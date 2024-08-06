package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderItemsList {

    @JsonProperty("OrderItems")
    private List<AmazonV2OrderItem> orderItems;

    @JsonProperty("NextToken")
    private String nextToken;

    @JsonProperty("AmazonOrderId")
    private String amazonOrderId;

    public List<AmazonV2OrderItem> getOrderItems() {
        return orderItems;
    }

    public OrderItemsList setOrderItems(List<AmazonV2OrderItem> orderItems) {
        this.orderItems = orderItems;
        return this;
    }

    public String getNextToken() {
        return nextToken;
    }

    public OrderItemsList setNextToken(String nextToken) {
        this.nextToken = nextToken;
        return this;
    }

    public String getAmazonOrderId() {
        return amazonOrderId;
    }

    public OrderItemsList setAmazonOrderId(String amazonOrderId) {
        this.amazonOrderId = amazonOrderId;
        return this;
    }
}
