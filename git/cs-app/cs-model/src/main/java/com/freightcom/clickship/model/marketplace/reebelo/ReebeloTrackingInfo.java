package com.freightcom.clickship.model.marketplace.reebelo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReebeloTrackingInfo implements Serializable {

	private static final long serialVersionUID = -1693661095755170148L;

	@JsonProperty("url")
	private String trackingUrl;
	
	@JsonProperty("number")
	private String trackingNumber;
	
	@JsonProperty("company")
	private String trackingCompany;

	public String getTrackingUrl() {
		return trackingUrl;
	}

	public ReebeloTrackingInfo setTrackingUrl(String trackingUrl) {
		this.trackingUrl = trackingUrl;
		return this;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public ReebeloTrackingInfo setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
		return this;
	}

	public String getTrackingCompany() {
		return trackingCompany;
	}

	public ReebeloTrackingInfo setTrackingCompany(String trackingCompany) {
		this.trackingCompany = trackingCompany;
		return this;
	}

}
