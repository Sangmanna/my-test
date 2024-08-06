package com.freightcom.clickship.model.customer;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.freightcom.clickship.model.CommonDTO;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerSubPlanDto extends CommonDTO implements Serializable {

	private static final long serialVersionUID = -6471398582893877697L;

	private Boolean status;
	
	private Boolean loadOwnRate;
	
	private Integer shippementsRemain;

	private Integer marketplaceRemain;

	private Integer userAccountsRemain;

	public Integer getShippementsRemain() {
		return shippementsRemain;
	}

	public CustomerSubPlanDto setShippementsRemain(Integer shippementsRemain) {
		this.shippementsRemain = shippementsRemain;
		return this;
	}

	public Integer getMarketplaceRemain() {
		return marketplaceRemain;
	}

	public CustomerSubPlanDto setMarketplaceRemain(Integer marketplaceRemain) {
		this.marketplaceRemain = marketplaceRemain;
		return this;
	}

	public Integer getUserAccountsRemain() {
		return userAccountsRemain;
	}

	public CustomerSubPlanDto setUserAccountsRemain(Integer userAccountsRemain) {
		this.userAccountsRemain = userAccountsRemain;
		return this;
	}

	public Boolean getStatus() {
		return status;
	}

	public CustomerSubPlanDto setStatus(Boolean status) {
		this.status = status;
		return this;
	}

	public Boolean getLoadOwnRate() {
		return loadOwnRate;
	}

	public CustomerSubPlanDto setLoadOwnRate(Boolean loadOwnRate) {
		this.loadOwnRate = loadOwnRate;
		return this;
	}

}
