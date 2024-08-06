package com.freightcom.clickship.model.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum ORDERLINE {
	LINE_NUMBER("Line Number"), SKU("SKU"), TITLE("Title"), QUANTITY("Quantity"), UNIT_PRICE("Unit Price"), LINE_SUBTOTAL("Line Subtotal");

	private final String columnName;

	ORDERLINE(String columnName) {
		this.columnName = columnName;
	}

	@Override
	public String toString() {
		return this.columnName;
	}

	public static List<Object> getColumns() {
		return Arrays.asList(LINE_NUMBER, SKU, TITLE, QUANTITY).stream().map(Object::toString).collect(Collectors.toList());
	}
	
	public static List<Object> getColumnsWithPrice() {
		return Arrays.asList(UNIT_PRICE, LINE_SUBTOTAL).stream().map(Object::toString).collect(Collectors.toList());
	}
}