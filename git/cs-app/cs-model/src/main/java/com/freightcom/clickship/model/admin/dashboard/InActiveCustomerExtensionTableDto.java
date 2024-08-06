package com.freightcom.clickship.model.admin.dashboard;

public class InActiveCustomerExtensionTableDto {

	private String businessName;

	private String email;

	private String phone;

	private String salesRep;

	private String createdDate;

	private String customerId;

	private String lastShipmentDate;

	private int inactivePeriod;

	private int dailyAvgShipments;

	private int dailyAvgValue;

	private int activityInLastMonth;

	public InActiveCustomerExtensionTableDto(Object[] cols) {
		this.businessName = cols[0].toString();
		this.email = cols[1].toString();
		this.phone = cols[2].toString();
		this.salesRep = cols[3].toString();
		this.createdDate = (String) cols[4];
		this.customerId = cols[5].toString();
		this.lastShipmentDate = (String) cols[6];
		this.inactivePeriod = (Integer) cols[7];
		this.dailyAvgValue = ((Number) cols[8]).intValue();
		this.dailyAvgShipments = ((Number) cols[9]).intValue();
		this.activityInLastMonth = ((Number) cols[10]).intValue();
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


	public String getLastShipmentDate() {
		return lastShipmentDate;
	}

	public void setLastShipmentDate(String lastShipmentDate) {
		this.lastShipmentDate = lastShipmentDate;
	}

	public int getInactivePeriod() {
		return inactivePeriod;
	}

	public void setInactivePeriod(int inactivePeriod) {
		this.inactivePeriod = inactivePeriod;
	}

	public int getDailyAvgShipments() {
		return dailyAvgShipments;
	}

	public void setDailyAvgShipments(int dailyAvgShipments) {
		this.dailyAvgShipments = dailyAvgShipments;
	}

	public int getDailyAvgValue() {
		return dailyAvgValue;
	}

	public void setDailyAvgValue(int dailyAvgValue) {
		this.dailyAvgValue = dailyAvgValue;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public int getActivityInLastMonth() {
		return activityInLastMonth;
	}

	public void setActivityInLastMonth(int activityInLastMonth) {
		this.activityInLastMonth = activityInLastMonth;
	}
}
