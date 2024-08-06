package com.freightcom.clickship.model.v2;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartShipmentRequest {
	@JsonProperty("shipment_ids")
	private List<String> shipmenIds;
	
	public List<String> getShipmenIds() {
		return shipmenIds;
	}

	public void setShipmenIds(List<String> shipmenIds) {
		this.shipmenIds = shipmenIds;
	}	
}
