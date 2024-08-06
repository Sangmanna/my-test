package com.freightcom.clickship.model.marketplace.etsy;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListingImage implements Serializable {

	private static final long serialVersionUID = 8999834205959945624L;

	@JsonProperty("listing_image_id")
    private Long listingImageId;

    @JsonProperty("hex_code")
    private String hexCode;

    @JsonProperty("red")
    private Integer red;

    @JsonProperty("green")
    private Integer green;

    @JsonProperty("blue")
    private Integer blue;

    @JsonProperty("hue")
    private Integer hue;

    @JsonProperty("saturation")
    private Integer saturation;

    @JsonProperty("brightness")
    private Integer brightness;

    @JsonProperty("is_black_and_white")
    private Boolean isBlackAndWhite;

    @JsonProperty("creation_tsz")
    private Float creationTsz;

    @JsonProperty("listing_id")
    private Integer listingId;

    @JsonProperty("rank")
    private Integer rank;

    @JsonProperty("url_75x75")
    private String url75x75;

    @JsonProperty("url_170x135")
    private String url170x135;

    @JsonProperty("url_570xN")
    private String url570xN;

    @JsonProperty("url_fullxfull")
    private String urlFullxfull;

    @JsonProperty("full_height")
    private Integer fullHeight;

    @JsonProperty("full_width")
    private Integer fullWidth;

    public Long getListingImageId() {
        return listingImageId;
    }

    public void setListingImageId(Long listingImageId) {
        this.listingImageId = listingImageId;
    }

    public String getHexCode() {
        return hexCode;
    }

    public void setHexCode(String hexCode) {
        this.hexCode = hexCode;
    }

    public Integer getRed() {
        return red;
    }

    public void setRed(Integer red) {
        this.red = red;
    }

    public Integer getGreen() {
        return green;
    }

    public void setGreen(Integer green) {
        this.green = green;
    }

    public Integer getBlue() {
        return blue;
    }

    public void setBlue(Integer blue) {
        this.blue = blue;
    }

    public Integer getHue() {
        return hue;
    }

    public void setHue(Integer hue) {
        this.hue = hue;
    }

    public Integer getSaturation() {
        return saturation;
    }

    public void setSaturation(Integer saturation) {
        this.saturation = saturation;
    }

    public Integer getBrightness() {
        return brightness;
    }

    public void setBrightness(Integer brightness) {
        this.brightness = brightness;
    }

    public Boolean getBlackAndWhite() {
        return isBlackAndWhite;
    }

    public void setBlackAndWhite(Boolean blackAndWhite) {
        isBlackAndWhite = blackAndWhite;
    }

    public Float getCreationTsz() {
        return creationTsz;
    }

    public void setCreationTsz(Float creationTsz) {
        this.creationTsz = creationTsz;
    }

    public Integer getListingId() {
        return listingId;
    }

    public void setListingId(Integer listingId) {
        this.listingId = listingId;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getUrl75x75() {
        return url75x75;
    }

    public void setUrl75x75(String url75x75) {
        this.url75x75 = url75x75;
    }

    public String getUrl170x135() {
        return url170x135;
    }

    public void setUrl170x135(String url170x135) {
        this.url170x135 = url170x135;
    }

    public String getUrl570xN() {
        return url570xN;
    }

    public void setUrl570xN(String url570xN) {
        this.url570xN = url570xN;
    }

    public String getUrlFullxfull() {
        return urlFullxfull;
    }

    public void setUrlFullxfull(String urlFullxfull) {
        this.urlFullxfull = urlFullxfull;
    }

    public Integer getFullHeight() {
        return fullHeight;
    }

    public void setFullHeight(Integer fullHeight) {
        this.fullHeight = fullHeight;
    }

    public Integer getFullWidth() {
        return fullWidth;
    }

    public void setFullWidth(Integer fullWidth) {
        this.fullWidth = fullWidth;
    }
}
