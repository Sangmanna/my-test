package com.freightcom.clickship.model.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.freightcom.clickship.model.CommonDTO;
import com.freightcom.clickship.model.box.BoxDTO;
import com.freightcom.clickship.model.enums.InsuranceType;

public class QuoteDTO extends CommonDTO implements Serializable {

	private static final long serialVersionUID = 7088433240154205687L;
	
	private String id;
	private String fromId;
	private String shipfromCity;
	private String shipfromProvinceState;
	private String shipfromCountry;
	private String shipfromZip;
	private String shiptoCity;
	private String shiptoProvinceState;
	private String shiptoCountry;
	private String shiptoZip;
	private String service;
	private String currency;
	private String shortName;
	private String carrierName;
	private int estimatedDate;
	private Double shippingCost;
	private boolean carrierRate = false;
	private String carrierServiceName;
	private String carrierAccountNumber;
	private List<BoxDTO> packages = new ArrayList<>();
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
	private boolean manualShipment = false;
	private String packageType;
	private List<AdditionalServicesDTO> additionalServices = new ArrayList<>();
	private String pickupInstructions;
	private String deliveryInstructions;

	public String getId() {
		return id;
	}

	public QuoteDTO setId(String id) {
		this.id = id;
		return this;
	}

	public String getFromId() {
		return fromId;
	}

	public QuoteDTO setFromId(String fromId) {
		this.fromId = fromId;
		return this;
	}

	public String getShipfromCity() {
		return shipfromCity;
	}

	public QuoteDTO setShipfromCity(String shipfromCity) {
		this.shipfromCity = shipfromCity;
		return this;
	}

	public String getShipfromProvinceState() {
		return shipfromProvinceState;
	}

	public QuoteDTO setShipfromProvinceState(String shipfromProvinceState) {
		this.shipfromProvinceState = shipfromProvinceState;
		return this;
	}

	public String getShipfromCountry() {
		return shipfromCountry;
	}

	public QuoteDTO setShipfromCountry(String shipfromCountry) {
		this.shipfromCountry = shipfromCountry;
		return this;
	}

	public String getShipfromZip() {
		return shipfromZip;
	}

	public QuoteDTO setShipfromZip(String shipfromZip) {
		this.shipfromZip = shipfromZip;
		return this;
	}

	public String getShiptoCity() {
		return shiptoCity;
	}

	public QuoteDTO setShiptoCity(String shiptoCity) {
		this.shiptoCity = shiptoCity;
		return this;
	}

	public String getShiptoProvinceState() {
		return shiptoProvinceState;
	}

	public QuoteDTO setShiptoProvinceState(String shiptoProvinceState) {
		this.shiptoProvinceState = shiptoProvinceState;
		return this;
	}

	public String getShiptoCountry() {
		return shiptoCountry;
	}

	public QuoteDTO setShiptoCountry(String shiptoCountry) {
		this.shiptoCountry = shiptoCountry;
		return this;
	}

	public String getShiptoZip() {
		return shiptoZip;
	}

	public QuoteDTO setShiptoZip(String shiptoZip) {
		this.shiptoZip = shiptoZip;
		return this;
	}

	public String getService() {
		return service;
	}

