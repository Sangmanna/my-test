
package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cancelLineStatusesType", propOrder = {
    "orderLineStatus"
})
public class CancelLineStatusesType {

    @XmlElement(required = true)
    protected List<CancelLineStatusType> orderLineStatus;

    public List<CancelLineStatusType> getOrderLineStatus() {
        if (orderLineStatus == null) {
            orderLineStatus = new ArrayList<CancelLineStatusType>();
        }
        return this.orderLineStatus;
    }

    public void setOrderLineStatus(List<CancelLineStatusType> orderLineStatus) {
        this.orderLineStatus = orderLineStatus;
    }
}
