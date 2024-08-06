package com.freightcom.clickship.model.marketplace;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MarketplaceImportingStatus {
	
	NONE(""),
	FAILED("Failed"),
	COMPLETED("Completed"),
	IN_PROGRESS("In Progress");
	
    private String value;
    
    private MarketplaceImportingStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
    
}
