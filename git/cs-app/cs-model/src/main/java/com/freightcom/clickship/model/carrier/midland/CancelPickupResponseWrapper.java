package com.freightcom.clickship.model.carrier.midland;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value= JsonInclude.Include.NON_EMPTY, content= JsonInclude.Include.NON_NULL)
public class CancelPickupResponseWrapper {
    @JsonProperty("CancelPickupResponse")
    private CancelPickupResponse cancelPickupResponse;

    public CancelPickupResponse getCancelPickupResponse() {
        return cancelPickupResponse;
    }

    public void setCancelPickupResponse(CancelPickupResponse cancelPickupResponse) {
        this.cancelPickupResponse = cancelPickupResponse;
    }
}
