package com.freightcom.clickship.model.marketplace.reverb;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
public class ReverbOrder {
	@JsonProperty("amount_product")
	private ReverbProductAmount amountProduct;
	@JsonProperty("presentment_amount_product")
	private ReverbProductAmount presentmentAmountProduct;
	@JsonProperty("amount_product_subtotal")
	private ReverbProductAmount amountProductSubtotal;
	@JsonProperty("presentment_amount_product_subtotal")
	private ReverbProductAmount presentmentAmountProductSubtotal;
	@JsonProperty("shipping")
	private ReverbProductAmount shipping;
	@JsonProperty("presentment_amount_shipping")
	private ReverbProductAmount presentmentAmountShipping;
	@JsonProperty("amount_tax")
	private ReverbProductAmount amountTax;
	@JsonProperty("presentment_amount_tax")
	private ReverbProductAmount presentmentAmountTax;
	@JsonProperty("total")
	private ReverbProductAmount total;
	@JsonProperty("presentment_amount_total")
	private ReverbProductAmount presentmentAmountTotal;
	@JsonProperty("shipping_taxed")
	private String shippingTaxed;
	@JsonProperty("buyer_name")
	private String buyerName;
	@JsonProperty("buyer_first_name")
	private String buyerFirstName;
	@JsonProperty("buyer_email")
	private String buyerEmail;
	@JsonProperty("buyer_last_name")
	private String buyerLastName;
	@JsonProperty("buyer_id")
	private String buyerId;
	@JsonProperty("created_at")
	private String createdAt;
	@JsonProperty("order_number")
	private String orderNumber;
	@JsonProperty("tax_rate")
	private String taxRate;
	@JsonProperty("order_source")
	private String orderSource;
	@JsonProperty("needs_feedback_for_buyer")
	private String needsFeedbackForBuyer;
	@JsonProperty("needs_feedback_for_seller")
	private String needsFeedbackForSeller;
	@JsonProperty("order_type")
	private String orderType;
	@JsonProperty("paid_at")
	private String paidAt;
	@JsonProperty("quantity")
	private String quantity;
	@JsonProperty("shipping_date")
	private String shippingDate;
	@JsonProperty("shipped_at")
	private String shippedAt;
	@JsonProperty("shipping_method")
	private String shippingMethod;
	@JsonProperty("shipment_status")
	private String shipmentStatus;
	@JsonProperty("local_pickup")
	private boolean localPickup;
	@JsonProperty("shop_name")
	private String shopName;
	@JsonProperty("status")
	private String status;
	@JsonProperty("title")
	private String title;
	@JsonProperty("updated_at")
	private String updatedAt;
	@JsonProperty("payment_method")
	private String paymentMethod;
	@JsonProperty("order_bundle_id")
	private String orderBundleId;
	@JsonProperty("product_id")
	private String productId;
	@JsonProperty("uuid")
	private String uuid;
	@JsonProperty("photos")
	private List<ReverbOrderPhotosLinks> photos;
	@JsonProperty("sku")
	private String sku;
	@JsonProperty("remaining_listing_inventory")
	private String remainingListingInventory;
	@JsonProperty("shipping_address")
	private ReverbShippingAddress shippingAddress;
	@JsonProperty("selling_fee")
	private ReverbProductAmount sellingFee;
	@JsonProperty("direct_checkout_fee")
	private ReverbProductAmount directCheckoutFee;
	@JsonProperty("tax_on_fees")
	private ReverbProductAmount taxOnFees;
	@JsonProperty("tax_responsible_party")
	private String taxResponsibleParty;
	@JsonProperty("direct_checkout_payout")
	private ReverbProductAmount directCheckoutPayout;
	@JsonProperty("order_notes")
	private List<ReverbOrderNotes> orderNotes;
	@JsonProperty("shipping_provider")
	private String shippingProvider;
	@JsonProperty("shipping_code")
	private String shippingCode;

	
	public String getShippingProvider() {
		return shippingProvider;
	}
	public void setShippingProvider(String shippingProvider) {
		this.shippingProvider = shippingProvider;
	}
	public String getShippingCode() {
		return shippingCode;
	}
	public void setShippingCode(String shippingCode) {
		this.shippingCode = shippingCode;
	}
	public ReverbProductAmount getAmountProduct() {
		return amountProduct;
	}
	public void setAmountProduct(ReverbProductAmount amountProduct) {
		this.amountProduct = amountProduct;
	}
	public ReverbProductAmount getPresentmentAmountProduct() {
		return presentmentAmountProduct;
	}
	public void setPresentmentAmountProduct(ReverbProductAmount presentmentAmountProduct) {
		this.presentmentAmountProduct = presentmentAmountProduct;
	}
	public ReverbProductAmount getAmountProductSubtotal() {
		return amountProductSubtotal;
	}
	public void setAmountProductSubtotal(ReverbProductAmount amountProductSubtotal) {
		this.amountProductSubtotal = amountProductSubtotal;
	}
	public ReverbProductAmount getPresentmentAmountProductSubtotal() {
		return presentmentAmountProductSubtotal;
	}
	public void setPresentmentAmountProductSubtotal(ReverbProductAmount presentmentAmountProductSubtotal) {
		this.presentmentAmountProductSubtotal = presentmentAmountProductSubtotal;
	}
	public ReverbProductAmount getShipping() {
		return shipping;
	}
	public void setShipping(ReverbProductAmount shipping) {
		this.shipping = shipping;
	}
	public ReverbProductAmount getPresentmentAmountShipping() {
		return presentmentAmountShipping;
	}
	public void setPresentmentAmountShipping(ReverbProductAmount presentmentAmountShipping) {
		this.presentmentAmountShipping = presentmentAmountShipping;
	}
	public ReverbProductAmount getAmountTax() {
		return amountTax;
	}
	public void setAmountTax(ReverbProductAmount amountTax) {
		this.amountTax = amountTax;
	}
	public ReverbProductAmount getPresentmentAmountTax() {
		return presentmentAmountTax;
	}
	public void setPresentmentAmountTax(ReverbProductAmount presentmentAmountTax) {
		this.presentmentAmountTax = presentmentAmountTax;
	}
	public ReverbProductAmount getTotal() {
		return total;
	}
	public void setTotal(ReverbProductAmount total) {
		this.total = total;
	}
	public ReverbProductAmount getPresentmentAmountTotal() {
		return presentmentAmountTotal;
	}
	public void setPresentmentAmountTotal(ReverbProductAmount presentmentAmountTotal) {
		this.presentmentAmountTotal = presentmentAmountTotal;
	}
	public String getShippingTaxed() {
		return shippingTaxed;
	}
	public void setShippingTaxed(String shippingTaxed) {
		this.shippingTaxed = shippingTaxed;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getBuyerFirstName() {
		return buyerFirstName;
	}
	public void setBuyerFirstName(String buyerFirstName) {
		this.buyerFirstName = buyerFirstName;
	}
	public String getBuyerEmail() {
		return buyerEmail;
	}
	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}
	public String getBuyerLastName() {
		return buyerLastName;
	}
	public void setBuyerLastName(String buyerLastName) {
		this.buyerLastName = buyerLastName;
	}
	public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(String taxRate) {
		this.taxRate = taxRate;
	}
	public String getOrderSource() {
		return orderSource;
	}
	public void setOrderSource(String orderSource) {
		this.orderSource = orderSource;
	}
	public String getNeedsFeedbackForBuyer() {
		return needsFeedbackForBuyer;
	}
	public void setNeedsFeedbackForBuyer(String needsFeedbackForBuyer) {
		this.needsFeedbackForBuyer = needsFeedbackForBuyer;
	}
	public String getNeedsFeedbackForSeller() {
		return needsFeedbackForSeller;
	}
	public void setNeedsFeedbackForSeller(String needsFeedbackForSeller) {
		this.needsFeedbackForSeller = needsFeedbackForSeller;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getPaidAt() {
		return paidAt;
	}
	public void setPaidAt(String paidAt) {
		this.paidAt = paidAt;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getShippingDate() {
		return shippingDate;
	}
	public void setShippingDate(String shippingDate) {
		this.shippingDate = shippingDate;
	}
	public String getShippedAt() {
		return shippedAt;
	}
	public void setShippedAt(String shippedAt) {
		this.shippedAt = shippedAt;
	}
	public String getShippingMethod() {
		return shippingMethod;
	}
	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}
	public String getShipmentStatus() {
		return shipmentStatus;
	}
	public void setShipmentStatus(String shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}
	public boolean isLocalPickup() {
		return localPickup;
	}
	public void setLocalPickup(boolean localPickup) {
		this.localPickup = localPickup;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getOrderBundleId() {
		return orderBundleId;
	}
	public void setOrderBundleId(String orderBundleId) {
		this.orderBundleId = orderBundleId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public List<ReverbOrderPhotosLinks> getPhotos() {
		return photos;
	}
	public void setPhotos(List<ReverbOrderPhotosLinks> photos) {
		this.photos = photos;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getRemainingListingInventory() {
		return remainingListingInventory;
	}
	public void setRemainingListingInventory(String remainingListingInventory) {
		this.remainingListingInventory = remainingListingInventory;
	}
	public ReverbShippingAddress getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(ReverbShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public ReverbProductAmount getSellingFee() {
		return sellingFee;
	}
	public void setSellingFee(ReverbProductAmount sellingFee) {
		this.sellingFee = sellingFee;
	}
	public ReverbProductAmount getDirectCheckoutFee() {
		return directCheckoutFee;
	}
	public void setDirectCheckoutFee(ReverbProductAmount directCheckoutFee) {
		this.directCheckoutFee = directCheckoutFee;
	}
	public ReverbProductAmount getTaxOnFees() {
		return taxOnFees;
	}
	public void setTaxOnFees(ReverbProductAmount taxOnFees) {
		this.taxOnFees = taxOnFees;
	}
	public String getTaxResponsibleParty() {
		return taxResponsibleParty;
	}
	public void setTaxResponsibleParty(String taxResponsibleParty) {
		this.taxResponsibleParty = taxResponsibleParty;
	}
	public ReverbProductAmount getDirectCheckoutPayout() {
		return directCheckoutPayout;
	}
	public void setDirectCheckoutPayout(ReverbProductAmount directCheckoutPayout) {
		this.directCheckoutPayout = directCheckoutPayout;
	}
	public List<ReverbOrderNotes> getOrderNotes() {
		return orderNotes;
	}
	public void setOrderNotes(List<ReverbOrderNotes> orderNotes) {
		this.orderNotes = orderNotes;
	}
	
}
