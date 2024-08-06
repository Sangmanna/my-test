package com.freightcom.clickship.client.midland;

public enum MidlandEndpoint {
    GET_RATES("MidlandGetRateQuote/1.0.0/RateQuote"),
    CREATE_SHIPMENT("MidlandShipmentRequest/1.0/shipment/request"),
    CANCEL_SHIPMENT("MidlandCancelShipment/1.0/shipment/cancel?refno="),
    TRACK_AND_TRACE("MidlandTrackandTrace/1.0.1/shipment/tracking?refno="),
    PICKUP("MidlandSchedulePickup/1.0/pickup"),
    CANCEL_PICKUP("MidlandCancelPickup/1.0/pickup/{PickupNumber}/pronumber/{pronumber}");


    private String value;

    MidlandEndpoint(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
