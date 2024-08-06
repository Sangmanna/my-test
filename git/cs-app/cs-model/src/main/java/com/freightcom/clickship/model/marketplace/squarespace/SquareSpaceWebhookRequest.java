package com.freightcom.clickship.model.marketplace.squarespace;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SquareSpaceWebhookRequest {

    @JsonProperty("id")
    private String id;

    @JsonProperty("endpointUrl")
    private String endpointUrl;

    @JsonProperty("topics")
    private List<String> topics;

    @JsonProperty("secret")
    private String secret;

    @JsonProperty("createdOn")
    private String createdOn;

    @JsonProperty("updatedOn")
    private String updatedOn;

    public String getId() {
        return id;
    }

    public SquareSpaceWebhookRequest setId(String id) {
        this.id = id;
        return this;
    }

    public String getEndpointUrl() {
        return endpointUrl;
    }

    public SquareSpaceWebhookRequest setEndpointUrl(String endpointUrl) {
        this.endpointUrl = endpointUrl;
        return this;
    }

    public List<String> getTopics() {
        return topics;
    }

    public SquareSpaceWebhookRequest setTopics(List<String> topics) {
        this.topics = topics;
        return this;
    }

    public String getSecret() {
        return secret;
    }

    public SquareSpaceWebhookRequest setSecret(String secret) {
        this.secret = secret;
        return this;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public SquareSpaceWebhookRequest setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public SquareSpaceWebhookRequest setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }
}
