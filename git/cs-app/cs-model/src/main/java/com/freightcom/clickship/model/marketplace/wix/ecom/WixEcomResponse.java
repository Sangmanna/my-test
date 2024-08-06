package com.freightcom.clickship.model.marketplace.wix.ecom;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WixEcomResponse {

	@JsonProperty("orders")
	private List<WixEcomOrder> orders;

	@JsonProperty("order")
	private WixEcomOrder order;

	@JsonProperty("metadata")
	private WixEcomMetadata metadata;

	@JsonProperty("fulfillmentId")
	private String fulfillmentId;

	public List<WixEcomOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<WixEcomOrder> orders) {
		this.orders = orders;
	}

	public WixEcomOrder getOrder() {
		return order;
	}

	public void setOrder(WixEcomOrder order) {
		this.order = order;
	}

	public WixEcomMetadata getMetadata() {
		return metadata;
	}

	public void setMetadata(WixEcomMetadata metadata) {
		this.metadata = metadata;
	}

	public String getFulfillmentId() {
		return fulfillmentId;
	}

	public void setFulfillmentId(String fulfillmentId) {
		this.fulfillmentId = fulfillmentId;
	}

}
