package com.freightcom.clickship.model.marketplace.wix;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WixTrackingInfo {

	@JsonProperty("shippingProvider")
	private String shippingProvider;

	@JsonProperty("trackingNumber")
	private String trackingNumber;

	@JsonProperty("trackingLink")
	private String trackingLink;

	public String getShippingProvider() {
		return shippingProvider;
	}

	public WixTrackingInfo setShippingProvider(String shippingProvider) {
		this.shippingProvider = shippingProvider;
		return this;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public WixTrackingInfo setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
		return this;
	}

	public String getTrackingLink() {
		return trackingLink;
	}

	public WixTrackingInfo setTrackingLink(String trackingLink) {
		this.trackingLink = trackingLink;
		return this;
	}
}
