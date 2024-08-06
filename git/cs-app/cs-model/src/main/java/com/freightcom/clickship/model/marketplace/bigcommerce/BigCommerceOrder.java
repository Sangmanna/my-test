package com.freightcom.clickship.model.marketplace.bigcommerce;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BigCommerceOrder {

	@JsonProperty("id")
	private int id;

	@JsonProperty("date_modified")
	private String dateModified;

	@JsonProperty("date_shipped")
	private String dateShipped;

	@JsonProperty("cart_id")
	private String cartId;

	@JsonProperty("status")
	private String status;

	@JsonProperty("subtotal_tax")
	private String subTotalTax;
	
	@JsonProperty("subtotal_ex_tax")
	private String subTotalExTax;
	
	@JsonProperty("subtotal_inc_tax")
	private String subTotalIncTax;

	@JsonProperty("shipping_cost_tax")
	private String shippingCostTax;

	@JsonProperty("handling_cost_tax")
	private String handlingCostTax;

	@JsonProperty("handling_cost_tax_class_id")
	private int handlingCostTaxClassId;

	@JsonProperty("wrapping_cost_tax")
	private String wrappingCostTax;

	@JsonProperty("wrapping_cost_tax_class_id")
	private int wrappingCostTaxClassId;

	@JsonProperty("payment_status")
	private String paymentStatus;

	@JsonProperty("store_credit_amount")
	private String storeCreditAmount;

	@JsonProperty("gift_certificate_amount")
	private String giftCertificateAmount;

	@JsonProperty("currency_id")
	private int currencyId;

	@JsonProperty("currency_code")
	private String currencyCode;

	@JsonProperty("currency_exchange_rate")
	private String currencyExchangeRate;

	@JsonProperty("default_currency_id")
	private int defaultCurrencyId;

	@JsonProperty("default_currency_code")
	private String defaultCurrencyCode;

	@JsonProperty("store_default_currency_code")
	private String storeDefaultCurrencyCode;

	@JsonProperty("store_default_to_transactional_exchange_rate")
	private String storeDefaultToTransactionExchangeRate;

	@JsonProperty("coupon_discount")
	private String couponDiscount;

	@JsonProperty("shipping_address_count")
	private int shippingAddressCount;

	@JsonProperty("is_email_opt_in")
	private boolean isEmailOptIn;

	@JsonProperty("order_source")
	private String orderSource;

	@JsonProperty("status_id")
	private int statusId;

	@JsonProperty("base_handling_cost")
	private String baseHandlingCost;

	@JsonProperty("base_shipping_cost")
	private String baseShippingCoset;

	@JsonProperty("customer_id")
	private int customerId;

	@JsonProperty("customer_message")
	private String customerMessage;

	@JsonProperty("date_created")
	private String dateCreated;

	@JsonProperty("discount_amount")
	private String discountAmount;

	@JsonProperty("handling_cost_ex_tax")
	private String handlingCostexTax;

	@JsonProperty("handling_cost_inc_tax")
	private String handlingCostIncTax;

	@JsonProperty("is_deleted")
	private boolean isDeleted;

	@JsonProperty("items_shipped")
	private int itemsShipped;

	@JsonProperty("items_total")
	private int itemsTotal;

	@JsonProperty("order_is_digital")
	private boolean orderIsDigital;

	@JsonProperty("payment_method")
	private String paymentMethod;

	@JsonProperty("shipping_cost_ex_tax")
	private String shippingCostExTax;

	@JsonProperty("shipping_cost_inc_tax")
	private String shippingCostIncTax;

	@JsonProperty("total_ex_tax")
	private String totalExTax;

	@JsonProperty("total_inc_tax")
	private String totalIncTax;

	@JsonProperty("total_tax")
	private String totalTax;
	
	@JsonProperty("staff_notes")
	private String staffNotes;
	
	@JsonProperty("billing_address")
	private BigCommerceAddress billingAddress;

	@JsonProperty("shipping_addresses")
	private BigCommerceAddress shippingAddress;
	
	@JsonProperty("products")
	private BigCommerceAddress products;
	
	private List<BigCommerceOrderline> orderLines;
	
	private BigCommerceShippingAddress bigCommerceShippingAddress;

	public int getId() {
		return id;
	}

	public BigCommerceOrder setId(int id) {
		this.id = id;
		return this;
	}

	public String getDateModified() {
		return dateModified;
	}

	public BigCommerceOrder setDateModified(String dateModified) {
		this.dateModified = dateModified;
		return this;
	}

	public String getDateShipped() {
		return dateShipped;
	}

	public BigCommerceOrder setDateShipped(String dateShipped) {
		this.dateShipped = dateShipped;
		return this;
	}

	public String getCartId() {
		return cartId;
	}

	public BigCommerceOrder setCartId(String cartId) {
		this.cartId = cartId;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public BigCommerceOrder setStatus(String status) {
		this.status = status;
		return this;
	}

	public String getSubTotalTax() {
		return subTotalTax;
	}

	public BigCommerceOrder setSubTotalTax(String subTotalTax) {
		this.subTotalTax = subTotalTax;
		return this;
	}

	public String getSubTotalExTax() {
		return subTotalExTax;
	}

	public BigCommerceOrder setSubTotalExTax(String subTotalExTax) {
		this.subTotalExTax = subTotalExTax;
		return this;
	}

	public String getSubTotalIncTax() {
		return subTotalIncTax;
	}

	public BigCommerceOrder setSubTotalIncTax(String subTotalIncTax) {
		this.subTotalIncTax = subTotalIncTax;
		return this;
	}

	public String getShippingCostTax() {
		return shippingCostTax;
	}

	public BigCommerceOrder setShippingCostTax(String shippingCostTax) {
		this.shippingCostTax = shippingCostTax;
		return this;
	}

	public String getHandlingCostTax() {
		return handlingCostTax;
	}

	public BigCommerceOrder setHandlingCostTax(String handlingCostTax) {
		this.handlingCostTax = handlingCostTax;
		return this;
	}

	public int getHandlingCostTaxClassId() {
		return handlingCostTaxClassId;
	}

	public BigCommerceOrder setHandlingCostTaxClassId(int handlingCostTaxClassId) {
		this.handlingCostTaxClassId = handlingCostTaxClassId;
		return this;
	}

	public String getWrappingCostTax() {
		return wrappingCostTax;
	}

	public BigCommerceOrder setWrappingCostTax(String wrappingCostTax) {
		this.wrappingCostTax = wrappingCostTax;
		return this;
	}

	public int getWrappingCostTaxClassId() {
		return wrappingCostTaxClassId;
	}

	public BigCommerceOrder setWrappingCostTaxClassId(int wrappingCostTaxClassId) {
		this.wrappingCostTaxClassId = wrappingCostTaxClassId;
		return this;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public BigCommerceOrder setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
		return this;
	}

	public String getStoreCreditAmount() {
		return storeCreditAmount;
	}

	public BigCommerceOrder setStoreCreditAmount(String storeCreditAmount) {
		this.storeCreditAmount = storeCreditAmount;
		return this;
	}

	public String getGiftCertificateAmount() {
		return giftCertificateAmount;
	}

	public BigCommerceOrder setGiftCertificateAmount(String giftCertificateAmount) {
		this.giftCertificateAmount = giftCertificateAmount;
		return this;
	}

	public int getCurrencyId() {
		return currencyId;
	}

	public BigCommerceOrder setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
		return this;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public BigCommerceOrder setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
		return this;
	}

	public String getCurrencyExchangeRate() {
		return currencyExchangeRate;
	}

	public BigCommerceOrder setCurrencyExchangeRate(String currencyExchangeRate) {
		this.currencyExchangeRate = currencyExchangeRate;
		return this;
	}

	public int getDefaultCurrencyId() {
		return defaultCurrencyId;
	}

	public BigCommerceOrder setDefaultCurrencyId(int defaultCurrencyId) {
		this.defaultCurrencyId = defaultCurrencyId;
		return this;
	}

	public String getDefaultCurrencyCode() {
		return defaultCurrencyCode;
	}

	public BigCommerceOrder setDefaultCurrencyCode(String defaultCurrencyCode) {
		this.defaultCurrencyCode = defaultCurrencyCode;
		return this;
	}

	public String getStoreDefaultCurrencyCode() {
		return storeDefaultCurrencyCode;
	}

	public BigCommerceOrder setStoreDefaultCurrencyCode(String storeDefaultCurrencyCode) {
		this.storeDefaultCurrencyCode = storeDefaultCurrencyCode;
		return this;
	}

	public String getStoreDefaultToTransactionExchangeRate() {
		return storeDefaultToTransactionExchangeRate;
	}

	public BigCommerceOrder setStoreDefaultToTransactionExchangeRate(String storeDefaultToTransactionExchangeRate) {
		this.storeDefaultToTransactionExchangeRate = storeDefaultToTransactionExchangeRate;
		return this;
	}

	public String getCouponDiscount() {
		return couponDiscount;
	}

	public BigCommerceOrder setCouponDiscount(String couponDiscount) {
		this.couponDiscount = couponDiscount;
		return this;
	}

	public int getShippingAddressCount() {
		return shippingAddressCount;
	}

	public BigCommerceOrder setShippingAddressCount(int shippingAddressCount) {
		this.shippingAddressCount = shippingAddressCount;
		return this;
	}

	public boolean isEmailOptIn() {
		return isEmailOptIn;
	}

	public BigCommerceOrder setEmailOptIn(boolean isEmailOptIn) {
		this.isEmailOptIn = isEmailOptIn;
		return this;
	}

	public String getOrderSource() {
		return orderSource;
	}

	public BigCommerceOrder setOrderSource(String orderSource) {
		this.orderSource = orderSource;
		return this;
	}

	public int getStatusId() {
		return statusId;
	}

	public BigCommerceOrder setStatusId(int statusId) {
		this.statusId = statusId;
		return this;
	}

	public String getBaseHandlingCost() {
		return baseHandlingCost;
	}

	public BigCommerceOrder setBaseHandlingCost(String baseHandlingCost) {
		this.baseHandlingCost = baseHandlingCost;
		return this;
	}

	public String getBaseShippingCoset() {
		return baseShippingCoset;
	}

	public BigCommerceOrder setBaseShippingCoset(String baseShippingCoset) {
		this.baseShippingCoset = baseShippingCoset;
		return this;
	}

	public int getCustomerId() {
		return customerId;
	}

	public BigCommerceOrder setCustomerId(int customerId) {
		this.customerId = customerId;
		return this;
	}

	public String getCustomerMessage() {
		return customerMessage;
	}

	public BigCommerceOrder setCustomerMessage(String customerMessage) {
		this.customerMessage = customerMessage;
		return this;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public BigCommerceOrder setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
		return this;
	}

	public String getDiscountAmount() {
		return discountAmount;
	}

	public BigCommerceOrder setDiscountAmount(String discountAmount) {
		this.discountAmount = discountAmount;
		return this;
	}

	public String getHandlingCostexTax() {
		return handlingCostexTax;
	}

	public BigCommerceOrder setHandlingCostexTax(String handlingCostexTax) {
		this.handlingCostexTax = handlingCostexTax;
		return this;
	}

	public String getHandlingCostIncTax() {
		return handlingCostIncTax;
	}

	public BigCommerceOrder setHandlingCostIncTax(String handlingCostIncTax) {
		this.handlingCostIncTax = handlingCostIncTax;
		return this;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public BigCommerceOrder setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
		return this;
	}

	public int getItemsShipped() {
		return itemsShipped;
	}

	public BigCommerceOrder setItemsShipped(int itemsShipped) {
		this.itemsShipped = itemsShipped;
		return this;
	}

	public int getItemsTotal() {
		return itemsTotal;
	}

	public BigCommerceOrder setItemsTotal(int itemsTotal) {
		this.itemsTotal = itemsTotal;
		return this;
	}

	public boolean isOrderIsDigital() {
		return orderIsDigital;
	}

	public BigCommerceOrder setOrderIsDigital(boolean orderIsDigital) {
		this.orderIsDigital = orderIsDigital;
		return this;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public BigCommerceOrder setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
		return this;
	}

	public String getShippingCostExTax() {
		return shippingCostExTax;
	}

	public BigCommerceOrder setShippingCostExTax(String shippingCostExTax) {
		this.shippingCostExTax = shippingCostExTax;
		return this;
	}

	public String getShippingCostIncTax() {
		return shippingCostIncTax;
	}

	public BigCommerceOrder setShippingCostIncTax(String shippingCostIncTax) {
		this.shippingCostIncTax = shippingCostIncTax;
		return this;
	}

	public String getTotalExTax() {
		return totalExTax;
	}

	public BigCommerceOrder setTotalExTax(String totalExTax) {
		this.totalExTax = totalExTax;
		return this;
	}

	public String getTotalIncTax() {
		return totalIncTax;
	}

	public BigCommerceOrder setTotalIncTax(String totalIncTax) {
		this.totalIncTax = totalIncTax;
		return this;
	}

	public String getTotalTax() {
		return totalTax;
	}

	public BigCommerceOrder setTotalTax(String totalTax) {
		this.totalTax = totalTax;
		return this;
	}

	public BigCommerceAddress getBillingAddress() {
		return billingAddress;
	}

	public BigCommerceOrder setBillingAddress(BigCommerceAddress billingAddress) {
		this.billingAddress = billingAddress;
		return this;
	}

	public BigCommerceAddress getShippingAddress() {
		return shippingAddress;
	}

	public BigCommerceOrder setShippingAddress(BigCommerceAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
		return this;
	}

	public BigCommerceAddress getProducts() {
		return products;
	}

	public BigCommerceOrder setProducts(BigCommerceAddress products) {
		this.products = products;
		return this;
	}

	public List<BigCommerceOrderline> getOrderLines() {
		return orderLines;
	}

	public BigCommerceOrder setOrderLines(List<BigCommerceOrderline> orderLines) {
		this.orderLines = orderLines;
		return this;
	}

	public BigCommerceShippingAddress getBigCommerceShippingAddress() {
		return bigCommerceShippingAddress;
	}

	public BigCommerceOrder setBigCommerceShippingAddress(BigCommerceShippingAddress bigCommerceShippingAddress) {
		this.bigCommerceShippingAddress = bigCommerceShippingAddress;
		return this;
	}

	public String getStaffNotes() {
		return staffNotes;
	}

	public BigCommerceOrder setStaffNotes(String staffNotes) {
		this.staffNotes = staffNotes;
		return this;
	}

}
