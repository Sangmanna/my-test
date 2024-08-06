package com.freightcom.clickship.model.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum PRICE {
	SHIPPING_COST("Shipping Cost"), SHIPPING_CURRENCY("Shipping Currency"), TOTAL_DISCOUNTS("Total Discounts"), TAXES("Taxes"), SUBTOTAL("Subtotal"), TOTAL("Total"), CURRENCY("Currency");

	PRICE(String columnName) {
		this.columnName = columnName;
	}

	private final String columnName;

	@Override
	public String toString() {
		return this.columnName;
	}

	public static List<Object> getColumns() {
		return Arrays.stream(PRICE.values()).map(Object::toString).collect(Collectors.toList());
	}
}