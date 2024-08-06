package com.freightcom.clickship.model.marketplace.lightspeed;

public enum LightSpeedOrderStatus {
    
	NEW("new"),
    OFFER("offer"),
    ON_HOLD("on_hold"),
    CANCELLED("cancelled"),
    COMPLETED("completed"),
    PROCESSING("processing"),
    COMPLETED_SHIPPED("completed_shipped"),
    COMPLETED_PICKED_UP("completed_picked_up"),
    PROCESSING_AWAITING_PICKUP("processing_awaiting_pickup"),
    PROCESSING_READY_FOR_PICKUP("processing_ready_for_pickup"),
    PROCESSING_AWAITING_PAYMENT("processing_awaiting_payment"),
    PROCESSING_AWAITING_SHIPMENT("processing_awaiting_shipment");
	
    private String value;

    private LightSpeedOrderStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
