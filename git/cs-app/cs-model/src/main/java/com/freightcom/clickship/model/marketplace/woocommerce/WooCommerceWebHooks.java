package com.freightcom.clickship.model.marketplace.woocommerce;

public enum WooCommerceWebHooks {
	
	PRODUCT_CREATE("product.created"),
	PRODUCT_UPDATE("product.updated"),
	PRODUCT_DELETE("product.deleted"),
	ORDER_CREATE("order.created"),
	ORDER_UPDATE("order.updated"),
	ORDER_DELETE("order.deleted");

	private String value;

	WooCommerceWebHooks(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
