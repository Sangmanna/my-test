package com.freightcom.clickship.model.carrier.midland;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value= JsonInclude.Include.NON_EMPTY, content= JsonInclude.Include.NON_NULL)
public class CancelRequestStatus {
    @JsonProperty("Pronumber")
    private String proNumber;
    @JsonProperty("Trn")
    private String trn;
    @JsonProperty("Status")
    private String status;

    public String getProNumber() {
        return proNumber;
    }

    public void setProNumber(String proNumber) {
        this.proNumber = proNumber;
    }

    public String getTrn() {
        return trn;
    }

    public void setTrn(String trn) {
        this.trn = trn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
