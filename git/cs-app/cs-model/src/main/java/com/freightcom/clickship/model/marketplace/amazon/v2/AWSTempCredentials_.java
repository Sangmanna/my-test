package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AWSTempCredentials_ {

    @JsonProperty("AssumeRoleResponse")
    private AssumeRoleResponse assumeRoleResponse;

    public AssumeRoleResponse getAssumeRoleResponse() {
        return assumeRoleResponse;
    }

    public AWSTempCredentials_ setAssumeRoleResponse(AssumeRoleResponse assumeRoleResponse) {
        this.assumeRoleResponse = assumeRoleResponse;
        return this;
    }
}
