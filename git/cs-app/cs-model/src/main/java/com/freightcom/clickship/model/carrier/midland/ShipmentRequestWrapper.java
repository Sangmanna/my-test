package com.freightcom.clickship.model.carrier.midland;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value= JsonInclude.Include.NON_EMPTY, content= JsonInclude.Include.NON_NULL)
public class ShipmentRequestWrapper {

    public ShipmentRequestWrapper(){

    }
    public ShipmentRequestWrapper(ShipmentRequest shipmentRequest) {
        this.shipmentRequest = shipmentRequest;
    }

    private ShipmentRequest shipmentRequest;

    public ShipmentRequest getShipmentRequest() {
        return shipmentRequest;
    }

    public void setShipmentRequest(ShipmentRequest shipmentRequest) {
        this.shipmentRequest = shipmentRequest;
    }
}
