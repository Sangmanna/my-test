package com.freightcom.clickship.model.enums;

public enum CustomerLockType {
	SHIPMENT("ACCOUNT_LOCKED_NO_SHIPMENT"), NO_LOGIN("ACCOUNT_LOCKED_NO_LOGIN");

	private final String type;

	CustomerLockType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return type;
	}
}