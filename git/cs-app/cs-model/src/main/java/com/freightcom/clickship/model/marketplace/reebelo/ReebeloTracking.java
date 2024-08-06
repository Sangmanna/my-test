package com.freightcom.clickship.model.marketplace.reebelo;

import java.util.List;

public class ReebeloTracking {
	private String orderNumber;
	private String carrier;
	private String trackingNumber;
	private List<ReebeloLineItems> lineItems;

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public List<ReebeloLineItems> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<ReebeloLineItems> lineItems) {
		this.lineItems = lineItems;
	}
}
