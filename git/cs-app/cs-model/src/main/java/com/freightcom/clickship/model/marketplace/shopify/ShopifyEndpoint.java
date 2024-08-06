package com.freightcom.clickship.model.marketplace.shopify;

public enum ShopifyEndpoint {

	SHOP("/admin/api/%s/shop.json"),
	ORDERS("/admin/api/%s/orders.json"),
	ORDER("/admin/api/%s/orders/%s.json"),
	WEBHOOKS("/admin/api/%s/webhooks.json"),
	PRODUCTS("/admin/api/%s/products.json"),
	CARRIER_CALLBACK_URL("%s/%s/shopify/%s"),
	WEBHOOK("/admin/api/%s/webhooks/%s.json"),
	PRODUCT("/admin/api/%s/products/%s.json"),
	VARIANT("/admin/api/%s/variants/%s.json"),
	LOCATIONS("/admin/api/%s/locations.json"),
	GENERATE_TOKEN("/admin/oauth/access_token"),
	LOCATION("/admin/api/%s/locations/%s.json"),
	WEBHOOK_CALLBACK_URL("%s/%s/shopify/%s/%s"),
	ORDERS_COUNT("/admin/api/%s/orders/count.json"),
	ORDER_CANCEL("/admin/api/%s/orders/%s/cancel.json"),
	PRODUCTS_COUNT("/admin/api/%s/products/count.json"),
	CARRIER_SERVICES("/admin/api/%s/carrier_services.json"),
	FULFILLMENT_CREATE_V2("/admin/api/%s/fulfillments.json"),
	CARRIER_SERVICE("/admin/api/%s/carrier_services/%s.json"),
	UNINTALL_STORE("/admin/api/%s/api_permissions/current.json"),
	FULFILLMENT_ORDER("/admin/api/%s/fulfillment_orders/%s.json"),
	FULFILLMENT_CREATE("/admin/api/%s/orders/%s/fulfillments.json"),
	RECURRING_CHARGE_CALLBACK_URL("%s/shopify/recurring/charge/%s"),
	FULFILLMENT_CANCEL_V2("/admin/api/%s/fulfillments/%s/cancel.json"),
	FULFILLMENT_ORDERS("/admin/api/%s/orders/%s/fulfillment_orders.json"),
	FULFILLMENT_ORDER_MOVE("/admin/api/%s/fulfillment_orders/%s/move.json"),
	RECURRING_CHARGE("/admin/api/%s/recurring_application_charges/%s.json"),
	FULFILLMENT_CANCEL("/admin/api/%s/orders/%s/fulfillments/%s/cancel.json");
//	RECURRING_CHARGE_CREATE("/admin/api/%s/recurring_application_charges.json"),
//	RECURRING_CHARGE_CANCEL("/admin/api/%s/recurring_application_charges/%s.json");
	
	private String value;

	ShopifyEndpoint(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
