package com.freightcom.clickship.model.marketplace.bestbuy;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BestBuyShipmentResponse {

	@JsonProperty("shipment_success")
	private List<BestBuyShipmentSuccess> shipmentSuccess;
	
	@JsonProperty("shipment_errors")
	private List<BestBuyShipmentErrors> shipmentErrors;


	public List<BestBuyShipmentErrors> getShipmentErrors() {
		return shipmentErrors;
	}

	public void setShipmentErrors(List<BestBuyShipmentErrors> shipmentErrors) {
		this.shipmentErrors = shipmentErrors;
	}

	public List<BestBuyShipmentSuccess> getShipmentSuccess() {
		return shipmentSuccess;
	}

	public void setShipmentSuccess(List<BestBuyShipmentSuccess> shipmentSuccess) {
		this.shipmentSuccess = shipmentSuccess;
	}
}
