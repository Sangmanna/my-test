package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SellerSKUIdentifier {
    @JsonProperty("MarketplaceId")
    private String marketplaceId;

    @JsonProperty("SellerId")
    private String sellerId;

    @JsonProperty("SellerSKU")
    private String sellerSKU;

    public String getMarketplaceId() {
        return marketplaceId;
    }

    public SellerSKUIdentifier setMarketplaceId(String marketplaceId) {
        this.marketplaceId = marketplaceId;
        return this;
    }

    public String getSellerId() {
        return sellerId;
    }

    public SellerSKUIdentifier setSellerId(String sellerId) {
        this.sellerId = sellerId;
        return this;
    }

    public String getSellerSKU() {
        return sellerSKU;
    }

    public SellerSKUIdentifier setSellerSKU(String sellerSKU) {
        this.sellerSKU = sellerSKU;
        return this;
    }
}
