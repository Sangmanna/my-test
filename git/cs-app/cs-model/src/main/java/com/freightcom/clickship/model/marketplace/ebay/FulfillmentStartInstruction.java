package com.freightcom.clickship.model.marketplace.ebay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FulfillmentStartInstruction {

    @JsonProperty("maxEstimatedDeliveryDate")
    private String maxEstimatedDeliveryDate;

    @JsonProperty("minEstimatedDeliveryDate")
    private String minEstimatedDeliveryDate;

    @JsonProperty("shippingStep")
    private ShippingStep shippingStep;

    public String getMaxEstimatedDeliveryDate() {
        return maxEstimatedDeliveryDate;
    }

    public void setMaxEstimatedDeliveryDate(String maxEstimatedDeliveryDate) {
        this.maxEstimatedDeliveryDate = maxEstimatedDeliveryDate;
    }

    public String getMinEstimatedDeliveryDate() {
        return minEstimatedDeliveryDate;
    }

    public void setMinEstimatedDeliveryDate(String minEstimatedDeliveryDate) {
        this.minEstimatedDeliveryDate = minEstimatedDeliveryDate;
    }

    public ShippingStep getShippingStep() {
        return shippingStep;
    }

    public void setShippingStep(ShippingStep shippingStep) {
        this.shippingStep = shippingStep;
    }
}
