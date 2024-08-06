package com.freightcom.clickship.model.customer.customerpreferences;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.freightcom.clickship.model.CommonDTO;

public class CustomerPreferencesDTO extends CommonDTO implements Serializable {

	private static final long serialVersionUID = 343309016370198211L;

	private String location;
	private String pickupTime;
	private String closeTime;
	private Boolean thermalLabels;
	private Boolean showBulkShipping;
	private boolean ltlForRealtimerates;
	private Boolean isCardDisclaimerAccepted;
	private boolean showReturnOrderConfirmation;
	private boolean showDuplicateOrderConfirmation;
	private String shiptoPhone;
	private String shiptoExt;
	private String shiptoEmail;
	private boolean agreeShiptoTerms = false;
	private String brokerName;
	private String brokerPhone;
	private String brokerEmail;
	private boolean agreeBrokerInfo = false;
	private boolean showMidland;
	private boolean showUps;
	private boolean showCanpar;
	private Integer pageSize = 20;
	private String bulkShippingPreference;
	private Boolean showShipItClosePopUp = false;
	
	private String referenceCodes;
	private String referenceCodeOthers;
	
	private String defaultPageOnLogin;
	private String language;
	private String defaultPackageAddressId;
	private String defaultPalletAddressId;
	private String shipperTaxId;
	
	private String companyName;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String phoneCountryCode;
	private String phoneInternationalDialNumber;
	private String password;
	private String newPassword;
	private String otp;
	private boolean allowRestrictedShipping;
	private boolean autoFetchRates;
	private String jwtToken;	
	private String actionType;
	
	private String sbaVersion;
	private String fcApiPreference = "V1";
	
	private ShippingPreferencesDTO shippingPreferences;
	private PrintingPreferenceDTO printingPreference;
	private List<PickupPreferenceDTO> pickupPreferences;
	
	private String manualShipmentPreference = "V1";
	private String manualShipmentSwitchFeedback = "";
	private String shippingRulePreference;
	private boolean ownCarrierBulkShipping;
	private boolean switchToSideMenu;
	
	private String subscriptionBillingChannel;
	
	private boolean enableCarrierCustomsBroker = false;
	
	public boolean isSwitchToSideMenu() {
		return switchToSideMenu;
	}

	public void setSwitchToSideMenu(boolean switchToSideMenu) {
		this.switchToSideMenu = switchToSideMenu;
	}

	public boolean isOwnCarrierBulkShipping() {
		return ownCarrierBulkShipping;
	}

	public void setOwnCarrierBulkShipping(boolean ownCarrierBulkShipping) {
		this.ownCarrierBulkShipping = ownCarrierBulkShipping;
	}

	public String getLocation() {
		return location;
	}

	public CustomerPreferencesDTO setLocation(String location) {
		this.location = location;
		return this;
	}

	public String getPickupTime() {
		return pickupTime;
	}

	public CustomerPreferencesDTO setPickupTime(String pickupTime) {
		this.pickupTime = pickupTime;
		return this;
	}

	public String getCloseTime() {
		return closeTime;
	}

	public CustomerPreferencesDTO setCloseTime(String closeTime) {
		this.closeTime = closeTime;
		return this;
	}

	public Boolean getThermalLabels() {
		return thermalLabels;
	}

	public CustomerPreferencesDTO setThermalLabels(Boolean thermalLabels) {
		this.thermalLabels = thermalLabels;
		return this;
	}

	public Boolean getShowBulkShipping() {
		return showBulkShipping;
	}

	public CustomerPreferencesDTO setShowBulkShipping(Boolean showBulkShipping) {
		this.showBulkShipping = showBulkShipping;
		return this;
	}
	
	public boolean isLtlForRealtimerates() {
		return ltlForRealtimerates;
	}

	public CustomerPreferencesDTO setLtlForRealtimerates(boolean ltlForRealtimerates) {
		this.ltlForRealtimerates = ltlForRealtimerates;
		return this;
	}

	public Boolean getIsCardDisclaimerAccepted() {
		return isCardDisclaimerAccepted;
	}

	public CustomerPreferencesDTO setIsCardDisclaimerAccepted(Boolean isCardDisclaimerAccepted) {
		this.isCardDisclaimerAccepted = isCardDisclaimerAccepted;
		return this;
	}

	public boolean isShowReturnOrderConfirmation() {
		return showReturnOrderConfirmation;
	}

	public CustomerPreferencesDTO setShowReturnOrderConfirmation(boolean showReturnOrderConfirmation) {
		this.showReturnOrderConfirmation = showReturnOrderConfirmation;
		return this;
	}

	public boolean isShowDuplicateOrderConfirmation() {
		return showDuplicateOrderConfirmation;
	}

	public CustomerPreferencesDTO setShowDuplicateOrderConfirmation(boolean showDuplicateOrderConfirmation) {
		this.showDuplicateOrderConfirmation = showDuplicateOrderConfirmation;
		return this;
	}
	
	public boolean ltlRatesEnabled() {
		return ltlForRealtimerates;
	}

	public String getShiptoPhone() {
		return shiptoPhone;
	}

	public CustomerPreferencesDTO setShiptoPhone(String shiptoPhone) {
		this.shiptoPhone = shiptoPhone;
		return this;
	}

	public String getShiptoExt() {
		return shiptoExt;
	}

	public CustomerPreferencesDTO setShiptoExt(String shiptoExt) {
		this.shiptoExt = shiptoExt;
		return this;
	}

