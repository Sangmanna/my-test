
package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cancelLinesType", propOrder = {
    "orderLine"
})
public class CancelLinesType {

    @XmlElement(required = true)
    protected List<CancelLineType> orderLine;

    public List<CancelLineType> getOrderLine() {
        if (orderLine == null) {
            orderLine = new ArrayList<CancelLineType>();
        }
        return this.orderLine;
    }

    public void setOrderLine(List<CancelLineType> orderLine) {
        this.orderLine = orderLine;
    }
}
