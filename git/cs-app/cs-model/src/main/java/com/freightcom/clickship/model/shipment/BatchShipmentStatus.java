package com.freightcom.clickship.model.shipment;

public enum BatchShipmentStatus {
	
	FAILED("Failed"),
	SUCCESS("Success");
	
    private String value;

	BatchShipmentStatus(String value) {
    	 this.value = value;
	}

	public String getValue() {
        return value;
    }

}
