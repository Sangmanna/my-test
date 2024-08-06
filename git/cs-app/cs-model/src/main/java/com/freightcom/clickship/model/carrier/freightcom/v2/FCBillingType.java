package com.freightcom.clickship.model.carrier.freightcom.v2;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum FCBillingType {
	
    @JsonProperty("net-terms")
	NETTERMS,
    
	@JsonProperty("credit-card")
    CREDITCARD

}
