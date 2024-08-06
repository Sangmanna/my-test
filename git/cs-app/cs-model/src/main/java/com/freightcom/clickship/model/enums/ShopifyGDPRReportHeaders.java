package com.freightcom.clickship.model.enums;

import java.util.List;
import org.apache.commons.lang3.EnumUtils;

public enum ShopifyGDPRReportHeaders {

	ORDER_NUMBER("Order Number"),
	ORDER_DATE("Order Date"),
	SHIP_FROM_COMPANY("Shipment From Company"),
	SHIP_FROM_CONTACT("Shipment From Contact"),
	SHIP_FROM_PHONE("Shipment From Phone"),
	SHIP_FROM_EMAIL("Shipment From Email"),
	SHIP_FROM_ADDRESS("Shipment From Address"),
	SHIP_TO_ADDRESS("Shipment To Address"),
	SHIP_TO_PHONE("Shipment To Phone"),
	SHIP_TO_EMAIL("Shipment To Email"),
	SHIP_DATE("Ship Date"),
	TRACKING_NUMBER("Tracking Number"),
	TRACKING_URL("Tracking URL"),
	SHIPPING_CARRIER("Shipping Carrier"),
	SERVICE_TYPE("Service Type"),
	MANIFEST_ID("Manifest ID"),
	SIGNATURE_REQUIRED("Signature Required"),
	ADULT_SIGNATURE_REQUIRED("Adult Signature Required"),
	RESIDENTIAL_DELIVERY("Residential Delivery"),
	SHIPMENT_COST("Shipment Total Cost(Tax Included)"),
	SHIPMENT_TAX_GST("Shipment Tax (GST)"),
	SHIPMENT_TAX_HST("Shipment Tax  (HST)"),
	SHIPMENT_TAX_OTHER("Shipment Tax (Other)");
		
	private final String headerName;

	ShopifyGDPRReportHeaders(String headerName) {
		this.headerName = headerName;
	}

	@Override
	public String toString() {
		return this.headerName;
	}

	public static String[] getHeaders() {
		List<ShopifyGDPRReportHeaders> list = EnumUtils.getEnumList(ShopifyGDPRReportHeaders.class);
		return list.stream().map(ShopifyGDPRReportHeaders::toString).toArray(String[]::new); 
	}

}
