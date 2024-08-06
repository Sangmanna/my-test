package com.freightcom.clickship.model.marketplace;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.freightcom.clickship.model.CommonDTO;
import com.freightcom.clickship.model.constants.ClickShipConstants;
import com.freightcom.clickship.model.customer.CustomerAddressDTO;
import com.freightcom.clickship.model.rates.PalletContingencyRatesDTO;

public class MarketplaceSettingDTO extends CommonDTO implements Serializable {

	private static final long serialVersionUID = -2707485164755326425L;

	private String id;
	
	private Boolean saturdayPickup = false;

	private Boolean saturdayDelivery = false;
	
	private boolean autoFullfillment = false;
	
	private Boolean signatureRequired = false;
	
	private Boolean residentialDelivery = false;
	
	private boolean realtimeRatesCheckout = false;
	
	private Boolean adultSignatureRequired = false;
	
	private Boolean allowPendingFulfillment = true;
	
	private Boolean autoSendShippingToCustomer = true;

	private boolean autoUpdateStatusInMarketplace = true;

	private Boolean autoSendReturnLabelToCustomer = true;
	
	private MarketplaceDTO marketplace;
	
	private CustomerAddressDTO defaultShippingFromAddress;
	
	private double realtimePriceMarkup = 0d;
	
	private boolean realtimePricePercent = false;
	
	private boolean realtimePriceDown = false;
	
	private String emailAddressOrderCancelled = "";
	
	private String emailAddressSuccessfulOrder = "";
	
	private String emailAddressNewOrderImported = "";
	
	private String emailAddressUnsuccessfulOrder = "";
	
	private String unitOfMeasure = ClickShipConstants.UNIT_IMPERIAL;

	private String defaultEmail = "";

	private String defaultPhone = "";

	private boolean palletRatesCheckout = false;

	private boolean insidePickup = false;

	private boolean insideDelivery = false;

	private boolean homelandSecurity = false;

	private boolean militaryBaseDelivery = false;

	private boolean limitedAccess = false;

	private boolean appoinmentDelivery = false;

	private boolean constructionSite = false;

	private boolean crossBorderFee = false;

	private boolean inBond = false;

	private boolean heatedService = false;

	private String dangerousGoodsType = "None";

	private boolean stackable = false;

	private boolean palletMarkupMode = false;

	private boolean palletMarkupType = false;

	private double palletMarkupValue = 0d;

	private boolean residentialPickup = false;

	private boolean tailgatePickup = false;

	private boolean palletResidentialDelivery = false;

	private boolean tailgateDelivery = false;

	private String readyTimeHrs;

	private String readyTimeMin;

	private String originCloseTimeHrs;

	private String originCloseMin;

	private String pickupInstructions;

	private String destinationCloseHrs;

	private String destinationCloseMin;

	private String deliveryInstructions;
	
	private String productIdentifier;
	
	private boolean locationSplit = false;
	
	private boolean rtrProcessingTime = true;
	
	private List<PalletContingencyRatesDTO> palletContingencyRates = new ArrayList<>();

	public String getId() {
		return id;
	}

	public MarketplaceSettingDTO setId(String id) {
		this.id = id;
		return this;
	}

	public Boolean getSaturdayPickup() {
		return saturdayPickup;
	}

	public MarketplaceSettingDTO setSaturdayPickup(Boolean saturdayPickup) {
		this.saturdayPickup = saturdayPickup;
		return this;
	}

	public Boolean getSaturdayDelivery() {
		return saturdayDelivery;
	}

	public MarketplaceSettingDTO setSaturdayDelivery(Boolean saturdayDelivery) {
		this.saturdayDelivery = saturdayDelivery;
		return this;
	}

	public boolean isAutoFullfillment() {
		return autoFullfillment;
	}

	public MarketplaceSettingDTO setAutoFullfillment(boolean autoFullfillment) {
		this.autoFullfillment = autoFullfillment;
		return this;
	}

	public Boolean getSignatureRequired() {
		return signatureRequired;
	}

	public MarketplaceSettingDTO setSignatureRequired(Boolean signatureRequired) {
		this.signatureRequired = signatureRequired;
		return this;
	}

	public Boolean getResidentialDelivery() {
		return residentialDelivery;
	}

