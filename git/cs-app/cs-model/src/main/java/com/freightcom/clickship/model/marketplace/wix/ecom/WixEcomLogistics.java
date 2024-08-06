package com.freightcom.clickship.model.marketplace.wix.ecom;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WixEcomLogistics {

	@JsonProperty("shippingDestination")
	private WixEcomShippingDestination shippingDestination;

	public WixEcomShippingDestination getShippingDestination() {
		return shippingDestination;
	}

	public void setShippingDestination(WixEcomShippingDestination shippingDestination) {
		this.shippingDestination = shippingDestination;
	}

}
