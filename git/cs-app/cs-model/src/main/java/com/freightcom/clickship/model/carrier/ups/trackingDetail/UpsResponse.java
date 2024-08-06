
package com.freightcom.clickship.model.carrier.ups.trackingDetail;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpsResponse implements Serializable {
	private static final long serialVersionUID = 7339651178365302926L;
	
	@JsonProperty("trackResponse")
	private UpsTrackingResponse trackResponse;

	public UpsTrackingResponse getTrackResponse() {
		return trackResponse;
	}

	public void setTrackResponse(UpsTrackingResponse trackResponse) {
		this.trackResponse = trackResponse;
	}
}
