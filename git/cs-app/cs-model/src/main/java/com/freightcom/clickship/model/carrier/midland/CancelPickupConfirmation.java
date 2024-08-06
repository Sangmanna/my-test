package com.freightcom.clickship.model.carrier.midland;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value= JsonInclude.Include.NON_EMPTY, content= JsonInclude.Include.NON_NULL)
public class CancelPickupConfirmation {

    @JsonProperty("ConfirmationMessage")
    private String confirmationMessage;
    @JsonProperty("ConfirmationMessageTranslated")
    private String confirmationMessageTranslated;

    public String getConfirmationMessage() {
        return confirmationMessage;
    }

    public void setConfirmationMessage(String confirmationMessage) {
        this.confirmationMessage = confirmationMessage;
    }

    public String getConfirmationMessageTranslated() {
        return confirmationMessageTranslated;
    }

    public void setConfirmationMessageTranslated(String confirmationMessageTranslated) {
        this.confirmationMessageTranslated = confirmationMessageTranslated;
    }
}
