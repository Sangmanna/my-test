package com.freightcom.clickship.model.marketplace.reverb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
public class ReverbProductAmount {
	@JsonProperty("amount")
	private String amount;
	@JsonProperty("amount_cents")
	private String amountCents;
	@JsonProperty("currency")
	private String currency;
	@JsonProperty("symbol")
	private String symbol;
	@JsonProperty("display")
	private String display;
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getAmountCents() {
		return amountCents;
	}
	public void setAmountCents(String amountCents) {
		this.amountCents = amountCents;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	
}
