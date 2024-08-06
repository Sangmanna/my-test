package com.freightcom.clickship.model.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuoteShipment {

	@JsonProperty("service_id")
	private String serviceId;
	
	@JsonProperty("rate_request_id")
	private String rateRequestId;
	
	@JsonProperty("order_source")
	private String orderSource;

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getRateRequestId() {
		return rateRequestId;
	}

	public void setRateRequestId(String rateRequestId) {
		this.rateRequestId = rateRequestId;
	}

	public String getOrderSource() {
		return orderSource;
	}

	public void setOrderSource(String orderSource) {
		this.orderSource = orderSource;
	}	
}
