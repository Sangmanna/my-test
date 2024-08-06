package com.freightcom.clickship.model.shippingrules;

public enum ShippingRuleBoxWeightType {
	ORDER_WEIGHT("Order Weight"),
	CUSTOM_WEIGHT("Custom Weight");

	private String type;

	ShippingRuleBoxWeightType(String s) {
		this.type = s;
	}

	public String getType() {
		return type;
	}
}
