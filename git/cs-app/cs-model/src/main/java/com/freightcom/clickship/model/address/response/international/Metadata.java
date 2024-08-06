
package com.freightcom.clickship.model.address.response.international;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.freightcom.clickship.model.CommonDTO;

import java.io.Serializable;

@JsonPropertyOrder({
    "latitude",
    "longitude",
    "geocode_precision",
    "max_geocode_precision",
    "address_format"
})
public class Metadata extends CommonDTO implements Serializable
{
    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("longitude")
    private Double longitude;
    @JsonProperty("geocode_precision")
    private String geocodePrecision;
    @JsonProperty("max_geocode_precision")
    private String maxGeocodePrecision;
    @JsonProperty("address_format")
    private String addressFormat;
    private final static long serialVersionUID = -9031377222398596462L;

    public Double getLatitude() {
        return latitude;
    }

    public Metadata setLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Metadata setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    public String getGeocodePrecision() {
        return geocodePrecision;
    }

    public Metadata setGeocodePrecision(String geocodePrecision) {
        this.geocodePrecision = geocodePrecision;
        return this;
    }

    public String getMaxGeocodePrecision() {
        return maxGeocodePrecision;
    }

    public Metadata setMaxGeocodePrecision(String maxGeocodePrecision) {
        this.maxGeocodePrecision = maxGeocodePrecision;
        return this;
    }
    
    public String getAddressFormat() {
        return addressFormat;
    }

    public Metadata setAddressFormat(String addressFormat) {
        this.addressFormat = addressFormat;
        return this;
    }

}
