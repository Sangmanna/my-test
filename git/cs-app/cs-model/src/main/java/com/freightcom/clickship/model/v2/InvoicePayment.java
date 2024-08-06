package com.freightcom.clickship.model.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InvoicePayment {

    @JsonProperty("id")
    private String id;

    @JsonProperty("type")
    private String type;

    @JsonProperty("amount")
    private Money amount;

    @JsonProperty("data")
    private PaymentData data;

    public String getId() {
        return id;
    }

    public InvoicePayment setId(String id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public InvoicePayment setType(String type) {
        this.type = type;
        return this;
    }

    public Money getAmount() {
        return amount;
    }

    public InvoicePayment setAmount(Money amount) {
        this.amount = amount;
        return this;
    }

    public PaymentData getData() {
        return data;
    }

    public InvoicePayment setData(PaymentData data) {
        this.data = data;
        return this;
    }
}
