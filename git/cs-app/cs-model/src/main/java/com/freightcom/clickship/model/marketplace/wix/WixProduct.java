package com.freightcom.clickship.model.marketplace.wix;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WixProduct {

	@JsonProperty("id")
	private String id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("slug")
	private String slug;

	@JsonProperty("visible")
	private boolean visible = false;

	@JsonProperty("productType")
	private String productType;

	@JsonProperty("description")
	private String description;

	@JsonProperty("sku")
	private String sku;

	@JsonProperty("weight")
	private Double weight;
	
	@JsonProperty("price")
	private WixPriceData price;

	@JsonProperty("priceData")
	private WixPriceData priceData;

	@JsonProperty("convertedPriceData")
	private WixPriceData convertedPriceData;
	
	@JsonProperty("pricePerUnitData")
	private WixPricePerUnitData pricePerUnitData;

	@JsonProperty("media")
	private WixMedia media;
	
	@JsonProperty("manageVariants")
	private Boolean manageVariants;
	
	@JsonProperty("numericId")
	private String numericId;
	
	@JsonProperty("inventoryItemId")
	private String inventoryItemId;

	@JsonProperty("discount")
	private WixDiscount discount;
	
	@JsonProperty("variants")
	private List<WixVariants> variants;
	
	// webhooks fields
	@JsonProperty("productId")
	private String productId;
	
	@JsonProperty("changedFields")
	private List<String> changedFields;

	public String getId() {
		return id;
	}

	public WixProduct setId(String id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public WixProduct setName(String name) {
		this.name = name;
		return this;
	}

	public String getSlug() {
		return slug;
	}

	public WixProduct setSlug(String slug) {
		this.slug = slug;
		return this;
	}

	public boolean isVisible() {
		return visible;
	}

	public WixProduct setVisible(boolean visible) {
		this.visible = visible;
		return this;
	}

	public String getProductType() {
		return productType;
	}

	public WixProduct setProductType(String productType) {
		this.productType = productType;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public WixProduct setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getSku() {
		return sku;
	}

	public WixProduct setSku(String sku) {
		this.sku = sku;
		return this;
	}

	public Double getWeight() {
		return weight;
	}

	public WixProduct setWeight(Double weight) {
		this.weight = weight;
		return this;
	}

	public WixPriceData getPriceData() {
		return priceData;
	}

	public WixProduct setPriceData(WixPriceData priceData) {
		this.priceData = priceData;
		return this;
	}

	public WixPriceData getConvertedPriceData() {
		return convertedPriceData;
	}

	public WixProduct setConvertedPriceData(WixPriceData convertedPriceData) {
		this.convertedPriceData = convertedPriceData;
		return this;
	}

	public WixMedia getMedia() {
		return media;
	}

	public WixProduct setMedia(WixMedia media) {
		this.media = media;
		return this;
	}
	
	public Boolean getManageVariants() {
		return manageVariants;
	}

	public WixProduct setManageVariants(Boolean manageVariants) {
		this.manageVariants = manageVariants;
		return this;
	}
	
	public List<WixVariants> getVariants() {
		return variants;
	}

	public WixProduct setVariants(List<WixVariants> variants) {
		this.variants = variants;
		return this;
	}

	public WixPricePerUnitData getPricePerUnitData() {
		return pricePerUnitData;
	}

	public WixProduct setPricePerUnitData(WixPricePerUnitData pricePerUnitData) {
		this.pricePerUnitData = pricePerUnitData;
		return this;
	}

	public String getInventoryItemId() {
		return inventoryItemId;
	}

	public WixProduct setInventoryItemId(String inventoryItemId) {
		this.inventoryItemId = inventoryItemId;
		return this;
	}

	public WixDiscount getDiscount() {
		return discount;
	}

	public WixProduct setDiscount(WixDiscount discount) {
		this.discount = discount;
		return this;
	}

	public String getNumericId() {
		return numericId;
	}

	public WixProduct setNumericId(String numericId) {
		this.numericId = numericId;
		return this;
	}

	public String getProductId() {
		return productId;
	}

	public WixProduct setProductId(String productId) {
		this.productId = productId;
		return this;
	}

	public WixPriceData getPrice() {
		return price;
	}

	public WixProduct setPrice(WixPriceData price) {
		this.price = price;
		return this;
	}

	public List<String> getChangedFields() {
		return changedFields;
	}

	public WixProduct setChangedFields(List<String> changedFields) {
		this.changedFields = changedFields;
		return this;
	}
}
