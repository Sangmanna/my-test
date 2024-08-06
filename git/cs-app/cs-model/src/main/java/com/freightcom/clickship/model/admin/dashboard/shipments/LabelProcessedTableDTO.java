package com.freightcom.clickship.model.admin.dashboard.shipments;

import java.math.BigInteger;

public class LabelProcessedTableDTO {
	
	private String businessName;
	
	private String carrierName;
	
	private BigInteger count;
	
	private	String store;

	public LabelProcessedTableDTO(String businessName, String carrierName, BigInteger count, String store) {
		super();
		this.businessName = businessName;
		this.carrierName = carrierName;
		this.count = count;
		this.store = store;
	}
	
	public LabelProcessedTableDTO(Object[] cols) {
		super();
		this.businessName = (String) cols[0];
		this.carrierName = (String) cols[1];
		this.count = (BigInteger)cols[2];
		this.store = (String) cols[3];
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public BigInteger getCount() {
		return count;
	}

	public void setCount(BigInteger count) {
		this.count = count;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

}
