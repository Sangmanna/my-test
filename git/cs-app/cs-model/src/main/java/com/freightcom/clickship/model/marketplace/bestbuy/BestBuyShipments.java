package com.freightcom.clickship.model.marketplace.bestbuy;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BestBuyShipments {

	@JsonProperty("order_id")
	private String orderId;
	
	@JsonProperty("shipped")
	private boolean shipped;
	
	@JsonProperty("shipment_lines")
	private List<BestBuyShipmentLines> shipmentLines;
	
	@JsonProperty("tracking")
	private BestBuyTracking tracking;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public boolean isShipped() {
		return shipped;
	}

	public void setShipped(boolean shipped) {
		this.shipped = shipped;
	}

	public List<BestBuyShipmentLines> getShipmentLines() {
		return shipmentLines;
	}

	public void setShipmentLines(List<BestBuyShipmentLines> shipmentLines) {
		this.shipmentLines = shipmentLines;
	}

	public BestBuyTracking getTracking() {
		return tracking;
	}

	public void setTracking(BestBuyTracking tracking) {
		this.tracking = tracking;
	}
	
}
