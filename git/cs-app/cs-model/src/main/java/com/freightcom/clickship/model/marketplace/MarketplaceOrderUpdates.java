package com.freightcom.clickship.model.marketplace;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketplaceOrderUpdates implements Serializable {

	private static final long serialVersionUID = 8254199177409807547L;

	@JsonProperty("action")
	private String action;
	
	@JsonProperty("sendEmail")
	private boolean sendEmail = false;
	
	@JsonProperty("marketplaceId")
	private String marketplaceId;
	
	@JsonProperty("orderIds")
	private List<String> orderIds;

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

	public List<String> getOrderIds() {
		return orderIds;
	}

	public void setOrderIds(List<String> orderIds) {
		this.orderIds = orderIds;
	}

}
