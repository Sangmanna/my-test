package com.freightcom.clickship.model.marketplace.woocommerce;

public enum WcEndpoint {
	
	    ORDERS("orders"),
	    PRODUCTS("products"),
	    WEBHOOKS_CREATE("webhooks/"),
	    PRODUCTS_TAGS("products/tags"),
	    SYSTEM_STATUS("system_status"),
	    WEBHOOKS_BATCH("webhooks/batch"),
	    SETTINGS_GENERAL("settings/general"),
	    SETTINGS_PRODUCT("settings/products"),
	    PRODUCTS_ATTRIBUTES("products/attributes"),
	    PRODUCTS_CATEGORIES("products/categories"),
	    TRACKING("orders/{orderId}/shipment-trackings"),
	    PRODUCTS_SHIPPING_CLASSES("products/shipping_classes");

	    private String value;

	    WcEndpoint(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }

}
