package com.freightcom.clickship.model.marketplace.ebay.user;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "eBayAuthToken"
})
public class RequesterCredentials {

    @XmlElement(required = true)
    private String eBayAuthToken;

    public String geteBayAuthToken() {
        return eBayAuthToken;
    }

    public void seteBayAuthToken(String eBayAuthToken) {
        this.eBayAuthToken = eBayAuthToken;
    }
}
