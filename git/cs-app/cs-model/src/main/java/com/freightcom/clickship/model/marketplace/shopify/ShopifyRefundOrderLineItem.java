package com.freightcom.clickship.model.marketplace.shopify;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyRefundOrderLineItem implements Serializable {

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
	private ShopifyOrderLineItem lineItem;

	public Long getId() {
		return id;
	}

	public ShopifyRefundOrderLineItem setId(Long id) {
		this.id = id;
		return this;
	}

	public int getQuantity() {
		return quantity;
	}

	public ShopifyRefundOrderLineItem setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}

	public Long getLineItemId() {
		return lineItemId;
	}

	public ShopifyRefundOrderLineItem setLineItemId(Long lineItemId) {
		this.lineItemId = lineItemId;
		return this;
	}

	public Long getLocationId() {
		return locationId;
	}

	public ShopifyRefundOrderLineItem setLocationId(Long locationId) {
		this.locationId = locationId;
		return this;
	}

	public ShopifyOrderLineItem getLineItem() {
		return lineItem;
	}

	public ShopifyRefundOrderLineItem setLineItem(ShopifyOrderLineItem lineItem) {
		this.lineItem = lineItem;
		return this;
	}
	
}
