package com.freightcom.clickship.model.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Distance {

	@JsonProperty("value")
	private String value;
	
	@JsonProperty("unit")
	private String unit;

	public String getValue() {
		return value;
	}

	public Distance setValue(String value) {
		this.value = value;
		return this;
	}

	public String getUnit() {
		return unit;
	}

	public Distance setUnit(String unit) {
		this.unit = unit;
		return this;
	}

}
