package com.freightcom.clickship.model.carrier.midland;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value= JsonInclude.Include.NON_EMPTY, content= JsonInclude.Include.NON_NULL)
public class RateQuoteCharge {

    @JsonProperty("QuoteNumber")
    private int quoteNumber;
    @JsonProperty("ChargeLineNo")
    private int chargeLineNo;
    @JsonProperty("ChargeDesc")
    private String chargeDesc;
    @JsonProperty("ChargeAmount")
    private double chargeAmount;

    public int getQuoteNumber() {
        return quoteNumber;
    }

    public void setQuoteNumber(int quoteNumber) {
        this.quoteNumber = quoteNumber;
    }

    public int getChargeLineNo() {
        return chargeLineNo;
    }

    public void setChargeLineNo(int chargeLineNo) {
        this.chargeLineNo = chargeLineNo;
    }

    public String getChargeDesc() {
        return chargeDesc;
    }

    public void setChargeDesc(String chargeDesc) {
        this.chargeDesc = chargeDesc;
    }

    public double getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(double chargeAmount) {
        this.chargeAmount = chargeAmount;
    }
}
