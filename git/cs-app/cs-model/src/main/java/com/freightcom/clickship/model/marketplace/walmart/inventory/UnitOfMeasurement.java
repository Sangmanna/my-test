
package com.freightcom.clickship.model.marketplace.walmart.inventory;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "UnitOfMeasurement")
@XmlEnum
public enum UnitOfMeasurement {

    EACH;

    public String value() {
        return name();
    }

    public static UnitOfMeasurement fromValue(String v) {
        return valueOf(v);
    }

}
