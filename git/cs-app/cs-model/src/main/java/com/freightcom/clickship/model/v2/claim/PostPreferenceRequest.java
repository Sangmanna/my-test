package com.freightcom.clickship.model.v2.claim;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostPreferenceRequest {
	
	private String value;

	public String getValue() {
		return value;
	}

	public PostPreferenceRequest setValue(String value) {
		this.value = value;
		return this;
	}
	
}
