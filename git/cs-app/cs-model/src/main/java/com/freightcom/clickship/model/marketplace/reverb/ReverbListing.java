package com.freightcom.clickship.model.marketplace.reverb;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
public class ReverbListing {
	@JsonProperty("id")
	private String id;
	@JsonProperty("make")
	private String make;
	@JsonProperty("model")
	private String model;
	@JsonProperty("finish")
	private String finish;
	@JsonProperty("year")
	private String year;
	@JsonProperty("title")
	private String title;
	@JsonProperty("created_at")
	private String createdAt;
	@JsonProperty("shop_name")
	private String shopName;
	@JsonProperty("description")
	private String description;
//	@JsonProperty("condition")
//	private String condition;
	@JsonProperty("condition_uuid")
	private String conditionUuid;
	@JsonProperty("condition_slug")
	private String conditionSlug;
	@JsonProperty("price")
	private ReverbProductAmount price;
	@JsonProperty("inventory")
	private String inventory;
	@JsonProperty("has_inventory")
	private boolean hasInventory;
	@JsonProperty("offers_enabled")
	private boolean offersEnabled;
	@JsonProperty("auction")
	private boolean auction;
	@JsonProperty("category_uuids")
	private String[] categoryUuids;
	@JsonProperty("listing_currency")
	private String listingCurrency;
	@JsonProperty("published_at")
	private String publishedAt;
	@JsonProperty("sku")
	private String sku;
	@JsonProperty("slug")
	private String slug;
	@JsonProperty("buyer_price")
	private ReverbListingBuyerPrice buyerPrice;
	@JsonProperty("seller_price")
	private ReverbProductAmount sellerPrice;
	@JsonProperty("state")
	private ReverbProductState state;
	@JsonProperty("shipping")
	private ReverbProductShipping shipping;
	@JsonProperty("stats")
	private ReverbProductStats stats;
	@JsonProperty("photos")
	private List<ReverbProductPhotos> photos;
	
	
	public List<ReverbProductPhotos> getPhotos() {
		return photos;
	}
	public void setPhotos(List<ReverbProductPhotos> photos) {
		this.photos = photos;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getFinish() {
		return finish;
	}
	public void setFinish(String finish) {
		this.finish = finish;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
//	public String getCondition() {
//		return condition;
//	}
//	public void setCondition(String condition) {
//		this.condition = condition;
//	}
	public String getConditionUuid() {
		return conditionUuid;
	}
	public void setConditionUuid(String conditionUuid) {
		this.conditionUuid = conditionUuid;
	}
	public String getConditionSlug() {
		return conditionSlug;
	}
	public void setConditionSlug(String conditionSlug) {
		this.conditionSlug = conditionSlug;
	}
	public ReverbProductAmount getPrice() {
		return price;
	}
	public void setPrice(ReverbProductAmount price) {
		this.price = price;
	}
	public String getInventory() {
		return inventory;
	}
	public void setInventory(String inventory) {
		this.inventory = inventory;
	}
	public boolean isHasInventory() {
		return hasInventory;
	}
	public void setHasInventory(boolean hasInventory) {
		this.hasInventory = hasInventory;
	}
	public boolean isOffersEnabled() {
		return offersEnabled;
	}
	public void setOffersEnabled(boolean offersEnabled) {
		this.offersEnabled = offersEnabled;
	}
	public boolean isAuction() {
		return auction;
	}
	public void setAuction(boolean auction) {
		this.auction = auction;
	}
	public String[] getCategoryUuids() {
		return categoryUuids;
	}
	public void setCategoryUuids(String[] categoryUuids) {
		this.categoryUuids = categoryUuids;
	}
	public String getListingCurrency() {
		return listingCurrency;
	}
	public void setListingCurrency(String listingCurrency) {
		this.listingCurrency = listingCurrency;
	}
	public String getPublishedAt() {
		return publishedAt;
	}
	public void setPublishedAt(String publishedAt) {
		this.publishedAt = publishedAt;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public ReverbListingBuyerPrice getBuyerPrice() {
		return buyerPrice;
	}
	public void setBuyerPrice(ReverbListingBuyerPrice buyerPrice) {
		this.buyerPrice = buyerPrice;
	}
	public ReverbProductAmount getSellerPrice() {
		return sellerPrice;
	}
	public void setSellerPrice(ReverbProductAmount sellerPrice) {
		this.sellerPrice = sellerPrice;
	}
	public ReverbProductState getState() {
		return state;
	}
	public void setState(ReverbProductState state) {
		this.state = state;
	}
	public ReverbProductShipping getShipping() {
		return shipping;
	}
	public void setShipping(ReverbProductShipping shipping) {
		this.shipping = shipping;
	}
	public ReverbProductStats getStats() {
		return stats;
	}
	public void setStats(ReverbProductStats stats) {
		this.stats = stats;
	}
	
}
