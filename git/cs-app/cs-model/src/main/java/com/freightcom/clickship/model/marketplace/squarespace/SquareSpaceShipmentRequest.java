package com.freightcom.clickship.model.marketplace.squarespace;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SquareSpaceShipmentRequest {

    @JsonProperty("shouldSendNotification")
    private boolean shouldSendNotification;

    @JsonProperty("shipments")
    private List<SquareSpaceShipment> shipments;

    public boolean isShouldSendNotification() {
        return shouldSendNotification;
    }

    public SquareSpaceShipmentRequest setShouldSendNotification(boolean shouldSendNotification) {
        this.shouldSendNotification = shouldSendNotification;
        return this;
    }

    public List<SquareSpaceShipment> getShipments() {
        return shipments;
    }

    public SquareSpaceShipmentRequest setShipments(List<SquareSpaceShipment> shipments) {
        this.shipments = shipments;
        return this;
    }
}
