package com.freightcom.clickship.model.enums;

import java.util.List;

import org.apache.commons.lang3.EnumUtils;

public enum BoxExcelHeaders {
	
	ID("ID"),
	NAME("Name"),
	BOX_TYPE("Type"),
	UNIT_OF_MEASURE("Unit Of Measure"),
	LENGTH("Length"),
	WIDTH("Width"),
	HEIGHT("Height"),
	WEIGHT("Weight"),
	MAX_WEIGHT("Max Weight"),
	USE_IN_SMART_PACKING("Use In Smart Packaging");
	
	private final String headerName;

	BoxExcelHeaders(String headerName) {
		this.headerName = headerName;
	}

	@Override
	public String toString() {
		return this.headerName;
	}

	public static String[] getHeaders() {
		List<BoxExcelHeaders> list = EnumUtils.getEnumList(BoxExcelHeaders.class);
		return list.stream().map(BoxExcelHeaders::toString).toArray(String[]::new); 
	}
}
