package com.freightcom.clickship.model.marketplace.reebelo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReebeloOrderShippingCost implements Serializable {

	private static final long serialVersionUID = 6371954214122569730L;

	@JsonProperty("shop_money")
	private ReebeloPrice cost;

	public ReebeloPrice getCost() {
		return cost;
	}

	public void setCost(ReebeloPrice cost) {
		this.cost = cost;
	}
	
}
