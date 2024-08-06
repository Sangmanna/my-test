package com.freightcom.clickship.model.v2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;


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

	@JsonProperty("dangerous_goods")
	private String dangerousGoods = null;

	@JsonProperty("dangerous_goods_details")
	private DangerousGoodsDetails dangerousGoodsDetails;

	@JsonProperty("pallets")
	private List<OneOfPackagingPalletPalletsItems> pallets = new ArrayList<OneOfPackagingPalletPalletsItems>();

	@JsonProperty("pallet_service_details")
	private PackagingPalletPalletServiceDetails palletServiceDetails = null;

	public PackagingPallet palletType(PalletTypeEnum palletType) {
		this.palletType = palletType;
		return this;
	}

	public PalletTypeEnum getPalletType() {
		return palletType;
	}

	public void setPalletType(PalletTypeEnum palletType) {
		this.palletType = palletType;
	}

	public PackagingPallet hasStackablePallets(Boolean hasStackablePallets) {
		this.hasStackablePallets = hasStackablePallets;
		return this;
	}

	public Boolean isHasStackablePallets() {
		return hasStackablePallets;
	}

	public void setHasStackablePallets(Boolean hasStackablePallets) {
		this.hasStackablePallets = hasStackablePallets;
	}

	public String getDangerousGoods() {
		return dangerousGoods;
	}

	public PackagingPallet setDangerousGoods(String dangerousGoods) {
		this.dangerousGoods = dangerousGoods;
		return this;
	}

	public DangerousGoodsDetails getDangerousGoodsDetails() {
		return dangerousGoodsDetails;
	}

	public void setDangerousGoodsDetails(DangerousGoodsDetails dangerousGoodsDetails) {
		this.dangerousGoodsDetails = dangerousGoodsDetails;
	}

	public PackagingPallet pallets(List<OneOfPackagingPalletPalletsItems> pallets) {
		this.pallets = pallets;
		return this;
	}

	public PackagingPallet addPalletsItem(OneOfPackagingPalletPalletsItems palletsItem) {
		this.pallets.add(palletsItem);
		return this;
	}

	public List<OneOfPackagingPalletPalletsItems> getPallets() {
		return pallets;
	}

	public void setPallets(List<OneOfPackagingPalletPalletsItems> pallets) {
		this.pallets = pallets;
	}

	public PackagingPallet palletServiceDetails(PackagingPalletPalletServiceDetails palletServiceDetails) {
		this.palletServiceDetails = palletServiceDetails;
		return this;
	}

	public PackagingPalletPalletServiceDetails getPalletServiceDetails() {
		return palletServiceDetails;
	}

	public void setPalletServiceDetails(PackagingPalletPalletServiceDetails palletServiceDetails) {
		this.palletServiceDetails = palletServiceDetails;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PackagingPallet packagingPallet = (PackagingPallet) o;
		return Objects.equals(this.palletType, packagingPallet.palletType)
				&& Objects.equals(this.hasStackablePallets, packagingPallet.hasStackablePallets)
				&& Objects.equals(this.dangerousGoods, packagingPallet.dangerousGoods)
				&& Objects.equals(this.pallets, packagingPallet.pallets)
				&& Objects.equals(this.palletServiceDetails, packagingPallet.palletServiceDetails);
	}

	@Override
	public int hashCode() {
		return Objects.hash(palletType, hasStackablePallets, dangerousGoods, pallets, palletServiceDetails);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PackagingPallet {\n");

		sb.append("    palletType: ").append(toIndentedString(palletType)).append("\n");
		sb.append("    hasStackablePallets: ").append(toIndentedString(hasStackablePallets)).append("\n");
		sb.append("    dangerousGoods: ").append(toIndentedString(dangerousGoods)).append("\n");
		sb.append("    pallets: ").append(toIndentedString(pallets)).append("\n");
		sb.append("    palletServiceDetails: ").append(toIndentedString(palletServiceDetails)).append("\n");
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
