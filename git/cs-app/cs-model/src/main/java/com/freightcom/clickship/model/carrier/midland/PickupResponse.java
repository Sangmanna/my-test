package com.freightcom.clickship.model.carrier.midland;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value= JsonInclude.Include.NON_EMPTY, content= JsonInclude.Include.NON_NULL)
public class PickupResponse {
   
	private List<PickupDetails> pickupDetails;
    
	@JsonProperty("ttErrorMessage")
    private List<MidlandErrorMessage> midlandErrorMessages;

    public List<PickupDetails> getPickupDetails() {
        return pickupDetails;
    }

    public void setPickupDetails(List<PickupDetails> pickupDetails) {
        this.pickupDetails = pickupDetails;
    }

    public List<MidlandErrorMessage> getMidlandErrorMessages() {
        return midlandErrorMessages;
    }

    public void setMidlandErrorMessages(List<MidlandErrorMessage> midlandErrorMessages) {
        this.midlandErrorMessages = midlandErrorMessages;
    }
}
