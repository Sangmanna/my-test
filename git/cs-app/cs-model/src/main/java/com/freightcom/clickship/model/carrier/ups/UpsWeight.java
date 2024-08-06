package com.freightcom.clickship.model.carrier.ups;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpsWeight implements Serializable {

	private static final long serialVersionUID = 8088974130280225421L;

	@JsonProperty("Weight")
	private String weight;

	@JsonProperty("UnitOfMeasurement")
	private CodeDescription description;
	
	public String getWeight() {
		return weight;
	}

	public UpsWeight setWeight(String weight) {
		this.weight = weight;
		return this;
	}

	public CodeDescription getDescription() {
		return description;
	}

	public UpsWeight setDescription(CodeDescription description) {
		this.description = description;
		return this;
	}
	
	@JsonIgnore
	public Double getDoubleWeight() {
		return weight != null ? Double.parseDouble(weight) : 0.0;
	}
}
