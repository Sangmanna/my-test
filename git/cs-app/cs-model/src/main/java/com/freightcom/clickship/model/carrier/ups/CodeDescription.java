package com.freightcom.clickship.model.carrier.ups;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CodeDescription implements Serializable {

	private static final long serialVersionUID = -8730893841970512487L;

	@JsonProperty("Code")
	private String code;

	@JsonProperty("Description")
	private String description;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public String getCode() {
		return code;
	}

	public CodeDescription setCode(String code) {
		this.code = code;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public CodeDescription setDescription(String description) {
		this.description = description;
		return this;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public CodeDescription setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

}
