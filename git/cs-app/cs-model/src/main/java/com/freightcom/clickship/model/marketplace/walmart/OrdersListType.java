package com.freightcom.clickship.model.marketplace.walmart;

import com.freightcom.clickship.model.marketplace.walmart.orders.ElementsType;
import com.freightcom.clickship.model.marketplace.walmart.orders.MetaType;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "list")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ordersListType", propOrder = {
    "meta",
    "elements"
})
public class OrdersListType {

    @XmlElement(required = true)
    protected MetaType meta;
    @XmlElement(required = true)
    protected ElementsType elements;

    public MetaType getMeta() {
        return meta;
    }

    public void setMeta(MetaType value) {
        this.meta = value;
    }

    public ElementsType getElements() {
        return elements;
    }

    public void setElements(ElementsType value) {
        this.elements = value;
    }

}
