package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AmazonV2ShippingAddress {

    @JsonProperty("Name")
    private String name;

    @JsonProperty("AddressLine1")
    private String addressLine1;

    @JsonProperty("AddressLine2")
    private String addressLine2;

    @JsonProperty("AddressLine3")
    private String addressLine3;

    @JsonProperty("City")
    private String city;

    @JsonProperty("County")
    private String county;

    @JsonProperty("District")
    private String district;

    @JsonProperty("StateOrRegion")
    private String stateOrRegion;

    @JsonProperty("Municipality")
    private String municipality;

    @JsonProperty("PostalCode")
    private String postalCode;

    @JsonProperty("CountryCode")
    private String countryCode;

    @JsonProperty("Phone")
    private String phone;

    @JsonProperty("AddressType")
    private String addressType;

    public String getName() {
        return name;
    }

    public AmazonV2ShippingAddress setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public AmazonV2ShippingAddress setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
        return this;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public AmazonV2ShippingAddress setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
        return this;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public AmazonV2ShippingAddress setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
        return this;
    }

    public String getCity() {
        return city;
    }

    public AmazonV2ShippingAddress setCity(String city) {
        this.city = city;
        return this;
    }

    public String getCounty() {
        return county;
    }

    public AmazonV2ShippingAddress setCounty(String county) {
        this.county = county;
        return this;
    }

    public String getDistrict() {
        return district;
    }

    public AmazonV2ShippingAddress setDistrict(String district) {
        this.district = district;
        return this;
    }

    public String getStateOrRegion() {
        return stateOrRegion;
    }

    public AmazonV2ShippingAddress setStateOrRegion(String stateOrRegion) {
        this.stateOrRegion = stateOrRegion;
        return this;
    }

    public String getMunicipality() {
        return municipality;
    }

    public AmazonV2ShippingAddress setMunicipality(String municipality) {
        this.municipality = municipality;
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public AmazonV2ShippingAddress setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public AmazonV2ShippingAddress setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public AmazonV2ShippingAddress setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getAddressType() {
        return addressType;
    }

    public AmazonV2ShippingAddress setAddressType(String addressType) {
        this.addressType = addressType;
        return this;
    }
}
