package com.freightcom.clickship.model.admin.dashboard;

import java.util.Date;

public class InActiveCustomerTableDto {

	private String businessName;

	private String email;

	private String phone;

	private String salesRep;

	private Date createdDate;

	private String lastShipmentDate;
	
	private String customerId;

	public InActiveCustomerTableDto(Object[] cols) {
		super();
		this.businessName = cols[0].toString();
		this.email = cols[1].toString();
		this.phone = cols[2].toString();
		this.salesRep = cols[3].toString();
		this.createdDate = (Date) cols[4];
		this.customerId = cols[5].toString();
		this.lastShipmentDate = (String) cols[6];
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

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastShipmentDate() {
		return lastShipmentDate;
	}

	public void setLastShipmentDate(String lastShipmentDate) {
		this.lastShipmentDate = lastShipmentDate;
	}

}
