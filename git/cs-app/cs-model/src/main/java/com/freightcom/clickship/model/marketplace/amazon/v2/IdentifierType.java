package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IdentifierType {

    @JsonProperty("MarketplaceASIN")
    private ASINIdentifier marketplaceASIN;

    @JsonProperty("SKUIdentifier")
    private SellerSKUIdentifier sKUIdentifier;

    public ASINIdentifier getMarketplaceASIN() {
        return marketplaceASIN;
    }

    public IdentifierType setMarketplaceASIN(ASINIdentifier marketplaceASIN) {
        this.marketplaceASIN = marketplaceASIN;
        return this;
    }

    public SellerSKUIdentifier getsKUIdentifier() {
        return sKUIdentifier;
    }

    public IdentifierType setsKUIdentifier(SellerSKUIdentifier sKUIdentifier) {
        this.sKUIdentifier = sKUIdentifier;
        return this;
    }
}
