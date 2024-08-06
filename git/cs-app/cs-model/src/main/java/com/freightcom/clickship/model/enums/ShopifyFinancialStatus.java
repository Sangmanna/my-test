package com.freightcom.clickship.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ShopifyFinancialStatus {

	authorized("authorized"),
	pending("pending"),
	paid("paid"),
	partially_paid("partially_paid"),
	refunded("refunded"),
	voided("voided"),
	partially_refunded("partially_refunded"),
	any("any"),
	unpaied("unpaied");
	
    private String value;
    
	private ShopifyFinancialStatus(){
		this.value = name();
	}

    private ShopifyFinancialStatus(String value) {
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
