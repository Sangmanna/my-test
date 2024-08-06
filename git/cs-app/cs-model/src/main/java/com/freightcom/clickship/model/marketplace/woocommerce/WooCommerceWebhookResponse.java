package com.freightcom.clickship.model.marketplace.woocommerce;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WooCommerceWebhookResponse {
	
	private String id;
	
	private String name;
	
	private String topic;
	
	private String event;
	
	private String status;
	
	private String resource;
	
	@JsonProperty("delivery_url")
	private String deliveryUrl;
	
	private List<String> hooks;

	public String getId() {
		return id;
	}

	public WooCommerceWebhookResponse setId(String id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public WooCommerceWebhookResponse setName(String name) {
		this.name = name;
		return this;
	}

	public String getTopic() {
		return topic;
	}

	public WooCommerceWebhookResponse setTopic(String topic) {
		this.topic = topic;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public WooCommerceWebhookResponse setStatus(String status) {
		this.status = status;
		return this;
	}

	public String getResource() {
		return resource;
	}

	public WooCommerceWebhookResponse setResource(String resource) {
		this.resource = resource;
		return this;
	}

	public String getEvent() {
		return event;
	}

	public WooCommerceWebhookResponse setEvent(String event) {
		this.event = event;
		return this;
	}

	public List<String> getHooks() {
		return hooks;
	}

	public WooCommerceWebhookResponse setHooks(List<String> hooks) {
		this.hooks = hooks;
		return this;
	}

	public String getDeliveryUrl() {
		return deliveryUrl;
	}

	public WooCommerceWebhookResponse setDeliveryUrl(String deliveryUrl) {
		this.deliveryUrl = deliveryUrl;
		return this;
	}
}
