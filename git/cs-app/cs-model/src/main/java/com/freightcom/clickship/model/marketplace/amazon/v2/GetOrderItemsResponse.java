package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetOrderItemsResponse {

    @JsonProperty("payload")
    private OrderItemsList payload;

    @JsonProperty("errors")
    private List<AmazonError> errors;

    public OrderItemsList getPayload() {
        return payload;
    }

    public GetOrderItemsResponse setPayload(OrderItemsList payload) {
        this.payload = payload;
        return this;
    }

    public List<AmazonError> getErrors() {
        return errors;
    }

    public GetOrderItemsResponse setErrors(List<AmazonError> errors) {
        this.errors = errors;
        return this;
    }
}
