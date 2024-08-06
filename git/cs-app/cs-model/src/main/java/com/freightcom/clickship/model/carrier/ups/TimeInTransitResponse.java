
package com.freightcom.clickship.model.carrier.ups;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ "Response", "TransitResponse" })
public class TimeInTransitResponse implements Serializable {

	private static final long serialVersionUID = 6452912724697921792L;

	@JsonProperty("Response")
	private UpsResponse response;

	@JsonProperty("TransitResponse")
	private TransitResponse timeInTransit;

	public UpsResponse getResponse() {
		return response;
	}

	public void setResponse(UpsResponse response) {
		this.response = response;
	}

	public TransitResponse getTimeInTransit() {
		return timeInTransit;
	}

	public void setTimeInTransit(TransitResponse timeInTransit) {
		this.timeInTransit = timeInTransit;
	}

}
