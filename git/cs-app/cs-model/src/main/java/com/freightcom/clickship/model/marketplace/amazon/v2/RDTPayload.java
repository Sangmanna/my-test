package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RDTPayload {

    @JsonProperty("restrictedDataToken")
    private String restrictedDataToken;

    @JsonProperty("expiresIn")
    private int expiresIn;

    public String getRestrictedDataToken() {
        return restrictedDataToken;
    }

    public RDTPayload setRestrictedDataToken(String restrictedDataToken) {
        this.restrictedDataToken = restrictedDataToken;
        return this;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public RDTPayload setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }
}
