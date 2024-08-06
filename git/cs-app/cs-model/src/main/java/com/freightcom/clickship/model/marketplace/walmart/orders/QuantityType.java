
package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "quantityType", propOrder = {
    "unitOfMeasurement",
    "amount"
})
public class QuantityType {

    @XmlElement(required = true)
    protected String unitOfMeasurement;
    @XmlElement(required = true)
    protected String amount;

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(String value) {
        this.unitOfMeasurement = value;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String value) {
        this.amount = value;
    }

}
