package com.freightcom.clickship.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PalletServicesDTO extends CommonDTO implements Serializable{

	private static final long serialVersionUID = 7144578768285616676L;

	private Boolean stackable = false;
	private Boolean dangerousGoods = false;
	private String dangerousGoodsType = "limited-quantity";
	private String unitedNationsNumber;
	private String packagingGroup = "";
	private String goodsClass;
	private String goodsDescription;
	private String emergencyContactName;
	private String emergencyContactPhone;
	private String emergencyContactPhoneExt;
	private Boolean limitedAccess = false;
	private String limitedAccessType = "construction-site";
	private String limitedAccessOtherName;
	private Boolean deliveryAppointment = false;
	private Boolean insideDelivery = false;
	private Boolean insidePickup = false;
	private Boolean inBond = false;
	private String inBondType = "transportation-and-exportation";
	private String inBondName;
	private String inBondAddress;
	private String inBondContactType = "email-address";
	private String inBondContactValue;
	private Boolean protectFromFreeze = false;
	private Boolean tradeShowDelivery = false;
	private Boolean amazonOrFBADelivery = false;

	public Boolean getStackable() {
		return stackable;
	}

	public PalletServicesDTO setStackable(Boolean stackable) {
		this.stackable = stackable;
		return this;
	}

	public Boolean getDangerousGoods() {
		return dangerousGoods;
	}

	public PalletServicesDTO setDangerousGoods(Boolean dangerousGoods) {
		this.dangerousGoods = dangerousGoods;
		return this;
	}

	public String getDangerousGoodsType() {
		return dangerousGoodsType;
	}

	public PalletServicesDTO setDangerousGoodsType(String dangerousGoodsType) {
		this.dangerousGoodsType = dangerousGoodsType;
		return this;
	}

	public String getUnitedNationsNumber() {
		return unitedNationsNumber;
	}

	public PalletServicesDTO setUnitedNationsNumber(String unitedNationsNumber) {
		this.unitedNationsNumber = unitedNationsNumber;
		return this;
	}

	public String getPackagingGroup() {
		return packagingGroup;
	}

	public PalletServicesDTO setPackagingGroup(String packagingGroup) {
		this.packagingGroup = packagingGroup;
		return this;
	}

	public String getGoodsClass() {
		return goodsClass;
	}

	public PalletServicesDTO setGoodsClass(String goodsClass) {
		this.goodsClass = goodsClass;
		return this;
	}

	public String getGoodsDescription() {
		return goodsDescription;
	}

	public PalletServicesDTO setGoodsDescription(String goodsDescription) {
		this.goodsDescription = goodsDescription;
		return this;
	}

	public String getEmergencyContactName() {
		return emergencyContactName;
	}

	public PalletServicesDTO setEmergencyContactName(String emergencyContactName) {
		this.emergencyContactName = emergencyContactName;
		return this;
	}

	public String getEmergencyContactPhone() {
		return emergencyContactPhone;
	}

	public PalletServicesDTO setEmergencyContactPhone(String emergencyContactPhone) {
		this.emergencyContactPhone = emergencyContactPhone;
		return this;
	}

	public String getEmergencyContactPhoneExt() {
		return emergencyContactPhoneExt;
	}

	public PalletServicesDTO setEmergencyContactPhoneExt(String emergencyContactPhoneExt) {
		this.emergencyContactPhoneExt = emergencyContactPhoneExt;
		return this;
	}

	public Boolean getLimitedAccess() {
		return limitedAccess;
	}

	public PalletServicesDTO setLimitedAccess(Boolean limitedAccess) {
		this.limitedAccess = limitedAccess;
		return this;
	}

	public String getLimitedAccessType() {
		return limitedAccessType;
	}

	public PalletServicesDTO setLimitedAccessType(String limitedAccessType) {
		this.limitedAccessType = limitedAccessType;
		return this;
	}

	public String getLimitedAccessOtherName() {
		return limitedAccessOtherName;
	}

	public PalletServicesDTO setLimitedAccessOtherName(String limitedAccessOtherName) {
		this.limitedAccessOtherName = limitedAccessOtherName;
		return this;
	}

	public Boolean getDeliveryAppointment() {
		return deliveryAppointment;
	}

	public PalletServicesDTO setDeliveryAppointment(Boolean deliveryAppointment) {
		this.deliveryAppointment = deliveryAppointment;
		return this;
	}

	public Boolean getInsideDelivery() {
		return insideDelivery;
	}

	public PalletServicesDTO setInsideDelivery(Boolean insideDelivery) {
		this.insideDelivery = insideDelivery;
		return this;
	}

	public Boolean getInsidePickup() {
		return insidePickup;
	}

	public PalletServicesDTO setInsidePickup(Boolean insidePickup) {
		this.insidePickup = insidePickup;
		return this;
	}

	public Boolean getInBond() {
		return inBond;
	}

	public PalletServicesDTO setInBond(Boolean inBond) {
		this.inBond = inBond;
		return this;
	}

	public String getInBondType() {
		return inBondType;
	}

	public PalletServicesDTO setInBondType(String inBondType) {
		this.inBondType = inBondType;
		return this;
	}

	public String getInBondName() {
		return inBondName;
	}

	public PalletServicesDTO setInBondName(String inBondName) {
		this.inBondName = inBondName;
		return this;
	}

	public String getInBondAddress() {
		return inBondAddress;
	}

	public PalletServicesDTO setInBondAddress(String inBondAddress) {
		this.inBondAddress = inBondAddress;
		return this;
	}

	public String getInBondContactType() {
		return inBondContactType;
	}

	public PalletServicesDTO setInBondContactType(String inBondContactType) {
		this.inBondContactType = inBondContactType;
		return this;
	}

	public String getInBondContactValue() {
		return inBondContactValue;
	}

	public PalletServicesDTO setInBondContactValue(String inBondContactValue) {
		this.inBondContactValue = inBondContactValue;
		return this;
	}

	public Boolean getProtectFromFreeze() {
		return protectFromFreeze;
	}

	public PalletServicesDTO setProtectFromFreeze(Boolean protectFromFreeze) {
		this.protectFromFreeze = protectFromFreeze;
		return this;
	}

	public Boolean getTradeShowDelivery() {
		return tradeShowDelivery;
	}

	public PalletServicesDTO setTradeShowDelivery(Boolean tradeShowDelivery) {
		this.tradeShowDelivery = tradeShowDelivery;
		return this;
	}

	public Boolean getAmazonOrFBADelivery() {
		return amazonOrFBADelivery;
	}

	public PalletServicesDTO setAmazonOrFBADelivery(Boolean amazonOrFBADelivery) {
		this.amazonOrFBADelivery = amazonOrFBADelivery;
		return this;
	}
}
