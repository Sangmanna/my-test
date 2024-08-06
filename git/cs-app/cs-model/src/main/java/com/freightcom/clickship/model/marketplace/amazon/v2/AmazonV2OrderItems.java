package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AmazonV2OrderItems {

    @JsonProperty("OrderItem")
    private List<AmazonV2OrderItem> orderItemsList;

    public List<AmazonV2OrderItem> getOrderItemsList() {
        return orderItemsList;
    }

    public AmazonV2OrderItems setOrderItemsList(List<AmazonV2OrderItem> orderItemsList) {
        this.orderItemsList = orderItemsList;
        return this;
    }
}
