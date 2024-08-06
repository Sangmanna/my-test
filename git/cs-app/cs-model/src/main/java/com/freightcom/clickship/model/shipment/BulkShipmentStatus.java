package com.freightcom.clickship.model.shipment;

public enum BulkShipmentStatus {

	QUEUE("Queue"),
	FAILED("Failed"),
	COMPLETED("Completed"),
	PROCESSING("Processing"),
	FINAL_STEPS("Final Steps"),
	PARTIALLY_COMPLETED("Partially Completed");
	
    private String value;

    BulkShipmentStatus(String value) {
    	 this.value = value;
	}

	public String getValue() {
        return value;
    }

}
