
package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderLineStatusType", propOrder = {
    "status",
    "statusQuantity",
    "cancellationReason",
    "trackingInfo"
})
public class OrderLineStatusType {

    @XmlElement(required = true)
    protected OrderLineStatusValueType status;
    @XmlElement(required = true)
    protected QuantityType statusQuantity;
    protected String cancellationReason;
    protected TrackingInfoType trackingInfo;

    public OrderLineStatusValueType getStatus() {
        return status;
    }

    public void setStatus(OrderLineStatusValueType value) {
        this.status = value;
    }

    public QuantityType getStatusQuantity() {
        return statusQuantity;
    }

    public void setStatusQuantity(QuantityType value) {
        this.statusQuantity = value;
    }

    public String getCancellationReason() {
        return cancellationReason;
    }

    public void setCancellationReason(String value) {
        this.cancellationReason = value;
    }

    public TrackingInfoType getTrackingInfo() {
        return trackingInfo;
    }

    public void setTrackingInfo(TrackingInfoType value) {
        this.trackingInfo = value;
    }

}
