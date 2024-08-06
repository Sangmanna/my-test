package com.freightcom.clickship.data.entity.common;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ClickShipOrderStatus {
	
	AutoFulfill("AutoFulfill"),
	UnFulfilled("Unfulfilled"),
	Fulfilled("Fulfilled"),
	ExternallyFulfilled("ExternallyFulfilled"),
	OnHold("On-Hold"),
	Cancelled("Cancelled"),
	Closed("Closed"),
	Pending("Pending"),
	Quoted("Quoted");
	
    private String value;
    
	private ClickShipOrderStatus(){
		this.value = name();
	}

    private ClickShipOrderStatus(String value) {
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
