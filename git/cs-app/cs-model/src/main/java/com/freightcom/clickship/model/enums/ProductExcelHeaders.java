package com.freightcom.clickship.model.enums;

import java.util.List;

import org.apache.commons.lang3.EnumUtils;

public enum ProductExcelHeaders {
	
	ID("ID"),
	SKU("SKU"),
	TITLE("Title"),
	UNIT_OF_MEASURE("Unit Of Measure"),
	LENGTH("Length"),
	WIDTH("Width"),
	HEIGHT("Height"),
	WEIGHT("Weight"),
	HS_CODE("HS code"),
	CUSTOMS_DESCRIPTION("Customs Description"),
	COUNTRY_OF_ORIGIN("Country Of Origin"),
	CUSTOM_BOX("Custom Box"),
	// CP-521
	CUSTOM_BOX_DESCRIPTION("Custom Box Description"),
	STORAGE_LOCATION("Storage Location"),
	STORAGE_ID("Stroage ID"),
	STACKABLE("Stackable"),
	CAN_ROTATE("Can Rotate"),
	IS_MULTI_SKU("Multi BOX Product"),
	MULTI_SKU_QUANTITY("Multi BOX Quantity");
	
	private final String headerName;

	ProductExcelHeaders(String headerName) {
		this.headerName = headerName;
	}

	@Override
	public String toString() {
		return this.headerName;
	}

	public static String[] getHeaders() {
		List<ProductExcelHeaders> list = EnumUtils.getEnumList(ProductExcelHeaders.class);
		return list.stream().map(ProductExcelHeaders::toString).toArray(String[]::new); 
	}
	
}
