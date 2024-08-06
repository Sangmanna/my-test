package com.freightcom.clickship.data.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "customer_preferences")
public class CustomerPreferences extends BaseEntity {

	private static final long serialVersionUID = -8104571383884082392L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", nullable = false, updatable = false)
	@JsonIgnore
	private Customer customer;

	@Column(name = "pickup_location")
	private String pickupLocation;

	@Column(name = "pickup_time")
	private String pickupTime;

	@Column(name = "closing_time")
	private String closingTime;

	@Column(name = "branding_image_url")
	private String brandingImageUrl;

	@Column(name = "logo_enabled")
	private boolean logoEnabled;

	@Column(name = "apply_to_email")
	private boolean applyToEmail;

	@Column(name = "apply_to_packing_slips")
	private boolean applyToPackingSlips;

	@Column(name = "apply_to_labels")
	private boolean applyToLabels;

	@Column(name = "email_settings_enabled")
	private boolean emailSettingsEnabled;

	@Column(name = "email_subject")
	private String emailSubject;

	@Column(name = "email_headline")
	private String emailHeadline;

	@Column(name = "email_message")
	private String emailMessage;

	@Column(name = "instagram_handle")
	private String instagramHandle;

	@Column(name = "facebook_handle")
	private String facebookHandle;

	@Column(name = "twitter_handle")
	private String twitterHandle;

	@Column(name = "linkedin_handle")
	private String linkedinHandle;

	@Column(name = "is_card_disclaimer_accepted")
	private boolean isCardDisclaimerAccepted = false;

	@Column(name = "new_carrier_requested")
	private String newCarrierRequested;

	@Column(name = "show_return_order_confirmation")
	private boolean showReturnOrderConfirmation = true;

	@Column(name = "show_duplicate_order_confirmation")
	private boolean showDuplicateOrderConfirmation = true;
	
	@Column(name = "default_page_on_login")
	private String defaultPageOnLogin = "Dashboard";
	
	@Column(name = "language")
	private String language = "en"; 
	
	@Column(name = "default_package_address_id")
	private String defaultPackageAddressId;
	
	@Column(name = "default_pallet_address_id")
	private String defaultPalletAddressId;
	
	@Column(name = "shipper_tax_id")
	private String shipperTaxId;
	
	@Column(name = "show_bulk_shipping")
	private boolean showBulkShipping = false;
	
	@Column(name = "bulk_shipping_preference")
	private String bulkShippingPreference = "V1";

	@Column(name = "manual_shipment_preference")
	private String manualShipmentPreference = "V1";

	@Column(name = "manual_shipment_switch_feedback")
	private String manualShipmentSwitchFeedback = "V1";

	@Column(name = "ltl_for_realtimerates")
	private boolean ltlForRealtimerates = false;

	@Column(name = "shipto_phone")
	private String shiptoPhone;

	@Column(name = "shipto_ext")
	private String shiptoExt;

	@Column(name = "shipto_email")
	private String shiptoEmail;

	@Column(name = "agree_shipto_terms")
	private boolean agreeShiptoTerms = false;

	@Column(name = "broker_name")
	private String brokerName;

	@Column(name = "broker_phone")
	private String brokerPhone;

	@Column(name = "broker_email")
	private String brokerEmail;

	@Column(name = "agree_broker_info")
	private boolean agreeBrokerInfo = false;

	@Column(name = "show_midland")
	private boolean showMidland;

	@Column(name = "show_ups")
	private boolean showUps;
	
	@Column(name = "show_canpar")
	private boolean showCanpar;
	
	@Column(name = "show_bigcommerce")
	private boolean showBigCommerce = false;
	
	@Column(name = "fc_api_preference")
	private String fcApiPreference = "V1";
	
	@Column(name = "fc_rtr_api_preference")
	private String fcRrtAPIPreference = "V1";
	
	@Column(name = "fc_pallet_api_preference")
	private String fcPalletAPIPreference = "V1";
	
	@Column(name = "amazon_app_id")
	private String amazonApiId;
	
	@Column(name = "amazon_client_id")
	private String amazonClientId;
	
	@Column(name = "amazon_secret")
	private String amazonApiSecret;

	@Column(name = "page_size")
	private Integer pageSize = 20;
	
	@Column(name = "reference_codes")
	private String referenceCodes;
	
	@Column(name = "reference_codes_others")
	private String referenceCodeOthers;

	@Column(name = "show_ship_it_close_pop_up")
	private Boolean showShipItClosePopUp = false;
	
	@Column(name = "allow_restricted_shipping")
	private boolean allowRestrictedShipping = false;
	
	@Column(name = "auto_fetch_rates")
	private boolean autoFetchRates = false;
	
	@Column(name = "sba_version")
	private String sbaVersion = "Basic";
	
