package com.freightcom.clickship.model.v2;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShippingProperties {

	@JsonProperty("packages")
	private List<PackagingPropertiesDTO> packageProperties;
	
	@JsonProperty("pallets")
	private List<PalletsDTO> pallets;
	
	@JsonProperty("pallet_type")
	private String palletType;
	
	@JsonProperty("includes_return_label")
	private String includesReturnLabel;
	
	@JsonProperty("has_stackable_pallets")
	private boolean hasStackablePallets;
	
	@JsonProperty("dangerous_goods")
	private String dangerousGoods;
	
	@JsonProperty("pallet_service_details")
	private PalletServiceDetailsDTO pallestServiceDetails;

	public List<PackagingPropertiesDTO> getPackageProperties() {
		return packageProperties;
	}

	public void setPackageProperties(List<PackagingPropertiesDTO> packageProperties) {
		this.packageProperties = packageProperties;
	}

	public String getIncludesReturnLabel() {
		return includesReturnLabel;
	}

	public void setIncludesReturnLabel(String includesReturnLabel) {
		this.includesReturnLabel = includesReturnLabel;
	}

	public String getPalletType() {
		return palletType;
	}

	public void setPalletType(String palletType) {
		this.palletType = palletType;
	}

	public List<PalletsDTO> getPallets() {
		return pallets;
	}

	public void setPallets(List<PalletsDTO> pallets) {
		this.pallets = pallets;
	}

	public boolean isHasStackablePallets() {
		return hasStackablePallets;
	}

	public void setHasStackablePallets(boolean hasStackablePallets) {
		this.hasStackablePallets = hasStackablePallets;
	}

	public String getDangerousGoods() {
		return dangerousGoods;
	}

	public void setDangerousGoods(String dangerousGoods) {
		this.dangerousGoods = dangerousGoods;
	}

	public PalletServiceDetailsDTO getPallestServiceDetails() {
		return pallestServiceDetails;
	}

	public void setPallestServiceDetails(PalletServiceDetailsDTO pallestServiceDetails) {
		this.pallestServiceDetails = pallestServiceDetails;
	}
	
	
	
	
	
}
