package com.freightcom.clickship.model.marketplace.squarespace;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SquareSpaceNotes {

    @JsonProperty("content")
    private String content;

    public String getContent() {
        return content;
    }

    public SquareSpaceNotes setContent(String content) {
        this.content = content;
        return this;
    }
}
