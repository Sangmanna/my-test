package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateReportSpecification {

    @JsonProperty("reportType")
    private String reportType;

    @JsonProperty("marketplaceIds")
    private List<String> marketplaceIds;

    @JsonProperty("dataStartTime")
    private String dataStartTime;

    @JsonProperty("dataEndTime")
    private String dataEndTime;

    public String getReportType() {
        return reportType;
    }

    public CreateReportSpecification setReportType(String reportType) {
        this.reportType = reportType;
        return this;
    }

    public List<String> getMarketplaceIds() {
        return marketplaceIds;
    }

    public CreateReportSpecification setMarketplaceIds(List<String> marketplaceIds) {
        this.marketplaceIds = marketplaceIds;
        return this;
    }

    public String getDataStartTime() {
        return dataStartTime;
    }

    public CreateReportSpecification setDataStartTime(String dataStartTime) {
        this.dataStartTime = dataStartTime;
        return this;
    }

    public String getDataEndTime() {
        return dataEndTime;
    }

    public CreateReportSpecification setDataEndTime(String dataEndTime) {
        this.dataEndTime = dataEndTime;
        return this;
    }
}
