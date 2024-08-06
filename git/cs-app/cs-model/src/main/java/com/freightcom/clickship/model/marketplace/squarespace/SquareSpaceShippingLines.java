package com.freightcom.clickship.model.marketplace.squarespace;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SquareSpaceShippingLines {

    @JsonProperty("method")
    private String method;

    @JsonProperty("amount")
    private SquareSpacePrice amount;

    public String getMethod() {
        return method;
    }

    public SquareSpaceShippingLines setMethod(String method) {
        this.method = method;
        return this;
    }

    public SquareSpacePrice getAmount() {
        return amount;
    }

    public SquareSpaceShippingLines setAmount(SquareSpacePrice amount) {
        this.amount = amount;
        return this;
    }
}
