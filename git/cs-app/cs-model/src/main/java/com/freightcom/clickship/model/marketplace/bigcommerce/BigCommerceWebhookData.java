package com.freightcom.clickship.model.marketplace.bigcommerce;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BigCommerceWebhookData {

	@JsonProperty("id")
	private long id;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("orderId")
	private long orderId;	
	
	@JsonProperty("sku")
	private BigCommerceWebhookDataDetails sku;
	
	@JsonProperty("status")
	private BigCommerceWebhookDataDetails status;
	
	@JsonProperty("refund")
	private BigCommerceWebhookDataDetails refund;
	
	@JsonProperty("message")
	private BigCommerceWebhookDataDetails message;
	
	@JsonProperty("inventory")
	private BigCommerceWebhookDataDetails inventory;
	
	public long getId() {
		return id;
	}

	public BigCommerceWebhookData setId(long id) {
		this.id = id;
		return this;
	}

	public String getType() {
		return type;
	}

	public BigCommerceWebhookData setType(String type) {
		this.type = type;
		return this;
	}

	public long getOrderId() {
		return orderId;
	}

	public BigCommerceWebhookData setOrderId(long orderId) {
		this.orderId = orderId;
		return this;
	}

	public BigCommerceWebhookDataDetails getSku() {
		return sku;
	}

	public BigCommerceWebhookData setSku(BigCommerceWebhookDataDetails sku) {
		this.sku = sku;
		return this;
	}

	public BigCommerceWebhookDataDetails getStatus() {
		return status;
	}

	public BigCommerceWebhookData setStatus(BigCommerceWebhookDataDetails status) {
		this.status = status;
		return this;
	}

	public BigCommerceWebhookDataDetails getRefund() {
		return refund;
	}

	public BigCommerceWebhookData setRefund(BigCommerceWebhookDataDetails refund) {
		this.refund = refund;
		return this;
	}

	public BigCommerceWebhookDataDetails getMessage() {
		return message;
	}

	public BigCommerceWebhookData setMessage(BigCommerceWebhookDataDetails message) {
		this.message = message;
		return this;
	}

	public BigCommerceWebhookDataDetails getInventory() {
		return inventory;
	}

	public BigCommerceWebhookData setInventory(BigCommerceWebhookDataDetails inventory) {
		this.inventory = inventory;
		return this;
	}
	
	@JsonIgnore
	public String getIdStr() {
		return Long.toString(id);
	}
	
	@JsonIgnore
	public String getOrderIdStr() {
		return Long.toString(orderId);
	}

}