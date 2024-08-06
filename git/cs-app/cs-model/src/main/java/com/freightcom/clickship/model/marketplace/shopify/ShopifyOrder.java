package com.freightcom.clickship.model.marketplace.shopify;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyOrder implements Serializable {

	private static final long serialVersionUID = 639023746976329220L;

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("phone")
	private String phone;
	
	@JsonProperty("order_number")
	private Long orderNumber;
	
	@JsonProperty("total_tax")
	private double totalTax;
	
	@JsonProperty("subtotal_price")
	private double subTotal;
	
	@JsonProperty("total_price")
	private double totalPrice;
	
	@JsonProperty("total_discounts")
	private double totalDiscount;
	
	@JsonProperty("current_total_tax")
	private double currentTotalTax;
	
	@JsonProperty("current_subtotal_price")
	private double currentSubTotal;
	
	@JsonProperty("current_total_price")
	private double currentTotalPrice;
	
	@JsonProperty("current_total_discounts")
	private double currentTotalDiscount;
	
	@JsonProperty("total_weight")
	private double totalWeight;
	
	@JsonProperty("currency")
	private String currency;
	
	@JsonProperty("financial_status")
	private String status;
	
	@JsonProperty("fulfillment_status")
	private String fulfillmentStatus;
	
	@JsonProperty("tax_lines")
	private List<ShopifyTax> taxes;
	
	@JsonProperty("billing_address")
	private ShopifyAddress billingAddress;
	
	@JsonProperty("shipping_address")
	private ShopifyAddress shippingAddress;
	
	@JsonProperty("shipping_lines")
	private List<ShopifyShipping> shipping;
	
	@JsonProperty("discount_applications")
	private List<ShopifyDiscount> discounts;
	
	@JsonProperty("line_items")
	private List<ShopifyOrderLineItem> orderLines;
	
	@JsonProperty("total_shipping_price_set")
	private ShopifyOrderShippingCost shippingCost;
	
	@JsonProperty("fulfillments")
	private List<ShopifyFulfillment> fulfillments;
	
	@JsonProperty("refunds")
	private List<ShopifyRefundOrder> refunds;
	
	@JsonProperty("note")
	private String note;
	
	@JsonProperty("cancelled_at")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date cancelledDate;
	
	@JsonProperty("created_at")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date createdDate;
	
	@JsonProperty("updated_at")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date updatedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public double getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(double totalTax) {
		this.totalTax = totalTax;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getTotalDiscount() {
		return totalDiscount;
	}

	public void setTotalDiscount(double totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	public double getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(double totalWeight) {
		this.totalWeight = totalWeight;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFulfillmentStatus() {
		return fulfillmentStatus;
	}

	public void setFulfillmentStatus(String fulfillmentStatus) {
		this.fulfillmentStatus = fulfillmentStatus;
	}

	public List<ShopifyTax> getTaxes() {
		return taxes;
	}

	public void setTaxes(List<ShopifyTax> taxes) {
		this.taxes = taxes;
	}

	public ShopifyAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(ShopifyAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public ShopifyAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShopifyAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public List<ShopifyShipping> getShipping() {
		return shipping;
	}

	public void setShipping(List<ShopifyShipping> shipping) {
		this.shipping = shipping;
	}

	public List<ShopifyDiscount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(List<ShopifyDiscount> discounts) {
		this.discounts = discounts;
	}

	public List<ShopifyOrderLineItem> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<ShopifyOrderLineItem> orderLines) {
		this.orderLines = orderLines;
	}

	public ShopifyOrderShippingCost getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(ShopifyOrderShippingCost shippingCost) {
		this.shippingCost = shippingCost;
	}

	public List<ShopifyFulfillment> getFulfillments() {
		return fulfillments;
	}

	public void setFulfillments(List<ShopifyFulfillment> fulfillments) {
		this.fulfillments = fulfillments;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getCancelledDate() {
		return cancelledDate;
	}

	public void setCancelledDate(Date cancelledDate) {
		this.cancelledDate = cancelledDate;
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

	public List<ShopifyRefundOrder> getRefunds() {
		return refunds;
	}

	public void setRefunds(List<ShopifyRefundOrder> refunds) {
		this.refunds = refunds;
	}

	public double getCurrentTotalTax() {
		return currentTotalTax;
	}

	public void setCurrentTotalTax(double currentTotalTax) {
		this.currentTotalTax = currentTotalTax;
	}

	public double getCurrentSubTotal() {
		return currentSubTotal;
	}

	public void setCurrentSubTotal(double currentSubTotal) {
		this.currentSubTotal = currentSubTotal;
	}

	public double getCurrentTotalPrice() {
		return currentTotalPrice;
	}

	public void setCurrentTotalPrice(double currentTotalPrice) {
		this.currentTotalPrice = currentTotalPrice;
	}

	public double getCurrentTotalDiscount() {
		return currentTotalDiscount;
	}

	public void setCurrentTotalDiscount(double currentTotalDiscount) {
		this.currentTotalDiscount = currentTotalDiscount;
	}
	
}
