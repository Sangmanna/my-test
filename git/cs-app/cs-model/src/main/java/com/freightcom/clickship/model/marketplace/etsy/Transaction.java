package com.freightcom.clickship.model.marketplace.etsy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction implements Serializable {

	private static final long serialVersionUID = -8689576063630572708L;

	@JsonProperty("transaction_id")
	private Long transactionId;

	@JsonProperty("title")
	private String title;

	@JsonProperty("description")
	private String description;

	@JsonProperty("seller_user_id")
	private Long sellerUserId;

	@JsonProperty("buyer_user_id")
	private Long buyerUserId;

	@JsonProperty("creation_tsz")
	private Float creationTsz;

	@JsonProperty("paid_tsz")
	private Float paidTsz;

	@JsonProperty("shipped_tsz")
	private Float shippedTsz;

	@JsonProperty("price")
	private Float price;

	@JsonProperty("currency_code")
	private String currencyCode;

	@JsonProperty("quantity")
	private Integer quantity;

	@JsonProperty("tags")
	private ArrayList<String> tags;

	@JsonProperty("materials")
	private ArrayList<String> materials;

	@JsonProperty("image_listing_id")
	private Long imageListingId;

	@JsonProperty("receipt_id")
	private Long receiptId;

	@JsonProperty("shipping_cost")
	private Float shippingCost;

	@JsonProperty("is_digital")
	private Boolean isDigital;

	@JsonProperty("file_data")
	private String fileData;

	@JsonProperty("listing_id")
	private Long listingId;

	@JsonProperty("is_quick_sale")
	private Boolean isQuickSale;

	@JsonProperty("seller_feedback_id")
	private Long sellerFeedbackId;

	@JsonProperty("buyer_feedback_id")
	private Long buyerFeedbackId;

	@JsonProperty("transaction_type")
	private String transactionType;

	@JsonProperty("url")
	private String url;

	@JsonProperty("variations")
	private ArrayList<ListingInventory> variations;

	@JsonProperty("product_data")
	private ListingProduct listingProduct;

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getSellerUserId() {
		return sellerUserId;
	}

	public void setSellerUserId(Long sellerUserId) {
		this.sellerUserId = sellerUserId;
	}

	public Long getBuyerUserId() {
		return buyerUserId;
	}

	public void setBuyerUserId(Long buyerUserId) {
		this.buyerUserId = buyerUserId;
	}

	public Float getCreationTsz() {
		return creationTsz;
	}

	public void setCreationTsz(Float creationTsz) {
		this.creationTsz = creationTsz;
	}

	public Float getPaidTsz() {
		return paidTsz;
	}

	public void setPaidTsz(Float paidTsz) {
		this.paidTsz = paidTsz;
	}

	public Float getShippedTsz() {
		return shippedTsz;
	}

	public void setShippedTsz(Float shippedTsz) {
		this.shippedTsz = shippedTsz;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public ArrayList<String> getTags() {
		return tags;
	}

	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}

	public ArrayList<String> getMaterials() {
		return materials;
	}

	public void setMaterials(ArrayList<String> materials) {
		this.materials = materials;
	}

	public Long getImageListingId() {
		return imageListingId;
	}

	public void setImageListingId(Long imageListingId) {
		this.imageListingId = imageListingId;
	}

	public Long getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(Long receiptId) {
		this.receiptId = receiptId;
	}

	public Float getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(Float shippingCost) {
		this.shippingCost = shippingCost;
	}

	public Boolean getDigital() {
		return isDigital;
	}

	public void setDigital(Boolean digital) {
		isDigital = digital;
	}

	public String getFileData() {
		return fileData;
	}

	public void setFileData(String fileData) {
		this.fileData = fileData;
	}

	public Long getListingId() {
		return listingId;
	}

	public void setListingId(Long listingId) {
		this.listingId = listingId;
	}

	public Boolean getQuickSale() {
		return isQuickSale;
	}

	public void setQuickSale(Boolean quickSale) {
		isQuickSale = quickSale;
	}

	public Long getSellerFeedbackId() {
		return sellerFeedbackId;
	}

	public void setSellerFeedbackId(Long sellerFeedbackId) {
		this.sellerFeedbackId = sellerFeedbackId;
	}

	public Long getBuyerFeedbackId() {
		return buyerFeedbackId;
	}

	public void setBuyerFeedbackId(Long buyerFeedbackId) {
		this.buyerFeedbackId = buyerFeedbackId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ArrayList<ListingInventory> getVariations() {
		return variations;
	}

	public void setVariations(ArrayList<ListingInventory> variations) {
		this.variations = variations;
	}

	public ListingProduct getListingProduct() {
		return listingProduct;
	}

	public void setListingProduct(ListingProduct listingProduct) {
		this.listingProduct = listingProduct;
	}
}
