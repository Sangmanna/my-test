package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AmazonV2ItemBuyerInfo {

    @JsonProperty("GiftWrapPrice")
    private AmazonMoney giftWrapPrice;

    @JsonProperty("GiftWrapTax")
    private AmazonMoney giftWrapTax;

    public AmazonMoney getGiftWrapPrice() {
        return giftWrapPrice;
    }

    public AmazonV2ItemBuyerInfo setGiftWrapPrice(AmazonMoney giftWrapPrice) {
        this.giftWrapPrice = giftWrapPrice;
        return this;
    }

    public AmazonMoney getGiftWrapTax() {
        return giftWrapTax;
    }

    public AmazonV2ItemBuyerInfo setGiftWrapTax(AmazonMoney giftWrapTax) {
        this.giftWrapTax = giftWrapTax;
        return this;
    }
}
