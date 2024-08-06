package com.freightcom.clickship.model.carrier.midland;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value= JsonInclude.Include.NON_EMPTY, content= JsonInclude.Include.NON_NULL)
public class RateQuoteRequest {

    @JsonProperty("ShipDate")
    private String shipDate;
    
    @JsonProperty("ShipZip")
    private String shipZip;
    
    @JsonProperty("ConsZip")
    private String consZip;
    
    @JsonProperty("DeclaredValue")
    private double declaredValue;
    
    @JsonProperty("CODAmount")
    private double codAmount;
    
    @JsonProperty("CheckReturnAmount")
    private double checkReturnAmount;

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public String getShipZip() {
        return shipZip;
    }

    public void setShipZip(String shipZip) {
        this.shipZip = shipZip;
    }

    public String getConsZip() {
        return consZip;
    }

    public void setConsZip(String consZip) {
        this.consZip = consZip;
    }

    public double getDeclaredValue() {
        return declaredValue;
    }

    public void setDeclaredValue(double declaredValue) {
        this.declaredValue = declaredValue;
    }

    public double getCodAmount() {
        return codAmount;
    }

    public void setCodAmount(double codAmount) {
        this.codAmount = codAmount;
    }

    public double getCheckReturnAmount() {
        return checkReturnAmount;
    }

    public void setCheckReturnAmount(double checkReturnAmount) {
        this.checkReturnAmount = checkReturnAmount;
    }
}
