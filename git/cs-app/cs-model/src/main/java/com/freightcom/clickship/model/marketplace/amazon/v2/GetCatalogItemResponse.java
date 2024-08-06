package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetCatalogItemResponse {

    @JsonProperty("payload")
    private AmazonV2Item payload;

    @JsonProperty("errors")
    private List<AmazonError> errors;

    public AmazonV2Item getPayload() {
        return payload;
    }

    public GetCatalogItemResponse setPayload(AmazonV2Item payload) {
        this.payload = payload;
        return this;
    }

    public List<AmazonError> getErrors() {
        return errors;
    }

    public GetCatalogItemResponse setErrors(List<AmazonError> errors) {
        this.errors = errors;
        return this;
    }
}
