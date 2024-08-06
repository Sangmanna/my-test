package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AmazonMoney {

    @JsonProperty("CurrencyCode")
    private String currencyCode;

    @JsonProperty("Amount")
    private String amount;

    public String getCurrencyCode() {
        return currencyCode;
    }

    public AmazonMoney setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    public String getAmount() {
        return amount;
    }

    public AmazonMoney setAmount(String amount) {
        this.amount = amount;
        return this;
    }
}
