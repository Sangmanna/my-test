package com.freightcom.clickship.model.carrier.freightcom.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FCAccountIds {

	@JsonProperty("CAD")
	private String cad;
	
	@JsonProperty("USD")
	private String usd;

	public String getCad() {
		return cad;
	}

	public FCAccountIds setCad(String cad) {
		this.cad = cad;
		return this;
	}

	public String getUsd() {
		return usd;
	}

	public FCAccountIds setUsd(String usd) {
		this.usd = usd;
		return this;
	}
	
}
