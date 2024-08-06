package com.freightcom.clickship.model.marketplace.ebay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Error {

    @JsonProperty("category")
    private String category;

    @JsonProperty("domain")
    private String domain;

    @JsonProperty("errorId")
    private Integer errorId;

    @JsonProperty("inputRefIds")
    private List<String> inputRefIds;

    @JsonProperty("longMessage")
    private String longMessage;

    @JsonProperty("message")
    private String message;

    @JsonProperty("outputRefIds")
    private List<String> outputRefIds;

    @JsonProperty("subdomain")
    private String subdomain;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Integer getErrorId() {
        return errorId;
    }

    public void setErrorId(Integer errorId) {
        this.errorId = errorId;
    }

    public List<String> getInputRefIds() {
        return inputRefIds;
    }

    public void setInputRefIds(List<String> inputRefIds) {
        this.inputRefIds = inputRefIds;
    }

    public String getLongMessage() {
        return longMessage;
    }

    public void setLongMessage(String longMessage) {
        this.longMessage = longMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getOutputRefIds() {
        return outputRefIds;
    }

    public void setOutputRefIds(List<String> outputRefIds) {
        this.outputRefIds = outputRefIds;
    }

    public String getSubdomain() {
        return subdomain;
    }

    public void setSubdomain(String subdomain) {
        this.subdomain = subdomain;
    }
}
