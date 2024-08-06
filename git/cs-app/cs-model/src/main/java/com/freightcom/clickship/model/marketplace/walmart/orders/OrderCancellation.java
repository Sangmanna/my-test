
package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "orderLines"
})
//@XmlRootElement(name = "orderCancellation")
public class OrderCancellation {

    @XmlElement(required = true)
    protected CancelLinesType orderLines;

    public CancelLinesType getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(CancelLinesType value) {
        this.orderLines = value;
    }

}
