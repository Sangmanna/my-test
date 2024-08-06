package com.freightcom.clickship.model.marketplace.ebay;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EbayOrder {

//    @JsonProperty("buyer")
//    private Buyer buyer = null;

//    @JsonProperty("buyerCheckoutNotes")
//    private String buyerCheckoutNotes = null;

    @JsonProperty("cancelStatus")
    private CancelStatus cancelStatus;

    @JsonProperty("creationDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date creationDate;

//    @JsonProperty("ebayCollectAndRemitTax")
//    private Boolean ebayCollectAndRemitTax = null;

    @JsonProperty("fulfillmentHrefs")
    private List<String> fulfillmentHrefs;

    @JsonProperty("fulfillmentStartInstructions")
    private List<FulfillmentStartInstruction> fulfillmentStartInstructions;

    @JsonProperty("lastModifiedDate")
    private String lastModifiedDate;

    @JsonProperty("legacyOrderId")
    private String legacyOrderId;

    @JsonProperty("lineItems")
    private List<LineItem> lineItems;

    @JsonProperty("orderFulfillmentStatus")
    private String orderFulfillmentStatus;

    @JsonProperty("orderId")
    private String orderId;

    @JsonProperty("orderPaymentStatus")
    private String orderPaymentStatus;

//    @JsonProperty("paymentSummary")
//    private PaymentSummary paymentSummary;

    @JsonProperty("pricingSummary")
    private PricingSummary pricingSummary;

//    @JsonProperty("salesRecordReference")
//    private String salesRecordReference;

    @JsonProperty("sellerId")
    private String sellerId;

    @JsonProperty("totalFeeBasisAmount")
    private Amount totalFeeBasisAmount;

//    public Buyer getBuyer() {
//        return buyer;
//    }
//
//    public void setBuyer(Buyer buyer) {
//        this.buyer = buyer;
//    }
//
//    public String getBuyerCheckoutNotes() {
//        return buyerCheckoutNotes;
//    }
//
//    public void setBuyerCheckoutNotes(String buyerCheckoutNotes) {
//        this.buyerCheckoutNotes = buyerCheckoutNotes;
//    }

    public CancelStatus getCancelStatus() {
        return cancelStatus;
    }

    public void setCancelStatus(CancelStatus cancelStatus) {
        this.cancelStatus = cancelStatus;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<String> getFulfillmentHrefs() {
        return fulfillmentHrefs;
    }

    public void setFulfillmentHrefs(List<String> fulfillmentHrefs) {
        this.fulfillmentHrefs = fulfillmentHrefs;
    }

    public List<FulfillmentStartInstruction> getFulfillmentStartInstructions() {
        return fulfillmentStartInstructions;
    }

    public void setFulfillmentStartInstructions(List<FulfillmentStartInstruction> fulfillmentStartInstructions) {
        this.fulfillmentStartInstructions = fulfillmentStartInstructions;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLegacyOrderId() {
        return legacyOrderId;
    }

    public void setLegacyOrderId(String legacyOrderId) {
        this.legacyOrderId = legacyOrderId;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public String getOrderFulfillmentStatus() {
        return orderFulfillmentStatus;
    }

    public void setOrderFulfillmentStatus(String orderFulfillmentStatus) {
        this.orderFulfillmentStatus = orderFulfillmentStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderPaymentStatus() {
        return orderPaymentStatus;
    }

    public void setOrderPaymentStatus(String orderPaymentStatus) {
        this.orderPaymentStatus = orderPaymentStatus;
    }

//    public PaymentSummary getPaymentSummary() {
//        return paymentSummary;
//    }
//
//    public void setPaymentSummary(PaymentSummary paymentSummary) {
//        this.paymentSummary = paymentSummary;
//    }

    public PricingSummary getPricingSummary() {
        return pricingSummary;
    }

    public void setPricingSummary(PricingSummary pricingSummary) {
        this.pricingSummary = pricingSummary;
    }

//    public String getSalesRecordReference() {
//        return salesRecordReference;
//    }
//
//    public void setSalesRecordReference(String salesRecordReference) {
//        this.salesRecordReference = salesRecordReference;
//    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public Amount getTotalFeeBasisAmount() {
        return totalFeeBasisAmount;
    }

    public void setTotalFeeBasisAmount(Amount totalFeeBasisAmount) {
        this.totalFeeBasisAmount = totalFeeBasisAmount;
    }
}
