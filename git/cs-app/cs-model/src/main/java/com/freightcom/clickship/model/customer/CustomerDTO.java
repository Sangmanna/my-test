package com.freightcom.clickship.model.customer;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDTO extends UserDTO implements Serializable {

	private static final long serialVersionUID = -667180373798189104L;

	private String id;

	private String businessName;

	private String firstName;

	private String lastName;
	
	private String subTier;

	private String prevSubtier;

	private Date subTierChangeDatetime;

	private Date prevSubCycleDate;

	private Date nextSubCycleDate;

	private Date subCycleDate;
	
	private String email;

	private String phone;

	private String ext;
	
	private Boolean receivePromo;

	private String notes;
	
	private String avgMonthlyShip;
	
	private Boolean isAgreeTerms;
	
	private Boolean isSubscribed;
	
	private String chargebeeId;

	private String chargebeeSubscriptionId;

	private String storePreference;
	
	private String industryType;
	
	private String fcBillingType;
	
	private String registrationSource;
	
	private String shipFrequency;

	private String salesRep;

	private boolean isFcCustomer = false;

	private Integer quickQuoteCount = 5;
	
	private Boolean active = true;

	private Boolean isInactivityMailSent = false;
	
	private Boolean isDisabledMailSent = false;
	
	private Boolean phoneVerified = false;
	
	private Boolean emailVerified = false;
	
	private boolean vettingProcessCompleted = false;

	private boolean temporaryLocked = false;
	private String temporaryLockType;
	private LocalDateTime lastShipDatetime;
	private int lockCycleCount = 0;
	private Date lastUnlockDatetime;

	public String getId() {
		return id;
	}

	public CustomerDTO setId(String id) {
		this.id = id;
		return this;
	}

	public String getBusinessName() {
		return businessName;
	}

	public CustomerDTO setBusinessName(String businessName) {
		this.businessName = businessName;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public CustomerDTO setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public CustomerDTO setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getSubTier() {
		return subTier;
	}

	public CustomerDTO setSubTier(String subTier) {
		this.subTier = subTier;
		return this;
	}

	public String getPrevSubtier() {
		return prevSubtier;
	}

	public CustomerDTO setPrevSubtier(String prevSubtier) {
		this.prevSubtier = prevSubtier;
		return this;
	}

	public Date getSubTierChangeDatetime() {
		return subTierChangeDatetime;
	}

	public CustomerDTO setSubTierChangeDatetime(Date subTierChangeDatetime) {
		this.subTierChangeDatetime = subTierChangeDatetime;
		return this;
	}

	public Date getPrevSubCycleDate() {
		return prevSubCycleDate;
	}

	public CustomerDTO setPrevSubCycleDate(Date prevSubCycleDate) {
		this.prevSubCycleDate = prevSubCycleDate;
		return this;
	}

	public Date getNextSubCycleDate() {
		return nextSubCycleDate;
	}

	public CustomerDTO setNextSubCycleDate(Date nextSubCycleDate) {
		this.nextSubCycleDate = nextSubCycleDate;
		return this;
	}

	public Date getSubCycleDate() {
		return subCycleDate;
	}

	public CustomerDTO setSubCycleDate(Date subCycleDate) {
		this.subCycleDate = subCycleDate;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public CustomerDTO setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public CustomerDTO setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getExt() {
		return ext;
	}

	public CustomerDTO setExt(String ext) {
		this.ext = ext;
		return this;
	}

	public Boolean getReceivePromo() {
		return receivePromo;
	}

	public CustomerDTO setReceivePromo(Boolean receivePromo) {
		this.receivePromo = receivePromo;
		return this;
	}

	public String getNotes() {
		return notes;
	}

	public CustomerDTO setNotes(String notes) {
		this.notes = notes;
		return this;
	}

	public String getAvgMonthlyShip() {
		return avgMonthlyShip;
	}

	public CustomerDTO setAvgMonthlyShip(String avgMonthlyShip) {
		this.avgMonthlyShip = avgMonthlyShip;
		return this;
	}

	public Boolean getIsAgreeTerms() {
		return isAgreeTerms;
	}

	public CustomerDTO setIsAgreeTerms(Boolean isAgreeTerms) {
		this.isAgreeTerms = isAgreeTerms;
		return this;
	}

	public Boolean getIsSubscribed() {
		return isSubscribed;
	}

	public CustomerDTO setIsSubscribed(Boolean isSubscribed) {
		this.isSubscribed = isSubscribed;
		return this;
	}

	public String getChargebeeId() {
		return chargebeeId;
	}

	public CustomerDTO setChargebeeId(String chargebeeId) {
		this.chargebeeId = chargebeeId;
		return this;
	}

	public String getChargebeeSubscriptionId() {
		return chargebeeSubscriptionId;
	}

	public CustomerDTO setChargebeeSubscriptionId(String chargebeeSubscriptionId) {
		this.chargebeeSubscriptionId = chargebeeSubscriptionId;
		return this;
	}

	public String getStorePreference() {
		return storePreference;
	}

	public CustomerDTO setStorePreference(String storePreference) {
		this.storePreference = storePreference;
		return this;
	}

	public String getIndustryType() {
		return industryType;
	}

	public CustomerDTO setIndustryType(String industryType) {
		this.industryType = industryType;
		return this;
	}

	public String getFcBillingType() {
		return fcBillingType;
	}

	public CustomerDTO setFcBillingType(String fcBillingType) {
		this.fcBillingType = fcBillingType;
		return this;
	}
	
	public String getRegistrationSource() {
		return registrationSource;
	}

	public CustomerDTO setRegistrationSource(String registrationSource) {
		this.registrationSource = registrationSource;
		return this;
	}

	public String getShipFrequency() {
		return shipFrequency;
	}

	public CustomerDTO setShipFrequency(String shipFrequency) {
		this.shipFrequency = shipFrequency;
		return this;
	}

	public String getSalesRep() {
		return salesRep;
	}

	public CustomerDTO setSalesRep(String salesRep) {
		this.salesRep = salesRep;
		return this;
	}

	public boolean isFcCustomer() {
		return isFcCustomer;
	}

	public CustomerDTO setFcCustomer(boolean isFcCustomer) {
		this.isFcCustomer = isFcCustomer;
		return this;
	}

	public Integer getQuickQuoteCount() {
		return quickQuoteCount;
	}

	public CustomerDTO setQuickQuoteCount(Integer quickQuoteCount) {
		this.quickQuoteCount = quickQuoteCount;
		return this;
	}

	public Boolean getActive() {
		return active;
	}

	public CustomerDTO setActive(Boolean active) {
		this.active = active;
		return this;
	}

	public Boolean getIsInactivityMailSent() {
		return isInactivityMailSent;
	}

	public CustomerDTO setIsInactivityMailSent(Boolean isInactivityMailSent) {
		this.isInactivityMailSent = isInactivityMailSent;
		return this;
	}

	public Boolean getIsDisabledMailSent() {
		return isDisabledMailSent;
	}

	public CustomerDTO setIsDisabledMailSent(Boolean isDisabledMailSent) {
		this.isDisabledMailSent = isDisabledMailSent;
		return this;
	}
	
	public String getContactName() {
		return firstName + " " + lastName;
	}

	public Boolean getPhoneVerified() {
		return phoneVerified;
	}

	public void setPhoneVerified(Boolean phoneVerified) {
		this.phoneVerified = phoneVerified;
	}

	public Boolean getEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(Boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public boolean isVettingProcessCompleted() {
		return vettingProcessCompleted;
	}

	public void setVettingProcessCompleted(boolean vettingProcessCompleted) {
		this.vettingProcessCompleted = vettingProcessCompleted;
	}

	public boolean isTemporaryLocked() {
		return temporaryLocked;
	}

	public void setTemporaryLocked(boolean temporaryLocked) {
		this.temporaryLocked = temporaryLocked;
	}

	public String getTemporaryLockType() {
		return temporaryLockType;
	}

	public void setTemporaryLockType(String temporaryLockType) {
		this.temporaryLockType = temporaryLockType;
	}

	public LocalDateTime getLastShipDatetime() {
		return lastShipDatetime;
	}

	public void setLastShipDatetime(LocalDateTime lastShipDatetime) {
		this.lastShipDatetime = lastShipDatetime;
	}

	public int getLockCycleCount() {
		return lockCycleCount;
	}

	public void setLockCycleCount(int lockCycleCount) {
		this.lockCycleCount = lockCycleCount;
	}

	public Date getLastUnlockDatetime() {
		return lastUnlockDatetime;
	}

	public void setLastUnlockDatetime(Date lastUnlockDatetime) {
		this.lastUnlockDatetime = lastUnlockDatetime;
	}
}
