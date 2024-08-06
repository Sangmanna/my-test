package com.freightcom.clickship.model.marketplace.shopify;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyTax implements Serializable {

	private static final long serialVersionUID = 8565628927163668560L;
	
	// Title of TAX type
	@JsonProperty("title")
	private String type;
	
	// Tax percentage
	@JsonProperty("rate")
	private double rate;
	
	@JsonProperty("price")
	private double totalTax;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(double totalTax) {
		this.totalTax = totalTax;
	}

}
