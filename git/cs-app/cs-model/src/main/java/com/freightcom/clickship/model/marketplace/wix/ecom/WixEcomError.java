package com.freightcom.clickship.model.marketplace.wix.ecom;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WixEcomError {

	@JsonProperty("message")
	private String message;

	@JsonProperty("details")
	private WixEcomErrorDetails details;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public WixEcomErrorDetails getDetails() {
		return details;
	}

	public void setDetails(WixEcomErrorDetails details) {
		this.details = details;
	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class WixEcomErrorDetails {

		@JsonProperty("validationError")
		private WixEcomValidationError validationError;

		public WixEcomValidationError getValidationError() {
			return validationError;
		}

		public void setValidationError(WixEcomValidationError validationError) {
			this.validationError = validationError;
		}
	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class WixEcomValidationError {

		@JsonProperty("fieldViolations")
		private List<WixEcomFieldViolations> fieldViolations;

		public List<WixEcomFieldViolations> getFieldViolations() {
			return fieldViolations;
		}

		public void setFieldViolations(List<WixEcomFieldViolations> fieldViolations) {
			this.fieldViolations = fieldViolations;
		}
	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class WixEcomFieldViolations {

		@JsonProperty("field")
		private String field;

		@JsonProperty("description")
		private String description;

		@JsonProperty("violatedRule")
		private String violatedRule;

		@JsonProperty("ruleName")
		private String ruleName;

		public String getField() {
			return field;
		}

		public void setField(String field) {
			this.field = field;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getViolatedRule() {
			return violatedRule;
		}

		public void setViolatedRule(String violatedRule) {
			this.violatedRule = violatedRule;
		}

		public String getRuleName() {
			return ruleName;
		}

		public void setRuleName(String ruleName) {
			this.ruleName = ruleName;
		}
	}
}
