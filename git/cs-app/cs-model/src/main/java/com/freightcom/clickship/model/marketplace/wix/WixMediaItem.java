package com.freightcom.clickship.model.marketplace.wix;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WixMediaItem {

    @JsonProperty("mediaType")
    private String mediaType;

    @JsonProperty("url")
    private String url;

    @JsonProperty("width")
    private Integer width;

    @JsonProperty("height")
    private Integer height;

    @JsonProperty("id")
    private String id;

    @JsonProperty("externalImageUrl")
    private String externalImageUrl;

    @JsonProperty("altText")
    private String altText;

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExternalImageUrl() {
        return externalImageUrl;
    }

    public void setExternalImageUrl(String externalImageUrl) {
        this.externalImageUrl = externalImageUrl;
    }

    public String getAltText() {
        return altText;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }
}
