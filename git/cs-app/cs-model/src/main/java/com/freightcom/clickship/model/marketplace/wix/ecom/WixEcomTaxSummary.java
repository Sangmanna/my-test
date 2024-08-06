package com.freightcom.clickship.model.marketplace.wix.ecom;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WixEcomTaxSummary {

	@JsonProperty("totalTax")
	private WixEcomAmount totalTax;

	public WixEcomAmount getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(WixEcomAmount totalTax) {
		this.totalTax = totalTax;
	}

}
