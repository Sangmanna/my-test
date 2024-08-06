

package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "trackingInfoType", propOrder = {
    "shipDateTime",
    "carrierName",
    "methodCode",
    "trackingNumber",
    "trackingURL"
})
public class TrackingInfoType {

    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar shipDateTime;
    @XmlElement(required = true)
    protected CarrierNameType carrierName;
    @XmlElement(required = true)
    protected String methodCode;
    @XmlElement(required = true)
    protected String trackingNumber;
    protected String trackingURL;

    public XMLGregorianCalendar getShipDateTime() {
        return shipDateTime;
    }

    public void setShipDateTime(XMLGregorianCalendar value) {
        this.shipDateTime = value;
    }

    public CarrierNameType getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(CarrierNameType value) {
        this.carrierName = value;
    }

    public String getMethodCode() {
        return methodCode;
    }

    public void setMethodCode(String value) {
        this.methodCode = value;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String value) {
        this.trackingNumber = value;
    }

    public String getTrackingURL() {
        return trackingURL;
    }

    public void setTrackingURL(String value) {
        this.trackingURL = value;
    }

}
