package com.freightcom.clickship.model.admin.dashboard.shipments;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ShipmentTrackingDTO {

	private String businessName;
	private String trackId;
	private String date;
	private String carrierName;
	private String shipmentType;
	private String store;
	private String salesRep;
	private Float shippingCost;
	

	public ShipmentTrackingDTO(Object[] cols) {
		super();
		this.businessName = (String) cols[0];
		this.trackId = (String) cols[1];
		this.date = (String) cols[2];
		this.carrierName = (String) cols[3];
		this.salesRep = (String) cols[4];
		this.shippingCost = (Float) cols[5];
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getTrackId() {
		return trackId;
	}

	public void setTrackId(String trackId) {
		this.trackId = trackId;
	}

	public String getDate() {
		return date;
	}

	public LocalDate getParsedDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d-M-yyyy");
		return LocalDate.parse(this.date, dtf);
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public String getShipmentType() {
		return shipmentType;
	}

	public void setShipmentType(String shipmentType) {
		this.shipmentType = shipmentType;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getSalesRep() {
		return salesRep;
	}

	public void setSalesRep(String salesRep) {
		this.salesRep = salesRep;
	}

	public Float getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(Float shippingCost) {
		this.shippingCost = shippingCost;
	}

}
