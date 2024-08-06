package com.freightcom.clickship.model.carrier.midland;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(value= JsonInclude.Include.NON_EMPTY, content= JsonInclude.Include.NON_NULL)
public class TrackingDetails {
    @JsonProperty("Status Date")
    private String statusDate;
    @JsonProperty("Status Time")
    private String statusTime;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("Location")
    private String location;

    public String getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(String statusDate) {
        this.statusDate = statusDate;
    }

    public String getStatusTime() {
        return statusTime;
    }

    public void setStatusTime(String statusTime) {
        this.statusTime = statusTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
