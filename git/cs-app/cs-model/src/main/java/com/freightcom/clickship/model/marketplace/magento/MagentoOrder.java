package com.freightcom.clickship.model.marketplace.magento;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MagentoOrder implements Serializable {

	private static final long serialVersionUID = 2563834179510996578L;
	
	@JsonProperty("entity_id")
	private Long orderId;
	
	@JsonProperty("increment_id")
	private String orderNumber;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonProperty("created_at")
	private Date createdDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonProperty("updated_at")
	private Date updatedDate;
	
	@JsonProperty("customer_email")
	private String email;
	
	@JsonProperty("customer_lastname")
	private String lastName;
	
	@JsonProperty("customer_firstname")
	private String firstName;
	
	@JsonProperty("store_currency_code")
	private String currencyCode;
	
	@JsonProperty("order_currency_code")
	private String ordercurrencyCode;
	
	@JsonProperty("shipping_amount")
	private Double shippingAmount;
	
	@JsonProperty("shipping_tax_amount")
	private Double shippingTaxAmount;
	
	@JsonProperty("shipping_discount_amount")
	private Double shippingDiscount;

	@JsonProperty("shipping_incl_tax")
	private Double shippingTotalWithTax;

	@JsonProperty("subtotal")
	private Double subTotal;

	@JsonProperty("tax_amount")
	private Double taxAmount;

	@JsonProperty("discount_amount")
	private Double discount;
	
	@JsonProperty("subtotal_incl_tax")
	private Double subTotalWithTax;

	@JsonProperty("grand_total")
	private Double grandTotal;
	
	@JsonProperty("total_item_count")
	private Integer totalItemCount;
	
	@JsonProperty("total_qty_ordered")
	private Integer totalQtyOrdered;
	
	@JsonProperty("items")
	private List<MagentoOrderItem> items;
	
	private String state;
	
	private String status;
	
	private Double weight;
	
	@JsonProperty("billing_address")
	private MagentoAddress billingAddress;
	
	@JsonProperty("extension_attributes")
	private OrderExtensionAttributes extensionAttributes;

	public Long getOrderId() {
		return orderId;
	}

	public MagentoOrder setOrderId(Long orderId) {
		this.orderId = orderId;
		return this;
	}
	
	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public MagentoOrder setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
		return this;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public MagentoOrder setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public MagentoOrder setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public MagentoOrder setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public MagentoOrder setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public MagentoOrder setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
		return this;
	}
	
	public String getOrdercurrencyCode() {
		return ordercurrencyCode;
	}

	public MagentoOrder setOrdercurrencyCode(String ordercurrencyCode) {
		this.ordercurrencyCode = ordercurrencyCode;
		return this;
	}

	public Double getShippingAmount() {
		return shippingAmount;
	}

	public MagentoOrder setShippingAmount(Double shippingAmount) {
		this.shippingAmount = shippingAmount;
		return this;
	}

	public Double getShippingTaxAmount() {
		return shippingTaxAmount;
	}

	public MagentoOrder setShippingTaxAmount(Double shippingTaxAmount) {
		this.shippingTaxAmount = shippingTaxAmount;
		return this;
	}

	public Double getShippingDiscount() {
		return shippingDiscount;
	}

	public MagentoOrder setShippingDiscount(Double shippingDiscount) {
		this.shippingDiscount = shippingDiscount;
		return this;
	}

	public Double getShippingTotalWithTax() {
		return shippingTotalWithTax;
	}

	public MagentoOrder setShippingTotalWithTax(Double shippingTotalWithTax) {
		this.shippingTotalWithTax = shippingTotalWithTax;
		return this;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public MagentoOrder setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
		return this;
	}

	public Double getTaxAmount() {
		return taxAmount;
	}

	public MagentoOrder setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
		return this;
	}

	public Double getDiscount() {
		return discount;
	}

	public MagentoOrder setDiscount(Double discount) {
		this.discount = discount;
		return this;
	}

	public Double getSubTotalWithTax() {
		return subTotalWithTax;
	}

	public MagentoOrder setSubTotalWithTax(Double subTotalWithTax) {
		this.subTotalWithTax = subTotalWithTax;
		return this;
	}

	public Double getGrandTotal() {
		return grandTotal;
	}

	public MagentoOrder setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
		return this;
	}

	public Integer getTotalItemCount() {
		return totalItemCount;
	}

	public MagentoOrder setTotalItemCount(Integer totalItemCount) {
		this.totalItemCount = totalItemCount;
		return this;
	}

	public Integer getTotalQtyOrdered() {
		return totalQtyOrdered;
	}

	public MagentoOrder setTotalQtyOrdered(Integer totalQtyOrdered) {
		this.totalQtyOrdered = totalQtyOrdered;
		return this;
	}

	public List<MagentoOrderItem> getItems() {
		return items;
	}

	public MagentoOrder setItems(List<MagentoOrderItem> items) {
		this.items = items;
		return this;
	}

	public String getState() {
		return state;
	}

	public MagentoOrder setState(String state) {
		this.state = state;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public MagentoOrder setStatus(String status) {
		this.status = status;
		return this;
	}

	public Double getWeight() {
		return weight;
	}

	public MagentoOrder setWeight(Double weight) {
		this.weight = weight;
		return this;
	}

	public MagentoAddress getBillingAddress() {
		return billingAddress;
	}

	public MagentoOrder setBillingAddress(MagentoAddress billingAddress) {
		this.billingAddress = billingAddress;
		return this;
	}

	public OrderExtensionAttributes getExtensionAttributes() {
		return extensionAttributes;
	}

	public MagentoOrder setExtensionAttributes(OrderExtensionAttributes extensionAttributes) {
		this.extensionAttributes = extensionAttributes;
		return this;
	}

	@Override
	public String toString() {
		return "MagentoOrder [orderId=" + orderId + "]";
	}

}
