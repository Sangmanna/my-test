
package com.freightcom.clickship.model.marketplace.walmart.orders;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "postalAddressType", propOrder = {
    "name",
    "address1",
    "address2",
    "city",
    "state",
    "postalCode",
    "country",
    "addressType"
})
public class PostalAddressType {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String address1;
    protected String address2;
    @XmlElement(required = true)
    protected String city;
    @XmlElement(required = true)
    protected String state;
    @XmlElement(required = true)
    protected String postalCode;
    @XmlElement(required = true)
    protected String country;
    protected String addressType;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String value) {
        this.address1 = value;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String value) {
        this.address2 = value;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String value) {
        this.city = value;
    }

    public String getState() {
        return state;
    }

    public void setState(String value) {
        this.state = value;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String value) {
        this.postalCode = value;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String value) {
        this.country = value;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String value) {
        this.addressType = value;
    }

}
