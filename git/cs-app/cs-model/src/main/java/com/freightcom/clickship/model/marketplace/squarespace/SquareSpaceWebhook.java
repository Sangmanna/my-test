package com.freightcom.clickship.model.marketplace.squarespace;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SquareSpaceWebhook {

    @JsonProperty("id")
    private String id;

    @JsonProperty("websiteId")
    private String websiteId;

    @JsonProperty("subscriptionId")
    private String subscriptionId;

    @JsonProperty("topic")
    private String topic;

    @JsonProperty("createdOn")
    private String createdOn;

    @JsonProperty("data")
    private SquaresSpaceWebhookData data;

    public String getId() {
        return id;
    }

    public SquareSpaceWebhook setId(String id) {
        this.id = id;
        return this;
    }

    public String getWebsiteId() {
        return websiteId;
    }

    public SquareSpaceWebhook setWebsiteId(String websiteId) {
        this.websiteId = websiteId;
        return this;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public SquareSpaceWebhook setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
        return this;
    }

    public String getTopic() {
        return topic;
    }

    public SquareSpaceWebhook setTopic(String topic) {
        this.topic = topic;
        return this;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public SquareSpaceWebhook setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public SquaresSpaceWebhookData getData() {
        return data;
    }

    public SquareSpaceWebhook setData(SquaresSpaceWebhookData data) {
        this.data = data;
        return this;
    }
}
