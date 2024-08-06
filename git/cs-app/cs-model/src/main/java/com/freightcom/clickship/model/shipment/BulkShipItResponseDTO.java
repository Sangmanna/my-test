package com.freightcom.clickship.model.shipment;

public class BulkShipItResponseDTO {

	private String status;
	
	private String carrier;
	
	private String orderId;
	
	private String orderNumber;
	
	private String trackingURL;
	
	private String trackingNumber;
	
	private String errorMessage;
	
	private Boolean isInternationalShipment;
	
	private Boolean isPaperlessCustomsInvoiceShipment;

	public String getOrderId() {
		return orderId;
	}

	public BulkShipItResponseDTO setOrderId(String orderId) {
		this.orderId = orderId;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public BulkShipItResponseDTO setStatus(String status) {
		this.status = status;
		return this;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public BulkShipItResponseDTO setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
		return this;
	}

	public String getTrackingURL() {
		return trackingURL;
	}

	public BulkShipItResponseDTO setTrackingURL(String trackingURL) {
		this.trackingURL = trackingURL;
		return this;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public BulkShipItResponseDTO setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
		return this;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public BulkShipItResponseDTO setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		return this;
	}

	public String getCarrier() {
		return carrier;
	}

	public BulkShipItResponseDTO setCarrier(String carrier) {
		this.carrier = carrier;
		return this;
	}

	public Boolean isInternationalShipment() {
		return isInternationalShipment;
	}

	public BulkShipItResponseDTO setInternationalShipment(Boolean isInternationalShipment) {
		this.isInternationalShipment = isInternationalShipment;
		return this;
	}

	public Boolean getIsPaperlessCustomsInvoiceShipment() {
		return isPaperlessCustomsInvoiceShipment;
	}

	public BulkShipItResponseDTO setIsPaperlessCustomsInvoiceShipment(Boolean isPaperlessCustomsInvoiceShipment) {
		this.isPaperlessCustomsInvoiceShipment = isPaperlessCustomsInvoiceShipment;
		return this;
	}

}
