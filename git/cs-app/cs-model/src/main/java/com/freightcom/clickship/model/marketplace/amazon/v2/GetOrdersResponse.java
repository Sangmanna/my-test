package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetOrdersResponse {

    @JsonProperty("payload")
    private OrdersList payload;

    @JsonProperty("errors")
    private List<AmazonError> errors;

    public OrdersList getPayload() {
        return payload;
    }

    public GetOrdersResponse setPayload(OrdersList payload) {
        this.payload = payload;
        return this;
    }

    public List<AmazonError> getErrors() {
        return errors;
    }

    public GetOrdersResponse setErrors(List<AmazonError> errors) {
        this.errors = errors;
        return this;
    }
}
