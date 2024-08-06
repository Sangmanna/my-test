package com.freightcom.clickship.service.service.integrations.shopify;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.freightcom.clickship.client.shopify.ShopifyRestClient;
import com.freightcom.clickship.data.entity.CarrierAccount;
import com.freightcom.clickship.data.entity.Code;
import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.CustomerPreferences;
import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.data.entity.MarketplaceProduct;
import com.freightcom.clickship.data.entity.Order;
import com.freightcom.clickship.data.entity.ShopifySubscription;
import com.freightcom.clickship.data.entity.common.ClickShipOrderStatus;
import com.freightcom.clickship.data.entity.common.OrderRelationship;
import com.freightcom.clickship.data.rep.CarrierAccountRepository;
import com.freightcom.clickship.data.rep.CustomerPreferencesRepository;
import com.freightcom.clickship.data.rep.CustomerRepository;
import com.freightcom.clickship.data.rep.MarketplaceProductRepository;
import com.freightcom.clickship.data.rep.OrderRepository;
import com.freightcom.clickship.data.rep.ShopifySubscriptionRepository;
import com.freightcom.clickship.data.util.EncryptionHelper;
import com.freightcom.clickship.model.enums.ChargebeeAddons;
import com.freightcom.clickship.model.marketplace.MarketplaceDTO;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyCarrierService;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyEndpoint;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyOrder;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyProduct;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyVariant;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyWebhook;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyWebhook_;
import com.freightcom.clickship.service.service.CodeService;
import com.freightcom.clickship.service.service.CustomerPreferencesService;
import com.freightcom.clickship.service.service.OrderDataService;

@Service
public class ShopifyService {
	
	private Logger logger = LogManager.getLogger(ShopifyService.class);
	
	@Value("${application.name}")
	private String applicationName;

	@Value("${clickship.ssl.domain}")
	private String clickshipSslDomain;
	
	@Value("${webhooks.application.name:webhooks}")
	protected String webhooksApplicationName;
	
	@Autowired
	private CodeService codeService;
	
	@Autowired
	private ShopifyRestClient client;
	
	@Autowired
	private OrderDataService orderService;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private EncryptionHelper encryptionHelper;
	
	@Autowired
	private ShopifyTransformer shopifyTransformer;
	
	@Autowired
	private MarketplaceProductRepository marketplaceProductRepository;
	
	@Autowired
	private CustomerPreferencesRepository customerPreferencesRepository;
	
	private CustomerRepository customerRepository;
	
	private CarrierAccountRepository carrierAccountRepository;
	
	private CustomerPreferencesService customerPreferencesService;
	
	private ShopifySubscriptionRepository shopifySubscriptionRepository;
	
	@Autowired	
	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Autowired
	public void setCarrierAccountRepository(CarrierAccountRepository carrierAccountRepository) {
		this.carrierAccountRepository = carrierAccountRepository;
	}

	@Autowired
	public void setShopifySubscriptionRepository(ShopifySubscriptionRepository shopifySubscriptionRepository) {
		this.shopifySubscriptionRepository = shopifySubscriptionRepository;
	}
	
	@Autowired
	public void setCustomerPreferencesService(CustomerPreferencesService customerPreferencesService) {
		this.customerPreferencesService = customerPreferencesService;
	}

	@Transactional
	public void cancelOrder(Marketplace marketplace, Order order) throws Exception {
		if(OrderRelationship.isSplittedParent(order)) {
			orderService.cancelSplitAndCancelOrderInCs(order);
		} else if(OrderRelationship.isCombinedChild(order)) {
			orderService.cancelCombineAndCancelOrderInCs(order);
		} else if(OrderRelationship.isFulfillmentOrderParent(order)) {
			order.setStatus(ClickShipOrderStatus.Cancelled);
			orderRepository.save(order);
			
			List<Order> list = orderService.getByParentOrder(order);
			list.stream().forEach(o -> o.setStatus(ClickShipOrderStatus.Cancelled));
			orderRepository.saveAll(list);
		} else if(StringUtils.equals(order.getStatus(), ClickShipOrderStatus.UnFulfilled.getValue())) {
			order.setStatus(ClickShipOrderStatus.Cancelled);
			orderRepository.save(order);
		} else {
			logger.info("Cannot cancel the order since order:{} is already fulfilled.", order.getId());
		}
	}
	
