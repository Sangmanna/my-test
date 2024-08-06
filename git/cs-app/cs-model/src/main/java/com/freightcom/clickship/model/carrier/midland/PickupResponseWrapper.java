package com.freightcom.clickship.model.carrier.midland;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value= JsonInclude.Include.NON_EMPTY, content= JsonInclude.Include.NON_NULL)
public class PickupResponseWrapper {
    private PickupResponse pickupResponse;

    public PickupResponse getPickupResponse() {
        return pickupResponse;
    }

    public void setPickupResponse(PickupResponse pickupResponse) {
        this.pickupResponse = pickupResponse;
    }
}
