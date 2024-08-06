package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DecimalWithUnits {

    @JsonProperty("value")
    private Double value;

    @JsonProperty("Units")
    private String units;

    public Double getValue() {
        return value;
    }

    public DecimalWithUnits setValue(Double value) {
        this.value = value;
        return this;
    }

    public String getUnits() {
        return units;
    }

    public DecimalWithUnits setUnits(String units) {
        this.units = units;
        return this;
    }
}
