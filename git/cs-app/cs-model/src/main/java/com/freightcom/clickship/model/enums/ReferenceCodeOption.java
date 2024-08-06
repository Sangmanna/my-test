package com.freightcom.clickship.model.enums;

public enum ReferenceCodeOption {
	ORDER_NUMBER("Order #"), CITY("City"), PROVINCE("Province/State"), COUNTRY("Country"), OTHER("Other");

	ReferenceCodeOption(String columnName) {
		this.columnName = columnName;
	}

	private final String columnName;

	@Override
	public String toString() {
		return this.columnName;
	}
}
