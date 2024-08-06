package com.freightcom.clickship.model.carrier.ups;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryConfirmation implements Serializable {

	private static final long serialVersionUID = 3209847428382783858L;

	@JsonProperty("DCISType")
	private String dCISType;

	public String getDCISType() {
		return dCISType;
	}

	public DeliveryConfirmation setDCISType(String dCISType) {
		this.dCISType = dCISType;
		return this;
	}

}
