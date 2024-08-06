package com.freightcom.clickship.model.v2.claim;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.freightcom.clickship.model.v2.PackagingPalletPalletServiceDetailsInBondDetails;

import lombok.Data;

@Data
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
	
	@JsonProperty("trade_show_delivery")
	private boolean tradeShowDelivery;
	
	@JsonProperty("amazon_or_fbadelivery")
	private boolean amazonOrFbadelivery;
}
