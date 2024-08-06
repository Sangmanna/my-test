package com.freightcom.clickship.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "pallet_services")
public class PalletServices extends BaseEntity {

	private static final long serialVersionUID = -5225908421436319555L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "shipment_id", nullable = false)
	private Shipment shipment;

	@Column(name = "stackable")
	private Boolean stackable = false;

	@Column(name = "dangerous_goods")
	private Boolean dangerousGoods = false;

	@Column(name = "dangerous_goods_type")
	private String dangerousGoodsType = "limited-quantity";

	@Column(name = "united_nations_number")
	private String unitedNationsNumber;

	@Column(name = "packaging_group")
	private String packagingGroup = "";

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

	@Column(name = "limited_access")
	private Boolean limitedAccess = false;

	@Column(name = "limited_access_type")
	private String limitedAccessType;

	@Column(name = "limited_access_other_name")
	private String limitedAccessOtherName;

	@Column(name = "delivery_appointment")
	private Boolean deliveryAppointment = false;

	@Column(name = "inside_delivery")
	private Boolean insideDelivery = false;

	@Column(name = "inside_pickup")
	private Boolean insidePickup = false;

	@Column(name = "in_bond")
	private Boolean inBond = false;

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

	@Column(name = "protect_from_freeze")
	private Boolean protectFromFreeze = false;

	@Column(name = "trade_show_delivery")
	private Boolean tradeShowDelivery = false;

	@Column(name = "amazon_fba_delivery")
	private Boolean amazonOrFBADelivery = false;

	public String getId() {
		return id;
	}

	public PalletServices setId(String id) {
		this.id = id;
		return this;
	}

	public Shipment getShipment() {
		return shipment;
	}

	public PalletServices setShipment(Shipment shipment) {
		this.shipment = shipment;
		return this;
	}

	public Boolean getStackable() {
		return stackable;
	}

	public PalletServices setStackable(Boolean stackable) {
		this.stackable = stackable;
		return this;
	}

	public Boolean getDangerousGoods() {
		return dangerousGoods;
	}

	public PalletServices setDangerousGoods(Boolean dangerousGoods) {
		this.dangerousGoods = dangerousGoods;
		return this;
	}

	public String getDangerousGoodsType() {
		return dangerousGoodsType;
	}

	public PalletServices setDangerousGoodsType(String dangerousGoodsType) {
		this.dangerousGoodsType = dangerousGoodsType;
		return this;
	}

	public String getUnitedNationsNumber() {
		return unitedNationsNumber;
	}

	public PalletServices setUnitedNationsNumber(String unitedNationsNumber) {
		this.unitedNationsNumber = unitedNationsNumber;
		return this;
	}

	public String getPackagingGroup() {
		return packagingGroup;
	}

	public PalletServices setPackagingGroup(String packagingGroup) {
		this.packagingGroup = packagingGroup;
		return this;
	}

	public String getGoodsClass() {
		return goodsClass;
	}

	public PalletServices setGoodsClass(String goodsClass) {
		this.goodsClass = goodsClass;
		return this;
	}

	public String getGoodsDescription() {
		return goodsDescription;
	}

	public PalletServices setGoodsDescription(String goodsDescription) {
		this.goodsDescription = goodsDescription;
		return this;
	}

	public String getEmergencyContactName() {
		return emergencyContactName;
	}

	public PalletServices setEmergencyContactName(String emergencyContactName) {
		this.emergencyContactName = emergencyContactName;
		return this;
	}

	public String getEmergencyContactPhone() {
		return emergencyContactPhone;
	}

	public PalletServices setEmergencyContactPhone(String emergencyContactPhone) {
		this.emergencyContactPhone = emergencyContactPhone;
		return this;
	}

	public String getEmergencyContactPhoneExt() {
		return emergencyContactPhoneExt;
	}

	public PalletServices setEmergencyContactPhoneExt(String emergencyContactPhoneExt) {
		this.emergencyContactPhoneExt = emergencyContactPhoneExt;
		return this;
	}

	public Boolean getLimitedAccess() {
		return limitedAccess;
	}

	public PalletServices setLimitedAccess(Boolean limitedAccess) {
		this.limitedAccess = limitedAccess;
		return this;
	}

	public String getLimitedAccessType() {
		return limitedAccessType;
	}

	public PalletServices setLimitedAccessType(String limitedAccessType) {
		this.limitedAccessType = limitedAccessType;
		return this;
	}

	public String getLimitedAccessOtherName() {
		return limitedAccessOtherName;
	}

	public PalletServices setLimitedAccessOtherName(String limitedAccessOtherName) {
		this.limitedAccessOtherName = limitedAccessOtherName;
		return this;
	}

	public Boolean getDeliveryAppointment() {
		return deliveryAppointment;
	}

	public PalletServices setDeliveryAppointment(Boolean deliveryAppointment) {
		this.deliveryAppointment = deliveryAppointment;
		return this;
	}

	public Boolean getInsideDelivery() {
		return insideDelivery;
	}

	public PalletServices setInsideDelivery(Boolean insideDelivery) {
		this.insideDelivery = insideDelivery;
		return this;
	}

	public Boolean getInsidePickup() {
		return insidePickup;
	}

	public PalletServices setInsidePickup(Boolean insidePickup) {
		this.insidePickup = insidePickup;
		return this;
	}

	public Boolean getInBond() {
		return inBond;
	}

	public PalletServices setInBond(Boolean inBond) {
		this.inBond = inBond;
		return this;
	}

	public String getInBondType() {
		return inBondType;
	}

	public PalletServices setInBondType(String inBondType) {
		this.inBondType = inBondType;
		return this;
	}

	public String getInBondName() {
		return inBondName;
	}

	public PalletServices setInBondName(String inBondName) {
		this.inBondName = inBondName;
		return this;
	}

	public String getInBondAddress() {
		return inBondAddress;
	}

	public PalletServices setInBondAddress(String inBondAddress) {
		this.inBondAddress = inBondAddress;
		return this;
	}

	public String getInBondContactType() {
		return inBondContactType;
	}

	public PalletServices setInBondContactType(String inBondContactType) {
		this.inBondContactType = inBondContactType;
		return this;
	}

	public String getInBondContactValue() {
		return inBondContactValue;
	}

	public PalletServices setInBondContactValue(String inBondContactValue) {
		this.inBondContactValue = inBondContactValue;
		return this;
	}

	public Boolean getProtectFromFreeze() {
		return protectFromFreeze;
	}

	public PalletServices setProtectFromFreeze(Boolean protectFromFreeze) {
		this.protectFromFreeze = protectFromFreeze;
		return this;
	}

	public Boolean getTradeShowDelivery() {
		return tradeShowDelivery;
	}

	public PalletServices setTradeShowDelivery(Boolean tradeShowDelivery) {
		this.tradeShowDelivery = tradeShowDelivery;
		return this;
	}

	public Boolean getAmazonOrFBADelivery() {
		return amazonOrFBADelivery;
	}

	public PalletServices setAmazonOrFBADelivery(Boolean amazonOrFBADelivery) {
		this.amazonOrFBADelivery = amazonOrFBADelivery;
		return this;
	}

}
