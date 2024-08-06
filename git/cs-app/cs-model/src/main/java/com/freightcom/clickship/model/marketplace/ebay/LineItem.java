package com.freightcom.clickship.model.marketplace.ebay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LineItem {

    @JsonProperty("appliedPromotions")
    private List<AppliedPromotion> appliedPromotions;

    @JsonProperty("deliveryCost")
    private DeliveryCost deliveryCost;

    @JsonProperty("discountedLineItemCost")
    private Amount discountedLineItemCost;

//    @JsonProperty("giftDetails")
//    private GiftDetails giftDetails;

    @JsonProperty("legacyItemId")
    private String legacyItemId;

    @JsonProperty("legacyVariationId")
    private String legacyVariationId;

    @JsonProperty("lineItemCost")
    private Amount lineItemCost;

    @JsonProperty("lineItemFulfillmentInstructions")
    private LineItemFulfillmentInstructions lineItemFulfillmentInstructions;

    @JsonProperty("lineItemFulfillmentStatus")
    private String lineItemFulfillmentStatus;

    @JsonProperty("lineItemId")
    private String lineItemId;

    @JsonProperty("listingMarketplaceId")
    private String listingMarketplaceId;

    @JsonProperty("purchaseMarketplaceId")
    private String purchaseMarketplaceId;

    @JsonProperty("quantity")
    private Integer quantity;

//    @JsonProperty("refunds")
//    private List<LineItemRefund> refunds;

    @JsonProperty("sku")
    private String sku;

//    @JsonProperty("soldFormat")
//    private String soldFormat;

    @JsonProperty("taxes")
    private List<EbayTax> taxes;

    @JsonProperty("title")
    private String title;

    @JsonProperty("total")
    private Amount total;

    public List<AppliedPromotion> getAppliedPromotions() {
        return appliedPromotions;
    }

    public void setAppliedPromotions(List<AppliedPromotion> appliedPromotions) {
        this.appliedPromotions = appliedPromotions;
    }

    public DeliveryCost getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(DeliveryCost deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public Amount getDiscountedLineItemCost() {
        return discountedLineItemCost;
    }

    public void setDiscountedLineItemCost(Amount discountedLineItemCost) {
        this.discountedLineItemCost = discountedLineItemCost;
    }

    public String getLegacyItemId() {
        return legacyItemId;
    }

    public void setLegacyItemId(String legacyItemId) {
        this.legacyItemId = legacyItemId;
    }

    public String getLegacyVariationId() {
        return legacyVariationId;
    }

    public void setLegacyVariationId(String legacyVariationId) {
        this.legacyVariationId = legacyVariationId;
    }

    public Amount getLineItemCost() {
        return lineItemCost;
    }

    public void setLineItemCost(Amount lineItemCost) {
        this.lineItemCost = lineItemCost;
    }

    public LineItemFulfillmentInstructions getLineItemFulfillmentInstructions() {
        return lineItemFulfillmentInstructions;
    }

    public void setLineItemFulfillmentInstructions(LineItemFulfillmentInstructions lineItemFulfillmentInstructions) {
        this.lineItemFulfillmentInstructions = lineItemFulfillmentInstructions;
    }

    public String getLineItemFulfillmentStatus() {
        return lineItemFulfillmentStatus;
    }

    public void setLineItemFulfillmentStatus(String lineItemFulfillmentStatus) {
        this.lineItemFulfillmentStatus = lineItemFulfillmentStatus;
    }

    public String getLineItemId() {
        return lineItemId;
    }

    public void setLineItemId(String lineItemId) {
        this.lineItemId = lineItemId;
    }

    public String getListingMarketplaceId() {
        return listingMarketplaceId;
    }

    public void setListingMarketplaceId(String listingMarketplaceId) {
        this.listingMarketplaceId = listingMarketplaceId;
    }

    public String getPurchaseMarketplaceId() {
        return purchaseMarketplaceId;
    }

    public void setPurchaseMarketplaceId(String purchaseMarketplaceId) {
        this.purchaseMarketplaceId = purchaseMarketplaceId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public List<EbayTax> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<EbayTax> taxes) {
        this.taxes = taxes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Amount getTotal() {
        return total;
    }

    public void setTotal(Amount total) {
        this.total = total;
    }
}
