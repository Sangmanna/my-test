package com.freightcom.clickship.model.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FcSchedulePickupResponse {

    @JsonProperty("status")
    private String status;

    @JsonProperty("error")
    private String error;

    @JsonProperty("pickup_confirmation_number")
    private String pickup_confirmation_number;

    public String getStatus() {
        return status;
    }

    public FcSchedulePickupResponse setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getError() {
        return error;
    }

    public FcSchedulePickupResponse setError(String error) {
        this.error = error;
        return this;
    }

    public String getPickup_confirmation_number() {
        return pickup_confirmation_number;
    }

    public FcSchedulePickupResponse setPickup_confirmation_number(String pickup_confirmation_number) {
        this.pickup_confirmation_number = pickup_confirmation_number;
        return this;
    }
}
