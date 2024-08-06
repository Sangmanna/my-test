package com.freightcom.clickship.model.carrier.freightcom.v2;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FCV2Error implements Serializable {

	private static final long serialVersionUID = 8337518816202560814L;

	@JsonProperty("message")
	private String message = "";

	@JsonProperty("data")
	private Map<String, String> data = new HashMap<>();
	
	@JsonProperty("status")
	private String status = "";
	
	@JsonProperty("error")
	private String error = "";
	
	public String getMessage() {
		return message;
	}

	public FCV2Error setMessage(String message) {
		this.message = message;
		return this;
	}

	public Map<String, String> getData() {
		return data;
	}

	public FCV2Error setData(Map<String, String> data) {
		this.data = data;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public FCV2Error setStatus(String status) {
		this.status = status;
		return this;
	}

	public String getError() {
		return error;
	}

	public FCV2Error setError(String error) {
		this.error = error;
		return this;
	}
	
}