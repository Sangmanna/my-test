package com.freightcom.clickship.model.carrier.midland;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestWrapper {

    public RequestWrapper(RateQuoteReq rateQuoteReq) {
        this.rateQuoteReq = rateQuoteReq;
    }

    @JsonProperty("RateQuoteReq")
    private RateQuoteReq rateQuoteReq;
}
