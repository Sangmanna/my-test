
package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "refundChargeType", propOrder = {
    "refundReason",
    "charge"
})
public class RefundChargeType {

    @XmlElement(required = true)
    protected ReasonCodesType refundReason;
    @XmlElement(required = true)
    protected ChargeType charge;

    public ReasonCodesType getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(ReasonCodesType value) {
        this.refundReason = value;
    }

    public ChargeType getCharge() {
        return charge;
    }

    public void setCharge(ChargeType value) {
        this.charge = value;
    }

}
