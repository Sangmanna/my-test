package com.freightcom.clickship.model.marketplace.squarespace;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShippingMeasurements {

    @JsonProperty("unit")
    private String unit;

    @JsonProperty("value")
    private double value;

    @JsonProperty("length")
    private double length;

    @JsonProperty("width")
    private double width;

    @JsonProperty("height")
    private double height;

    public String getUnit() {
        return unit;
    }

    public ShippingMeasurements setUnit(String unit) {
        this.unit = unit;
        return this;
    }

    public double getValue() {
        return value;
    }

    public ShippingMeasurements setValue(double value) {
        this.value = value;
        return this;
    }

    public double getLength() {
        return length;
    }

    public ShippingMeasurements setLength(double length) {
        this.length = length;
        return this;
    }

    public double getWidth() {
        return width;
    }

    public ShippingMeasurements setWidth(double width) {
        this.width = width;
        return this;
    }

    public double getHeight() {
        return height;
    }

    public ShippingMeasurements setHeight(double height) {
        this.height = height;
        return this;
    }
}
