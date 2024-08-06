package com.freightcom.clickship.service.service.integrations.shopify;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freightcom.clickship.client.shopify.ShopifyRestClient;
import com.freightcom.clickship.data.entity.CustomerAddress;
import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.data.entity.MarketplaceSetting;
import com.freightcom.clickship.data.entity.Order;
import com.freightcom.clickship.data.entity.User;
import com.freightcom.clickship.data.entity.common.OrderRelationship;
import com.freightcom.clickship.model.exception.http.ClickshipHttpRestException;
import com.freightcom.clickship.model.exception.marketplace.LocationMoveException;
import com.freightcom.clickship.model.exception.marketplace.LocationSplitException;
import com.freightcom.clickship.model.exception.marketplace.MarketplaceRuntimeException;
import com.freightcom.clickship.model.marketplace.MarketplaceDTO;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyFulfillmentOrder;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyFulfillmentOrderWebhook;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyPaginationResponse;
import com.freightcom.clickship.model.order.MoveLocationOrderDTO;
import com.freightcom.clickship.service.service.CustomerAddressService;
import com.freightcom.clickship.service.service.MarketplaceService;
import com.freightcom.clickship.service.service.MarketplaceSettingService;
import com.freightcom.clickship.service.service.OrderDataService;
import com.freightcom.clickship.service.service.integrations.AbstractLocationSplitOrderService;
import com.freightcom.clickship.service.util.JsonTransformer;

@Service("ShopifyLocationSplitOrderService")
public class ShopifyLocationSplitOrderService extends AbstractLocationSplitOrderService {

	private Logger logger = LogManager.getLogger(this.getClass());

	@Autowired
	private ShopifyRestClient client;
	
	@Autowired
	private JsonTransformer jsonTransformer;
	
	@Autowired
	private OrderDataService orderDataService;

	@Autowired
	private MarketplaceService marketplaceService;
	
	@Autowired
	private CustomerAddressService customerAddressService;
	
	@Autowired
	private MarketplaceSettingService marketplaceSettingService;
	
	@Autowired
	private ShopifyLocationSplitService shopifyLocationSplitService;
	
	@Override
	public void moveOrderToNewLocation(Marketplace marketplace, MoveLocationOrderDTO dto) {
		Order order = orderDataService.findByOrderById(dto.getOrderId());
		
		if(StringUtils.isBlank(order.getExtFulfillmentOrderId())) {
			throw new LocationMoveException("This feature is enabled only for location split orders.");
		}
		
		CustomerAddress address = customerAddressService.getAddress(dto.getNewLocationId());
		MarketplaceDTO marketplaceDTO = marketplaceService.getMarketplaceDto(marketplace);
		
		try {
			ShopifyFulfillmentOrderWebhook obj = new ShopifyFulfillmentOrderWebhook();
			obj.setNewLocationId(address.getExternalId());
			/**		obj.setFulfillmentOrderLines(getShopifyOrderLineItem(order));*/
		
			ShopifyFulfillmentOrderWebhook sfo = new ShopifyFulfillmentOrderWebhook();
			sfo.setFulfillmentOrder(obj);
		
			logger.log(Level.INFO, () -> "Move fulfillment order location request - " + jsonTransformer.toJson(sfo));
			
			client.moveFulfillmentOrder(marketplaceDTO, sfo, order.getExtFulfillmentOrderId());
		} catch(ClickshipHttpRestException e) {
			ShopifyPaginationResponse response = jsonTransformer.fromJson(e.getResponseBodyAsString(), ShopifyPaginationResponse.class);
			throw new LocationMoveException(StringUtils.join(response.getErrors(), ", "));
		}
	}

	@Override
	public void processLocationSplitUiRequest(Marketplace marketplace, String orderId, User user) {
		Order order = orderDataService.findByOrderById(orderId);

		checkAccess(user, order);
		
		validateSplitLocationUiRequest(order);
		
		try {
			List<ShopifyFulfillmentOrder> list = getFulfillmentOrders(marketplace, order.getExternalOrderId(), false);
			
			for(ShopifyFulfillmentOrder fulfillmentOrder : list) {
				shopifyLocationSplitService.saveShopifyLocationSplitOrder(marketplace, fulfillmentOrder, true);
			}
		} catch(ClickshipHttpRestException e) {
			ShopifyPaginationResponse response = jsonTransformer.fromJson(e.getResponseBodyAsString(), ShopifyPaginationResponse.class);
			throw new LocationSplitException(StringUtils.join(response.getErrors(), ", "));
		} 
	}

