package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateFeedDocumentSpecification {

    @JsonProperty("contentType")
    private String contentType;

    public String getContentType() {
        return contentType;
    }

    public CreateFeedDocumentSpecification setContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }
}
