package com.freightcom.clickship.model.marketplace.lightspeed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LightSpeedCancelRequest {
    @JsonProperty("order")
    private LightSpeedOrder order;

    public LightSpeedOrder getOrder() {
        return order;
    }

    public void setOrder(LightSpeedOrder order) {
        this.order = order;
    }
}
