package com.freightcom.clickship.model.shippingrules;

public class ShippingRuleAdditionalOptionsDTO {
	private String id;
	private boolean adultSignatureRequired;
	private boolean signatureRequired;
	private boolean residentialDelivery;	
	private boolean noSignatureRequired;
	private String locationTypeForShippingOrigin;
	private String locationTypeForShippingDestination;	
	private boolean insidePickup;
	private boolean insideDelivery;
	private boolean limitedAccess;
	private String limitedAccessType;
	private String limitedAccessOtherName;
	private boolean protectFromFreeze;	
	private boolean stackable;
	private boolean appointmentDelivery;
	private boolean dangerousGoods;
	private String dangerousGoodsType;
	private String unitedNationsNumber;
	private String packagingGroup;
	private String goodsClass;
	private String goodsDescription;
	private String emergencyContactName;
	private String emergencyContactPhone;
	private String emergencyContactPhoneExt;	
	private boolean inBond = false;
	private String inBondType;
	private String inBondName;
	private String inBondAddress;
	private String inBondContactType;
	private String inBondContactValue;
	private boolean tradeShowDelivery;
	private boolean amazonOrFBADelivery;
	private boolean specialHandlingRequired = false;
	private boolean palletOptions;
	private boolean packageOptions;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isAdultSignatureRequired() {
		return adultSignatureRequired;
	}
	public void setAdultSignatureRequired(boolean adultSignatureRequired) {
		this.adultSignatureRequired = adultSignatureRequired;
	}
	public boolean isSignatureRequired() {
		return signatureRequired;
	}
	public void setSignatureRequired(boolean signatureRequired) {
		this.signatureRequired = signatureRequired;
	}
	public boolean isResidentialDelivery() {
		return residentialDelivery;
	}
	public void setResidentialDelivery(boolean residentialDelivery) {
		this.residentialDelivery = residentialDelivery;
	}
	public boolean isNoSignatureRequired() {
		return noSignatureRequired;
	}
	public void setNoSignatureRequired(boolean noSignatureRequired) {
		this.noSignatureRequired = noSignatureRequired;
	}
	public String getLocationTypeForShippingOrigin() {
		return locationTypeForShippingOrigin;
	}
	public void setLocationTypeForShippingOrigin(String locationTypeForShippingOrigin) {
		this.locationTypeForShippingOrigin = locationTypeForShippingOrigin;
	}
	public String getLocationTypeForShippingDestination() {
		return locationTypeForShippingDestination;
	}
	public void setLocationTypeForShippingDestination(String locationTypeForShippingDestination) {
		this.locationTypeForShippingDestination = locationTypeForShippingDestination;
	}
	public boolean isInsidePickup() {
		return insidePickup;
	}
	public void setInsidePickup(boolean insidePickup) {
		this.insidePickup = insidePickup;
	}
	public boolean isInsideDelivery() {
		return insideDelivery;
	}
	public void setInsideDelivery(boolean insideDelivery) {
		this.insideDelivery = insideDelivery;
	}
	public boolean isLimitedAccess() {
		return limitedAccess;
	}
	public void setLimitedAccess(boolean limitedAccess) {
		this.limitedAccess = limitedAccess;
	}
	public String getLimitedAccessType() {
		return limitedAccessType;
	}
	public void setLimitedAccessType(String limitedAccessType) {
		this.limitedAccessType = limitedAccessType;
	}
	public String getLimitedAccessOtherName() {
		return limitedAccessOtherName;
	}
	public void setLimitedAccessOtherName(String limitedAccessOtherName) {
		this.limitedAccessOtherName = limitedAccessOtherName;
	}
	public boolean isProtectFromFreeze() {
		return protectFromFreeze;
	}
	public void setProtectFromFreeze(boolean protectFromFreeze) {
		this.protectFromFreeze = protectFromFreeze;
	}
	public boolean isStackable() {
		return stackable;
	}
	public void setStackable(boolean stackable) {
		this.stackable = stackable;
	}
	public boolean isAppointmentDelivery() {
		return appointmentDelivery;
	}
	public void setAppointmentDelivery(boolean appointmentDelivery) {
		this.appointmentDelivery = appointmentDelivery;
	}
	public boolean isDangerousGoods() {
		return dangerousGoods;
	}
	public void setDangerousGoods(boolean dangerousGoods) {
		this.dangerousGoods = dangerousGoods;
	}
	public String getDangerousGoodsType() {
		return dangerousGoodsType;
	}
	public void setDangerousGoodsType(String dangerousGoodsType) {
		this.dangerousGoodsType = dangerousGoodsType;
	}
	public String getUnitedNationsNumber() {
		return unitedNationsNumber;
	}
	public void setUnitedNationsNumber(String unitedNationsNumber) {
		this.unitedNationsNumber = unitedNationsNumber;
	}
	public String getPackagingGroup() {
		return packagingGroup;
	}
	public void setPackagingGroup(String packagingGroup) {
		this.packagingGroup = packagingGroup;
	}
	public String getGoodsClass() {
		return goodsClass;
	}
	public void setGoodsClass(String goodsClass) {
		this.goodsClass = goodsClass;
	}
	public String getGoodsDescription() {
		return goodsDescription;
	}
	public void setGoodsDescription(String goodsDescription) {
		this.goodsDescription = goodsDescription;
	}
	public String getEmergencyContactName() {
		return emergencyContactName;
	}
	public void setEmergencyContactName(String emergencyContactName) {
		this.emergencyContactName = emergencyContactName;
	}
	public String getEmergencyContactPhone() {
		return emergencyContactPhone;
	}
	public void setEmergencyContactPhone(String emergencyContactPhone) {
		this.emergencyContactPhone = emergencyContactPhone;
	}
	public String getEmergencyContactPhoneExt() {
		return emergencyContactPhoneExt;
	}
	public void setEmergencyContactPhoneExt(String emergencyContactPhoneExt) {
		this.emergencyContactPhoneExt = emergencyContactPhoneExt;
	}
	public boolean isInBond() {
		return inBond;
	}
	public void setInBond(boolean inBond) {
		this.inBond = inBond;
	}
	public String getInBondType() {
		return inBondType;
	}
	public void setInBondType(String inBondType) {
		this.inBondType = inBondType;
	}
	public String getInBondName() {
		return inBondName;
	}
	public void setInBondName(String inBondName) {
		this.inBondName = inBondName;
	}
	public String getInBondAddress() {
		return inBondAddress;
	}
	public void setInBondAddress(String inBondAddress) {
		this.inBondAddress = inBondAddress;
	}
	public String getInBondContactType() {
		return inBondContactType;
	}
	public void setInBondContactType(String inBondContactType) {
		this.inBondContactType = inBondContactType;
	}
	public String getInBondContactValue() {
		return inBondContactValue;
	}
	public void setInBondContactValue(String inBondContactValue) {
		this.inBondContactValue = inBondContactValue;
	}
	public boolean isTradeShowDelivery() {
		return tradeShowDelivery;
	}
	public void setTradeShowDelivery(boolean tradeShowDelivery) {
		this.tradeShowDelivery = tradeShowDelivery;
	}
	public boolean isAmazonOrFBADelivery() {
		return amazonOrFBADelivery;
	}
	public void setAmazonOrFBADelivery(boolean amazonOrFBADelivery) {
		this.amazonOrFBADelivery = amazonOrFBADelivery;
	}
	public boolean isSpecialHandlingRequired() {
		return specialHandlingRequired;
	}
	public void setSpecialHandlingRequired(boolean specialHandlingRequired) {
		this.specialHandlingRequired = specialHandlingRequired;
	}
	public boolean isPalletOptions() {
		return palletOptions;
	}
	public void setPalletOptions(boolean palletOptions) {
		this.palletOptions = palletOptions;
	}
	public boolean isPackageOptions() {
		return packageOptions;
	}
	public void setPackageOptions(boolean packageOptions) {
		this.packageOptions = packageOptions;
	}			
	
}
