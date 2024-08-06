package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AssumeRoleResult {

    @JsonProperty("Credentials")
    private AWSTempCredentials credentials;

    public AWSTempCredentials getCredentials() {
        return credentials;
    }

    public AssumeRoleResult setCredentials(AWSTempCredentials credentials) {
        this.credentials = credentials;
        return this;
    }
}
