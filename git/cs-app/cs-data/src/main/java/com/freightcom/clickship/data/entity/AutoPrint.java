package com.freightcom.clickship.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "auto_print")
public class AutoPrint extends BaseEntity {

	private static final long serialVersionUID = 6958633212698961801L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "customer_id")
	@JsonIgnore
	private Customer customer;
	
	@Column(name = "username")
	private String username;

	@Column(name = "auto_print_enabled")
	private Boolean autoPrintEnabled;

	@Column(name = "auto_print_bulk_shipping")
	private Boolean autoPrintBulkShipping;

	@Column(name = "shipping_label")
	private Boolean shippingLabel;

	@Column(name = "bill_of_lading")
	private Boolean billOfLading;

	@Column(name = "packing_slips")
	private Boolean packingSlips;

	@Column(name = "shipment_details")
	private Boolean shipmentDetails;

	@Column(name = "customs_invoice")
	private Boolean customsInvoice;

	@Column(name = "enable_printing_status")
	private Boolean enablePrintingStatus;

	public String getId() {
		return id;
	}

	public AutoPrint setId(String id) {
		this.id = id;
		return this;
	}

	public Customer getCustomer() {
		return customer;
	}

	public AutoPrint setCustomer(Customer customer) {
		this.customer = customer;
		return this;
	}

	public Boolean getAutoPrintEnabled() {
		return autoPrintEnabled;
	}

	public AutoPrint setAutoPrintEnabled(Boolean autoPrintEnabled) {
		this.autoPrintEnabled = autoPrintEnabled;
		return this;
	}

	public Boolean getAutoPrintBulkShipping() {
		return autoPrintBulkShipping;
	}

	public AutoPrint setAutoPrintBulkShipping(Boolean autoPrintBulkShipping) {
		this.autoPrintBulkShipping = autoPrintBulkShipping;
		return this;
	}

	public Boolean getShippingLabel() {
		return shippingLabel;
	}

	public AutoPrint setShippingLabel(Boolean shippingLabel) {
		this.shippingLabel = shippingLabel;
		return this;
	}

	public Boolean getBillOfLading() {
		return billOfLading;
	}

	public AutoPrint setBillOfLading(Boolean billOfLading) {
		this.billOfLading = billOfLading;
		return this;
	}

	public Boolean getPackingSlips() {
		return packingSlips;
	}

	public AutoPrint setPackingSlips(Boolean packingSlips) {
		this.packingSlips = packingSlips;
		return this;
	}

	public Boolean getShipmentDetails() {
		return shipmentDetails;
	}

	public AutoPrint setShipmentDetails(Boolean shipmentDetails) {
		this.shipmentDetails = shipmentDetails;
		return this;
	}

	public Boolean getCustomsInvoice() {
		return customsInvoice;
	}

	public AutoPrint setCustomsInvoice(Boolean customsInvoice) {
		this.customsInvoice = customsInvoice;
		return this;
	}

	public Boolean getEnablePrintingStatus() {
		return enablePrintingStatus;
	}

	public void setEnablePrintingStatus(Boolean enablePrintingStatus) {
		this.enablePrintingStatus = enablePrintingStatus;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
