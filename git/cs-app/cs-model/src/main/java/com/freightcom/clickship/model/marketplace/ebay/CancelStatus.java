package com.freightcom.clickship.model.marketplace.ebay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CancelStatus {

    @JsonProperty("cancelledDate")
    private String cancelledDate;

    @JsonProperty("cancelRequests")
    private List<CancelRequest> cancelRequests;

    @JsonProperty("cancelState")
    private String cancelState;

    public String getCancelledDate() {
        return cancelledDate;
    }

    public void setCancelledDate(String cancelledDate) {
        this.cancelledDate = cancelledDate;
    }

    public List<CancelRequest> getCancelRequests() {
        return cancelRequests;
    }

    public void setCancelRequests(List<CancelRequest> cancelRequests) {
        this.cancelRequests = cancelRequests;
    }

    public String getCancelState() {
        return cancelState;
    }

    public void setCancelState(String cancelState) {
        this.cancelState = cancelState;
    }
}
