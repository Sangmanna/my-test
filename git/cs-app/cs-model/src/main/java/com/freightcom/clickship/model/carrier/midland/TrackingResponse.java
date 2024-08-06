package com.freightcom.clickship.model.carrier.midland;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(value= JsonInclude.Include.NON_EMPTY, content= JsonInclude.Include.NON_NULL)
public class TrackingResponse {

    @JsonProperty("Probill")
    private List<MidlandProbill> midlandProbills;

    public List<MidlandProbill> getMidlandProbills() {
        return midlandProbills;
    }

    public void setMidlandProbills(List<MidlandProbill> midlandProbills) {
        this.midlandProbills = midlandProbills;
    }
}
