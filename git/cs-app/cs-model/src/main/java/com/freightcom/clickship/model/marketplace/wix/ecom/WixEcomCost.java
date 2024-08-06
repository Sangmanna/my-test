package com.freightcom.clickship.model.marketplace.wix.ecom;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WixEcomCost {

	@JsonProperty("price")
	private WixEcomAmount price;

	@JsonProperty("totalPriceBeforeTax")
	private WixEcomAmount totalPriceBeforeTax;

	@JsonProperty("totalPriceAfterTax")
	private WixEcomAmount totalPriceAfterTax;

	@JsonProperty("taxDetails")
	private WixEcomTaxDetails taxDetails;

	@JsonProperty("discount")
	private WixEcomAmount discount;

	public WixEcomAmount getPrice() {
		return price;
	}

	public void setPrice(WixEcomAmount price) {
		this.price = price;
	}

	public WixEcomAmount getTotalPriceBeforeTax() {
		return totalPriceBeforeTax;
	}

	public void setTotalPriceBeforeTax(WixEcomAmount totalPriceBeforeTax) {
		this.totalPriceBeforeTax = totalPriceBeforeTax;
	}

	public WixEcomAmount getTotalPriceAfterTax() {
		return totalPriceAfterTax;
	}

	public void setTotalPriceAfterTax(WixEcomAmount totalPriceAfterTax) {
		this.totalPriceAfterTax = totalPriceAfterTax;
	}

	public WixEcomTaxDetails getTaxDetails() {
		return taxDetails;
	}

	public void setTaxDetails(WixEcomTaxDetails taxDetails) {
		this.taxDetails = taxDetails;
	}

	public WixEcomAmount getDiscount() {
		return discount;
	}

	public void setDiscount(WixEcomAmount discount) {
		this.discount = discount;
	}
}
