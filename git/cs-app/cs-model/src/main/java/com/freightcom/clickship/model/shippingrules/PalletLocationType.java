package com.freightcom.clickship.model.shippingrules;

public enum PalletLocationType {
	BUSINESS_TAILGATE_NOT_REQUIRED("commercial-business-with-dock"),
	BUSINESS_TAILGATE_REQUIRED("commercial-business-with-tailgate-required"),
	RESIDENCE_TAILGATE_REQUIRED("residential-with-tailgate-required"),
	RESIDENCE_TAILGATE_NOT_REQUIRED("residential-without-tailgate-required");
	
	private String type;

	PalletLocationType(String s) {
		this.type = s;
	}

	public String getType() {
		return type;
	}
	
	public static PalletLocationType get(String type) {
	    for (PalletLocationType palletLocationType : PalletLocationType.values()) {
	        if (palletLocationType.getType().equals(type)) {
	            return palletLocationType;
	        }
	    }
	    throw new IllegalArgumentException("No PalletLocationType found with type: " + type);
	}
}
