package com.freightcom.clickship.model.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DangerousGoodsDetails {

	@JsonProperty("packaging_group")
	private String packagingGroup = null;

	@JsonProperty("goods_class")
	private String goodsClass = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("united_nations_number")
	private String unitedNationsNumber = null;

	@JsonProperty("emergency_contact_name")
	private String emergencyContactName = null;

	@JsonProperty("emergency_contact_phone_number")
	private PhoneNumber contactPhoneNumber = null;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUnitedNationsNumber() {
		return unitedNationsNumber;
	}

	public void setUnitedNationsNumber(String unitedNationsNumber) {
		this.unitedNationsNumber = unitedNationsNumber;
	}

	public String getEmergencyContactName() {
		return emergencyContactName;
	}

	public void setEmergencyContactName(String emergencyContactName) {
		this.emergencyContactName = emergencyContactName;
	}

	public PhoneNumber getContactPhoneNumber() {
		return contactPhoneNumber;
	}

	public void setContactPhoneNumber(PhoneNumber contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
	}
	
}
