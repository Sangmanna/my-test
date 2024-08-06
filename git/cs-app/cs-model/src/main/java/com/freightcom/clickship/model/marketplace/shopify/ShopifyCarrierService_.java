package com.freightcom.clickship.model.marketplace.shopify;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyCarrierService_ implements Serializable {

	private static final long serialVersionUID = -1603610328659115473L;

	@JsonProperty("carrier_service")
	private ShopifyCarrierService service;
	
	public ShopifyCarrierService_() {
		super();
	}

	public ShopifyCarrierService_(ShopifyCarrierService service) {
		super();
		this.service = service;
	}

	public ShopifyCarrierService getService() {
		return service;
	}

	public void setService(ShopifyCarrierService service) {
		this.service = service;
	}
	
}
