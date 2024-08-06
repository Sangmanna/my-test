package com.freightcom.clickship.model.v2;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Courier pickup details, required if courier service utilized.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PickupDetails {
	@JsonProperty("date")
	private Date date = null;

	@JsonProperty("ready_at")
	private TimeOfDay readyAt = null;

	@JsonProperty("ready_until")
	private TimeOfDay readyUntil = null;

	@JsonProperty("pickup_location")
	private String pickupLocation = null;

	@JsonProperty("contact_name")
	private String contactName = null;

	@JsonProperty("contact_phone_number")
	private PhoneNumber contactPhoneNumber = null;

	public PickupDetails date(Date date) {
		this.date = date;
		return this;
	}

	/**
	 * Get date
	 * 
	 * @return date
	 **/
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public PickupDetails readyAt(TimeOfDay readyAt) {
		this.readyAt = readyAt;
		return this;
	}

	/**
	 * Get readyAt
	 * 
	 * @return readyAt
	 **/
	public TimeOfDay getReadyAt() {
		return readyAt;
	}

	public void setReadyAt(TimeOfDay readyAt) {
		this.readyAt = readyAt;
	}

	public PickupDetails readyUntil(TimeOfDay readyUntil) {
		this.readyUntil = readyUntil;
		return this;
	}

	/**
	 * Get readyUntil
	 * 
	 * @return readyUntil
	 **/
	public TimeOfDay getReadyUntil() {
		return readyUntil;
	}

	public void setReadyUntil(TimeOfDay readyUntil) {
		this.readyUntil = readyUntil;
	}

	public PickupDetails pickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
		return this;
	}

	/**
	 * Get pickupLocation
	 * 
	 * @return pickupLocation
	 **/

	public String getPickupLocation() {
		return pickupLocation;
	}

	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	public PickupDetails contactName(String contactName) {
		this.contactName = contactName;
		return this;
	}

	/**
	 * Get contactName
	 * 
	 * @return contactName
	 **/

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public PickupDetails contactPhoneNumber(PhoneNumber contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
		return this;
	}

	/**
	 * Get contactPhoneNumber
	 * 
	 * @return contactPhoneNumber
	 **/

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
		PickupDetails pickupDetails = (PickupDetails) o;
		return Objects.equals(this.date, pickupDetails.date) && Objects.equals(this.readyAt, pickupDetails.readyAt)
				&& Objects.equals(this.readyUntil, pickupDetails.readyUntil)
				&& Objects.equals(this.pickupLocation, pickupDetails.pickupLocation)
				&& Objects.equals(this.contactName, pickupDetails.contactName)
				&& Objects.equals(this.contactPhoneNumber, pickupDetails.contactPhoneNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, readyAt, readyUntil, pickupLocation, contactName, contactPhoneNumber);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PickupDetails {\n");

		sb.append("    date: ").append(toIndentedString(date)).append("\n");
		sb.append("    readyAt: ").append(toIndentedString(readyAt)).append("\n");
		sb.append("    readyUntil: ").append(toIndentedString(readyUntil)).append("\n");
		sb.append("    pickupLocation: ").append(toIndentedString(pickupLocation)).append("\n");
		sb.append("    contactName: ").append(toIndentedString(contactName)).append("\n");
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
