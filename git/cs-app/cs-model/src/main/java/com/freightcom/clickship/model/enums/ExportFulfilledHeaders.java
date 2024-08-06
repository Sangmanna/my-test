package com.freightcom.clickship.model.enums;

import java.util.List;
import org.apache.commons.lang3.EnumUtils;

public enum ExportFulfilledHeaders {

	ORDER_NUMBER("Order Number"),
	MARKETPLACE("Marketplace"),
	SKU("SKU"),
	TITLE("Title"),
	QUANTITY("Quantity"),
	ORDER_DATE("Order Date"),
	SHIP_DATE("Ship Date"),
	TRACKING_NUMBER("Tracking Number"),
	TRACKING_URL("Tracking URL"),
	SHIPPING_CARRIER("Shipping Carrier"),
	SERVICE_TYPE("Service Type"),
	MANIFEST_ID("Manifest ID"),
	ACTIVE_SHIPMENT("Active Shipment"),
	SIGNATURE_REQUIRED("Signature Required"),
	ADULT_SIGNATURE_REQUIRED("Adult Signature Required"),
	RESIDENTIAL_DELIVERY("Residential Delivery"),
	SHIP_TO_CONTACT("Shipment To Contact"),
	SHIP_TO_ADDRESS1("Shipment To Address1"),
	SHIP_TO_ADDRESS2("Shipment To Address2"),
	SHIP_TO_CITY("Shipment To City"),
	SHIP_TO_PROVINCE("Shipment To Province/State"),
	SHIP_TO_COUNTRY("Shipment To Country"),
	SHIP_TO_POSTAL_CODE("Shipment To Postal Code"),
	SHIP_TO_PHONE("Shipment To Phone"),
	SHIP_TO_EMAIL("Shipment To Email"),
	SHIP_FROM_COMPANY("Shipment From Company"),
	SHIP_FROM_CONTACT("Shipment From Contact"),
	SHIP_FROM_ADDRESS1("Shipment From Address1"),
	SHIP_FROM_ADDRESS2("Shipment From Address2"),
	SHIP_FROM_CITY("Shipment From City"),
	SHIP_FROM_PROVINCE("Shipment From Province/State"),
	SHIP_FROM_COUNTRY("Shipment From Country"),
	SHIP_FROM_POSTAL_CODE("Shipment From Postal Code"),
	SHIP_FROM_PHONE("Shipment From Phone"),
	SHIP_FROM_EMAIL("Shipment From Email"),
	SHIPMENT_COST("Shipment Total Cost(Tax Included)"),
	SHIPMENT_TAX_HST("Shipment Tax  (HST)"),
	SHIPMENT_TAX_GST("Shipment Tax (GST)"),
	SHIPMENT_TAX_OTHER("Shipment Tax (Other)"),
	CARRIER("Shipment Carrier"),
	SERVICE("Shipment Service"),
	RTR_FETCHED("RTR Fetched for this order"),
	REFERENCE1("Reference #1"),
	REFERENCE2("Reference #2"),
	REFERENCE3("Reference #3"),
	ORDER_NOTES("Order Notes"),
	CS_NOTES("ClickShip Notes");
	
	
	private final String headerName;

	ExportFulfilledHeaders(String headerName) {
		this.headerName = headerName;
	}

	@Override
	public String toString() {
		return this.headerName;
	}

	public static String[] getHeaders() {
		List<ExportFulfilledHeaders> list = EnumUtils.getEnumList(ExportFulfilledHeaders.class);
		return list.stream().map(ExportFulfilledHeaders::toString).toArray(String[]::new); 
	}

}
