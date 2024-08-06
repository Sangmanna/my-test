package com.freightcom.clickship.model.marketplace.shopify;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyFulfillmentV2_ implements Serializable {

	private static final long serialVersionUID = 1837934404166301624L;

	@JsonProperty("fulfillment")
	private ShopifyFulfillmentV2 fulfillment;
	
	public ShopifyFulfillmentV2_() {
		super();
	}

	public ShopifyFulfillmentV2_(ShopifyFulfillmentV2 fulfillment) {
		super();
		this.fulfillment = fulfillment;
	}

	public ShopifyFulfillmentV2 getFulfillment() {
		return fulfillment;
	}

	public void setFulfillment(ShopifyFulfillmentV2 fulfillment) {
		this.fulfillment = fulfillment;
	}

}
