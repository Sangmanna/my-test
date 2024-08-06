package com.freightcom.clickship.model.carrier.ups;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class InternationalForms implements Serializable {

	private static final long serialVersionUID = -205956687825660295L;

	@JsonProperty("FormType")
	private String formType;

	@JsonProperty("InvoiceDate")
	private String invoiceDate;

	@JsonProperty("PurchaseOrderNumber")
	private String purchaseOrderNumber;

	@JsonProperty("ReasonForExport")
	private String reasonForExport;

	@JsonProperty("CurrencyCode")
	private String currencyCode;

	@JsonProperty("Product")
	private List<UpsProduct> product;

	@JsonProperty("Contacts")
	private UpsContact contacts;

	public String getFormType() {
		return formType;
	}

	public InternationalForms setFormType(String formType) {
		this.formType = formType;
		return this;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public InternationalForms setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
		return this;
	}

	public String getPurchaseOrderNumber() {
		return purchaseOrderNumber;
	}

	public InternationalForms setPurchaseOrderNumber(String purchaseOrderNumber) {
		this.purchaseOrderNumber = purchaseOrderNumber;
		return this;
	}

	public String getReasonForExport() {
		return reasonForExport;
	}

	public InternationalForms setReasonForExport(String reasonForExport) {
		this.reasonForExport = reasonForExport;
		return this;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public InternationalForms setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
		return this;
	}

	public List<UpsProduct> getProduct() {
		return product;
	}

	public InternationalForms setProduct(List<UpsProduct> product) {
		this.product = product;
		return this;
	}

	public UpsContact getContacts() {
		return contacts;
	}

	public InternationalForms setContacts(UpsContact contacts) {
		this.contacts = contacts;
		return this;
	}
	
}
