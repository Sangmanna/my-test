package com.freightcom.clickship.model.marketplace.bigcommerce;

public enum BigCommerceOrderStatus {

	INCOMPLETE("0"),
	PENDING("1"),
	SHIPPED("2"),
	PARTIALLY_SHIPPED("3"),
	REFUNDED("4"),
	CANCELLED("5"),
	DECLINED("6"),
	AWAITING_PAYMENT("7"),
	AWAITING_PICKUP("8"),
	AWAITING_SHIPMENT("9"),
	COMPLETED("10"),
	AWAITING_FULFILLMENT("11"),
	MANUAL_VERIFICATION_REQUIRED("12"),
	DISPUTED("13"),
	PARTIALLY_REFUNDED("14");

	private String value;

	private BigCommerceOrderStatus(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
	
	public int getIntValue() {
		return Integer.parseInt(this.value);
	}

}
