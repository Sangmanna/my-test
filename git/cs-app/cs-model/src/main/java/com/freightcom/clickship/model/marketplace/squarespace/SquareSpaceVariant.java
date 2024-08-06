package com.freightcom.clickship.model.marketplace.squarespace;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SquareSpaceVariant {

    @JsonProperty("id")
    private String id;

    @JsonProperty("sku")
    private String sku;

    @JsonProperty("pricing")
    private Pricing pricing;

    @JsonProperty("stock")
    private ProductStock stock;

    @JsonProperty("attributes")
    private Map<String, String> attributes;

    @JsonProperty("shippingMeasurements")
    private ShippingDimensions shippingDimensions;

    @JsonProperty("image")
    private SquareSpaceImage image;

    public String getId() {
        return id;
    }

    public SquareSpaceVariant setId(String id) {
        this.id = id;
        return this;
    }

    public String getSku() {
        return sku;
    }

    public SquareSpaceVariant setSku(String sku) {
        this.sku = sku;
        return this;
    }

    public Pricing getPricing() {
        return pricing;
    }

    public SquareSpaceVariant setPricing(Pricing pricing) {
        this.pricing = pricing;
        return this;
    }

    public ProductStock getStock() {
        return stock;
    }

    public SquareSpaceVariant setStock(ProductStock stock) {
        this.stock = stock;
        return this;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public SquareSpaceVariant setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
        return this;
    }

    public ShippingDimensions getShippingDimensions() {
        return shippingDimensions;
    }

    public SquareSpaceVariant setShippingDimensions(ShippingDimensions shippingDimensions) {
        this.shippingDimensions = shippingDimensions;
        return this;
    }

    public SquareSpaceImage getImage() {
        return image;
    }

    public SquareSpaceVariant setImage(SquareSpaceImage image) {
        this.image = image;
        return this;
    }
}
