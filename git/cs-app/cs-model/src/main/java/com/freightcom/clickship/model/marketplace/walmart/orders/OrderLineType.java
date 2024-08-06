
package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderLineType", propOrder = {
    "lineNumber",
    "item",
    "charges",
    "orderLineQuantity",
    "statusDate",
    "orderLineStatuses",
    "refund",
    "originalCarrierMethod",
    "referenceLineId",
    "fulfillment",
    "intentToCancel",
    "configId"
})
public class OrderLineType {

    @XmlElement(required = true)
    protected String lineNumber;
    @XmlElement(required = true)
    protected ItemType item;
    @XmlElement(required = true)
    protected ChargesType charges;
    @XmlElement(required = true)
    protected QuantityType orderLineQuantity;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar statusDate;
    @XmlElement(required = true)
    protected OrderLineStatusesType orderLineStatuses;
    protected RefundType refund;
    protected String originalCarrierMethod;
    protected String referenceLineId;
    protected FulfillmentType fulfillment;
    protected String intentToCancel;
    protected String configId;

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String value) {
        this.lineNumber = value;
    }

    public ItemType getItem() {
        return item;
    }

    public void setItem(ItemType value) {
        this.item = value;
    }

    public ChargesType getCharges() {
        return charges;
    }

    public void setCharges(ChargesType value) {
        this.charges = value;
    }

    public QuantityType getOrderLineQuantity() {
        return orderLineQuantity;
    }

    public void setOrderLineQuantity(QuantityType value) {
        this.orderLineQuantity = value;
    }

    public XMLGregorianCalendar getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(XMLGregorianCalendar value) {
        this.statusDate = value;
    }

    public OrderLineStatusesType getOrderLineStatuses() {
        return orderLineStatuses;
    }

    public void setOrderLineStatuses(OrderLineStatusesType value) {
        this.orderLineStatuses = value;
    }

    public RefundType getRefund() {
        return refund;
    }

    public void setRefund(RefundType value) {
        this.refund = value;
    }

    public String getOriginalCarrierMethod() {
        return originalCarrierMethod;
    }

    public void setOriginalCarrierMethod(String value) {
        this.originalCarrierMethod = value;
    }

    public String getReferenceLineId() {
        return referenceLineId;
    }

    public void setReferenceLineId(String value) {
        this.referenceLineId = value;
    }

    public FulfillmentType getFulfillment() {
        return fulfillment;
    }

    public void setFulfillment(FulfillmentType value) {
        this.fulfillment = value;
    }

    public String getIntentToCancel() {
        return intentToCancel;
    }

    public void setIntentToCancel(String value) {
        this.intentToCancel = value;
    }

    public String getConfigId() {
        return configId;
    }

    public void setConfigId(String value) {
        this.configId = value;
    }

}
