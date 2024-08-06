
package com.freightcom.clickship.model.address.response.usa;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.freightcom.clickship.model.CommonDTO;

import java.io.Serializable;

@JsonPropertyOrder({
    "record_type",
    "zip_type",
    "county_fips",
    "county_name",
    "ews_match",
    "carrier_route",
    "congressional_district",
    "building_default_indicator",
    "rdi",
    "elot_sequence",
    "elot_sort",
    "latitude",
    "longitude",
    "precision",
    "time_zone",
    "utc_offset",
    "dst"
})
public class Metadata  extends CommonDTO implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -3242934914811523319L;
	@JsonProperty("record_type")
    private String recordType;
    @JsonProperty("zip_type")
    private String zipType;
    @JsonProperty("county_fips")
    private String countyFips;
    @JsonProperty("county_name")
    private String countyName;
    @JsonProperty("ews_match")
    private String ewsMatch;
    @JsonProperty("carrier_route")
    private String carrierRoute;
    @JsonProperty("congressional_district")
    private String congressionalDistrict;
    @JsonProperty("building_default_indicator")
    private String buildingDefaultIndicator;
    @JsonProperty("rdi")
    private String rdi;
    @JsonProperty("elot_sequence")
    private String elotSequence;
    @JsonProperty("elot_sort")
    private String elotSort;
    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("longitude")
    private Double longitude;
    @JsonProperty("precision")
    private String precision;
    @JsonProperty("time_zone")
    private String timeZone;
    @JsonProperty("utc_offset")
    private Integer utcOffset;
    @JsonProperty("dst")
    private Boolean dst;

    public String getRecordType() {
        return recordType;
    }

    public Metadata setRecordType(String recordType) {
        this.recordType = recordType;
        return this;
    }

    public String getZipType() {
        return zipType;
    }

    public Metadata setZipType(String zipType) {
        this.zipType = zipType;
        return this;
    }

    public String getCountyFips() {
        return countyFips;
    }

    public Metadata setCountyFips(String countyFips) {
        this.countyFips = countyFips;
        return this;
    }

    public String getCountyName() {
        return countyName;
    }

    public Metadata setCountyName(String countyName) {
        this.countyName = countyName;
        return this;
    }

    public String getCarrierRoute() {
        return carrierRoute;
    }

    public Metadata setCarrierRoute(String carrierRoute) {
        this.carrierRoute = carrierRoute;
        return this;
    }

    public String getCongressionalDistrict() {
        return congressionalDistrict;
    }

    public Metadata setCongressionalDistrict(String congressionalDistrict) {
        this.congressionalDistrict = congressionalDistrict;
        return this;
    }

    public String getRdi() {
        return rdi;
    }

    public Metadata setRdi(String rdi) {
        this.rdi = rdi;
        return this;
    }

    public String getElotSequence() {
        return elotSequence;
    }

    public Metadata setElotSequence(String elotSequence) {
        this.elotSequence = elotSequence;
        return this;
    }

    public String getElotSort() {
        return elotSort;
    }

    public Metadata setElotSort(String elotSort) {
        this.elotSort = elotSort;
        return this;
    }

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

    public String getPrecision() {
        return precision;
    }

    public Metadata setPrecision(String precision) {
        this.precision = precision;
        return this;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public Metadata setTimeZone(String timeZone) {
        this.timeZone = timeZone;
        return this;
    }

    public Integer getUtcOffset() {
        return utcOffset;
    }

    public Metadata setUtcOffset(Integer utcOffset) {
        this.utcOffset = utcOffset;
        return this;
    }

    public Boolean getDst() {
        return dst;
    }

    public Metadata setDst(Boolean dst) {
        this.dst = dst;
        return this;
    }

}
