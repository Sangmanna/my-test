package com.freightcom.clickship.model.shippingrules;

public enum ShippingRuleFieldType {
	ORDER_WEIGHT("Order Weight"),
	ORDER_DATE("Order Date"),
	MARKETPLACE("Marketplace"),
	CUSTOMER_NAME("Customer Name"),
	PRODUCT_TITLE("Product Title"),
	SKU("SKU"),
	ORDER_VALUE("Order Value"),
	SHIPPING_DESTINATION("Shipping Destination");
	
	private String type;
	
	ShippingRuleFieldType(String s) {
		this.type = s;
	}

	public String getType() {
		return type;
	}
}
