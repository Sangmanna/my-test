package com.freightcom.clickship.model.marketplace.woocommerce;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WooCommerceWebhookRequest {
	
	private String name;
	
	private String topic;
	
	@JsonProperty("delivery_url")
	private String deliveryUrl;
	
	
	public WooCommerceWebhookRequest(String name, String topic, String deliveryUrl) {
		super();
		this.name = name;
		this.topic = topic;
		this.deliveryUrl = deliveryUrl;
	}

	public String getName() {
		return name;
	}

	public WooCommerceWebhookRequest setName(String name) {
		this.name = name;
		return this;
	}

	public String getTopic() {
		return topic;
	}

	public WooCommerceWebhookRequest setTopic(String topic) {
		this.topic = topic;
		return this;
	}

	public String getDeliveryUrl() {
		return deliveryUrl;
	}

	public WooCommerceWebhookRequest setDeliveryUrl(String deliveryUrl) {
		this.deliveryUrl = deliveryUrl;
		return this;
	}

}
