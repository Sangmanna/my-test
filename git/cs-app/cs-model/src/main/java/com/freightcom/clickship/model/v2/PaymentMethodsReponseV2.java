package com.freightcom.clickship.model.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentMethodsReponseV2 {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("customer_id")
	private String customerId;

	@JsonProperty("type")
	private String type;

	@JsonProperty("label")
	private String label;
	
	@JsonProperty("time_created")
	private String timeCreated;
	
	@JsonProperty("data")
	private PaymentMethodsPostRequestV2 data;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(String timeCreated) {
		this.timeCreated = timeCreated;
	}

	public PaymentMethodsPostRequestV2 getData() {
		return data;
	}

	public void setData(PaymentMethodsPostRequestV2 data) {
		this.data = data;
	}
	
}
