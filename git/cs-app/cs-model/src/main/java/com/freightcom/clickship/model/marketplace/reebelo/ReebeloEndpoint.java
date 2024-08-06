package com.freightcom.clickship.model.marketplace.reebelo;

public enum ReebeloEndpoint {
    
	GET_ORDERS("/sockets/orders"),
	SHIPMENT_URL("/sockets/orders/track");


    private String value;

    ReebeloEndpoint(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
