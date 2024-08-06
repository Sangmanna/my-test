
package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "priceType", propOrder = {
    "total",
    "retail",
    "shipping"
})
public class PriceType {

    protected float total;
    @XmlElement(required = true)
    protected PriceAndTaxType retail;
    @XmlElement(required = true)
    protected PriceAndTaxType shipping;

    public float getTotal() {
        return total;
    }

    public void setTotal(float value) {
        this.total = value;
    }

    public PriceAndTaxType getRetail() {
        return retail;
    }

    public void setRetail(PriceAndTaxType value) {
        this.retail = value;
    }

    public PriceAndTaxType getShipping() {
        return shipping;
    }

    public void setShipping(PriceAndTaxType value) {
        this.shipping = value;
    }

}