	@Override
	public void processOrderUpdateRequest(Marketplace marketplace, String externalOrderId) {
		boolean checkForFulfillmentOrderUpdates = false;
		MarketplaceSetting setting = marketplaceSettingService.getMarketplaceSettingByMarketplace(marketplace);
		
		if(setting != null && setting.isLocationSplit()) {
			checkForFulfillmentOrderUpdates = true;
			logger.info("Location split is enabled for [{}] order update webhook request for fulfillment order - {} ",
					marketplace.getStoreUrl(), externalOrderId);
		}
		
		Order order = orderDataService.getByMarketplaceAndExternalOrderId(marketplace, externalOrderId);
				
		if (order != null) {
			List<Order> list = orderDataService.getByParentOrder(order);

			if (CollectionUtils.isNotEmpty(list)) {
				checkForFulfillmentOrderUpdates = list.stream().anyMatch(OrderRelationship::isFulfillmentOrder);
				
				if(checkForFulfillmentOrderUpdates) {
					logger.info("Found existing location split order for [{}] order - {} ",
							marketplace.getStoreUrl(), externalOrderId);
				}
			}
		}
		
		if(checkForFulfillmentOrderUpdates) {
			logger.info("Processing [{}] order update webhook request for fulfillment orders - {}",  marketplace.getStoreUrl(), externalOrderId);
			List<ShopifyFulfillmentOrder> list = getFulfillmentOrders(marketplace, externalOrderId, false);
			
			if (CollectionUtils.isNotEmpty(list)) {
				for(ShopifyFulfillmentOrder fulfillmentOrder : list) {
					shopifyLocationSplitService.saveShopifyLocationSplitOrder(marketplace, fulfillmentOrder, false);
				}				
			}
		}
	}

	@Override
	public void processLocationSplitWebhookRequest(Marketplace marketplace, Map<String, Object> map) {
		String data = (String) map.get("json");
		String type = (String) map.get("type");
		String action = (String) map.get("action");
		
		logger.info("Processing [{}] {} {} webhook request - {}", marketplace.getStoreUrl(), type, action, data);

		switch (action) {
			case "moved":
				processMovedRequest(marketplace, data);
				break;
			
			case "cancelled":
				processCancelledRequest(marketplace, data);
				break;
			
			case "order_routing_complete":
				processOrderRoutingCompleteRequest(marketplace, data);
				break;

			case "split":
				processSplitRequest(marketplace, data);
				break;
				
			case "merged":
				processMergeRequest(marketplace, data);
				break;

			case "rescheduled":
			case "hold_released":
			case "placed_on_hold":
			case "fulfillment_request_accepted":
			case "fulfillment_request_rejected":
			case "fulfillment_request_submitted":
			case "cancellation_request_accepted":
			case "cancellation_request_rejected":
			case "cancellation_request_submitted":				
			case "line_items_prepared_for_pickup":
			case "scheduled_fulfillment_order_ready":
			case "line_items_prepared_for_local_delivery":
			case "fulfillment_service_failed_to_complete":
				handleFulfilmentOrderWebhookRequest(marketplace, data);
				break;

			default:
				logger.info("[{}] - Invalid {} {} webhook request - {}", marketplace.getStoreUrl(), type, action, data);
		}
	}
	
	private void processOrderRoutingCompleteRequest(Marketplace marketplace, String data) {
		handleFulfilmentOrderWebhookRequest(marketplace, data);
	}

	private void processMovedRequest(Marketplace marketplace, String data) {
		ShopifyFulfillmentOrderWebhook sfo = jsonToObject(data, ShopifyFulfillmentOrderWebhook.class);
		String id = getFulfillmentOrderId(sfo.getOriginalFulfillmentOrder().getId());

		ShopifyFulfillmentOrder fulfillmentOrder = getFulfillmentOrder(marketplace, id, false);
		List<ShopifyFulfillmentOrder> list = getFulfillmentOrders(marketplace, "" + fulfillmentOrder.getOrderId(), true);
		
		for (ShopifyFulfillmentOrder obj : list) {
			shopifyLocationSplitService.saveShopifyLocationSplitOrder(marketplace, obj, false);
		}
	}

	private void processCancelledRequest(Marketplace marketplace, String data) {
		ShopifyFulfillmentOrderWebhook sfo = jsonToObject(data, ShopifyFulfillmentOrderWebhook.class);
		String id = getFulfillmentOrderId(sfo.getFulfillmentOrder().getId());

		ShopifyFulfillmentOrder fulfillmentOrder = getFulfillmentOrder(marketplace, id, false);
		shopifyLocationSplitService.cancelLocationSplitOrder(marketplace, fulfillmentOrder);
		
		String replacementOrderId = getFulfillmentOrderId(sfo.getFulfillmentOrderReplacement().getId());
		
		fulfillmentOrder = getFulfillmentOrder(marketplace, replacementOrderId, true);
		shopifyLocationSplitService.saveShopifyLocationSplitOrder(marketplace, fulfillmentOrder, false);
	}

