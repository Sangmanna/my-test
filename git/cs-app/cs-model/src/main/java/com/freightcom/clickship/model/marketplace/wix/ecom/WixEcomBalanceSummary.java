package com.freightcom.clickship.model.marketplace.wix.ecom;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WixEcomBalanceSummary {

	@JsonProperty("balance")
	private WixEcomAmount balance;

	@JsonProperty("paid")
	private WixEcomAmount paid;

	@JsonProperty("refunded")
	private WixEcomAmount refunded;

	public WixEcomAmount getBalance() {
		return balance;
	}

	public void setBalance(WixEcomAmount balance) {
		this.balance = balance;
	}

	public WixEcomAmount getPaid() {
		return paid;
	}

	public void setPaid(WixEcomAmount paid) {
		this.paid = paid;
	}

	public WixEcomAmount getRefunded() {
		return refunded;
	}

	public void setRefunded(WixEcomAmount refunded) {
		this.refunded = refunded;
	}
}
