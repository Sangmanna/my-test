
package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "shippingLinesType", propOrder = {
    "orderLine"
})
public class ShippingLinesType {

    @XmlElement(required = true)
    protected List<ShippingLineType> orderLine;

    public List<ShippingLineType> getOrderLine() {
        if (orderLine == null) {
            orderLine = new ArrayList<ShippingLineType>();
        }
        return this.orderLine;
    }

    public void setOrderLine(List<ShippingLineType> orderLine) {
        this.orderLine = orderLine;
    }

}
