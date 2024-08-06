package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AmazonError {

    @JsonProperty("code")
    private String code;

    @JsonProperty("message")
    private String message;

    @JsonProperty("details")
    private String details;

    public String getCode() {
        return code;
    }

    public AmazonError setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public AmazonError setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getDetails() {
        return details;
    }

    public AmazonError setDetails(String details) {
        this.details = details;
        return this;
    }
}
