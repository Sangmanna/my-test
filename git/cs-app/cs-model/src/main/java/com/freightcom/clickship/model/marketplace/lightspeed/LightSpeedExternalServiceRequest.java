package com.freightcom.clickship.model.marketplace.lightspeed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LightSpeedExternalServiceRequest {
    @JsonProperty("externalService")
    private LightSpeedExternalService externalService;

    public LightSpeedExternalService getExternalService() {
        return externalService;
    }

    public void setExternalService(LightSpeedExternalService externalService) {
        this.externalService = externalService;
    }
}
