package com.freightcom.clickship.model.v2.invoice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostReportResponse {

	@JsonProperty("report_id")
	private String reportId;

	public String getReportId() {
		return reportId;
	}

	public PostReportResponse setReportId(String reportId) {
		this.reportId = reportId;
		return this;
	}
	
}
