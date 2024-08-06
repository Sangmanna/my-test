package com.freightcom.clickship.model.marketplace.vendasta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class VendastaOrderForm {

    @JsonProperty("username")
    private String username;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("contact_phone_number")
    private String contactPhoneNumber;

    @JsonProperty("business_phone_number")
    private String businessPhoneNumber;

    @JsonProperty("salesperson_name")
    private String salespersonName;

    @JsonProperty("business_account_group_id")
    private String businessAccountGroupId;

    @JsonProperty("business_website")
    private String businessWebsite;

    @JsonProperty("business_address")
    private String businessAddress;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("contact_email")
    private String contactEmail;

    @JsonProperty("salesperson_phone_number")
    private String salespersonPhoneNumber;

    @JsonProperty("salesperson_email")
    private String salespersonEmail;

    @JsonProperty("business_name")
    private String businessName;

    @JsonProperty("contact_name")
    private String contactName;

    @JsonProperty("password")
    private String password;

    @JsonProperty("email")
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public String getBusinessPhoneNumber() {
        return businessPhoneNumber;
    }

    public void setBusinessPhoneNumber(String businessPhoneNumber) {
        this.businessPhoneNumber = businessPhoneNumber;
    }

    public String getSalespersonName() {
        return salespersonName;
    }

    public void setSalespersonName(String salespersonName) {
        this.salespersonName = salespersonName;
    }

    public String getBusinessAccountGroupId() {
        return businessAccountGroupId;
    }

    public void setBusinessAccountGroupId(String businessAccountGroupId) {
        this.businessAccountGroupId = businessAccountGroupId;
    }

    public String getBusinessWebsite() {
        return businessWebsite;
    }

    public void setBusinessWebsite(String businessWebsite) {
        this.businessWebsite = businessWebsite;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getSalespersonPhoneNumber() {
        return salespersonPhoneNumber;
    }

    public void setSalespersonPhoneNumber(String salespersonPhoneNumber) {
        this.salespersonPhoneNumber = salespersonPhoneNumber;
    }

    public String getSalespersonEmail() {
        return salespersonEmail;
    }

    public void setSalespersonEmail(String salespersonEmail) {
        this.salespersonEmail = salespersonEmail;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
