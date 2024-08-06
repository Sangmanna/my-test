package com.freightcom.clickship.model.enums;

public enum CanadapostShipmentMethodOfPaymentEnum {
	Account("Account"), CreditCard("Credit Card");

	private final String name;

	private CanadapostShipmentMethodOfPaymentEnum(String s) {
		name = s;
	}

	public String toString() {
		return this.name;
	}
}