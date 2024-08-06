package com.freightcom.clickship.model.marketplace.ebay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExtendedContact {

    @JsonProperty("companyName")
    private String companyName;

    @JsonProperty("contactAddress")
    private Address contactAddress;

    @JsonProperty("email")
    private String email;

    @JsonProperty("fullName")
    private String fullName;

    @JsonProperty("primaryPhone")
    private PhoneNumber primaryPhone;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Address getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(Address contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public PhoneNumber getPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(PhoneNumber primaryPhone) {
        this.primaryPhone = primaryPhone;
    }
}
