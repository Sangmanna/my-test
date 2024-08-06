package com.freightcom.clickship.model.marketplace.bestbuy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BestBuyShipmentErrors {

	@JsonProperty("message")
	private String message;
	
	@JsonProperty("order_id")
	private String orderId;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	@Override
	public String toString() {
		return "BestBuyShipmentErrors [message=" + message + ", orderId=" + orderId + "]";
	}
}
