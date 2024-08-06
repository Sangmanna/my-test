package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ASINIdentifier {

    @JsonProperty("MarketplaceId")
    private String marketplaceId;

    @JsonProperty("ASIN")
    private String asin;

    public String getMarketplaceId() {
        return marketplaceId;
    }

    public ASINIdentifier setMarketplaceId(String marketplaceId) {
        this.marketplaceId = marketplaceId;
        return this;
    }

    public String getAsin() {
        return asin;
    }

    public ASINIdentifier setAsin(String asin) {
        this.asin = asin;
        return this;
    }
}
