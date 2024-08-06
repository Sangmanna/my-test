package com.freightcom.clickship.model.marketplace.etsy;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Money implements Serializable {

	private static final long serialVersionUID = -3224794337858284247L;

	@JsonProperty("amount")
	private int amount;

	@JsonProperty("divisor")
	private int divisor;

	@JsonProperty("currency_code")
	private String currencyCode;

	@JsonProperty("currency_formatted_raw")
	private String formattedRaw;

	@JsonProperty("currency_formatted_short")
	private String formattedShort;

	@JsonProperty("currency_formatted_long")
	private String formattedLong;

	@JsonProperty("original_currency_code")
	private String originalCurrencyCode;

	@JsonProperty("before_conversion")
	private Money beforeConversion;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getDivisor() {
		return divisor;
	}

	public void setDivisor(int divisor) {
		this.divisor = divisor;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getFormattedRaw() {
		return formattedRaw;
	}

	public void setFormattedRaw(String formattedRaw) {
		this.formattedRaw = formattedRaw;
	}

	public String getFormattedShort() {
		return formattedShort;
	}

	public void setFormattedShort(String formattedShort) {
		this.formattedShort = formattedShort;
	}

	public String getFormattedLong() {
		return formattedLong;
	}

	public void setFormattedLong(String formattedLong) {
		this.formattedLong = formattedLong;
	}

	public String getOriginalCurrencyCode() {
		return originalCurrencyCode;
	}

	public void setOriginalCurrencyCode(String originalCurrencyCode) {
		this.originalCurrencyCode = originalCurrencyCode;
	}

	public Money getBeforeConversion() {
		return beforeConversion;
	}

	public void setBeforeConversion(Money beforeConversion) {
		this.beforeConversion = beforeConversion;
	}
}
