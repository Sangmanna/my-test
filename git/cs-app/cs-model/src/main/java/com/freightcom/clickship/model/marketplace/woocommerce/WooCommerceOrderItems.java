package com.freightcom.clickship.model.marketplace.woocommerce;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WooCommerceOrderItems implements Serializable {
	
	private static final long serialVersionUID = 2409752132643642431L;

	private Long id;
	
	private String name;

	@JsonProperty("product_id")
	private Long productId;
	
	@JsonProperty("variation_id")
	private Long variationId;
	
	private Long quantity;
	
	private String subtotal;
	
	@JsonProperty("subtotal_tax")
	private String subtotalTax;
	
	private String total;
	
	@JsonProperty("total_tax")
	private String totalTax;
	
	private String sku;
	
	private String price;
	
	@JsonProperty("method_title")
	private String methodTitle;
	
	@JsonProperty("method_id")
	private String methodId;
	
	@JsonProperty("instance_id")
	private String instanceId;
	
	@JsonProperty("meta_data")
	private List<WooCommerceMetadata> metadata;

	public Long getId() {
		return id;
	}

	public WooCommerceOrderItems setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public WooCommerceOrderItems setName(String name) {
		this.name = name;
		return this;
	}

	public Long getProductId() {
		return productId;
	}

	public WooCommerceOrderItems setProductId(Long productId) {
		this.productId = productId;
		return this;
	}

	public Long getVariationId() {
		return variationId;
	}

	public WooCommerceOrderItems setVariationId(Long variationId) {
		this.variationId = variationId;
		return this;
	}

	public Long getQuantity() {
		return quantity;
	}

	public WooCommerceOrderItems setQuantity(Long quantity) {
		this.quantity = quantity;
		return this;
	}

	public String getSubtotal() {
		return subtotal;
	}

	public WooCommerceOrderItems setSubtotal(String subtotal) {
		this.subtotal = subtotal;
		return this;
	}

	public String getSubtotalTax() {
		return subtotalTax;
	}

	public WooCommerceOrderItems setSubtotalTax(String subtotalTax) {
		this.subtotalTax = subtotalTax;
		return this;
	}

	public String getTotal() {
		return total;
	}

	public WooCommerceOrderItems setTotal(String total) {
		this.total = total;
		return this;
	}

	public String getTotalTax() {
		return totalTax;
	}

	public WooCommerceOrderItems setTotalTax(String totalTax) {
		this.totalTax = totalTax;
		return this;
	}

	public String getSku() {
		return sku;
	}

	public WooCommerceOrderItems setSku(String sku) {
		this.sku = sku;
		return this;
	}

	public String getPrice() {
		return price;
	}

	public WooCommerceOrderItems setPrice(String price) {
		this.price = price;
		return this;
	}

	public String getMethodTitle() {
		return methodTitle;
	}

	public WooCommerceOrderItems setMethodTitle(String methodTitle) {
		this.methodTitle = methodTitle;
		return this;
	}

	public String getMethodId() {
		return methodId;
	}

	public WooCommerceOrderItems setMethodId(String methodId) {
		this.methodId = methodId;
		return this;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public WooCommerceOrderItems setInstanceId(String instanceId) {
		this.instanceId = instanceId;
		return this;
	}

	public List<WooCommerceMetadata> getMetadata() {
		return metadata;
	}

	public WooCommerceOrderItems setMetadata(List<WooCommerceMetadata> metadata) {
		this.metadata = metadata;
		return this;
	}
	
}