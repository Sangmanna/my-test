package com.freightcom.clickship.service.service.integrations.shopify;

import static com.freightcom.clickship.model.util.ClickshipStringUtil.removeSpecialCharsAndAreaCode;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.freightcom.clickship.client.shopify.ShopifyRestClient;
import com.freightcom.clickship.data.entity.CustomerAddress;
import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.data.entity.MarketplaceProduct;
import com.freightcom.clickship.data.entity.Order;
import com.freightcom.clickship.data.entity.OrderShippingRule;
import com.freightcom.clickship.data.entity.Orderline;
import com.freightcom.clickship.data.entity.common.ClickShipOrderStatus;
import com.freightcom.clickship.data.entity.common.OrderRelationship;
import com.freightcom.clickship.data.rep.CustomerAddressRepository;
import com.freightcom.clickship.data.rep.MarketplaceProductRepository;
import com.freightcom.clickship.data.rep.OrderRepository;
import com.freightcom.clickship.data.rep.OrderShippingRuleRepository;
import com.freightcom.clickship.data.rep.OrderlineRepository;
import com.freightcom.clickship.data.util.EncryptionHelper;
import com.freightcom.clickship.model.exception.marketplace.MarketplaceWebhookFailureException;
import com.freightcom.clickship.model.marketplace.MarketplaceDTO;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyFulfillmentOrder;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyOrderLineItem;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyProduct;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyVariant;
import com.freightcom.clickship.model.shippingrules.AdvShippingRuleType;
import com.freightcom.clickship.model.util.ClickshipStringUtil;

@Service
public class ShopifyLocationSplitService {
	
	private Logger logger = LogManager.getLogger(ShopifyLocationSplitService.class);
	
	@Autowired
	private ShopifyRestClient client;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private EncryptionHelper encryptionHelper;

	@Autowired
	private ShopifyTransformer shopifyTransformer;
	
	@Autowired
	private OrderlineRepository orderlineRepository;
	
	@Autowired
	private CustomerAddressRepository custmoerAddressRepository;
	
	@Autowired
	private MarketplaceProductRepository marketplaceProductRepository;
	
