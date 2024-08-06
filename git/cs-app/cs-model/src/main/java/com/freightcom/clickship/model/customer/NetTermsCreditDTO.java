package com.freightcom.clickship.model.customer;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.freightcom.clickship.model.CommonDTO;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NetTermsCreditDTO extends CommonDTO implements Serializable {

	private static final long serialVersionUID = 1297740107842631574L;

	private Date lastUpdated;
	
	private double usedCredit;
	
	private double totalCredit;
	
	private double availableCredit;

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public NetTermsCreditDTO setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
		return this;
	}

	public double getUsedCredit() {
		return usedCredit;
	}

	public NetTermsCreditDTO setUsedCredit(double usedCredit) {
		this.usedCredit = usedCredit;
		return this;
	}

	public double getTotalCredit() {
		return totalCredit;
	}

	public NetTermsCreditDTO setTotalCredit(double totalCredit) {
		this.totalCredit = totalCredit;
		return this;
	}

	public double getAvailableCredit() {
		return availableCredit;
	}

	public NetTermsCreditDTO setAvailableCredit(double availableCredit) {
		this.availableCredit = availableCredit;
		return this;
	}

}
