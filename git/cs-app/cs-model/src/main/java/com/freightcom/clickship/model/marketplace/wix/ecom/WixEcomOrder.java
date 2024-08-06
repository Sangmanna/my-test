package com.freightcom.clickship.model.marketplace.wix.ecom;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WixEcomOrder {

	@JsonProperty("id")
	private String id;

	@JsonProperty("number")
	private String number;

	@JsonProperty("createdDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date createdDate;

	@JsonProperty("updatedDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date updatedDate;

	@JsonProperty("lineItems")
	private List<WixEcomLineItems> lineItems;

	@JsonProperty("buyerInfo")
	private WixEcomBuyerInfo buyerInfo;

	@JsonProperty("paymentStatus")
	private String paymentStatus;

	@JsonProperty("fulfillmentStatus")
	private String fulfillmentStatus;

	@JsonProperty("buyerLanguage")
	private String buyerLanguage;

	@JsonProperty("weightUnit")
	private String weightUnit;

	@JsonProperty("currency")
	private String currency;

	@JsonProperty("taxIncludedInPrices")
	private Boolean taxIncludedInPrices;

	@JsonProperty("priceSummary")
	private WixEcomPriceSummary priceSummary;

	@JsonProperty("billingInfo")
	private WixEcomBillingInfo billingInfo;

	@JsonProperty("shippingInfo")
	private WixEcomShippingInfo shippingInfo;

	@JsonProperty("status")
	private String status;

	@JsonProperty("archived")
	private Boolean archived;

	@JsonProperty("buyerNote")
	private String buyerNote;

	@JsonProperty("taxSummary")
	private WixEcomTaxSummary taxSummary;

	@JsonProperty("appliedDiscounts")
	private List<WixEcomAppliedDiscounts> appliedDiscounts;

	@JsonProperty("activities")
	private List<WixEcomActivities> activities;

	@JsonProperty("seenByAHuman")
	private Boolean seenByAHuman;

	@JsonProperty("checkoutId")
	private String checkoutId;

	@JsonProperty("cartId")
	private String cartId;

	@JsonProperty("payNow")
	private WixEcomPayNow payNow;

	@JsonProperty("balanceSummary")
	private WixEcomBalanceSummary balanceSummary;

	// webhooks field
	@JsonProperty("orderId")
	private String orderId;

	@JsonProperty("fulfillmentId")
	private String fulfillmentId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<WixEcomLineItems> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<WixEcomLineItems> lineItems) {
		this.lineItems = lineItems;
	}

	public WixEcomBuyerInfo getBuyerInfo() {
		return buyerInfo;
	}

	public void setBuyerInfo(WixEcomBuyerInfo buyerInfo) {
		this.buyerInfo = buyerInfo;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getFulfillmentStatus() {
		return fulfillmentStatus;
	}

	public void setFulfillmentStatus(String fulfillmentStatus) {
		this.fulfillmentStatus = fulfillmentStatus;
	}

	public String getBuyerLanguage() {
		return buyerLanguage;
	}

	public void setBuyerLanguage(String buyerLanguage) {
		this.buyerLanguage = buyerLanguage;
	}

	public String getWeightUnit() {
		return weightUnit;
	}

	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Boolean getTaxIncludedInPrices() {
		return taxIncludedInPrices;
	}

	public void setTaxIncludedInPrices(Boolean taxIncludedInPrices) {
		this.taxIncludedInPrices = taxIncludedInPrices;
	}

	public WixEcomPriceSummary getPriceSummary() {
		return priceSummary;
	}

	public void setPriceSummary(WixEcomPriceSummary priceSummary) {
		this.priceSummary = priceSummary;
	}

	public WixEcomBillingInfo getBillingInfo() {
		return billingInfo;
	}

	public void setBillingInfo(WixEcomBillingInfo billingInfo) {
		this.billingInfo = billingInfo;
	}

	public WixEcomShippingInfo getShippingInfo() {
		return shippingInfo;
	}

	public void setShippingInfo(WixEcomShippingInfo shippingInfo) {
		this.shippingInfo = shippingInfo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getArchived() {
		return archived;
	}

	public void setArchived(Boolean archived) {
		this.archived = archived;
	}

	public String getBuyerNote() {
		return buyerNote;
	}

	public void setBuyerNote(String buyerNote) {
		this.buyerNote = buyerNote;
	}

	public WixEcomTaxSummary getTaxSummary() {
		return taxSummary;
	}

	public void setTaxSummary(WixEcomTaxSummary taxSummary) {
		this.taxSummary = taxSummary;
	}

	public List<WixEcomAppliedDiscounts> getAppliedDiscounts() {
		return appliedDiscounts;
	}

	public void setAppliedDiscounts(List<WixEcomAppliedDiscounts> appliedDiscounts) {
		this.appliedDiscounts = appliedDiscounts;
	}

	public List<WixEcomActivities> getActivities() {
		return activities;
	}

	public void setActivities(List<WixEcomActivities> activities) {
		this.activities = activities;
	}

	public Boolean getSeenByAHuman() {
		return seenByAHuman;
	}

	public void setSeenByAHuman(Boolean seenByAHuman) {
		this.seenByAHuman = seenByAHuman;
	}

	public String getCheckoutId() {
		return checkoutId;
	}

	public void setCheckoutId(String checkoutId) {
		this.checkoutId = checkoutId;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public WixEcomPayNow getPayNow() {
		return payNow;
	}

	public void setPayNow(WixEcomPayNow payNow) {
		this.payNow = payNow;
	}

	public WixEcomBalanceSummary getBalanceSummary() {
		return balanceSummary;
	}

	public void setBalanceSummary(WixEcomBalanceSummary balanceSummary) {
		this.balanceSummary = balanceSummary;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getFulfillmentId() {
		return fulfillmentId;
	}

	public void setFulfillmentId(String fulfillmentId) {
		this.fulfillmentId = fulfillmentId;
	}

}