	@Autowired
	private OrderShippingRuleRepository orderShippingRuleRepository;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void cancelLocationSplitOrder(Marketplace marketplace,  ShopifyFulfillmentOrder fulfillmentOrder) {
		Order parentOrder = orderRepository.findByMarketplaceAndExternalOrderId(marketplace, "" + fulfillmentOrder.getOrderId());
		
		if (parentOrder == null) {
			throw new MarketplaceWebhookFailureException("Parent Order not avaiable");
		}
		
		Order order = orderRepository.findByMarketplaceAndParentOrderAndExtFulfillmentOrderId(marketplace, parentOrder, "" + fulfillmentOrder.getId());
		
		if(isThisOrderCanBeModifiedInCs(order)) {
			order.setStatus(ClickShipOrderStatus.Cancelled);
			orderRepository.save(order);			
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveShopifyLocationSplitOrder(Marketplace marketplace,  ShopifyFulfillmentOrder fulfillmentOrder, boolean isManualSplit) {
		logger.log(Level.INFO, () -> "Saving Location split order - " + fulfillmentOrder.getId());
		
		Order parentOrder = orderRepository.findByMarketplaceAndExternalOrderId(marketplace, "" + fulfillmentOrder.getOrderId());
		
		if (parentOrder == null) {
			throw new MarketplaceWebhookFailureException("Parent Order not avaiable");
		}
		
		if (parentOrder.getShipment() != null) {
			return;
		}
		
		// If RTR Shipping rules exists for an order, then don't split it. CP-1054
		// When order comes for the first time, don't split it, and subsequent updates too shall not split the order.
		// But User can split it manually from UI, after that fulfillment orders shall be in sync with Shopify
		if(!isManualSplit && parentOrder.getOrderRelType() == null) {
			List<OrderShippingRule> orderShippingRules = orderShippingRuleRepository.findByOrderAndAdvancedShippingRuleType(parentOrder.getId(), AdvShippingRuleType.REAL_TIME_RATE_RULE.toString(), true);
			if(orderShippingRules != null && !orderShippingRules.isEmpty()) {
				logger.log(Level.INFO, () -> "Location split order skipped as RTR Shipping Rule exists- " + fulfillmentOrder.getId());
				return;
			}
		}
		
		
		Order order = orderRepository.findByMarketplaceAndParentOrderAndExtFulfillmentOrderId(marketplace, parentOrder, "" + fulfillmentOrder.getId());
		
		if (order == null) {
			parentOrder.setOrderRelType(OrderRelationship.FULFILLMENT_ORDER_PARENT.getType());
			orderRepository.save(parentOrder);

			order = createBaseOrder(marketplace, parentOrder);
		}
		
		if (isThisOrderCanBeModifiedInCs(order)) {
			setOrderGerneralInfo(order, parentOrder, fulfillmentOrder);
			setOrderCostInfo(order, parentOrder);
			setOrderStatusInfo(order, fulfillmentOrder);
			setOrderShiptoInfo(order, parentOrder);
			setOrderBilltoInfo(order, parentOrder);
			
			if (StringUtils.isEmpty(order.getId())) {
				encryptionHelper.encryptOrder(order);
			}
	
			order = orderRepository.save(order);
			
			deleteLineItems(order, fulfillmentOrder);
			order = orderRepository.save(order);
			
			order.setOrderlines(getLineItems(order, fulfillmentOrder));
			
			orderRepository.save(order);
		}
	}
	
	@Transactional
	public List<Orderline> getLineItems(Order order, ShopifyFulfillmentOrder sfo) {
		List<Orderline> items = new ArrayList<>();
		
		int i=0;
		for (ShopifyOrderLineItem sl : sfo.getOrderLines()) {
			Marketplace marketplace = order.getMarketplace();

			// Save OrderLine only if SHOPIFY says product exist. If SHOPIFY says product does't exist means product source is from external system. 
			if (sl.getVariantId() > 0) {
				Orderline obj = orderlineRepository.findByExternalLineIdAndOrder(sl.getLineItemId().toString(), order);

				if (obj == null) {
					obj = new Orderline().setOrder(order).setExternalLineId("" + sl.getLineItemId()).setLineNumber(++i);
				}

				setProductInfo(marketplace, obj, sl);

				obj.setQuantity(sl.getFulfillableQuantity()).setLineSubtotal(obj.getUnitPrice() * obj.getQuantity());

				items.add(obj);
			}
		}
		
		return items;
	}
	
	@Transactional
	public void deleteLineItems(Order order, ShopifyFulfillmentOrder sfo) {
		if (CollectionUtils.isNotEmpty(order.getOrderlines())) {
			Map<String, ShopifyOrderLineItem> map = new HashMap<>();
			sfo.getOrderLines().stream().forEach(o -> map.put("" + o.getLineItemId(), o));

			for (Orderline ol : order.getOrderlines()) {
				if (!map.containsKey(ol.getExternalLineId())) {
					ol.setQuantity(0);
				}
			}
		}
	}
	
	@Transactional
	public void deleteLineItems(Order order) {
		if (CollectionUtils.isNotEmpty(order.getOrderlines())) {
			orderlineRepository.deleteAll(order.getOrderlines());
		}
	}
	
	@Transactional
	public void setProductInfo(Marketplace marketplace, Orderline orderLine, ShopifyOrderLineItem lineItem) {
		String variantId = "" + lineItem.getVariantId();
		ShopifyVariant shopifyVariant = client.getVariant(getMarketplaceDto(marketplace), variantId);
			
		MarketplaceProduct csProduct = marketplaceProductRepository.findByMarketplaceAndExternalProductIdAndVariantId(marketplace, shopifyVariant.getProductId(), variantId);

		// If SHOPIFY says product exists but CS does not have product/variant means product might not imported into CS due WEBHOOKS failure.
		// Call SHOPIFY and create variant before save the order.
		if (csProduct == null) {
			try {
				MarketplaceDTO dto = getMarketplaceDto(marketplace);

				sleep(true); // Since get variant call made. Made import product after 1sec to avoid too many calls error
				ShopifyProduct shopifyProduct = client.importProduct(dto, "" + shopifyVariant.getProductId());

				if (shopifyProduct != null) {
					// Product/variant doesn't imported. Import first before save order.
					shopifyTransformer.updateProduct(marketplace, shopifyProduct);
				}
			} catch (Exception e) {
				logger.debug("Exception while importing shopify:[{}] missing product:[{}]", marketplace.getId(), "" + shopifyVariant.getProductId());
			}

			csProduct = marketplaceProductRepository.findByMarketplaceAndExternalProductIdAndVariantId(marketplace, shopifyVariant.getProductId(), variantId);
		}
			
		if (csProduct != null) {
			orderLine.setMarketplaceProduct(csProduct).setTitle(csProduct.getTitle()).setHsCode(csProduct.getHsCode())
					.setUnitPrice(shopifyVariant.getPrice()).setSku(shopifyVariant.getSku());
		} 
	}

	private Order createBaseOrder(Marketplace marketplace, Order parentOrder) {
		List<Order> list = orderRepository.findAllByParentOrder(parentOrder);
		
		Order order = new Order();
		
		order.setMarketplace(marketplace)
			.setParentOrder(parentOrder)
			.setCustomer(marketplace.getCustomer())
			.setShipfromEmail(marketplace.getCustomer().getEmail())
			.setShipfromContact(marketplace.getCustomer().getContactName())
			.setShipfromCompany(marketplace.getCustomer().getBusinessName())
			.setShipfromPhone(removeSpecialCharsAndAreaCode(marketplace.getCustomer().getPhone()));
		
		order.setOrderRelType(OrderRelationship.FULFILLMENT_ORDER.getType());
		
		if (parentOrder.getOrderlines() != null && parentOrder.getOrderlines().size() > 1) {
			order.setOrderNumber(String.format("%s-%s", list.size() + 1, parentOrder.getOrderNumber()));
		} else {
			order.setOrderNumber(parentOrder.getOrderNumber());
		}
		
		return order;
	}
	
	private void setOrderGerneralInfo(Order order, Order parentOrder, ShopifyFulfillmentOrder fulfillmentOrder) {
		CustomerAddress address = custmoerAddressRepository.findByCustomerAndExternalId(order.getCustomer(), fulfillmentOrder.getAssignedLocationId());
		
		if (address != null) {
			order.setCsAddressId(address.getId());
			order.setServiceType(address.getAddressName());
		}
		
		order.setNote(parentOrder.getNote()).setOrderDate(parentOrder.getOrderDate()).setExternalLocationId("" + fulfillmentOrder.getAssignedLocationId())
				.setExtFulfillmentOrderId("" + fulfillmentOrder.getId());
	}
	
	private void setOrderCostInfo(Order order, Order parentOrder) {
		order.setTaxes(parentOrder.getTaxes()).setTotal(parentOrder.getTotal())
			.setSubtotal(parentOrder.getSubtotal()).setCostCurrency(parentOrder.getCostCurrency())
			.setOriginalTotal(parentOrder.getOriginalTotal()).setTotalDiscounts(parentOrder.getTotalDiscounts());
	}
	
	private void setOrderStatusInfo(Order order, ShopifyFulfillmentOrder fulfillmentOrder) {
		String fulfillmentOrderStatus = fulfillmentOrder.getStatus();
		order.setExtFulfillmentStatus(fulfillmentOrderStatus);

		if (StringUtils.equalsAnyIgnoreCase(fulfillmentOrderStatus, "open", "in_progress", "scheduled")) {
			order.setStatus(ClickShipOrderStatus.UnFulfilled);
		} else if (StringUtils.equalsAnyIgnoreCase(fulfillmentOrderStatus, "cancelled", "incomplete") || CollectionUtils.isEmpty(fulfillmentOrder.getOrderLines())) {
			order.setStatus(ClickShipOrderStatus.Cancelled);
		} else if (StringUtils.equalsAnyIgnoreCase(fulfillmentOrderStatus, "on_hold")) {
			order.setStatus(ClickShipOrderStatus.Pending);
		} else if (StringUtils.equalsAnyIgnoreCase(fulfillmentOrderStatus, "closed")) {
			// SHOPIFY sends the "Closed status for both fulfilled and refunded items.
			// If all order line items quantity is zero means its cancelled/refunded order."
			boolean isReallyFulfilled = fulfillmentOrder.getOrderLines().stream().anyMatch(ol -> ol.getQuantity() > 0);
			
			if(isReallyFulfilled) {
				order.setStatus(ClickShipOrderStatus.ExternallyFulfilled);
				order.setExternallyFulfilledDate(new Date());				
			} else {
				order.setStatus(ClickShipOrderStatus.Cancelled);	
			}
		} else {
			order.setStatus(ClickShipOrderStatus.Pending);
		}
		
		if (fulfillmentOrder.getDeliveryMethod() != null && !StringUtils.equalsAnyIgnoreCase(fulfillmentOrderStatus, "closed", "cancelled", "incomplete")) {
			saveFulfilmentOrderTypeDetails(order, fulfillmentOrder);
		}
	}
	
	private void setOrderShiptoInfo(Order order, Order parentOrder) {
		order.setShiptoAddress1(parentOrder.getShiptoAddress1())
				.setShiptoAddress2(parentOrder.getShiptoAddress2())
				.setShiptoCompany(parentOrder.getShiptoCompany())
				.setShiptoCity(parentOrder.getShiptoCity())
				.setShiptoCountry(parentOrder.getShiptoCountry())
				.setShiptoEmail(parentOrder.getShiptoEmail())
				.setShiptoContact(parentOrder.getShiptoContact())
				.setShiptoPhone(ClickshipStringUtil.removeSpecialCharsAndAreaCode(parentOrder.getShiptoPhone()))
				.setShiptoProvinceState(parentOrder.getShiptoProvinceState())
				.setShiptoZip(parentOrder.getShiptoZip());
			
		if (StringUtils.isEmpty(order.getShiptoCompany())) {
			order.setShiptoCompany(order.getShiptoContact());
		}

		if (StringUtils.isEmpty(order.getShiptoContact())) {
			order.setShiptoContact(order.getShiptoCompany());
		}
	}
	
	private void setOrderBilltoInfo(Order order, Order billingAddress) {
		order.setBilltoAddress1(billingAddress.getBilltoAddress1())
			.setBilltoAddress2(billingAddress.getBilltoAddress2())
			.setBilltoContact(billingAddress.getBilltoContact())
			.setBilltoCity(billingAddress.getBilltoCity())
			.setBilltoCountry(billingAddress.getBilltoCountry())
			.setBilltoEmail(billingAddress.getBilltoEmail())
			.setBilltoPhone(ClickshipStringUtil.removeSpecialCharsAndAreaCode(billingAddress.getBilltoPhone()))
			.setBilltoProvinceState(billingAddress.getBilltoProvinceState())
			.setBilltoPostalcode(billingAddress.getBilltoPostalcode());
	}
	
	private void saveFulfilmentOrderTypeDetails(Order order, ShopifyFulfillmentOrder fulfillmentOrder) {
		String fulfillmentOrderStatus = fulfillmentOrder.getStatus();
		
		if (fulfillmentOrder.getDeliveryMethod() != null) {
			order.setExtFulfillmentOrderType(fulfillmentOrder.getDeliveryMethod().getMethodType());
			
			if (StringUtils.equalsAnyIgnoreCase(fulfillmentOrderStatus, "on_hold")) {
				order.setServiceType("On-Hold");
			} else if (StringUtils.equalsAnyIgnoreCase(fulfillmentOrder.getDeliveryMethod().getMethodType(), "none")) {
				order.setServiceType("No Shipping Required");
				order.setStatus(ClickShipOrderStatus.Pending);
			} else if (StringUtils.equalsAnyIgnoreCase(fulfillmentOrder.getDeliveryMethod().getMethodType(), "pick-up")) {
				order.setServiceType("Pickup Order");
				order.setStatus(ClickShipOrderStatus.Pending);
			} else if (StringUtils.equalsAnyIgnoreCase(fulfillmentOrder.getDeliveryMethod().getMethodType(), "retail")) {
				order.setServiceType("Retail Order");
				order.setStatus(ClickShipOrderStatus.Pending);
			}
		} else {
			order.setServiceType("No Shipping Required");
			order.setStatus(ClickShipOrderStatus.Pending);
		}
	}
	
	private MarketplaceDTO getMarketplaceDto(Marketplace marketplace) {
		return shopifyTransformer.getMarketplaceDto(marketplace); 
	}
	
	/**
	 * 
	 * SHOPIFTY has a rate limit make only two calls per second. 
	 * 
	 */
	private void sleep(boolean sleep) {
		if (sleep) {
			try {
				Thread.sleep(1000);	
			} catch (Exception e) {
				logger.error("Exception while sleeping", e);
				Thread.currentThread().interrupt();
			}
		}
	}
	
	private boolean isThisOrderCanBeModifiedInCs(Order order) {
		return !StringUtils.equalsAny(order.getStatus(), ClickShipOrderStatus.Fulfilled.getValue());
	}

}
