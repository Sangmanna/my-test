package com.freightcom.clickship.model.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum ORDER {
	ID("ID"), ORDER_NUMBER("Order Number"), MARKETPLACE("Marketplace"), MARKETPLACE_ORDER_NUMBER("Marketplace Order Number"), STATUS("Status");

	private final String columnName;

	ORDER(String columnName) {
		this.columnName = columnName;
	}

	@Override
	public String toString() {
		return this.columnName;
	}

	public static List<Object> getColumns() {
		return Arrays.stream(ORDER.values()).map(Object::toString).collect(Collectors.toList());
	}
}