	@Transactional
	public void deleteOrder(Marketplace marketplace, Order order) throws Exception {
		// In SHOPIFY delete order option will be enabled for archived fulfilled and cancelled state orders. But in CS we need to delete
		// the FULFILLED orders with LABELS from file system with separate job. 
		// So ignore the delete order event if the order is in fulfilled state in CS.
		boolean orderCanBeDeleteInCs = false;
		
		if(OrderRelationship.isSplittedParent(order)) {
			List<Order> list = orderRepository.findAllByParentOrder(order);
			orderCanBeDeleteInCs = list.stream().noneMatch(o -> StringUtils.equals(o.getStatus(), ClickShipOrderStatus.Fulfilled.getValue()));
			
			if(orderCanBeDeleteInCs) {
				orderService.cancelSplit(order.getId());
			}
		} else if(OrderRelationship.isCombinedChild(order)) {
			orderCanBeDeleteInCs  = !StringUtils.equals(order.getStatus(), ClickShipOrderStatus.Fulfilled.getValue()) 
					|| !StringUtils.equals(order.getParentOrder().getStatus(), ClickShipOrderStatus.Fulfilled.getValue());
			
			if(orderCanBeDeleteInCs) {
				orderService.cancelOrderCombination(order.getParentOrder().getId());
			}
		} else {
			orderCanBeDeleteInCs  = !StringUtils.equals(order.getStatus(), ClickShipOrderStatus.Fulfilled.getValue());
		}
		
		if(orderCanBeDeleteInCs) {
			orderRepository.delete(order);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void saveProduct(Marketplace marketplace, ShopifyProduct shopifyProduct) {
		for (ShopifyVariant variant : shopifyProduct.getVariants()) {
			MarketplaceProduct csProduct = shopifyTransformer.getShopifyVariant(marketplace, shopifyProduct, variant);
			marketplaceProductRepository.save(csProduct);
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Order saveOrder(Marketplace marketplace, ShopifyOrder shopifyOrder) {
		Order order = shopifyTransformer.getCsOrder(marketplace, shopifyOrder);

		if (StringUtils.isEmpty(order.getId())) {
			encryptionHelper.encryptOrder(order);
		}
		orderRepository.save(order);
		order.setDiscounts(shopifyTransformer.getDiscountsFromShopifyOrder(shopifyOrder, order));
		order.setTaxList(shopifyTransformer.getTaxesFromShopifyOrder(shopifyOrder, order));
		order.setOrderlines(shopifyTransformer.getLineItems(shopifyOrder, order));

		orderRepository.save(order);

		return order;
	}
	
	@Transactional
	public void uninstallStore(Marketplace marketplace) {
		try {
			removePreviousInfoInShopify(marketplace);
			unsubscribeSubscritions(marketplace);
			client.uninstallStore(getMarketplaceDto(marketplace));
		} catch (Exception e) {
			logger.error("Failed to uninstall clickship on the shopify side", e);
		}
	}
	
	public void removePreviousInfoInShopify(Marketplace marketplace) {
		try {
			deleteWebhooks(marketplace);
			disableShopifyCarrierService(marketplace);
		} catch (Exception e) {
			logger.error("Failed to remove data on the shopify side", e);
		}
	}
	
	@Transactional
	public void unsubscribeSubscritions(Marketplace marketplace) {
		List<ShopifySubscription> list = shopifySubscriptionRepository.findByMarketplaceAndAddonTypeAndStatus(marketplace, "CLICKSHIP", "ACTIVE");
		
		list.stream().forEach(o -> {
			if (StringUtils.equalsAnyIgnoreCase(o.getStatus(), "ACTIVE")) {
				String addonId = o.getAddonId();
				ChargebeeAddons addOn = ChargebeeAddons.valueOf(addonId);

				CarrierAccount carrierAccount = null;
				String carrierName = getCarrierName(addOn);
				Customer customer = marketplace.getCustomer();

				if (StringUtils.isNotBlank(carrierName)) {
					carrierAccount = processDeleteMarketplaceReq(customer, carrierName);

					if (carrierAccount != null) {
						carrierAccountRepository.save(carrierAccount);
					}
				} else {
					processCancelNonCarrierAddonRequest(customer, addOn);
					customerRepository.save(customer);
				}
			}
			
			o.setStatus("CANCELLED");
		});
		
		CustomerPreferences preferences = customerPreferencesService.getCustomerPreferencesByCustomer(marketplace.getCustomer());
		preferences.setSubscriptionBillingChannel("ChargeBee");
		customerPreferencesService.save(preferences);
		
		shopifySubscriptionRepository.saveAll(list);
		
		List<ShopifySubscription> shopifySubscriptions = shopifySubscriptionRepository.findByMarketplaceAndAddonTypeAndStatus(marketplace, "SHOPIFY", "ACTIVE");
		shopifySubscriptions.stream().forEach(ss -> ss.setStatus("CANCELLED"));
		
		shopifySubscriptionRepository.saveAll(shopifySubscriptions);
	}
	
	public void registerWebhooks(Marketplace marketplace) {
		logger.info("Shopify[{}] store initial import - registering webhooks - id:[{}]", marketplace.getStoreUrl(), marketplace.getId());

		try {
			List<Code> topicList = codeService.getCodes("SHOPIFY_WEBHOOKS");

			for (Code topic : topicList) {
				String endpoint = String.format(ShopifyEndpoint.WEBHOOK_CALLBACK_URL.getValue(), clickshipSslDomain, webhooksApplicationName, marketplace.getId(), topic.getValue());
				ShopifyWebhook_ webhook = new ShopifyWebhook_(new ShopifyWebhook(endpoint, topic.getValue()));
				client.createWebhook(getMarketplaceDto(marketplace), webhook).getWebhook();
			}
			
			Customer customer = marketplace.getCustomer();
			CustomerPreferences preferences = customerPreferencesRepository.getCustomerPreferencesByCustomer(customer);
			
			if(StringUtils.equalsAnyIgnoreCase(preferences.getSubscriptionBillingChannel(), "Shopify")) {
				List<Code> subscriptionTopicList = codeService.getCodes("SHOPIFY_BILLING_WEBHOOKS");
				
				for (Code topic : subscriptionTopicList) {
					String endpoint = String.format(ShopifyEndpoint.WEBHOOK_CALLBACK_URL.getValue(), clickshipSslDomain, webhooksApplicationName, marketplace.getId(), topic.getValue());
					ShopifyWebhook_ webhook = new ShopifyWebhook_(new ShopifyWebhook(endpoint, topic.getValue()));
					client.createWebhook(getMarketplaceDto(marketplace), webhook).getWebhook();
				}
			}
		} catch (Exception e) {
			logger.info("Shopify[{}] store initial import - Error while registering webhooks - id:[{}]", marketplace.getStoreUrl(), marketplace.getId());
			throw e;
		}
	}
	
	public void deleteWebhooks(Marketplace marketplace) {
		try {
			List<ShopifyWebhook> webhookList = client.getWebhooks(getMarketplaceDto(marketplace));
			
			if (CollectionUtils.isNotEmpty(webhookList)) {
				for(ShopifyWebhook webhook : webhookList) {
					try {
						if(StringUtils.containsAny(webhook.getAddress(), marketplace.getId(), "webhooks/shopify")) {
							client.deleteWebhookById(getMarketplaceDto(marketplace), webhook.getId().toString());	
						}
					} catch (Exception e) {
						logger.error("Unable to delete the webhook in shopify - marketplace:{}, webhhok:{}, error:{}", 
								marketplace.getStoreUrl(), webhook.getTopic(), e.getMessage(), e);
					}
				}
			}
		} catch (Exception e) {
			logger.error("Error while deleting webhooks - marketplace:{} ", marketplace.getStoreUrl(), e);
		}
	}
	
	public void removeFulfilmentOrderWebhooks(Marketplace marketplace) {
		try {
			List<ShopifyWebhook> webhookList = client.getWebhooks(getMarketplaceDto(marketplace));
			
			if (CollectionUtils.isNotEmpty(webhookList)) {
				for(ShopifyWebhook webhook : webhookList) {
					try {
						logger.info("webhook {}", webhook.getAddress());
						
						if (StringUtils.contains(webhook.getAddress(), "fulfillment_orders") 
								&& StringUtils.contains(webhook.getAddress(), marketplace.getId())) {
							logger.info("Removing webhook {}", webhook.getAddress());
							client.deleteWebhookById(getMarketplaceDto(marketplace), webhook.getId().toString());
						}
					} catch (Exception e) {
						logger.error("Unable to delete {} {} webhook.", marketplace.getStoreUrl(), webhook.getTopic(), e);
					}
				}
			}
		} catch (Exception e) {
			logger.error("Error while deleting {} fulfillment_orders webhooks.", marketplace.getStoreUrl(), e);
		}
	}
	
	public void createFulfilmentOrderWebhooks(Marketplace marketplace) {
		logger.info("Registering {} fulfillment_orders webhooks", marketplace.getStoreUrl());

		try {
			List<ShopifyWebhook> webhookList = client.getWebhooks(getMarketplaceDto(marketplace));
			Map<String, ShopifyWebhook> map = webhookList.stream().collect(Collectors.toMap(ShopifyWebhook::getTopic, Function.identity()));
			
			List<Code> topicList = codeService.getCodes("SHOPIFY_FO_WEBHOOKS");

			for (Code topic : topicList) {
				if(!map.containsKey(topic.getValue())) {
					String endpoint = String.format(ShopifyEndpoint.WEBHOOK_CALLBACK_URL.getValue(), clickshipSslDomain, webhooksApplicationName, marketplace.getId(), topic.getValue());
					ShopifyWebhook_ webhook = new ShopifyWebhook_(new ShopifyWebhook(endpoint, topic.getValue()));
					client.createWebhook(getMarketplaceDto(marketplace), webhook).getWebhook();
				}
			}
		} catch (Exception e) {
			logger.info("Error while registering {} fulfillment_orders webhooks", marketplace.getStoreUrl());
		}
	}
	
	public void disableShopifyCarrierService(Marketplace marketplace) {
		try {
			ShopifyCarrierService carrierService = client.getClickshipCarrierService(getMarketplaceDto(marketplace));
			
			if(carrierService != null) {
				client.deleteClickshipCarrierService(getMarketplaceDto(marketplace), carrierService);
			}
		} catch (Exception e) {
			logger.error("Failed disableShopifyCarrierService", e);
		}
	}
	
	private String getCarrierName(ChargebeeAddons addon) {
		if (ChargebeeAddons.UPS_CARRIER_ADDON.equals(addon)) {
			return "UPS";
		} else if (ChargebeeAddons.CANPAR_CARRIER_ADDON.equals(addon)) {
			return "Canpar";
		} else if (ChargebeeAddons.CANADAPOST_CARRIER_ADDON.equals(addon)) {
			return "CanadaPost";
		} else if (ChargebeeAddons.MIDLAND_CARRIER_ADDON.equals(addon)) {
			return "Midland";
		}

		return null;
	}
	
	private CarrierAccount processDeleteMarketplaceReq(Customer customer, String carrier) {
		CarrierAccount carrierAccount = carrierAccountRepository.findByCustomerIdAndCarrierName(customer.getId(), carrier);

		if (carrierAccount == null) {
			return null;
		}

		carrierAccount.setOnHold(true);
		carrierAccount.setOnHoldMessage("Your primary Shopify marketplace is deleted. Please subscribe again.");
		
		carrierAccount.setActive(false);
		carrierAccount.setIsSubscribed(false);
		
		return carrierAccount;
	}
	
	private void processCancelNonCarrierAddonRequest(Customer customer, ChargebeeAddons addOn) {
//		String message = "One of your addons got hold due to your primary marketplace deletion. Please subscribe again.";
		if (ChargebeeAddons.CUSTOM_BRANDING.equals(addOn)) {
			customer.setHasCustomBranding(false);
		} else if (ChargebeeAddons.ADVANCED_SHIPPING_RULE.equals(addOn)) {
			customer.setAdvancedShippingRuleActive(false);
		} else if (ChargebeeAddons.ADVANCED_SHIPPING_RULE_PALLET.equals(addOn)) {
			customer.setAdvancedShippingRulePalletActive(false);
		}
	}

	private MarketplaceDTO getMarketplaceDto(Marketplace marketplace) {
		return shopifyTransformer.getMarketplaceDto(marketplace); 
	}
}
