package com.freightcom.clickship.model.marketplace.wix.ecom;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WixEcomCancelOrderReq {

	@JsonProperty("customMessage")
	private String customMessage;

	@JsonProperty("restockAllItems")
	private Boolean restockAllItems;

	@JsonProperty("sendOrderCanceledEmail")
	private Boolean sendOrderCanceledEmail;

	public String getCustomMessage() {
		return customMessage;
	}

	public void setCustomMessage(String customMessage) {
		this.customMessage = customMessage;
	}

	public Boolean getRestockAllItems() {
		return restockAllItems;
	}

	public void setRestockAllItems(Boolean restockAllItems) {
		this.restockAllItems = restockAllItems;
	}

	public Boolean getSendOrderCanceledEmail() {
		return sendOrderCanceledEmail;
	}

	public void setSendOrderCanceledEmail(Boolean sendOrderCanceledEmail) {
		this.sendOrderCanceledEmail = sendOrderCanceledEmail;
	}
}
