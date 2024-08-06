package com.freightcom.clickship.data.entity;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freightcom.clickship.data.entity.common.BaseEntity;
import com.freightcom.clickship.data.entity.common.CustomerAssociateEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "address_book")
public class AddressBook extends BaseEntity implements CustomerAssociateEntity {
	
	private static final long serialVersionUID = 116997371271686052L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@Column(name = "business_name")
	private String businessName;
	
	@Column(name = "contact_name")
	private String contactName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "ext")
	private String ext;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "address1")
	private String address1;
	
	@Column(name = "address2")
	private String address2;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "province_state")
	private String provinceState;

	@Column(name = "country")
	private String country;

	@Column(name = "postal_code")
	private String postalCode;

	@Column(name = "residential_delivery")
	private Boolean residentialDelivery = false;
	
	@Column(name = "signature_preference")
	private String signaturePreference;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false, updatable = false)
	@JsonIgnore
	private Customer customer;

	@Column(name = "contact_id")
	private String contactId;

	@Column(name = "unit_floor")
	private String unitFloor;

	public String getId() {
		return id;
	}

	public AddressBook setId(String id) {
		this.id = id;
		return this;
	}

	public String getBusinessName() {
		return businessName;
	}

	public AddressBook setBusinessName(String businessName) {
		this.businessName = businessName;
		return this;
	}

	public String getContactName() {
		return contactName;
	}

	public AddressBook setContactName(String contactName) {
		this.contactName = contactName;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public AddressBook setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getExt() {
		return ext;
	}

	public AddressBook setExt(String ext) {
		this.ext = ext;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public AddressBook setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getAddress1() {
		return address1;
	}

	public AddressBook setAddress1(String address1) {
		this.address1 = address1;
		return this;
	}

	public String getAddress2() {
		return address2;
	}

	public AddressBook setAddress2(String address2) {
		this.address2 = address2;
		return this;
	}

	public String getCity() {
		return city;
	}

	public AddressBook setCity(String city) {
		this.city = city;
		return this;
	}

	public String getProvinceState() {
		return provinceState;
	}

	public AddressBook setProvinceState(String provinceState) {
		this.provinceState = provinceState;
		return this;
	}

	public String getCountry() {
		return country;
	}

	public AddressBook setCountry(String country) {
		this.country = country;
		return this;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public AddressBook setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		return this;
	}

	public Customer getCustomer() {
		return customer;
	}

	public AddressBook setCustomer(Customer customer) {
		this.customer = customer;
		return this;
	}

	public Boolean getResidentialDelivery() {
		return residentialDelivery;
	}

	public AddressBook setResidentialDelivery(Boolean residentialDelivery) {
		this.residentialDelivery = residentialDelivery;
		return this;
	}

	public String getSignaturePreference() {
		return signaturePreference;
	}

	public AddressBook setSignaturePreference(String signaturePreference) {
		this.signaturePreference = signaturePreference;
		return this;
	}
	
	public String getContactId() {
		return contactId;
	}

	public AddressBook setContactId(String contactId) {
		this.contactId = contactId;
		return this;
	}

	public String getUnitFloor() {
		return unitFloor;
	}

	public AddressBook setUnitFloor(String unitFloor) {
		this.unitFloor = unitFloor;
		return this;
	}
	
}
