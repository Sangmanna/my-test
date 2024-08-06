package com.freightcom.clickship.model.enums;

import java.util.List;
import org.apache.commons.lang3.EnumUtils;

public enum ExternallyFulfilledHeaders {

	ORDER_NUMBER("Order Number"),
	MARKETPLACE("Marketplace"),
	ORDER_DATE("Order Date"),
	EXTERANNALY_FULFILLED_DATE("Externally Fulfilled Date"),
	RTR_FETCHED("RTR Fetched for this order"),
	RTR_CHARGES("RTR Usage Charges"),
	ORDER_NOTES("Order Notes"),
	CS_NOTES("ClickShip Notes");
	
	
	private final String headerName;

	ExternallyFulfilledHeaders(String headerName) {
		this.headerName = headerName;
	}

	@Override
	public String toString() {
		return this.headerName;
	}

	public static String[] getHeaders() {
		List<ExternallyFulfilledHeaders> list = EnumUtils.getEnumList(ExternallyFulfilledHeaders.class);
		return list.stream().map(ExternallyFulfilledHeaders::toString).toArray(String[]::new); 
	}

}
