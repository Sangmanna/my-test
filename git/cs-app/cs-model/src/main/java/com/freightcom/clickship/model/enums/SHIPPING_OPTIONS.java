package com.freightcom.clickship.model.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum SHIPPING_OPTIONS {
	SIGNATURE_REQUIRED("Signature Required"), ADULT_SIGNATURE_REQUIRED("Adult Signature Required"), RESIDENTIAL_DELIVERY("Residential Delivery"), SATURDAY_DELIVERY("Saturday Delivery"), SATURDAY_PICKUP("Saturday Pickup");

	SHIPPING_OPTIONS(String columnName) {
		this.columnName = columnName;
	}

	private final String columnName;

	@Override
	public String toString() {
		return this.columnName;
	}

	public static List<Object> getColumns() {
		return Arrays.stream(SHIPPING_OPTIONS.values()).map(Object::toString).collect(Collectors.toList());
	}
}