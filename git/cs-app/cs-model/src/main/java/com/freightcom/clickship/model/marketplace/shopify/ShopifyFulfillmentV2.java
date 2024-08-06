package com.freightcom.clickship.model.marketplace.shopify;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyFulfillmentV2 implements Serializable {

	private static final long serialVersionUID = -1693661095755170148L;
	
	@JsonProperty("id")
	private long id;
	
	@JsonProperty("notify_customer")
	private boolean notifyCustomer = true;
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("tracking_info")
	private ShopifyTrackingInfo trackingInfo;

	@JsonProperty("line_items_by_fulfillment_order")
	private List<ShopifyFulfilmentLineItem> lineItmes = new ArrayList<>();;

	public long getId() {
		return id;
	}

	public ShopifyFulfillmentV2 setId(long id) {
		this.id = id;
		return this;
	}

	public boolean isNotifyCustomer() {
		return notifyCustomer;
	}

	public ShopifyFulfillmentV2 setNotifyCustomer(boolean notifyCustomer) {
		this.notifyCustomer = notifyCustomer;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public ShopifyFulfillmentV2 setMessage(String message) {
		this.message = message;
		return this;
	}

	public ShopifyTrackingInfo getTrackingInfo() {
		return trackingInfo;
	}

	public ShopifyFulfillmentV2 setTrackingInfo(ShopifyTrackingInfo trackingInfo) {
		this.trackingInfo = trackingInfo;
		return this;
	}

	public List<ShopifyFulfilmentLineItem> getLineItmes() {
		return lineItmes;
	}

	public ShopifyFulfillmentV2 setLineItmes(List<ShopifyFulfilmentLineItem> lineItmes) {
		this.lineItmes = lineItmes;
		return this;
	}
	
	public void addLineItemToList(ShopifyFulfilmentLineItem lineItem) {
		if(lineItmes == null) {
			lineItmes = new ArrayList<>();
		}
		
		lineItmes.add(lineItem);
	}

}
