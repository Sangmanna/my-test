package com.freightcom.clickship.model.shippingrules;

public enum ShippingRuleVersion {
	ADVANCED("ADVANCED"),
	BASIC("BASIC");

	private String type;

	ShippingRuleVersion(String s) {
		this.type = s;
	}

	public String getType() {
		return type;
	}
}
