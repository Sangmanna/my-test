package com.freightcom.clickship.model.v2;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CartBookingResult {
	@JsonProperty("status")
    private String status;

    @JsonProperty("error_type")
    private String errorType;

    @JsonProperty("error_message")
    private String errorMessage;

    @JsonProperty("booking")
    private CartBooking booking;

    @JsonProperty("booked_shipments")
    private List<CartBookedShipment> bookedShipments;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

	public CartBooking getBooking() {
		return booking;
	}

	public void setBooking(CartBooking booking) {
		this.booking = booking;
	}

	public List<CartBookedShipment> getBookedShipments() {
		return bookedShipments;
	}

	public void setBookedShipments(List<CartBookedShipment> bookedShipments) {
		this.bookedShipments = bookedShipments;
	}

   
}
