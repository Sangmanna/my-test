package com.freightcom.clickship.model.carrier.midland;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShipmentResponse {

    @JsonProperty("shipment")
    private MidlandShipment midlandShipment;

    @JsonProperty("ttErrorMessage")
    private MidlandErrorMessage midlandErrorMessage;

    public MidlandShipment getMidlandShipment() {
        return midlandShipment;
    }

    public void setMidlandShipment(MidlandShipment midlandShipment) {
        this.midlandShipment = midlandShipment;
    }

    public MidlandErrorMessage getMidlandErrorMessage() {
        return midlandErrorMessage;
    }

    public void setMidlandErrorMessage(MidlandErrorMessage midlandErrorMessage) {
        this.midlandErrorMessage = midlandErrorMessage;
    }
}
