package com.freightcom.clickship.model.marketplace.magento;

public enum MagentoEndpoint {
	
	ORDERS("/rest/V1/orders"),
	PRODUCTS("/rest/V1/products"),
	GET_ORDER("/rest/V1/orders/%s"),
	SHIPMENTS("/rest/V1/shipments/"),
	CONFIG("/rest/V1/store/storeConfigs"),
	GET_SHIPMENT("/rest/V1/shipment/%s"),
	ADD_SHIPMENT("/rest/V1/order/%s/ship"),
	ORDER_CANCEL("/rest/V1/orders/%s/cancel"),
	CREATE_INVOICE("/rest/V1/order/%s/invoice"),
	GENERATE_TOKEN("/rest/V1/integration/admin/token"),
	ADD_TRACKING_TO_SHIPMENT("/rest/V1/shipment/track"),
	DELETE_TRACKING_FROM_SHIPMENT("/rest/V1/shipment/track/%s");

	private String value;

	MagentoEndpoint(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
