package com.freightcom.clickship.model.admin.dashboard;

import java.util.Date;

public class TopCustomersDto {

	private String businessName;

	private Date signUpDate;

	private Long shipments;

	private Float totalCost;

	private String salesRep;
	
	private String customerId;

	public TopCustomersDto(Object[] cols) {
		super();
		this.businessName = cols[0].toString();
		this.signUpDate = (Date) cols[1];
		this.shipments = Long.valueOf(cols[2].toString());
		this.totalCost = Float.valueOf((cols[3].toString()));
		this.salesRep = cols[4].toString();
		this.customerId = cols[5].toString();
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public Date getSignUpDate() {
		return signUpDate;
	}

	public void setSignUpDate(Date signUpDate) {
		this.signUpDate = signUpDate;
	}

	public String getSalesRep() {
		return salesRep;
	}

	public void setSalesRep(String salesRep) {
		this.salesRep = salesRep;
	}

	public Long getShipments() {
		return shipments;
	}

	public void setShipments(Long shipments) {
		this.shipments = shipments;
	}

	public Float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Float totalCost) {
		this.totalCost = totalCost;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	

}
