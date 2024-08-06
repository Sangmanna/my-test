package com.freightcom.clickship.model.marketplace.etsy.v3;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EtsyListing extends EtsyBaseDTO {

	private static final long serialVersionUID = 4580838793888292313L;

	@JsonProperty("listing_id")
	private Long listingId;
	
	@JsonProperty("user_id")
	private Long userId;
	
	@JsonProperty("shop_id")
	private Long shopId;
	
	@JsonProperty("title")
	private String title;

	@JsonProperty("description")	
	private String description;

	@JsonProperty("state")
	private String state;
	
	@JsonProperty("quantity")
	private Integer quantity;

	@JsonProperty("price")
	private EtsyPrice price;

	@JsonProperty("item_weight")
	private double weight;

	@JsonProperty("item_weight_unit")
	private String weightUnit;

	@JsonProperty("item_length")
	private double length;

	@JsonProperty("item_width")
	private double width;

	@JsonProperty("item_height")
	private double height;

	@JsonProperty("item_dimensions_unit")
	private String dimensionsUnit;

	@JsonProperty("tags")
	private ArrayList<String> tags;

	@JsonProperty("sku")
	private ArrayList<String> skus;

	@JsonProperty("url")
	private String url;

	@JsonProperty("has_variations")
	private Boolean hasVariations;
	
	@JsonProperty("images")
	private List<EtsyListingImage> images;
	
	@JsonProperty("inventory")
	private EtsyListingInventory inventory;

	public Long getListingId() {
		return listingId;
	}

	public EtsyListing setListingId(Long listingId) {
		this.listingId = listingId;
		return this;
	}

	public Long getUserId() {
		return userId;
	}

	public EtsyListing setUserId(Long userId) {
		this.userId = userId;
		return this;
	}

	public Long getShopId() {
		return shopId;
	}

	public EtsyListing setShopId(Long shopId) {
		this.shopId = shopId;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public EtsyListing setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public EtsyListing setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getState() {
		return state;
	}

	public EtsyListing setState(String state) {
		this.state = state;
		return this;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public EtsyListing setQuantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}

	public EtsyPrice getPrice() {
		return price;
	}

	public EtsyListing setPrice(EtsyPrice price) {
		this.price = price;
		return this;
	}

	public double getWeight() {
		return weight;
	}

	public EtsyListing setWeight(double weight) {
		this.weight = weight;
		return this;
	}

	public String getWeightUnit() {
		return weightUnit;
	}

	public EtsyListing setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
		return this;
	}

	public double getLength() {
		return length;
	}

	public EtsyListing setLength(double length) {
		this.length = length;
		return this;
	}

	public double getWidth() {
		return width;
	}

	public EtsyListing setWidth(double width) {
		this.width = width;
		return this;
	}

	public double getHeight() {
		return height;
	}

	public EtsyListing setHeight(double height) {
		this.height = height;
		return this;
	}

	public String getDimensionsUnit() {
		return dimensionsUnit;
	}

	public EtsyListing setDimensionsUnit(String dimensionsUnit) {
		this.dimensionsUnit = dimensionsUnit;
		return this;
	}

	public ArrayList<String> getTags() {
		return tags;
	}

	public EtsyListing setTags(ArrayList<String> tags) {
		this.tags = tags;
		return this;
	}

	public ArrayList<String> getSkus() {
		return skus;
	}

	public EtsyListing setSkus(ArrayList<String> skus) {
		this.skus = skus;
		return this;
	}

	public String getUrl() {
		return url;
	}

	public EtsyListing setUrl(String url) {
		this.url = url;
		return this;
	}

	public Boolean getHasVariations() {
		return hasVariations;
	}

	public EtsyListing setHasVariations(Boolean hasVariations) {
		this.hasVariations = hasVariations;
		return this;
	}

	public List<EtsyListingImage> getImages() {
		return images;
	}

	public EtsyListing setImages(List<EtsyListingImage> images) {
		this.images = images;
		return this;
	}

	public EtsyListingInventory getInventory() {
		return inventory;
	}

	public EtsyListing setInventory(EtsyListingInventory inventory) {
		this.inventory = inventory;
		return this;
	}
	
}
