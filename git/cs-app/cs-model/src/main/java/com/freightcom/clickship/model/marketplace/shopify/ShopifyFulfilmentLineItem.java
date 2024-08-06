package com.freightcom.clickship.model.marketplace.shopify;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyFulfilmentLineItem implements Serializable {

	private static final long serialVersionUID = 1448364393080757894L;

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("quantity")
	private Integer quantity;
	
	@JsonProperty("fulfillment_order_id")
	private Long fulfillmentOrderId;
	
	@JsonProperty("fulfillment_order_line_items")
	private List<ShopifyFulfilmentLineItem> lineItemList = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public ShopifyFulfilmentLineItem setId(Long id) {
		this.id = id;
		return this;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public ShopifyFulfilmentLineItem setQuantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}

	public List<ShopifyFulfilmentLineItem> getLineItemList() {
		return lineItemList;
	}

	public void setLineItemList(List<ShopifyFulfilmentLineItem> lineItemList) {
		this.lineItemList = lineItemList;
	}
	
	public void addLineItemToList(ShopifyFulfilmentLineItem lineItem) {
		if(lineItemList == null) {
			lineItemList = new ArrayList<>();
		}
		
		lineItemList.add(lineItem);
	}

	public Long getFulfillmentOrderId() {
		return fulfillmentOrderId;
	}

	public void setFulfillmentOrderId(Long fulfillmentOrderId) {
		this.fulfillmentOrderId = fulfillmentOrderId;
	}
	
}
