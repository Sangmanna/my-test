package com.freightcom.clickship.model.marketplace.bigcommerce;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BigCommerceWebhookDataDetails {

	@JsonProperty("previous_status_id")
	private String prevStatusId;
	
	@JsonProperty("new_status_id")
	private String newStatusId;
	
	@JsonProperty("order_message_id")
	private String orderMessageId;

	@JsonProperty("refund_id")
	private String refundId;
	
	@JsonProperty("product_id")
	private String productId;
	
	@JsonProperty("variant_id")
	private String variantId;
	
	@JsonProperty("order_id")
	private String orderId;
	
	@JsonProperty("method")
	private String method;
	
	@JsonProperty("value")
	private long inventoryQuantity;

	public String getPrevStatusId() {
		return prevStatusId;
	}

	public BigCommerceWebhookDataDetails setPrevStatusId(String prevStatusId) {
		this.prevStatusId = prevStatusId;
		return this;
	}

	public String getNewStatusId() {
		return newStatusId;
	}

	public BigCommerceWebhookDataDetails setNewStatusId(String newStatusId) {
		this.newStatusId = newStatusId;
		return this;
	}

	public String getOrderMessageId() {
		return orderMessageId;
	}

	public BigCommerceWebhookDataDetails setOrderMessageId(String orderMessageId) {
		this.orderMessageId = orderMessageId;
		return this;
	}

	public String getRefundId() {
		return refundId;
	}

	public BigCommerceWebhookDataDetails setRefundId(String refundId) {
		this.refundId = refundId;
		return this;
	}

	public String getProductId() {
		return productId;
	}

	public BigCommerceWebhookDataDetails setProductId(String productId) {
		this.productId = productId;
		return this;
	}

	public String getVariantId() {
		return variantId;
	}

	public BigCommerceWebhookDataDetails setVariantId(String variantId) {
		this.variantId = variantId;
		return this;
	}

	public String getOrderId() {
		return orderId;
	}

	public BigCommerceWebhookDataDetails setOrderId(String orderId) {
		this.orderId = orderId;
		return this;
	}

	public String getMethod() {
		return method;
	}

	public BigCommerceWebhookDataDetails setMethod(String method) {
		this.method = method;
		return this;
	}

	public long getInventoryQuantity() {
		return inventoryQuantity;
	}

	public BigCommerceWebhookDataDetails setInventoryQuantity(long inventoryQuantity) {
		this.inventoryQuantity = inventoryQuantity;
		return this;
	}
	
	@JsonIgnore
	public int getInventoryQuantityIntValue() {
		return (int) inventoryQuantity;
	}
	
}