	public String getShiptoEmail() {
		return shiptoEmail;
	}

	public CustomerPreferencesDTO setShiptoEmail(String shiptoEmail) {
		this.shiptoEmail = shiptoEmail;
		return this;
	}

	public boolean isAgreeShiptoTerms() {
		return agreeShiptoTerms;
	}

	public CustomerPreferencesDTO setAgreeShiptoTerms(boolean agreeShiptoTerms) {
		this.agreeShiptoTerms = agreeShiptoTerms;
		return this;
	}

	public String getBrokerName() {
		return brokerName;
	}

	public CustomerPreferencesDTO setBrokerName(String brokerName) {
		this.brokerName = brokerName;
		return this;
	}

	public String getBrokerPhone() {
		return brokerPhone;
	}

	public CustomerPreferencesDTO setBrokerPhone(String brokerPhone) {
		this.brokerPhone = brokerPhone;
		return this;
	}

	public String getBrokerEmail() {
		return brokerEmail;
	}

	public CustomerPreferencesDTO setBrokerEmail(String brokerEmail) {
		this.brokerEmail = brokerEmail;
		return this;
	}

	public boolean isAgreeBrokerInfo() {
		return agreeBrokerInfo;
	}

	public CustomerPreferencesDTO setAgreeBrokerInfo(boolean agreeBrokerInfo) {
		this.agreeBrokerInfo = agreeBrokerInfo;
		return this;
	}

	public boolean isShowMidland() {
		return showMidland;
	}

	public CustomerPreferencesDTO setShowMidland(boolean showMidland) {
		this.showMidland = showMidland;
		return this;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public CustomerPreferencesDTO setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
		return this;
	}

	public String getBulkShippingPreference() {
		return bulkShippingPreference;
	}

	public CustomerPreferencesDTO setBulkShippingPreference(String bulkShippingPreference) {
		this.bulkShippingPreference = bulkShippingPreference;
		return this;
	}

	public Boolean getShowShipItClosePopUp() {
		return showShipItClosePopUp;
	}

	public CustomerPreferencesDTO setShowShipItClosePopUp(Boolean showShipItClosePopUp) {
		this.showShipItClosePopUp = showShipItClosePopUp;
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

	public List<PickupPreferenceDTO> getPickupPreferences() {
		return pickupPreferences;
	}

	public void setPickupPreferences(List<PickupPreferenceDTO> pickupPreferences) {
		this.pickupPreferences = pickupPreferences;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}
	
	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getPhoneCountryCode() {
		return phoneCountryCode;
	}

	public void setPhoneCountryCode(String phoneCountryCode) {
		this.phoneCountryCode = phoneCountryCode;
	}

	public String getPhoneInternationalDialNumber() {
		return phoneInternationalDialNumber;
	}

	public void setPhoneInternationalDialNumber(String phoneInternationalDialNumber) {
		this.phoneInternationalDialNumber = phoneInternationalDialNumber;
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

	public void setAutoFetchRates(boolean autoFetchRates) {
		this.autoFetchRates = autoFetchRates;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public String getSbaVersion() {
		return sbaVersion;
	}

	public void setSbaVersion(String sbaVersion) {
		this.sbaVersion = sbaVersion;
	}

	public String getFcApiPreference() {
		return fcApiPreference;
	}

	public void setFcApiPreference(String fcApiPreference) {
		this.fcApiPreference = fcApiPreference;
	}

	public ShippingPreferencesDTO getShippingPreferences() {
		return shippingPreferences == null ? new ShippingPreferencesDTO() : this.shippingPreferences;
	}

	public void setShippingPreferences(ShippingPreferencesDTO shippingPreferences) {
		this.shippingPreferences = shippingPreferences;
	}
	
	public void setPrintingPreference(PrintingPreferenceDTO printingPreference) {
		this.printingPreference = printingPreference;
	}
	
	public PrintingPreferenceDTO getPrintingPreference() {
		return this.printingPreference;
	}

	public String getManualShipmentPreference() {
		return manualShipmentPreference;
	}

	public CustomerPreferencesDTO setManualShipmentPreference(String manualShipmentPreference) {
		this.manualShipmentPreference = manualShipmentPreference;
		return this;
	}

	public String getManualShipmentSwitchFeedback() {
		return manualShipmentSwitchFeedback;
	}

	public CustomerPreferencesDTO setManualShipmentSwitchFeedback(String manualShipmentSwitchFeedback) {
		this.manualShipmentSwitchFeedback = manualShipmentSwitchFeedback;
		return this;
	}
	
	public String getShippingRulePreference() {
		return shippingRulePreference;
	}

	public CustomerPreferencesDTO setShippingRulePreference(String shippingRulePreference) {
		this.shippingRulePreference = shippingRulePreference;
		return this;
	}

	public String getSubscriptionBillingChannel() {
		return subscriptionBillingChannel;
	}

	public CustomerPreferencesDTO setSubscriptionBillingChannel(String subscriptionBillingChannel) {
		this.subscriptionBillingChannel = StringUtils.lowerCase(StringUtils.isNotBlank(subscriptionBillingChannel) ?  subscriptionBillingChannel : "ChargeBee");
		return this;
	}
	
	public boolean isEnableCarrierCustomsBroker() {
		return enableCarrierCustomsBroker;
	}

	public void setEnableCarrierCustomsBroker(boolean enableCarrierCustomsBroker) {
		this.enableCarrierCustomsBroker = enableCarrierCustomsBroker;
	}
}
