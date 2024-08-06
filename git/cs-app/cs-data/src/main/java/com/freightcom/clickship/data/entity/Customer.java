package com.freightcom.clickship.data.entity;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.GenericGenerator;

import com.freightcom.clickship.data.entity.common.BaseEntity;
import com.freightcom.clickship.model.util.ClickshipStringUtil;

@Entity
@Table(name = "customer")
public class Customer extends BaseEntity {
	
	private static final long serialVersionUID = 5262679541836881146L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@Column(name = "business_name", nullable = false)
	private String businessName;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "sub_tier")
	private String subTier;

	@Column(name = "prev_sub_tier")
	private String prevSubtier;

	@Column(name = "sub_tier_change_datetime")
	private Date subTierChangeDatetime;

	@Column(name = "prev_sub_cycle_date")
	private Date prevSubCycleDate;

	@Column(name = "next_sub_cycle_date")
	private Date nextSubCycleDate;

	@Column(name = "sub_cycle_date")
	private Date subCycleDate;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;

	@Column(name = "ext")
	private String ext;

	@Column(name = "receive_promo")
	private Boolean receivePromo;

	@Column(name = "notes")
	private String notes;

	@Column(name = "avg_monthly_ship")
	private String avgMonthlyShip;

	@Column(name = "is_agree_terms")
	private boolean isAgreeTerms;

	@Column(name = "is_subscribed")
	private boolean isSubscribed;

	@Column(name = "chargebee_Id")
	private String chargebeeId;

	@Column(name = "chargebee_subscription_Id")
	private String chargebeeSubscriptionId;
	
	@Column(name = "chargebee_credit_card_status")
	private String chargebeeCreditCardStatus = "deleted";

	@Column(name = "subscription_status")
	private String subscriptionStatus = "Cancelled";

	@Column(name = "store_preference")
	private String storePreference;

	@Column(name = "industry_type")
	private String industryType;

	@Column(name = "fc_billing_type")
	private String fcBillingType;

	@Column(name = "registration_source")
	private String registrationSource;

	@Column(name = "advanced_shipping_rule_active")
	private boolean advancedShippingRuleActive = false;
	
	@Column(name = "advanced_shipping_rule_pallet_active")
	private boolean advancedShippingRulePalletActive = false;

	@Column(name = "advanced_shipping_rule_trial_used")
	private boolean advancedShippingRuleTrialUsed = false;
	
	@Column(name = "advanced_shipping_rule_trial_end_datetime")
	private Date advancedShippingRuleTrialEndDatetime;
	
	@Column(name = "vetting_process_completed")
	private boolean vettingProcessCompleted;

	/**
	 * @deprecated replaced with new onboarding table
	 */
	@Column(name = "onboarding_complete")
	private Boolean onboardingComplete = false;

	@Column(name = "ship_frequency")
	private String shipFrequency;

	@Column(name = "sales_rep")
	private String salesRep;
	
	@Column(name = "is_fc_customer")
	private boolean isFcCustomer = false;

	@Column(name = "quick_quote_count")
	private Integer quickQuoteCount = 5;
	
	@Column(name = "active")
	private Boolean active = true;

	@Column(name = "is_inactivity_mail_sent")
	private Boolean isInactivityMailSent = false;
	
	@Column(name = "is_disabled_mail_sent")
	private Boolean isDisabledMailSent = false;

	@Column(name = "has_custom_branding")
	private boolean hasCustomBranding = false;
	
	@Column(name = "fc_customer_id")
	private String fcCustomerId;
	
	@Column(name = "custom_branding_trial_used")
	private boolean customBrandingTrialUsed;
	
	@Column(name = "fc_payment_method_id")
	private String fcPaymentMethodId;
	
	@Column(name = "phone_verified")
	private Boolean phoneVerified = false;
	
	@Column(name = "email_verified")
	private Boolean emailVerified = false;
	
	@Column(name = "phone_international_dial_number")
	private String phoneInternationalDialNumber;
	
	@Column(name = "phone_country_code")
	private String phoneCountryCode;
	
	@Column(name = "quote_used_without_credit_card", nullable = false)
	private int quoteUsedWithoutCreditCard = 0;
	
	@Column(name = "free_quote_exceed_notify_email_sent", nullable = false)
	private boolean freeQuoteExceedNotifyEmailSent = false;
	
	/**
	 * The field indicates that the customer's advanced shipping rule addon has been deactivated due to the invalid card status in Chargebee
	 */
	@Column(name = "advanced_shipping_rule_deactivated")
	private boolean advancedShippingRuleDeactivated;

	@Column(name = "temporary_locked", nullable = false)
	private boolean temporaryLocked = false;
	
	@Column(name = "temporary_lock_type")
	private String temporaryLockType;
	
	@Column(name = "last_ship_datetime")
	private LocalDateTime lastShipDatetime;
	
	@Column(name = "lock_cycle_count", nullable = false)
	private int lockCycleCount = 0;
	
	@Column(name = "last_unlock_datetime")
    private Date lastUnlockDatetime;
	
	
	public Customer() {
		super();
	}
	
	public Customer(String id, String chargebeeId, String chargebeeSubscriptionId) {
		super();
		this.id = id;
		this.chargebeeId = chargebeeId;
		this.chargebeeSubscriptionId = chargebeeSubscriptionId;
	}

	public Customer(String id, String chargebeeId, String chargebeeSubscriptionId, String subTier) {
		super();
		this.id = id;
		this.chargebeeId = chargebeeId;
		this.chargebeeSubscriptionId = chargebeeSubscriptionId;
		this.subTier = subTier;
	}

	public String getId() {
		return id;
	}

	public Customer setId(String id) {
		this.id = id;
		return this;
	}

	public String getBusinessName() {
		return businessName;
	}

	public Customer setBusinessName(String businessName) {
		this.businessName = ClickshipStringUtil.getStringStripAccents(businessName);
		return this;
	}

	public boolean isAgreeTerms() {
		return isAgreeTerms;
	}

	public Customer setAgreeTerms(boolean isAgreeTerms) {
		this.isAgreeTerms = isAgreeTerms;
		return this;
	}

	public boolean isSubscribed() {
		return isSubscribed;
	}

	public Customer setSubscribed(boolean isSubscribed) {
		this.isSubscribed = isSubscribed;
		return this;
	}

	public String getSubTier() {
		return subTier;
	}

	public String getFirstName() {
		return firstName;
	}

	public Customer setFirstName(String firstName) {
		this.firstName = ClickshipStringUtil.getStringStripAccents(firstName);
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public Customer setLastName(String lastName) {
		this.lastName = ClickshipStringUtil.getStringStripAccents(lastName);
		return this;
	}

	public Customer setSubTier(String subTier) {
		this.subTier = subTier;
		return this;
	}

	public String getPrevSubtier() {
		return prevSubtier;
	}

	public Customer setPrevSubtier(String prevSubtier) {
		this.prevSubtier = prevSubtier;
		return this;
	}

	public Date getSubTierChangeDatetime() {
		return subTierChangeDatetime;
	}

	public Customer setSubTierChangeDatetime(Date subTierChangeDatetime) {
		this.subTierChangeDatetime = subTierChangeDatetime;
		return this;
	}

	public Date getPrevSubCycleDate() {
		return prevSubCycleDate;
	}

	public Customer setPrevSubCycleDate(Date prevSubCycleDate) {
		this.prevSubCycleDate = prevSubCycleDate;
		return this;
	}

	public Date getNextSubCycleDate() {
		return nextSubCycleDate;
	}

	public Customer setNextSubCycleDate(Date nextSubCycleDate) {
		this.nextSubCycleDate = nextSubCycleDate;
		return this;
	}

	public Date getSubCycleDate() {
		return subCycleDate;
	}

	public Customer setSubCycleDate(Date subCycleDate) {
		this.subCycleDate = subCycleDate;
		return this;
	}

	public String getContactName() {
		String name = null;

		if (StringUtils.isNotBlank(firstName)) {
			name = firstName;
		}

		if (StringUtils.isNotBlank(lastName)) {
			name = name == null ? lastName : name + " " + lastName;
		}

		return name;
	}

	public String getEmail() {
		return email;
	}

	public Customer setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public Customer setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getExt() {
		return ext;
	}

	public Customer setExt(String ext) {
		this.ext = ext;
		return this;
	}

	public Boolean getReceivePromo() {
		return receivePromo;
	}

	public Customer setReceivePromo(Boolean receivePromo) {
		this.receivePromo = receivePromo;
		return this;
	}

	public String getNotes() {
		return notes;
	}

	public Customer setNotes(String notes) {
		this.notes = notes;
		return this;
	}

	public String getAvgMonthlyShip() {
		return avgMonthlyShip;
	}

	public Customer setAvgMonthlyShip(String avgMonthlyShip) {
		this.avgMonthlyShip = avgMonthlyShip;
		return this;
	}

	public String getChargebeeId() {
		return chargebeeId;
	}

	public Customer setChargebeeId(String chargebeeId) {
		this.chargebeeId = chargebeeId;
		return this;
	}

	public String getChargebeeSubscriptionId() {
		return chargebeeSubscriptionId;
	}

	public Customer setChargebeeSubscriptionId(String chargebeeSubscriptionId) {
		this.chargebeeSubscriptionId = chargebeeSubscriptionId;
		return this;
	}

	public String getStorePreference() {
		return storePreference;
	}

	public Customer setStorePreference(String storePreference) {
		this.storePreference = storePreference;
		return this;
	}

	public String getIndustryType() {
		return industryType;
	}

	public Customer setIndustryType(String industryType) {
		this.industryType = industryType;
		return this;
	}

	public String getFcBillingType() {
		return fcBillingType;
	}

	public Customer setFcBillingType(String fcBillingType) {
		this.fcBillingType = fcBillingType;
		return this;
	}

	public String getRegistrationSource() {
		return registrationSource;
	}

	public Customer setRegistrationSource(String registrationSource) {
		this.registrationSource = registrationSource;
		return this;
	}

	public String getShipFrequency() {
		return shipFrequency;
	}

	public Customer setShipFrequency(String shipFrequency) {
		this.shipFrequency = shipFrequency;
		return this;
	}

	public String getSalesRep() {
		return salesRep;
	}

	public Customer setSalesRep(String salesRep) {
		this.salesRep = salesRep;
		return this;
	}

	public boolean isFcCustomer() {
		return isFcCustomer;
	}

	public Customer setFcCustomer(boolean isFcCustomer) {
		this.isFcCustomer = isFcCustomer;
		return this;
	}

	public Integer getQuickQuoteCount() {
		return quickQuoteCount;
	}

	public Customer setQuickQuoteCount(Integer quickQuoteCount) {
		this.quickQuoteCount = quickQuoteCount;
		return this;
	}

	public Boolean getActive() {
		return active;
	}

	public Customer setActive(Boolean active) {
		this.active = active;
		return this;
	}

	public Boolean getIsInactivityMailSent() {
		return isInactivityMailSent;
	}

	public Customer setIsInactivityMailSent(Boolean isInactivityMailSent) {
		this.isInactivityMailSent = isInactivityMailSent;
		return this;
	}

	public Boolean getIsDisabledMailSent() {
		return isDisabledMailSent;
	}

	public Customer setIsDisabledMailSent(Boolean isDisabledMailSent) {
		this.isDisabledMailSent = isDisabledMailSent;
		return this;
	}

	public String getChargebeeCreditCardStatus() {
		return chargebeeCreditCardStatus;
	}

	public Customer setChargebeeCreditCardStatus(String chargebeeCreditCardStatus) {
		this.chargebeeCreditCardStatus = chargebeeCreditCardStatus;
		return this;
	}

	public String getSubscriptionStatus() {
		return subscriptionStatus;
	}

	public Customer setSubscriptionStatus(String subscriptionStatus) {
		this.subscriptionStatus = subscriptionStatus;
		return this;
	}

	public boolean hasCustomBranding() {
		return hasCustomBranding;
	}

	public Customer setHasCustomBranding(boolean hasCustomBranding) {
		this.hasCustomBranding = hasCustomBranding;
		return this;
	}
	
	public String getFcCustomerId() {
		return fcCustomerId;
	}

	public Customer setFcCustomerId(String fcCustomerId) {
		this.fcCustomerId = fcCustomerId;
		return this;
	}

	public boolean isCustomBrandingTrialUsed() {
		return customBrandingTrialUsed;
	}

	public Customer setCustomBrandingTrialUsed(boolean customBrandingTrialUsed) {
		this.customBrandingTrialUsed = customBrandingTrialUsed;
		return this;
	}

	public String getFcPaymentMethodId() {
		return fcPaymentMethodId;
	}

	public Customer setFcPaymentMethodId(String fcPaymentMethodId) {
		this.fcPaymentMethodId = fcPaymentMethodId;
		return this;
	}

	public Boolean getOnboardingComplete() {
		return onboardingComplete;
	}

	public Customer setOnboardingComplete(Boolean onboardingComplete) {
		this.onboardingComplete = onboardingComplete;
		return this;
	}

	public Boolean getPhoneVerified() {
		return phoneVerified;
	}

	public Customer setPhoneVerified(Boolean phoneVerified) {
		this.phoneVerified = phoneVerified;
		return this;
	}

	public Boolean getEmailVerified() {
		return emailVerified;
	}

	public Customer setEmailVerified(Boolean emailVerified) {
		this.emailVerified = emailVerified;
		return this;
	}

	public String getPhoneInternationalDialNumber() {
		return phoneInternationalDialNumber;
	}

	public Customer setPhoneInternationalDialNumber(String phoneInternationalDialNumber) {
		this.phoneInternationalDialNumber = phoneInternationalDialNumber;
		return this;
	}

	public String getPhoneCountryCode() {
		return phoneCountryCode;
	}

	public Customer setPhoneCountryCode(String phoneCountryCode) {
		this.phoneCountryCode = phoneCountryCode;
		return this;
	}
	
	public int getQuoteUsedWithoutCreditCard() {
		return quoteUsedWithoutCreditCard;
	}

	public Customer setQuoteUsedWithoutCreditCard(int quoteUsedWithoutCreditCard) {
		this.quoteUsedWithoutCreditCard = quoteUsedWithoutCreditCard;
		return this;
	}

	public boolean isAdvancedShippingRuleActive() {
		return advancedShippingRuleActive;
	}

	public void setAdvancedShippingRuleActive(boolean advancedShippingRuleActive) {
		this.advancedShippingRuleActive = advancedShippingRuleActive;
	}

	public boolean isAdvancedShippingRulePalletActive() {
		return advancedShippingRulePalletActive;
	}

	public void setAdvancedShippingRulePalletActive(boolean advancedShippingRulePalletActive) {
		this.advancedShippingRulePalletActive = advancedShippingRulePalletActive;
	}

	public boolean isAdvancedShippingRuleTrialUsed() {
		return advancedShippingRuleTrialUsed;
	}

	public void setAdvancedShippingRuleTrialUsed(boolean advancedShippingRuleTrialUsed) {
		this.advancedShippingRuleTrialUsed = advancedShippingRuleTrialUsed;
	}

	public Date getAdvancedShippingRuleTrialEndDatetime() {
		return advancedShippingRuleTrialEndDatetime;
	}

	public void setAdvancedShippingRuleTrialEndDatetime(Date advancedShippingRuleTrialEndDatetime) {
		this.advancedShippingRuleTrialEndDatetime = advancedShippingRuleTrialEndDatetime;
	}

	public boolean getAdvancedShippingRuleDeactivated() {
		return advancedShippingRuleDeactivated;
	}

	public void setAdvancedShippingRuleDeactivated(boolean advancedShippingRuleDeactivated) {
		this.advancedShippingRuleDeactivated = advancedShippingRuleDeactivated;
	}

	public boolean isVettingProcessCompleted() {
		return vettingProcessCompleted;
	}

	public void setVettingProcessCompleted(boolean vettingProcessCompleted) {
		this.vettingProcessCompleted = vettingProcessCompleted;
	}

	public boolean isFreeQuoteExceedNotifyEmailSent() {
		return freeQuoteExceedNotifyEmailSent;
	}

	public void setFreeQuoteExceedNotifyEmailSent(boolean freeQuoteExceedNotifyEmailSent) {
		this.freeQuoteExceedNotifyEmailSent = freeQuoteExceedNotifyEmailSent;
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