	@OneToOne(mappedBy = "customerPreferences", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private PrintingPreference printingPreference;
	
	@Column(name = "user_roles_limit")
	private Integer userRolesLimit = 4;
	
	@Column(name = "own_carrier_bulk_shipping")
	private boolean ownCarrierBulkShipping = true;
	
	@Column(name = "switch_to_side_menu")
	private boolean switchToSideMenu = true;
	
	@Column(name = "subscription_billing_channel")
	private String subscriptionBillingChannel = "ChargeBee";

	@Column(name = "wix_order_api_preference")
	private String wixOrderApiPreference = "ecom";
	
	@Column(name = "enable_carrier_customs_broker")
	private boolean enableCarrierCustomsBroker = false;
	
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

	public CustomerPreferences setCustomer(Customer customer) {
		this.customer = customer;
		return this;
	}

	public String getPickupLocation() {
		return pickupLocation;
	}

	public CustomerPreferences setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
		return this;
	}

	public String getPickupTime() {
		return pickupTime;
	}

	public CustomerPreferences setPickupTime(String pickupTime) {
		this.pickupTime = pickupTime;
		return this;
	}

	public String getClosingTime() {
		return closingTime;
	}

	public CustomerPreferences setClosingTime(String closingTime) {
		this.closingTime = closingTime;
		return this;
	}

	public String getBrandingImageUrl() {
		return brandingImageUrl;
	}

	public CustomerPreferences setBrandingImageUrl(String brandingImageUrl) {
		this.brandingImageUrl = brandingImageUrl;
		return this;
	}

	public boolean isLogoEnabled() {
		return logoEnabled;
	}

	public CustomerPreferences setLogoEnabled(boolean logoEnabled) {
		this.logoEnabled = logoEnabled;
		return this;
	}

	public boolean isApplyToEmail() {
		return applyToEmail;
	}

	public CustomerPreferences setApplyToEmail(boolean applyToEmail) {
		this.applyToEmail = applyToEmail;
		return this;
	}

	public boolean isApplyToPackingSlips() {
		return applyToPackingSlips;
	}

	public CustomerPreferences setApplyToPackingSlips(boolean applyToPackingSlips) {
		this.applyToPackingSlips = applyToPackingSlips;
		return this;
	}

	public boolean isApplyToLabels() {
		return applyToLabels;
	}

	public CustomerPreferences setApplyToLabels(boolean applyToLabels) {
		this.applyToLabels = applyToLabels;
		return this;
	}

	public boolean isEmailSettingsEnabled() {
		return emailSettingsEnabled;
	}

	public CustomerPreferences setEmailSettingsEnabled(boolean emailSettingsEnabled) {
		this.emailSettingsEnabled = emailSettingsEnabled;
		return this;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public CustomerPreferences setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
		return this;
	}

	public String getEmailHeadline() {
		return emailHeadline;
	}

	public CustomerPreferences setEmailHeadline(String emailHeadline) {
		this.emailHeadline = emailHeadline;
		return this;
	}

	public String getEmailMessage() {
		return emailMessage;
	}

	public CustomerPreferences setEmailMessage(String emailMessage) {
		this.emailMessage = emailMessage;
		return this;
	}

	public String getInstagramHandle() {
		return instagramHandle;
	}

	public CustomerPreferences setInstagramHandle(String instagramHandle) {
		this.instagramHandle = instagramHandle;
		return this;
	}

	public String getFacebookHandle() {
		return facebookHandle;
	}

	public CustomerPreferences setFacebookHandle(String facebookHandle) {
		this.facebookHandle = facebookHandle;
		return this;
	}

	public String getTwitterHandle() {
		return twitterHandle;
	}

	public CustomerPreferences setTwitterHandle(String twitterHandle) {
		this.twitterHandle = twitterHandle;
		return this;
	}

	public String getLinkedinHandle() {
		return linkedinHandle;
	}

	public CustomerPreferences setLinkedinHandle(String linkedinHandle) {
		this.linkedinHandle = linkedinHandle;
		return this;
	}

	public boolean isCardDisclaimerAccepted() {
		return isCardDisclaimerAccepted;
	}

	public CustomerPreferences setCardDisclaimerAccepted(boolean isCardDisclaimerAccepted) {
		this.isCardDisclaimerAccepted = isCardDisclaimerAccepted;
		return this;
	}

	public String getNewCarrierRequested() {
		return newCarrierRequested;
	}

	public CustomerPreferences setNewCarrierRequested(String newCarrierRequested) {
		this.newCarrierRequested = newCarrierRequested;
		return this;
	}

	public boolean isShowReturnOrderConfirmation() {
		return showReturnOrderConfirmation;
	}

	public CustomerPreferences setShowReturnOrderConfirmation(boolean showReturnOrderConfirmation) {
		this.showReturnOrderConfirmation = showReturnOrderConfirmation;
		return this;
	}

