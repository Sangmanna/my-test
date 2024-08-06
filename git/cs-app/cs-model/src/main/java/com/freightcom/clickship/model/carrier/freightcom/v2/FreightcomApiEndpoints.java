package com.freightcom.clickship.model.carrier.freightcom.v2;

public enum FreightcomApiEndpoints {

	CUSTOMER("/customer"),
	CUSTOMER_DETAILS("/customer/details"),
	UPDATE_PASSWORD("/user/%s/%s/password"),
	CUSTOMER_APPROVE("/customer/%s/approve"),
	PAYMENT_METHOD("/finance/%s/payment-methods"),
	USER_EMAIL_VERIFY("/user/%s/%s/verify-email"),
	CONVERT_CURRENCY("/finance/test-customer/convert-currency");
	
	private String value;

	FreightcomApiEndpoints(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
