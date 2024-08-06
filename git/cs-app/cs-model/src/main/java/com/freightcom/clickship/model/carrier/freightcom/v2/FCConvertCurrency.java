package com.freightcom.clickship.model.carrier.freightcom.v2;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FCConvertCurrency implements Serializable {

	private static final long serialVersionUID = -7600454169439859884L;

	@JsonProperty("amount")
	private FCMoney amount;

	@JsonProperty("to_currency")
	private String toCurrency;

	public FCMoney getAmount() {
		return amount;
	}

	public void setAmount(FCMoney amount) {
		this.amount = amount;
	}

	public String getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}

}
