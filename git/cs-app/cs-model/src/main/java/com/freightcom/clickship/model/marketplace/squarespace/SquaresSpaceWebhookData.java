package com.freightcom.clickship.model.marketplace.squarespace;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SquaresSpaceWebhookData {

    @JsonProperty("orderId")
    private String orderId;

    @JsonProperty("update")
    private String update;

    @JsonProperty("clientId")
    private String clientId;

    public String getOrderId() {
        return orderId;
    }

    public SquaresSpaceWebhookData setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getUpdate() {
        return update;
    }

    public SquaresSpaceWebhookData setUpdate(String update) {
        this.update = update;
        return this;
    }

    public String getClientId() {
        return clientId;
    }

    public SquaresSpaceWebhookData setClientId(String clientId) {
        this.clientId = clientId;
        return this;
    }
}
