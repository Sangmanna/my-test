package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateReportResponse {

    @JsonProperty("reportId")
    private String reportId;

    public String getReportId() {
        return reportId;
    }

    public CreateReportResponse setReportId(String reportId) {
        this.reportId = reportId;
        return this;
    }
}
