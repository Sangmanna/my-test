package com.freightcom.clickship.model.marketplace.reebelo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReebeloLineItemDiscount implements Serializable {

	private static final long serialVersionUID = 8798537963340400342L;
	
	@JsonProperty("amount")
	private double amount;
	
	@JsonProperty("discount_application_index")
	private int discountIndex;
	
	@JsonProperty("amount_set")
	private ReebeloPrice amountSet;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getDiscountIndex() {
		return discountIndex;
	}

	public void setDiscountIndex(int discountIndex) {
		this.discountIndex = discountIndex;
	}

	public ReebeloPrice getAmountSet() {
		return amountSet;
	}

	public void setAmountSet(ReebeloPrice amountSet) {
		this.amountSet = amountSet;
	}

}
