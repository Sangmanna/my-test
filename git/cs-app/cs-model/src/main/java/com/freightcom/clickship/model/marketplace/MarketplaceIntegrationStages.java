package com.freightcom.clickship.model.marketplace;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MarketplaceIntegrationStages {
	
	FAILED(0, "Integration failed."),
	SUCCESS(1, "Integration & initial import successfull."),
	TWO(2, "Authorization successful. Importing your products & orders."),
	THREE(3, "Your location details have been added. Your store products are now being imported."),
	FOUR(4, "%s/%s products are currently being imported."),
	FIVE(5, "Your product details have been added. We are currently importing your orders."),
	SIX(6, "%s/%s orders are currently being imported."),
	SEVEN(7, "The final steps of the integration process are now being completed, a confirmation e-mail will be sent upon completion.");
	
	private int stage;
    private String value;
    
    private MarketplaceIntegrationStages(int stage, String value) {
    	this.stage = stage;
        this.value = value;
    }
    
    @JsonValue
    public int getStage() {
        return stage;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
    
	public String toString() {
		return value;
	}
}
