package com.freightcom.clickship.model.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum SHIPPING_DETAILS {
	TRACKING_NUMBER("Tracking Number"), TRACKING_URL("Tracking URL"), SHIPPING_ACCOUNT("Shipping Account"), SERVICE_TYPE("Service Type"), MANIFEST_ID("Manifest ID"),
	CARRIER_SHIPMENT_ID("Carrier Shipment ID"), ACTIVE_SHIPMENT("Active Shipment"), REFERENCE_CODE1("Reference Code #1"), REFERENCE_CODE2("Reference Code #2"), REFERENCE_CODE3("Reference Code #3");

	SHIPPING_DETAILS(String columnName) {
		this.columnName = columnName;
	}

	private final String columnName;

	@Override
	public String toString() {
		return this.columnName;
	}

	public static List<Object> getColumns() {
		return Arrays.stream(SHIPPING_DETAILS.values()).map(Object::toString).collect(Collectors.toList());
	}
}
