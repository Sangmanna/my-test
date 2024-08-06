
package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "chargeType", propOrder = {
    "chargeType",
    "chargeName",
    "chargeAmount",
    "tax"
})
public class ChargeType {

    @XmlElement(required = true)
    protected String chargeType;
    @XmlElement(required = true)
    protected String chargeName;
    @XmlElement(required = true)
    protected MoneyType chargeAmount;
    protected TaxType tax;

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String value) {
        this.chargeType = value;
    }

    public String getChargeName() {
        return chargeName;
    }

    public void setChargeName(String value) {
        this.chargeName = value;
    }

    public MoneyType getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(MoneyType value) {
        this.chargeAmount = value;
    }

    public TaxType getTax() {
        return tax;
    }

    public void setTax(TaxType value) {
        this.tax = value;
    }

}
