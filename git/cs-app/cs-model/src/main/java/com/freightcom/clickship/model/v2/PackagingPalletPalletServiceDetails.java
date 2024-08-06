package com.freightcom.clickship.model.v2;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class PackagingPalletPalletServiceDetails {
	/**
	 * If limited access delivery the type of delivery.
	 */
	public enum LimitedAccessDeliveryTypeEnum {
		CONSTRUCTION_SITE("construction-site"),

		FAIR("fair"),

		FARM("farm"),

		MALL("mall"),

		MINI_STORAGE_UNIT("mini-storage-unit"),

		PLACE_OF_WORSHIP("place-of-worship"),

		SCHOOL("school"),

		SECURED_LOCATION("secured-location"),

		OTHER("other");

		private String value;

		LimitedAccessDeliveryTypeEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static LimitedAccessDeliveryTypeEnum fromValue(String text) {
			for (LimitedAccessDeliveryTypeEnum b : LimitedAccessDeliveryTypeEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("limited_access_delivery_type")
	private LimitedAccessDeliveryTypeEnum limitedAccessDeliveryType = null;

	@JsonProperty("limited_access_delivery_other_name")
	private String limitedAccessDeliveryOtherName = null;

	@JsonProperty("in_bond")
	private Boolean inBond = null;

	@JsonProperty("in_bond_details")
	private PackagingPalletPalletServiceDetailsInBondDetails inBondDetails = null;

	@JsonProperty("appointment_delivery")
	private Boolean appointmentDelivery = null;

	@JsonProperty("protect_from_freeze")
	private Boolean protectFromFreeze = null;

	@JsonProperty("threshold_pickup")
	private Boolean thresholdPickup = null;

	@JsonProperty("threshold_delivery")
	private Boolean thresholdDelivery = null;

	public PackagingPalletPalletServiceDetails limitedAccessDeliveryType(
			LimitedAccessDeliveryTypeEnum limitedAccessDeliveryType) {
		this.limitedAccessDeliveryType = limitedAccessDeliveryType;
		return this;
	}

	public LimitedAccessDeliveryTypeEnum getLimitedAccessDeliveryType() {
		return limitedAccessDeliveryType;
	}

	public void setLimitedAccessDeliveryType(LimitedAccessDeliveryTypeEnum limitedAccessDeliveryType) {
		this.limitedAccessDeliveryType = limitedAccessDeliveryType;
	}

	public PackagingPalletPalletServiceDetails limitedAccessDeliveryOtherName(String limitedAccessDeliveryOtherName) {
		this.limitedAccessDeliveryOtherName = limitedAccessDeliveryOtherName;
		return this;
	}

	public String getLimitedAccessDeliveryOtherName() {
		return limitedAccessDeliveryOtherName;
	}

	public void setLimitedAccessDeliveryOtherName(String limitedAccessDeliveryOtherName) {
		this.limitedAccessDeliveryOtherName = limitedAccessDeliveryOtherName;
	}

	public PackagingPalletPalletServiceDetails inBond(Boolean inBond) {
		this.inBond = inBond;
		return this;
	}

	public Boolean isInBond() {
		return inBond;
	}

	public void setInBond(Boolean inBond) {
		this.inBond = inBond;
	}

	public PackagingPalletPalletServiceDetails inBondDetails(
			PackagingPalletPalletServiceDetailsInBondDetails inBondDetails) {
		this.inBondDetails = inBondDetails;
		return this;
	}

	public PackagingPalletPalletServiceDetailsInBondDetails getInBondDetails() {
		return inBondDetails;
	}

	public void setInBondDetails(PackagingPalletPalletServiceDetailsInBondDetails inBondDetails) {
		this.inBondDetails = inBondDetails;
	}

	public PackagingPalletPalletServiceDetails appointmentDelivery(Boolean appointmentDelivery) {
		this.appointmentDelivery = appointmentDelivery;
		return this;
	}

	public Boolean isAppointmentDelivery() {
		return appointmentDelivery;
	}

	public void setAppointmentDelivery(Boolean appointmentDelivery) {
		this.appointmentDelivery = appointmentDelivery;
	}

	public PackagingPalletPalletServiceDetails protectFromFreeze(Boolean protectFromFreeze) {
		this.protectFromFreeze = protectFromFreeze;
		return this;
	}

	public Boolean isProtectFromFreeze() {
		return protectFromFreeze;
	}

	public void setProtectFromFreeze(Boolean protectFromFreeze) {
		this.protectFromFreeze = protectFromFreeze;
	}

	public PackagingPalletPalletServiceDetails thresholdPickup(Boolean thresholdPickup) {
		this.thresholdPickup = thresholdPickup;
		return this;
	}

	public Boolean isThresholdPickup() {
		return thresholdPickup;
	}

	public void setThresholdPickup(Boolean thresholdPickup) {
		this.thresholdPickup = thresholdPickup;
	}

	public PackagingPalletPalletServiceDetails thresholdDelivery(Boolean thresholdDelivery) {
		this.thresholdDelivery = thresholdDelivery;
		return this;
	}

	public Boolean isThresholdDelivery() {
		return thresholdDelivery;
	}

	public void setThresholdDelivery(Boolean thresholdDelivery) {
		this.thresholdDelivery = thresholdDelivery;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PackagingPalletPalletServiceDetails packagingPalletPalletServiceDetails = (PackagingPalletPalletServiceDetails) o;
		return Objects.equals(this.limitedAccessDeliveryType,
				packagingPalletPalletServiceDetails.limitedAccessDeliveryType)
				&& Objects.equals(this.limitedAccessDeliveryOtherName,
						packagingPalletPalletServiceDetails.limitedAccessDeliveryOtherName)
				&& Objects.equals(this.inBond, packagingPalletPalletServiceDetails.inBond)
				&& Objects.equals(this.inBondDetails, packagingPalletPalletServiceDetails.inBondDetails)
				&& Objects.equals(this.appointmentDelivery, packagingPalletPalletServiceDetails.appointmentDelivery)
				&& Objects.equals(this.protectFromFreeze, packagingPalletPalletServiceDetails.protectFromFreeze)
				&& Objects.equals(this.thresholdPickup, packagingPalletPalletServiceDetails.thresholdPickup)
				&& Objects.equals(this.thresholdDelivery, packagingPalletPalletServiceDetails.thresholdDelivery);
	}

	@Override
	public int hashCode() {
		return Objects.hash(limitedAccessDeliveryType, limitedAccessDeliveryOtherName, inBond, inBondDetails,
				appointmentDelivery, protectFromFreeze, thresholdPickup, thresholdDelivery);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PackagingPalletPalletServiceDetails {\n");

		sb.append("    limitedAccessDeliveryType: ").append(toIndentedString(limitedAccessDeliveryType)).append("\n");
		sb.append("    limitedAccessDeliveryOtherName: ").append(toIndentedString(limitedAccessDeliveryOtherName))
		.append("\n");
		sb.append("    inBond: ").append(toIndentedString(inBond)).append("\n");
		sb.append("    inBondDetails: ").append(toIndentedString(inBondDetails)).append("\n");
		sb.append("    appointmentDelivery: ").append(toIndentedString(appointmentDelivery)).append("\n");
		sb.append("    protectFromFreeze: ").append(toIndentedString(protectFromFreeze)).append("\n");
		sb.append("    thresholdPickup: ").append(toIndentedString(thresholdPickup)).append("\n");
		sb.append("    thresholdDelivery: ").append(toIndentedString(thresholdDelivery)).append("\n");
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
