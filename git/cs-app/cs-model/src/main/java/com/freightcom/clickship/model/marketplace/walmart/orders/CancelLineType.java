

package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cancelLineType", propOrder = {
    "lineNumber",
    "orderLineStatuses"
})
public class CancelLineType {

    @XmlElement(required = true)
    protected String lineNumber;
    @XmlElement(required = true)
    protected CancelLineStatusesType orderLineStatuses;

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String value) {
        this.lineNumber = value;
    }

    public CancelLineStatusesType getOrderLineStatuses() {
        return orderLineStatuses;
    }

    public void setOrderLineStatuses(CancelLineStatusesType value) {
        this.orderLineStatuses = value;
    }

}
