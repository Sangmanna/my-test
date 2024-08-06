package com.freightcom.clickship.model.address;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.StringUtils;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressValidationDTO {

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonAlias({ "shipfromAddress1", "shiptoAddress1", "address_line1" })
    private String address1;

    @JsonAlias({ "shipfromAddress2", "shiptoAddress2", "address_line2" })
    private String address2;

    @JsonAlias({ "shipfromZip", "shiptoZip", "postal_code" })
    private String postalCode;

    @JsonAlias({ "shipfromCity", "shiptoCity", "city" })
    private String city;

    @JsonAlias({ "shipfromProvinceState", "shiptoProvinceState", "region" })
    private String provinceState;

    @JsonAlias({"shipfromCountry", "shiptoCountry", "country" })
    private String country;

    @JsonAlias("id")
    private String orderId;

    @JsonAlias("marketplaceId")
    private String marketplaceId;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvinceState() {
        return provinceState;
    }

    public void setProvinceState(String provinceState) {
        this.provinceState = provinceState;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getMarketplaceId() {
        return marketplaceId;
    }

    public void setMarketplaceId(String marketplaceId) {
        this.marketplaceId = marketplaceId;
    }

    public String getContactName() {
        String name = null;

        if(StringUtils.isNotBlank(firstName)){
            name = firstName;
        }

        if(StringUtils.isNotBlank(lastName)){
            name = name == null ? lastName : name+ " " + lastName;
        }

        return name;
    }
}
