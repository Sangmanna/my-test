
package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "moneyType", propOrder = {
    "currency",
    "amount"
})
public class MoneyType {

    @XmlElement(required = true)
    protected CurrencyType currency;
    @XmlElement(required = true)
    protected BigDecimal amount;

    public CurrencyType getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyType value) {
        this.currency = value;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal value) {
        this.amount = value;
    }

}
