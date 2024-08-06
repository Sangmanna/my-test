package com.freightcom.clickship.model.marketplace;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketplaceProductUpdates implements Serializable {

	private static final long serialVersionUID = 3530644083240021394L;

	@JsonProperty("action")
	private String action;
	
	@JsonProperty("sendEmail")
	private boolean sendEmail  = false;
	
	@JsonProperty("marketplaceId")
	private String marketplaceId;
	
	@JsonProperty("productIds")
	private List<String> productIds;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	public boolean isSendEmail() {
		return sendEmail;
	}

	public void setSendEmail(boolean sendEmail) {
		this.sendEmail = sendEmail;
	}

	public String getMarketplaceId() {
		return marketplaceId;
	}

	public void setMarketplaceId(String marketplaceId) {
		this.marketplaceId = marketplaceId;
	}

	public List<String> getProductIds() {
		return productIds;
	}

	public void setProductIds(List<String> productIds) {
		this.productIds = productIds;
	}
	
}
