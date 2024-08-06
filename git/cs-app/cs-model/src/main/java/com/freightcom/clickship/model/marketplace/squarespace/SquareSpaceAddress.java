package com.freightcom.clickship.model.marketplace.squarespace;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SquareSpaceAddress {

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("address1")
    private String address1;

    @JsonProperty("address2")
    private String address2;

    @JsonProperty("city")
    private String city;

    @JsonProperty("state")
    private String state;

    @JsonProperty("countryCode")
    private String countryCode;

    @JsonProperty("postalCode")
    private String postalCode;

    @JsonProperty("phone")
    private String phone;

    public String getFirstName() {
        return firstName;
    }

    public SquareSpaceAddress setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public SquareSpaceAddress setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getAddress1() {
        return address1;
    }

    public SquareSpaceAddress setAddress1(String address1) {
        this.address1 = address1;
        return this;
    }

    public String getAddress2() {
        return address2;
    }

    public SquareSpaceAddress setAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public String getCity() {
        return city;
    }

    public SquareSpaceAddress setCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public SquareSpaceAddress setState(String state) {
        this.state = state;
        return this;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public SquareSpaceAddress setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public SquareSpaceAddress setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public SquareSpaceAddress setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
