package com.freightcom.clickship.model.marketplace.etsy.v3;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EtsyPrice implements Serializable {

	private static final long serialVersionUID = -7613463971762132021L;

	@JsonProperty("amount")
	private int amount;

	@JsonProperty("divisor")
	private int divisor;

	@JsonProperty("currency_code")
	private String currencyCode;

	public int getAmount() {
		return amount;
	}

	public EtsyPrice setAmount(int amount) {
		this.amount = amount;
		return this;
	}

	public int getDivisor() {
		return divisor;
	}

	public EtsyPrice setDivisor(int divisor) {
		this.divisor = divisor;
		return this;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public EtsyPrice setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
		return this;
	}	
	
}
