
package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "refundLineType", propOrder = {
    "lineNumber",
    "refunds"
})
public class RefundLineType {

    @XmlElement(required = true)
    protected String lineNumber;
    @XmlElement(required = true)
    protected RefundsType refunds;

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String value) {
        this.lineNumber = value;
    }

    public RefundsType getRefunds() {
        return refunds;
    }

    public void setRefunds(RefundsType value) {
        this.refunds = value;
    }

}
