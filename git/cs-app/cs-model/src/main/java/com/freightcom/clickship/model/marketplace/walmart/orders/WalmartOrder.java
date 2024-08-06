
package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Order", propOrder = {
    "purchaseOrderId",
    "customerOrderId",
    "customerEmailId",
    "orderDate",
    "shippingInfo",
    "orderLines"
})
public class WalmartOrder {

    @XmlElement(required = true)
    protected String purchaseOrderId;
    @XmlElement(required = true)
    protected String customerOrderId;
    @XmlElement(required = true)
    protected String customerEmailId;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar orderDate;
    @XmlElement(required = true)
    protected ShippingInfoType shippingInfo;
    @XmlElement(required = true)
    protected OrderLinesType orderLines;

    public String getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(String value) {
        this.purchaseOrderId = value;
    }

    public String getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(String value) {
        this.customerOrderId = value;
    }

    public String getCustomerEmailId() {
        return customerEmailId;
    }

    public void setCustomerEmailId(String value) {
        this.customerEmailId = value;
    }

    public XMLGregorianCalendar getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(XMLGregorianCalendar value) {
        this.orderDate = value;
    }

    public ShippingInfoType getShippingInfo() {
        return shippingInfo;
    }

    public void setShippingInfo(ShippingInfoType value) {
        this.shippingInfo = value;
    }

    public OrderLinesType getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(OrderLinesType value) {
        this.orderLines = value;
    }

}
