package com.freightcom.clickship.model.v2;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Information on the customs invoice broker.
 */

public class ShipmentCustomsInvoiceBroker {
	@JsonProperty("name")
	private String name = null;

	@JsonProperty("account_number")
	private String accountNumber = null;

	@JsonProperty("phone_number")
	private PhoneNumber phoneNumber = null;

	@JsonProperty("fax_number")
	private PhoneNumber faxNumber = null;

	@JsonProperty("email_address")
	private String emailAddress = null;

	@JsonProperty("usmca_number")
	private String usmcaNumber = null;

	@JsonProperty("fda_number")
	private String fdaNumber = null;

	public ShipmentCustomsInvoiceBroker name(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ShipmentCustomsInvoiceBroker accountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
		return this;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public ShipmentCustomsInvoiceBroker phoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public ShipmentCustomsInvoiceBroker faxNumber(PhoneNumber faxNumber) {
		this.faxNumber = faxNumber;
		return this;
	}

	public PhoneNumber getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(PhoneNumber faxNumber) {
		this.faxNumber = faxNumber;
	}

	public ShipmentCustomsInvoiceBroker emailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
		return this;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public ShipmentCustomsInvoiceBroker usmcaNumber(String usmcaNumber) {
		this.usmcaNumber = usmcaNumber;
		return this;
	}

	public String getUsmcaNumber() {
		return usmcaNumber;
	}

	public void setUsmcaNumber(String usmcaNumber) {
		this.usmcaNumber = usmcaNumber;
	}

	public ShipmentCustomsInvoiceBroker fdaNumber(String fdaNumber) {
		this.fdaNumber = fdaNumber;
		return this;
	}

	public String getFdaNumber() {
		return fdaNumber;
	}

	public void setFdaNumber(String fdaNumber) {
		this.fdaNumber = fdaNumber;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ShipmentCustomsInvoiceBroker shipmentCustomsInvoiceBroker = (ShipmentCustomsInvoiceBroker) o;
		return Objects.equals(this.name, shipmentCustomsInvoiceBroker.name)
				&& Objects.equals(this.accountNumber, shipmentCustomsInvoiceBroker.accountNumber)
				&& Objects.equals(this.phoneNumber, shipmentCustomsInvoiceBroker.phoneNumber)
				&& Objects.equals(this.faxNumber, shipmentCustomsInvoiceBroker.faxNumber)
				&& Objects.equals(this.emailAddress, shipmentCustomsInvoiceBroker.emailAddress)
				&& Objects.equals(this.usmcaNumber, shipmentCustomsInvoiceBroker.usmcaNumber)
				&& Objects.equals(this.fdaNumber, shipmentCustomsInvoiceBroker.fdaNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, accountNumber, phoneNumber, faxNumber, emailAddress, usmcaNumber, fdaNumber);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ShipmentCustomsInvoiceBroker {\n");

		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
		sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
		sb.append("    faxNumber: ").append(toIndentedString(faxNumber)).append("\n");
		sb.append("    emailAddress: ").append(toIndentedString(emailAddress)).append("\n");
		sb.append("    usmcaNumber: ").append(toIndentedString(usmcaNumber)).append("\n");
		sb.append("    fdaNumber: ").append(toIndentedString(fdaNumber)).append("\n");
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
}
