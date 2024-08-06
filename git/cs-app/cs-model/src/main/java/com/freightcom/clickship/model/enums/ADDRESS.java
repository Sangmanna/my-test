package com.freightcom.clickship.model.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum ADDRESS {
	COMPANY("Company"), CONTACT("Contact"), ADDRESS1("Address1"), ADDRESS2("Address2"), ADDRESS3("Address3"), CITY("City"), PROVINCE("Province/State"), COUNTRY("Country"), POSTAL_CODE("Postal Code"), PHONE("Phone"), EMAIL("Email");

	ADDRESS(String columnName) {
		this.columnName = columnName;
	}

	private final String columnName;

	@Override
	public String toString() {
		return this.columnName;
	}

	private static List<Object> columns = Arrays.stream(ADDRESS.values()).map(Object::toString).collect(Collectors.toList());

	public static final String SHIP_TO = "Shipment To ";
	public static final String BILL_TO = "Bill To ";
	public static final String ORDER_SHIP_TO = "Order Ship To ";
	private static final String SHIP_FROM = "Shipment From ";

	public static String getShipTo(ADDRESS col) {
		return SHIP_TO + col;
	}

	public static String getBillTo(ADDRESS col) {
		return BILL_TO + col;
	}

	public static String getOrderShipTo(ADDRESS col) {
		return ORDER_SHIP_TO + col;
	}

	public static String getOrderShipFrom(ADDRESS col) {
		return SHIP_FROM + col;
	}

	private static List<Object> getColumns(String prefix) {
		return columns.stream().map(str -> prefix + str).collect(Collectors.toList());
	}

	public static List<Object> getOrderShipToColumns() {
		return getColumns(ORDER_SHIP_TO);
	}
	
	public static List<Object> getOrderShipFromColumns() {
		return getColumns(SHIP_FROM);
	}
	
	public static List<Object> getShipToColumns() {
		return getColumnsWithoutCompany(SHIP_TO);
	}
	
	public static List<Object> getBillToColumns() {
		return getColumnsWithoutCompany(BILL_TO);
	}
	
	private static List<Object> getColumnsWithoutCompany(String prefix) {
		List<Object> list = getColumns(prefix);
		return list.subList(1, list.size());
	}
}
