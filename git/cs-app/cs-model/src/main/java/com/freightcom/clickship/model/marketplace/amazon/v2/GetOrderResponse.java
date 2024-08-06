package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetOrderResponse {

    @JsonProperty("payload")
    private AmazonV2Order order;

    @JsonProperty("errors")
    private List<AmazonError> errors;

    public AmazonV2Order getOrder() {
        return order;
    }

    public GetOrderResponse setOrder(AmazonV2Order order) {
        this.order = order;
        return this;
    }

    public List<AmazonError> getErrors() {
        return errors;
    }

    public GetOrderResponse setErrors(List<AmazonError> errors) {
        this.errors = errors;
        return this;
    }
}
