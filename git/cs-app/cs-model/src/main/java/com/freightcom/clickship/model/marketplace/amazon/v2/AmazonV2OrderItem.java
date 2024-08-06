package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AmazonV2OrderItem {

    @JsonProperty("ASIN")
    private String asin;

    @JsonProperty("SellerSKU")
    private String sellerSKU;

    @JsonProperty("OrderItemId")
    private String orderItemId;

    @JsonProperty("Title")
    private String title;

    @JsonProperty("QuantityOrdered")
    private Integer quantityOrdered;

    @JsonProperty("QuantityShipped")
    private Integer quantityShipped;

    @JsonProperty("ProductInfo")
    private AmazonV2ProductInfo productInfo;

    @JsonProperty("ItemPrice")
    private AmazonMoney itemPrice;

    @JsonProperty("ShippingPrice")
    private AmazonMoney shippingPrice;

    @JsonProperty("ItemTax")
    private AmazonMoney itemTax;

    @JsonProperty("ShippingTax")
    private AmazonMoney shippingTax;

    @JsonProperty("ShippingDiscount")
    private AmazonMoney shippingDiscount;

    @JsonProperty("ShippingDiscountTax")
    private AmazonMoney shippingDiscountTax;

    @JsonProperty("PromotionDiscount")
    private AmazonMoney promotionDiscount;

    @JsonProperty("PromotionDiscountTax")
    private AmazonMoney promotionDiscountTax;

    @JsonProperty("CODFee")
    private AmazonMoney codFee;

    @JsonProperty("CODFeeDiscount")
    private AmazonMoney codFeeDiscount;

    @JsonProperty("BuyerInfo")
    private AmazonV2ItemBuyerInfo itemBuyerInfo;

    @JsonProperty("BuyerRequestedCancel")
    private BuyerRequestedCancel buyerRequestedCancel;

    public String getAsin() {
        return asin;
    }

    public AmazonV2OrderItem setAsin(String asin) {
        this.asin = asin;
        return this;
    }

    public String getSellerSKU() {
        return sellerSKU;
    }

    public AmazonV2OrderItem setSellerSKU(String sellerSKU) {
        this.sellerSKU = sellerSKU;
        return this;
    }

    public String getOrderItemId() {
        return orderItemId;
    }

    public AmazonV2OrderItem setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public AmazonV2OrderItem setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getQuantityOrdered() {
        return quantityOrdered;
    }

    public AmazonV2OrderItem setQuantityOrdered(Integer quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
        return this;
    }

    public Integer getQuantityShipped() {
        return quantityShipped;
    }

    public AmazonV2OrderItem setQuantityShipped(Integer quantityShipped) {
        this.quantityShipped = quantityShipped;
        return this;
    }

    public AmazonV2ProductInfo getProductInfo() {
        return productInfo;
    }

    public AmazonV2OrderItem setProductInfo(AmazonV2ProductInfo productInfo) {
        this.productInfo = productInfo;
        return this;
    }

    public AmazonMoney getItemPrice() {
        return itemPrice;
    }

    public AmazonV2OrderItem setItemPrice(AmazonMoney itemPrice) {
        this.itemPrice = itemPrice;
        return this;
    }

    public AmazonMoney getShippingPrice() {
        return shippingPrice;
    }

    public AmazonV2OrderItem setShippingPrice(AmazonMoney shippingPrice) {
        this.shippingPrice = shippingPrice;
        return this;
    }

    public AmazonMoney getItemTax() {
        return itemTax;
    }

    public AmazonV2OrderItem setItemTax(AmazonMoney itemTax) {
        this.itemTax = itemTax;
        return this;
    }

    public AmazonMoney getShippingTax() {
        return shippingTax;
    }

    public AmazonV2OrderItem setShippingTax(AmazonMoney shippingTax) {
        this.shippingTax = shippingTax;
        return this;
    }

    public AmazonMoney getShippingDiscount() {
        return shippingDiscount;
    }

    public AmazonV2OrderItem setShippingDiscount(AmazonMoney shippingDiscount) {
        this.shippingDiscount = shippingDiscount;
        return this;
    }

    public AmazonMoney getShippingDiscountTax() {
        return shippingDiscountTax;
    }

    public AmazonV2OrderItem setShippingDiscountTax(AmazonMoney shippingDiscountTax) {
        this.shippingDiscountTax = shippingDiscountTax;
        return this;
    }

    public AmazonMoney getPromotionDiscount() {
        return promotionDiscount;
    }

    public AmazonV2OrderItem setPromotionDiscount(AmazonMoney promotionDiscount) {
        this.promotionDiscount = promotionDiscount;
        return this;
    }

    public AmazonMoney getPromotionDiscountTax() {
        return promotionDiscountTax;
    }

    public AmazonV2OrderItem setPromotionDiscountTax(AmazonMoney promotionDiscountTax) {
        this.promotionDiscountTax = promotionDiscountTax;
        return this;
    }

    public AmazonMoney getCodFee() {
        return codFee;
    }

    public AmazonV2OrderItem setCodFee(AmazonMoney codFee) {
        this.codFee = codFee;
        return this;
    }

    public AmazonMoney getCodFeeDiscount() {
        return codFeeDiscount;
    }

    public AmazonV2OrderItem setCodFeeDiscount(AmazonMoney codFeeDiscount) {
        this.codFeeDiscount = codFeeDiscount;
        return this;
    }

    public AmazonV2ItemBuyerInfo getItemBuyerInfo() {
        return itemBuyerInfo;
    }

    public AmazonV2OrderItem setItemBuyerInfo(AmazonV2ItemBuyerInfo itemBuyerInfo) {
        this.itemBuyerInfo = itemBuyerInfo;
        return this;
    }

    public BuyerRequestedCancel getBuyerRequestedCancel() {
        return buyerRequestedCancel;
    }

    public AmazonV2OrderItem setBuyerRequestedCancel(BuyerRequestedCancel buyerRequestedCancel) {
        this.buyerRequestedCancel = buyerRequestedCancel;
        return this;
    }
}
