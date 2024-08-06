package com.freightcom.clickship.model.v2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Establishment {
	@JsonProperty("name")
	private String name = null;

	@JsonProperty("address")
	private Address address = null;

	@JsonProperty("residential")
	private Boolean residential = false;

	@JsonProperty("tailgate_required")
	private Boolean tailgateRequired = false;

	@JsonProperty("instructions")
	private String instructions = null;

	@JsonProperty("contact_name")
	private String contactName = null;
	
	@JsonProperty("business_type")
	private String businessType = null;
	
	@JsonProperty("receives_email_updates")
	private Boolean receives_email_updates = false;
	
	@JsonProperty("address_book_contact_id")
	private String addressBookContactId = null;

	@JsonProperty("phone_number")
	private PhoneNumber phoneNumber = null;
	
	@JsonProperty("email_addresses")
	private List<String> emailAddresses;

	public Establishment name(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Establishment address(Address address) {
		this.address = address;
		return this;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Establishment residential(Boolean residential) {
		this.residential = residential;
		return this;
	}

	public Boolean isResidential() {
		return residential;
	}

	public void setResidential(Boolean residential) {
		this.residential = residential;
	}

	public Establishment tailgateRequired(Boolean tailgateRequired) {
		this.tailgateRequired = tailgateRequired;
		return this;
	}

	public Boolean isTailgateRequired() {
		return tailgateRequired;
	}

	public void setTailgateRequired(Boolean tailgateRequired) {
		this.tailgateRequired = tailgateRequired;
	}

	public Establishment instructions(String instructions) {
		this.instructions = instructions;
		return this;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public Establishment contactName(String contactName) {
		this.contactName = contactName;
		return this;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public Establishment phoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Establishment establishment = (Establishment) o;
		return Objects.equals(this.name, establishment.name) && Objects.equals(this.address, establishment.address)
				&& Objects.equals(this.residential, establishment.residential)
				&& Objects.equals(this.tailgateRequired, establishment.tailgateRequired)
				&& Objects.equals(this.instructions, establishment.instructions)
				&& Objects.equals(this.contactName, establishment.contactName)
				&& Objects.equals(this.phoneNumber, establishment.phoneNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, address, residential, tailgateRequired, instructions, contactName, phoneNumber);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Establishment {\n");

		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    address: ").append(toIndentedString(address)).append("\n");
		sb.append("    residential: ").append(toIndentedString(residential)).append("\n");
		sb.append("    tailgateRequired: ").append(toIndentedString(tailgateRequired)).append("\n");
		sb.append("    instructions: ").append(toIndentedString(instructions)).append("\n");
		sb.append("    contactName: ").append(toIndentedString(contactName)).append("\n");
		sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public Boolean getReceives_email_updates() {
		return receives_email_updates;
	}

	public void setReceives_email_updates(Boolean receives_email_updates) {
		this.receives_email_updates = receives_email_updates;
	}

	public String getAddressBookContactId() {
		return addressBookContactId;
	}

	public void setAddressBookContactId(String addressBookContactId) {
		this.addressBookContactId = addressBookContactId;
	}

	public List<String> getEmailAddresses() {
		return emailAddresses;
	}

	public void setEmailAddresses(List<String> emailAddresses) {
		this.emailAddresses = emailAddresses;
	}
	
	public void setEmailAddress(String emailAddress) {
		if (this.emailAddresses == null) {
			this.emailAddresses = new ArrayList<>();
		}
		this.emailAddresses.add(emailAddress);
	}

	public Boolean getResidential() {
		return residential;
	}

	public Boolean getTailgateRequired() {
		return tailgateRequired;
	}
}
