package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateRestrictedDataTokenResponse {

    @JsonProperty("payload")
    private RDTPayload rdtPayload;

    public RDTPayload getRdtPayload() {
        return rdtPayload;
    }

    public CreateRestrictedDataTokenResponse setRdtPayload(RDTPayload rdtPayload) {
        this.rdtPayload = rdtPayload;
        return this;
    }
}
