
package com.freightcom.clickship.model.carrier.ups.trackingDetail;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpsTrackingLocation implements Serializable {

	private static final long serialVersionUID = -2897466305110457822L;

	@JsonProperty("address")
	private UpsTrackingAddress address;

	public UpsTrackingAddress getAddress() {
		return address;
	}

	public void setAddress(UpsTrackingAddress address) {
		this.address = address;
	}
}
