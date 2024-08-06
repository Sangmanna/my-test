package com.freightcom.clickship.model.marketplace.lightspeed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LightSpeedShipmentRequest {
    @JsonProperty("shipment")
    private LightSpeedShipment shipment;

    public LightSpeedShipment getShipment() {
        return shipment;
    }

    public void setShipment(LightSpeedShipment shipment) {
        this.shipment = shipment;
    }
}
