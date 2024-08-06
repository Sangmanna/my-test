package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaxClassification {

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Value")
    private String value;

    public String getName() {
        return name;
    }

    public TaxClassification setName(String name) {
        this.name = name;
        return this;
    }

    public String getValue() {
        return value;
    }

    public TaxClassification setValue(String value) {
        this.value = value;
        return this;
    }
}
