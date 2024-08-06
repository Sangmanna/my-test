package com.freightcom.clickship.model.admin.dashboard.stores;

import java.math.BigInteger;

public class MarketplaceTableDTO {

	private String businessName;
	private String store;
	private	 BigInteger total;

	public MarketplaceTableDTO(String businessName, String store, BigInteger total) {
		super();
		this.businessName = businessName;
		this.store = store;
		this.total = total;
	}

	public MarketplaceTableDTO(Object[] cols) {
		super();
		this.businessName = (String) cols[0];
		this.store = (String) cols[1];
		this.total = (BigInteger) cols[2];
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public BigInteger getTotal() {
		return total;
	}

	public void setTotal(BigInteger total) {
		this.total = total;
	}
}
