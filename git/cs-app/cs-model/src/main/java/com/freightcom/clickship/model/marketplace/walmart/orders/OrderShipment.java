
package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "orderLines"
})
public class OrderShipment {

    @XmlElement(required = true)
    protected ShippingLinesType orderLines;

    public ShippingLinesType getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(ShippingLinesType value) {
        this.orderLines = value;
    }

}
