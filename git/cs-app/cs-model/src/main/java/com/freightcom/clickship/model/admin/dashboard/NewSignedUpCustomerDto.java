package com.freightcom.clickship.model.admin.dashboard;

import java.util.Date;

public class NewSignedUpCustomerDto {

	private String businessName;

	private Date signUpDate;

	private String subPlan;

	private String storePref;

	private String billingType;

	private Long shipments;

	private Date lastShipped;
	
	private Boolean inActiveMailSent;

	private Boolean disableMailSent;

	private Date lasLogin;
	
	private Boolean active;

	public NewSignedUpCustomerDto(Object[] obj) {
		super();
		this.businessName = obj[0].toString();
		this.signUpDate = (Date) obj[1];
		this.subPlan = (String) obj[2];
		this.storePref = (String) obj[3];
		this.billingType = (String) obj[4];
		this.shipments = Long.valueOf(obj[5].toString());
		this.lastShipped = (Date) obj[6];
		this.inActiveMailSent = (Boolean) obj[7];
		this.disableMailSent = (Boolean) obj[8];
		this.lasLogin = (Date) obj[9];
		this.active = (Boolean)obj[10];
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

	public String getSubPlan() {
		return subPlan;
	}

	public void setSubPlan(String subPlan) {
		this.subPlan = subPlan;
	}

	public String getStorePref() {
		return storePref;
	}

	public void setStorePref(String storePref) {
		this.storePref = storePref;
	}

	public String getBillingType() {
		return billingType;
	}

	public void setBillingType(String billingType) {
		this.billingType = billingType;
	}

	public Long getShipments() {
		return shipments;
	}

	public void setShipments(Long shipments) {
		this.shipments = shipments;
	}

	public Boolean getInActiveMailSent() {
		return inActiveMailSent;
	}

	public void setInActiveMailSent(Boolean inActiveMailSent) {
		this.inActiveMailSent = inActiveMailSent;
	}

	public Boolean getDisableMailSent() {
		return disableMailSent;
	}

	public void setDisableMailSent(Boolean disableMailSent) {
		this.disableMailSent = disableMailSent;
	}

	public Date getLasLogin() {
		return lasLogin;
	}

	public void setLasLogin(Date lasLogin) {
		this.lasLogin = lasLogin;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Date getLastShipped() {
		return lastShipped;
	}

	public void setLastShipped(Date lastShipped) {
		this.lastShipped = lastShipped;
	}

	
}
