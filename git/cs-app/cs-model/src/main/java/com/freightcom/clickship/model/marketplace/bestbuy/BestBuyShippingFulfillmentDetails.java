package com.freightcom.clickship.model.marketplace.bestbuy;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BestBuyShippingFulfillmentDetails {
	
	@JsonProperty("shipments")
	private List<BestBuyShipments> shipments;

	public List<BestBuyShipments> getShipments() {
		return shipments;
	}

	public void setShipments(List<BestBuyShipments> shipments) {
		this.shipments = shipments;
	}	
}
