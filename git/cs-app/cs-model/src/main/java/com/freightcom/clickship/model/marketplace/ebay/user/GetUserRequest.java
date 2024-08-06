package com.freightcom.clickship.model.marketplace.ebay.user;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "RequesterCredentials",
        "UserID"
})
@XmlRootElement(name = "GetUserRequest")
public class GetUserRequest {

    @XmlElement(required = true)
    private RequesterCredentials RequesterCredentials;

    @XmlElement(required = true)
    private String UserID;

    public com.freightcom.clickship.model.marketplace.ebay.user.RequesterCredentials getRequesterCredentials() {
        return RequesterCredentials;
    }

    public void setRequesterCredentials(com.freightcom.clickship.model.marketplace.ebay.user.RequesterCredentials requesterCredentials) {
        RequesterCredentials = requesterCredentials;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }
}
