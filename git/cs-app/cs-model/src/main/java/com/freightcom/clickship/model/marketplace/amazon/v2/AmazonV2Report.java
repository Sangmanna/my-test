package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AmazonV2Report {

    @JsonProperty("reportId")
    private String reportId;

    @JsonProperty("marketplaceIds")
    private List<String> marketplaceIds;

    @JsonProperty("reportType")
    private String reportType;

    @JsonProperty("dataStartTime")
    private String dataStartTime;

    @JsonProperty("dataEndTime")
    private String dataEndTime;

    @JsonProperty("reportScheduleId")
    private String reportScheduleId;

    @JsonProperty("createdTime")
    private String createdTime;

    @JsonProperty("processingStatus")
    private ProcessingStatus processingStatus;

    @JsonProperty("processingStartTime")
    private String processingStartTime;

    @JsonProperty("processingEndTime")
    private String processingEndTime;

    @JsonProperty("reportDocumentId")
    private String reportDocumentId;

    public String getReportId() {
        return reportId;
    }

    public AmazonV2Report setReportId(String reportId) {
        this.reportId = reportId;
        return this;
    }

    public List<String> getMarketplaceIds() {
        return marketplaceIds;
    }

    public AmazonV2Report setMarketplaceIds(List<String> marketplaceIds) {
        this.marketplaceIds = marketplaceIds;
        return this;
    }

    public String getReportType() {
        return reportType;
    }

    public AmazonV2Report setReportType(String reportType) {
        this.reportType = reportType;
        return this;
    }

    public String getDataStartTime() {
        return dataStartTime;
    }

    public AmazonV2Report setDataStartTime(String dataStartTime) {
        this.dataStartTime = dataStartTime;
        return this;
    }

    public String getDataEndTime() {
        return dataEndTime;
    }

    public AmazonV2Report setDataEndTime(String dataEndTime) {
        this.dataEndTime = dataEndTime;
        return this;
    }

    public String getReportScheduleId() {
        return reportScheduleId;
    }

    public AmazonV2Report setReportScheduleId(String reportScheduleId) {
        this.reportScheduleId = reportScheduleId;
        return this;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public AmazonV2Report setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public ProcessingStatus getProcessingStatus() {
        return processingStatus;
    }

    public AmazonV2Report setProcessingStatus(ProcessingStatus processingStatus) {
        this.processingStatus = processingStatus;
        return this;
    }

    public String getProcessingStartTime() {
        return processingStartTime;
    }

    public AmazonV2Report setProcessingStartTime(String processingStartTime) {
        this.processingStartTime = processingStartTime;
        return this;
    }

    public String getProcessingEndTime() {
        return processingEndTime;
    }

    public AmazonV2Report setProcessingEndTime(String processingEndTime) {
        this.processingEndTime = processingEndTime;
        return this;
    }

    public String getReportDocumentId() {
        return reportDocumentId;
    }

    public AmazonV2Report setReportDocumentId(String reportDocumentId) {
        this.reportDocumentId = reportDocumentId;
        return this;
    }
}
