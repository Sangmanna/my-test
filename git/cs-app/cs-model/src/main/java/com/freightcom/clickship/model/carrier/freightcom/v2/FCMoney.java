package com.freightcom.clickship.model.carrier.freightcom.v2;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FCMoney implements Serializable {

	private static final long serialVersionUID = -6845082647588303673L;

	@JsonProperty("currency")
	private String currency;

	@JsonProperty("value")
	private String value;
	
	public FCMoney() {
		super();
	}

	public FCMoney(String currency, String value) {
		super();
		this.currency = currency;
		this.value = value;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
