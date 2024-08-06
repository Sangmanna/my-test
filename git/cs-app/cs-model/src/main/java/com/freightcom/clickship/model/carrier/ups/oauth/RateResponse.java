
package com.freightcom.clickship.model.carrier.ups.oauth;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.freightcom.clickship.model.carrier.ups.UpsQuote;
import com.freightcom.clickship.model.carrier.ups.UpsResponse;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RateResponse implements Serializable {

	private static final long serialVersionUID = 7923306983353857516L;
	
    @JsonProperty("RatedShipment")
    private UpsQuote quote;

	@JsonProperty("Response")
    private UpsResponse response;
	
    public UpsQuote getQuote() {
		return quote;
	}

	public void setQuote(UpsQuote quote) {
		this.quote = quote;
	}

	public UpsResponse getResponse() {
		return response;
	}

	public void setResponse(UpsResponse response) {
		this.response = response;
	}


}
