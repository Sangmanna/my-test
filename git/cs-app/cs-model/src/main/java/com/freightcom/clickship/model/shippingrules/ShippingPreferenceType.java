package com.freightcom.clickship.model.shippingrules;

public enum ShippingPreferenceType {
	BEST_RATE("Best Rate"),
	FASTEST("Fastest"),
	SPECIFIC_CARRIERS("Specific Carriers"),
	RTR_CARRIER("RTR Carrier");
	
	private String type;
	
	ShippingPreferenceType(String s) {
		this.type = s;
	}

	public String getType() {
		return type;
	}
}
