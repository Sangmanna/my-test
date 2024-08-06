
package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "carrierNameType", propOrder = {
    "otherCarrier",
    "carrier"
})
public class CarrierNameType {

    protected String otherCarrier;
    protected CarrierType carrier;

    public String getOtherCarrier() {
        return otherCarrier;
    }

    public void setOtherCarrier(String value) {
        this.otherCarrier = value;
    }

    public CarrierType getCarrier() {
        return carrier;
    }

    public void setCarrier(CarrierType value) {
        this.carrier = value;
    }

}
