package com.freightcom.clickship.model.marketplace.wix.ecom;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WixEcomAmount {

	@JsonProperty("amount")
	private String amount;

	@JsonProperty("formattedAmount")
	private String formattedAmount;

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getFormattedAmount() {
		return formattedAmount;
	}

	public void setFormattedAmount(String formattedAmount) {
		this.formattedAmount = formattedAmount;
	}
}
