package com.freightcom.clickship.model.marketplace.ebay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Amount {

    @JsonProperty("convertedFromCurrency")
    private String convertedFromCurrency = null;

    @JsonProperty("convertedFromValue")
    private String convertedFromValue = null;

    @JsonProperty("currency")
    private String currency = null;

    @JsonProperty("value")
    private String value = null;

    public String getConvertedFromCurrency() {
        return convertedFromCurrency;
    }

    public void setConvertedFromCurrency(String convertedFromCurrency) {
        this.convertedFromCurrency = convertedFromCurrency;
    }

    public String getConvertedFromValue() {
        return convertedFromValue;
    }

    public void setConvertedFromValue(String convertedFromValue) {
        this.convertedFromValue = convertedFromValue;
    }

    public String getCurrency() {
		return convertedFromCurrency != null ? convertedFromCurrency : currency != null ? currency : "";
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getValue() {
    	return convertedFromValue != null ? convertedFromValue : value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
