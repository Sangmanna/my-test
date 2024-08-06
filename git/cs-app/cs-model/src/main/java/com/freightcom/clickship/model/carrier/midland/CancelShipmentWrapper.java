package com.freightcom.clickship.model.carrier.midland;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY, content = JsonInclude.Include.NON_NULL)
public class CancelShipmentWrapper {

	@JsonProperty("CancelShipmentResponse")
	private CancelShipmentResponse cancelShipmentResponse;

	public CancelShipmentResponse getCancelShipmentResponse() {
		return cancelShipmentResponse;
	}

	public void setCancelShipmentResponse(CancelShipmentResponse cancelShipmentResponse) {
		this.cancelShipmentResponse = cancelShipmentResponse;
	}
}
