package com.freightcom.clickship.model.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum DATE {
	ORDER_DATE("Order Date"), SHIP_DATE("Ship Date");

	private final String columnName;

	DATE(String columnName) {
		this.columnName = columnName;
	}

	@Override
	public String toString() {
		return this.columnName;
	}

	public static List<Object> getColumns() {
		return Arrays.stream(DATE.values()).map(Object::toString).collect(Collectors.toList());
	}
}
