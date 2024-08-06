package com.freightcom.clickship.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.GenericGenerator;

import com.freightcom.clickship.data.entity.common.BaseEntity;
import com.freightcom.clickship.model.constants.ClickShipConstants;

@Entity
@Table(name = "marketplace_setting")
public class MarketplaceSetting extends BaseEntity {
	
	private static final long serialVersionUID = -5144551909849572024L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class )
	@Column(name = "id", nullable = false, updatable = false)
	private String id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "marketplace_id", updatable = false)
	private Marketplace marketplace;

	@Column(name = "real_time_rates_checkout")
	private boolean realtimeRatesCheckout = false;

	@Column(name = "adult_signature_required")
	private Boolean adultSignatureRequired = false;

	@Column(name = "signature_required")
	private Boolean signatureRequired = false;

	@Column(name = "residential_delivery")
	private Boolean residentialDelivery = false;

	@Column(name = "saturday_delivery")
	private Boolean saturdayDelivery = false;

	@Column(name = "saturday_pickup")
	private Boolean saturdayPickup = false;

	@Column(name = "unit_of_measure")
	private String unitOfMeasure = ClickShipConstants.UNIT_IMPERIAL;

	@Column(name = "realtime_price_markup")
	private double realtimePriceMarkup = 0d;

	@Column(name = "email_address_successful_order")
	private String emailAddressSuccessfulOrder = "";

	@Column(name = "email_address_unsuccessful_order")
	private String emailAddressUnsuccessfulOrder = "";

	@Column(name = "email_address_new_order_imported")
	private String emailAddressNewOrderImported = "";

	@Column(name = "email_address_order_cancelled")
	private String emailAddressOrderCancelled = "";

	@Column(name = "auto_fullfillment")
	private boolean autoFullfillment = false;

	@Column(name = "auto_update_status_in_marketplace")
	private boolean autoUpdateStatusInMarketplace = true;

	@Column(name = "auto_send_shipping_to_customer")
	private Boolean autoSendShippingToCustomer = true;

	@Column(name = "auto_send_return_label_to_customer")
	private Boolean autoSendReturnLabelToCustomer = true;

	@Column(name = "allow_pending_fulfillment")
	private Boolean allowPendingFulfillment = true;

	@Column(name = "is_realtime_price_percent")
	private boolean realtimePricePercent = false;

	@Column(name = "is_realtime_price_down")
	private boolean realtimePriceDown = false;

	// Value should be between 100 to 1000 and multiples by 100
	@Column(name = "api_request_page_size")
	private int apiRequestPageSize = 0;

	@Column(name = "product_identifier")
	private String productIdentifier;

	@Transient
	private boolean isPalletMarkupChanged = false;
	
	@Transient
	private boolean isPackageMarkupChanged = false;

	@Column(name = "default_phone")
	private String defaultPhone;

	@Column(name = "pallet_rates_checkout")
	private boolean palletRatesCheckout = false;

	@Column(name = "inside_pickup")
	private boolean insidePickup = false;

	@Column(name = "inside_delivery")
	private boolean insideDelivery = false;

	@Column(name = "homeland_security")
	private boolean homelandSecurity = false;

	@Column(name = "military_base_delivery")
	private boolean militaryBaseDelivery = false;

	@Column(name = "limited_access")
	private boolean limitedAccess = false;

	@Column(name = "appoinment_delivery")
	private boolean appoinmentDelivery = false;

	@Column(name = "construction_site")
	private boolean constructionSite = false;

	@Column(name = "cross_border_fee")
	private boolean crossBorderFee = false;

	@Column(name = "in_bond")
	private boolean inBond = false;

	@Column(name = "heated_service")
	private boolean heatedService = false;

	@Column(name = "dangerous_goods_type")
	private String dangerousGoodsType = "None";

	@Column(name = "stackable")
	private boolean stackable = false;

	@Column(name = "pallet_markup_mode")
	private boolean palletMarkupMode = false;

	@Column(name = "pallet_markup_type")
	private boolean palletMarkupType = false;

	@Column(name = "pallet_markup_value")
	private double palletMarkupValue = 0d;

	@Column(name = "residential_pickup")
	private boolean residentialPickup;

	@Column(name = "tailgate_pickup")
	private boolean tailgatePickup;

	@Column(name = "pallet_residential_delivery")
	private boolean palletResidentialDelivery;

	@Column(name = "tailgate_delivery")
	private boolean tailgateDelivery;

	@Column(name = "ready_time_hrs")
	private String readyTimeHrs;

	@Column(name = "ready_time_min")
	private String readyTimeMin;

	@Column(name = "origin_close_time_hrs")
	private String originCloseTimeHrs;

	@Column(name = "origin_close_min")
	private String originCloseMin;

	@Column(name = "pickup_instructions")
	private String pickupInstructions;

	@Column(name = "destination_close_hrs")
	private String destinationCloseHrs;

	@Column(name = "destination_close_min")
	private String destinationCloseMin;

	@Column(name = "delivery_instructions")
	private String deliveryInstructions;
	
	@Column(name = "location_split")
	private boolean locationSplit = false;
	
	@Column(name = "rtr_processing_time")
	private boolean rtrProcessingTime = true;
	
	@Column(name = "pull_product_updates")
	private boolean pullProductUpdates = true;

	public MarketplaceSetting() {

	}

	public MarketplaceSetting(Marketplace marketplace) {
		this.marketplace = marketplace;
	}

	public String getId() {
		return id;
	}

	public MarketplaceSetting setId(String id) {
		this.id = id;
		return this;
	}

	public Marketplace getMarketplace() {
		return marketplace;
	}

	public MarketplaceSetting setMarketplace(Marketplace marketplace) {
		this.marketplace = marketplace;
		return this;
	}

	public boolean isRealtimeRatesCheckout() {
		return realtimeRatesCheckout;
	}

	public MarketplaceSetting setRealtimeRatesCheckout(boolean realtimeRatesCheckout) {
		this.realtimeRatesCheckout = realtimeRatesCheckout;
		return this;
	}

	public boolean isPalletRatesCheckout() {
		return palletRatesCheckout;
	}

	public MarketplaceSetting setPalletRatesCheckout(boolean palletRatesCheckout) {
		this.palletRatesCheckout = palletRatesCheckout;
		return this;
	}
	
	public boolean isPackageMarkupChanged() {
		return isPackageMarkupChanged;
	}

	public void setPackageMarkupChanged(boolean isPackageMarkupChanged) {
		this.isPackageMarkupChanged = isPackageMarkupChanged;
	}

	public boolean isPalletMarkupChanged() {
		return isPalletMarkupChanged;
	}

	public void setPalletMarkupChanged(boolean isPalletMarkupChanged) {
		this.isPalletMarkupChanged = isPalletMarkupChanged;
	}

	public Boolean getAllowPendingFulfillment() {
		return allowPendingFulfillment;
	}

	public Boolean getAdultSignatureRequired() {
		return adultSignatureRequired;
	}

	public MarketplaceSetting setAdultSignatureRequired(Boolean adultSignatureRequired) {
		this.adultSignatureRequired = adultSignatureRequired;
		return this;
	}

	public Boolean getSignatureRequired() {
		return signatureRequired;
	}

	public MarketplaceSetting setSignatureRequired(Boolean signatureRequired) {
		this.signatureRequired = signatureRequired;
		return this;
	}

	public Boolean getResidentialDelivery() {
		return residentialDelivery;
	}

	public MarketplaceSetting setResidentialDelivery(Boolean residentialDelivery) {
		this.residentialDelivery = residentialDelivery;
		return this;
	}

	public Boolean getSaturdayDelivery() {
		return saturdayDelivery;
	}

	public MarketplaceSetting setSaturdayDelivery(Boolean saturdayDelivery) {
		this.saturdayDelivery = saturdayDelivery;
		return this;
	}

	public Boolean getSaturdayPickup() {
		return saturdayPickup;
	}

	public MarketplaceSetting setSaturdayPickup(Boolean saturdayPickup) {
		this.saturdayPickup = saturdayPickup;
		return this;
	}

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public MarketplaceSetting setUnitOfMeasure(String unitOfMeasure) {

		if (StringUtils.equalsAnyIgnoreCase(unitOfMeasure, ClickShipConstants.UNIT_IMPERIAL, "lbs")) {
			this.unitOfMeasure = ClickShipConstants.UNIT_IMPERIAL;
		} else if (StringUtils.equalsAnyIgnoreCase(unitOfMeasure, ClickShipConstants.UNIT_METRIC, "kgs")) {
			this.unitOfMeasure = ClickShipConstants.UNIT_METRIC;
		}

		return this;
	}

	public double getRealtimePriceMarkup() {
		return realtimePriceMarkup;
	}

	public MarketplaceSetting setRealtimePriceMarkup(double realtimePriceMarkup) {
		if (realtimePriceMarkup != this.realtimePriceMarkup) {
			isPackageMarkupChanged = true;
		}

		this.realtimePriceMarkup = realtimePriceMarkup;
		return this;
	}

	public String getEmailAddressSuccessfulOrder() {
		return emailAddressSuccessfulOrder;
	}

	public MarketplaceSetting setEmailAddressSuccessfulOrder(String emailAddressSuccessfulOrder) {
		this.emailAddressSuccessfulOrder = emailAddressSuccessfulOrder;
		return this;
	}

	public String getEmailAddressUnsuccessfulOrder() {
		return emailAddressUnsuccessfulOrder;
	}

	public MarketplaceSetting setEmailAddressUnsuccessfulOrder(String emailAddressUnsuccessfulOrder) {
		this.emailAddressUnsuccessfulOrder = emailAddressUnsuccessfulOrder;
		return this;
	}

	public String getEmailAddressNewOrderImported() {
		return emailAddressNewOrderImported;
	}

	public MarketplaceSetting setEmailAddressNewOrderImported(String emailAddressNewOrderImported) {
		this.emailAddressNewOrderImported = emailAddressNewOrderImported;
		return this;
	}

	public String getEmailAddressOrderCancelled() {
		return emailAddressOrderCancelled;
	}

	public MarketplaceSetting setEmailAddressOrderCancelled(String emailAddressOrderCancelled) {
		this.emailAddressOrderCancelled = emailAddressOrderCancelled;
		return this;
	}

	public boolean isAutoFullfillment() {
		return autoFullfillment;
	}

	public MarketplaceSetting setAutoFullfillment(boolean autoFullfillment) {
		this.autoFullfillment = autoFullfillment;
		return this;
	}

	public boolean isAutoUpdateStatusInMarketplace() {
		return autoUpdateStatusInMarketplace;
	}

	public MarketplaceSetting setAutoUpdateStatusInMarketplace(boolean autoUpdateStatusInMarketplace) {
		this.autoUpdateStatusInMarketplace = autoUpdateStatusInMarketplace;
		return this;
	}

	public boolean isAutoSendShippingToCustomer() {
		return autoSendShippingToCustomer;
	}

	public boolean getAutoSendShippingToCustomer() {
		return autoSendShippingToCustomer;
	}

	public MarketplaceSetting setAutoSendShippingToCustomer(Boolean autoSendShippingToCustomer) {
		if (autoSendShippingToCustomer == null) {
			autoSendShippingToCustomer = true;
		}
		this.autoSendShippingToCustomer = autoSendShippingToCustomer;
		return this;
	}

	public boolean isAutoSendReturnLabelToCustomer() {
		return autoSendReturnLabelToCustomer;
	}

	public boolean getAutoSendReturnLabelToCustomer() {
		return autoSendReturnLabelToCustomer;
	}

	public MarketplaceSetting setAutoSendReturnLabelToCustomer(Boolean autoSendReturnLabelToCustomer) {
		if (autoSendReturnLabelToCustomer == null) {
			autoSendReturnLabelToCustomer = true;
		}
		this.autoSendReturnLabelToCustomer = autoSendReturnLabelToCustomer;
		return this;
	}

	public Boolean isAllowPendingFulfillment() {
		return allowPendingFulfillment;
	}

	public MarketplaceSetting setAllowPendingFulfillment(Boolean allowPendingFulfillment) {
		if (allowPendingFulfillment == null) {
			allowPendingFulfillment = false;
		}
		this.allowPendingFulfillment = allowPendingFulfillment;
		return this;
	}

	public boolean isRealtimePricePercent() {
		return realtimePricePercent;
	}

	public MarketplaceSetting setRealtimePricePercent(boolean realtimePricePercent) {
		if (realtimePricePercent != this.realtimePricePercent) {
			isPackageMarkupChanged = true;
		}

		this.realtimePricePercent = realtimePricePercent;
		return this;
	}

	public boolean isRealtimePriceDown() {
		return realtimePriceDown;
	}

	public MarketplaceSetting setRealtimePriceDown(boolean realtimePriceDown) {
		if (realtimePriceDown != this.realtimePriceDown) {
			isPackageMarkupChanged = true;
		}

		this.realtimePriceDown = realtimePriceDown;
		return this;
	}

	public int getApiRequestPageSize() {
		return apiRequestPageSize;
	}

	public MarketplaceSetting setApiRequestPageSize(int apiRequestPageSize) {
		this.apiRequestPageSize = apiRequestPageSize;
		return this;
	}

	public String getProductIdentifier() {
		return productIdentifier;
	}

	public void setProductIdentifier(String productIdentifier) {
		this.productIdentifier = productIdentifier;
	}

	public String getDefaultPhone() {
		return defaultPhone;
	}

	public void setDefaultPhone(String phoneNumberDefaultLabel) {
		this.defaultPhone = phoneNumberDefaultLabel;
	}

	public boolean isInsidePickup() {
		return insidePickup;
	}

	public MarketplaceSetting setInsidePickup(boolean insidePickup) {
		this.insidePickup = insidePickup;
		return this;
	}

	public boolean isInsideDelivery() {
		return insideDelivery;
	}

	public MarketplaceSetting setInsideDelivery(boolean insideDelivery) {
		this.insideDelivery = insideDelivery;
		return this;
	}

	public boolean isHomelandSecurity() {
		return homelandSecurity;
	}

	public MarketplaceSetting setHomelandSecurity(boolean homelandSecurity) {
		this.homelandSecurity = homelandSecurity;
		return this;
	}

	public boolean isMilitaryBaseDelivery() {
		return militaryBaseDelivery;
	}

	public MarketplaceSetting setMilitaryBaseDelivery(boolean militaryBaseDelivery) {
		this.militaryBaseDelivery = militaryBaseDelivery;
		return this;
	}

	public boolean isLimitedAccess() {
		return limitedAccess;
	}

	public MarketplaceSetting setLimitedAccess(boolean limitedAccess) {
		this.limitedAccess = limitedAccess;
		return this;
	}

	public boolean isAppoinmentDelivery() {
		return appoinmentDelivery;
	}

	public MarketplaceSetting setAppoinmentDelivery(boolean appoinmentDelivery) {
		this.appoinmentDelivery = appoinmentDelivery;
		return this;
	}

	public boolean isConstructionSite() {
		return constructionSite;
	}

	public MarketplaceSetting setConstructionSite(boolean constructionSite) {
		this.constructionSite = constructionSite;
		return this;
	}

	public boolean isCrossBorderFee() {
		return crossBorderFee;
	}

	public MarketplaceSetting setCrossBorderFee(boolean crossBorderFee) {
		this.crossBorderFee = crossBorderFee;
		return this;
	}

	public boolean isInBond() {
		return inBond;
	}

	public MarketplaceSetting setInBond(boolean inBond) {
		this.inBond = inBond;
		return this;
	}

	public boolean isHeatedService() {
		return heatedService;
	}

	public MarketplaceSetting setHeatedService(boolean heatedService) {
		this.heatedService = heatedService;
		return this;
	}

	public String getDangerousGoodsType() {
		return dangerousGoodsType;
	}

	public MarketplaceSetting setDangerousGoodsType(String dangerousGoodsType) {
		this.dangerousGoodsType = dangerousGoodsType;
		return this;
	}

	public boolean isStackable() {
		return stackable;
	}

	public MarketplaceSetting setStackable(boolean stackable) {
		this.stackable = stackable;
		return this;
	}

	public boolean isPalletMarkupMode() {
		return palletMarkupMode;
	}

	public MarketplaceSetting setPalletMarkupMode(boolean palletMarkupMode) {
		if (this.palletMarkupMode != palletMarkupMode) {
			isPalletMarkupChanged = true;
		}
		
		this.palletMarkupMode = palletMarkupMode;
		return this;
	}

	public boolean isPalletMarkupType() {
		return palletMarkupType;
	}

	public MarketplaceSetting setPalletMarkupType(boolean palletMarkupType) {
		if (this.palletMarkupType != palletMarkupType) {
			isPalletMarkupChanged = true;
		}
		
		this.palletMarkupType = palletMarkupType;
		return this;
	}

	public double getPalletMarkupValue() {
		return palletMarkupValue;
	}

	public MarketplaceSetting setPalletMarkupValue(double palletMarkupValue) {
		if (this.palletMarkupValue != palletMarkupValue) {
			isPalletMarkupChanged = true;
		}
		
		this.palletMarkupValue = palletMarkupValue;
		return this;
	}

	public boolean isResidentialPickup() {
		return residentialPickup;
	}

	public MarketplaceSetting setResidentialPickup(boolean residentialPickup) {
		this.residentialPickup = residentialPickup;
		return this;
	}

	public boolean isTailgatePickup() {
		return tailgatePickup;
	}

	public MarketplaceSetting setTailgatePickup(boolean tailgatePickup) {
		this.tailgatePickup = tailgatePickup;
		return this;
	}

	public boolean isPalletResidentialDelivery() {
		return palletResidentialDelivery;
	}

	public MarketplaceSetting setPalletResidentialDelivery(boolean palletResidentialDelivery) {
		this.palletResidentialDelivery = palletResidentialDelivery;
		return this;
	}

	public boolean isTailgateDelivery() {
		return tailgateDelivery;
	}

	public MarketplaceSetting setTailgateDelivery(boolean tailgateDelivery) {
		this.tailgateDelivery = tailgateDelivery;
		return this;
	}

	public String getReadyTimeHrs() {
		return readyTimeHrs;
	}

	public MarketplaceSetting setReadyTimeHrs(String readyTimeHrs) {
		this.readyTimeHrs = readyTimeHrs;
		return this;
	}

	public String getReadyTimeMin() {
		return readyTimeMin;
	}

	public MarketplaceSetting setReadyTimeMin(String readyTimeMin) {
		this.readyTimeMin = readyTimeMin;
		return this;
	}

	public String getOriginCloseTimeHrs() {
		return originCloseTimeHrs;
	}

	public MarketplaceSetting setOriginCloseTimeHrs(String originCloseTimeHrs) {
		this.originCloseTimeHrs = originCloseTimeHrs;
		return this;
	}

	public String getOriginCloseMin() {
		return originCloseMin;
	}

	public MarketplaceSetting setOriginCloseMin(String originCloseMin) {
		this.originCloseMin = originCloseMin;
		return this;
	}

	public String getPickupInstructions() {
		return pickupInstructions;
	}

	public MarketplaceSetting setPickupInstructions(String pickupInstructions) {
		this.pickupInstructions = pickupInstructions;
		return this;
	}

	public String getDestinationCloseHrs() {
		return destinationCloseHrs;
	}

	public MarketplaceSetting setDestinationCloseHrs(String destinationCloseHrs) {
		this.destinationCloseHrs = destinationCloseHrs;
		return this;
	}

	public String getDestinationCloseMin() {
		return destinationCloseMin;
	}

	public MarketplaceSetting setDestinationCloseMin(String destinationCloseMin) {
		this.destinationCloseMin = destinationCloseMin;
		return this;
	}

	public String getDeliveryInstructions() {
		return deliveryInstructions;
	}

	public MarketplaceSetting setDeliveryInstructions(String deliveryInstructions) {
		this.deliveryInstructions = deliveryInstructions;
		return this;
	}

	public boolean isLocationSplit() {
		return locationSplit;
	}

	public MarketplaceSetting setLocationSplit(boolean locationSplit) {
		this.locationSplit = locationSplit;
		return this;
	}

	public boolean isRtrProcessingTime() {
		return rtrProcessingTime;
	}

	public MarketplaceSetting setRtrProcessingTime(boolean rtrProcessingTime) {
		this.rtrProcessingTime = rtrProcessingTime;
		return this;
	}

	public boolean isPullProductUpdates() {
		return pullProductUpdates;
	}

	public MarketplaceSetting setPullProductUpdates(boolean pullProductUpdates) {
		this.pullProductUpdates = pullProductUpdates;
		return this;
	}
	
}