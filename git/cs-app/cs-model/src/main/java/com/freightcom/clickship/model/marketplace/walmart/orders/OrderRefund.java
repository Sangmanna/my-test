
package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "purchaseOrderId",
    "orderLines"
})
@XmlRootElement(name = "orderRefund")
public class OrderRefund {

    @XmlElement(required = true)
    protected String purchaseOrderId;
    @XmlElement(required = true)
    protected RefundLinesType orderLines;

    public String getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(String value) {
        this.purchaseOrderId = value;
    }

    public RefundLinesType getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(RefundLinesType value) {
        this.orderLines = value;
    }

}
