package com.freightcom.clickship.model.marketplace.wix.ecom;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WixEcomTaxDetails {

	@JsonProperty("taxableAmount")
	private WixEcomAmount taxableAmount;

	@JsonProperty("taxRate")
	private String taxRate;

	@JsonProperty("totalTax")
	private WixEcomAmount totalTax;

	public WixEcomAmount getTaxableAmount() {
		return taxableAmount;
	}

	public void setTaxableAmount(WixEcomAmount taxableAmount) {
		this.taxableAmount = taxableAmount;
	}

	public String getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(String taxRate) {
		this.taxRate = taxRate;
	}

	public WixEcomAmount getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(WixEcomAmount totalTax) {
		this.totalTax = totalTax;
	}

}
