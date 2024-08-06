package com.freightcom.clickship.model.v2.claim;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PackagingPallet implements OneOfShippingDetailsPackagingProperties {
	/**
	 * The pallet types.
	 */
	public enum PalletTypeEnum {
		LTL("ltl");

		private String value;

		PalletTypeEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static PalletTypeEnum fromValue(String text) {
			for (PalletTypeEnum b : PalletTypeEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("pallet_type")
	private PalletTypeEnum palletType = null;

	@JsonProperty("has_stackable_pallets")
	private Boolean hasStackablePallets = null;

	@JsonProperty("has_dangerous_goods")
	private Boolean hasDangerousGoods = null;

	@JsonProperty("pallets")
	private List<LTLPallet> pallets = null;
 
	@JsonProperty("pallet_service_details")
	private PackagingPalletPalletServiceDetails palletServiceDetails = null;
	
	@JsonProperty("dangerous_goods")
	private String dangerousGoods = null;
}
