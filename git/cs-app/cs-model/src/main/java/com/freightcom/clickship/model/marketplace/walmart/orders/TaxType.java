
package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "taxType", propOrder = {
    "taxName",
    "taxAmount"
})
public class TaxType {

    @XmlElement(required = true)
    protected String taxName;
    @XmlElement(required = true)
    protected MoneyType taxAmount;

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String value) {
        this.taxName = value;
    }

    public MoneyType getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(MoneyType value) {
        this.taxAmount = value;
    }

}
