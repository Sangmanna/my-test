package com.freightcom.clickship.client.wix;

public enum WixEndPoint {

	WIX_AUTHORIZE_URL("/installer/install"),
	WIX_AUTH_EXCHANGE("/oauth/access"),
	WIX_COMPLETE_AUTH("/_api/site-apps/v1/site-apps/token-received"),
	
	GET_INSTANCE("/apps/v1/instance"),
	GET_ADDRESS("/site-properties/v4/properties"),
	
	GET_PRODUCTS("/stores/v1/products/query"),
	GET_PRODUCT("/stores/v1/products/{productId}"),
	GET_VARIANTS("/stores/v1/products/{productId}/variants/query"),
	
	GET_ORDERS("/stores/v2/orders/query"),
	GET_ORDER("/stores/v2/orders/{orderId}"),

	CREATE_FULFILLMENT("/stores/v2/orders/{orderId}/fulfillments"),
	CANCEL_FULFILLMENT("/stores/v2/orders/{orderId}/fulfillments/{fulfillmentId}"),

	SEARCH_ECOM_ORDERS("/ecom/v1/orders/search"),
	GET_ECOM_ORDER_BY_ID("/ecom/v1/orders/{orderId}"),
	CANCEL_ECOM_ORDERS("/ecom/v1/orders/{orderId}/cancel"),
	CREATE_ECOM_FULFILLMENT("/ecom/v1/fulfillments/orders/{orderId}/create-fulfillment"),
	CANCEL_ECOM_FULFILLMENT("/ecom/v1/fulfillments/{fulfillmentId}/orders/{orderId}");
	
	private String value;

	private WixEndPoint(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
