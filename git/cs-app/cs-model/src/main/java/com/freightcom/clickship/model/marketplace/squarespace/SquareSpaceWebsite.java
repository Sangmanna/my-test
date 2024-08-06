package com.freightcom.clickship.model.marketplace.squarespace;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SquareSpaceWebsite {

    @JsonProperty("id")
    private String id;

    @JsonProperty("siteId")
    private String siteId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("url")
    private String url;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("measurementStandard")
    private String measurementStandard;

    @JsonProperty("language")
    private String language;

    public String getId() {
        return id;
    }

    public SquareSpaceWebsite setId(String id) {
        this.id = id;
        return this;
    }

    public String getSiteId() {
        return siteId;
    }

    public SquareSpaceWebsite setSiteId(String siteId) {
        this.siteId = siteId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SquareSpaceWebsite setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public SquareSpaceWebsite setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public SquareSpaceWebsite setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public String getMeasurementStandard() {
        return measurementStandard;
    }

    public SquareSpaceWebsite setMeasurementStandard(String measurementStandard) {
        this.measurementStandard = measurementStandard;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public SquareSpaceWebsite setLanguage(String language) {
        this.language = language;
        return this;
    }
}
