package com.freightcom.clickship.model.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CartBookingStatus {
	
	@JsonProperty("result")
    private CartBookingResult result;

    public CartBookingResult getResult() {
        return result;
    }

    public void setResult(CartBookingResult result) {
        this.result = result;
    }
}
