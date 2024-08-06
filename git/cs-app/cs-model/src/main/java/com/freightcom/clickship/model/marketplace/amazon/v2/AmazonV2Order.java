package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AmazonV2Order {

    @JsonProperty("AmazonOrderId")
    private String amazonOrderId;

    @JsonProperty("SellerOrderId")
    private String sellerOrderId;

    @JsonProperty("PurchaseDate")
    private String purchaseDate;

    @JsonProperty("LastUpdateDate")
    private String lastUpdateDate;

    @JsonProperty("OrderStatus")
    private String orderStatus;

    @JsonProperty("FulfillmentChannel")
    private FulfillmentChannelEnum fulfillmentChannel;

    @JsonProperty("OrderTotal")
    private AmazonMoney orderTotal;

    @JsonProperty("NumberOfItemsShipped")
    private Integer NumberOfItemsShipped;

    @JsonProperty("NumberOfItemsUnshipped")
    private Integer NumberOfItemsUnshipped;

    @JsonProperty("PaymentMethod")
    private PaymentMethodEnum paymentMethod;

    @JsonProperty("PaymentMethodDetails")
    private List<String> paymentMethodDetails;

    @JsonProperty("MarketplaceId")
    private String marketplaceId;

    @JsonProperty("OrderType")
    private OrderTypeEnum orderType;

    @JsonProperty("EarliestShipDate")
    private String earliestShipDate;

    @JsonProperty("LatestShipDate")
    private String latestShipDate;

    @JsonProperty("EarliestDeliveryDate")
    private String earliestDeliveryDate;

    @JsonProperty("LatestDeliveryDate")
    private String latestDeliveryDate;

    @JsonProperty("IsPrime")
    private Boolean IsPrime;

    @JsonProperty("MarketplaceTaxInfo")
    private MarketplaceTaxInfo marketplaceTaxInfo;

    @JsonProperty("ShippingAddress")
    private AmazonV2ShippingAddress shippingAddress;

    @JsonProperty("BuyerInfo")
    private AmazonV2BuyerInfo buyerInfo;

    private AmazonV2OrderItems orderItemsList;

    public String getAmazonOrderId() {
        return amazonOrderId;
    }

    public AmazonV2Order setAmazonOrderId(String amazonOrderId) {
        this.amazonOrderId = amazonOrderId;
        return this;
    }

    public String getSellerOrderId() {
        return sellerOrderId;
    }

    public AmazonV2Order setSellerOrderId(String sellerOrderId) {
        this.sellerOrderId = sellerOrderId;
        return this;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public AmazonV2Order setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
        return this;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public AmazonV2Order setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
        return this;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public AmazonV2Order setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public FulfillmentChannelEnum getFulfillmentChannel() {
        return fulfillmentChannel;
    }

    public AmazonV2Order setFulfillmentChannel(FulfillmentChannelEnum fulfillmentChannel) {
        this.fulfillmentChannel = fulfillmentChannel;
        return this;
    }

    public AmazonMoney getOrderTotal() {
        return orderTotal;
    }

    public AmazonV2Order setOrderTotal(AmazonMoney orderTotal) {
        this.orderTotal = orderTotal;
        return this;
    }

    public Integer getNumberOfItemsShipped() {
        return NumberOfItemsShipped;
    }

    public AmazonV2Order setNumberOfItemsShipped(Integer numberOfItemsShipped) {
        NumberOfItemsShipped = numberOfItemsShipped;
        return this;
    }

    public Integer getNumberOfItemsUnshipped() {
        return NumberOfItemsUnshipped;
    }

    public AmazonV2Order setNumberOfItemsUnshipped(Integer numberOfItemsUnshipped) {
        NumberOfItemsUnshipped = numberOfItemsUnshipped;
        return this;
    }

    public PaymentMethodEnum getPaymentMethod() {
        return paymentMethod;
    }

    public AmazonV2Order setPaymentMethod(PaymentMethodEnum paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    public List<String> getPaymentMethodDetails() {
        return paymentMethodDetails;
    }

    public AmazonV2Order setPaymentMethodDetails(List<String> paymentMethodDetails) {
        this.paymentMethodDetails = paymentMethodDetails;
        return this;
    }

    public String getMarketplaceId() {
        return marketplaceId;
    }

    public AmazonV2Order setMarketplaceId(String marketplaceId) {
        this.marketplaceId = marketplaceId;
        return this;
    }

    public OrderTypeEnum getOrderType() {
        return orderType;
    }

    public AmazonV2Order setOrderType(OrderTypeEnum orderType) {
        this.orderType = orderType;
        return this;
    }

    public String getEarliestShipDate() {
        return earliestShipDate;
    }

    public AmazonV2Order setEarliestShipDate(String earliestShipDate) {
        this.earliestShipDate = earliestShipDate;
        return this;
    }

    public String getLatestShipDate() {
        return latestShipDate;
    }

    public AmazonV2Order setLatestShipDate(String latestShipDate) {
        this.latestShipDate = latestShipDate;
        return this;
    }

    public String getEarliestDeliveryDate() {
        return earliestDeliveryDate;
    }

    public AmazonV2Order setEarliestDeliveryDate(String earliestDeliveryDate) {
        this.earliestDeliveryDate = earliestDeliveryDate;
        return this;
    }

    public String getLatestDeliveryDate() {
        return latestDeliveryDate;
    }

    public AmazonV2Order setLatestDeliveryDate(String latestDeliveryDate) {
        this.latestDeliveryDate = latestDeliveryDate;
        return this;
    }

    public Boolean getPrime() {
        return IsPrime;
    }

    public AmazonV2Order setPrime(Boolean prime) {
        IsPrime = prime;
        return this;
    }

    public MarketplaceTaxInfo getMarketplaceTaxInfo() {
        return marketplaceTaxInfo;
    }

    public AmazonV2Order setMarketplaceTaxInfo(MarketplaceTaxInfo marketplaceTaxInfo) {
        this.marketplaceTaxInfo = marketplaceTaxInfo;
        return this;
    }

    public AmazonV2ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public AmazonV2Order setShippingAddress(AmazonV2ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
        return this;
    }

    public AmazonV2BuyerInfo getBuyerInfo() {
        return buyerInfo;
    }

    public AmazonV2Order setBuyerInfo(AmazonV2BuyerInfo buyerInfo) {
        this.buyerInfo = buyerInfo;
        return this;
    }

    public AmazonV2OrderItems getOrderItemsList() {
        return orderItemsList;
    }

    public AmazonV2Order setOrderItemsList(AmazonV2OrderItems orderItemsList) {
        this.orderItemsList = orderItemsList;
        return this;
    }
}