	public MarketplaceSettingDTO setResidentialDelivery(Boolean residentialDelivery) {
		this.residentialDelivery = residentialDelivery;
		return this;
	}

	public boolean isRealtimeRatesCheckout() {
		return realtimeRatesCheckout;
	}

	public MarketplaceSettingDTO setRealtimeRatesCheckout(boolean realtimeRatesCheckout) {
		this.realtimeRatesCheckout = realtimeRatesCheckout;
		return this;
	}
	
	public Boolean getAdultSignatureRequired() {
		return adultSignatureRequired;
	}

	public MarketplaceSettingDTO setAdultSignatureRequired(Boolean adultSignatureRequired) {
		this.adultSignatureRequired = adultSignatureRequired;
		return this;
	}

	public Boolean isAllowPendingFulfillment() {
		return allowPendingFulfillment;
	}

	public MarketplaceSettingDTO setAllowPendingFulfillment(Boolean allowPendingFulfillment) {
		this.allowPendingFulfillment = allowPendingFulfillment;
		return this;
	}

	public Boolean getAutoSendShippingToCustomer() {
		return autoSendShippingToCustomer;
	}

	public MarketplaceSettingDTO setAutoSendShippingToCustomer(Boolean autoSendShippingToCustomer) {
		this.autoSendShippingToCustomer = autoSendShippingToCustomer;
		return this;
	}

	public boolean isAutoUpdateStatusInMarketplace() {
		return autoUpdateStatusInMarketplace;
	}

	public MarketplaceSettingDTO setAutoUpdateStatusInMarketplace(boolean autoUpdateStatusInMarketplace) {
		this.autoUpdateStatusInMarketplace = autoUpdateStatusInMarketplace;
		return this;
	}

	public Boolean getAutoSendReturnLabelToCustomer() {
		return autoSendReturnLabelToCustomer;
	}

	public MarketplaceSettingDTO setAutoSendReturnLabelToCustomer(Boolean autoSendReturnLabelToCustomer) {
		this.autoSendReturnLabelToCustomer = autoSendReturnLabelToCustomer;
		return this;
	}

	public MarketplaceDTO getMarketplace() {
		return marketplace;
	}

	public MarketplaceSettingDTO setMarketplace(MarketplaceDTO marketplace) {
		this.marketplace = marketplace;
		return this;
	}

	public CustomerAddressDTO getDefaultShippingFromAddress() {
		return defaultShippingFromAddress;
	}

	public MarketplaceSettingDTO setDefaultShippingFromAddress(CustomerAddressDTO defaultShippingFromAddress) {
		this.defaultShippingFromAddress = defaultShippingFromAddress;
		return this;
	}

	public double getRealtimePriceMarkup() {
		return realtimePriceMarkup;
	}

	public MarketplaceSettingDTO setRealtimePriceMarkup(double realtimePriceMarkup) {
		this.realtimePriceMarkup = realtimePriceMarkup;
		return this;
	}

	public String getEmailAddressOrderCancelled() {
		return emailAddressOrderCancelled;
	}

	public MarketplaceSettingDTO setEmailAddressOrderCancelled(String emailAddressOrderCancelled) {
		this.emailAddressOrderCancelled = emailAddressOrderCancelled;
		return this;
	}

	public String getEmailAddressSuccessfulOrder() {
		return emailAddressSuccessfulOrder;
	}

	public MarketplaceSettingDTO setEmailAddressSuccessfulOrder(String emailAddressSuccessfulOrder) {
		this.emailAddressSuccessfulOrder = emailAddressSuccessfulOrder;
		return this;
	}

	public String getEmailAddressNewOrderImported() {
		return emailAddressNewOrderImported;
	}

	public MarketplaceSettingDTO setEmailAddressNewOrderImported(String emailAddressNewOrderImported) {
		this.emailAddressNewOrderImported = emailAddressNewOrderImported;
		return this;
	}

	public String getEmailAddressUnsuccessfulOrder() {
		return emailAddressUnsuccessfulOrder;
	}

