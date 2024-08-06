package com.freightcom.clickship.model.marketplace.squarespace;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SquareSpaceOrder {

    @JsonProperty("id")
    private String id;

    @JsonProperty("orderNumber")
    private String orderNumber;

    @JsonProperty("createdOn")
    private String createdOn;

    @JsonProperty("modifiedOn")
    private String modifiedOn;

    @JsonProperty("customerEmail")
    private String customerEmail;

    @JsonProperty("billingAddress")
    private SquareSpaceAddress billingAddress;

    @JsonProperty("shippingAddress")
    private SquareSpaceAddress shippingAddress;

    @JsonProperty("fulfillmentStatus")
    private String fulfillmentStatus;

    @JsonProperty("lineItems")
    private List<SquareSpaceLineItem> lineItems;

    @JsonProperty("internalNotes")
    private List<SquareSpaceNotes> internalNotes;

    @JsonProperty("shippingLines")
    private List<SquareSpaceShippingLines> shippingLines;

    @JsonProperty("discountLines")
    private List<SquareSpaceDiscountLines> discountLines;

    @JsonProperty("fulfillments")
    private List<SquareSpaceFulfillment> squareSpaceFulfillments;

    @JsonProperty("subtotal")
    private SquareSpacePrice subtotal;

    @JsonProperty("shippingTotal")
    private SquareSpacePrice shippingTotal;

    @JsonProperty("discountTotal")
    private SquareSpacePrice discountTotal;

    @JsonProperty("taxTotal")
    private SquareSpacePrice taxTotal;

    @JsonProperty("refundedTotal")
    private SquareSpacePrice refundedTotal;

    @JsonProperty("grandTotal")
    private SquareSpacePrice grandTotal;

    @JsonProperty("fulfilledOn")
    private String fulfilledOn;

    @JsonProperty("priceTaxInterpretation")
    private String priceTaxInterpretation;

    public String getId() {
        return id;
    }

    public SquareSpaceOrder setId(String id) {
        this.id = id;
        return this;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public SquareSpaceOrder setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
        return this;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public SquareSpaceOrder setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public String getModifiedOn() {
        return modifiedOn;
    }

    public SquareSpaceOrder setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
        return this;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public SquareSpaceOrder setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
        return this;
    }

    public SquareSpaceAddress getBillingAddress() {
        return billingAddress;
    }

    public SquareSpaceOrder setBillingAddress(SquareSpaceAddress billingAddress) {
        this.billingAddress = billingAddress;
        return this;
    }

    public SquareSpaceAddress getShippingAddress() {
        return shippingAddress;
    }

    public SquareSpaceOrder setShippingAddress(SquareSpaceAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
        return this;
    }

    public String getFulfillmentStatus() {
        return fulfillmentStatus;
    }

    public SquareSpaceOrder setFulfillmentStatus(String fulfillmentStatus) {
        this.fulfillmentStatus = fulfillmentStatus;
        return this;
    }

    public List<SquareSpaceLineItem> getLineItems() {
        return lineItems;
    }

    public SquareSpaceOrder setLineItems(List<SquareSpaceLineItem> lineItems) {
        this.lineItems = lineItems;
        return this;
    }

    public List<SquareSpaceShippingLines> getShippingLines() {
        return shippingLines;
    }

    public SquareSpaceOrder setShippingLines(List<SquareSpaceShippingLines> shippingLines) {
        this.shippingLines = shippingLines;
        return this;
    }

    public List<SquareSpaceDiscountLines> getDiscountLines() {
        return discountLines;
    }

    public SquareSpaceOrder setDiscountLines(List<SquareSpaceDiscountLines> discountLines) {
        this.discountLines = discountLines;
        return this;
    }

    public List<SquareSpaceFulfillment> getSquareSpaceFulfillments() {
        return squareSpaceFulfillments;
    }

    public SquareSpaceOrder setSquareSpaceFulfillments(List<SquareSpaceFulfillment> squareSpaceFulfillments) {
        this.squareSpaceFulfillments = squareSpaceFulfillments;
        return this;
    }

    public SquareSpacePrice getSubtotal() {
        return subtotal;
    }

    public SquareSpaceOrder setSubtotal(SquareSpacePrice subtotal) {
        this.subtotal = subtotal;
        return this;
    }

    public SquareSpacePrice getShippingTotal() {
        return shippingTotal;
    }

    public SquareSpaceOrder setShippingTotal(SquareSpacePrice shippingTotal) {
        this.shippingTotal = shippingTotal;
        return this;
    }

    public SquareSpacePrice getDiscountTotal() {
        return discountTotal;
    }

    public SquareSpaceOrder setDiscountTotal(SquareSpacePrice discountTotal) {
        this.discountTotal = discountTotal;
        return this;
    }

    public SquareSpacePrice getTaxTotal() {
        return taxTotal;
    }

    public SquareSpaceOrder setTaxTotal(SquareSpacePrice taxTotal) {
        this.taxTotal = taxTotal;
        return this;
    }

    public SquareSpacePrice getRefundedTotal() {
        return refundedTotal;
    }

    public SquareSpaceOrder setRefundedTotal(SquareSpacePrice refundedTotal) {
        this.refundedTotal = refundedTotal;
        return this;
    }

    public SquareSpacePrice getGrandTotal() {
        return grandTotal;
    }

    public SquareSpaceOrder setGrandTotal(SquareSpacePrice grandTotal) {
        this.grandTotal = grandTotal;
        return this;
    }

    public String getFulfilledOn() {
        return fulfilledOn;
    }

    public SquareSpaceOrder setFulfilledOn(String fulfilledOn) {
        this.fulfilledOn = fulfilledOn;
        return this;
    }

    public String getPriceTaxInterpretation() {
        return priceTaxInterpretation;
    }

    public SquareSpaceOrder setPriceTaxInterpretation(String priceTaxInterpretation) {
        this.priceTaxInterpretation = priceTaxInterpretation;
        return this;
    }

    public List<SquareSpaceNotes> getInternalNotes() {
        return internalNotes;
    }

    public SquareSpaceOrder setInternalNotes(List<SquareSpaceNotes> internalNotes) {
        this.internalNotes = internalNotes;
        return this;
    }
}
