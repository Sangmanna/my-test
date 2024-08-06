package com.freightcom.clickship.model.marketplace.wix;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WixDiscount {

	@JsonProperty("type")
	private String type;

	@JsonProperty("value")
	private Double value;
	
	@JsonProperty("appliedCoupon")
	private WixAppliedCoupon appliedCoupon;
	
	public String getType() {
		return type;
	}

	public WixDiscount setType(String type) {
		this.type = type;
		return this;
	}

	public Double getValue() {
		return value;
	}

	public WixDiscount setValue(Double value) {
		this.value = value;
		return this;
	}

	public WixAppliedCoupon getAppliedCoupon() {
		return appliedCoupon;
	}

	public WixDiscount setAppliedCoupon(WixAppliedCoupon appliedCoupon) {
		this.appliedCoupon = appliedCoupon;
		return this;
	}
	
}
