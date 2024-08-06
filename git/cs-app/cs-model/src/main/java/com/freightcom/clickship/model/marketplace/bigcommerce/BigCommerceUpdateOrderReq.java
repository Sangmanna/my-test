package com.freightcom.clickship.model.marketplace.bigcommerce;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BigCommerceUpdateOrderReq {

	@JsonProperty("status")
	private String status;
	
	@JsonProperty("status_id")
	private int statusId;

	public String getStatus() {
		return status;
	}

	public BigCommerceUpdateOrderReq setStatus(String status) {
		this.status = status;
		return this;
	}

	public int getStatusId() {
		return statusId;
	}

	public BigCommerceUpdateOrderReq setStatusId(int statusId) {
		this.statusId = statusId;
		return this;
	}
	
}
