
package com.freightcom.clickship.model.marketplace.walmart;

import com.freightcom.clickship.model.marketplace.walmart.inventory.Quantity;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "inventory")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "inventory", propOrder = {
    "sku",
    "quantity",
    "fulfillmentLagTime"
})
public class Inventory {

    @XmlElement(required = true)
    protected String sku;
    @XmlElement(required = true)
    protected Quantity quantity;
    protected int fulfillmentLagTime;

    public String getSku() {
        return sku;
    }

    public void setSku(String value) {
        this.sku = value;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity value) {
        this.quantity = value;
    }

    public int getFulfillmentLagTime() {
        return fulfillmentLagTime;
    }

    public void setFulfillmentLagTime(int value) {
        this.fulfillmentLagTime = value;
    }

}
