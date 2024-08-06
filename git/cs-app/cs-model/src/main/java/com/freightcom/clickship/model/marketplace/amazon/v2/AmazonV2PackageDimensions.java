package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AmazonV2PackageDimensions {

    @JsonProperty("Height")
    private DecimalWithUnits height;

    @JsonProperty("Length")
    private DecimalWithUnits length;

    @JsonProperty("Width")
    private DecimalWithUnits width;

    @JsonProperty("Weight")
    private DecimalWithUnits weight;

    public DecimalWithUnits getHeight() {
        return height;
    }

    public AmazonV2PackageDimensions setHeight(DecimalWithUnits height) {
        this.height = height;
        return this;
    }

    public DecimalWithUnits getLength() {
        return length;
    }

    public AmazonV2PackageDimensions setLength(DecimalWithUnits length) {
        this.length = length;
        return this;
    }

    public DecimalWithUnits getWidth() {
        return width;
    }

    public AmazonV2PackageDimensions setWidth(DecimalWithUnits width) {
        this.width = width;
        return this;
    }

    public DecimalWithUnits getWeight() {
        return weight;
    }

    public AmazonV2PackageDimensions setWeight(DecimalWithUnits weight) {
        this.weight = weight;
        return this;
    }
}
