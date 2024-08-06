
package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderLineStatusesType", propOrder = {
    "orderLineStatus"
})
public class OrderLineStatusesType {

    protected List<OrderLineStatusType> orderLineStatus;

    public List<OrderLineStatusType> getOrderLineStatus() {
        if (orderLineStatus == null) {
            orderLineStatus = new ArrayList<OrderLineStatusType>();
        }
        return this.orderLineStatus;
    }

}
