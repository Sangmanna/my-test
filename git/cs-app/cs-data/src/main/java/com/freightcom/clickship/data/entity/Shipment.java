package com.freightcom.clickship.data.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freightcom.clickship.data.entity.common.BaseEntity;
import com.freightcom.clickship.data.entity.common.CustomerAssociateEntity;
import com.freightcom.clickship.model.constants.ClickShipConstants;
import com.freightcom.clickship.model.util.ClickshipStringUtil;
import com.freightcom.clickship.model.util.Security;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "shipment")
public class Shipment extends BaseEntity implements CustomerAssociateEntity {

	private static final long serialVersionUID = -3937502878554288849L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "order_id", nullable = true, updatable = false)
	@JsonIgnore
	private Order order;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", nullable = false, updatable = false)
	@JsonIgnore
	private Customer customer;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "invoice_id", nullable = true, updatable = true)
	@JsonIgnore
	private Invoice invoice;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "custom_invoice_id")
	@JsonIgnore
	private Invoice customInvoice;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "promo_id", nullable = true, updatable = true)
	@JsonIgnore
	private Promo promo;

	@Column(name = "carrier_shipment_id")
	private String carrierShipmentId;

	@Column(name = "carrier_group_id")
	private String carrierGroupId;

	@Column(name = "shipfrom_company")
	private String shipfromCompany;

	@Column(name = "shipfrom_contact")
	private String shipfromContact;

	@Column(name = "shipfrom_email")
	private String shipfromEmail;

	@Column(name = "shipfrom_phone")
	private String shipfromPhone;

	@Column(name = "shipfrom_phone_ext")
	private String shipfromPhoneExt;

	@Column(name = "shipfrom_address1")
	private String shipfromAddress1;

	@Column(name = "shipfrom_address2")
	private String shipfromAddress2;

	@Column(name = "shipfrom_address3")
	private String shipfromAddress3;

	@Column(name = "shipfrom_city")
	private String shipfromCity;

	@Column(name = "shipfrom_province_state")
	private String shipfromProvinceState;

	@Column(name = "shipfrom_country")
	private String shipfromCountry;

	@Column(name = "shipfrom_postalcode")
	private String shipfromPostalcode;

	@Column(name = "shipfrom_floor")
	private String shipfromFloor;

	@Column(name = "shipfrom_opens_at")
	private String shipfromOpensAt;

	@Column(name = "shipfrom_closes_at")
	private String shipfromClosesAt;

	@Column(name = "shipfrom_location_type")
	private String shipfromLocationType = "";

	@Column(name = "pickup_tailgate")
	private Boolean pickupTailgate = false;

	@Column(name = "shipto_contact")
	private String shiptoContact;

	@Column(name = "shipto_company")
	private String shiptoCompany;

	@Column(name = "shipto_email")
	private String shiptoEmail;

	@Column(name = "shipto_phone")
	private String shiptoPhone;

	@Column(name = "shipto_phone_ext")
	private String shiptoPhoneExt;

	@Column(name = "shipto_address1")
	private String shiptoAddress1;

	@Column(name = "shipto_address2")
	private String shiptoAddress2;

	@Column(name = "shipto_address3")
	private String shiptoAddress3;

	@Column(name = "shipto_city")
	private String shiptoCity;

	@Column(name = "shipto_province_state")
	private String shiptoProvinceState;

	@Column(name = "shipto_country")
	private String shiptoCountry;

	@Column(name = "shipto_postalcode")
	private String shiptoPostalcode;
	
	@Column(name = "shipto_floor")
	private String shiptoFloor;
	
	@Column(name = "shipto_opens_at")
	private String shiptoOpensAt;

	@Column(name = "shipto_closes_at")
	private String shiptoClosesAt;

	@Column(name = "shipto_location_type")
	private String shiptoLocationType;

	@Column(name = "delivery_tailgate")
	private Boolean deliveryTailgate = false;

	@Column(name = "label_path")
	private String labelPath;
	
	@Column(name = "shipment_details_path")
	private String shipmentDetailsPath;

	@Column(name = "shipment_type")
	private String shipmentType = ClickShipConstants.MANUAL_SHIPMENT_TYPE;

	@Column(name = "package_type")
	private String packageType;
	
	@Column(name = "pickup_type")
	private String pickupType = "now";

	@Column(name = "insurance_currency")
	private String insuranceCurrency;

	@Column(name = "active")
	private Boolean active = true;

	@Column(name = "adult_signature_required")
	private Boolean adultSignatureRequired;

	@Column(name = "signature_required")
	private Boolean signatureRequired;

	@Column(name = "residential_pickup")
	private Boolean residentialPickup;

	@Column(name = "residential_delivery")
	private Boolean residentialDelivery;

	@Column(name = "saturday_delivery")
	private Boolean saturdayDelivery;

	@Column(name = "saturday_pickup")
	private Boolean saturdayPickup;

	@Column(name = "scheduled_pickup")
	private Boolean schedulePickUp;

	@Column(name = "order_date")
	private Date orderDate;
	
	@Column(name = "est_del_date")
	private Date estDelDate;

	@Column(name = "order_number")
	private String orderNumber;

	@Column(name = "service_type")
	private String serviceType;

	@Column(name = "transmitted_to_carrier")
	private Boolean transmittedToCarrier = false;

	@Column(name = "manifest_id")
	private String manifestId;
	
	@Column(name = "freightcom_order_id")
	private String freightcomOrderId;
	
	@Column(name = "freightcom_v2_order_id")
	private String freightcomV2OrderId;
	
	@Column(name = "tracking_number")
	private String trackingNumber;
	
	@Column(name = "tracking_url")
	private String trackingURL;
	
	@Column(name = "status")
	private String status = "Ready";
	
	@Column(name = "status_description"	)
	private String statusDescription = "READY FOR SHIPPING";

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "carrier_code")
	@JsonIgnore
	private Carrier carrier;

	@Column(name = "tax_id")
	private String taxId;

	@Column(name = "shipping_account")
	private String shippingAccount;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "shipment", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Package> packages;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "shipment", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Pickup> pickups;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "shipment", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<ShipmentAdditionalServices> shipmentAdditionalServices;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "shipment", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<ShipmentTax> shipmentTaxList;
	
	@Column(name = "insurance_type")
	private Integer insuranceType;

	@Column(name = "pickup_instructions")
	private String pickupInstructions;
	
	@Column(name = "delivery_instructions")
	private String deliveryInstructions;

	@Column(name = "reference_code")
	private String referenceCode;
	
	@Column(name = "reference_code2")
	private String referenceCode2;
	
	@Column(name = "reference_code3")
	private String referenceCode3;

	@Column(name = "is_claims_raised")
	private Boolean isClaimsRaised = false;

	@Column(name = "is_encrypted")
	private boolean isEncrypted;
	
	@Column(name = "batch_id")
	private String batchId;

	@Column(name = "batch_number")
	private String batchNumber;
	
	@Column(name = "claim_id")
	private String claimId;
	
	@Column(name = "claim_status")
	private String claimStatus;

	public Pickup getPickup() {
		if (pickups != null) {
			Optional<Pickup> possible = pickups.stream().filter(Pickup::isStatus).findFirst();
			if (possible.isPresent())
				return possible.get();
		}
		return null;
	}

	public Shipment addPickup(Pickup pickup) {
		if (this.pickups == null) {
			this.pickups = new ArrayList<>();
		}
		pickup.setShipment(this);
		this.pickups.add(pickup);
		return this;
	}

	public String getId() {
		return id;
	}

	public Shipment setId(String id) {
		this.id = id;
		return this;
	}

	public Order getOrder() {
		return order;
	}

	public Shipment setOrder(Order order) {
		this.order = order;
		return this;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Shipment setCustomer(Customer customer) {
		this.customer = customer;
		return this;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public Shipment setInvoice(Invoice invoice) {
		this.invoice = invoice;
		return this;
	}

	public Promo getPromo() {
		return promo;
	}

	public Shipment setPromo(Promo promo) {
		this.promo = promo;
		return this;
	}

	public String getCarrierShipmentId() {
		return carrierShipmentId;
	}

	public Shipment setCarrierShipmentId(String carrierShipmentId) {
		this.carrierShipmentId = carrierShipmentId;
		return this;
	}

	public String getCarrierGroupId() {
		return carrierGroupId;
	}

	public Shipment setCarrierGroupId(String carrierGroupId) {
		this.carrierGroupId = carrierGroupId;
		return this;
	}

	public String getShipfromCompany() {
		return shipfromCompany;
	}

	public Shipment setShipfromCompany(String shipfromCompany) {
		this.shipfromCompany = ClickshipStringUtil.getStringStripAccents(shipfromCompany);
		return this;
	}

	public String getShipfromContact() {
		return shipfromContact;
	}

	public Shipment setShipfromContact(String shipfromContact) {
		this.shipfromContact = ClickshipStringUtil.getStringStripAccents(shipfromContact);
		return this;
	}

	public String getShipfromEmail() {
		return shipfromEmail;
	}

	public Shipment setShipfromEmail(String shipfromEmail) {
		this.shipfromEmail = shipfromEmail;
		return this;
	}

	public String getShipfromPhone() {
		return shipfromPhone;
	}

	public Shipment setShipfromPhone(String shipfromPhone) {
		this.shipfromPhone = shipfromPhone;
		return this;
	}

	public String getShipfromAddress1() {
		return shipfromAddress1;
	}

	public Shipment setShipfromAddress1(String shipfromAddress1) {
		this.shipfromAddress1 = ClickshipStringUtil.getStringStripAccents(shipfromAddress1);
		return this;
	}

	public String getShipfromAddress2() {
		return shipfromAddress2;
	}

	public Shipment setShipfromAddress2(String shipfromAddress2) {
		this.shipfromAddress2 = ClickshipStringUtil.getStringStripAccents(shipfromAddress2);
		return this;
	}

	public String getShipfromAddress3() {
		return shipfromAddress3;
	}

	public Shipment setShipfromAddress3(String shipfromAddress3) {
		this.shipfromAddress3 = shipfromAddress3;
		return this;
	}

	public String getShipfromCity() {
		return shipfromCity;
	}

	public Shipment setShipfromCity(String shipfromCity) {
		this.shipfromCity = shipfromCity;
		return this;
	}

	public String getShipfromProvinceState() {
		return shipfromProvinceState;
	}

	public Shipment setShipfromProvinceState(String shipfromProvinceState) {
		this.shipfromProvinceState = shipfromProvinceState;
		return this;
	}

	public String getShipfromCountry() {
		return shipfromCountry;
	}

	public Shipment setShipfromCountry(String shipfromCountry) {
		this.shipfromCountry = shipfromCountry;
		return this;
	}

	public String getShipfromPostalcode() {
		return shipfromPostalcode;
	}

	public Shipment setShipfromPostalcode(String shipfromPostalcode) {
		this.shipfromPostalcode = shipfromPostalcode;
		return this;
	}

	public String getShiptoContact() {		
		return checkAndReturnDecryptedData(this.shiptoContact);
	}

	public Shipment setShiptoContact(String shiptoContact) {
		this.shiptoContact = ClickshipStringUtil.getStringStripAccents(shiptoContact);
		return this;
	}

	public String getShiptoEmail() {
		return checkAndReturnDecryptedData(this.shiptoEmail);
	}

	public Shipment setShiptoEmail(String shiptoEmail) {
		this.shiptoEmail = shiptoEmail;
		return this;
	}

	public String getShiptoPhone() {	
		return checkAndReturnDecryptedData(this.shiptoPhone);
	}

	public Shipment setShiptoPhone(String shiptoPhone) {
		this.shiptoPhone = shiptoPhone;
		return this;
	}

	public String getShiptoAddress1() {		
		return checkAndReturnDecryptedData(this.shiptoAddress1);
	}

	public Shipment setShiptoAddress1(String shiptoAddress1) {
		this.shiptoAddress1 = ClickshipStringUtil.getStringStripAccents(shiptoAddress1);
		return this;
	}

	public String getShiptoAddress2() {
		return shiptoAddress2;
	}

	public Shipment setShiptoAddress2(String shiptoAddress2) {
		this.shiptoAddress2 = ClickshipStringUtil.getStringStripAccents(shiptoAddress2);
		return this;
	}

	public String getShiptoAddress3() {
		return shiptoAddress3;
	}

	public Shipment setShiptoAddress3(String shiptoAddress3) {
		this.shiptoAddress3 = shiptoAddress3;
		return this;
	}

	public String getShiptoCity() {
		return shiptoCity;
	}

	public Shipment setShiptoCity(String shiptoCity) {
		this.shiptoCity = shiptoCity;
		return this;
	}

	public String getShiptoProvinceState() {
		return shiptoProvinceState;
	}

	public Shipment setShiptoProvinceState(String shiptoProvinceState) {
		this.shiptoProvinceState = shiptoProvinceState;
		return this;
	}

	public String getShiptoCountry() {
		return shiptoCountry;
	}

	public Shipment setShiptoCountry(String shiptoCountry) {
		this.shiptoCountry = shiptoCountry;
		return this;
	}

	public String getShiptoPostalcode() {		
		return checkAndReturnDecryptedData(this.shiptoPostalcode);
	}

	public Shipment setShiptoPostalcode(String shiptoPostalcode) {
		this.shiptoPostalcode = shiptoPostalcode;
		return this;
	}

	public String getShipmentType() {
		return shipmentType;
	}

	public Shipment setShipmentType(String shipmentType) {
		this.shipmentType = shipmentType;
		return this;
	}
	
	public String getPackageType() {
		return packageType;
	}

	public Shipment setPackageType(String packageType) {
		this.packageType = packageType;
		return this;
	}

	public String getPickupType() {
		return pickupType;
	}

	public Shipment setPickupType(String pickupType) {
		this.pickupType = pickupType;
		return this;
	}

	public String getInsuranceCurrency() {
		return insuranceCurrency;
	}

	public Shipment setInsuranceCurrency(String insuranceCurrency) {
		this.insuranceCurrency = insuranceCurrency;
		return this;
	}

	public Boolean getActive() {
		return active;
	}

	public Boolean isActive() {
		return active;
	}

	public Shipment setActive(Boolean active) {
		this.active = active;
		return this;
	}

	public Boolean getAdultSignatureRequired() {
		return adultSignatureRequired;
	}

	public Shipment setAdultSignatureRequired(Boolean adultSignatureRequired) {
		this.adultSignatureRequired = adultSignatureRequired;
		return this;
	}

	public Boolean getSignatureRequired() {
		return signatureRequired;
	}

	public Shipment setSignatureRequired(Boolean signatureRequired) {
		this.signatureRequired = signatureRequired;
		return this;
	}

	public Boolean getResidentialDelivery() {
		return residentialDelivery;
	}

	public Shipment setResidentialDelivery(Boolean residentialDelivery) {
		this.residentialDelivery = residentialDelivery;
		return this;
	}

	public Boolean getSaturdayDelivery() {
		return saturdayDelivery;
	}

	public Shipment setSaturdayDelivery(Boolean saturdayDelivery) {
		this.saturdayDelivery = saturdayDelivery;
		return this;
	}

	public Boolean getSaturdayPickup() {
		return saturdayPickup;
	}

	public Shipment setSaturdayPickup(Boolean saturdayPickup) {
		this.saturdayPickup = saturdayPickup;
		return this;
	}

	public Boolean getSchedulePickUp() {
		return schedulePickUp;
	}

	public Shipment setSchedulePickUp(Boolean schedulePickUp) {
		this.schedulePickUp = schedulePickUp;
		return this;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public Shipment setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
		return this;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public Shipment setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
		return this;
	}

	public String getServiceType() {
		return serviceType;
	}

	public Shipment setServiceType(String serviceType) {
		this.serviceType = serviceType;
		return this;
	}

	public Carrier getCarrier() {
		return carrier;
	}

	public Shipment setCarrier(Carrier carrier) {
		this.carrier = carrier;
		return this;
	}

	public String getTaxId() {
		return taxId;
	}

	public Shipment setTaxId(String taxId) {
		this.taxId = taxId;
		return this;
	}

	public String getShippingAccount() {
		return shippingAccount;
	}

	public Shipment setShippingAccount(String shippingAccount) {
		this.shippingAccount = shippingAccount;
		return this;
	}

	public List<Package> getPackages() {
		return packages;
	}

	public Shipment setPackages(List<Package> packages) {
		this.packages = packages;
		return this;
	}

	public Shipment addPackages(Package pack) {
		if (this.packages == null) {
			this.packages = new ArrayList<>();
		}
		this.packages.add(pack);
		return this;
	}

	public List<Pickup> getPickups() {
		return pickups;
	}

	public Shipment setPickups(List<Pickup> pickups) {
		this.pickups = pickups;
		return this;
	}

	public List<ShipmentTax> getShipmentTaxList() {
		return shipmentTaxList;
	}

	public Shipment setShipmentTaxList(List<ShipmentTax> shipmentTaxList) {
		this.shipmentTaxList = shipmentTaxList;
		return this;
	}

	public boolean hasActivePickup() {
		return getPickup() != null;
	}

	public String getLabelPath() {
		return labelPath;
	}

	public Shipment setLabelPath(String labelPath) {
		this.labelPath = labelPath;
		return this;
	}
	
	public String getShipmentDetailsPath() {
		return shipmentDetailsPath;
	}

	public Shipment setShipmentDetailsPath(String shipmentDetailsPath) {
		this.shipmentDetailsPath = shipmentDetailsPath;
		return this;
	}

	public Invoice getCustomInvoice() {
		return customInvoice;
	}

	public Shipment setCustomInvoice(Invoice customInvoice) {
		this.customInvoice = customInvoice;
		return this;
	}

	public Shipment setTransmittedToCarrier(Boolean transmittedToCarrier) {
		this.transmittedToCarrier = transmittedToCarrier;
		return this;
	}

	public Boolean getTransmittedToCarrier() {
		return transmittedToCarrier;
	}

	public String getManifestId() {
		return manifestId;
	}

	public Shipment setManifestId(String manifestId) {
		this.manifestId = manifestId;
		return this;
	}

	public Integer getInsuranceType() {
		return insuranceType;
	}

	public Shipment setInsuranceType(Integer insuranceType) {
		this.insuranceType = insuranceType;
		return this;
	}

	public String getFreightcomOrderId() {
		return freightcomOrderId;
	}

	public Shipment setFreightcomOrderId(String freightcomOrderId) {
		this.freightcomOrderId = freightcomOrderId;
		return this;
	}
	
	public String getFreightcomV2OrderId() {
		return freightcomV2OrderId;
	}

	public void setFreightcomV2OrderId(String freightcomV2OrderId) {
		this.freightcomV2OrderId = freightcomV2OrderId;
	}

	public String getTrackingURL() {
		return trackingURL;
	}
	
	public Shipment setTrackingURL(String trackingURL) {
		this.trackingURL = trackingURL;
		return this;
	}
	
	public String getTrackingNumber() {
		return trackingNumber;
	}

	public Shipment setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
		return this;
	}

	public String getShiptoCompany() {	
		return checkAndReturnDecryptedData(this.shiptoCompany);
	}

	public Shipment setShiptoCompany(String shiptoCompany) {
		this.shiptoCompany = ClickshipStringUtil.getStringStripAccents(shiptoCompany);
		return this;
	}

	public String getShipfromPhoneExt() {
		return shipfromPhoneExt;
	}

	public Shipment setShipfromPhoneExt(String shipfromPhoneExt) {
		this.shipfromPhoneExt = shipfromPhoneExt;
		return this;
	}

	public String getShiptoPhoneExt() {
		return shiptoPhoneExt;
	}

	public Shipment setShiptoPhoneExt(String shiptoPhoneExt) {
		this.shiptoPhoneExt = shiptoPhoneExt;
		return this;
	}
	
	public String getPickupInstructions() {
		return pickupInstructions;
	}

	public Shipment setPickupInstructions(String pickupInstructions) {
		this.pickupInstructions = pickupInstructions;
		return this;
	}

	public String getDeliveryInstructions() {
		return deliveryInstructions;
	}

	public Shipment setDeliveryInstructions(String deliveryInstructions) {
		this.deliveryInstructions = deliveryInstructions;
		return this;
	}

	public List<ShipmentAdditionalServices> getShipmentAdditionalServices() {
		return shipmentAdditionalServices;
	}

	public Shipment setShipmentAdditionalServices(List<ShipmentAdditionalServices> shipmentAdditionalServices) {
		this.shipmentAdditionalServices = shipmentAdditionalServices;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	public String getReferenceCode() {
		return referenceCode;
	}

	public Shipment setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
		return this;
	}
	
	public String getReferenceCode2() {
		return referenceCode2;
	}

	public void setReferenceCode2(String referenceCode2) {
		this.referenceCode2 = referenceCode2;
	}

	public String getReferenceCode3() {
		return referenceCode3;
	}

	public void setReferenceCode3(String referenceCode3) {
		this.referenceCode3 = referenceCode3;
	}

	public Date getEstDelDate() {
		return estDelDate;
	}

	public Shipment setEstDelDate(Date estDelDate) {
		this.estDelDate = estDelDate;
		return this;
	}

	public Boolean getIsClaimsRaised() {
		return isClaimsRaised;
	}

	public Shipment setIsClaimsRaised(Boolean isClaimsRaised) {
		this.isClaimsRaised = isClaimsRaised;
		return this;
	}

	public boolean isEncrypted() {
		return isEncrypted;
	}

	public Shipment setEncrypted(boolean isEncrypted) {
		this.isEncrypted = isEncrypted;
		return this;
	}
	
	public String getBatchId() {
		return batchId;
	}

	public Shipment setBatchId(String batchId) {
		this.batchId = batchId;
		return this;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public Shipment setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
		return this;
	}
	
	public String getClaimId() {
		return claimId;
	}

	public void setClaimId(String claimId) {
		this.claimId = claimId;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public String getShipfromLocationType() {
		return shipfromLocationType;
	}

	public Shipment setShipfromLocationType(String shipfromLocationType) {
		this.shipfromLocationType = shipfromLocationType;
		return this;
	}

	public String getShiptoLocationType() {
		return shiptoLocationType;
	}

	public Shipment setShiptoLocationType(String shiptoLocationType) {
		this.shiptoLocationType = shiptoLocationType;
		return this;
	}

	public Boolean getResidentialPickup() {
		return residentialPickup;
	}

	public Shipment setResidentialPickup(Boolean residentialPickup) {
		this.residentialPickup = residentialPickup;
		return this;
	}
	
	public String getShiptoFloor() {
		return shiptoFloor;
	}

	public void setShiptoFloor(String shiptoFloor) {
		this.shiptoFloor = shiptoFloor;
	}
	
	public String getShipfromFloor() {
		return shipfromFloor;
	}

	public void setShipfromFloor(String shipfromFloor) {
		this.shipfromFloor = shipfromFloor;
	}

	public Map<String, String> getFrom() {
		Map<String, String> from = new HashMap<>();
		from.put("city", shipfromCity);
		from.put("email", shipfromEmail);
		from.put("phone", shipfromPhone);
		from.put("country", shipfromCountry);
		from.put("company", shipfromCompany);
		from.put("contact", shipfromContact);
		from.put("address1", shipfromAddress1);
		from.put("address2", shipfromAddress2);
		from.put("address3", shipfromAddress3);
		from.put("floor", shipfromFloor);
		from.put("opensAt", shipfromOpensAt);
		from.put("closesAt", shipfromClosesAt);
		from.put("shipfromLocationType", shipfromLocationType);
		from.put("province", shipfromProvinceState);
		from.put("postalCode", shipfromPostalcode);
		return from;
	}
	
	public Map<String, String> getTo() {
		Map<String, String> to = new HashMap<>();
		to.put("city", shiptoCity);
		to.put("email", checkAndReturnDecryptedData(shiptoEmail));
		to.put("phone", checkAndReturnDecryptedData(shiptoPhone));
		to.put("company", checkAndReturnDecryptedData(shiptoCompany));
		to.put("contact", checkAndReturnDecryptedData(shiptoContact));
		to.put("country", shiptoCountry);
		to.put("address1", checkAndReturnDecryptedData(shiptoAddress1));
		to.put("address2", shiptoAddress2);
		to.put("address3", shiptoAddress3);
		to.put("floor", shiptoFloor);
		to.put("opensAt", shiptoOpensAt);
		to.put("closesAt", shiptoClosesAt);
		to.put("shiptoLocationType", shiptoLocationType);
		to.put("province", shiptoProvinceState);
		to.put("postalCode", checkAndReturnDecryptedData(shiptoPostalcode));
		return to;
	}
	
	private String checkAndReturnDecryptedData(String data) {
		if(this.isEncrypted) {
			return Security.decryptPII(data);
		}
		return data;
	}

}