	public boolean isShowDuplicateOrderConfirmation() {
		return showDuplicateOrderConfirmation;
	}

	public CustomerPreferences setShowDuplicateOrderConfirmation(boolean showDuplicateOrderConfirmation) {
		this.showDuplicateOrderConfirmation = showDuplicateOrderConfirmation;
		return this;
	}

	public boolean isShowBulkShipping() {
		return showBulkShipping;
	}

	public CustomerPreferences setShowBulkShipping(boolean showBulkShipping) {
		this.showBulkShipping = showBulkShipping;
		return this;
	}
	
	public String getBulkShippingPreference() {
		return bulkShippingPreference;
	}

	public CustomerPreferences setBulkShippingPreference(String bulkShippingPreference) {
		this.bulkShippingPreference = bulkShippingPreference;
		return this;
	}

	public boolean isLtlForRealtimerates() {
		return ltlForRealtimerates;
	}

	public CustomerPreferences setLtlForRealtimerates(boolean ltlForRealtimerates) {
		this.ltlForRealtimerates = ltlForRealtimerates;
		return this;
	}

	public String getShiptoPhone() {
		return shiptoPhone;
	}

	public CustomerPreferences setShiptoPhone(String shiptoPhone) {
		this.shiptoPhone = shiptoPhone;
		return this;
	}

	public String getShiptoExt() {
		return shiptoExt;
	}

	public CustomerPreferences setShiptoExt(String shiptoExt) {
		this.shiptoExt = shiptoExt;
		return this;
	}

	public String getShiptoEmail() {
		return shiptoEmail;
	}

	public CustomerPreferences setShiptoEmail(String shiptoEmail) {
		this.shiptoEmail = shiptoEmail;
		return this;
	}

	public boolean isAgreeShiptoTerms() {
		return agreeShiptoTerms;
	}

	public CustomerPreferences setAgreeShiptoTerms(boolean agreeShiptoTerms) {
		this.agreeShiptoTerms = agreeShiptoTerms;
		return this;
	}

	public String getBrokerName() {
		return brokerName;
	}

	public CustomerPreferences setBrokerName(String brokerName) {
		this.brokerName = brokerName;
		return this;
	}

	public String getBrokerPhone() {
		return brokerPhone;
	}

	public CustomerPreferences setBrokerPhone(String brokerPhone) {
		this.brokerPhone = brokerPhone;
		return this;
	}

	public String getBrokerEmail() {
		return brokerEmail;
	}

	public CustomerPreferences setBrokerEmail(String brokerEmail) {
		this.brokerEmail = brokerEmail;
		return this;
	}

	public boolean isAgreeBrokerInfo() {
		return agreeBrokerInfo;
	}

	public CustomerPreferences setAgreeBrokerInfo(boolean agreeBrokerInfo) {
		this.agreeBrokerInfo = agreeBrokerInfo;
		return this;
	}

	public boolean isShowMidland() {
		return showMidland;
	}

	public CustomerPreferences setShowMidland(boolean showMidland) {
		this.showMidland = showMidland;
		return this;
	}

	public boolean isShowBigCommerce() {
		return showBigCommerce;
	}

	public CustomerPreferences setShowBigCommerce(boolean showBigCommerce) {
		this.showBigCommerce = showBigCommerce;
		return this;
	}

	public String getFcApiPreference() {
		return fcApiPreference;
	}

	public void setFcApiPreference(String fcApiPreference) {
		this.fcApiPreference = fcApiPreference;
	}

	public String getFcRrtAPIPreference() {
		return fcRrtAPIPreference;
	}

	public void setFcRrtAPIPreference(String fcRrtAPIPreference) {
		this.fcRrtAPIPreference = fcRrtAPIPreference;
	}

	public String getAmazonApiId() {
		return amazonApiId;
	}

	public void setAmazonApiId(String amazonApiId) {
		this.amazonApiId = amazonApiId;
	}

	public String getAmazonClientId() {
		return amazonClientId;
	}

	public void setAmazonClientId(String amazonClientId) {
		this.amazonClientId = amazonClientId;
	}

	public String getAmazonApiSecret() {
		return amazonApiSecret;
	}

	public void setAmazonApiSecret(String amazonApiSecret) {
		this.amazonApiSecret = amazonApiSecret;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public CustomerPreferences setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
		return this;
	}

	public String getReferenceCodes() {
		return referenceCodes;
	}

	public void setReferenceCodes(String referenceCodes) {
		this.referenceCodes = referenceCodes;
	}

	public String getReferenceCodeOthers() {
		return referenceCodeOthers;
	}

	public void setReferenceCodeOthers(String referenceCodeOthers) {
		this.referenceCodeOthers = referenceCodeOthers;
	}

	public String getDefaultPageOnLogin() {
		return defaultPageOnLogin;
	}

