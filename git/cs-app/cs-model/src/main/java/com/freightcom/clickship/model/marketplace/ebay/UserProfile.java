package com.freightcom.clickship.model.marketplace.ebay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserProfile {

    @JsonProperty("Version")
    private String Version;

    @JsonProperty("User")
    private EbayUser User;

    @JsonProperty("Ack")
    private String Ack;

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public EbayUser getUser() {
        return User;
    }

    public void setUser(EbayUser user) {
        User = user;
    }

    public String getAck() {
        return Ack;
    }

    public void setAck(String ack) {
        Ack = ack;
    }
}