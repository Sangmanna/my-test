package com.freightcom.clickship.model.marketplace.reebelo;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ReebeloFinancialStatus {

	AUTHORIZED("authorized"),
	PENDING("pending"),
	PAID("paid"),
	PARTIALLY_PAID("partially_paid"),
	REFUNDED("refunded"),
	VOIDED("voided"),
	PARTIALLY_REFUNDED("partially_refunded"),
	ANY("any"),
	UNPAIED("unpaied");
	
    private String value;
    
	private ReebeloFinancialStatus(){
		this.value = name();
	}

    private ReebeloFinancialStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
    
    @Override
	public String toString() {
		return value;
	}
}
