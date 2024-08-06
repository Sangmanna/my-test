package com.freightcom.clickship.model.admin.dashboard.csEarnings;

public class CsEarningTableDTO {

	private String businessName;
	private String category;
	private Double charge;
	private Double total;

	public CsEarningTableDTO(String businessName, String category, Double charge, Double total) {
		super();
		this.businessName = businessName;
		this.category = category;
		this.charge = charge;
		this.total = total;
	}
	
	public CsEarningTableDTO(Object[] cols) {
		super();
		this.businessName = (String) cols[0];
		this.category = (String) cols[1];
		this.charge = (Double) cols[2];
		this.total = (Double) cols[3];
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getCharge() {
		return charge;
	}

	public void setCharge(Double charge) {
		this.charge = charge;
	}

	@Override
	public String toString() {
		return "CsEarningTableDTO [businessName=" + businessName + ", category=" + category + ", charge=" + charge
				+ ", total=" + total + "]";
	}

}
