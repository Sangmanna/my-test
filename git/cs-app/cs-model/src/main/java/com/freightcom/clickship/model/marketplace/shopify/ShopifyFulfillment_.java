package com.freightcom.clickship.model.marketplace.shopify;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyFulfillment_ implements Serializable {

	private static final long serialVersionUID = 1837934404166301624L;

	@JsonProperty("fulfillment")
	private ShopifyFulfillment fulfillment;
	
	public ShopifyFulfillment_() {
		super();
	}

	public ShopifyFulfillment_(ShopifyFulfillment fulfillment) {
		super();
		this.fulfillment = fulfillment;
	}

	public ShopifyFulfillment getFulfillment() {
		return fulfillment;
	}

	public void setFulfillment(ShopifyFulfillment fulfillment) {
		this.fulfillment = fulfillment;
	}

}
