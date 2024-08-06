package com.freightcom.clickship.model.carrier.ups;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpsProduct implements Serializable {

	private static final long serialVersionUID = -62650480365779189L;

	@JsonProperty("Description")
	private String description;

	@JsonProperty("OriginCountryCode")
	private String originCountryCode;

	@JsonProperty("Unit")
	private UpsWeight unit;

	public String getDescription() {
		return description;
	}

	public UpsProduct setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getOriginCountryCode() {
		return originCountryCode;
	}

	public UpsProduct setOriginCountryCode(String originCountryCode) {
		this.originCountryCode = originCountryCode;
		return this;
	}

	public UpsWeight getUnit() {
		return unit;
	}

	public UpsProduct setUnit(UpsWeight unit) {
		this.unit = unit;
		return this;
	}
}
