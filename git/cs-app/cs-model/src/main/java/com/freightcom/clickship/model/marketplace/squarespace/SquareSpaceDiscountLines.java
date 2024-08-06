package com.freightcom.clickship.model.marketplace.squarespace;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SquareSpaceDiscountLines {

    @JsonProperty("name")
    private String name;

    @JsonProperty("amount")
    private SquareSpacePrice amount;

    @JsonProperty("promoCode")
    private String promoCode;

    public String getName() {
        return name;
    }

    public SquareSpaceDiscountLines setName(String name) {
        this.name = name;
        return this;
    }

    public SquareSpacePrice getAmount() {
        return amount;
    }

    public SquareSpaceDiscountLines setAmount(SquareSpacePrice amount) {
        this.amount = amount;
        return this;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public SquareSpaceDiscountLines setPromoCode(String promoCode) {
        this.promoCode = promoCode;
        return this;
    }
}
