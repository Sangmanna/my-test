package com.freightcom.clickship.model.marketplace.woocommerce;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WooCommerceOrder implements Serializable {

	private static final long serialVersionUID = -8244792234822729478L;

	private Long id;
	
	@JsonProperty("parent_id")
	private Long parentId;
	
	private String number;
	
	@JsonProperty("order_key")
	private String orderKey;
	
	@JsonProperty("created_via")
	private String createdVia;
	
	private String version;
	
	private String status;
	
	private String currency;
	
	@JsonProperty("discount_total")
	private String discountTotal;

	@JsonProperty("discount_tax")
	private String discountTax;
	
	@JsonProperty("shipping_total")
	private String shippingTotal;
	
	@JsonProperty("shipping_tax")
	private String shippingTax;
	
	@JsonProperty("cart_tax")
	private String cartTax;

	private String total;
	
	@JsonProperty("total_tax")
	private String totalTax;
	
	@JsonProperty("prices_include_tax")
	private boolean pricesIncludeTax;
	
	@JsonProperty("customer_id")
	private Long customerId;
	
	private WooCommerceOrderBilling billing;
	
	private WooCommerceOrderShipping shipping;
	
	@JsonProperty("payment_method")
	private String paymentMethod;
	
	@JsonProperty("payment_method_title")
	private String paymentMethodTitle;
	
	@JsonProperty("line_items")
	private List<WooCommerceOrderItems> lineItems;
	
	@JsonProperty("tax_lines")
	private List<WooCommerceOrderItems> taxLines;
	
	@JsonProperty("shipping_lines")
	private List<WooCommerceOrderItems> shippingLines;
	
	@JsonProperty("fee_lines")
	private List<WooCommerceOrderItems> feeLines;
	
	@JsonProperty("coupon_lines")
	private List<WooCommerceOrderItems> couponLines;
	
	@JsonProperty("date_created")
	private Date dateCreated;
	
	@JsonProperty("date_created_gmt")
	private Date dateCreatedGmt;
	
	@JsonProperty("date_modified")
	private Date dateModified;
	
	@JsonProperty("date_modified_gmt")
	private Date dateModifiedGmt;

	public Long getId() {
		return id;
	}

	public WooCommerceOrder setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getParentId() {
		return parentId;
	}

	public WooCommerceOrder setParentId(Long parentId) {
		this.parentId = parentId;
		return this;
	}

	public String getNumber() {
		return number;
	}

	public WooCommerceOrder setNumber(String number) {
		this.number = number;
		return this;
	}

	public String getOrderKey() {
		return orderKey;
	}

	public WooCommerceOrder setOrderKey(String orderKey) {
		this.orderKey = orderKey;
		return this;
	}

	public String getCreatedVia() {
		return createdVia;
	}

	public WooCommerceOrder setCreatedVia(String createdVia) {
		this.createdVia = createdVia;
		return this;
	}

	public String getVersion() {
		return version;
	}

	public WooCommerceOrder setVersion(String version) {
		this.version = version;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public WooCommerceOrder setStatus(String status) {
		this.status = status;
		return this;
	}

	public String getCurrency() {
		return currency;
	}

	public WooCommerceOrder setCurrency(String currency) {
		this.currency = currency;
		return this;
	}

	public String getDiscountTotal() {
		return discountTotal;
	}

	public WooCommerceOrder setDiscountTotal(String discountTotal) {
		this.discountTotal = discountTotal;
		return this;
	}

	public String getDiscountTax() {
		return discountTax;
	}

	public WooCommerceOrder setDiscountTax(String discountTax) {
		this.discountTax = discountTax;
		return this;
	}

	public String getShippingTotal() {
		return shippingTotal;
	}

	public WooCommerceOrder setShippingTotal(String shippingTotal) {
		this.shippingTotal = shippingTotal;
		return this;
	}

	public String getShippingTax() {
		return shippingTax;
	}

	public WooCommerceOrder setShippingTax(String shippingTax) {
		this.shippingTax = shippingTax;
		return this;
	}

	public String getCartTax() {
		return cartTax;
	}

	public WooCommerceOrder setCartTax(String cartTax) {
		this.cartTax = cartTax;
		return this;
	}

	public String getTotal() {
		return total;
	}

	public WooCommerceOrder setTotal(String total) {
		this.total = total;
		return this;
	}

	public String getTotalTax() {
		return totalTax;
	}

	public WooCommerceOrder setTotalTax(String totalTax) {
		this.totalTax = totalTax;
		return this;
	}

	public boolean isPricesIncludeTax() {
		return pricesIncludeTax;
	}

	public WooCommerceOrder setPricesIncludeTax(boolean pricesIncludeTax) {
		this.pricesIncludeTax = pricesIncludeTax;
		return this;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public WooCommerceOrder setCustomerId(Long customerId) {
		this.customerId = customerId;
		return this;
	}

	public WooCommerceOrderBilling getBilling() {
		return billing;
	}

	public WooCommerceOrder setBilling(WooCommerceOrderBilling billing) {
		this.billing = billing;
		return this;
	}

	public WooCommerceOrderShipping getShipping() {
		return shipping;
	}

	public WooCommerceOrder setShipping(WooCommerceOrderShipping shipping) {
		this.shipping = shipping;
		return this;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public WooCommerceOrder setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
		return this;
	}

	public String getPaymentMethodTitle() {
		return paymentMethodTitle;
	}

	public WooCommerceOrder setPaymentMethodTitle(String paymentMethodTitle) {
		this.paymentMethodTitle = paymentMethodTitle;
		return this;
	}

	public List<WooCommerceOrderItems> getLineItems() {
		return lineItems;
	}

	public WooCommerceOrder setLineItems(List<WooCommerceOrderItems> lineItems) {
		this.lineItems = lineItems;
		return this;
	}

	public List<WooCommerceOrderItems> getTaxLines() {
		return taxLines;
	}

	public WooCommerceOrder setTaxLines(List<WooCommerceOrderItems> taxLines) {
		this.taxLines = taxLines;
		return this;
	}

	public List<WooCommerceOrderItems> getShippingLines() {
		return shippingLines;
	}

	public WooCommerceOrder setShippingLines(List<WooCommerceOrderItems> shippingLines) {
		this.shippingLines = shippingLines;
		return this;
	}

	public List<WooCommerceOrderItems> getFeeLines() {
		return feeLines;
	}

	public WooCommerceOrder setFeeLines(List<WooCommerceOrderItems> feeLines) {
		this.feeLines = feeLines;
		return this;
	}

	public List<WooCommerceOrderItems> getCouponLines() {
		return couponLines;
	}

	public WooCommerceOrder setCouponLines(List<WooCommerceOrderItems> couponLines) {
		this.couponLines = couponLines;
		return this;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public WooCommerceOrder setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
		return this;
	}

	public Date getDateCreatedGmt() {
		return dateCreatedGmt;
	}

	public WooCommerceOrder setDateCreatedGmt(Date dateCreatedGmt) {
		this.dateCreatedGmt = dateCreatedGmt;
		return this;
	}

	public Date getDateModified() {
		return dateModified;
	}

	public WooCommerceOrder setDateModified(Date dateModified) {
		this.dateModified = dateModified;
		return this;
	}

	public Date getDateModifiedGmt() {
		return dateModifiedGmt;
	}

	public WooCommerceOrder setDateModifiedGmt(Date dateModifiedGmt) {
		this.dateModifiedGmt = dateModifiedGmt;
		return this;
	}
	
}
