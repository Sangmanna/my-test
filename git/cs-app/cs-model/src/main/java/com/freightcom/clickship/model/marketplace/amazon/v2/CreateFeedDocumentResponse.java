package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateFeedDocumentResponse {

    @JsonProperty("feedDocumentId")
    private String feedDocumentId;

    @JsonProperty("url")
    private String url;

    public String getFeedDocumentId() {
        return feedDocumentId;
    }

    public CreateFeedDocumentResponse setFeedDocumentId(String feedDocumentId) {
        this.feedDocumentId = feedDocumentId;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public CreateFeedDocumentResponse setUrl(String url) {
        this.url = url;
        return this;
    }
}
