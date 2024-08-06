package com.freightcom.clickship.model.carrier.canpar;

public enum CANPAREndpoint {

	ADDON("%s/canshipws/services/CanparAddonsService"),
	RATING("%s/canshipws/services/CanparRatingService"),
	BUSINESS("%s/canshipws/services/CanshipBusinessService");

	private String value;

	CANPAREndpoint(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
