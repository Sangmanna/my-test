package com.freightcom.clickship.data.entity;


import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freightcom.clickship.data.entity.common.BaseEntity;
import com.freightcom.clickship.model.constants.ClickShipConstants;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "shipping_preferences")
public class ShippingPreferences extends BaseEntity {

	private static final long serialVersionUID = 171012133873135655L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "customer_id")
	@JsonIgnore
	private Customer customer;

	@Column(name = "packaging_type")
	private String packagingType = "Package";
	
	@Column(name = "unit_of_measure")
	private String unitOfMeasure = ClickShipConstants.UNIT_IMPERIAL;

	@Column(name = "signature_preferences")
	private String signaturePreferences = "NSR";
	
	@Column(name = "bill_to")
	private String billTo = "receiver";

	@Column(name = "shipper_tax_id")
	private String shipperTaxId;

	@Column(name = "receiver_tax_id")
	private String receiverTaxId;

	@Column(name = "shipto_phone")
	private String shiptoPhone;

	@Column(name = "shipto_ext")
	private String shiptoExt;

	@Column(name = "shipto_email")
	private String shiptoEmail;

	@Column(name = "agree_shipto_terms")
	private boolean agreeShiptoTerms = false;

	@Column(name = "reference_codes")
	private String referenceCodes;

	@Column(name = "reference_codes_others")
	private String referenceCodeOthers;

	@Column(name = "auto_fetch_rates")
	private boolean autoFetchRates = false;

	@Column(name = "thermal_labels")
	private boolean thermalLabels;

	@Column(name = "default_package_address_id")
	private String defaultPackageAddressId;

	@Column(name = "default_pallet_address_id")
	private String defaultPalletAddressId;

	@Column(name = "pallet_broker_name")
	private String palletBrokerName;

	@Column(name = "pallet_broker_phone")
	private String palletBrokerPhone;
	
	@Column(name = "pallet_broker_phone_ext")
	private String palletBrokerPhoneExt;
	
	@Column(name = "pallet_broker_email")
	private String palletBrokerEmail;
	
	@Column(name = "pallet_fda_number")
	private String palletFdaNumber;
	
	@Column(name = "pallet_fax_number")
	private String palletFaxNumber;
	
	@Column(name = "pallet_usmca_number")
	private String palletUsmcaNumber;
	
	@Column(name = "pallet_account_number")
	private String palletAccountNumber;
	
	@Column(name = "residential_delivery")
	private Boolean residentialDelivery = false;
	
	@Column(name = "includes_return_label")
	private Boolean includesReturnLabel = false;

	@Column(name = "pallet_to_location_type")
	private String palletToLocationType;
	
	@Column(name = "reason_for_export")
	private String reasonForExport;
	
	@Column(name = "reason_for_export_other")
	private String reasonForExportOther;

	@OneToOne(mappedBy = "shippingPreference", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private CourierBrokerPreferences courierBrokerPreferences;

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

	public ShippingPreferences setCustomer(Customer customer) {
		this.customer = customer;
		return this;
	}

	public String getPackagingType() {
		return packagingType;
	}

	public ShippingPreferences setPackagingType(String packagingType) {
		this.packagingType = packagingType;
		return this;
	}

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public ShippingPreferences setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
		return this;
	}

	public String getSignaturePreferences() {
		return signaturePreferences;
	}

	public ShippingPreferences setSignaturePreferences(String signaturePreferences) {
		this.signaturePreferences = signaturePreferences;
		return this;
	}

	public String getBillTo() {
		return billTo;
	}

	public ShippingPreferences setBillTo(String billTo) {
		this.billTo = billTo;
		return this;
	}

	public String getShipperTaxId() {
		return shipperTaxId;
	}

	public ShippingPreferences setShipperTaxId(String shipperTaxId) {
		this.shipperTaxId = shipperTaxId;
		return this;
	}

	public String getReceiverTaxId() {
		return receiverTaxId;
	}

	public ShippingPreferences setReceiverTaxId(String receiverTaxId) {
		this.receiverTaxId = receiverTaxId;
		return this;
	}

	public String getShiptoPhone() {
		return shiptoPhone;
	}

	public ShippingPreferences setShiptoPhone(String shiptoPhone) {
		this.shiptoPhone = shiptoPhone;
		return this;
	}

	public String getShiptoExt() {
		return shiptoExt;
	}

	public ShippingPreferences setShiptoExt(String shiptoExt) {
		this.shiptoExt = shiptoExt;
		return this;
	}

	public String getShiptoEmail() {
		return shiptoEmail;
	}

	public ShippingPreferences setShiptoEmail(String shiptoEmail) {
		this.shiptoEmail = shiptoEmail;
		return this;
	}

	public boolean isAgreeShiptoTerms() {
		return agreeShiptoTerms;
	}

	public ShippingPreferences setAgreeShiptoTerms(boolean agreeShiptoTerms) {
		this.agreeShiptoTerms = agreeShiptoTerms;
		return this;
	}

	public String getReferenceCodes() {
		return referenceCodes;
	}

	public ShippingPreferences setReferenceCodes(String referenceCodes) {
		this.referenceCodes = referenceCodes;
		return this;
	}

	public String getReferenceCodeOthers() {
		return referenceCodeOthers;
	}

	public ShippingPreferences setReferenceCodeOthers(String referenceCodeOthers) {
		this.referenceCodeOthers = referenceCodeOthers;
		return this;
	}

	public boolean isAutoFetchRates() {
		return autoFetchRates;
	}

	public ShippingPreferences setAutoFetchRates(boolean autoFetchRates) {
		this.autoFetchRates = autoFetchRates;
		return this;
	}

	public boolean isThermalLabels() {
		return thermalLabels;
	}

	public ShippingPreferences setThermalLabels(boolean thermalLabels) {
		this.thermalLabels = thermalLabels;
		return this;
	}

	public String getDefaultPackageAddressId() {
		return defaultPackageAddressId;
	}

	public ShippingPreferences setDefaultPackageAddressId(String defaultPackageAddressId) {
		this.defaultPackageAddressId = defaultPackageAddressId;
		return this;
	}

	public String getDefaultPalletAddressId() {
		return defaultPalletAddressId;
	}

	public ShippingPreferences setDefaultPalletAddressId(String defaultPalletAddressId) {
		this.defaultPalletAddressId = defaultPalletAddressId;
		return this;
	}

	public String getPalletBrokerName() {
		return palletBrokerName;
	}

	public ShippingPreferences setPalletBrokerName(String palletBrokerName) {
		this.palletBrokerName = palletBrokerName;
		return this;
	}

	public String getPalletBrokerPhone() {
		return palletBrokerPhone;
	}

	public ShippingPreferences setPalletBrokerPhone(String palletBrokerPhone) {
		this.palletBrokerPhone = palletBrokerPhone;
		return this;
	}

	public String getPalletBrokerPhoneExt() {
		return palletBrokerPhoneExt;
	}

	public ShippingPreferences setPalletBrokerPhoneExt(String palletBrokerPhoneExt) {
		this.palletBrokerPhoneExt = palletBrokerPhoneExt;
		return this;
	}

	public String getPalletBrokerEmail() {
		return palletBrokerEmail;
	}

	public ShippingPreferences setPalletBrokerEmail(String palletBrokerEmail) {
		this.palletBrokerEmail = palletBrokerEmail;
		return this;
	}

	public String getPalletFdaNumber() {
		return palletFdaNumber;
	}

	public ShippingPreferences setPalletFdaNumber(String palletFdaNumber) {
		this.palletFdaNumber = palletFdaNumber;
		return this;
	}

	public String getPalletFaxNumber() {
		return palletFaxNumber;
	}

	public ShippingPreferences setPalletFaxNumber(String palletFaxNumber) {
		this.palletFaxNumber = palletFaxNumber;
		return this;
	}

	public String getPalletUsmcaNumber() {
		return palletUsmcaNumber;
	}

	public ShippingPreferences setPalletUsmcaNumber(String palletUsmcaNumber) {
		this.palletUsmcaNumber = palletUsmcaNumber;
		return this;
	}

	public String getPalletAccountNumber() {
		return palletAccountNumber;
	}

	public ShippingPreferences setPalletAccountNumber(String palletAccountNumber) {
		this.palletAccountNumber = palletAccountNumber;
		return this;
	}

	public Boolean getResidentialDelivery() {
		return residentialDelivery;
	}

	public ShippingPreferences setResidentialDelivery(Boolean residentialDelivery) {
		this.residentialDelivery = residentialDelivery;
		return this;
	}

	public Boolean getIncludesReturnLabel() {
		return includesReturnLabel;
	}

	public ShippingPreferences setIncludesReturnLabel(Boolean includesReturnLabel) {
		this.includesReturnLabel = includesReturnLabel;
		return this;
	}

	public String getPalletToLocationType() {
		return palletToLocationType;
	}

	public ShippingPreferences setPalletToLocationType(String palletToLocationType) {
		this.palletToLocationType = palletToLocationType;
		return this;
	}

	public String getReasonForExport() {
		return reasonForExport;
	}

	public void setReasonForExport(String reasonForExport) {
		this.reasonForExport = reasonForExport;
	}

	public String getReasonForExportOther() {
		return reasonForExportOther;
	}

	public void setReasonForExportOther(String reasonForExportOther) {
		this.reasonForExportOther = reasonForExportOther;
	}

	public CourierBrokerPreferences getCourierBrokerPreferences() {
		return courierBrokerPreferences;
	}

	public void setCourierBrokerPreferences(CourierBrokerPreferences courierBrokerPreferences) {
		this.courierBrokerPreferences = courierBrokerPreferences;
	}
}
