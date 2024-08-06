package com.freightcom.clickship.model.marketplace.wix;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WixLineItems {

    @JsonProperty("index")
    private Integer index;

    @JsonProperty("quantity")
    private Integer quantity;
    
    @JsonProperty("refundedQuantity")
    private Integer refundedQuantity;

    @JsonProperty("priceData")
    private WixPriceData priceData;

    @JsonProperty("name")
    private String name;

    @JsonProperty("translatedName")
    private String translatedName;

    @JsonProperty("productId")
    private String productId;

    @JsonProperty("lineItemType")
    private String lineItemType;

    @JsonProperty("weight")
    private String weight;

    @JsonProperty("mediaItem")
    private WixMediaItem mediaItem;

    @JsonProperty("sku")
    private String sku;

    @JsonProperty("notes")
    private String notes;

    @JsonProperty("variantId")
    private String variantId;

    @JsonProperty("fulfillerId")
    private String fulfillerId;

    @JsonProperty("discount")
    private String discount;

    @JsonProperty("tax")
    private String tax;

    @JsonProperty("taxGroupId")
    private String taxGroupId;

	public Integer getIndex() {
		return index;
	}

	public WixLineItems setIndex(Integer index) {
		this.index = index;
		return this;
	}

	public Integer getQuantity() {
		return quantity != null ? quantity : 0;
	}

	public WixLineItems setQuantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}

	public Integer getRefundedQuantity() {
		return refundedQuantity != null ? refundedQuantity : 0;
	}

	public WixLineItems setRefundedQuantity(Integer refundedQuantity) {
		this.refundedQuantity = refundedQuantity;
		return this;
	}

	public WixPriceData getPriceData() {
		return priceData;
	}

	public WixLineItems setPriceData(WixPriceData priceData) {
		this.priceData = priceData;
		return this;
	}

	public String getName() {
		return name;
	}

	public WixLineItems setName(String name) {
		this.name = name;
		return this;
	}

	public String getTranslatedName() {
		return translatedName;
	}

	public WixLineItems setTranslatedName(String translatedName) {
		this.translatedName = translatedName;
		return this;
	}

	public String getProductId() {
		return productId;
	}

	public WixLineItems setProductId(String productId) {
		this.productId = productId;
		return this;
	}

	public String getLineItemType() {
		return lineItemType;
	}

	public WixLineItems setLineItemType(String lineItemType) {
		this.lineItemType = lineItemType;
		return this;
	}

	public String getWeight() {
		return weight;
	}

	public WixLineItems setWeight(String weight) {
		this.weight = weight;
		return this;
	}

	public WixMediaItem getMediaItem() {
		return mediaItem;
	}

	public WixLineItems setMediaItem(WixMediaItem mediaItem) {
		this.mediaItem = mediaItem;
		return this;
	}

	public String getSku() {
		return sku;
	}

	public WixLineItems setSku(String sku) {
		this.sku = sku;
		return this;
	}

	public String getNotes() {
		return notes;
	}

	public WixLineItems setNotes(String notes) {
		this.notes = notes;
		return this;
	}

	public String getVariantId() {
		return variantId;
	}

	public WixLineItems setVariantId(String variantId) {
		this.variantId = variantId;
		return this;
	}

	public String getFulfillerId() {
		return fulfillerId;
	}

	public WixLineItems setFulfillerId(String fulfillerId) {
		this.fulfillerId = fulfillerId;
		return this;
	}

	public String getDiscount() {
		return discount;
	}

	public WixLineItems setDiscount(String discount) {
		this.discount = discount;
		return this;
	}

	public String getTax() {
		return tax;
	}

	public WixLineItems setTax(String tax) {
		this.tax = tax;
		return this;
	}

	public String getTaxGroupId() {
		return taxGroupId;
	}

	public WixLineItems setTaxGroupId(String taxGroupId) {
		this.taxGroupId = taxGroupId;
		return this;
	}
}