	public QuoteDTO setService(String service) {
		this.service = service;
		return this;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public QuoteDTO setCarrierName(String carrierName) {
		this.carrierName = carrierName;
		return this;
	}

	public String getCarrierServiceName() {
		return carrierServiceName;
	}

	public QuoteDTO setCarrierServiceName(String carrierServiceName) {
		this.carrierServiceName = carrierServiceName;
		return this;
	}

	public List<BoxDTO> getPackages() {
		return packages;
	}

	public QuoteDTO setPackages(List<BoxDTO> packages) {
		this.packages = packages;
		return this;
	}

	public boolean isAdultSignatureRequired() {
		return adultSignatureRequired;
	}

	public QuoteDTO setAdultSignatureRequired(boolean adultSignatureRequired) {
		this.adultSignatureRequired = adultSignatureRequired;
		return this;
	}

	public boolean isSignatureRequired() {
		return signatureRequired;
	}

	public QuoteDTO setSignatureRequired(boolean signatureRequired) {
		this.signatureRequired = signatureRequired;
		return this;
	}

	public boolean isResidentialDelivery() {
		return residentialDelivery;
	}

	public QuoteDTO setResidentialDelivery(boolean residentialDelivery) {
		this.residentialDelivery = residentialDelivery;
		return this;
	}

	public boolean isSaturdayDelivery() {
		return saturdayDelivery;
	}

	public QuoteDTO setSaturdayDelivery(boolean saturdayDelivery) {
		this.saturdayDelivery = saturdayDelivery;
		return this;
	}

	public boolean isSaturdayPickup() {
		return saturdayPickup;
	}

	public QuoteDTO setSaturdayPickup(boolean saturdayPickup) {
		this.saturdayPickup = saturdayPickup;
		return this;
	}

	public boolean isSchedulePickUp() {
		return schedulePickUp;
	}

	public QuoteDTO setSchedulePickUp(boolean schedulePickUp) {
		this.schedulePickUp = schedulePickUp;
		return this;
	}

	public int getInsuranceType() {
		return insuranceType;
	}

	public QuoteDTO setInsuranceType(int insuranceType) {
		this.insuranceType = insuranceType;
		return this;
	}

	public Double getInsuranceAmount() {
		return insuranceAmount;
	}

	public QuoteDTO setInsuranceAmount(Double insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
		return this;
	}

	public String getInsuranceCurrency() {
		return insuranceCurrency;
	}

	public QuoteDTO setInsuranceCurrency(String insuranceCurrency) {
		this.insuranceCurrency = insuranceCurrency;
		return this;
	}

	public boolean isInsuranceTermsAgree() {
		return isInsuranceTermsAgree;
	}

	public QuoteDTO setInsuranceTermsAgree(boolean isInsuranceTermsAgree) {
		this.isInsuranceTermsAgree = isInsuranceTermsAgree;
		return this;
	}

	public boolean isManualShipment() {
		return manualShipment;
	}

	public QuoteDTO setManualShipment(boolean manualShipment) {
		this.manualShipment = manualShipment;
		return this;
	}

	public String getPackageType() {
		return packageType;
	}

	public QuoteDTO setPackageType(String packageType) {
		this.packageType = packageType;
		return this;
	}

	public List<AdditionalServicesDTO> getAdditionalServices() {
		return additionalServices;
	}

	public QuoteDTO setAdditionalServices(List<AdditionalServicesDTO> additionalServices) {
		this.additionalServices = additionalServices;
		return this;
	}

	public String getPickupInstructions() {
		return pickupInstructions;
	}

	public QuoteDTO setPickupInstructions(String pickupInstructions) {
		this.pickupInstructions = pickupInstructions;
		return this;
	}

	public String getDeliveryInstructions() {
		return deliveryInstructions;
	}

	public QuoteDTO setDeliveryInstructions(String deliveryInstructions) {
		this.deliveryInstructions = deliveryInstructions;
		return this;
	}

	public String getCurrency() {
		return currency;
	}

	public QuoteDTO setCurrency(String currency) {
		this.currency = currency;
		return this;
	}

	public String getShortName() {
		return shortName;
	}

	public QuoteDTO setShortName(String shortName) {
		this.shortName = shortName;
		return this;
	}

	public int getEstimatedDate() {
		return estimatedDate;
	}

	public void setEstimatedDate(int estimatedDate) {
		this.estimatedDate = estimatedDate;
	}

	public Double getShippingCost() {
		return shippingCost;
	}

	public QuoteDTO setShippingCost(Double shippingCost) {
		this.shippingCost = shippingCost;
		return this;
	}

	public boolean isCarrierRate() {
		return carrierRate;
	}

	public QuoteDTO setCarrierRate(boolean carrierRate) {
		this.carrierRate = carrierRate;
		return this;
	}

	public String getCarrierAccountNumber() {
		return carrierAccountNumber;
	}

	public QuoteDTO setCarrierAccountNumber(String carrierAccountNumber) {
		this.carrierAccountNumber = carrierAccountNumber;
		return this;
	}

}
