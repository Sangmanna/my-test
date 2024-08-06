package com.freightcom.clickship.model.marketplace.etsy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Receipt implements Serializable {

	private static final long serialVersionUID = -2461426294347412669L;

	@JsonProperty("receipt_id")
	private Long receiptId;

	@JsonProperty("receipt_type")
	private Long receiptType;

	@JsonProperty("order_id")
	private Long orderId;

	@JsonProperty("seller_user_id")
	private Long sellerUserId;

	@JsonProperty("buyer_user_id")
	private Long buyerUserId;

	@JsonProperty("creation_tsz")
	private Float creationTsz;

	@JsonProperty("last_modified_tsz")
	private Float lastModifiedTsz;

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

	@JsonProperty("country_id")
	private Long countryId;

	@JsonProperty("payment_method")
	private String paymentMethod;

	@JsonProperty("payment_email")
	private String paymentEmail;

	@JsonProperty("message_from_seller")
	private String messageFromSeller;

	@JsonProperty("message_from_buyer")
	private String messageFrom_buyer;

	@JsonProperty("was_paid")
	private Boolean wasPaid;

	@JsonProperty("total_tax_cost")
	private Float totalTaxCost;

	@JsonProperty("total_vat_cost")
	private Float totalVatCost;

	@JsonProperty("total_price")
	private Float totalPrice;

	@JsonProperty("total_shipping_cost")
	private Float totalShippingCost;

	@JsonProperty("currency_code")
	private String currencyCode;

	@JsonProperty("message_from_payment")
	private String messageFromPayment;

	@JsonProperty("was_shipped")
	private Boolean wasShipped;

	@JsonProperty("buyer_email")
	private String buyerEmail;

	@JsonProperty("seller_email")
	private String sellerEmail;

	@JsonProperty("discount_amt")
	private Float discountAmt;

	@JsonProperty("subtotal")
	private Float subtotal;

	@JsonProperty("grandtotal")
	private Float grandtotal;

	@JsonProperty("adjusted_grandtotal")
	private Float adjustedGrandtotal;

	@JsonProperty("shipments")
	private ArrayList<ReceiptShipment> shipments;

	@JsonProperty("shipped_date")
	private Float shippedDate;

	public Long getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(Long receiptId) {
		this.receiptId = receiptId;
	}

	public Long getReceiptType() {
		return receiptType;
	}

	public void setReceiptType(Long receiptType) {
		this.receiptType = receiptType;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getSellerUserId() {
		return sellerUserId;
	}

	public void setSellerUserId(Long sellerUserId) {
		this.sellerUserId = sellerUserId;
	}

	public Long getBuyerUserId() {
		return buyerUserId;
	}

	public void setBuyerUserId(Long buyerUserId) {
		this.buyerUserId = buyerUserId;
	}

	public Float getCreationTsz() {
		return creationTsz;
	}

	public void setCreationTsz(Float creationTsz) {
		this.creationTsz = creationTsz;
	}

	public Float getLastModifiedTsz() {
		return lastModifiedTsz;
	}

	public void setLastModifiedTsz(Float lastModifiedTsz) {
		this.lastModifiedTsz = lastModifiedTsz;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstLine() {
		return firstLine;
	}

	public void setFirstLine(String firstLine) {
		this.firstLine = firstLine;
	}

	public String getSecondLine() {
		return secondLine;
	}

	public void setSecondLine(String secondLine) {
		this.secondLine = secondLine;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentEmail() {
		return paymentEmail;
	}

	public void setPaymentEmail(String paymentEmail) {
		this.paymentEmail = paymentEmail;
	}

	public String getMessageFromSeller() {
		return messageFromSeller;
	}

	public void setMessageFromSeller(String messageFromSeller) {
		this.messageFromSeller = messageFromSeller;
	}

	public String getMessageFrom_buyer() {
		return messageFrom_buyer;
	}

	public void setMessageFrom_buyer(String messageFrom_buyer) {
		this.messageFrom_buyer = messageFrom_buyer;
	}

	public Boolean getWasPaid() {
		return wasPaid;
	}

	public void setWasPaid(Boolean wasPaid) {
		this.wasPaid = wasPaid;
	}

	public Float getTotalTaxCost() {
		return totalTaxCost;
	}

	public void setTotalTaxCost(Float totalTaxCost) {
		this.totalTaxCost = totalTaxCost;
	}

	public Float getTotalVatCost() {
		return totalVatCost;
	}

	public void setTotalVatCost(Float totalVatCost) {
		this.totalVatCost = totalVatCost;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Float getTotalShippingCost() {
		return totalShippingCost;
	}

	public void setTotalShippingCost(Float totalShippingCost) {
		this.totalShippingCost = totalShippingCost;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getMessageFromPayment() {
		return messageFromPayment;
	}

	public void setMessageFromPayment(String messageFromPayment) {
		this.messageFromPayment = messageFromPayment;
	}

	public Boolean getWasShipped() {
		return wasShipped;
	}

	public void setWasShipped(Boolean wasShipped) {
		this.wasShipped = wasShipped;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}

	public Float getDiscountAmt() {
		return discountAmt;
	}

	public void setDiscountAmt(Float discountAmt) {
		this.discountAmt = discountAmt;
	}

	public Float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Float subtotal) {
		this.subtotal = subtotal;
	}

	public Float getGrandtotal() {
		return grandtotal;
	}

	public void setGrandtotal(Float grandtotal) {
		this.grandtotal = grandtotal;
	}

	public Float getAdjustedGrandtotal() {
		return adjustedGrandtotal;
	}

	public void setAdjustedGrandtotal(Float adjustedGrandtotal) {
		this.adjustedGrandtotal = adjustedGrandtotal;
	}

	public ArrayList<ReceiptShipment> getShipments() {
		return shipments;
	}

	public void setShipments(ArrayList<ReceiptShipment> shipments) {
		this.shipments = shipments;
	}

	public Float getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(Float shippedDate) {
		this.shippedDate = shippedDate;
	}
}
