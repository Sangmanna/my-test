package com.freightcom.clickship.model.marketplace.bestbuy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BestBuyShipmentLines {

	@JsonProperty("offer_sku")
	private String offerSku;
	
	@JsonProperty("order_line_id")
	private String orderLineId;
	
	@JsonProperty("quantity")
	private int quantity;

	public String getOfferSku() {
		return offerSku;
	}

	public void setOfferSku(String offerSku) {
		this.offerSku = offerSku;
	}

	public String getOrderLineId() {
		return orderLineId;
	}

	public void setOrderLineId(String orderLineId) {
		this.orderLineId = orderLineId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
