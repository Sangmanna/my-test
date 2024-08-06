package com.freightcom.clickship.model.v2;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Contact {
  private String name;

  @JsonProperty("phone_number")
  private PhoneNumber phoneNumber = new PhoneNumber();

  @JsonProperty("email_address")
  private String emailAddress;

  @JsonProperty("receives_email_updates")
  private boolean receivesEmailUpdates;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PhoneNumber getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(PhoneNumber phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public boolean isReceivesEmailUpdates() {
    return receivesEmailUpdates;
  }

  public void setReceivesEmailUpdates(boolean receivesEmailUpdates) {
    this.receivesEmailUpdates = receivesEmailUpdates;
  }

}
