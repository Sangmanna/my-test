package com.freightcom.clickship.model.customer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.freightcom.clickship.model.CommonDTO;
import com.freightcom.clickship.model.marketplace.MarketplaceDTO;
import com.freightcom.clickship.model.util.ClickshipStringUtil;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerAddressDTO extends CommonDTO implements Serializable {

	private static final long serialVersionUID = -8588602510637855231L;

	private String id;

	private String businessName;
	
	private String firstName;

	private String lastName;

	private String address1;

	private String address2;

	private String postalCode;

	private String city;

	private String provinceState;

	private String country;

	private String phone;
	
	private String ext;

	private Long externalId;

	private String addressType;

	private String addressName;
	
	private String contactName;

	private String email;

	private String notes;
	
	private boolean isDefaultAddress = false;
	
	private List<MarketplaceDTO> marketplaces = new ArrayList<>();

	public String getId() {
		return id;
	}

	public CustomerAddressDTO setId(String id) {
		this.id = id;
		return this;
	}

	public String getBusinessName() {
		return businessName;
	}

	public CustomerAddressDTO setBusinessName(String businessName) {
		this.businessName = ClickshipStringUtil.getStringStripAccents(businessName);
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public CustomerAddressDTO setFirstName(String firstName) {
		this.firstName = ClickshipStringUtil.getStringStripAccents(firstName);
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public CustomerAddressDTO setLastName(String lastName) {
		this.lastName = ClickshipStringUtil.getStringStripAccents(lastName);
		return this;
	}

	public String getAddress1() {
		return address1;
	}

	public CustomerAddressDTO setAddress1(String address1) {
		this.address1 = ClickshipStringUtil.getStringStripAccents(address1);
		return this;
	}

	public String getAddress2() {
		return address2;
	}

	public CustomerAddressDTO setAddress2(String address2) {
		this.address2 = ClickshipStringUtil.getStringStripAccents(address2);
		return this;
	}
	
	public String getConcatenateAddress() {
		String address = null;
		
		if(StringUtils.isNotBlank(address1)){
			address = address1; 
		}
		
		if(StringUtils.isNotBlank(address2)){
			address = address == null ? address2 : address+ " " + address2; 
		}
		
		return address;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public CustomerAddressDTO setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		return this;
	}

	public String getCity() {
		return city;
	}

	public CustomerAddressDTO setCity(String city) {
		this.city = city;
		return this;
	}

	public String getProvinceState() {
		return provinceState;
	}

	public CustomerAddressDTO setProvinceState(String provinceState) {
		this.provinceState = provinceState;
		return this;
	}

	public String getCountry() {
		return country;
	}

	public CustomerAddressDTO setCountry(String country) {
		this.country = country;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public CustomerAddressDTO setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getExt() {
		return ext;
	}

	public CustomerAddressDTO setExt(String ext) {
		this.ext = ext;
		return this;
	}

	public Long getExternalId() {
		return externalId;
	}

	public CustomerAddressDTO setExternalId(Long externalId) {
		this.externalId = externalId;
		return this;
	}

	public String getAddressType() {
		return addressType;
	}

	public CustomerAddressDTO setAddressType(String addressType) {
		this.addressType = addressType;
		return this;
	}

	public String getAddressName() {
		return addressName;
	}

	public CustomerAddressDTO setAddressName(String addressName) {
		this.addressName = ClickshipStringUtil.getStringStripAccents(addressName);
		return this;
	}

	public String getEmail() {
		return email;
	}

	public CustomerAddressDTO setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getNotes() {
		return notes;
	}

	public CustomerAddressDTO setNotes(String notes) {
		this.notes = notes;
		return this;
	}

	public boolean isDefaultAddress() {
		return isDefaultAddress;
	}

	public CustomerAddressDTO setDefaultAddress(boolean isDefaultAddress) {
		this.isDefaultAddress = isDefaultAddress;
		return this;
	}

	public List<MarketplaceDTO> getMarketplaces() {
		return marketplaces;
	}

	public CustomerAddressDTO setMarketplaces(List<MarketplaceDTO> marketplaces) {
		if(marketplaces != null && marketplaces.size() > 0 ) {
			this.marketplaces.addAll(marketplaces);	
		}
		
		return this;
	}
	
	public String getContactName() {
		return contactName;
	}

	public CustomerAddressDTO setContactName(String contactName) {
		this.contactName = ClickshipStringUtil.getStringStripAccents(contactName);
		return this;
	}
	
}
