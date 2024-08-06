package com.freightcom.clickship.data.entity;

import org.hibernate.annotations.GenericGenerator;

import com.freightcom.clickship.data.entity.common.BaseEntity;
import com.freightcom.clickship.model.util.Security;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "custom_invoice_detail")
public class CustomInvoiceDetail extends BaseEntity {
	
	private static final long serialVersionUID = 3166676703176097936L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "invoice_id", updatable = false)
	private Invoice invoice;

	// 'Shipper' or 'Receiver'
	@Column(name = "bill_to")
	private String billTo;
	
	@Column(name = "shipper_tax_id")
	private String shipperTaxId;
	
	@Column(name = "recipient_tax_id")
	private String recipientTaxId;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address1")
	private String address1;
	
	@Column(name = "address2")
	private String address2;
	
	@Column(name = "floor")
	private String floor;

	@Column(name = "city")
	private String city;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "province_state")
	private String provinceState;
	
	@Column(name = "postal_code")
	private String postalCode;

	@Column(name = "reason_for_export")
	private String reasonForExport = "gift";
	
	@Column(name = "reason_for_export_other")
	private String reasonForExportOther;
	
	@Column(name = "broker_name")
	private String brokerName;
	
	@Column(name = "broker_phone_number")
	private String brokerPhoneNumber;
	
	@Column(name = "broker_phone_ext")
	private String brokerPhoneExt;
	
	@Column(name = "broker_email")
	private String brokerEmail;
	
	@Column(name = "fda_number")
	private String fdaNumber;

	@Column(name = "fax_number")
	private String faxNumber;

	@Column(name = "usmca_number")
	private String usmcaNumber;

	@Column(name = "account_number")
	private String accountNumber;

	@Column(name = "is_encrypted")
	private boolean isEncrypted;

	public CustomInvoiceDetail() {

	}
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public CustomInvoiceDetail setId(String id) {
		this.id = id;
		return this;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public CustomInvoiceDetail setInvoice(Invoice invoice) {
		this.invoice = invoice;
		return this;
	}

	public String getBillTo() {
		return checkAndReturnDecryptedData(billTo);
	}

	public CustomInvoiceDetail setBillTo(String billTo) {
		this.billTo = billTo;
		return this;
	}

	public String getShipperTaxId() {
		return shipperTaxId;
	}

	public CustomInvoiceDetail setShipperTaxId(String shipperTaxId) {
		this.shipperTaxId = shipperTaxId;
		return this;
	}

	public String getRecipientTaxId() {
		return recipientTaxId;
	}

	public CustomInvoiceDetail setRecipientTaxId(String recipientTaxId) {
		this.recipientTaxId = recipientTaxId;
		return this;
	}

	public String getCompanyName() {
		return checkAndReturnDecryptedData(companyName);
	}

	public CustomInvoiceDetail setCompanyName(String companyName) {
		this.companyName = companyName;
		return this;
	}

	public String getName() {
		return checkAndReturnDecryptedData(name);
	}

	public CustomInvoiceDetail setName(String name) {
		this.name = name;
		return this;
	}

	public String getAddress1() {
		return checkAndReturnDecryptedData(address1);
	}

	public CustomInvoiceDetail setAddress1(String address1) {
		this.address1 = address1;
		return this;
	}

	public String getAddress2() {
		return address2;
	}

	public CustomInvoiceDetail setAddress2(String address2) {
		this.address2 = address2;
		return this;
	}

	public String getCity() {
		return city;
	}

	public CustomInvoiceDetail setCity(String city) {
		this.city = city;
		return this;
	}

	public String getCountry() {
		return country;
	}

	public CustomInvoiceDetail setCountry(String country) {
		this.country = country;
		return this;
	}

	public String getProvinceState() {
		return provinceState;
	}

	public CustomInvoiceDetail setProvinceState(String provinceState) {
		this.provinceState = provinceState;
		return this;
	}

	public String getPostalCode() {
		return checkAndReturnDecryptedData(postalCode);
	}

	public CustomInvoiceDetail setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		return this;
	}

	public String getBrokerName() {
		return brokerName;
	}

	public CustomInvoiceDetail setBrokerName(String brokerName) {
		this.brokerName = brokerName;
		return this;
	}

	public String getBrokerPhoneNumber() {
		return brokerPhoneNumber;
	}

	public CustomInvoiceDetail setBrokerPhoneNumber(String brokerPhoneNumber) {
		this.brokerPhoneNumber = brokerPhoneNumber;
		return this;
	}

	public String getBrokerEmail() {
		return brokerEmail;
	}

	public CustomInvoiceDetail setBrokerEmail(String brokerEmail) {
		this.brokerEmail = brokerEmail;
		return this;
	}
	
	public boolean isEncrypted() {
		return isEncrypted;
	}

	public CustomInvoiceDetail setEncrypted(boolean isEncrypted) {
		this.isEncrypted = isEncrypted;
		return this;
	}
	
	private String checkAndReturnDecryptedData(String data) {
		if(this.isEncrypted) {
			return Security.decryptPII(data);
		}
		return data;
	}

	public String getFloor() {
		return floor;
	}

	public CustomInvoiceDetail setFloor(String floor) {
		this.floor = floor;
		return this;
	}

	public String getReasonForExport() {
		return reasonForExport;
	}

	public CustomInvoiceDetail setReasonForExport(String reasonForExport) {
		this.reasonForExport = reasonForExport;
		return this;
	}

	public String getBrokerPhoneExt() {
		return brokerPhoneExt;
	}

	public CustomInvoiceDetail setBrokerPhoneExt(String brokerPhoneExt) {
		this.brokerPhoneExt = brokerPhoneExt;
		return this;
	}

	public String getFdaNumber() {
		return fdaNumber;
	}

	public CustomInvoiceDetail setFdaNumber(String fdaNumber) {
		this.fdaNumber = fdaNumber;
		return this;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public CustomInvoiceDetail setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
		return this;
	}

	public String getUsmcaNumber() {
		return usmcaNumber;
	}

	public CustomInvoiceDetail setUsmcaNumber(String usmcaNumber) {
		this.usmcaNumber = usmcaNumber;
		return this;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public CustomInvoiceDetail setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
		return this;
	}

	public String getReasonForExportOther() {
		return reasonForExportOther;
	}

	public void setReasonForExportOther(String reasonForExportOther) {
		this.reasonForExportOther = reasonForExportOther;
	}
}
