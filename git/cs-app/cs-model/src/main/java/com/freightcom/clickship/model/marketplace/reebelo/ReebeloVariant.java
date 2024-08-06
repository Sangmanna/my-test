package com.freightcom.clickship.model.marketplace.reebelo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReebeloVariant implements Serializable {

	private static final long serialVersionUID = -7954916562892290995L;
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("product_id")
	private Long productId;
	
	@JsonProperty("image_id")
	private Long imageId;
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("price")
	private double price;
	
	@JsonProperty("sku")
	private String sku;
	
	@JsonProperty("weight")
	private double weight;
	
	@JsonProperty("weight_unit")
	private String weightUnit;
	
	@JsonProperty("inventory_quantity")
	private double quantity;
	
	@JsonProperty("inventory_item_id")
	private Long inventoryItemId;
	
	@JsonProperty("old_inventory_quantity")
	private Long oldQuantity;
	
	@JsonProperty("requires_shipping")
	private boolean requiresShipping;
	
	@JsonProperty("created_at")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date createdDate;
	
	@JsonProperty("updated_at")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date updatedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getWeightUnit() {
		return weightUnit;
	}

	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Long getInventoryItemId() {
		return inventoryItemId;
	}

	public void setInventoryItemId(Long inventoryItemId) {
		this.inventoryItemId = inventoryItemId;
	}

	public Long getOldQuantity() {
		return oldQuantity;
	}

	public void setOldQuantity(Long oldQuantity) {
		this.oldQuantity = oldQuantity;
	}

	public boolean isRequiresShipping() {
		return requiresShipping;
	}

	public void setRequiresShipping(boolean requiresShipping) {
		this.requiresShipping = requiresShipping;
	}
	
}
