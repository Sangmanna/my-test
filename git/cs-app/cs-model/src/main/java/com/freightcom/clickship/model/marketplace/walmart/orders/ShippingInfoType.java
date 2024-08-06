
package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "shippingInfoType", propOrder = {
    "phone",
    "estimatedDeliveryDate",
    "estimatedShipDate",
    "methodCode",
    "postalAddress"
})
public class ShippingInfoType {

    @XmlElement(required = true)
    protected String phone;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar estimatedDeliveryDate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar estimatedShipDate;
    @XmlElement(required = true)
    protected ShippingMethodCodeType methodCode;
    @XmlElement(required = true)
    protected PostalAddressType postalAddress;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String value) {
        this.phone = value;
    }

    public XMLGregorianCalendar getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(XMLGregorianCalendar value) {
        this.estimatedDeliveryDate = value;
    }

    public XMLGregorianCalendar getEstimatedShipDate() {
        return estimatedShipDate;
    }

    public void setEstimatedShipDate(XMLGregorianCalendar value) {
        this.estimatedShipDate = value;
    }

    public ShippingMethodCodeType getMethodCode() {
        return methodCode;
    }

    public void setMethodCode(ShippingMethodCodeType value) {
        this.methodCode = value;
    }

    public PostalAddressType getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(PostalAddressType value) {
        this.postalAddress = value;
    }

}
