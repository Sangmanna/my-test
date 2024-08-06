
package com.freightcom.clickship.model.carrier.ups;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpsResponse implements Serializable {

	private final static long serialVersionUID = -3168105927001144456L;
	
	@JsonProperty("ResponseStatus")
	private CodeDescription responseStatus;
	
	@JsonProperty("Alert")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private List<CodeDescription> alert = null;
	
	@JsonProperty("TransactionReference")
	private TransactionReference transactionReference;

	@JsonProperty("errors")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private List<UpsError> errors = null;
	
	@JsonProperty("Error")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private List<UpsError> error = null;
	
    @JsonProperty("ResponseStatusCode")
    private String responseStatusCode;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public List<CodeDescription> getAlert() {
		return alert;
	}

	public UpsResponse setAlert(List<CodeDescription> alert) {
		this.alert = alert;
		return this;
	}

	public List<UpsError> getErrors() {
		return errors;
	}

	public void setErrors(List<UpsError> errors) {
		this.errors = errors;
	}
    
	public List<UpsError> getError() {
		return error;
	}

	public void setError(List<UpsError> error) {
		this.error = error;
	}

	public CodeDescription getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(CodeDescription responseStatus) {
		this.responseStatus = responseStatus;
	}

    public String getResponseStatusCode() {
        return responseStatusCode;
    }

    public void setResponseStatusCode(String responseStatusCode) {
        this.responseStatusCode = responseStatusCode;
    }

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
