package com.freightcom.clickship.model.marketplace.shopify;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyGdprRequest implements Serializable {

	private static final long serialVersionUID = -1693661095755170148L;

	@JsonProperty("shop_id")
	private long shopId;
	
	@JsonProperty("shop_domain")
	private String url;
	
	@JsonProperty("customer")
	private ShopifyCustomer customer;
	
	@JsonProperty("orders_requested")
	private List<String> ordersRequested;
	
	@JsonProperty("orders_to_redact")
	private List<String> ordersToRedact;
	
	public long getShopId() {
		return shopId;
	}

	public void setShopId(long shopId) {
		this.shopId = shopId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ShopifyCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(ShopifyCustomer customer) {
		this.customer = customer;
	}

	public List<String> getOrdersRequested() {
		return ordersRequested;
	}

	public void setOrdersRequested(List<String> ordersRequested) {
		this.ordersRequested = ordersRequested;
	}

	public List<String> getOrdersToRedact() {
		return ordersToRedact;
	}

	public void setOrdersToRedact(List<String> ordersToRedact) {
		this.ordersToRedact = ordersToRedact;
	}
	
}
