package com.freightcom.clickship.model.carrier.midland;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value= JsonInclude.Include.NON_EMPTY, content= JsonInclude.Include.NON_NULL)
public class ProReference {
    @JsonProperty("RefNumTypeCode")
    private String refNumTypeCode;
    @JsonProperty("ReferenceNumber")
    private String referenceNumber;

    public String getRefNumTypeCode() {
        return refNumTypeCode;
    }

    public void setRefNumTypeCode(String refNumTypeCode) {
        this.refNumTypeCode = refNumTypeCode;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }
}
