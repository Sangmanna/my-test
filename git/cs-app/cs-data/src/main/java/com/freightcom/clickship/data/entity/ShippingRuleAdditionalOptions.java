package com.freightcom.clickship.data.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "shipping_rule_additional_options")
public class ShippingRuleAdditionalOptions extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -6044109834900971718L;

	@Id
    @GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
    @Column(name = "id", nullable = false, updatable = false)
    private String id;
	
	@Column(name = "adult_signature_required")
	private Boolean adultSignatureRequired = false;

	@Column(name = "signature_required")
	private Boolean signatureRequired = false;

	@Column(name = "residential_delivery")
	private Boolean residentialDelivery = false;	
	
	@Column(name = "no_signature_required")
	private boolean noSignatureRequired;
	
	@Column(name = "location_type_shipping_origin")
	private String locationTypeForShippingOrigin;
	
	@Column(name = "location_type_shipping_destination")
	private String locationTypeForShippingDestination;	
	
	@Column(name = "inside_pickup")
	private boolean insidePickup = false;

	@Column(name = "inside_delivery")
	private boolean insideDelivery = false;

	@Column(name = "limited_access")
	private boolean limitedAccess = false;
	
	@Column(name = "limited_access_type")
	private String limitedAccessType;

	@Column(name = "limited_access_other_name")
	private String limitedAccessOtherName;

	@Column(name = "protect_from_freeze")
	private boolean protectFromFreeze = false;	

	@Column(name = "stackable")
	private boolean stackable = false;
	
	@Column(name = "appointment_delivery")
	private boolean appointmentDelivery;

	@Column(name = "dangerous_goods")
	private boolean dangerousGoods;
	
	@Column(name = "dangerous_goods_type")
	private String dangerousGoodsType;

	@Column(name = "united_nations_number")
	private String unitedNationsNumber;

	@Column(name = "packaging_group")
	private String packagingGroup;

	@Column(name = "goods_class")
	private String goodsClass;

	@Column(name = "goods_description")
	private String goodsDescription;

	@Column(name = "emergency_contact_name")
	private String emergencyContactName;

	@Column(name = "emergency_contact_phone")
	private String emergencyContactPhone;

	@Column(name = "emergency_contact_phone_ext")
	private String emergencyContactPhoneExt;	

	@Column(name = "in_bond")
	private boolean inBond = false;
	
	@Column(name = "in_bond_type")
	private String inBondType;

	@Column(name = "in_bond_name")
	private String inBondName;

	@Column(name = "in_bond_address")
	private String inBondAddress;

	@Column(name = "in_bond_contact_type")
	private String inBondContactType;

	@Column(name = "in_bond_contact_value")
	private String inBondContactValue;

	@Column(name = "trade_show_delivery")
	private boolean tradeShowDelivery;

	@Column(name = "amazon_or_fba_delivery")
	private boolean amazonOrFBADelivery;
	
	@Column(name = "special_handling_required")
	private boolean specialHandlingRequired;
	
	@Column(name = "pallet_options")	
	private boolean palletOptions;
	
	@Column(name = "package_options")
	private boolean packageOptions;
	
	public String getId() {
		return id;
	}

	public Boolean getAdultSignatureRequired() {
		return adultSignatureRequired;
	}

	public void setAdultSignatureRequired(Boolean adultSignatureRequired) {
		this.adultSignatureRequired = adultSignatureRequired;
	}

	public Boolean getSignatureRequired() {
		return signatureRequired;
	}

	public void setSignatureRequired(Boolean signatureRequired) {
		this.signatureRequired = signatureRequired;
	}

	public Boolean getResidentialDelivery() {
		return residentialDelivery;
	}

	public void setResidentialDelivery(Boolean residentialDelivery) {
		this.residentialDelivery = residentialDelivery;
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

	public boolean isInBond() {
		return inBond;
	}

	public void setInBond(boolean inBond) {
		this.inBond = inBond;
	}

	public String getDangerousGoodsType() {
		return dangerousGoodsType;
	}

	public void setDangerousGoodsType(String dangerousGoodsType) {
		this.dangerousGoodsType = dangerousGoodsType;
	}

	public boolean isStackable() {
		return stackable;
	}

	public void setStackable(boolean stackable) {
		this.stackable = stackable;
	}

	public BaseEntity setId(String id) {
		return this;
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

	public boolean isNoSignatureRequired() {
		return noSignatureRequired;
	}

	public void setNoSignatureRequired(boolean noSignatureRequired) {
		this.noSignatureRequired = noSignatureRequired;
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

	public boolean isProtectFromFreeze() {
		return protectFromFreeze;
	}

	public void setProtectFromFreeze(boolean protectFromFreeze) {
		this.protectFromFreeze = protectFromFreeze;
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
