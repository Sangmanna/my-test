package com.freightcom.clickship.model.marketplace.wix;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WixOrder {

	@JsonProperty("id")
	private String id;

	@JsonProperty("number")
	private Integer number;

	@JsonProperty("dateCreated")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date dateCreated;

	@JsonProperty("buyerInfo")
	private WixBuyerInfo buyerInfo;

	@JsonProperty("currency")
	private String currency;

	@JsonProperty("weightUnit")
	private String weightUnit;

	@JsonProperty("totals")
	private WixTotals totals;

	@JsonProperty("billingInfo")
	private WixBillingInfo billingInfo;

	@JsonProperty("shippingInfo")
	private WixShippingInfo shippingInfo;

	@JsonProperty("paymentStatus")
	private String paymentStatus;

	@JsonProperty("fulfillmentStatus")
	private String fulfillmentStatus;

	@JsonProperty("buyerNote")
	private String buyerNote;
	
	@JsonProperty("archived")
	private Boolean archived;

	@JsonProperty("lineItems")
	private List<WixLineItems> lineItems;

	@JsonProperty("fulfillments")
	private List<WixFulfillments> fulfillments;

	@JsonProperty("discount")
	private WixDiscount discount;

	@JsonProperty("cartId")
	private String cartId;

	@JsonProperty("lastUpdated")
	private String lastUpdated;

	@JsonProperty("refunds")
	private List<WixRefunds> refunds;
	
	// webhooks field
	@JsonProperty("orderId")
	private String orderId;
	
	@JsonProperty("fulfillmentId")
	private String fulfillmentId;
	
    @JsonProperty("trackingInfo")
    private WixTrackingInfo trackingInfo;

	public String getId() {
		return id;
	}

	public WixOrder setId(String id) {
		this.id = id;
		return this;
	}

	public Integer getNumber() {
		return number;
	}

	public WixOrder setNumber(Integer number) {
		this.number = number;
		return this;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public WixOrder setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
		return this;
	}

	public WixBuyerInfo getBuyerInfo() {
		return buyerInfo;
	}

	public WixOrder setBuyerInfo(WixBuyerInfo buyerInfo) {
		this.buyerInfo = buyerInfo;
		return this;
	}

	public String getCurrency() {
		return currency;
	}

	public WixOrder setCurrency(String currency) {
		this.currency = currency;
		return this;
	}

	public String getWeightUnit() {
		return weightUnit;
	}

	public WixOrder setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
		return this;
	}

	public WixTotals getTotals() {
		return totals;
	}

	public WixOrder setTotals(WixTotals totals) {
		this.totals = totals;
		return this;
	}

	public WixBillingInfo getBillingInfo() {
		return billingInfo;
	}

	public WixOrder setBillingInfo(WixBillingInfo billingInfo) {
		this.billingInfo = billingInfo;
		return this;
	}

	public WixShippingInfo getShippingInfo() {
		return shippingInfo;
	}

	public WixOrder setShippingInfo(WixShippingInfo shippingInfo) {
		this.shippingInfo = shippingInfo;
		return this;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public WixOrder setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
		return this;
	}

	public String getFulfillmentStatus() {
		return fulfillmentStatus;
	}

	public WixOrder setFulfillmentStatus(String fulfillmentStatus) {
		this.fulfillmentStatus = fulfillmentStatus;
		return this;
	}

	public String getBuyerNote() {
		return buyerNote;
	}

	public WixOrder setBuyerNote(String buyerNote) {
		this.buyerNote = buyerNote;
		return this;
	}

	public Boolean getArchived() {
		return archived;
	}

	public WixOrder setArchived(Boolean archived) {
		this.archived = archived;
		return this;
	}

	public List<WixLineItems> getLineItems() {
		return lineItems;
	}

	public WixOrder setLineItems(List<WixLineItems> lineItems) {
		this.lineItems = lineItems;
		return this;
	}

	public List<WixFulfillments> getFulfillments() {
		return fulfillments;
	}

	public WixOrder setFulfillments(List<WixFulfillments> fulfillments) {
		this.fulfillments = fulfillments;
		return this;
	}

	public WixDiscount getDiscount() {
		return discount;
	}

	public WixOrder setDiscount(WixDiscount discount) {
		this.discount = discount;
		return this;
	}

	public String getCartId() {
		return cartId;
	}

	public WixOrder setCartId(String cartId) {
		this.cartId = cartId;
		return this;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public WixOrder setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
		return this;
	}

	public List<WixRefunds> getRefunds() {
		return refunds;
	}

	public WixOrder setRefunds(List<WixRefunds> refunds) {
		this.refunds = refunds;
		return this;
	}

	public String getOrderId() {
		return orderId;
	}

	public WixOrder setOrderId(String orderId) {
		this.orderId = orderId;
		return this;
	}

	public String getFulfillmentId() {
		return fulfillmentId;
	}

	public WixOrder setFulfillmentId(String fulfillmentId) {
		this.fulfillmentId = fulfillmentId;
		return this;
	}

	public WixTrackingInfo getTrackingInfo() {
		return trackingInfo;
	}

	public WixOrder setTrackingInfo(WixTrackingInfo trackingInfo) {
		this.trackingInfo = trackingInfo;
		return this;
	}
}
