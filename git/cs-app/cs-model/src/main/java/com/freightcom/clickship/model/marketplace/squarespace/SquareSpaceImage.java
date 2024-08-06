package com.freightcom.clickship.model.marketplace.squarespace;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SquareSpaceImage {

    @JsonProperty("id")
    private String id;

    @JsonProperty("url")
    private String url;

    public String getId() {
        return id;
    }

    public SquareSpaceImage setId(String id) {
        this.id = id;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public SquareSpaceImage setUrl(String url) {
        this.url = url;
        return this;
    }
}
