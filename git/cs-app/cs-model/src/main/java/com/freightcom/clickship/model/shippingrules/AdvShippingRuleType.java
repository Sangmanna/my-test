package com.freightcom.clickship.model.shippingrules;

public enum AdvShippingRuleType {
	REAL_TIME_RATE_RULE("Real-Time Rates at Checkout"),
	ORDER_RULE("Orders within ClickShip");

	private String type;

	AdvShippingRuleType(String s) {
		this.type = s;
	}

	public String getType() {
		return type;
	}
}
