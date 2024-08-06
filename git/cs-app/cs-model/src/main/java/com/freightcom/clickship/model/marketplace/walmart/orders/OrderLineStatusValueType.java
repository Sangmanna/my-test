
package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "orderLineStatusValueType")
@XmlEnum
public enum OrderLineStatusValueType {

    @XmlEnumValue("Created")
    CREATED("Created"),
    @XmlEnumValue("Acknowledged")
    ACKNOWLEDGED("Acknowledged"),
    @XmlEnumValue("Shipped")
    SHIPPED("Shipped"),
    @XmlEnumValue("Cancelled")
    CANCELLED("Cancelled"),
    @XmlEnumValue("Refund")
    REFUND("Refund");
    private final String value;

    OrderLineStatusValueType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OrderLineStatusValueType fromValue(String v) {
        for (OrderLineStatusValueType c: OrderLineStatusValueType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
