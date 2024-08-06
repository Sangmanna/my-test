package com.freightcom.clickship.model.marketplace.etsy.v3;

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
	private EtsyPrice price;

	@JsonProperty("quantity")
	private long quantity;

	@JsonProperty("is_enabled")
	private boolean enabled;

	@JsonProperty("is_deleted")
	private boolean deleted;

	public Long getOfferingId() {
		return offeringId;
	}

	public void setOfferingId(Long offeringId) {
		this.offeringId = offeringId;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
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

	public EtsyPrice getPrice() {
		return price;
	}

	public void setPrice(EtsyPrice price) {
		this.price = price;
	}
	
}
