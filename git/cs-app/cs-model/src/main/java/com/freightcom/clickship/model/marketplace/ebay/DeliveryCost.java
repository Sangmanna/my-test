package com.freightcom.clickship.model.marketplace.ebay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeliveryCost {

//    @JsonProperty("importCharges")
//    private Amount importCharges = null;

    @JsonProperty("shippingCost")
    private Amount shippingCost;

//    @JsonProperty("shippingIntermediationFee")
//    private Amount shippingIntermediationFee = null;


    public Amount getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(Amount shippingCost) {
        this.shippingCost = shippingCost;
    }
}
