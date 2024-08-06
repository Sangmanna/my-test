package com.freightcom.clickship.model.shipment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.freightcom.clickship.model.CommonDTO;
import com.freightcom.clickship.model.constants.ClickShipConstants;
import com.freightcom.clickship.model.customer.customerpreferences.CourierBrokerPreferencesDTO;
import com.freightcom.clickship.model.product.MarketplaceProductDTO;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomsInvoiceDTO extends CommonDTO implements Serializable {
	
	private static final long serialVersionUID = 5954536820353421422L;
	
	private String billTo;
	private String shipperTaxID;
	private String recipientTaxID;
	private String thirdPartyTaxID;
	private String billCompany;
	private String billName;
	private String billAddress;
	private String billAddress2;
	private String billApt;
	private String billCity;
	private String billCountry;
	private String billProvinceState;
	private String billPostalCode;
	private String billUnitFloor;
	private String contactPhone;
	private String contactPhoneExt;
	
	private String brokerName;
	private String brokerPhoneNumber;
	private String brokerEmail;

	private String fdaNumber;
	private String faxNumber;
	private String usmcaNumber;
	private String accountNumber;
	private String brokerPhoneExt;

	private Integer noProducts;
	private String currency = "CAD";
	private String billFloor;
	private String description;
	private String reasonForExport = "gift";
	private String additionalRemarks;
	private String unitOfMeasure = ClickShipConstants.UNIT_IMPERIAL;
	private int productQuantity;
	private boolean fromQuickShip = false;
	private boolean addressValidated = false;
	private boolean enableCarrierCustomsBroker;
	
	private List<MarketplaceProductDTO> marketplaceProductList = new ArrayList<>();
	
	private CourierBrokerPreferencesDTO courierBrokerPreferences = new CourierBrokerPreferencesDTO();

	public String getBillCompany() {
		return billCompany;
	}

	public CustomsInvoiceDTO setBillCompany(String billCompany) {
		this.billCompany = billCompany;
		return this;
	}

	public String getBillName() {
		return billName;
	}

	public CustomsInvoiceDTO setBillName(String billName) {
		this.billName = billName;
		return this;
	}

	public String getBillAddress() {
		return billAddress;
	}

	public CustomsInvoiceDTO setBillAddress(String billAddress) {
		this.billAddress = billAddress;
		return this;
	}

	public String getBillApt() {
		return billApt;
	}

	public CustomsInvoiceDTO setBillApt(String billApt) {
		this.billApt = billApt;
		return this;
	}

	public String getBillCity() {
		return billCity;
	}

	public CustomsInvoiceDTO setBillCity(String billCity) {
		this.billCity = billCity;
		return this;
	}

	public String getBillCountry() {
		return billCountry;
	}

	public CustomsInvoiceDTO setBillCountry(String billCountry) {
		this.billCountry = billCountry;
		return this;
	}

	public String getBillProvinceState() {
		return billProvinceState;
	}

	public CustomsInvoiceDTO setBillProvinceState(String billProvinceState) {
		this.billProvinceState = billProvinceState;
		return this;
	}

	public String getBillPostalCode() {
		return billPostalCode;
	}

	public CustomsInvoiceDTO setBillPostalCode(String billPostalCode) {
		this.billPostalCode = billPostalCode;
		return this;
	}

	public String getBrokerName() {
		return brokerName;
	}

	public CustomsInvoiceDTO setBrokerName(String brokerName) {
		this.brokerName = brokerName;
		return this;
	}

	public List<MarketplaceProductDTO> getMarketplaceProductList() {
		return marketplaceProductList;
	}
	
	public CustomsInvoiceDTO setMarketplaceProductList(List<MarketplaceProductDTO> marketplaceProductList) {
		this.marketplaceProductList = marketplaceProductList;
		return this;
	}

	public String getBillTo() {
		return billTo;
	}

	public CustomsInvoiceDTO setBillTo(String billTo) {
		this.billTo = billTo;
		return this;
	}

	public String getShipperTaxID() {
		return shipperTaxID;
	}

	public CustomsInvoiceDTO setShipperTaxID(String shipperTaxID) {
		this.shipperTaxID = shipperTaxID;
		return this;
	}

	public String getRecipientTaxID() {
		return recipientTaxID;
	}

	public CustomsInvoiceDTO setRecipientTaxID(String recipientTaxID) {
		this.recipientTaxID = recipientTaxID;
		return this;
	}

	public String getThirdPartyTaxID() {
		return thirdPartyTaxID;
	}

	public CustomsInvoiceDTO setThirdPartyTaxID(String thirdPartyTaxID) {
		this.thirdPartyTaxID = thirdPartyTaxID;
		return this;
	}

	public String getBrokerPhoneNumber() {
		return brokerPhoneNumber;
	}

	public CustomsInvoiceDTO setBrokerPhoneNumber(String brokerPhoneNumber) {
		this.brokerPhoneNumber = brokerPhoneNumber;
		return this;
	}

	public String getBrokerEmail() {
		return brokerEmail;
	}

	public CustomsInvoiceDTO setBrokerEmail(String brokerEmail) {
		this.brokerEmail = brokerEmail;
		return this;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public CustomsInvoiceDTO setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
		return this;
	}

	public String getContactPhoneExt() {
		return contactPhoneExt;
	}

	public CustomsInvoiceDTO setContactPhoneExt(String contactPhoneExt) {
		this.contactPhoneExt = contactPhoneExt;
		return this;
	}

	public String getFdaNumber() {
		return fdaNumber;
	}

	public CustomsInvoiceDTO setFdaNumber(String fdaNumber) {
		this.fdaNumber = fdaNumber;
		return this;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public CustomsInvoiceDTO setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
		return this;
	}

	public String getUsmcaNumber() {
		return usmcaNumber;
	}

	public CustomsInvoiceDTO setUsmcaNumber(String usmcaNumber) {
		this.usmcaNumber = usmcaNumber;
		return this;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public CustomsInvoiceDTO setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
		return this;
	}

	public String getBrokerPhoneExt() {
		return brokerPhoneExt;
	}

	public CustomsInvoiceDTO setBrokerPhoneExt(String brokerPhoneExt) {
		this.brokerPhoneExt = brokerPhoneExt;
		return this;
	}

	public Integer getNoProducts() {
		return noProducts;
	}

	public CustomsInvoiceDTO setNoProducts(Integer noProducts) {
		this.noProducts = noProducts;
		return this;
	}

	public String getCurrency() {
		return currency;
	}

	public CustomsInvoiceDTO setCurrency(String currency) {
		this.currency = currency;
		return this;
	}

	public String getBillFloor() {
		return billFloor;
	}

	public CustomsInvoiceDTO setBillFloor(String billFloor) {
		this.billFloor = billFloor;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public CustomsInvoiceDTO setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getReasonForExport() {
		return reasonForExport;
	}

	public CustomsInvoiceDTO setReasonForExport(String reasonForExport) {
		this.reasonForExport = reasonForExport;
		return this;
	}

	public String getAdditionalRemarks() {
		return additionalRemarks;
	}

	public CustomsInvoiceDTO setAdditionalRemarks(String additionalRemarks) {
		this.additionalRemarks = additionalRemarks;
		return this;
	}

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public CustomsInvoiceDTO setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
		return this;
	}

	public String getBillAddress2() {
		return billAddress2;
	}

	public void setBillAddress2(String billAddress2) {
		this.billAddress2 = billAddress2;
	}

	public String getBillUnitFloor() {
		return billUnitFloor;
	}

	public void setBillUnitFloor(String billUnitFloor) {
		this.billUnitFloor = billUnitFloor;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public boolean isFromQuickShip() {
		return fromQuickShip;
	}

	public void setFromQuickShip(boolean fromQuickShip) {
		this.fromQuickShip = fromQuickShip;
	}

	public boolean isAddressValidated() {
		return addressValidated;
	}

	public void setAddressValidated(boolean addressValidated) {
		this.addressValidated = addressValidated;
	}
	
	public CourierBrokerPreferencesDTO getCourierBrokerPreferences() {
		return courierBrokerPreferences;
	}

	public void setCourierBrokerPreferences(CourierBrokerPreferencesDTO courierBrokerPreferences) {
		this.courierBrokerPreferences = courierBrokerPreferences;
	}

	public boolean isEnableCarrierCustomsBroker() {
		return enableCarrierCustomsBroker;
	}

	public void setEnableCarrierCustomsBroker(boolean enableCarrierCustomsBroker) {
		this.enableCarrierCustomsBroker = enableCarrierCustomsBroker;
	}
}