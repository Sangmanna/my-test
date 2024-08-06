package com.freightcom.clickship.model.marketplace.squarespace;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SquareSpaceProduct {

    @JsonProperty("id")
    private String id;

    @JsonProperty("type")
    private String type;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("url")
    private String url;

    @JsonProperty("isVisible")
    private boolean isVisible;

    @JsonProperty("variantAttributes")
    private List<String> variantAttributes;

    @JsonProperty("variants")
    private List<SquareSpaceVariant> variants;

    @JsonProperty("images")
    private List<SquareSpaceImage> images;

    public String getId() {
        return id;
    }

    public SquareSpaceProduct setId(String id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public SquareSpaceProduct setType(String type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public SquareSpaceProduct setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SquareSpaceProduct setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public SquareSpaceProduct setUrl(String url) {
        this.url = url;
        return this;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public SquareSpaceProduct setVisible(boolean visible) {
        isVisible = visible;
        return this;
    }

    public List<String> getVariantAttributes() {
        return variantAttributes;
    }

    public SquareSpaceProduct setVariantAttributes(List<String> variantAttributes) {
        this.variantAttributes = variantAttributes;
        return this;
    }

    public List<SquareSpaceVariant> getVariants() {
        return variants;
    }

    public SquareSpaceProduct setVariants(List<SquareSpaceVariant> variants) {
        this.variants = variants;
        return this;
    }

    public List<SquareSpaceImage> getImages() {
        return images;
    }

    public SquareSpaceProduct setImages(List<SquareSpaceImage> images) {
        this.images = images;
        return this;
    }
}
