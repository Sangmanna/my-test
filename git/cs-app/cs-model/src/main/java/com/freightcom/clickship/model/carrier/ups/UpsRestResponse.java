package com.freightcom.clickship.model.carrier.ups;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpsRestResponse implements Serializable {
	
	private static final long serialVersionUID = 1983643488543064540L;

	@JsonProperty("response")
    private UpsResponse response;
	
	@JsonProperty("RateResponse")
    private RateResponse rateResponse;
	
	@JsonProperty("trackResponse")
    private UpsTrackingResponse trackResponse;
	
	@JsonProperty("TimeInTransitResponse")
    private TimeInTransitResponse timeInTransitResponse;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    
    public RateResponse getRateResponse() {
		return rateResponse;
	}

	public void setRateResponse(RateResponse rateResponse) {
		this.rateResponse = rateResponse;
	}

	public UpsResponse getResponse() {
		return response;
	}

	public void setResponse(UpsResponse response) {
		this.response = response;
	}
	
	public UpsTrackingResponse getTrackResponse() {
		return trackResponse;
	}

	public void setTrackResponse(UpsTrackingResponse trackResponse) {
		this.trackResponse = trackResponse;
	}

	public TimeInTransitResponse getTimeInTransitResponse() {
		return timeInTransitResponse;
	}

	public void setTimeInTransitResponse(TimeInTransitResponse timeInTransitResponse) {
		this.timeInTransitResponse = timeInTransitResponse;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
