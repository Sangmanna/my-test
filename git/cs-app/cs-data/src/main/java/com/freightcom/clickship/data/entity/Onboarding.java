package com.freightcom.clickship.data.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "onboarding")
public class Onboarding extends BaseEntity {

	private static final long serialVersionUID = 2565592084332596093L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false, updatable = false)
	@JsonIgnore
	private Customer customer;
	
	@Column(name = "email_verified")
	private boolean emailVerified = false;
	
	@Column(name = "phone_verified")
	private boolean phoneVerified = false;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "phone_international_dial_number")
	private String phoneInternationalDialNumber;
	
	@Column(name = "phone_country_code")
	private String phoneCountryCode;
	
	@Column(name = "email_address")
	private String emailAddress;
	
	@Column(name = "usage_of_clickship")
	private String usageOfClickship;
	
	@Column(name = "kind_of_package")
	private String kindOfPackage;
	
	@Column(name = "monthly_shipments")
	private String monthlyShipments;
	
	@Column(name = "marketplaces")
	private String marketplaces;
	
	@Column(name = "other_marketplaces")
	private String otherMarketplaces;
	
	@Column(name = "kind_of_products")
	private String kindOfProducts;
	
	@Column(name = "carriers")
	private String carriers;
	
	@Column(name = "other_carriers")
	private String otherCarriers;
	
	@Column(name = "has_accounts")
	private String hasAccounts;
	
	@Column(name = "how_know_us")
	private String howKnowUs;
	
	@Column(name = "other_how_know_us")
	private String otherHowKnowUs;
	
	@Column(name = "promo_code")
	private String promoCode;
	
	@Column(name = "opt_in_for_emails")
	private boolean optInForEmails = false;
	
	@Column(name = "current_step")
	private int currentStep;
	
	@Column(name = "completed")
	private boolean completed = false;

	@Column(name = "otp_type")
	private String otpType;
	
	@Column(name = "verification_code_sent")
	@Temporal(TemporalType.TIMESTAMP)
	public Date verificationCodeSent;
	
	@Column(name = "appcue_reported")
	private String appcueReported;
	
	@Column(name = "address1")
	private String address1;
	
	@Column(name = "address2")
	private String address2;
	
	@Column(name = "postalCode")
	private String postalCode;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "province_state")
	private String provinceState;
	
	@Column(name = "country")
	private String country;
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public BaseEntity setId(String id) {
		this.id = id;
		return this;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Onboarding setCustomer(Customer customer) {
		this.customer = customer;
		return this;
	}

	public boolean isEmailVerified() {
		return emailVerified;
	}

	public Onboarding setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
		return this;
	}

	public boolean isPhoneVerified() {
		return phoneVerified;
	}

	public Onboarding setPhoneVerified(boolean phoneVerified) {
		this.phoneVerified = phoneVerified;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public Onboarding setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getPhoneInternationalDialNumber() {
		return phoneInternationalDialNumber;
	}

	public Onboarding setPhoneInternationalDialNumber(String phoneInternationalDialNumber) {
		this.phoneInternationalDialNumber = phoneInternationalDialNumber;
		return this;
	}

	public String getPhoneCountryCode() {
		return phoneCountryCode;
	}

	public Onboarding setPhoneCountryCode(String phoneCountryCode) {
		this.phoneCountryCode = phoneCountryCode;
		return this;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public Onboarding setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
		return this;
	}

	public String getUsageOfClickship() {
		return usageOfClickship;
	}

	public Onboarding setUsageOfClickship(String usageOfClickship) {
		this.usageOfClickship = usageOfClickship;
		return this;
	}

	public String getKindOfPackage() {
		return kindOfPackage;
	}

	public Onboarding setKindOfPackage(String kindOfPackage) {
		this.kindOfPackage = kindOfPackage;
		return this;
	}

	public String getMonthlyShipments() {
		return monthlyShipments;
	}

	public Onboarding setMonthlyShipments(String monthlyShipments) {
		this.monthlyShipments = monthlyShipments;
		return this;
	}

	public String getMarketplaces() {
		return marketplaces;
	}

	public Onboarding setMarketplaces(String marketplaces) {
		this.marketplaces = marketplaces;
		return this;
	}

	public String getOtherMarketplaces() {
		return otherMarketplaces;
	}

	public Onboarding setOtherMarketplaces(String otherMarketplaces) {
		this.otherMarketplaces = otherMarketplaces;
		return this;
	}

	public String getKindOfProducts() {
		return kindOfProducts;
	}

	public Onboarding setKindOfProducts(String kindOfProducts) {
		this.kindOfProducts = kindOfProducts;
		return this;
	}

	public String getCarriers() {
		return carriers;
	}

	public Onboarding setCarriers(String carriers) {
		this.carriers = carriers;
		return this;
	}

	public String getOtherCarriers() {
		return otherCarriers;
	}

	public Onboarding setOtherCarriers(String otherCarriers) {
		this.otherCarriers = otherCarriers;
		return this;
	}

	public String getHasAccounts() {
		return StringUtils.isNotBlank(hasAccounts) ? hasAccounts : "";
	}

	public Onboarding setHasAccounts(String hasAccounts) {
		this.hasAccounts = hasAccounts;
		return this;
	}

	public String getHowKnowUs() {
		return howKnowUs;
	}

	public Onboarding setHowKnowUs(String howKnowUs) {
		this.howKnowUs = howKnowUs;
		return this;
	}

	public String getOtherHowKnowUs() {
		return otherHowKnowUs;
	}

	public Onboarding setOtherHowKnowUs(String otherHowKnowUs) {
		this.otherHowKnowUs = otherHowKnowUs;
		return this;
	}

	public String getPromoCode() {
		return promoCode;
	}

	public Onboarding setPromoCode(String promoCode) {
		this.promoCode = promoCode;
		return this;
	}

	public boolean isOptInForEmails() {
		return optInForEmails;
	}

	public Onboarding setOptInForEmails(boolean optInForEmails) {
		this.optInForEmails = optInForEmails;
		return this;
	}

	public int getCurrentStep() {
		return currentStep;
	}

	public Onboarding setCurrentStep(int currentStep) {
		this.currentStep = currentStep;
		return this;
	}

	public boolean isCompleted() {
		return completed;
	}

	public Onboarding setCompleted(boolean completed) {
		this.completed = completed;
		return this;
	}

	public String getOtpType() {
		return otpType;
	}

	public Onboarding setOtpType(String otpType) {
		this.otpType = otpType;
		return this;
	}

	public Date getVerificationCodeSent() {
		return verificationCodeSent;
	}

	public Onboarding setVerificationCodeSent(Date verificationCodeSent) {
		this.verificationCodeSent = verificationCodeSent;
		return this;
	}

	public String getAppcueReported() {
		return appcueReported;
	}

	public Onboarding setAppcueReported(String appcueReported) {
		this.appcueReported = appcueReported;
		return this;
	}

	public String getAddress1() {
		return address1;
	}

	public Onboarding setAddress1(String address1) {
		this.address1 = address1;
		return this;
	}

	public String getAddress2() {
		return address2;
	}

	public Onboarding setAddress2(String address2) {
		this.address2 = address2;
		return this;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public Onboarding setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		return this;
	}

	public String getCity() {
		return city;
	}

	public Onboarding setCity(String city) {
		this.city = city;
		return this;
	}

	public String getProvinceState() {
		return provinceState;
	}

	public Onboarding setProvinceState(String provinceState) {
		this.provinceState = provinceState;
		return this;
	}

	public String getCountry() {
		return country;
	}

	public Onboarding setCountry(String country) {
		this.country = country;
		return this;
	}
	
}
