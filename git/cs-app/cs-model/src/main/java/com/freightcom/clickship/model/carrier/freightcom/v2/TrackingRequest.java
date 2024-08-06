package com.freightcom.clickship.model.carrier.freightcom.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrackingRequest {

	@JsonProperty("CustomerID")
	private String customerId;

	@JsonProperty("ShipmentID")
	private String shipmentId;

	@JsonProperty("State")
	private String State;

	@JsonProperty("Time")
	private String time;

	@JsonProperty("TrackingEvent")
	private TrackingEvent trackingEvent;

	public String getCustomerId() {
		return customerId;
	}

	public TrackingRequest setCustomerId(String customerId) {
		this.customerId = customerId;
		return this;
	}

	public String getShipmentId() {
		return shipmentId;
	}

	public TrackingRequest setShipmentId(String shipmentId) {
		this.shipmentId = shipmentId;
		return this;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getTime() {
		return time;
	}

	public TrackingRequest setTime(String time) {
		this.time = time;
		return this;
	}

	public TrackingEvent getTrackingEvent() {
		return trackingEvent;
	}

	public void setTrackingEvent(TrackingEvent trackingEvent) {
		this.trackingEvent = trackingEvent;
	}
}
