package com.freightcom.clickship.model.marketplace.lightspeed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LightSpeedShipment extends LightSpeedBaseEntity {

    @JsonProperty("number")
    private String number;

    @JsonProperty("status")
    private String status;

    @JsonProperty("trackingCode")
    private String trackingCode;

    @JsonProperty("doNotifyShipped")
    private boolean doNotifyShipped;

    @JsonProperty("doNotifyReadyForPickup")
    private boolean doNotifyReadyForPickup;

    @JsonProperty("doNotifyTrackingCode")
    private boolean doNotifyTrackingCode;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTrackingCode() {
        return trackingCode;
    }

    public void setTrackingCode(String trackingCode) {
        this.trackingCode = trackingCode;
    }

    public boolean isDoNotifyShipped() {
        return doNotifyShipped;
    }

    public void setDoNotifyShipped(boolean doNotifyShipped) {
        this.doNotifyShipped = doNotifyShipped;
    }

    public boolean isDoNotifyReadyForPickup() {
        return doNotifyReadyForPickup;
    }

    public void setDoNotifyReadyForPickup(boolean doNotifyReadyForPickup) {
        this.doNotifyReadyForPickup = doNotifyReadyForPickup;
    }

    public boolean isDoNotifyTrackingCode() {
        return doNotifyTrackingCode;
    }

    public void setDoNotifyTrackingCode(boolean doNotifyTrackingCode) {
        this.doNotifyTrackingCode = doNotifyTrackingCode;
    }
}
