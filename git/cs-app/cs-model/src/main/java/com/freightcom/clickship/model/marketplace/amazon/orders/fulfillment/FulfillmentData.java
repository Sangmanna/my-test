package com.freightcom.clickship.model.marketplace.amazon.orders.fulfillment;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "FulfillmentData")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "carrierCode", "carrierName", "shippingMethod", "shipperTrackingNumber" })
public class FulfillmentData {

	@XmlElement(name = "CarrierCode")
	private String carrierCode;

	@XmlElement(name = "CarrierName")
	private String carrierName;

	@XmlElement(name = "ShippingMethod")
	private String shippingMethod;

	@XmlElement(name = "ShipperTrackingNumber")
	private String shipperTrackingNumber;

	public FulfillmentData() {

	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public String getCarrierCode() {
		return carrierCode;
	}

	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}

	public String getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public String getShipperTrackingNumber() {
		return shipperTrackingNumber;
	}

	public void setShipperTrackingNumber(String shipperTrackingNumber) {
		this.shipperTrackingNumber = shipperTrackingNumber;
	}
}
