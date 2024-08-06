
package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cancelLineStatusType", propOrder = {
    "status",
    "cancellationReason",
    "statusQuantity"
})
public class CancelLineStatusType {

    @XmlElement(required = true)
    protected String status;
    @XmlElement(required = true)
    protected CancellationReasonType cancellationReason;
    @XmlElement(required = true)
    protected QuantityType statusQuantity;

    public String getStatus() {
        return status;
    }

    public void setStatus(String value) {
        this.status = value;
    }

    public CancellationReasonType getCancellationReason() {
        return cancellationReason;
    }

    public void setCancellationReason(CancellationReasonType value) {
        this.cancellationReason = value;
    }

    public QuantityType getStatusQuantity() {
        return statusQuantity;
    }

    public void setStatusQuantity(QuantityType value) {
        this.statusQuantity = value;
    }

}
