package com.freightcom.clickship.model.marketplace.squarespace;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SquareSpaceLineItem {

    @JsonProperty("id")
    private String id;

    @JsonProperty("variantId")
    private String variantId;

    @JsonProperty("sku")
    private String sku;

    @JsonProperty("weight")
    private double weight;

    @JsonProperty("width")
    private double width;

    @JsonProperty("length")
    private double length;

    @JsonProperty("height")
    private double height;

    @JsonProperty("productId")
    private String productId;

    @JsonProperty("productName")
    private String productName;

    @JsonProperty("quantity")
    private double quantity;

    @JsonProperty("unitPricePaid")
    private SquareSpacePrice unitPricePaid;

    @JsonProperty("variantOptions")
    private List<SquareSpaceVariantOptions> variantOptions;

    public String getId() {
        return id;
    }

    public SquareSpaceLineItem setId(String id) {
        this.id = id;
        return this;
    }

    public String getVariantId() {
        return variantId;
    }

    public SquareSpaceLineItem setVariantId(String variantId) {
        this.variantId = variantId;
        return this;
    }

    public String getSku() {
        return sku;
    }

    public SquareSpaceLineItem setSku(String sku) {
        this.sku = sku;
        return this;
    }

    public double getWeight() {
        return weight;
    }

    public SquareSpaceLineItem setWeight(double weight) {
        this.weight = weight;
        return this;
    }

    public double getWidth() {
        return width;
    }

    public SquareSpaceLineItem setWidth(double width) {
        this.width = width;
        return this;
    }

    public double getLength() {
        return length;
    }

    public SquareSpaceLineItem setLength(double length) {
        this.length = length;
        return this;
    }

    public double getHeight() {
        return height;
    }

    public SquareSpaceLineItem setHeight(double height) {
        this.height = height;
        return this;
    }

    public String getProductId() {
        return productId;
    }

    public SquareSpaceLineItem setProductId(String productId) {
        this.productId = productId;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public SquareSpaceLineItem setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public double getQuantity() {
        return quantity;
    }

    public SquareSpaceLineItem setQuantity(double quantity) {
        this.quantity = quantity;
        return this;
    }

    public SquareSpacePrice getUnitPricePaid() {
        return unitPricePaid;
    }

    public SquareSpaceLineItem setUnitPricePaid(SquareSpacePrice unitPricePaid) {
        this.unitPricePaid = unitPricePaid;
        return this;
    }

    public List<SquareSpaceVariantOptions> getVariantOptions() {
        return variantOptions;
    }

    public SquareSpaceLineItem setVariantOptions(List<SquareSpaceVariantOptions> variantOptions) {
        this.variantOptions = variantOptions;
        return this;
    }
}
