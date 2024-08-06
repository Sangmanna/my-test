
package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "refundLinesType", propOrder = {
    "orderLine"
})
public class RefundLinesType {

    @XmlElement(required = true)
    protected List<RefundLineType> orderLine;

    public List<RefundLineType> getOrderLine() {
        if (orderLine == null) {
            orderLine = new ArrayList<RefundLineType>();
        }
        return this.orderLine;
    }

}
