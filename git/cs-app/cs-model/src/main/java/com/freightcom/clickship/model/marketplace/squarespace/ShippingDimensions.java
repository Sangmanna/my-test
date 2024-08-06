package com.freightcom.clickship.model.marketplace.squarespace;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShippingDimensions {

    @JsonProperty("weight")
    private ShippingMeasurements weight;

    @JsonProperty("dimensions")
    private ShippingMeasurements dimensions;

    public ShippingMeasurements getWeight() {
        return weight;
    }

    public ShippingDimensions setWeight(ShippingMeasurements weight) {
        this.weight = weight;
        return this;
    }

    public ShippingMeasurements getDimensions() {
        return dimensions;
    }

    public ShippingDimensions setDimensions(ShippingMeasurements dimensions) {
        this.dimensions = dimensions;
        return this;
    }
}
