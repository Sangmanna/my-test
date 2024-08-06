package com.freightcom.clickship.model.marketplace.amazon;

public enum AmazonOrderStatuses {
	
	PENDING("Pending"),
	UNSHIPPED("Unshipped"),
	PARTIALLY_SHIPPED("PartiallyShipped"),
	SHIPPED("Shipped"),
	CANCELED("Canceled"),
	UNFULFILLABLE("Unfilfillable"),
	PENDING_AVAILABILITY("PendingAvailability");
	
	private String value;

	AmazonOrderStatuses(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
