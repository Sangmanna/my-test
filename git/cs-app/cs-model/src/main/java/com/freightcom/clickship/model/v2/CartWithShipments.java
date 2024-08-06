package com.freightcom.clickship.model.v2;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartWithShipments {

	private String id;
	@JsonProperty("customer_id")
	private String customerId;
	@JsonProperty("booked")
	private boolean isBooked;
	@JsonProperty("booking_request_id")
	private String bookingRequestId;	
	private List<GetShipmentResponseDTO> shipments;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public boolean isBooked() {
		return isBooked;
	}
	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}
	public String getBookingRequestId() {
		return bookingRequestId;
	}
	public void setBookingRequestId(String bookingRequestId) {
		this.bookingRequestId = bookingRequestId;
	}
	public List<GetShipmentResponseDTO> getShipments() {
		return shipments;
	}
	public void setShipments(List<GetShipmentResponseDTO> shipments) {
		this.shipments = shipments;
	}	
	
}
