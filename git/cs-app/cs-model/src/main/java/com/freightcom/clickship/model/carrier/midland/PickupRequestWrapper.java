package com.freightcom.clickship.model.carrier.midland;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(value= JsonInclude.Include.NON_EMPTY, content= JsonInclude.Include.NON_NULL)
public class PickupRequestWrapper {

    public PickupRequestWrapper() {
    }

    public PickupRequestWrapper(List<PickupRequest> pickupRequests) {
        this.pickupRequests = pickupRequests;
    }
    @JsonProperty("pickupRequest")
    private List<PickupRequest> pickupRequests;

    public List<PickupRequest> getPickupRequests() {
        return pickupRequests;
    }

    public void setPickupRequests(List<PickupRequest> pickupRequests) {
        this.pickupRequests = pickupRequests;
    }
}
