package com.freightcom.clickship.model.marketplace.squarespace;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pagination {

    @JsonProperty("nextPageUrl")
    private String nextPageUrl;

    @JsonProperty("nextPageCursor")
    private String nextPageCursor;

    @JsonProperty("hasNextPage")
    private boolean hasNextPage;

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public Pagination setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
        return this;
    }

    public String getNextPageCursor() {
        return nextPageCursor;
    }

    public Pagination setNextPageCursor(String nextPageCursor) {
        this.nextPageCursor = nextPageCursor;
        return this;
    }

    public boolean getHasNextPage() {
        return hasNextPage;
    }

    public Pagination setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
        return this;
    }
}
