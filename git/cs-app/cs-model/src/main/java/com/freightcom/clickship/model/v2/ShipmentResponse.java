package com.freightcom.clickship.model.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShipmentResponse {
	
	@JsonProperty("shipment")
	private GetShipmentResponseDTO shipmentResponseDto;

	public GetShipmentResponseDTO getShipmentResponseDto() {
		return shipmentResponseDto;
	}

	public void setShipmentResponseDto(GetShipmentResponseDTO shipmentResponseDto) {
		this.shipmentResponseDto = shipmentResponseDto;
	}
	
	

}
