
package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "carrierType")
@XmlEnum
public enum CarrierType {

    UPS("UPS"),
    USPS("USPS"),
    @XmlEnumValue("FedEx")
    FED_EX("FedEx"),
    CPC("CPC"),
    PCLINT("PCLINT"),
    DHL("DHL"),
    GLB("GLB");
    private final String value;

    CarrierType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CarrierType fromValue(String v) {
        for (CarrierType c: CarrierType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
