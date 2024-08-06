package com.freightcom.clickship.model.marketplace;

import java.io.Serializable;

import com.freightcom.clickship.model.CommonDTO;

public class MarketplaceTypeDTO extends CommonDTO implements Serializable {
		
	private static final long serialVersionUID = 1118610104213724917L;

	private String id;

	private Long seq;
	
	private String name;
	
	private String beanPrefix;
	
	private boolean productIdStr;

	private boolean dataEncrypted;
	
	private String orderImportType;
	
	private Integer rtrResponseThreshold;
	
	private boolean isLocationSplitAllowed;

	public String getId() {
		return id;
	}

	public MarketplaceTypeDTO setId(String id) {
		this.id = id;
		return this;
	}
	
	public String getName() {
		return name;
	}

	public MarketplaceTypeDTO setName(String name) {
		this.name = name;
		return this;
	}

	public String getBeanPrefix() {
		return beanPrefix;
	}
	
	public MarketplaceTypeDTO setBeanPrefix(String beanPrefix) {
		this.beanPrefix = beanPrefix;
		return this;
	}

	public String getOrderImportType() {
		return orderImportType;
	}

	public void setOrderImportType(String orderImportType) {
		this.orderImportType = orderImportType;
	}

	public boolean isProductIdStr() {
		return productIdStr;
	}

	public void setProductIdStr(boolean productIdStr) {
		this.productIdStr = productIdStr;
	}

	public Long getSeq() {
		return seq;
	}

	public MarketplaceTypeDTO setSeq(Long seq) {
		this.seq = seq;
		return this;
	}

	public Integer getRtrResponseThreshold() {
		return rtrResponseThreshold;
	}

	public MarketplaceTypeDTO setRtrResponseThreshold(Integer rtrResponseThreshold) {
		this.rtrResponseThreshold = rtrResponseThreshold;
		return this;
	}
	
	public boolean isDataEncrypted() {
		return dataEncrypted;
	}

	public MarketplaceTypeDTO setDataEncrypted(boolean dataEncrypted) {
		this.dataEncrypted = dataEncrypted;
		return this;
	}

	public boolean isLocationSplitAllowed() {
		return isLocationSplitAllowed;
	}

	public MarketplaceTypeDTO setLocationSplitAllowed(boolean isLocationSplitAllowed) {
		this.isLocationSplitAllowed = isLocationSplitAllowed;
		return this;
	}
	
}