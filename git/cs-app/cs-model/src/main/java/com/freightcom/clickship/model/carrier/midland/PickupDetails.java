package com.freightcom.clickship.model.carrier.midland;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value= JsonInclude.Include.NON_EMPTY, content= JsonInclude.Include.NON_NULL)
public class PickupDetails {
    @JsonProperty("pronumber")
    private String proNumber;
    private String pickupNumber;
    private String pickupDate;

    public String getProNumber() {
        return proNumber;
    }

    public void setProNumber(String proNumber) {
        this.proNumber = proNumber;
    }

    public String getPickupNumber() {
        return pickupNumber;
    }

    public void setPickupNumber(String pickupNumber) {
        this.pickupNumber = pickupNumber;
    }

    public String getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(String pickupDate) {
        this.pickupDate = pickupDate;
    }
}
