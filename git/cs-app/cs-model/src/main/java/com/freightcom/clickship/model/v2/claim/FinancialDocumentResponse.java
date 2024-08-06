package com.freightcom.clickship.model.v2.claim;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * I do not know what the data look like and how to create this data in FC to pull. 
 * Just added the fields required to processing the FC logic copied code.
 * 
 * @author sangmann
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FinancialDocumentResponse {
	
	@JsonProperty("result")
	public Result result;
	
	public Result getResult() {
		return result;
	}

	public FinancialDocumentResponse setResult(Result result) {
		this.result = result;
		return this;
	}

	@Data
	@EqualsAndHashCode(callSuper = false)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Result {
		
		private String status;
		
		private Map<String, String> urlsMap;

		public String getStatus() {
			return status;
		}

		public Result setStatus(String status) {
			this.status = status;
			return this;
		}

		public Map<String, String> getUrlsMap() {
			return urlsMap;
		}

		public Result setUrlsMap(Map<String, String> urlsMap) {
			this.urlsMap = urlsMap;
			return this;
		}
	}
}
