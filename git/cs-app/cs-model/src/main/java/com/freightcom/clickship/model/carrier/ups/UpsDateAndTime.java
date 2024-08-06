package com.freightcom.clickship.model.carrier.ups;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpsDateAndTime implements Serializable {
	
	private static final long serialVersionUID = -7564128960938724345L;

	@JsonAlias({"type", "Type"})
    private String type;
    
    @JsonProperty("date")
    private String date;
    
    @JsonProperty("startTime")
    private String startTime;
    
    @JsonProperty("endTime")
    private String endTime;
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getType() {
		return type;
	}

	public UpsDateAndTime setType(String type) {
		this.type = type;
		return this;
	}

	public String getDate() {
		return date;
	}

	public UpsDateAndTime setDate(String date) {
		this.date = date;
		return this;
	}

	public String getStartTime() {
		return startTime;
	}

	public UpsDateAndTime setStartTime(String startTime) {
		this.startTime = startTime;
		return this;
	}

	public String getEndTime() {
		return endTime;
	}

	public UpsDateAndTime setEndTime(String endTime) {
		this.endTime = endTime;
		return this;
	}

	@JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public UpsDateAndTime setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
