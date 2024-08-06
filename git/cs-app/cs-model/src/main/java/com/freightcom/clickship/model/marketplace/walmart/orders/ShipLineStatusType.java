
package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "shipLineStatusType", propOrder = {
    "status",
    "asn",
    "statusQuantity",
    "trackingInfo"
})
public class ShipLineStatusType {

    @XmlElement(required = true)
    protected String status;
    protected AsnType asn;
    @XmlElement(required = true)
    protected QuantityType statusQuantity;
    @XmlElement(required = true)
    protected TrackingInfoType trackingInfo;

    public String getStatus() {
        return status;
    }

    public void setStatus(String value) {
        this.status = value;
    }

    public AsnType getAsn() {
        return asn;
    }

    public void setAsn(AsnType value) {
        this.asn = value;
    }

    public QuantityType getStatusQuantity() {
        return statusQuantity;
    }

    public void setStatusQuantity(QuantityType value) {
        this.statusQuantity = value;
    }

    public TrackingInfoType getTrackingInfo() {
        return trackingInfo;
    }

    public void setTrackingInfo(TrackingInfoType value) {
        this.trackingInfo = value;
    }

}
