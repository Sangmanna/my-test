package com.freightcom.clickship.model.marketplace.wix;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WixPriceData {

	@JsonProperty("currency")
	private String currency;

	@JsonProperty("price")
	private Double price;

	@JsonProperty("totalPrice")
	private Double totalPrice;

	@JsonProperty("discountedPrice")
	private Double discountedPrice;

	@JsonProperty("pricePerUnit")
	private Double pricePerUnit;

	@JsonProperty("taxIncludedInPrice")
	private Boolean taxIncludedInPrice;

	public String getCurrency() {
		return currency;
	}

	public WixPriceData setCurrency(String currency) {
		this.currency = currency;
		return this;
	}

	public Double getPrice() {
		return price;
	}

	public WixPriceData setPrice(Double price) {
		this.price = price;
		return this;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public WixPriceData setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
		return this;
	}

	public Double getDiscountedPrice() {
		return discountedPrice;
	}

	public WixPriceData setDiscountedPrice(Double discountedPrice) {
		this.discountedPrice = discountedPrice;
		return this;
	}

	public Double getPricePerUnit() {
		return pricePerUnit;
	}

	public WixPriceData setPricePerUnit(Double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
		return this;
	}

	public Boolean getTaxIncludedInPrice() {
		return taxIncludedInPrice;
	}

	public WixPriceData setTaxIncludedInPrice(Boolean taxIncludedInPrice) {
		this.taxIncludedInPrice = taxIncludedInPrice;
		return this;
	}

}
