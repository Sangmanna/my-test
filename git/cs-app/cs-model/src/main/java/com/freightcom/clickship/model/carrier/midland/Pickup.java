package com.freightcom.clickship.model.carrier.midland;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value= JsonInclude.Include.NON_EMPTY, content= JsonInclude.Include.NON_NULL)
public class Pickup {
    @JsonProperty("pronumber")
    private String proNumber;
    private String pickupDate;
    private String readyTime;
    private String closeTime;
    private String contactName;
    private String contactPhone;
    private String specialRequirement;
    private String notes;
    @JsonProperty("thirdpartyName")
    private String thirdPartyName;
    @JsonProperty("thirdpartyPhone")
    private String thirdPartyPhone;
    @JsonProperty("thirdpartyContact")
    private String thirdPartyContact;
    @JsonProperty("thirdpartyEmail")
    private String thirdPartyEmail;
    private String confirmationEmail;

    public String getProNumber() {
        return proNumber;
    }

    public void setProNumber(String proNumber) {
        this.proNumber = proNumber;
    }

    public String getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(String pickupDate) {
        this.pickupDate = pickupDate;
    }

    public String getReadyTime() {
        return readyTime;
    }

    public void setReadyTime(String readyTime) {
        this.readyTime = readyTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getSpecialRequirement() {
        return specialRequirement;
    }

    public void setSpecialRequirement(String specialRequirement) {
        this.specialRequirement = specialRequirement;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getThirdPartyName() {
        return thirdPartyName;
    }

    public void setThirdPartyName(String thirdPartyName) {
        this.thirdPartyName = thirdPartyName;
    }

    public String getThirdPartyPhone() {
        return thirdPartyPhone;
    }

    public void setThirdPartyPhone(String thirdPartyPhone) {
        this.thirdPartyPhone = thirdPartyPhone;
    }

    public String getThirdPartyContact() {
        return thirdPartyContact;
    }

    public void setThirdPartyContact(String thirdPartyContact) {
        this.thirdPartyContact = thirdPartyContact;
    }

    public String getThirdPartyEmail() {
        return thirdPartyEmail;
    }

    public void setThirdPartyEmail(String thirdPartyEmail) {
        this.thirdPartyEmail = thirdPartyEmail;
    }

    public String getConfirmationEmail() {
        return confirmationEmail;
    }

    public void setConfirmationEmail(String confirmationEmail) {
        this.confirmationEmail = confirmationEmail;
    }
}
