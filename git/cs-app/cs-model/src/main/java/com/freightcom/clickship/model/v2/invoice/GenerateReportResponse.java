package com.freightcom.clickship.model.v2.invoice;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.freightcom.clickship.model.v2.ShippingResponseLabels;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenerateReportResponse {

	@JsonProperty("result")
	private Result result;

	public Result getResult() {
		return result;
	}

	public GenerateReportResponse setResult(Result result) {
		this.result = result;
		return this;
	}

	@Data
	@EqualsAndHashCode(callSuper = false)
	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public class Result {

		@JsonProperty("status")
		private String status;

		@JsonProperty("error")
		private String error;
		
		@JsonProperty("report")
		private GenerateReport report;

		@JsonProperty("labels")
		private List<ShippingResponseLabels> labels;

		public String getStatus() {
			return status;
		}

		public Result setStatus(String status) {
			this.status = status;
			return this;
		}

		public String getError() {
			return error;
		}

		public Result setError(String error) {
			this.error = error;
			return this;
		}

		public GenerateReport getReport() {
			return report;
		}

		public Result setReport(GenerateReport report) {
			this.report = report;
			return this;
		}

		public List<ShippingResponseLabels> getLabels() {
			return labels;
		}

		public Result setLabels(List<ShippingResponseLabels> labels) {
			this.labels = labels;
			return this;
		}
		
	}
}
