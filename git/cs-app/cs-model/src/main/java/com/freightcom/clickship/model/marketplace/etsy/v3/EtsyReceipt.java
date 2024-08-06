package com.freightcom.clickship.model.marketplace.etsy.v3;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EtsyReceipt implements Serializable {

	private static final long serialVersionUID = -3045906893179269311L;

	@JsonProperty("receipt_id")
	private Long receiptId;

	@JsonProperty("receipt_type")
	private Long receiptType;

	@JsonProperty("seller_user_id")
	private Long sellerUserId;
	
	@JsonProperty("seller_email")
	private String sellerEmail;

	@JsonProperty("buyer_user_id")
	private Long buyerUserId;
	
	@JsonProperty("buyer_email")
	private String buyerEmail;

	@JsonProperty("name")
	private String name;

	@JsonProperty("first_line")
	private String firstLine;

	@JsonProperty("second_line")
	private String secondLine;

	@JsonProperty("city")
	private String city;

	@JsonProperty("state")
	private String state;

	@JsonProperty("zip")
	private String zip;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("formatted_address")
	private String formattedAddress;

	@JsonProperty("country_iso")
	private String countryCode;
	
	@JsonProperty("payment_method")
	private String paymentMethod;

	@JsonProperty("payment_email")
	private String paymentEmail;
	
	@JsonProperty("message_from_payment")
	private String messageFromPayment;

	@JsonProperty("message_from_seller")
	private String messageFromSeller;

	@JsonProperty("message_from_buyer")
	private String messageFromBuyer;

	@JsonProperty("is_shipped")
	private Boolean isShipped;
	
	@JsonProperty("is_paid")
	private Boolean isPaid;
	
	@JsonProperty("is_gift")
	private Boolean isGift;
	
	@JsonProperty("gift_message")
	private String giftMessage;
	
	@JsonProperty("grandtotal")
	private EtsyPrice grandTotal;
	
	@JsonProperty("subtotal")
	private EtsyPrice subTotal;
	
	@JsonProperty("total_price")
	private EtsyPrice totalPrice;
	
	@JsonProperty("total_shipping_cost")
	private EtsyPrice totalShippingCost	;

	@JsonProperty("total_tax_cost")
	private EtsyPrice totalTaxCost;

	@JsonProperty("total_vat_cost")
	private EtsyPrice totalVatCost;
	
	@JsonProperty("discount_amt")
	private EtsyPrice discountAmt;
	
	@JsonProperty("gift_wrap_price")
	private EtsyPrice giftWrap;

	@JsonProperty("create_timestamp")
	private Long createTimestamp;
	
	@JsonProperty("created_timestamp")
	private Long createdTimestamp;
	
	@JsonProperty("update_timestamp")
	private Long updateTimestamp;
	
	@JsonProperty("updated_timestamp")
	private Long updatedTimestamp;

	@JsonProperty("shipments")
	private List<EtsyReceiptShipment> shipments;

	@JsonProperty("refunds")
	private List<EtsyReceiptRefund> refunds;
	
	@JsonProperty("transactions")
	private List<EtsyReceiptTransaction> transactions;

	public Long getReceiptId() {
		return receiptId;
	}

	public EtsyReceipt setReceiptId(Long receiptId) {
		this.receiptId = receiptId;
		return this;
	}

	public Long getReceiptType() {
		return receiptType;
	}

	public EtsyReceipt setReceiptType(Long receiptType) {
		this.receiptType = receiptType;
		return this;
	}

	public Long getSellerUserId() {
		return sellerUserId;
	}

	public EtsyReceipt setSellerUserId(Long sellerUserId) {
		this.sellerUserId = sellerUserId;
		return this;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public EtsyReceipt setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
		return this;
	}

	public Long getBuyerUserId() {
		return buyerUserId;
	}

	public EtsyReceipt setBuyerUserId(Long buyerUserId) {
		this.buyerUserId = buyerUserId;
		return this;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	public EtsyReceipt setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
		return this;
	}

	public String getName() {
		return name;
	}

	public EtsyReceipt setName(String name) {
		this.name = name;
		return this;
	}

	public String getFirstLine() {
		return firstLine;
	}

	public EtsyReceipt setFirstLine(String firstLine) {
		this.firstLine = firstLine;
		return this;
	}

	public String getSecondLine() {
		return secondLine;
	}

	public EtsyReceipt setSecondLine(String secondLine) {
		this.secondLine = secondLine;
		return this;
	}

	public String getCity() {
		return city;
	}

	public EtsyReceipt setCity(String city) {
		this.city = city;
		return this;
	}

	public String getState() {
		return state;
	}

	public EtsyReceipt setState(String state) {
		this.state = state;
		return this;
	}

	public String getZip() {
		return zip;
	}

	public EtsyReceipt setZip(String zip) {
		this.zip = zip;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public EtsyReceipt setStatus(String status) {
		this.status = status;
		return this;
	}

	public String getFormattedAddress() {
		return formattedAddress;
	}

	public EtsyReceipt setFormattedAddress(String formattedAddress) {
		this.formattedAddress = formattedAddress;
		return this;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public EtsyReceipt setCountryCode(String countryCode) {
		this.countryCode = countryCode;
		return this;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public EtsyReceipt setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
		return this;
	}

	public String getPaymentEmail() {
		return paymentEmail;
	}

	public EtsyReceipt setPaymentEmail(String paymentEmail) {
		this.paymentEmail = paymentEmail;
		return this;
	}

	public String getMessageFromPayment() {
		return messageFromPayment;
	}

	public EtsyReceipt setMessageFromPayment(String messageFromPayment) {
		this.messageFromPayment = messageFromPayment;
		return this;
	}

	public String getMessageFromSeller() {
		return messageFromSeller;
	}

	public EtsyReceipt setMessageFromSeller(String messageFromSeller) {
		this.messageFromSeller = messageFromSeller;
		return this;
	}

	public String getMessageFromBuyer() {
		return messageFromBuyer;
	}

	public EtsyReceipt setMessageFromBuyer(String messageFromBuyer) {
		this.messageFromBuyer = messageFromBuyer;
		return this;
	}

	public Boolean getIsShipped() {
		return isShipped;
	}

	public EtsyReceipt setIsShipped(Boolean isShipped) {
		this.isShipped = isShipped;
		return this;
	}

	public Boolean getIsPaid() {
		return isPaid;
	}

	public EtsyReceipt setIsPaid(Boolean isPaid) {
		this.isPaid = isPaid;
		return this;
	}

	public Boolean getIsGift() {
		return isGift;
	}

	public EtsyReceipt setIsGift(Boolean isGift) {
		this.isGift = isGift;
		return this;
	}

	public String getGiftMessage() {
		return giftMessage;
	}

	public EtsyReceipt setGiftMessage(String giftMessage) {
		this.giftMessage = giftMessage;
		return this;
	}

	public EtsyPrice getGrandTotal() {
		return grandTotal;
	}

	public EtsyReceipt setGrandTotal(EtsyPrice grandTotal) {
		this.grandTotal = grandTotal;
		return this;
	}

	public EtsyPrice getSubTotal() {
		return subTotal;
	}

	public EtsyReceipt setSubTotal(EtsyPrice subTotal) {
		this.subTotal = subTotal;
		return this;
	}

	public EtsyPrice getTotalPrice() {
		return totalPrice;
	}

	public EtsyReceipt setTotalPrice(EtsyPrice totalPrice) {
		this.totalPrice = totalPrice;
		return this;
	}

	public EtsyPrice getTotalShippingCost() {
		return totalShippingCost;
	}

	public EtsyReceipt setTotalShippingCost(EtsyPrice totalShippingCost) {
		this.totalShippingCost = totalShippingCost;
		return this;
	}

	public EtsyPrice getTotalTaxCost() {
		return totalTaxCost;
	}

	public EtsyReceipt setTotalTaxCost(EtsyPrice totalTaxCost) {
		this.totalTaxCost = totalTaxCost;
		return this;
	}

	public EtsyPrice getTotalVatCost() {
		return totalVatCost;
	}

	public EtsyReceipt setTotalVatCost(EtsyPrice totalVatCost) {
		this.totalVatCost = totalVatCost;
		return this;
	}

	public EtsyPrice getDiscountAmt() {
		return discountAmt;
	}

	public EtsyReceipt setDiscountAmt(EtsyPrice discountAmt) {
		this.discountAmt = discountAmt;
		return this;
	}

	public EtsyPrice getGiftWrap() {
		return giftWrap;
	}

	public EtsyReceipt setGiftWrap(EtsyPrice giftWrap) {
		this.giftWrap = giftWrap;
		return this;
	}

	public Long getCreateTimestamp() {
		return createTimestamp;
	}

	public EtsyReceipt setCreateTimestamp(Long createTimestamp) {
		this.createTimestamp = createTimestamp;
		return this;
	}

	public Long getCreatedTimestamp() {
		return createdTimestamp;
	}

	public EtsyReceipt setCreatedTimestamp(Long createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
		return this;
	}

	public Long getUpdateTimestamp() {
		return updateTimestamp;
	}

	public EtsyReceipt setUpdateTimestamp(Long updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
		return this;
	}

	public Long getUpdatedTimestamp() {
		return updatedTimestamp;
	}

	public EtsyReceipt setUpdatedTimestamp(Long updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
		return this;
	}

	public List<EtsyReceiptShipment> getShipments() {
		return shipments;
	}

	public EtsyReceipt setShipments(List<EtsyReceiptShipment> shipments) {
		this.shipments = shipments;
		return this;
	}

	public List<EtsyReceiptRefund> getRefunds() {
		return refunds;
	}

	public EtsyReceipt setRefunds(List<EtsyReceiptRefund> refunds) {
		this.refunds = refunds;
		return this;
	}

	public List<EtsyReceiptTransaction> getTransactions() {
		return transactions;
	}

	public EtsyReceipt setTransactions(List<EtsyReceiptTransaction> transactions) {
		this.transactions = transactions;
		return this;
	}
	
}
