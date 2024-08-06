package com.freightcom.clickship.model.marketplace.bigcommerce;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BigCommerceOrderline {

	@JsonProperty("id")
	private Integer id;
	
	@JsonProperty("order_id")
	private Integer orderId;
	
	@JsonProperty("product_id")
	private Integer productId;
	
	@JsonProperty("order_product_id")
	private Integer orderProductId;
	
	@JsonProperty("variant_id")
	private Integer variantId;
	
	@JsonProperty("order_address_id")
	private Integer orderAddressId;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("sku")
	private String sku;
	
	@JsonProperty("quantity")
	private Integer quantity;
	
	@JsonProperty("base_price")
	private String basePrice;
	
	@JsonProperty("base_total")
	private String baseTotal;
	
	@JsonProperty("type")
	private String type;

	public Integer getId() {
		return id;
	}

	public BigCommerceOrderline setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public BigCommerceOrderline setOrderId(Integer orderId) {
		this.orderId = orderId;
		return this;
	}

	public Integer getProductId() {
		return productId;
	}

	public BigCommerceOrderline setProductId(Integer productId) {
		this.productId = productId;
		return this;
	}

	public Integer getOrderProductId() {
		return orderProductId;
	}

	public BigCommerceOrderline setOrderProductId(Integer orderProductId) {
		this.orderProductId = orderProductId;
		return this;
	}
	
	public Integer getVariantId() {
		return variantId;
	}

	public BigCommerceOrderline setVariantId(Integer variantId) {
		this.variantId = variantId;
		return this;
	}

	public Integer getOrderAddressId() {
		return orderAddressId;
	}

	public BigCommerceOrderline setOrderAddressId(Integer orderAddressId) {
		this.orderAddressId = orderAddressId;
		return this;
	}

	public String getName() {
		return name;
	}

	public BigCommerceOrderline setName(String name) {
		this.name = name;
		return this;
	}

	public String getSku() {
		return sku;
	}

	public BigCommerceOrderline setSku(String sku) {
		this.sku = sku;
		return this;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public BigCommerceOrderline setQuantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}

	public String getBasePrice() {
		return basePrice;
	}

	public BigCommerceOrderline setBasePrice(String basePrice) {
		this.basePrice = basePrice;
		return this;
	}

	public String getBaseTotal() {
		return baseTotal;
	}

	public BigCommerceOrderline setBaseTotal(String baseTotal) {
		this.baseTotal = baseTotal;
		return this;
	}

	public String getType() {
		return type;
	}

	public BigCommerceOrderline setType(String type) {
		this.type = type;
		return this;
	}

}
