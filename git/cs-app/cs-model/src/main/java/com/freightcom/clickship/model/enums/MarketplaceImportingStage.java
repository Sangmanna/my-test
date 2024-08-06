package com.freightcom.clickship.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MarketplaceImportingStage {
	
	INITIAL_IMPORT("INITIAL_IMPORT"),
	IMPORT_ADDRESS("IMPORT_ADDRESS"),
	IMPORT_PRODUCT("IMPORT_PRODUCT"),
	IMPORT_ORDER("IMPORT_ORDER"),
	IMPORT_INVENTORY("IMPORT_INVENTORY"),
	INVALID_METRICS("INVALID_METRICS"),
	EMAIL_REPORT("EMAIL_REPORT"),
	REGISTER_WEBHOOK("REGISTER_WEBHOOK"),
	WEBHOOK_REQUEST("WEBHOOK_REQUEST"),
	QUARTZ_JOB("QUARTZ_JOB"),
	QUARTZ_JOB_ORDER_UPDATES("QUARTZ_JOB_ORDER_UPDATES"),
	QUARTZ_JOB_PRODUCT_UPDATES("QUARTZ_JOB_PRODUCT_UPDATES");
	
    private String value;
    
	private MarketplaceImportingStage(){
		this.value = name();
	}

    private MarketplaceImportingStage(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
    
	public String toString() {
		return value;
	}
}
