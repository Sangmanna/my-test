package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AWSTempCredentials {

    @JsonProperty("AccessKeyId")
    private String accessKeyId;

    @JsonProperty("SecretAccessKey")
    private String secretAccessKey;

    @JsonProperty("SessionToken")
    private String sessionToken;

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public AWSTempCredentials setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
        return this;
    }

    public String getSecretAccessKey() {
        return secretAccessKey;
    }

    public AWSTempCredentials setSecretAccessKey(String secretAccessKey) {
        this.secretAccessKey = secretAccessKey;
        return this;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public AWSTempCredentials setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
        return this;
    }
}