	public void setDefaultPageOnLogin(String defaultPageOnLogin) {
		this.defaultPageOnLogin = defaultPageOnLogin;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getDefaultPackageAddressId() {
		return defaultPackageAddressId;
	}

	public void setDefaultPackageAddressId(String defaultPackageAddressId) {
		this.defaultPackageAddressId = defaultPackageAddressId;
	}

	public String getDefaultPalletAddressId() {
		return defaultPalletAddressId;
	}

	public void setDefaultPalletAddressId(String defaultPalletAddressId) {
		this.defaultPalletAddressId = defaultPalletAddressId;
	}

	public String getShipperTaxId() {
		return shipperTaxId;
	}

	public void setShipperTaxId(String shipperTaxId) {
		this.shipperTaxId = shipperTaxId;
	}

	public Boolean getShowShipItClosePopUp() {
		return showShipItClosePopUp;
	}

	public CustomerPreferences setShowShipItClosePopUp(Boolean showShipItClosePopUp) {
		this.showShipItClosePopUp = showShipItClosePopUp;
		return this;
	}

	public boolean isAllowRestrictedShipping() {
		return allowRestrictedShipping;
	}

	public void setAllowRestrictedShipping(boolean allowRestrictedShipping) {
		this.allowRestrictedShipping = allowRestrictedShipping;
	}

	public boolean isShowUps() {
		return showUps;
	}

	public void setShowUps(boolean showUps) {
		this.showUps = showUps;
	}

	public boolean isShowCanpar() {
		return showCanpar;
	}

	public void setShowCanpar(boolean showCanpar) {
		this.showCanpar = showCanpar;
	}

	public boolean isAutoFetchRates() {
		return autoFetchRates;
	}

	public CustomerPreferences setAutoFetchRates(boolean autoFetchRates) {
		this.autoFetchRates = autoFetchRates;
		return this;
	}

	public String getFcPalletAPIPreference() {
		return fcPalletAPIPreference;
	}

	public CustomerPreferences setFcPalletAPIPreference(String fcPalletAPIPreference) {
		this.fcPalletAPIPreference = fcPalletAPIPreference;
		return this;
	}
	
	public String getSbaVersion() {
		return sbaVersion;
	}

	public CustomerPreferences setSbaVersion(String sbaVersion) {
		this.sbaVersion = sbaVersion;
		return this;
	}
	
	public PrintingPreference getPrintingPreference() {
		return printingPreference;
	}
	
	public void setPrintingPreference(PrintingPreference printingPreference) {
		this.printingPreference = printingPreference;
	}

	public String getManualShipmentPreference() {
		return manualShipmentPreference;
	}

	public CustomerPreferences setManualShipmentPreference(String manualShipmentPreference) {
		this.manualShipmentPreference = manualShipmentPreference;
		return this;
	}

	public String getManualShipmentSwitchFeedback() {
		return manualShipmentSwitchFeedback;
	}

	public CustomerPreferences setManualShipmentSwitchFeedback(String manualShipmentSwitchFeedback) {
		this.manualShipmentSwitchFeedback = manualShipmentSwitchFeedback;
		return this;
	}

	public Integer getUserRolesLimit() {
		return userRolesLimit;
	}

	public CustomerPreferences setUserRolesLimit(Integer userRolesLimit) {
		this.userRolesLimit = userRolesLimit;
		return this;
	}
	
	public boolean isOwnCarrierBulkShipping() {
		return ownCarrierBulkShipping;
	}

	public CustomerPreferences setOwnCarrierBulkShipping(boolean ownCarrierBulkShipping) {
		this.ownCarrierBulkShipping = ownCarrierBulkShipping;
		return this;
	}

	public String getWixOrderApiPreference() {
		return wixOrderApiPreference;
	}

	public CustomerPreferences setWixOrderApiPreference(String wixOrderApiPreference) {
		this.wixOrderApiPreference = wixOrderApiPreference;
		return this;
	}

	public boolean isSwitchToSideMenu() {
		return switchToSideMenu;
	}

	public CustomerPreferences setSwitchToSideMenu(boolean switchToSideMenu) {
		this.switchToSideMenu = switchToSideMenu;
		return this;
	}

	public String getSubscriptionBillingChannel() {
		return subscriptionBillingChannel;
	}

	public CustomerPreferences setSubscriptionBillingChannel(String subscriptionBillingChannel) {
		this.subscriptionBillingChannel = subscriptionBillingChannel;
		return this;
	}

	public boolean isEnableCarrierCustomsBroker() {
		return enableCarrierCustomsBroker;
	}

	public void setEnableCarrierCustomsBroker(boolean enableCarrierCustomsBroker) {
		this.enableCarrierCustomsBroker = enableCarrierCustomsBroker;
	}
	
}
