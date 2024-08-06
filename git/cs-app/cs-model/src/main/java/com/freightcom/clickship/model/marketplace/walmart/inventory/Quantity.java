
package com.freightcom.clickship.model.marketplace.walmart.inventory;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Quantity", propOrder = {
    "unit",
    "amount"
})
public class Quantity {

    @XmlElement(required = true)
    protected String unit;
    @XmlElement(required = true)
    protected BigDecimal amount;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String value) {
        this.unit = value;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal value) {
        this.amount = value;
    }

}
