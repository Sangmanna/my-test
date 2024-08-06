package com.freightcom.clickship.model.onboarding;

import java.io.Serializable;

import com.freightcom.clickship.model.CommonDTO;

public class OnboardingDTO extends CommonDTO implements Serializable {
	
	private static final long serialVersionUID = -39132367201319297L;

	// singup part
	private String signupUserName;
	private String signupPassword;
	private String firstName;
	private String lastName;
	private String phone;
	private String phoneInternationalDialNumber;
	private String phoneCountryCode;
	private String emailAddress;
	private String businessName;
	private String otpType;
	private String registrationSource;

	// onboarding part
	private int currentStep;
	private String usageOfClickship;
	private String kindOfPackage;
	private String monthlyShipments;
	private String marketplaces;
	private String otherMarketplaces;
	private String kindOfProducts;
	private String carriers;
	private String otherCarriers;
	private String hasAccounts;
	private String howKnowUs;
	private String otherHowKnowUs;
	private String promoCode;
	private boolean optInForEmails;
	private boolean completed;
	private long verificationCodeRemainedTime;
	private boolean emptyVendastaRequest;

	// add address
	private String address1;
	private String address2;
	private String postalCode;
	private String city;
	private String provinceState;
	private String country;
	
	private String plan;
	
	// Details from FC API
	private String fcUserId;
	private String fcCustomerId;
	private String fcBillingType;
	private boolean isFcCustomer;
	private String salesRep;
	private boolean isV2Customer;
	private String fcPaymentMethodId;

	public String getSignupUserName() {
		return signupUserName;
	}

	public OnboardingDTO setSignupUserName(String signupUserName) {
		this.signupUserName = signupUserName;
		return this;
	}

	public String getSignupPassword() {
		return signupPassword;
	}

