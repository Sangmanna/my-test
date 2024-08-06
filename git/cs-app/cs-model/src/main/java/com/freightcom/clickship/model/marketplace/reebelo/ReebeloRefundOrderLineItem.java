package com.freightcom.clickship.model.marketplace.reebelo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReebeloRefundOrderLineItem implements Serializable {

	private static final long serialVersionUID = 1448364393080757894L;

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("quantity")
	private int quantity;
	
	@JsonProperty("line_item_id")
	private Long lineItemId;
	
	@JsonProperty("location_id")
	private Long locationId;
	
	@JsonProperty("line_item")
	private ReebeloOrderLineItem lineItem;

	public Long getId() {
		return id;
	}

	public ReebeloRefundOrderLineItem setId(Long id) {
		this.id = id;
		return this;
	}

	public int getQuantity() {
		return quantity;
	}

	public ReebeloRefundOrderLineItem setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}

	public Long getLineItemId() {
		return lineItemId;
	}

	public ReebeloRefundOrderLineItem setLineItemId(Long lineItemId) {
		this.lineItemId = lineItemId;
		return this;
	}

	public Long getLocationId() {
		return locationId;
	}

	public ReebeloRefundOrderLineItem setLocationId(Long locationId) {
		this.locationId = locationId;
		return this;
	}

	public ReebeloOrderLineItem getLineItem() {
		return lineItem;
	}

	public void setLineItem(ReebeloOrderLineItem lineItem) {
		this.lineItem = lineItem;
	}

}
