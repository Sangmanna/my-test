package com.freightcom.clickship.model.marketplace.bigcommerce;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BigCommerceShipment extends BigCommerceCreateShipment {

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("order_id")
	private Long orderId;
	
	@JsonProperty("customer_id")
	private Long customerId;
	
	@JsonProperty("date_created")
	private String dateCreated;

	@JsonProperty("merchant_shipping_cost")
	private String merchantShippingCost;

	@JsonProperty("comments")
	private String comments;
	
	@JsonProperty("shipping_provider")
	private String shippingProvider;
	
	@JsonProperty("billing_address")
	private BigCommerceAddress billingAddress;
	
	@JsonProperty("shipping_addresses")
	private BigCommerceAddress shippingAddress;

	@JsonProperty("items")
	private List<BigCommerceOrderline> lineItems;

	public Long getId() {
		return id;
	}
	
	public String getIdStr() {
		return id != null ? id.toString() : null;
	}

	public BigCommerceShipment setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getOrderId() {
		return orderId;
	}

	public BigCommerceShipment setOrderId(Long orderId) {
		this.orderId = orderId;
		return this;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public BigCommerceShipment setCustomerId(Long customerId) {
		this.customerId = customerId;
		return this;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public BigCommerceShipment setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
		return this;
	}

	public String getMerchantShippingCost() {
		return merchantShippingCost;
	}

	public BigCommerceShipment setMerchantShippingCost(String merchantShippingCost) {
		this.merchantShippingCost = merchantShippingCost;
		return this;
	}

	public String getComments() {
		return comments;
	}

	public BigCommerceShipment setComments(String comments) {
		this.comments = comments;
		return this;
	}

	public String getShippingProvider() {
		return shippingProvider;
	}

	public BigCommerceShipment setShippingProvider(String shippingProvider) {
		this.shippingProvider = shippingProvider;
		return this;
	}

	public BigCommerceAddress getBillingAddress() {
		return billingAddress;
	}

	public BigCommerceShipment setBillingAddress(BigCommerceAddress billingAddress) {
		this.billingAddress = billingAddress;
		return this;
	}

	public BigCommerceAddress getShippingAddress() {
		return shippingAddress;
	}

	public BigCommerceShipment setShippingAddress(BigCommerceAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
		return this;
	}

	public List<BigCommerceOrderline> getLineItems() {
		return lineItems;
	}

	public BigCommerceShipment setLineItems(List<BigCommerceOrderline> lineItems) {
		this.lineItems = lineItems;
		return this;
	}

}
