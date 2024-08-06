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
public class UpsMoney implements Serializable {
	
	private static final long serialVersionUID = -7564128960938724345L;

	@JsonProperty("CurrencyCode")
    private String currencyCode;
    
    @JsonProperty("MonetaryValue")
    private String monetaryValue;
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getCurrencyCode() {
        return currencyCode;
    }

    public UpsMoney setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    public String getMonetaryValue() {
        return monetaryValue;
    }

    public UpsMoney setMonetaryValue(String monetaryValue) {
        this.monetaryValue = monetaryValue;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public UpsMoney setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
