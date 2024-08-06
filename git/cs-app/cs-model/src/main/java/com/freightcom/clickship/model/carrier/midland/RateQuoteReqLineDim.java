package com.freightcom.clickship.model.carrier.midland;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value= JsonInclude.Include.NON_EMPTY, content= JsonInclude.Include.NON_NULL)
public class RateQuoteReqLineDim {

    @JsonProperty("QuoteLineNo")
    private String quoteLineNo;
    @JsonProperty("DimLineNo")
    private String dimLineNo;
    @JsonProperty("DimUnits")
    private String dimUnits;
    @JsonProperty("UnitLength")
    private String unitLength;
    @JsonProperty("UnitHeight")
    private String unitHeight;
    @JsonProperty("UnitWidth")
    private String unitWidth;
    @JsonProperty("UnitCount")
    private String unitCount;

    public String getQuoteLineNo() {
        return quoteLineNo;
    }

    public void setQuoteLineNo(String quoteLineNo) {
        this.quoteLineNo = quoteLineNo;
    }

    public String getDimLineNo() {
        return dimLineNo;
    }

    public void setDimLineNo(String dimLineNo) {
        this.dimLineNo = dimLineNo;
    }

    public String getDimUnits() {
        return dimUnits;
    }

    public void setDimUnits(String dimUnits) {
        this.dimUnits = dimUnits;
    }

    public String getUnitLength() {
        return unitLength;
    }

    public void setUnitLength(String unitLength) {
        this.unitLength = unitLength;
    }

    public String getUnitHeight() {
        return unitHeight;
    }

    public void setUnitHeight(String unitHeight) {
        this.unitHeight = unitHeight;
    }

    public String getUnitWidth() {
        return unitWidth;
    }

    public void setUnitWidth(String unitWidth) {
        this.unitWidth = unitWidth;
    }

    public String getUnitCount() {
        return unitCount;
    }

    public void setUnitCount(String unitCount) {
        this.unitCount = unitCount;
    }
}
