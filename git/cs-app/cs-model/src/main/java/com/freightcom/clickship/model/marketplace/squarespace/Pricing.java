package com.freightcom.clickship.model.marketplace.squarespace;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pricing {

    @JsonProperty("basePrice")
    private SquareSpacePrice basePrice;

    @JsonProperty("salePrice")
    private SquareSpacePrice salePrice;

    @JsonProperty("onSale")
    private boolean onSale;

    public SquareSpacePrice getBasePrice() {
        return basePrice;
    }

    public Pricing setBasePrice(SquareSpacePrice basePrice) {
        this.basePrice = basePrice;
        return this;
    }

    public SquareSpacePrice getSalePrice() {
        return salePrice;
    }

    public Pricing setSalePrice(SquareSpacePrice salePrice) {
        this.salePrice = salePrice;
        return this;
    }

    public boolean getOnSale() {
        return onSale;
    }

    public Pricing setOnSale(boolean onSale) {
        this.onSale = onSale;
        return this;
    }
}
