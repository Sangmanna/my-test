package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateRestrictedDataTokenRequest {

    @JsonProperty("restrictedResources")
    private List<RestrictedResource> restrictedResources;

    public List<RestrictedResource> getRestrictedResources() {
        return restrictedResources;
    }

    public CreateRestrictedDataTokenRequest setRestrictedResources(List<RestrictedResource> restrictedResources) {
        this.restrictedResources = restrictedResources;
        return this;
    }
}
