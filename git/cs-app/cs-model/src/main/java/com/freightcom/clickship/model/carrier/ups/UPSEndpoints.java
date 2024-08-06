package com.freightcom.clickship.model.carrier.ups;

public enum UPSEndpoints {

	TRACKING("/track/v1/details/"),
	TIME_IN_TRANSIT("/rest/TimeInTransit"),
	RATE("/ship/v1/rating/Shop?additionalinfo=timeintransit");
	
	
    private String value;

	UPSEndpoints(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
