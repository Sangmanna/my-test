package com.freightcom.clickship.model.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.freightcom.clickship.model.CommonDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SendDocumentEmailResponseDTO extends CommonDTO {

	private Result result;
	
	public Result getResult() {
		return result;
	}

	public SendDocumentEmailResponseDTO setResult(Result result) {
		this.result = result;
		return this;
	}

	@Data
	@EqualsAndHashCode(callSuper = false)
	public class Result extends CommonDTO {
		
		private String status;

		@JsonProperty("num_documents")
		private int numDocuments;
		
		private String url;

		public String getStatus() {
			return status;
		}

		public Result setStatus(String status) {
			this.status = status;
			return this;
		}

		public int getNumDocuments() {
			return numDocuments;
		}

		public Result setNumDocuments(int numDocuments) {
			this.numDocuments = numDocuments;
			return this;
		}

		public String getUrl() {
			return url;
		}

		public Result setUrl(String url) {
			this.url = url;
			return this;
		}
		
	}
}
