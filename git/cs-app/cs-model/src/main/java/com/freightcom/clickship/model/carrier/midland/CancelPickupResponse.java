package com.freightcom.clickship.model.carrier.midland;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value= JsonInclude.Include.NON_EMPTY, content= JsonInclude.Include.NON_NULL)
public class CancelPickupResponse {
    
	@JsonProperty("ttConfirmationMessage")
    private List<CancelPickupConfirmation> cancelPickupConfirmation;
  
	@JsonProperty("ttErrorMessage")
    private List<MidlandErrorMessage> midlandErrorMessage;

    public List<CancelPickupConfirmation> getCancelPickupConfirmation() {
        return cancelPickupConfirmation;
    }

    public void setCancelPickupConfirmation(List<CancelPickupConfirmation> cancelPickupConfirmation) {
        this.cancelPickupConfirmation = cancelPickupConfirmation;
    }

    public List<MidlandErrorMessage> getMidlandErrorMessage() {
        return midlandErrorMessage;
    }

    public void setMidlandErrorMessage(List<MidlandErrorMessage> midlandErrorMessage) {
        this.midlandErrorMessage = midlandErrorMessage;
    }
}
