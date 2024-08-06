package com.freightcom.clickship.model.marketplace.etsy.v3;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EtsyReceiptTransaction implements Serializable {

	private static final long serialVersionUID = -7330817970071905904L;

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

	@JsonProperty("create_timestamp")
	private Long createTimestamp;
	
	@JsonProperty("created_timestamp")
	private Long createdTimestamp;
	
	@JsonProperty("paid_timestamp")
	private Long paidTimestamp;
	
	@JsonProperty("shipped_timestamp")
	private Long shippedTimestamp;

	@JsonProperty("quantity")
	private Integer quantity;

	@JsonProperty("listing_image_id")
	private Long listingImageId;

	@JsonProperty("receipt_id")
	private Long receiptId;

	@JsonProperty("is_digital")
	private Boolean isDigital;

	@JsonProperty("file_data")
	private String fileData;

	@JsonProperty("listing_id")
	private Long listingId;
	
	@JsonProperty("sku")
	private String sku;
	
	@JsonProperty("product_id")
	private Long productId;

	@JsonProperty("transaction_type")
	private String transactionType;
	
	@JsonProperty("price")
	private EtsyPrice price;
	
	@JsonProperty("shipping_cost")
	private EtsyPrice shippingCost;
	
	@JsonProperty("shipping_profile_id")
	private Long shippingProfileId;
	
	@JsonProperty("min_processing_days")
	private Integer minProcessingDays;
	
	@JsonProperty("max_processing_days")
	private Integer maxProcessingDays;
	
	@JsonProperty("expected_ship_date")
	private Long expectedShipDate;
	
	@JsonProperty("buyer_coupon")
	private Integer buyerCoupon;
	
	@JsonProperty("shop_coupon")
	private Integer shopCoupon;
	
	@JsonProperty("shipping_method")
	private String shippingMethod;
	
	@JsonProperty("shipping_upgrade")
	private String shippingUpgrade;

	public Long getTransactionId() {
		return transactionId;
	}

	public EtsyReceiptTransaction setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public EtsyReceiptTransaction setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public EtsyReceiptTransaction setDescription(String description) {
		this.description = description;
		return this;
	}

	public Long getSellerUserId() {
		return sellerUserId;
	}

	public EtsyReceiptTransaction setSellerUserId(Long sellerUserId) {
		this.sellerUserId = sellerUserId;
		return this;
	}

	public Long getBuyerUserId() {
		return buyerUserId;
	}

	public EtsyReceiptTransaction setBuyerUserId(Long buyerUserId) {
		this.buyerUserId = buyerUserId;
		return this;
	}

	public Long getCreateTimestamp() {
		return createTimestamp;
	}

	public EtsyReceiptTransaction setCreateTimestamp(Long createTimestamp) {
		this.createTimestamp = createTimestamp;
		return this;
	}

	public Long getCreatedTimestamp() {
		return createdTimestamp;
	}

	public EtsyReceiptTransaction setCreatedTimestamp(Long createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
		return this;
	}

	public Long getPaidTimestamp() {
		return paidTimestamp;
	}

	public EtsyReceiptTransaction setPaidTimestamp(Long paidTimestamp) {
		this.paidTimestamp = paidTimestamp;
		return this;
	}

	public Long getShippedTimestamp() {
		return shippedTimestamp;
	}

	public EtsyReceiptTransaction setShippedTimestamp(Long shippedTimestamp) {
		this.shippedTimestamp = shippedTimestamp;
		return this;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public EtsyReceiptTransaction setQuantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}

	public Long getListingImageId() {
		return listingImageId;
	}

	public EtsyReceiptTransaction setListingImageId(Long listingImageId) {
		this.listingImageId = listingImageId;
		return this;
	}

	public Long getReceiptId() {
		return receiptId;
	}

	public EtsyReceiptTransaction setReceiptId(Long receiptId) {
		this.receiptId = receiptId;
		return this;
	}

	public Boolean getIsDigital() {
		return isDigital;
	}

	public EtsyReceiptTransaction setIsDigital(Boolean isDigital) {
		this.isDigital = isDigital;
		return this;
	}

	public String getFileData() {
		return fileData;
	}

	public EtsyReceiptTransaction setFileData(String fileData) {
		this.fileData = fileData;
		return this;
	}

	public Long getListingId() {
		return listingId;
	}

	public EtsyReceiptTransaction setListingId(Long listingId) {
		this.listingId = listingId;
		return this;
	}

	public String getSku() {
		return sku;
	}

	public EtsyReceiptTransaction setSku(String sku) {
		this.sku = sku;
		return this;
	}

	public Long getProductId() {
		return productId;
	}

	public EtsyReceiptTransaction setProductId(Long productId) {
		this.productId = productId;
		return this;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public EtsyReceiptTransaction setTransactionType(String transactionType) {
		this.transactionType = transactionType;
		return this;
	}

	public EtsyPrice getPrice() {
		return price;
	}

	public EtsyReceiptTransaction setPrice(EtsyPrice price) {
		this.price = price;
		return this;
	}

	public EtsyPrice getShippingCost() {
		return shippingCost;
	}

	public EtsyReceiptTransaction setShippingCost(EtsyPrice shippingCost) {
		this.shippingCost = shippingCost;
		return this;
	}

	public Long getShippingProfileId() {
		return shippingProfileId;
	}

	public EtsyReceiptTransaction setShippingProfileId(Long shippingProfileId) {
		this.shippingProfileId = shippingProfileId;
		return this;
	}

	public Integer getMinProcessingDays() {
		return minProcessingDays;
	}

	public EtsyReceiptTransaction setMinProcessingDays(Integer minProcessingDays) {
		this.minProcessingDays = minProcessingDays;
		return this;
	}

	public Integer getMaxProcessingDays() {
		return maxProcessingDays;
	}

	public EtsyReceiptTransaction setMaxProcessingDays(Integer maxProcessingDays) {
		this.maxProcessingDays = maxProcessingDays;
		return this;
	}

	public Long getExpectedShipDate() {
		return expectedShipDate;
	}

	public EtsyReceiptTransaction setExpectedShipDate(Long expectedShipDate) {
		this.expectedShipDate = expectedShipDate;
		return this;
	}

	public Integer getBuyerCoupon() {
		return buyerCoupon;
	}

	public EtsyReceiptTransaction setBuyerCoupon(Integer buyerCoupon) {
		this.buyerCoupon = buyerCoupon;
		return this;
	}

	public Integer getShopCoupon() {
		return shopCoupon;
	}

	public EtsyReceiptTransaction setShopCoupon(Integer shopCoupon) {
		this.shopCoupon = shopCoupon;
		return this;
	}

	public String getShippingMethod() {
		return shippingMethod;
	}

	public EtsyReceiptTransaction setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
		return this;
	}

	public String getShippingUpgrade() {
		return shippingUpgrade;
	}

	public EtsyReceiptTransaction setShippingUpgrade(String shippingUpgrade) {
		this.shippingUpgrade = shippingUpgrade;
		return this;
	}

}
