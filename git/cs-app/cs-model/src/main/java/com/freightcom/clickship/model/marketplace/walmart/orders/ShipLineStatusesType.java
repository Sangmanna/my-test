
package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "shipLineStatusesType", propOrder = {
    "orderLineStatus"
})
public class ShipLineStatusesType {

    @XmlElement(required = true)
    protected List<ShipLineStatusType> orderLineStatus;

    public List<ShipLineStatusType> getOrderLineStatus() {
        if (orderLineStatus == null) {
            orderLineStatus = new ArrayList<ShipLineStatusType>();
        }
        return this.orderLineStatus;
    }

    public void setOrderLineStatus (List<ShipLineStatusType> orderLineStatus) {
        this.orderLineStatus = orderLineStatus;
    }

}
