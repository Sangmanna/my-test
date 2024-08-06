package com.freightcom.clickship.model.marketplace.ebay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CancelRequest {

    @JsonProperty("cancelCompletedDate")
    private String cancelCompletedDate;

    @JsonProperty("cancelInitiator")
    private String cancelInitiator;

    @JsonProperty("cancelReason")
    private String cancelReason;

    @JsonProperty("cancelRequestedDate")
    private String cancelRequestedDate;

    @JsonProperty("cancelRequestId")
    private String cancelRequestId;

    @JsonProperty("cancelRequestState")
    private String cancelRequestState;

    public String getCancelCompletedDate() {
        return cancelCompletedDate;
    }

    public void setCancelCompletedDate(String cancelCompletedDate) {
        this.cancelCompletedDate = cancelCompletedDate;
    }

    public String getCancelInitiator() {
        return cancelInitiator;
    }

    public void setCancelInitiator(String cancelInitiator) {
        this.cancelInitiator = cancelInitiator;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public String getCancelRequestedDate() {
        return cancelRequestedDate;
    }

    public void setCancelRequestedDate(String cancelRequestedDate) {
        this.cancelRequestedDate = cancelRequestedDate;
    }

    public String getCancelRequestId() {
        return cancelRequestId;
    }

    public void setCancelRequestId(String cancelRequestId) {
        this.cancelRequestId = cancelRequestId;
    }

    public String getCancelRequestState() {
        return cancelRequestState;
    }

    public void setCancelRequestState(String cancelRequestState) {
        this.cancelRequestState = cancelRequestState;
    }
}
