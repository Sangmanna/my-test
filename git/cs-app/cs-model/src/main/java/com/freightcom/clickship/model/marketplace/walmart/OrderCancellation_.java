package com.freightcom.clickship.model.marketplace.walmart;

import com.freightcom.clickship.model.marketplace.walmart.orders.OrderCancellation;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "orderCancellation"
})
@XmlRootElement(name = "orderCancellation")
public class OrderCancellation_ {

    @XmlElement(required = true)
    protected OrderCancellation orderCancellation;

    public OrderCancellation getOrderCancellation() {
        return orderCancellation;
    }

    public void setOrderCancellation(OrderCancellation orderCancellation) {
        this.orderCancellation = orderCancellation;
    }
}
