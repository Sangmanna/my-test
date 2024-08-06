package com.freightcom.clickship.model.carrier.ups;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpsRestRequest implements Serializable {
	
	private static final long serialVersionUID = 6848095225396978272L;
	
	@JsonProperty("Security")
	private UPSSecurity security;

	@JsonProperty("RateRequest")
    private UpsRateRequest rateRequest;
	
	@JsonProperty("TimeInTransitRequest")
	private TimeInTransitRequest transitRequest;
	
	public UPSSecurity getSecurity() {
		return security;
	}

	public UpsRestRequest setSecurity(UPSSecurity security) {
		this.security = security;
		return this;
	}

	public UpsRateRequest getRateRequest() {
		return rateRequest;
	}

	public UpsRestRequest setRateRequest(UpsRateRequest rateRequest) {
		this.rateRequest = rateRequest;
		return this;
	}

	public TimeInTransitRequest getTransitRequest() {
		return transitRequest;
	}

	public UpsRestRequest setTransitRequest(TimeInTransitRequest transitRequest) {
		this.transitRequest = transitRequest;
		return this;
	}

}
