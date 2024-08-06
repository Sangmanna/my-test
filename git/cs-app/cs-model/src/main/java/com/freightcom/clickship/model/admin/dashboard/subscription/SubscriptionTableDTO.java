package com.freightcom.clickship.model.admin.dashboard.subscription;

public class SubscriptionTableDTO {

	private String businessName;
	private String subsPlan;
	private Double price;
	private String prevPlan;
	private String salesRep;
	private String dateString;
	private String customerId;

	public SubscriptionTableDTO(Object[] cols) {
		super();
		this.businessName = (String) cols[0];
		this.subsPlan = (String) cols[1];
		this.price = (Double) cols[2];
		this.prevPlan = (String) cols[3];
		this.salesRep = (String) cols[4];
		this.dateString = (String)cols[5];
		this.customerId = cols[6]+"";
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getSubsPlan() {
		return subsPlan;
	}

	public void setSubsPlan(String subsPlan) {
		this.subsPlan = subsPlan;
	}

	public String getPrevPlan() {
		return prevPlan;
	}

	public void setPrevPlan(String nextDate) {
		this.prevPlan = nextDate;
	}

	public String getSalesRep() {
		return salesRep;
	}

	public void setSalesRep(String salesRep) {
		this.salesRep = salesRep;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDateString() {
		return dateString;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	
}
