package com.freightcom.clickship.model.marketplace.lightspeed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LightSpeedExternalService extends LightSpeedBaseEntity {

    @JsonProperty("type")
    private String type;

    @JsonProperty("name")
    private String name;

    @JsonProperty("urlEndpoint")
    private String urlEndpoint;

    @JsonProperty("isActive")
    private boolean isActive;

    @JsonProperty("rateEstimate")
    private boolean rateEstimate;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlEndpoint() {
        return urlEndpoint;
    }

    public void setUrlEndpoint(String urlEndpoint) {
        this.urlEndpoint = urlEndpoint;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isRateEstimate() {
        return rateEstimate;
    }

    public void setRateEstimate(boolean rateEstimate) {
        this.rateEstimate = rateEstimate;
    }
}