	public MarketplaceSettingDTO setEmailAddressUnsuccessfulOrder(String emailAddressUnsuccessfulOrder) {
		this.emailAddressUnsuccessfulOrder = emailAddressUnsuccessfulOrder;
		return this;
	}

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public MarketplaceSettingDTO setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
		return this;
	}

	public boolean isRealtimePricePercent() {
		return realtimePricePercent;
	}

	public MarketplaceSettingDTO setRealtimePricePercent(boolean realtimePricePercent) {
		this.realtimePricePercent = realtimePricePercent;
		return this;
	}

	public boolean isRealtimePriceDown() {
		return realtimePriceDown;
	}

	public MarketplaceSettingDTO setRealtimePriceDown(boolean realtimePriceDown) {
		this.realtimePriceDown = realtimePriceDown;
		return this;
	}

	public String getDefaultEmail() {
		return defaultEmail;
	}

	public MarketplaceSettingDTO setDefaultEmail(String defaultEmail) {
		this.defaultEmail = defaultEmail;
		return this;
	}

	public String getDefaultPhone() {
		return defaultPhone;
	}

	public MarketplaceSettingDTO setDefaultPhone(String defaultPhone) {
		this.defaultPhone = defaultPhone;
		return this;
	}

	public boolean isPalletRatesCheckout() {
		return palletRatesCheckout;
	}

	public MarketplaceSettingDTO setPalletRatesCheckout(boolean palletRatesCheckout) {
		this.palletRatesCheckout = palletRatesCheckout;
		return this;
	}

	public boolean isInsidePickup() {
		return insidePickup;
	}

	public MarketplaceSettingDTO setInsidePickup(boolean insidePickup) {
		this.insidePickup = insidePickup;
		return this;
	}

	public boolean isInsideDelivery() {
		return insideDelivery;
	}

	public MarketplaceSettingDTO setInsideDelivery(boolean insideDelivery) {
		this.insideDelivery = insideDelivery;
		return this;
	}

	public boolean isHomelandSecurity() {
		return homelandSecurity;
	}

	public MarketplaceSettingDTO setHomelandSecurity(boolean homelandSecurity) {
		this.homelandSecurity = homelandSecurity;
		return this;
	}

	public boolean isMilitaryBaseDelivery() {
		return militaryBaseDelivery;
	}

	public MarketplaceSettingDTO setMilitaryBaseDelivery(boolean militaryBaseDelivery) {
		this.militaryBaseDelivery = militaryBaseDelivery;
		return this;
	}

	public boolean isLimitedAccess() {
		return limitedAccess;
	}

	public MarketplaceSettingDTO setLimitedAccess(boolean limitedAccess) {
		this.limitedAccess = limitedAccess;
		return this;
	}

	public boolean isAppoinmentDelivery() {
		return appoinmentDelivery;
	}

	public MarketplaceSettingDTO setAppoinmentDelivery(boolean appoinmentDelivery) {
		this.appoinmentDelivery = appoinmentDelivery;
		return this;
	}

	public boolean isConstructionSite() {
		return constructionSite;
	}

	public MarketplaceSettingDTO setConstructionSite(boolean constructionSite) {
		this.constructionSite = constructionSite;
		return this;
	}

	public boolean isCrossBorderFee() {
		return crossBorderFee;
	}

	public MarketplaceSettingDTO setCrossBorderFee(boolean crossBorderFee) {
		this.crossBorderFee = crossBorderFee;
		return this;
	}

	public boolean isInBond() {
		return inBond;
	}

	public MarketplaceSettingDTO setInBond(boolean inBond) {
		this.inBond = inBond;
		return this;
	}

	public boolean isHeatedService() {
		return heatedService;
	}

	public MarketplaceSettingDTO setHeatedService(boolean heatedService) {
		this.heatedService = heatedService;
		return this;
	}

	public String getDangerousGoodsType() {
		return dangerousGoodsType;
	}

	public MarketplaceSettingDTO setDangerousGoodsType(String dangerousGoodsType) {
		this.dangerousGoodsType = dangerousGoodsType;
		return this;
	}

	public boolean isStackable() {
		return stackable;
	}

	public MarketplaceSettingDTO setStackable(boolean stackable) {
		this.stackable = stackable;
		return this;
	}

	public boolean isPalletMarkupMode() {
		return palletMarkupMode;
	}

	public MarketplaceSettingDTO setPalletMarkupMode(boolean palletMarkupMode) {
		this.palletMarkupMode = palletMarkupMode;
		return this;
	}

	public boolean isPalletMarkupType() {
		return palletMarkupType;
	}

	public MarketplaceSettingDTO setPalletMarkupType(boolean palletMarkupType) {
		this.palletMarkupType = palletMarkupType;
		return this;
	}

	public double getPalletMarkupValue() {
		return palletMarkupValue;
	}

	public MarketplaceSettingDTO setPalletMarkupValue(double palletMarkupValue) {
		this.palletMarkupValue = palletMarkupValue;
		return this;
	}

	public boolean isResidentialPickup() {
		return residentialPickup;
	}

	public MarketplaceSettingDTO setResidentialPickup(boolean residentialPickup) {
		this.residentialPickup = residentialPickup;
		return this;
	}

	public boolean isTailgatePickup() {
		return tailgatePickup;
	}

	public MarketplaceSettingDTO setTailgatePickup(boolean tailgatePickup) {
		this.tailgatePickup = tailgatePickup;
		return this;
	}

	public boolean isPalletResidentialDelivery() {
		return palletResidentialDelivery;
	}

	public MarketplaceSettingDTO setPalletResidentialDelivery(boolean palletResidentialDelivery) {
		this.palletResidentialDelivery = palletResidentialDelivery;
		return this;
	}

	public boolean isTailgateDelivery() {
		return tailgateDelivery;
	}

	public MarketplaceSettingDTO setTailgateDelivery(boolean tailgateDelivery) {
		this.tailgateDelivery = tailgateDelivery;
		return this;
	}

	public String getReadyTimeHrs() {
		return readyTimeHrs;
	}

	public MarketplaceSettingDTO setReadyTimeHrs(String readyTimeHrs) {
		this.readyTimeHrs = readyTimeHrs;
		return this;
	}

	public String getReadyTimeMin() {
		return readyTimeMin;
	}

	public MarketplaceSettingDTO setReadyTimeMin(String readyTimeMin) {
		this.readyTimeMin = readyTimeMin;
		return this;
	}

	public String getOriginCloseTimeHrs() {
		return originCloseTimeHrs;
	}

	public MarketplaceSettingDTO setOriginCloseTimeHrs(String originCloseTimeHrs) {
		this.originCloseTimeHrs = originCloseTimeHrs;
		return this;
	}

	public String getOriginCloseMin() {
		return originCloseMin;
	}

	public MarketplaceSettingDTO setOriginCloseMin(String originCloseMin) {
		this.originCloseMin = originCloseMin;
		return this;
	}

	public String getPickupInstructions() {
		return pickupInstructions;
	}

	public MarketplaceSettingDTO setPickupInstructions(String pickupInstructions) {
		this.pickupInstructions = pickupInstructions;
		return this;
	}

	public String getDestinationCloseHrs() {
		return destinationCloseHrs;
	}

	public MarketplaceSettingDTO setDestinationCloseHrs(String destinationCloseHrs) {
		this.destinationCloseHrs = destinationCloseHrs;
		return this;
	}

	public String getDestinationCloseMin() {
		return destinationCloseMin;
	}

	public MarketplaceSettingDTO setDestinationCloseMin(String destinationCloseMin) {
		this.destinationCloseMin = destinationCloseMin;
		return this;
	}

	public String getDeliveryInstructions() {
		return deliveryInstructions;
	}

	public MarketplaceSettingDTO setDeliveryInstructions(String deliveryInstructions) {
		this.deliveryInstructions = deliveryInstructions;
		return this;
	}

	public List<PalletContingencyRatesDTO> getPalletContingencyRates() {
		return palletContingencyRates;
	}

	public void setPalletContingencyRates(List<PalletContingencyRatesDTO> palletContingencyRates) {
		this.palletContingencyRates.addAll(palletContingencyRates);
	}
	
	public void addPalletContingencyRates(PalletContingencyRatesDTO palletContingencyRate) {
		this.palletContingencyRates.add(palletContingencyRate);
	}

	public String getProductIdentifier() {
		return productIdentifier;
	}

	public void setProductIdentifier(String productIdentifier) {
		this.productIdentifier = productIdentifier;
	}

	public boolean isLocationSplit() {
		return locationSplit;
	}

	public void setLocationSplit(boolean locationSplit) {
		this.locationSplit = locationSplit;
	}

	public boolean isRtrProcessingTime() {
		return rtrProcessingTime;
	}

	public void setRtrProcessingTime(boolean rtrProcessingTime) {
		this.rtrProcessingTime = rtrProcessingTime;
	}
	
}
