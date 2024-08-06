package com.freightcom.clickship.model.marketplace.walmart;


import com.freightcom.clickship.model.marketplace.walmart.orders.OrderShipment;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "orderShipment"
})
@XmlRootElement(name = "orderShipment")
public class OrderShipment_ {

    @XmlElement(required = true)
    protected OrderShipment orderShipment;

    public OrderShipment getOrderShipment() {
        return orderShipment;
    }

    public void setOrderShipment(OrderShipment orderShipment) {
        this.orderShipment = orderShipment;
    }
}
