package com.freightcom.clickship.model.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.freightcom.clickship.model.CommonDTO;
import com.freightcom.clickship.model.KeyValue;
import com.freightcom.clickship.model.PalletServicesDTO;
import com.freightcom.clickship.model.box.BoxDTO;
import com.freightcom.clickship.model.constants.ClickShipConstants;
import com.freightcom.clickship.model.enums.InsuranceType;
import com.freightcom.clickship.model.rates.RateDTO;
import com.freightcom.clickship.model.shipment.CustomsInvoiceDTO;
import com.freightcom.clickship.model.util.ClickshipStringUtil;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDTO extends CommonDTO implements Serializable {

	private static final long serialVersionUID = 5689705961523588832L;

	private String marketplaceId;
	private String marketplaceType;
	private String id;
	private String shipfromCompany;
	private String shipfromAddress1;
	private String shipfromAddress2;
	private String shipfromCity;
	private String shipfromProvinceState;
	private String shipfromCountry;
	private String shipfromZip;
	private String shipfromPhone;
	private String shipfromPhoneExt;
	private String shipfromAttention;
	private String shipfromEmail;
	private String shiptoContact;
	private String shiptoCompany;
	private String shiptoAddress1;
	private String shiptoAddress2;
	private String shiptoCity;
	private String shiptoProvinceState;
	private String shiptoCountry;
	private String shiptoZip;
	private String shiptoPhone;
	private String shiptoPhoneExt;
	private String shiptoEmail;
	private String note;
	private String service;
	private String currency;
	private String shortName;
	private String carrierName;
	private Integer estimatedDate;
	private Double shippingCost;
	private boolean carrierRate = false;
	private String carrierServiceName;
	private String carrierAccountNumber;
	private List<BoxDTO> packages = new ArrayList<>();
	private CustomsInvoiceDTO customsInvoice = new CustomsInvoiceDTO();
	private PickupDTO pickup = new PickupDTO();
	private PickupWhileShipmentDTO pickupWhileShipmentDTO = new PickupWhileShipmentDTO();
	private String orderNumber;
	private String locationId;
	private List<OrderlineDTO> items = new ArrayList<>();
	private boolean adultSignatureRequired = false;
	private boolean signatureRequired = false;
	private boolean residentialDelivery = false;
	private boolean saturdayDelivery = false;
	private boolean saturdayPickup = false;
	private boolean schedulePickUp = false;
	private int insuranceType = InsuranceType.FREIGHTCOM.getValue();
	private Double insuranceAmount;
	private String insuranceCurrency = "CAD";
	private boolean isInsuranceTermsAgree = false;
	private boolean isInsuranceApplied = false;
	private boolean manualShipment = false;
	private String shipfromAddressIdx;
	private boolean returnLabel = false;
	private String returnLabelOrderId;	
	private String packageType;
	private String externalOrderId;
	private List<AdditionalServicesDTO> additionalServices = new ArrayList<>();
	private String pickupInstructions;
	private String deliveryInstructions;
	private String unitOfMeasure = ClickShipConstants.UNIT_IMPERIAL;
	private boolean isInternationalShipment = false;
	private String referenceCode; // this is from UI
	private List<KeyValue> referenceCodeList = new ArrayList<>(); // from customer_preferences
	private String expectedShipDate;
	private boolean isEncrypted = false;
	private boolean isPaperlessCustomsInvoice = false;
	private String rateRequestId;
	private List<RateDTO> ratesDto = new ArrayList<>();

	// this field is for v2 bulk-shipping UI
	private Date shipDate;
	private Double originalTotal;
	private Double originalShippingCost;
	private String originalShippingCurrency;
	private String trackingNumber;

	// v2 manual shipment
	private Integer percentage;
	private Integer totalRates;
	private Integer completedRates;
	private String pickupType = "now";
	private String palletRateRequestId;
	private String seletedRateType = "Package";
	private boolean fetchingRatesCompleted = false;
	private Boolean showPalletAndPackageRates = false;
	private boolean fetchingPalletRatesCompleted = false;

	private String shiptoFloor;
	private String shipfromFloor;
	private String shiptoOpensAt;
	private String shiptoClosesAt;
	private String shipfromOpensAt;
	private String shipfromClosesAt;
	private String shiptoLocationType = "";
	private String shipfromLocationType = "";
	private Boolean pickupTailgate = false;
	private Boolean deliveryTailgate = false;

	private String addressBookId;
	private Boolean saveLocation = false;
	private Boolean saveAddressBook = false;
	private Boolean saveAsNewLocation = false;
	private Boolean saveAsDefaultLocation = false;

	private Date estimatedShipDate;
	private String signatureRequirement;
	private Boolean residentialPickup = false;
	private Boolean includesReturnLabel = false;

	private boolean autoFulfilled;
	private boolean labelAccessed;
	private String appliedRTRShippingRuleName;
	private String appliedShippingRuleName;
	private String shippingRuleErrors;
	private String shippingRuleWarning;
	private boolean isShippingRuleRateFound;
	private String srRateServiceTypeCode;
	private String srRateServiceType;
	private Double srRateShippingCost;
	private String srRateShippingCurrency;
	private int srRateTransitTime;
	private Date srRateFetchedTime;
	private String srCarrierShortName;
	private String srCarrierImageName;
	private String srRateRequestId;
	private boolean shippingRuleInProgress;
	
	private PalletServicesDTO palletServices = new PalletServicesDTO();
	
	public String getMarketplaceId() {
		return marketplaceId;
	}

	public OrderDTO setMarketplaceId(String marketplaceId) {
		this.marketplaceId = marketplaceId;
		return this;
	}
	
	public String getMarketplaceType() {
		return marketplaceType;
	}

	public OrderDTO setMarketplaceType(String marketplaceType) {
		this.marketplaceType = marketplaceType;
		return this;
	}

	public String getId() {
		return id;
	}

	public OrderDTO setId(String orderId) {
		this.id = orderId;
		return this;
	}

	public String getShipfromCompany() {
		return shipfromCompany;
	}

	public OrderDTO setShipfromCompany(String shipfromCompany) {
		this.shipfromCompany = ClickshipStringUtil.getStringStripAccents(shipfromCompany);
		return this;
	}

	public String getShipfromAddress1() {
		return shipfromAddress1;
	}

	public OrderDTO setShipfromAddress1(String shipfromAddress1) {
		this.shipfromAddress1 = ClickshipStringUtil.getStringStripAccents(shipfromAddress1);
		return this;
	}

	public String getShipfromAddress2() {
		return shipfromAddress2;
	}

	public OrderDTO setShipfromAddress2(String shipfromAddress2) {
		this.shipfromAddress2 = ClickshipStringUtil.getStringStripAccents(shipfromAddress2);
		return this;
	}

	public String getShipfromCity() {
		return shipfromCity;
	}

	public OrderDTO setShipfromCity(String shipfromCity) {
		this.shipfromCity = ClickshipStringUtil.getStringStripAccents(shipfromCity);
		return this;
	}

	public String getShipfromProvinceState() {
		return shipfromProvinceState;
	}

	public OrderDTO setShipfromProvinceState(String shipfromProvinceState) {
		this.shipfromProvinceState = shipfromProvinceState;
		return this;
	}

	public String getShipfromCountry() {
		return shipfromCountry;
	}

	public OrderDTO setShipfromCountry(String shipfromCountry) {
		this.shipfromCountry = shipfromCountry;
		return this;
	}

	public String getShipfromZip() {
		return shipfromZip;
	}

	public OrderDTO setShipfromZip(String shipfromZip) {
		this.shipfromZip = shipfromZip;
		return this;
	}

	public String getShipfromPhone() {
		return shipfromPhone;
	}

	public OrderDTO setShipfromPhone(String shipfromPhone) {
		this.shipfromPhone = shipfromPhone;
		return this;
	}

	public String getShipfromAttention() {
		return shipfromAttention;
	}

	public OrderDTO setShipfromAttention(String shipfromAttention) {
		this.shipfromAttention = ClickshipStringUtil.getStringStripAccents(shipfromAttention);
		return this;
	}

	public String getShipfromEmail() {
		return shipfromEmail;
	}

	public OrderDTO setShipfromEmail(String shipfromEmail) {
		this.shipfromEmail = shipfromEmail;
		return this;
	}

	public String getShiptoContact() {
		return shiptoContact;
	}

	public OrderDTO setShiptoContact(String shiptoContact) {
		this.shiptoContact = ClickshipStringUtil.getStringStripAccents(shiptoContact);
		return this;
	}

	public String getShiptoCompany() {
		return shiptoCompany;
	}

	public OrderDTO setShiptoCompany(String shiptoCompany) {
		this.shiptoCompany = ClickshipStringUtil.getStringStripAccents(shiptoCompany);
		return this;
	}

	public String getShiptoAddress1() {
		return shiptoAddress1;
	}

	public OrderDTO setShiptoAddress1(String shiptoAddress1) {
		this.shiptoAddress1 = ClickshipStringUtil.getStringStripAccents(shiptoAddress1);
		return this;
	}

	public String getShiptoAddress2() {
		return shiptoAddress2;
	}

	public OrderDTO setShiptoAddress2(String shiptoAddress2) {
		this.shiptoAddress2 = ClickshipStringUtil.getStringStripAccents(shiptoAddress2);
		return this;
	}

	public String getShiptoCity() {
		return shiptoCity;
	}

	public OrderDTO setShiptoCity(String shiptoCity) {
		this.shiptoCity = ClickshipStringUtil.getStringStripAccents(shiptoCity);
		return this;
	}

	public String getShiptoProvinceState() {
		return shiptoProvinceState;
	}

	public OrderDTO setShiptoProvinceState(String shiptoProvinceState) {
		this.shiptoProvinceState = shiptoProvinceState;
		return this;
	}

	public String getShiptoCountry() {
		return shiptoCountry;
	}

	public OrderDTO setShiptoCountry(String shiptoCountry) {
		this.shiptoCountry = shiptoCountry;
		return this;
	}

	public String getShiptoZip() {
		return shiptoZip;
	}

	public OrderDTO setShiptoZip(String shiptoZip) {
		this.shiptoZip = shiptoZip;
		return this;
	}

	public String getShiptoPhone() {
		return shiptoPhone;
	}

	public OrderDTO setShiptoPhone(String shiptoPhone) {
		this.shiptoPhone = ClickshipStringUtil.removeSpecialCharsAndAreaCode(shiptoPhone);
		return this;
	}

	public String getShiptoEmail() {
		return shiptoEmail;
	}

	public OrderDTO setShiptoEmail(String shiptoEmail) {
		this.shiptoEmail = shiptoEmail;
		return this;
	}

	public String getNote() {
		return note;
	}

	public OrderDTO setNote(String note) {
		this.note = note;
		return this;
	}

	public String getShortName() {
		return shortName;
	}

	public OrderDTO setShortName(String shortName) {
		this.shortName = shortName;
		return this;
	}

	public String getService() {
		return service;
	}

	public OrderDTO setService(String service) {
		this.service = service;
		return this;
	}

	public List<BoxDTO> getPackages() {
		return packages;
	}

	public OrderDTO setPackages(List<BoxDTO> packages) {
		this.packages = packages;
		return this;
	}
	
	public OrderDTO addPackage(BoxDTO box) {
		if (this.packages == null) {
			this.packages = new ArrayList<>();
		}
		this.packages.add(box);
		return this;
	}

	public CustomsInvoiceDTO getCustomsInvoice() {
		return customsInvoice;
	}

	public OrderDTO setCustomsInvoice(CustomsInvoiceDTO customsInvoice) {
		this.customsInvoice = customsInvoice;
		return this;
	}

	public PickupDTO getPickup() {
		return pickup;
	}

	public OrderDTO setPickup(PickupDTO pickup) {
		this.pickup = pickup;
		return this;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public OrderDTO setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
		return this;
	}

	public List<OrderlineDTO> getItems() {
		return items;
	}

	public OrderDTO setItems(List<OrderlineDTO> items) {
		this.items = items;
		return this;
	}

	public boolean getAdultSignatureRequired() {
		return adultSignatureRequired;
	}

	public OrderDTO setAdultSignatureRequired(boolean adultSignatureRequired) {
		this.adultSignatureRequired = adultSignatureRequired;
		return this;
	}

	public boolean getSignatureRequired() {
		return signatureRequired;
	}

	public OrderDTO setSignatureRequired(boolean signatureRequired) {
		this.signatureRequired = signatureRequired;
		return this;
	}

	public boolean getResidentialDelivery() {
		return residentialDelivery;
	}

	public OrderDTO setResidentialDelivery(boolean residentialDelivery) {
		this.residentialDelivery = residentialDelivery;
		return this;
	}

	public boolean getSaturdayDelivery() {
		return saturdayDelivery;
	}

	public OrderDTO setSaturdayDelivery(boolean saturdayDelivery) {
		this.saturdayDelivery = saturdayDelivery;
		return this;
	}

	public boolean getSaturdayPickup() {
		return saturdayPickup;
	}

	public OrderDTO setSaturdayPickup(boolean saturdayPickup) {
		this.saturdayPickup = saturdayPickup;
		return this;
	}

	public boolean getSchedulePickUp() {
		return schedulePickUp;
	}

	public OrderDTO setSchedulePickUp(boolean schedulePickUp) {
		this.schedulePickUp = schedulePickUp;
		return this;
	}

	public int getInsuranceType() {
		return insuranceType;
	}

	public OrderDTO setInsuranceType(int insuranceType) {
		this.insuranceType = insuranceType;
		return this;
	}

	public Double getInsuranceAmount() {
		return insuranceAmount;
	}

	public OrderDTO setInsuranceAmount(Double insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
		return this;
	}
	
	public String getInsuranceCurrency() {
		return insuranceCurrency;
	}

	public OrderDTO setInsuranceCurrency(String insuranceCurrency) {
		this.insuranceCurrency = insuranceCurrency;
		return this;
	}

	public boolean isInsuranceTermsAgree() {
		return isInsuranceTermsAgree;
	}

	public OrderDTO setInsuranceTermsAgree(boolean isInsuranceTermsAgree) {
		this.isInsuranceTermsAgree = isInsuranceTermsAgree;
		return this;
	}

	public boolean isInsuranceApplied() {
		return isInsuranceApplied;
	}

	public OrderDTO setInsuranceApplied(boolean isInsuranceApplied) {
		this.isInsuranceApplied = isInsuranceApplied;
		return this;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public OrderDTO setCarrierName(String carrierName) {
		this.carrierName = carrierName;
		return this;
	}

	public Double getShippingCost() {
		return shippingCost;
	}

	public OrderDTO setShippingCost(Double shippingCost) {
		this.shippingCost = shippingCost;
		return this;
	}

	public boolean isCarrierRate() {
		return carrierRate;
	}

	public OrderDTO setCarrierRate(boolean carrierRate) {
		this.carrierRate = carrierRate;
		return this;
	}

	public String getCarrierServiceName() {
		return carrierServiceName;
	}

	public OrderDTO setCarrierServiceName(String carrierServiceName) {
		this.carrierServiceName = carrierServiceName;
		return this;
	}

	public String getCarrierAccountNumber() {
		return carrierAccountNumber;
	}

	public OrderDTO setCarrierAccountNumber(String carrierAccountNumber) {
		this.carrierAccountNumber = carrierAccountNumber;
		return this;
	}

	public String getLocationId() {
		return locationId;
	}

	public OrderDTO setLocationId(String locationId) {
		this.locationId = locationId;
		return this;
	}

	public boolean isManualShipment() {
		return manualShipment;
	}

	public OrderDTO setManualShipment(boolean isManualShipment) {
		this.manualShipment = isManualShipment;
		return this;
	}

	public String getShipfromAddressIdx() {
		return shipfromAddressIdx;
	}

	public OrderDTO setShipfromAddressIdx(String shipfromAddressIdx) {
		this.shipfromAddressIdx = shipfromAddressIdx;
		return this;
	}

	public String getShipfromPhoneExt() {
		return shipfromPhoneExt;
	}

	public OrderDTO setShipfromPhoneExt(String shipfromPhoneExt) {
		this.shipfromPhoneExt = shipfromPhoneExt;
		return this;
	}

	public String getShiptoPhoneExt() {
		return shiptoPhoneExt;
	}

	public OrderDTO setShiptoPhoneExt(String shiptoPhoneExt) {
		this.shiptoPhoneExt = shiptoPhoneExt;
		return this;
	}
	
	public boolean isReturnLabel() {
		return returnLabel;
	}

	public OrderDTO setReturnLabel(boolean isReturnLabel) {
		this.returnLabel = isReturnLabel;
		return this;
	}

	public String getReturnLabelOrderId() {
		return returnLabelOrderId;
	}

	public OrderDTO setReturnLabelOrderId(String returnLabelOrderId) {
		this.returnLabelOrderId = returnLabelOrderId;
		return this;
	}

	public String getCurrency() {
		return currency;
	}

	public OrderDTO setCurrency(String currency) {
		this.currency = currency;
		return this;
	}

	public String getPackageType() {
		return packageType;
	}

	public OrderDTO setPackageType(String packageType) {
		this.packageType = packageType;
		return this;
	}

	public String getExternalOrderId() {
		return externalOrderId;
	}

	public OrderDTO setExternalOrderId(String externalOrderId) {
		this.externalOrderId = externalOrderId;
		return this;
	}

	public List<AdditionalServicesDTO> getAdditionalServices() {
		return additionalServices;
	}

	public OrderDTO setAdditionalServices(List<AdditionalServicesDTO> additionalServices) {
		this.additionalServices = additionalServices;
		return this;
	}

	public String getPickupInstructions() {
		return pickupInstructions;
	}

	public OrderDTO setPickupInstructions(String pickupInstructions) {
		this.pickupInstructions = StringUtils.left(pickupInstructions, 500);
		return this;
	}

	public String getDeliveryInstructions() {
		return deliveryInstructions;
	}

	public OrderDTO setDeliveryInstructions(String deliveryInstructions) {
		this.deliveryInstructions = StringUtils.left(deliveryInstructions, 500);
		return this;
	}

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public OrderDTO setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
		return this;
	}

	public Integer getEstimatedDate() {
		return estimatedDate;
	}

	public void setEstimatedDate(Integer estimatedDate) {
		this.estimatedDate = estimatedDate;
	}

	public boolean isInternationalShipment() {
		return isInternationalShipment;
	}

	public OrderDTO setInternationalShipment(boolean isInternationalShipment) {
		this.isInternationalShipment = isInternationalShipment;
		return this;
	}

	public String getAppliedShippingRuleName() {
		return appliedShippingRuleName;
	}

	public OrderDTO setAppliedShippingRuleName(String appliedShippingRuleName) {
		this.appliedShippingRuleName = appliedShippingRuleName;
		return this;
	}

	public String getReferenceCode() {
		return referenceCode;
	}

	public OrderDTO setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
		return this;
	}

	public List<KeyValue> getReferenceCodeList() {
		return referenceCodeList;
	}

	public void setReferenceCodeList(List<KeyValue> referenceCodeList) {
		this.referenceCodeList = referenceCodeList;
	}

	public String getExpectedShipDate() {
		return expectedShipDate;
	}

	public OrderDTO setExpectedShipDate(String expectedShipDate) {
		this.expectedShipDate = expectedShipDate;
		return this;
	}

	public boolean isEncrypted() {
		return isEncrypted;
	}

	public OrderDTO setEncrypted(boolean isEncrypted) {
		this.isEncrypted = isEncrypted;
		return this;
	}

	public boolean isPaperlessCustomsInvoice() {
		return isPaperlessCustomsInvoice;
	}

	public OrderDTO setPaperlessCustomsInvoice(boolean isPaperlessCustomsInvoice) {
		this.isPaperlessCustomsInvoice = isPaperlessCustomsInvoice;
		return this;
	}

	public String getRateRequestId() {
		return rateRequestId;
	}

	public OrderDTO setRateRequestId(String rateRequestId) {
		this.rateRequestId = rateRequestId;
		return this;
	}

	public List<RateDTO> getRatesDto() {
		return ratesDto;
	}

	public Date getShipDate() {
		return shipDate;
	}

	public OrderDTO setShipDate(Date shipDate) {
		this.shipDate = shipDate;
		return this;
	}

	public OrderDTO setRatesDto(List<RateDTO> ratesDto) {
		this.ratesDto = ratesDto;
		return this;
	}

	public Double getOriginalTotal() {
		return originalTotal;
	}

	public OrderDTO setOriginalTotal(Double originalTotal) {
		this.originalTotal = originalTotal;
		return this;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public OrderDTO setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
		return this;
	}

	public Integer getPercentage() {
		return percentage;
	}

	public OrderDTO setPercentage(Integer percentage) {
		this.percentage = percentage;
		return this;
	}

	public Integer getTotalRates() {
		return totalRates;
	}

	public OrderDTO setTotalRates(Integer totalRates) {
		this.totalRates = totalRates;
		return this;
	}

	public Integer getCompletedRates() {
		return completedRates;
	}

	public OrderDTO setCompletedRates(Integer completedRates) {
		this.completedRates = completedRates;
		return this;
	}

	public String getPickupType() {
		return pickupType;
	}

	public OrderDTO setPickupType(String pickupType) {
		this.pickupType = pickupType;
		return this;
	}

	public String getPalletRateRequestId() {
		return palletRateRequestId;
	}

	public OrderDTO setPalletRateRequestId(String palletRateRequestId) {
		this.palletRateRequestId = palletRateRequestId;
		return this;
	}

	public String getSeletedRateType() {
		return seletedRateType;
	}

	public OrderDTO setSeletedRateType(String seletedRateType) {
		this.seletedRateType = seletedRateType;
		return this;
	}

	public boolean isFetchingRatesCompleted() {
		return fetchingRatesCompleted;
	}

	public OrderDTO setFetchingRatesCompleted(boolean fetchingRatesCompleted) {
		this.fetchingRatesCompleted = fetchingRatesCompleted;
		return this;
	}

	public Boolean getShowPalletAndPackageRates() {
		return showPalletAndPackageRates;
	}

	public OrderDTO setShowPalletAndPackageRates(Boolean showPalletAndPackageRates) {
		this.showPalletAndPackageRates = showPalletAndPackageRates;
		return this;
	}

	public boolean isFetchingPalletRatesCompleted() {
		return fetchingPalletRatesCompleted;
	}

	public OrderDTO setFetchingPalletRatesCompleted(boolean fetchingPalletRatesCompleted) {
		this.fetchingPalletRatesCompleted = fetchingPalletRatesCompleted;
		return this;
	}

	public String getShiptoFloor() {
		return shiptoFloor;
	}

	public OrderDTO setShiptoFloor(String shiptoFloor) {
		this.shiptoFloor = shiptoFloor;
		return this;
	}

	public String getShipfromFloor() {
		return shipfromFloor;
	}

	public OrderDTO setShipfromFloor(String shipfromFloor) {
		this.shipfromFloor = shipfromFloor;
		return this;
	}

	public String getShiptoOpensAt() {
		return shiptoOpensAt;
	}

	public OrderDTO setShiptoOpensAt(String shiptoOpensAt) {
		this.shiptoOpensAt = shiptoOpensAt;
		return this;
	}

	public String getShiptoClosesAt() {
		return shiptoClosesAt;
	}

	public OrderDTO setShiptoClosesAt(String shiptoClosesAt) {
		this.shiptoClosesAt = shiptoClosesAt;
		return this;
	}

	public String getShipfromOpensAt() {
		return shipfromOpensAt;
	}

	public OrderDTO setShipfromOpensAt(String shipfromOpensAt) {
		this.shipfromOpensAt = shipfromOpensAt;
		return this;
	}

	public String getShipfromClosesAt() {
		return shipfromClosesAt;
	}

	public OrderDTO setShipfromClosesAt(String shipfromClosesAt) {
		this.shipfromClosesAt = shipfromClosesAt;
		return this;
	}

	public String getShiptoLocationType() {
		return shiptoLocationType;
	}

	public OrderDTO setShiptoLocationType(String shiptoLocationType) {
		this.shiptoLocationType = shiptoLocationType;
		return this;
	}

	public String getShipfromLocationType() {
		return shipfromLocationType;
	}

	public OrderDTO setShipfromLocationType(String shipfromLocationType) {
		this.shipfromLocationType = shipfromLocationType;
		return this;
	}

	public Boolean getPickupTailgate() {
		return pickupTailgate;
	}

	public OrderDTO setPickupTailgate(Boolean pickupTailgate) {
		this.pickupTailgate = pickupTailgate;
		return this;
	}

	public Boolean getDeliveryTailgate() {
		return deliveryTailgate;
	}

	public OrderDTO setDeliveryTailgate(Boolean deliveryTailgate) {
		this.deliveryTailgate = deliveryTailgate;
		return this;
	}

	public String getAddressBookId() {
		return addressBookId;
	}

	public OrderDTO setAddressBookId(String addressBookId) {
		this.addressBookId = addressBookId;
		return this;
	}

	public Boolean getSaveLocation() {
		return saveLocation;
	}

	public OrderDTO setSaveLocation(Boolean saveLocation) {
		this.saveLocation = saveLocation;
		return this;
	}

	public Boolean getSaveAddressBook() {
		return saveAddressBook;
	}

	public OrderDTO setSaveAddressBook(Boolean saveAddressBook) {
		this.saveAddressBook = saveAddressBook;
		return this;
	}
	
	public Boolean getSaveAsNewLocation() {
		return saveAsNewLocation;
	}

	public OrderDTO setSaveAsNewLocation(Boolean saveAsNewLocation) {
		this.saveAsNewLocation = saveAsNewLocation;
		return this;
	}

	public Boolean getSaveAsDefaultLocation() {
		return saveAsDefaultLocation;
	}

	public OrderDTO setSaveAsDefaultLocation(Boolean saveAsDefaultLocation) {
		this.saveAsDefaultLocation = saveAsDefaultLocation;
		return this;
	}

	public Date getEstimatedShipDate() {
		return estimatedShipDate;
	}

	public OrderDTO setEstimatedShipDate(Date estimatedShipDate) {
		this.estimatedShipDate = estimatedShipDate;
		return this;
	}

	public String getSignatureRequirement() {
		return signatureRequirement;
	}

	public OrderDTO setSignatureRequirement(String signatureRequirement) {
		this.signatureRequirement = signatureRequirement;
		return this;
	}

	public Boolean getResidentialPickup() {
		return residentialPickup;
	}

	public OrderDTO setResidentialPickup(Boolean residentialPickup) {
		this.residentialPickup = residentialPickup;
		return this;
	}

	public Boolean getIncludesReturnLabel() {
		return includesReturnLabel;
	}

	public OrderDTO setIncludesReturnLabel(Boolean includesReturnLabel) {
		this.includesReturnLabel = includesReturnLabel;
		return this;
	}

	public PalletServicesDTO getPalletServices() {
		return palletServices;
	}

	public OrderDTO setPalletServices(PalletServicesDTO palletServices) {
		this.palletServices = palletServices;
		return this;
	}

	public Double getOriginalShippingCost() {
		return originalShippingCost;
	}

	public void setOriginalShippingCost(Double originalShippingCost) {
		this.originalShippingCost = originalShippingCost;
	}

	public String getOriginalShippingCurrency() {
		return originalShippingCurrency;
	}

	public void setOriginalShippingCurrency(String originalShippingCurrency) {
		this.originalShippingCurrency = originalShippingCurrency;
	}

	public boolean isAutoFulfilled() {
		return autoFulfilled;
	}

	public void setAutoFulfilled(boolean autoFulfilled) {
		this.autoFulfilled = autoFulfilled;
	}

	public boolean isLabelAccessed() {
		return labelAccessed;
	}

	public void setLabelAccessed(boolean labelAccessed) {
		this.labelAccessed = labelAccessed;
	}

	public String getAppliedRTRShippingRuleName() {
		return appliedRTRShippingRuleName;
	}

	public void setAppliedRTRShippingRuleName(String appliedRTRShippingRuleName) {
		this.appliedRTRShippingRuleName = appliedRTRShippingRuleName;
	}

	public String getShippingRuleErrors() {
		return shippingRuleErrors;
	}

	public void setShippingRuleErrors(String shippingRuleErrors) {
		this.shippingRuleErrors = shippingRuleErrors;
	}

	public String getShippingRuleWarning() {
		return shippingRuleWarning;
	}

	public void setShippingRuleWarning(String shippingRuleWarning) {
		this.shippingRuleWarning = shippingRuleWarning;
	}

	public boolean isShippingRuleRateFound() {
		return isShippingRuleRateFound;
	}

	public void setShippingRuleRateFound(boolean isShippingRuleRateFound) {
		this.isShippingRuleRateFound = isShippingRuleRateFound;
	}

	public String getSrRateServiceTypeCode() {
		return srRateServiceTypeCode;
	}

	public void setSrRateServiceTypeCode(String srRateServiceTypeCode) {
		this.srRateServiceTypeCode = srRateServiceTypeCode;
	}

	public String getSrRateServiceType() {
		return srRateServiceType;
	}

	public void setSrRateServiceType(String srRateServiceType) {
		this.srRateServiceType = srRateServiceType;
	}

	public Double getSrRateShippingCost() {
		return srRateShippingCost;
	}

	public void setSrRateShippingCost(Double srRateShippingCost) {
		this.srRateShippingCost = srRateShippingCost;
	}

	public String getSrRateShippingCurrency() {
		return srRateShippingCurrency;
	}

	public void setSrRateShippingCurrency(String srRateShippingCurrency) {
		this.srRateShippingCurrency = srRateShippingCurrency;
	}

	public int getSrRateTransitTime() {
		return srRateTransitTime;
	}

	public void setSrRateTransitTime(int srRateTransitTime) {
		this.srRateTransitTime = srRateTransitTime;
	}

	public Date getSrRateFetchedTime() {
		return srRateFetchedTime;
	}

	public void setSrRateFetchedTime(Date srRateFetchedTime) {
		this.srRateFetchedTime = srRateFetchedTime;
	}

	public String getSrCarrierShortName() {
		return srCarrierShortName;
	}

	public void setSrCarrierShortName(String srCarrierShortName) {
		this.srCarrierShortName = srCarrierShortName;
	}

	public String getSrCarrierImageName() {
		return srCarrierImageName;
	}

	public void setSrCarrierImageName(String srCarrierImageName) {
		this.srCarrierImageName = srCarrierImageName;
	}

	public boolean isShippingRuleInProgress() {
		return shippingRuleInProgress;
	}

	public void setShippingRuleInProgress(boolean shippingRuleInProgress) {
		this.shippingRuleInProgress = shippingRuleInProgress;
	}

	public String getSrRateRequestId() {
		return srRateRequestId;
	}

	public void setSrRateRequestId(String srRateRequestId) {
		this.srRateRequestId = srRateRequestId;
	}
	
	public PickupWhileShipmentDTO getPickupWhileShipmentDTO() {
		return pickupWhileShipmentDTO;
	}

	public void setPickupWhileShipmentDTO(PickupWhileShipmentDTO pickupWhileShipmentDTO) {
		this.pickupWhileShipmentDTO = pickupWhileShipmentDTO;
	}
}
