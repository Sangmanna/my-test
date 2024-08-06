package com.freightcom.clickship.model.marketplace.ebay.user;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GetUserResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetUserResponse {
    @XmlElement(name="Timestamp")
    private String timestamp;
    @XmlElement(name="Ack")
    private String ack;
    @XmlElement(name="User")
    private GetEbayUserResponse user;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getAck() {
        return ack;
    }

    public void setAck(String ack) {
        this.ack = ack;
    }

    public GetEbayUserResponse getUser() {
        return user;
    }

    public void setUser(GetEbayUserResponse user) {
        this.user = user;
    }
}
