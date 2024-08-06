package com.freightcom.clickship.model.printer;

public class AutoPrintDTO {

	private String id;
	
	private Boolean billOfLading = true;
	
	private Boolean packingSlips = false;
	
	private Boolean shippingLabel = true;
	
	private Boolean customsInvoice = false;
	
	private Boolean shipmentDetails = false;
	
	private Boolean autoPrintEnabled = true;
	
	private Boolean autoPrintBulkShipping = true;

	private Boolean enablePrintingStatus = true;

	public String getId() {
		return id;
	}

	public AutoPrintDTO setId(String id) {
		this.id = id;
		return this;
	}

	public Boolean getAutoPrintEnabled() {
		return autoPrintEnabled;
	}

	public AutoPrintDTO setAutoPrintEnabled(Boolean autoPrintEnabled) {
		this.autoPrintEnabled = autoPrintEnabled;
		return this;
	}

	public Boolean getAutoPrintBulkShipping() {
		return autoPrintBulkShipping;
	}

	public AutoPrintDTO setAutoPrintBulkShipping(Boolean autoPrintBulkShipping) {
		this.autoPrintBulkShipping = autoPrintBulkShipping;
		return this;
	}

	public Boolean getShippingLabel() {
		return shippingLabel;
	}

	public AutoPrintDTO setShippingLabel(Boolean shippingLabel) {
		this.shippingLabel = shippingLabel;
		return this;
	}

	public Boolean getBillOfLading() {
		return billOfLading;
	}

	public AutoPrintDTO setBillOfLading(Boolean billOfLading) {
		this.billOfLading = billOfLading;
		return this;
	}

	public Boolean getPackingSlips() {
		return packingSlips;
	}

	public AutoPrintDTO setPackingSlips(Boolean packingSlips) {
		this.packingSlips = packingSlips;
		return this;
	}

	public Boolean getShipmentDetails() {
		return shipmentDetails;
	}

	public AutoPrintDTO setShipmentDetails(Boolean shipmentDetails) {
		this.shipmentDetails = shipmentDetails;
		return this;
	}

	public Boolean getCustomsInvoice() {
		return customsInvoice;
	}

	public AutoPrintDTO setCustomsInvoice(Boolean customsInvoice) {
		this.customsInvoice = customsInvoice;
		return this;
	}

	public Boolean getEnablePrintingStatus() {
		return enablePrintingStatus;
	}

	public AutoPrintDTO setEnablePrintingStatus(Boolean enablePrintingStatus) {
		this.enablePrintingStatus = enablePrintingStatus;
		return this;
	}

}
