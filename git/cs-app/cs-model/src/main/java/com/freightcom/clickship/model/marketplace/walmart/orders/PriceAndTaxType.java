
package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "priceAndTaxType", propOrder = {
    "price",
    "tax"
})
public class PriceAndTaxType {

    @XmlElement(required = true)
    protected MoneyType price;
    @XmlElement(required = true)
    protected MoneyType tax;

    public MoneyType getPrice() {
        return price;
    }

    public void setPrice(MoneyType value) {
        this.price = value;
    }

    public MoneyType getTax() {
        return tax;
    }

    public void setTax(MoneyType value) {
        this.tax = value;
    }

}
