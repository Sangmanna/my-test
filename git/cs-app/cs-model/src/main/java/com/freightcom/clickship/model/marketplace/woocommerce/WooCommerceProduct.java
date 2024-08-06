package com.freightcom.clickship.model.marketplace.woocommerce;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WooCommerceProduct implements Serializable {
	
	private static final long serialVersionUID = -112272062605169286L;

	private Long id;
	
	@JsonProperty("parent_id")
	private Long parentId;
	
	private String sku;
	
	private String name;
	
	private String slug;
	
	private String type;
	
	private double price;
	
	private double weight;
	
	private String status;
	
	private boolean featured;
	
	private String description;
	
	@JsonProperty("sale_price")
	private double salePrice;
	
	@JsonProperty("regular_price")
	private double regularPrice;
	
	private List<Long> variations;
	
	private List<WooCommerceImages> images;
	
	@JsonProperty("meta_data")
	private List<WooCommerceMetadata> metadata;
	
	private WooCommerceProductDimesions dimensions;

	public Long getId() {
		return id;
	}

	public WooCommerceProduct setId(Long id) {
		this.id = id;
		return this;
	}
	
	public Long getParentId() {
		return parentId;
	}

	public WooCommerceProduct setParentId(Long parentId) {
		this.parentId = parentId;
		return this;
	}

	public String getName() {
		return name;
	}

	public WooCommerceProduct setName(String name) {
		this.name = name;
		return this;
	}

	public String getSlug() {
		return slug;
	}

	public WooCommerceProduct setSlug(String slug) {
		this.slug = slug;
		return this;
	}

	public String getType() {
		return type;
	}

	public WooCommerceProduct setType(String type) {
		this.type = type;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public WooCommerceProduct setStatus(String status) {
		this.status = status;
		return this;
	}

	public boolean isFeatured() {
		return featured;
	}

	public WooCommerceProduct setFeatured(boolean featured) {
		this.featured = featured;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public WooCommerceProduct setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getSku() {
		return sku;
	}

	public WooCommerceProduct setSku(String sku) {
		this.sku = sku;
		return this;
	}

	public Double getPrice() {
		return price;
	}

	public WooCommerceProduct setPrice(double price) {
		this.price = price;
		return this;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public WooCommerceProduct setSalePrice(double salePrice) {
		this.salePrice = salePrice;
		return this;
	}

	public Double getRegularPrice() {
		return regularPrice;
	}

	public WooCommerceProduct setRegularPrice(double regularPrice) {
		this.regularPrice = regularPrice;
		return this;
	}

	public Double getWeight() {
		return weight;
	}

	public WooCommerceProduct setWeight(double weight) {
		this.weight = weight;
		return this;
	}

	public WooCommerceProductDimesions getDimensions() {
		return dimensions;
	}

	public WooCommerceProduct setDimensions(WooCommerceProductDimesions dimensions) {
		this.dimensions = dimensions;
		return this;
	}

	public List<WooCommerceImages> getImages() {
		return images;
	}

	public WooCommerceProduct setImages(List<WooCommerceImages> images) {
		this.images = images;
		return this;
	}

	public List<Long> getVariations() {
		return variations;
	}

	public WooCommerceProduct setVariations(List<Long> variations) {
		this.variations = variations;
		return this;
	}

	public List<WooCommerceMetadata> getMetadata() {
		return metadata;
	}

	public WooCommerceProduct setMetadata(List<WooCommerceMetadata> metadata) {
		this.metadata = metadata;
		return this;
	}
}

