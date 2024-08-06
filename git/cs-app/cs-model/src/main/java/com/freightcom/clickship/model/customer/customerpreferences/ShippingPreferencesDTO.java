package com.freightcom.clickship.model.customer.customerpreferences;

import java.io.Serializable;

import com.freightcom.clickship.model.CommonDTO;
import com.freightcom.clickship.model.constants.ClickShipConstants;

public class ShippingPreferencesDTO extends CommonDTO implements Serializable {

	private static final long serialVersionUID = 975876827175263321L;

	private String id;
	private String unitOfMeasure = ClickShipConstants.UNIT_IMPERIAL;
	private String packagingType = "Package";
	private String signaturePreferences = "NSR";
	private String billTo = "receiver";
	private String shipperTaxId;
	private String receiverTaxId;
	private String shiptoPhone;
	private String shiptoExt;
	private String shiptoEmail;
	private boolean agreeShiptoTerms = false;
	private String referenceCodes;
	private String referenceCodeOthers;
	private boolean autoFetchRates = false;
	private boolean thermalLabels;
	private String defaultPackageAddressId;
	private String defaultPalletAddressId;
	private String palletToLocationType;
	private Boolean residentialDelivery = false;
	private Boolean includesReturnLabel = false;
	private String reasonForExport;
	private String reasonForExportOther;
	private CourierBrokerPreferencesDTO courierBrokerPreferences;
	private String palletBrokerName;
	private String palletBrokerPhone;
	private String palletBrokerPhoneExt;
	private String palletBrokerEmail;
	private String palletAccountNumber;
	private String palletFaxNumber;
	private String palletFdaNumber;
	private String palletUsmcaNumber;

	private String actionType;

	public String getId() {
		return id;
	}

