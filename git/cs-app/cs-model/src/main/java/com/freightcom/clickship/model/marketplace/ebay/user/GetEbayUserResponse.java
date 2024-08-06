package com.freightcom.clickship.model.marketplace.ebay.user;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "User")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetEbayUserResponse {

    @XmlElement(name = "UserID")
    private String userId;
    @XmlElement(name = "RegistrationSite")
    private String registrationSite;
    @XmlElement(name = "SellerItemsURL")
    private String itemsUrl;
    @XmlElement(name = "Status")
    private String status;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRegistrationSite() {
        return registrationSite;
    }

    public void setRegistrationSite(String registrationSite) {
        this.registrationSite = registrationSite;
    }

    public String getItemsUrl() {
        return itemsUrl;
    }

    public void setItemsUrl(String itemsUrl) {
        this.itemsUrl = itemsUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
