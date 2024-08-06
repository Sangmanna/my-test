package com.freightcom.clickship.model.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CartBookingResponse {
	
	@JsonProperty("booking_request_id")
	private String bookingRequestId;

	public String getBookingRequestId() {
		return bookingRequestId;
	}

	public void setBookingRequestId(String bookingRequestId) {
		this.bookingRequestId = bookingRequestId;
	}
	
	

}
