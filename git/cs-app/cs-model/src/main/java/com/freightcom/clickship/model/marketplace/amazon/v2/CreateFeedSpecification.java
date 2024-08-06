package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateFeedSpecification {

    @JsonProperty("feedType")
    private String feedType;

    @JsonProperty("marketplaceIds")
    private List<String> marketplaceIds;

    @JsonProperty("inputFeedDocumentId")
    private String inputFeedDocumentId;

    public String getFeedType() {
        return feedType;
    }

    public CreateFeedSpecification setFeedType(String feedType) {
        this.feedType = feedType;
        return this;
    }

    public List<String> getMarketplaceIds() {
        return marketplaceIds;
    }

    public CreateFeedSpecification setMarketplaceIds(List<String> marketplaceIds) {
        this.marketplaceIds = marketplaceIds;
        return this;
    }

    public String getInputFeedDocumentId() {
        return inputFeedDocumentId;
    }

    public CreateFeedSpecification setInputFeedDocumentId(String inputFeedDocumentId) {
        this.inputFeedDocumentId = inputFeedDocumentId;
        return this;
    }
}
