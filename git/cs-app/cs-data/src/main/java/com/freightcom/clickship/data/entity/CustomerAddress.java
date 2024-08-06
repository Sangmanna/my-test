package com.freightcom.clickship.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freightcom.clickship.data.entity.common.BaseEntity;
import com.freightcom.clickship.data.entity.common.CustomerAssociateEntity;
import com.freightcom.clickship.model.enums.AddressType;
import com.freightcom.clickship.model.util.ClickshipStringUtil;

@Entity
@Table(name = "customer_address")
public class CustomerAddress extends BaseEntity implements CustomerAssociateEntity {
	
	private static final long serialVersionUID = 8940805426615662575L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false, updatable = false)
	@JsonIgnore
	private Customer customer;

	@Column(name = "business_name")
	private String businessName;
	
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "address1")
	private String address1;

	@Column(name = "address2")
	private String address2;

	@Column(name = "postal_code")
	private String postalCode;

	@Column(name = "city")
	private String city;

	@Column(name = "province_state")
	private String provinceState;

	@Column(name = "country")
	private String country;

	@Column(name = "phone")
	private String phone;
	
	@Column(name = "ext")
	private String ext;

	@Column(name = "external_id")
	private Long externalId;

	@Column(name = "address_type")
	private String addressType = AddressType.REG.toString();

	@Column(name = "address_name")
	private String addressName;

	@Column(name = "email")
	private String email;

	@Column(name = "notes")
	private String notes;

	public String getId() {
		return id;
	}

	public BaseEntity setId(String id) {
		this.id = id;
		return this;
	}

	public String getCity() {
		return city;
	}

	public CustomerAddress setCity(String city) {
		this.city = ClickshipStringUtil.getStringStripAccents(city);
		return this;
	}

	public String getCountry() {
		return country;
	}

	public CustomerAddress setCountry(String country) {
		this.country = country;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public CustomerAddress setPhone(String phone) {
		this.phone = phone;
		return this;
	}
	
	public String getExt() {
		return ext;
	}

	public CustomerAddress setExt(String ext) {
		this.ext = ext;
		return this;
	}

	public Long getExternalId() {
		return externalId;
	}

	public CustomerAddress setExternalId(Long externalId) {
		this.externalId = externalId;
		return this;
	}

	public Customer getCustomer() {
		return customer;
	}

	public CustomerAddress setCustomer(Customer customer) {
		this.customer = customer;
		return this;
	}

	public String getAddress1() {
		return address1;
	}

	public CustomerAddress setAddress1(String address1) {
		this.address1 = ClickshipStringUtil.getStringStripAccents(address1);
		return this;
	}

	public String getAddress2() {
		return address2;
	}

	public CustomerAddress setAddress2(String address2) {
		this.address2 = ClickshipStringUtil.getStringStripAccents(address2);
		return this;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public CustomerAddress setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		return this;
	}

	public String getProvinceState() {
		return provinceState;
	}

	public CustomerAddress setProvinceState(String provinceState) {
		this.provinceState = provinceState;
		return this;
	}

	public String getAddressType() {
		return addressType;
	}

	public CustomerAddress setAddressType(String addressType) {
		this.addressType = addressType;
		return this;
	}

	public String getAddressName() {
		return addressName;
	}

	public CustomerAddress setAddressName(String addressName) {
		this.addressName = ClickshipStringUtil.getStringStripAccents(addressName);
		return this;
	}

	public String getContactName() {
		String name = null;
		
		if(StringUtils.isNotBlank(firstName)){
			name = firstName; 
		}
		
		if(StringUtils.isNotBlank(lastName)){
			name = name == null ? lastName : name+ " " + lastName; 
		}
		
		return name;
	}

	public String getEmail() {
		return email;
	}

	public CustomerAddress setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getNotes() {
		return notes;
	}

	public CustomerAddress setNotes(String notes) {
		this.notes = notes;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public CustomerAddress setFirstName(String firstName) {
		this.firstName = ClickshipStringUtil.getStringStripAccents(firstName);
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public CustomerAddress setLastName(String lastName) {
		this.lastName = ClickshipStringUtil.getStringStripAccents(lastName);
		return this;
	}
	public String getBusinessName() {
		return businessName;
	}

	public CustomerAddress setBusinessName(String businessName) {
		this.businessName = ClickshipStringUtil.getStringStripAccents(businessName);
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

	public String getAddress() {
		return String.format("%s %s %s %s %s", this.getAddress1(), this.getCity(), this.getProvinceState(), this.getCountry(), this.getPostalCode());
	}
}