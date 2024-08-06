
package com.freightcom.clickship.model.carrier.ups;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RateResponse implements Serializable {

	private static final long serialVersionUID = 7923306983353857516L;
	
    @JsonProperty("RatedShipment")
    private List<UpsQuote> quote;

	@JsonProperty("Response")
    private UpsResponse response;
	
    public List<UpsQuote> getQuote() {
		return quote;
	}

	public void setQuote(List<UpsQuote> quote) {
		this.quote = quote;
	}

	public UpsResponse getResponse() {
		return response;
	}

	public void setResponse(UpsResponse response) {
		this.response = response;
	}


}
