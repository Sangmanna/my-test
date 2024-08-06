package com.freightcom.clickship.model.marketplace.lightspeed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LightSpeedCompany {

	@JsonProperty("name")
	private String name;

	@JsonProperty("resource")
	private LightSpeedResource resource;

	public String getName() {
		return name;
	}

	public LightSpeedCompany setName(String name) {
		this.name = name;
		return this;
	}

	public LightSpeedResource getResource() {
		return resource;
	}

	public LightSpeedCompany setResource(LightSpeedResource resource) {
		this.resource = resource;
		return this;
	}
}
