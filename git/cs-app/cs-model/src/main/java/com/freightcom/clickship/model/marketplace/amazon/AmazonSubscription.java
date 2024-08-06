package com.freightcom.clickship.model.marketplace.amazon;

public enum AmazonSubscription {
	
	FEE_PROMOTION("FeePromotion"),
	OFFER_CHANGED("AnyOfferChanged"),
	ORDER_STATUS("FulfillmentOrderStatus"),
	FEE_PROCESSING("FeedProcessingFinished"),
	SHIPMENT_STATUS("FBAOutboundShipmentStatus"),
	REPORT_PROCESSING("ReportProcessingFinished");
	
	private String value;

	AmazonSubscription(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