	public ShippingPreferencesDTO setId(String id) {
		this.id = id;
		return this;
	}

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public ShippingPreferencesDTO setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
		return this;
	}

	public String getPackagingType() {
		return packagingType;
	}

	public ShippingPreferencesDTO setPackagingType(String packagingType) {
		this.packagingType = packagingType;
		return this;
	}

	public String getSignaturePreferences() {
		return signaturePreferences;
	}

	public ShippingPreferencesDTO setSignaturePreferences(String signaturePreferences) {
		this.signaturePreferences = signaturePreferences;
		return this;
	}

	public String getBillTo() {
		return billTo;
	}

	public ShippingPreferencesDTO setBillTo(String billTo) {
		this.billTo = billTo;
		return this;
	}

	public String getShipperTaxId() {
		return shipperTaxId;
	}

	public ShippingPreferencesDTO setShipperTaxId(String shipperTaxId) {
		this.shipperTaxId = shipperTaxId;
		return this;
	}

	public String getReceiverTaxId() {
		return receiverTaxId;
	}

	public ShippingPreferencesDTO setReceiverTaxId(String receiverTaxId) {
		this.receiverTaxId = receiverTaxId;
		return this;
	}

	public String getShiptoPhone() {
		return shiptoPhone;
	}

	public ShippingPreferencesDTO setShiptoPhone(String shiptoPhone) {
		this.shiptoPhone = shiptoPhone;
		return this;
	}

	public String getShiptoExt() {
		return shiptoExt;
	}

	public ShippingPreferencesDTO setShiptoExt(String shiptoExt) {
		this.shiptoExt = shiptoExt;
		return this;
	}

	public String getShiptoEmail() {
		return shiptoEmail;
	}

	public ShippingPreferencesDTO setShiptoEmail(String shiptoEmail) {
		this.shiptoEmail = shiptoEmail;
		return this;
	}

	public boolean isAgreeShiptoTerms() {
		return agreeShiptoTerms;
	}

	public ShippingPreferencesDTO setAgreeShiptoTerms(boolean agreeShiptoTerms) {
		this.agreeShiptoTerms = agreeShiptoTerms;
		return this;
	}

	public String getReferenceCodes() {
		return referenceCodes;
	}

	public ShippingPreferencesDTO setReferenceCodes(String referenceCodes) {
		this.referenceCodes = referenceCodes;
		return this;
	}

	public String getReferenceCodeOthers() {
		return referenceCodeOthers;
	}

	public ShippingPreferencesDTO setReferenceCodeOthers(String referenceCodeOthers) {
		this.referenceCodeOthers = referenceCodeOthers;
		return this;
	}

	public boolean isAutoFetchRates() {
		return autoFetchRates;
	}

	public ShippingPreferencesDTO setAutoFetchRates(boolean autoFetchRates) {
		this.autoFetchRates = autoFetchRates;
		return this;
	}

	public boolean isThermalLabels() {
		return thermalLabels;
	}

	public ShippingPreferencesDTO setThermalLabels(boolean thermalLabels) {
		this.thermalLabels = thermalLabels;
		return this;
	}

	public String getDefaultPackageAddressId() {
		return defaultPackageAddressId;
	}

	public ShippingPreferencesDTO setDefaultPackageAddressId(String defaultPackageAddressId) {
		this.defaultPackageAddressId = defaultPackageAddressId;
		return this;
	}

	public String getDefaultPalletAddressId() {
		return defaultPalletAddressId;
	}

	public ShippingPreferencesDTO setDefaultPalletAddressId(String defaultPalletAddressId) {
		this.defaultPalletAddressId = defaultPalletAddressId;
		return this;
	}

	public String getPalletToLocationType() {
		return palletToLocationType;
	}

	public ShippingPreferencesDTO setPalletToLocationType(String palletToLocationType) {
		this.palletToLocationType = palletToLocationType;
		return this;
	}

	public String getActionType() {
		return actionType;
	}

	public ShippingPreferencesDTO setActionType(String actionType) {
		this.actionType = actionType;
		return this;
	}

	public Boolean getResidentialDelivery() {
		return residentialDelivery;
	}

	public ShippingPreferencesDTO setResidentialDelivery(Boolean residentialDelivery) {
		this.residentialDelivery = residentialDelivery;
		return this;
	}

	public Boolean getIncludesReturnLabel() {
		return includesReturnLabel;
	}

	public ShippingPreferencesDTO setIncludesReturnLabel(Boolean includesReturnLabel) {
		this.includesReturnLabel = includesReturnLabel;
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

	public CourierBrokerPreferencesDTO getCourierBrokerPreferences() {
		return courierBrokerPreferences;
	}

	public void setCourierBrokerPreferences(CourierBrokerPreferencesDTO courierBrokerPreferences) {
		this.courierBrokerPreferences = courierBrokerPreferences;
	}

	public String getPalletBrokerName() {
		return palletBrokerName;
	}

	public void setPalletBrokerName(String palletBrokerName) {
		this.palletBrokerName = palletBrokerName;
	}

	public String getPalletBrokerPhone() {
		return palletBrokerPhone;
	}

	public void setPalletBrokerPhone(String palletBrokerPhone) {
		this.palletBrokerPhone = palletBrokerPhone;
	}

	public String getPalletBrokerPhoneExt() {
		return palletBrokerPhoneExt;
	}

	public void setPalletBrokerPhoneExt(String palletBrokerPhoneExt) {
		this.palletBrokerPhoneExt = palletBrokerPhoneExt;
	}

	public String getPalletBrokerEmail() {
		return palletBrokerEmail;
	}

	public void setPalletBrokerEmail(String palletBrokerEmail) {
		this.palletBrokerEmail = palletBrokerEmail;
	}

	public String getPalletAccountNumber() {
		return palletAccountNumber;
	}

	public void setPalletAccountNumber(String palletAccountNumber) {
		this.palletAccountNumber = palletAccountNumber;
	}

	public String getPalletFaxNumber() {
		return palletFaxNumber;
	}

	public void setPalletFaxNumber(String palletFaxNumber) {
		this.palletFaxNumber = palletFaxNumber;
	}

	public String getPalletFdaNumber() {
		return palletFdaNumber;
	}

	public void setPalletFdaNumber(String palletFdaNumber) {
		this.palletFdaNumber = palletFdaNumber;
	}

	public String getPalletUsmcaNumber() {
		return palletUsmcaNumber;
	}

	public void setPalletUsmcaNumber(String palletUsmcaNumber) {
		this.palletUsmcaNumber = palletUsmcaNumber;
	}
}