	public OnboardingDTO setSignupPassword(String signupPassword) {
		this.signupPassword = signupPassword;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public OnboardingDTO setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public OnboardingDTO setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public OnboardingDTO setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getPhoneInternationalDialNumber() {
		return phoneInternationalDialNumber;
	}

	public OnboardingDTO setPhoneInternationalDialNumber(String phoneInternationalDialNumber) {
		this.phoneInternationalDialNumber = phoneInternationalDialNumber;
		return this;
	}

	public String getPhoneCountryCode() {
		return phoneCountryCode;
	}

	public OnboardingDTO setPhoneCountryCode(String phoneCountryCode) {
		this.phoneCountryCode = phoneCountryCode;
		return this;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public OnboardingDTO setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
		return this;
	}

	public String getBusinessName() {
		return businessName;
	}

	public OnboardingDTO setBusinessName(String businessName) {
		this.businessName = businessName;
		return this;
	}

	public String getOtpType() {
		return otpType;
	}

	public OnboardingDTO setOtpType(String otpType) {
		this.otpType = otpType;
		return this;
	}

	public String getRegistrationSource() {
		return registrationSource;
	}

	public OnboardingDTO setRegistrationSource(String registrationSource) {
		this.registrationSource = registrationSource;
		return this;
	}

	public int getCurrentStep() {
		return currentStep;
	}

	public OnboardingDTO setCurrentStep(int currentStep) {
		this.currentStep = currentStep;
		return this;
	}

	public String getUsageOfClickship() {
		return usageOfClickship;
	}

	public OnboardingDTO setUsageOfClickship(String usageOfClickship) {
		this.usageOfClickship = usageOfClickship;
		return this;
	}

	public String getKindOfPackage() {
		return kindOfPackage;
	}

	public OnboardingDTO setKindOfPackage(String kindOfPackage) {
		this.kindOfPackage = kindOfPackage;
		return this;
	}

	public String getMonthlyShipments() {
		return monthlyShipments;
	}

	public OnboardingDTO setMonthlyShipments(String monthlyShipments) {
		this.monthlyShipments = monthlyShipments;
		return this;
	}

	public String getMarketplaces() {
		return marketplaces;
	}

	public OnboardingDTO setMarketplaces(String marketplaces) {
		this.marketplaces = marketplaces;
		return this;
	}

	public String getOtherMarketplaces() {
		return otherMarketplaces;
	}

	public OnboardingDTO setOtherMarketplaces(String otherMarketplaces) {
		this.otherMarketplaces = otherMarketplaces;
		return this;
	}

	public String getKindOfProducts() {
		return kindOfProducts;
	}

	public OnboardingDTO setKindOfProducts(String kindOfProducts) {
		this.kindOfProducts = kindOfProducts;
		return this;
	}

	public String getCarriers() {
		return carriers;
	}

	public OnboardingDTO setCarriers(String carriers) {
		this.carriers = carriers;
		return this;
	}

	public String getOtherCarriers() {
		return otherCarriers;
	}

	public OnboardingDTO setOtherCarriers(String otherCarriers) {
		this.otherCarriers = otherCarriers;
		return this;
	}

	public String getHasAccounts() {
		return hasAccounts;
	}

	public OnboardingDTO setHasAccounts(String hasAccounts) {
		this.hasAccounts = hasAccounts;
		return this;
	}

	public String getHowKnowUs() {
		return howKnowUs;
	}

	public OnboardingDTO setHowKnowUs(String howKnowUs) {
		this.howKnowUs = howKnowUs;
		return this;
	}

	public String getOtherHowKnowUs() {
		return otherHowKnowUs;
	}

	public OnboardingDTO setOtherHowKnowUs(String otherHowKnowUs) {
		this.otherHowKnowUs = otherHowKnowUs;
		return this;
	}

	public String getPromoCode() {
		return promoCode;
	}

	public OnboardingDTO setPromoCode(String promoCode) {
		this.promoCode = promoCode;
		return this;
	}

	public boolean isOptInForEmails() {
		return optInForEmails;
	}

	public OnboardingDTO setOptInForEmails(boolean optInForEmails) {
		this.optInForEmails = optInForEmails;
		return this;
	}

	public boolean isCompleted() {
		return completed;
	}

	public OnboardingDTO setCompleted(boolean completed) {
		this.completed = completed;
		return this;
	}

	public long getVerificationCodeRemainedTime() {
		return verificationCodeRemainedTime;
	}

	public OnboardingDTO setVerificationCodeRemainedTime(long verificationCodeRemainedTime) {
		this.verificationCodeRemainedTime = verificationCodeRemainedTime;
		return this;
	}

	public boolean isEmptyVendastaRequest() {
		return emptyVendastaRequest;
	}

	public OnboardingDTO setEmptyVendastaRequest(boolean emptyVendastaRequest) {
		this.emptyVendastaRequest = emptyVendastaRequest;
		return this;
	}

	public String getAddress1() {
		return address1;
	}

	public OnboardingDTO setAddress1(String address1) {
		this.address1 = address1;
		return this;
	}

	public String getAddress2() {
		return address2;
	}

	public OnboardingDTO setAddress2(String address2) {
		this.address2 = address2;
		return this;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public OnboardingDTO setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		return this;
	}

	public String getCity() {
		return city;
	}

	public OnboardingDTO setCity(String city) {
		this.city = city;
		return this;
	}

	public String getProvinceState() {
		return provinceState;
	}

	public OnboardingDTO setProvinceState(String provinceState) {
		this.provinceState = provinceState;
		return this;
	}

	public String getCountry() {
		return country;
	}

	public OnboardingDTO setCountry(String country) {
		this.country = country;
		return this;
	}
	
	public String getAddress() {
		return String.format("%s %s", address1, address2);
	}
	
	public String getContactName() {
		return firstName + " " + lastName;
	}

	public String getPlan() {
		return plan;
	}

	public OnboardingDTO setPlan(String plan) {
		this.plan = plan;
		return this;
	}

	public boolean isFcCustomer() {
		return isFcCustomer;
	}

	public OnboardingDTO setFcCustomer(boolean isFcCustomer) {
		this.isFcCustomer = isFcCustomer;
		return this;
	}

	public String getFcBillingType() {
		return fcBillingType;
	}

	public OnboardingDTO setFcBillingType(String fcBillingType) {
		this.fcBillingType = fcBillingType;
		return this;
	}

	public String getFcUserId() {
		return fcUserId;
	}

	public OnboardingDTO setFcUserId(String fcUserId) {
		this.fcUserId = fcUserId;
		return this;
	}

	public String getFcCustomerId() {
		return fcCustomerId;
	}

	public OnboardingDTO setFcCustomerId(String fcCustomerId) {
		this.fcCustomerId = fcCustomerId;
		return this;
	}

	public String getSalesRep() {
		return salesRep;
	}

	public void setSalesRep(String salesRep) {
		this.salesRep = salesRep;
	}

	public boolean isV2Customer() {
		return isV2Customer;
	}

	public OnboardingDTO setV2Customer(boolean isV2Customer) {
		this.isV2Customer = isV2Customer;
		return this;
	}

	public String getFcPaymentMethodId() {
		return fcPaymentMethodId;
	}

	public OnboardingDTO setFcPaymentMethodId(String fcPaymentMethodId) {
		this.fcPaymentMethodId = fcPaymentMethodId;
		return this;
	}
	
}
