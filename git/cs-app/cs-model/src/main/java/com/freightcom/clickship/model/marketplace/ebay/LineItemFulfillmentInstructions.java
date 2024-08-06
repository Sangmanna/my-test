package com.freightcom.clickship.model.marketplace.ebay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LineItemFulfillmentInstructions {

    @JsonProperty("guaranteedDelivery")
    private Boolean guaranteedDelivery = null;

    @JsonProperty("maxEstimatedDeliveryDate")
    private String maxEstimatedDeliveryDate = null;

    @JsonProperty("minEstimatedDeliveryDate")
    private String minEstimatedDeliveryDate = null;

    @JsonProperty("shipByDate")
    private String shipByDate = null;

    public Boolean getGuaranteedDelivery() {
        return guaranteedDelivery;
    }

    public void setGuaranteedDelivery(Boolean guaranteedDelivery) {
        this.guaranteedDelivery = guaranteedDelivery;
    }

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

    public String getShipByDate() {
        return shipByDate;
    }

    public void setShipByDate(String shipByDate) {
        this.shipByDate = shipByDate;
    }
}
