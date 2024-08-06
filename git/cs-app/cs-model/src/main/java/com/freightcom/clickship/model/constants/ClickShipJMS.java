package com.freightcom.clickship.model.constants;

public class ClickShipJMS {
	
	private ClickShipJMS() {
		
	}
	
	public static final String MAIL_QUEUE = "user.validation.mail";
	public static final String SMTP_EMAIL_QUEUE = "smtp.email.queue";
	
	public static final String CHARGEBEE_WEBHOOKS = "chargebee.webhooks.queue";
	public static final String FREIGHTCOM_WEBHOOKS = "freightcom.webhooks.queue";
	
	// ORDERS / SHIPMENTS
	public static final String AUTO_FULFILL_ORDERS = "auto.fulfill.orders.queue";
	public static final String REFRESH_SHIPPING_RULES = "refresh.shipping.rules.queue";
	public static final String SHIPPING_RULE_RATES_QUEUE = "shippingrule.rates.queue";
	
	// SHOPIFY integration
	public static final String SHOPIFY_WEBHOOKS = "shopify.webhooks.queue";
	public static final String SHOPIFY_ORDER_WEBHOOKS = "shopify.order.webhooks.queue";
	public static final String SHOPIFY_WEBHOOKS_REVOKE = "shopify.webhooks.revoke.queue";
	public static final String SHOPIFY_WEBHOOKS_CREATE = "shopify.webhooks.create.queue";
	public static final String SHOPIFY_PRODUCT_WEBHOOKS = "shopify.product.webhooks.queue";
	public static final String SHOPIFY_ORDER_UPDATE_WEBHOOK = "shopify.order.update.queue";
	public static final String SHOPIFY_PROCESS_DELETE_VARIANTS = "shopify.process.delete.variants";
	public static final String SHOPIFY_FULFILMENT_ORDER_WEBHOOKS = "shopify.fulfilment.order.webhooks.queue";

	// WooCommerce integration
	public static final String WOOCOMMERCE_IMPORT_ORDERS = "woocommerce.import.orders.queue";
	public static final String WOOCOMMERCE_WEBHOOKS_REVOKE = "woocommerce.webhooks.revoke.queue";
	public static final String WOOCOMMERCE_WEBHOOKS_CREATE = "woocommerce.webhooks.create.queue";
	public static final String WOOCOMMERCE_IMPORT_PRODUCTS = "woocommerce.import.products.queue";
	public static final String WOOCOMMERCE_IMPORT_STORE_SETTINGS = "woocommerce.import.store.settings.queue";
	
	// WooCommerce WEBHOOKS
	public static final String WOOCOMMERCE_WEBHOOKS_RETRY_EVENTS = "woocommerce.webhooks.retry.events.queue";
	public static final String WOOCOMMERCE_WEBHOOKS_ORDER_EVENTS = "woocommerce.webhooks.order.events.queue";
	public static final String WOOCOMMERCE_WEBHOOKS_PRODUCT_EVENTS = "woocommerce.webhooks.product.events.queue";
	public static final String WOOCOMMERCE_WEBHOOKS_PRODUCT_VARIANT_EVENTS = "woocommerce.webhooks.product.variant.events.queue";

	// Marketpalce UPDATES
	public static final String MARKETPLACE_INITIAL_IMPORT = "marketplace.initial.import.queue";
	public static final String MARKETPLACE_GET_MISSING_ORDERS = "marketplace.get.missing.orders.queue";
	public static final String MARKETPLACE_GET_MISSING_PRODUCTS = "marketplace.get.missing.products.queue";
	public static final String MARKETPLACE_IMPORT_LATEST_ORDER_UPDATES = "marketplace.import.latest.order.updates.queue";
	
	public static final String MARKETPLACE_REALTIME_RATES = "marketplace.realtime.rates.queue";
	public static final String MARKETPLACE_FULFILMENT_UPDATE = "marketplace.fulfilment.update.queue";
	public static final String MARKETPLACE_PROCESS_DELETE_PRODUCTS = "marketplace.process.delete.products";
	public static final String MARKETPLACE_LOCATION_SPLIT_UPDATES = "marketplace.location.split.updates.queue";
	
	// Notifications
	public static final String SEND_NOTIFICATION_UPDATE_EVENT = "send.notification.update.queue";
	
	// delete markeplace
	public static final String DELETE_MARKETPLACE_QUEUE = "delete.marketplace.queue";

