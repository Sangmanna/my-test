package com.freightcom.clickship.model.marketplace.bigcommerce;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BigCommerceShippingMethodSetting implements Serializable {
	
	private static final long serialVersionUID = -6029421444016620450L;

	@JsonProperty("carrier_options")
	private BigCommerceCarrierOptions carrierOptions;
	
	public BigCommerceShippingMethodSetting() {
		super();
	}

	public BigCommerceShippingMethodSetting(BigCommerceCarrierOptions carrierOptions) {
		super();
		this.carrierOptions = carrierOptions;
	}

	public BigCommerceCarrierOptions getCarrierOptions() {
		return carrierOptions;
	}

	public BigCommerceShippingMethodSetting setCarrierOptions(BigCommerceCarrierOptions carrierOptions) {
		this.carrierOptions = carrierOptions;
		return this;
	}
	
}
