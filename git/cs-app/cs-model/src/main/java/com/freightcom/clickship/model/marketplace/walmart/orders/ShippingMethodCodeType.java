
package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "shippingMethodCodeType")
@XmlEnum
public enum ShippingMethodCodeType {

    @XmlEnumValue("Standard")
    STANDARD("Standard"),
    @XmlEnumValue("Express")
    EXPRESS("Express"),
    @XmlEnumValue("OneDay")
    ONE_DAY("OneDay"),
    @XmlEnumValue("Freight")
    FREIGHT("Freight"),
    @XmlEnumValue("WhiteGlove")
    WHITE_GLOVE("WhiteGlove"),
    @XmlEnumValue("Value")
    VALUE("Value");
    private final String value;

    ShippingMethodCodeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ShippingMethodCodeType fromValue(String v) {
        for (ShippingMethodCodeType c: ShippingMethodCodeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
