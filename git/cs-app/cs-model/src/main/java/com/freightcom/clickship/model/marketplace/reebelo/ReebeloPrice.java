package com.freightcom.clickship.model.marketplace.reebelo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReebeloPrice implements Serializable {

	private static final long serialVersionUID = -8596858379020614418L;
	
	@JsonProperty("amount")
	private double amount;
	
	@JsonProperty("currency_code")
	private String currency;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