	// Wix
	public static final String WIX_WEBHOOKS = "wix.webhooks.queue";
	public static final String WIX_ORDER_WEBHOOKS = "wix.order.webhooks.queue";
	public static final String WIX_PRODUCT_WEBHOOKS = "wix.product.webhooks.queue";
	public static final String WIX_PROCESS_DELETE_VARIANTS = "wix.process.delete.variants";
	public static final String WIX_ORDER_FULFILMENT_WEBHOOKS = "wix.order.fulfilment.webhooks.queue";

	// Wix ecom
	public static final String WIX_ECOM_ORDER_WEBHOOKS = "wix.ecom.order.webhooks.queue";
	public static final String WIX_ECOM_ORDER_FULFILMENT_WEBHOOKS = "wix.ecom.order.fulfilment.webhooks.queue";

	// LightSpeed integration
	public static final String LIGHTSPEED_WEBHOOKS = "lightspeed.webhooks.queue";
	public static final String LIGHTSPEED_ORDER_WEBHOOKS = "lightspeed.order.webhooks.queue";
	public static final String LIGHTSPEED_WEBHOOKS_CREATE = "lightspeed.webhooks.create.queue";
	public static final String LIGHTSPEED_PRODUCT_WEBHOOKS = "lightspeed.product.webhooks.queue";
	public static final String LIGHTSPEED_PROCESS_DELETE_VARIANTS = "lightspeed.process.delete.variants";

	// SquareSpace integration
	public static final String SQUARESPACE_WEBHOOKS_CREATE = "sqaurespace.webhooks.create.queue";
	public static final String SQUARESPACE_ORDER_WEBHOOKS = "sqaurespace.order.webhooks.queue";
	public static final String SQUARESPACE_WEBHOOKS_REVOKE = "sqaurespace.webhooks.revoke.queue";

	public static final String EXTERNAL_FULFILLED_ORDERS_WEBHOOK = "external.fulfilled.orders.queue";
    
	// Custom branding event topics
	public static final String ORDER_RECEIVED_EVENT_TOPIC = "order.received.event.topic";
	public static final String ORDER_SHIPPED_EVENT_TOPIC = "order.shipped.event.topic";
	public static final String ORDER_DELIVERED_EVENT_TOPIC = "order.delivered.event.topic";
	public static final String ORDER_DELIVERY_FAILED_EVENT_TOPIC = "order.delivery.failed.event.topic";
	
	public static final String SHIPMENT_TRACKING_UPDATE_EVENT_QUEUE = "shipment.delivery.update.event.queue";

	// BIGCOMMERCE
	public static final String BIGCOMMERCE_SKUS_WEBHOOKS_QUEUE = "bigcommerce.skus.webhooks.queue";
	public static final String BIGCOMMERCE_ORDERS_WEBHOOKS_QUEUE = "bigcommerce.orders.webhooks.queue";
	public static final String BIGCOMMERCE_PRODCUTS_WEBHOOKS_QUEUE = "bigcommerce.products.webhooks.queue";
	public static final String BIGCOMMERCE_SHIPMENTS_WEBHOOKS_QUEUE = "bigcommerce.shipments.webhooks.queue";
	
	// Encryption - Decryption
	public static final String PII_ENCRYPTION_BY_MARKETPLACE = "pii.marketplace.encryption";
	public static final String DATA_ENCRYPTION_PROCESSOR = "data.encryption.processor";
	public static final String MARKETPLACE_KEYS_PROCESSOR = "marketplace.keys.processor";
	
	//TOPICs
	public static final String JPA_ORDER_CREATE_TOPIC = "jpa.order.create.topic";
	public static final String JPA_ORDER_UPDATE_TOPIC = "jpa.order.update.topic";

	public static final String JPA_BULK_SHIPMENT_TOPIC = "jpa.bulk.shipment.topic";
	public static final String JPA_BATCH_SHIPMENT_TOPIC = "jpa.batch.shipment.topic";
	public static final String JPA_SHIPMENT_CREATE_TOPIC = "jpa.shipment.create.topic";
	public static final String JPA_SHIPMENT_UPDATE_TOPIC = "jpa.shipment.update.topic";

	public static final String ORDER_IMPORT_QUEUE = "marketplace.csv.order.import.queue";

	public static final String JPA_PREFETCH_QUOTES_ORDER_CREATE_TOPIC = "JPA.PrefetchQuotes."
			+ ClickShipJMS.JPA_ORDER_CREATE_TOPIC;

	public static final String PREFETCH_QUOTES_GET_RATES_QUEUE = "prefetchQuotes.get.rates.queue";

	public static final String WEBHOOK_TYPE = "type";
	public static final String WEBHOOK_ACTION = "event";
	public static final String MARKETPLACE_ID = "marketplaceId";
}
