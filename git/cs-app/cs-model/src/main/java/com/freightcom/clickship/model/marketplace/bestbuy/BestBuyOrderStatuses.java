package com.freightcom.clickship.model.marketplace.bestbuy;

public enum BestBuyOrderStatuses {
	
	STAGING("STAGING"),
	WAITING_ACCEPTANCE("WAITING_ACCEPTANCE"),
	WAITING_DEBIT("WAITING_DEBIT"),
	WAITING_DEBIT_PAYMENT("WAITING_DEBIT_PAYMENT"),
	SHIPPING("SHIPPING"),
	SHIPPED("SHIPPED"),
	TO_COLLECT("TO_COLLECT"),
	RECEIVED("RECEIVED"),
	CLOSED("CLOSED"),
	REFUSED("REFUSED"),
	CANCELED("CANCELED"),
	INCIDENT_OPEN("INCIDENT_OPEN"),
	REFUNDED("REFUNDED");
	
	private String value;

	BestBuyOrderStatuses(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
