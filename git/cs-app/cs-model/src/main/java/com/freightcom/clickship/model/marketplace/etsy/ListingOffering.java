package com.freightcom.clickship.model.marketplace.etsy;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListingOffering implements Serializable {

	private static final long serialVersionUID = -2463599942490142485L;

	@JsonProperty("offering_id")
	private Long offeringId;

	@JsonProperty("price")
	private Money money;

	@JsonProperty("quantity")
	private int quantity;

	@JsonProperty("isEnabled")
	private boolean enabled;

	@JsonProperty("isDeleted")
	private boolean deleted;

	public Long getOfferingId() {
		return offeringId;
	}

	public void setOfferingId(Long offeringId) {
		this.offeringId = offeringId;
	}

	public Money getMoney() {
		return money;
	}

	public void setMoney(Money money) {
		this.money = money;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}
