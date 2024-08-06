package com.freightcom.clickship.model.carrier.ups;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestOption implements Serializable {
	
	private static final long serialVersionUID = -8412544807113894254L;

	@JsonProperty("RequestOption")
	private String requestOption;

	public String getRequestOption() {
		return requestOption;
	}

	public RequestOption setRequestOption(String requestOption) {
		this.requestOption = requestOption;
		return this;
	}
	
}
