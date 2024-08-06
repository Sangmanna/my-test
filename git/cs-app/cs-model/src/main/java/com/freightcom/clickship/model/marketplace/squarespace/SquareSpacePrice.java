package com.freightcom.clickship.model.marketplace.squarespace;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SquareSpacePrice {

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("value")
    private String value;

    public String getCurrency() {
        return currency;
    }

    public SquareSpacePrice setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public String getValue() {
        return value;
    }

    public SquareSpacePrice setValue(String value) {
        this.value = value;
        return this;
    }
}
