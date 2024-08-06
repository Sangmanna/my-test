package com.freightcom.clickship.model.enums;

import java.util.List;
import org.apache.commons.lang3.EnumUtils;

public enum OrderCsvHeaders {
	
	ORDER_ID("Order ID"),
	COMPANY_BUSINESS("Company/Business"),
	CUSTOMER_NAME("Customer's Name"),
	CUSTOMER_EMAIL("Customer's Email"),
	CUSTOMER_PHONE_NUMBER("Customer's Phone Number"),
	ADDRESS_LINE_1("Address Line 1"),
	ADDRESS_LINE_2("Address Line 2"),
	POSTALCODE("Postal/Zip Code"),
	CITY("City"),
	PROVINCE_STATE("Province/State"),
	COUNTRY("Country"),
	PRODUCT_NAME("Product Name"),
	CUSTOMS_DESCRIPTION("Customs Description"),
	SKU("SKU"),
	PRODUCT_QUANTITY("Product Quantity"),
	PRICE_PER_UNIT("Price Per Unit"),
	CURRENCY("Currency"),
	HS_CODE("HS code"),
	COUNTRY_OF_ORIGIN("Country of Origin"),
	UNIT_OF_MEASUREMENT("Unit of Measurement"),
	PACKAGE_LENGTH("Package Length"),
	PACKAGE_WIDTH("Package Width"),
	PACKAGE_HEIGHT("Package Height"),
	PACKAGE_WEIGHT("Package Weight"),
	ORDER_NOTES("Order Notes"),
	ERROR_MESSAGES("Error messages");
	
	private final String csvHeaderName;

	OrderCsvHeaders(String csvHeaderName) {
		this.csvHeaderName = csvHeaderName;
	}

	@Override
	public String toString() {
		return this.csvHeaderName;
	}

	public static String[] getHeaders() {
		List<OrderCsvHeaders> list = EnumUtils.getEnumList(OrderCsvHeaders.class);
		return list.stream().map(OrderCsvHeaders::toString).toArray(String[]::new); 
	}

	public static OrderCsvHeaders fromString(String csvHeaderName) {
		for (OrderCsvHeaders header : values()) {
			if (header.toString().equals(csvHeaderName)) {
				return header;
			}
		}
		return null;
	}
}
