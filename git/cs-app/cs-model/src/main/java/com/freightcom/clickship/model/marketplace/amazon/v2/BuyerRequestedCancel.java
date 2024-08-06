package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BuyerRequestedCancel {

    @JsonProperty("IsBuyerRequestedCancel")
    private Boolean isBuyerRequestedCancel;

    @JsonProperty("BuyerCancelReason")
    private String buyerCancelReason;

    public Boolean getBuyerRequestedCancel() {
        return isBuyerRequestedCancel;
    }

    public BuyerRequestedCancel setBuyerRequestedCancel(Boolean buyerRequestedCancel) {
        isBuyerRequestedCancel = buyerRequestedCancel;
        return this;
    }

    public String getBuyerCancelReason() {
        return buyerCancelReason;
    }

    public BuyerRequestedCancel setBuyerCancelReason(String buyerCancelReason) {
        this.buyerCancelReason = buyerCancelReason;
        return this;
    }
}
