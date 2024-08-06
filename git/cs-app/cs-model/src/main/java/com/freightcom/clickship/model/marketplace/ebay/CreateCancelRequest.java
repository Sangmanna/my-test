package com.freightcom.clickship.model.marketplace.ebay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateCancelRequest {

    @JsonProperty("legacyOrderId")
    private String legacyOrderId;

    @JsonProperty("cancelReason")
    private String cancelReason;

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public String getLegacyOrderId() {
        return legacyOrderId;
    }

    public void setLegacyOrderId(String legacyOrderId) {
        this.legacyOrderId = legacyOrderId;
    }
}


