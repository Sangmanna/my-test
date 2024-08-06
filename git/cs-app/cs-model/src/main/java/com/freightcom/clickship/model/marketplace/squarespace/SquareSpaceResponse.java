package com.freightcom.clickship.model.marketplace.squarespace;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SquareSpaceResponse {

    @JsonProperty("products")
    private List<SquareSpaceProduct> products;

    @JsonProperty("result")
    private List<SquareSpaceOrder> orders;

    @JsonProperty("pagination")
    private Pagination pagination;

    @JsonProperty("webhookSubscriptions")
    private List<SquareSpaceWebhookRequest> webhooks;

    public List<SquareSpaceProduct> getProducts() {
        return products;
    }

    public SquareSpaceResponse setProducts(List<SquareSpaceProduct> products) {
        this.products = products;
        return this;
    }

    public List<SquareSpaceOrder> getOrders() {
        return orders;
    }

    public SquareSpaceResponse setOrders(List<SquareSpaceOrder> orders) {
        this.orders = orders;
        return this;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public SquareSpaceResponse setPagination(Pagination pagination) {
        this.pagination = pagination;
        return this;
    }

    public List<SquareSpaceWebhookRequest> getWebhooks() {
        return webhooks;
    }

    public SquareSpaceResponse setWebhooks(List<SquareSpaceWebhookRequest> webhooks) {
        this.webhooks = webhooks;
        return this;
    }
}
