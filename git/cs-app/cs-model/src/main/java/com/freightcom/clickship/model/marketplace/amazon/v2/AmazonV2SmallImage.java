package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AmazonV2SmallImage {

    @JsonProperty("URL")
    private String url;

    @JsonProperty("Height")
    private DecimalWithUnits height;

    @JsonProperty("Width")
    private DecimalWithUnits width;

    public String getUrl() {
        return url;
    }

    public AmazonV2SmallImage setUrl(String url) {
        this.url = url;
        return this;
    }

    public DecimalWithUnits getHeight() {
        return height;
    }

    public AmazonV2SmallImage setHeight(DecimalWithUnits height) {
        this.height = height;
        return this;
    }

    public DecimalWithUnits getWidth() {
        return width;
    }

    public AmazonV2SmallImage setWidth(DecimalWithUnits width) {
        this.width = width;
        return this;
    }
}
