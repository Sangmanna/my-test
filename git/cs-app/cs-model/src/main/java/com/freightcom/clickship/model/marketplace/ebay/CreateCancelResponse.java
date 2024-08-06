package com.freightcom.clickship.model.marketplace.ebay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateCancelResponse {

    @JsonProperty("cancel_id")
    private String cancelId;

    public String getCancelId() {
        return cancelId;
    }

    public void setCancelId(String cancelId) {
        this.cancelId = cancelId;
    }
}
