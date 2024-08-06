package com.freightcom.clickship.model.carrier.ups;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpsError implements Serializable {

	private static final long serialVersionUID = 1828872596324500194L;

	@JsonProperty("code")
	private String code;
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("ErrorCode")
	private String errorCode;
	
	@JsonProperty("ErrorDetail")
	private String errorDetail;
	
	@JsonProperty("ErrorSeverity")
	private String errorSeverity;
	
	@JsonProperty("ErrorDescription")
	private String errorDescription;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getErrorSeverity() {
		return errorSeverity;
	}

	public void setErrorSeverity(String errorSeverity) {
		this.errorSeverity = errorSeverity;
	}

	public String getErrorDetail() {
		return errorDetail;
	}

	public void setErrorDetail(String errorDetail) {
		this.errorDetail = errorDetail;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}