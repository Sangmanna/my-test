package com.freightcom.clickship.model.marketplace.vendasta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class VendastaTokenRequest {

    @JsonProperty("grant_type")
    private String grantType;

    @JsonProperty("assertion")
    private String assertion;


    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getAssertion() {
        return assertion;
    }

    public void setAssertion(String assertion) {
        this.assertion = assertion;
    }
}
