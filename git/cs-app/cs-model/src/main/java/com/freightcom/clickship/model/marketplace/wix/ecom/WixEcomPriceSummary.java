package com.freightcom.clickship.model.marketplace.wix.ecom;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WixEcomPriceSummary {

	@JsonProperty("subtotal")
	private WixEcomAmount subtotal;

	@JsonProperty("shipping")
	private WixEcomAmount shipping;

	@JsonProperty("tax")
	private WixEcomAmount tax;

	@JsonProperty("discount")
	private WixEcomAmount discount;

	@JsonProperty("total")
	private WixEcomAmount total;

	@JsonProperty("totalAdditionalFees")
	private WixEcomAmount totalAdditionalFees;

	public WixEcomAmount getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(WixEcomAmount subtotal) {
		this.subtotal = subtotal;
	}

	public WixEcomAmount getShipping() {
		return shipping;
	}

	public void setShipping(WixEcomAmount shipping) {
		this.shipping = shipping;
	}

	public WixEcomAmount getTax() {
		return tax;
	}

	public void setTax(WixEcomAmount tax) {
		this.tax = tax;
	}

	public WixEcomAmount getDiscount() {
		return discount;
	}

	public void setDiscount(WixEcomAmount discount) {
		this.discount = discount;
	}

	public WixEcomAmount getTotal() {
		return total;
	}

	public void setTotal(WixEcomAmount total) {
		this.total = total;
	}

	public WixEcomAmount getTotalAdditionalFees() {
		return totalAdditionalFees;
	}

	public void setTotalAdditionalFees(WixEcomAmount totalAdditionalFees) {
		this.totalAdditionalFees = totalAdditionalFees;
	}

}
