package com.freightcom.clickship.model.marketplace.shopify;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyOrderShippingCost implements Serializable {

	private static final long serialVersionUID = 6371954214122569730L;

	@JsonProperty("shop_money")
	private ShopifyPrice cost;

	public ShopifyPrice getCost() {
		return cost;
	}

	public void setCost(ShopifyPrice cost) {
		this.cost = cost;
	}
	
}
