package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AssumeRoleResponse {

    @JsonProperty("AssumeRoleResult")
    private AssumeRoleResult assumeRoleResult;

    public AssumeRoleResult getAssumeRoleResult() {
        return assumeRoleResult;
    }

    public AssumeRoleResponse setAssumeRoleResult(AssumeRoleResult assumeRoleResult) {
        this.assumeRoleResult = assumeRoleResult;
        return this;
    }
}
