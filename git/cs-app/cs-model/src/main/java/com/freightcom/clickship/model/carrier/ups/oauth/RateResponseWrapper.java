package com.freightcom.clickship.model.carrier.ups.oauth;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RateResponseWrapper implements Serializable {

	private static final long serialVersionUID = -2231120660079035193L;

	@JsonProperty("RateResponse")
	private RateResponse rateResponse;

	public RateResponse getRateResponse() {
		return rateResponse;
	}

	public void setRateResponse(RateResponse rateResponse) {
		this.rateResponse = rateResponse;
	}
}