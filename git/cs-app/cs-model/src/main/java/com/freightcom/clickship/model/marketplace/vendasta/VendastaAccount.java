package com.freightcom.clickship.model.marketplace.vendasta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class VendastaAccount {

    @JsonProperty("contact_first_name")
    private String contactFirstName;

    @JsonProperty("work_number")
    private List<String> workNumber;

    @JsonProperty("partner_id")
    private String partnerId;

    @JsonProperty("id")
    private String accountId;

    @JsonProperty("city")
    private String city;

    @JsonProperty("zip")
    private String zip;

    @JsonProperty("market_id")
    private String marketId;

    @JsonProperty("state")
    private String state;

    @JsonProperty("company_name")
    private String companyName;

    @JsonProperty("website")
    private String website;

    @JsonProperty("updated")
    private String updated;

    @JsonProperty("address2")
    private String address2;

    @JsonProperty("fax_number")
    private String fax_number;

    @JsonProperty("contact_email")
    private String contactEmail;

    @JsonProperty("address")
    private String address;

    @JsonProperty("contact_last_name")
    private String contactLastName;

    @JsonProperty("cell_number")
    private String cellNumber;

    @JsonProperty("created")
    private String created;

    @JsonProperty("sales_person_id")
    private String salesPersonId;

    @JsonProperty("country")
    private String country;

    public String getContactFirstName() {
        return contactFirstName;
    }

    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    public List<String> getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(List<String> workNumber) {
        this.workNumber = workNumber;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getFax_number() {
        return fax_number;
    }

    public void setFax_number(String fax_number) {
        this.fax_number = fax_number;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getSalesPersonId() {
        return salesPersonId;
    }

    public void setSalesPersonId(String salesPersonId) {
        this.salesPersonId = salesPersonId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
