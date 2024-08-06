package com.freightcom.clickship.model.admin.dashboard;

import java.util.Date;

public class ActiveCustomerTableDto {

	private String businessName;

	private Date lastShipment;
	
	private String salesRep;
	
	private String customerId;
	
	

	public ActiveCustomerTableDto(Object[] cols) {
		super();
		this.businessName = cols[0].toString();
		this.lastShipment = (Date)cols[1];
		this.salesRep = cols[2].toString();
		this.customerId = cols[3].toString();
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getSalesRep() {
		return salesRep;
	}

	public void setSalesRep(String salesRep) {
		this.salesRep = salesRep;
	}

	public Date getLastShipment() {
		return lastShipment;
	}

	public void setLastShipment(Date lastShipment) {
		this.lastShipment = lastShipment;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

}
