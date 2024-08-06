
package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "refundType", propOrder = {
    "refundId",
    "refundComments",
    "refundCharges"
})
public class RefundType {

    protected String refundId;
    protected String refundComments;
    @XmlElement(required = true)
    protected RefundChargesType refundCharges;

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String value) {
        this.refundId = value;
    }

    public String getRefundComments() {
        return refundComments;
    }

    public void setRefundComments(String value) {
        this.refundComments = value;
    }

    public RefundChargesType getRefundCharges() {
        return refundCharges;
    }

    public void setRefundCharges(RefundChargesType value) {
        this.refundCharges = value;
    }

}
