package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttributeSetList {

    @JsonProperty("Brand")
    private String brand;

    @JsonProperty("Color")
    private String color;

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Manufacturer")
    private String manufacturer;

    @JsonProperty("PackageDimensions")
    private AmazonV2PackageDimensions packageDimensions;

    @JsonProperty("ItemDimensions")
    private AmazonV2PackageDimensions itemDimensions;

    @JsonProperty("PackageQuantity")
    private String packageQuantity;

    @JsonProperty("ProductTypeName")
    private String productTypeName;

    @JsonProperty("SmallImage")
    private AmazonV2SmallImage smallImage;

    public String getBrand() {
        return brand;
    }

    public AttributeSetList setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getColor() {
        return color;
    }

    public AttributeSetList setColor(String color) {
        this.color = color;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public AttributeSetList setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public AttributeSetList setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public AmazonV2PackageDimensions getPackageDimensions() {
        return packageDimensions;
    }

    public AttributeSetList setPackageDimensions(AmazonV2PackageDimensions packageDimensions) {
        this.packageDimensions = packageDimensions;
        return this;
    }

    public AmazonV2PackageDimensions getItemDimensions() {
        return itemDimensions;
    }

    public AttributeSetList setItemDimensions(AmazonV2PackageDimensions itemDimensions) {
        this.itemDimensions = itemDimensions;
        return this;
    }

    public String getPackageQuantity() {
        return packageQuantity;
    }

    public AttributeSetList setPackageQuantity(String packageQuantity) {
        this.packageQuantity = packageQuantity;
        return this;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public AttributeSetList setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
        return this;
    }

    public AmazonV2SmallImage getSmallImage() {
        return smallImage;
    }

    public AttributeSetList setSmallImage(AmazonV2SmallImage smallImage) {
        this.smallImage = smallImage;
        return this;
    }
}