	private void handleFulfilmentOrderWebhookRequest(Marketplace marketplace, String data) {
		ShopifyFulfillmentOrderWebhook sfo = jsonToObject(data, ShopifyFulfillmentOrderWebhook.class);
		String id = getFulfillmentOrderId(sfo.getFulfillmentOrder().getId());
		
		ShopifyFulfillmentOrder fulfillmentOrder = getFulfillmentOrder(marketplace, id, false);
		shopifyLocationSplitService.saveShopifyLocationSplitOrder(marketplace, fulfillmentOrder, false);
	}
	
	private void processSplitRequest(Marketplace marketplace, String data) {
		ShopifyFulfillmentOrderWebhook sfo = jsonToObject(data, ShopifyFulfillmentOrderWebhook.class);
		
		String id = getFulfillmentOrderId(sfo.getFulfillmentOrder().getId());
		ShopifyFulfillmentOrder fulfillmentOrder = getFulfillmentOrder(marketplace, id, false);
		shopifyLocationSplitService.saveShopifyLocationSplitOrder(marketplace, fulfillmentOrder, false);
			
		if (sfo.getRemainingFulfillmentOrder() != null) {
			String remainingFulfillmentOrderid = getFulfillmentOrderId(sfo.getRemainingFulfillmentOrder().getId());

			ShopifyFulfillmentOrder remainingFulfillmentOrder = getFulfillmentOrder(marketplace, remainingFulfillmentOrderid, true);
			shopifyLocationSplitService.saveShopifyLocationSplitOrder(marketplace, remainingFulfillmentOrder, false);
		}
	
		if (sfo.getFulfillmentOrderReplacement() != null) {
			String replacementFulfillmentOrderid = getFulfillmentOrderId(sfo.getFulfillmentOrderReplacement().getId());

			ShopifyFulfillmentOrder replacementFulfillmentOrder = getFulfillmentOrder(marketplace, replacementFulfillmentOrderid, true);
			shopifyLocationSplitService.saveShopifyLocationSplitOrder(marketplace, replacementFulfillmentOrder, false);
		}
	}

	private void processMergeRequest(Marketplace marketplace, String data) {
		ShopifyFulfillmentOrderWebhook sfo = jsonToObject(data, ShopifyFulfillmentOrderWebhook.class);
		
		if (CollectionUtils.isNotEmpty(sfo.getMergeIntents())) {
			for (ShopifyFulfillmentOrderWebhook mergeIndent : sfo.getMergeIntents()) {
				ShopifyFulfillmentOrder mergedFulfillmentOrder = getFulfillmentOrder(marketplace, mergeIndent.getFulfillmentOrderId(), true);
				shopifyLocationSplitService.saveShopifyLocationSplitOrder(marketplace, mergedFulfillmentOrder, false);
			}
		}
	}
	
	private ShopifyFulfillmentOrder getFulfillmentOrder(Marketplace marketplace, String id, boolean sleep) {
		sleep(sleep);
		return client.getFulfillmentOrderById(getMarketplaceDto(marketplace), id);
	}
	
	private List<ShopifyFulfillmentOrder> getFulfillmentOrders(Marketplace marketplace, String shopifyOrderId, boolean sleep) {
		sleep(sleep);
		return client.getFulfillmentOrders(getMarketplaceDto(marketplace), shopifyOrderId);
	}

	private <R> R jsonToObject(String jsonData, Class<R> clazz) {
		try {
			return jsonTransformer.fromJson(jsonData, clazz);
		} catch (Exception e) {
			throw new MarketplaceRuntimeException("Error while json to object tranformation ", e);
		}
	}

	private MarketplaceDTO getMarketplaceDto(Marketplace marketplace) {
		return marketplaceService.getMarketplaceDto(marketplace);
	}
	
	private String getFulfillmentOrderId(String id) {
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(id);

		if (matcher.find()) {
			return matcher.group(0);
		}

		throw new MarketplaceRuntimeException("Invalid fulfillment orderId: " + id);
	}
	
	private void validateSplitLocationUiRequest(Order order) {
		if(CollectionUtils.isEmpty(order.getOrderlines()) || order.getOrderlines().size() ==1) {
			throw new LocationSplitException("Selected order(s) contains only single unit, which cannot be split. Please choose orders containing multiple units.");
		}
		
		if(OrderRelationship.isSplittedChild(order)) {
			throw new LocationSplitException("Selected order is ClickShip split order which cannot be split again. Please choose regular order.");
		}
		
		if(OrderRelationship.isCombinedParent(order)) {
			throw new LocationSplitException("Selected order is ClickShip combined order which cannot be split. Please choose regular order.");
		}
		
		if(OrderRelationship.isFulfillmentOrder(order)) {
			throw new LocationSplitException("Selected order is already splited. Please choose regular order.");
		}
	}

	/**
	 * 
	 * SHOPIFTY has a rate limit make only two calls per second. 
	 * 
	 */
	private void sleep(boolean sleep) {
		if(sleep) {
			try {
				Thread.sleep(1000);	
			} catch (Exception e) {
				logger.error("Exception while sleeping", e);
				Thread.currentThread().interrupt();
			}
		}
	}
}
