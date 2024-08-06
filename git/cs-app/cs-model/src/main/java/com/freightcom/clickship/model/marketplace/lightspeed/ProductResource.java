package com.freightcom.clickship.model.marketplace.lightspeed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductResource {

    @JsonProperty("resource")
    private LightSpeedResource resource;

    public LightSpeedResource getResource() {
        return resource;
    }

    public void setResource(LightSpeedResource resource) {
        this.resource = resource;
    }
}
