package com.freightcom.clickship.model.carrier.midland;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value= JsonInclude.Include.NON_EMPTY, content= JsonInclude.Include.NON_NULL)
public class RateQuoteReqLine {

    @JsonProperty("QuoteLineNo")
    private int quoteLineNo;
    @JsonProperty("Pieces")
    private int pieces;
    @JsonProperty("Weight")
    private double weight;
    @JsonProperty("WeightUnits")
    private String weightUnits;

    public int getQuoteLineNo() {
        return quoteLineNo;
    }

    public void setQuoteLineNo(int quoteLineNo) {
        this.quoteLineNo = quoteLineNo;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getWeightUnits() {
        return weightUnits;
    }

    public void setWeightUnits(String weightUnits) {
        this.weightUnits = weightUnits;
    }
}
