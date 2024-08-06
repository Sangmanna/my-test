package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrdersList {

    @JsonProperty("Orders")
    private List<AmazonV2Order> orders;

    @JsonProperty("NextToken")
    private String nextToken;

    @JsonProperty("LastUpdatedBefore")
    private String lastUpdatedBefore;

    @JsonProperty("CreatedBefore")
    private String createdBefore;

    public List<AmazonV2Order> getOrders() {
        return orders;
    }

    public OrdersList setOrders(List<AmazonV2Order> orders) {
        this.orders = orders;
        return this;
    }

    public String getNextToken() {
        return nextToken;
    }

    public OrdersList setNextToken(String nextToken) {
        this.nextToken = nextToken;
        return this;
    }

    public String getLastUpdatedBefore() {
        return lastUpdatedBefore;
    }

    public OrdersList setLastUpdatedBefore(String lastUpdatedBefore) {
        this.lastUpdatedBefore = lastUpdatedBefore;
        return this;
    }

    public String getCreatedBefore() {
        return createdBefore;
    }

    public OrdersList setCreatedBefore(String createdBefore) {
        this.createdBefore = createdBefore;
        return this;
    }
}
