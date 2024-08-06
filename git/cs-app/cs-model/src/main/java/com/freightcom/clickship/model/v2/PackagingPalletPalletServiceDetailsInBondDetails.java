package com.freightcom.clickship.model.v2;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class PackagingPalletPalletServiceDetailsInBondDetails {
	/**
	 * Gets or Sets type
	 */
	public enum TypeEnum {
		IMMEDIATE_EXPORTATION("immediate-exportation"),

		TRANSPORTATION_AND_EXPORTATION("transportation-and-exportation");

		private String value;

		TypeEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static TypeEnum fromValue(String text) {
			for (TypeEnum b : TypeEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("type")
	private TypeEnum type = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("address")
	private String address = null;

	/**
	 * Which contact method to utilize.
	 */
	public enum ContactMethodEnum {
		EMAIL_ADDRESS("email-address"),

		PHONE_NUMBER("phone-number"),

		FAX_NUMBER("fax-number");

		private String value;

		ContactMethodEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static ContactMethodEnum fromValue(String text) {
			for (ContactMethodEnum b : ContactMethodEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("contact_method")
	private ContactMethodEnum contactMethod = null;

	@JsonProperty("contact_email_address")
	private String contactEmailAddress = null;

	@JsonProperty("contact_phone_number")
	private PhoneNumber contactPhoneNumber = null;

	public PackagingPalletPalletServiceDetailsInBondDetails type(TypeEnum type) {
		this.type = type;
		return this;
	}

	public TypeEnum getType() {
		return type;
	}

	public void setType(TypeEnum type) {
		this.type = type;
	}

	public PackagingPalletPalletServiceDetailsInBondDetails name(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PackagingPalletPalletServiceDetailsInBondDetails address(String address) {
		this.address = address;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public PackagingPalletPalletServiceDetailsInBondDetails contactMethod(ContactMethodEnum contactMethod) {
		this.contactMethod = contactMethod;
		return this;
	}

	public ContactMethodEnum getContactMethod() {
		return contactMethod;
	}

	public void setContactMethod(ContactMethodEnum contactMethod) {
		this.contactMethod = contactMethod;
	}

	public PackagingPalletPalletServiceDetailsInBondDetails contactEmailAddress(String contactEmailAddress) {
		this.contactEmailAddress = contactEmailAddress;
		return this;
	}

	public String getContactEmailAddress() {
		return contactEmailAddress;
	}

	public void setContactEmailAddress(String contactEmailAddress) {
		this.contactEmailAddress = contactEmailAddress;
	}

	public PackagingPalletPalletServiceDetailsInBondDetails contactPhoneNumber(PhoneNumber contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
		return this;
	}

	public PhoneNumber getContactPhoneNumber() {
		return contactPhoneNumber;
	}

	public void setContactPhoneNumber(PhoneNumber contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PackagingPalletPalletServiceDetailsInBondDetails packagingPalletPalletServiceDetailsInBondDetails = (PackagingPalletPalletServiceDetailsInBondDetails) o;
		return Objects.equals(this.type, packagingPalletPalletServiceDetailsInBondDetails.type)
				&& Objects.equals(this.name, packagingPalletPalletServiceDetailsInBondDetails.name)
				&& Objects.equals(this.address, packagingPalletPalletServiceDetailsInBondDetails.address)
				&& Objects.equals(this.contactMethod, packagingPalletPalletServiceDetailsInBondDetails.contactMethod)
				&& Objects.equals(this.contactEmailAddress,
						packagingPalletPalletServiceDetailsInBondDetails.contactEmailAddress)
				&& Objects.equals(this.contactPhoneNumber,
						packagingPalletPalletServiceDetailsInBondDetails.contactPhoneNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, name, address, contactMethod, contactEmailAddress, contactPhoneNumber);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PackagingPalletPalletServiceDetailsInBondDetails {\n");

		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    address: ").append(toIndentedString(address)).append("\n");
		sb.append("    contactMethod: ").append(toIndentedString(contactMethod)).append("\n");
		sb.append("    contactEmailAddress: ").append(toIndentedString(contactEmailAddress)).append("\n");
		sb.append("    contactPhoneNumber: ").append(toIndentedString(contactPhoneNumber)).append("\n");
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
