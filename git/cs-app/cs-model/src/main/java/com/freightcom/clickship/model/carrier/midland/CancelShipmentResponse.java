package com.freightcom.clickship.model.carrier.midland;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value= JsonInclude.Include.NON_EMPTY, content= JsonInclude.Include.NON_NULL)
public class CancelShipmentResponse {
    @JsonProperty("RequestStatus")
    private CancelRequestStatus cancelRequestStatus;
    @JsonProperty("ErrorMessage")
    private MidlandErrorMessage errorMessage;

    public CancelRequestStatus getCancelRequestStatus() {
        return cancelRequestStatus;
    }

    public void setCancelRequestStatus(CancelRequestStatus cancelRequestStatus) {
        this.cancelRequestStatus = cancelRequestStatus;
    }

    public MidlandErrorMessage getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(MidlandErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }
}
