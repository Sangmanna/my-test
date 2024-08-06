package com.freightcom.clickship.model.carrier.ups.trackingDetail;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpsPackage implements Serializable {

	private static final long serialVersionUID = -55378186319086128L;

	@JsonProperty("trackingNumber")
	private String trackingNumber;

	@JsonProperty("activity")
	private List<UpsTrackingActivity> tracking;

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public List<UpsTrackingActivity> getTracking() {
		return tracking;
	}

	public void setTracking(List<UpsTrackingActivity> tracking) {
		this.tracking = tracking;
	}
}
