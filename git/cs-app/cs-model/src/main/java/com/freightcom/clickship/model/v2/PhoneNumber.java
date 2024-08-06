package com.freightcom.clickship.model.v2;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Phone number without any special characters.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PhoneNumber {
	public PhoneNumber() {

	}
	
	public PhoneNumber(String number, String ext) {
		this.number = number;
		this.extension = ext;
	}
	
	@JsonProperty("number")
	private String number = null;

	@JsonProperty("extension")
	private String extension = null;

	public PhoneNumber number(String number) {
		this.number = number;
		return this;
	}

	/**
	 * Get number
	 * 
	 * @return number
	 **/

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public PhoneNumber extension(String extension) {
		this.extension = extension;
		return this;
	}

	/**
	 * Get extension
	 * 
	 * @return extension
	 **/

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PhoneNumber phoneNumber = (PhoneNumber) o;
		return Objects.equals(this.number, phoneNumber.number) && Objects.equals(this.extension, phoneNumber.extension);
	}

	@Override
	public int hashCode() {
		return Objects.hash(number, extension);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PhoneNumber {\n");

		sb.append("    number: ").append(toIndentedString(number)).append("\n");
		sb.append("    extension: ").append(toIndentedString(extension)).append("\n");
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
