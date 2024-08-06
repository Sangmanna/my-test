package com.freightcom.clickship.model.customer;

import java.util.Date;

import lombok.Data;

@Data
public class VettingProcessDTO {
    
	private String id;
	
	private Date vettingDate;
    
	private String customerId;
    
	private String vettingMethod;
    
	private String vettingComments;

	public String getId() {
		return id;
	}

	public VettingProcessDTO setId(String id) {
		this.id = id;
		return this;
	}

	public Date getVettingDate() {
		return vettingDate;
	}

	public VettingProcessDTO setVettingDate(Date vettingDate) {
		this.vettingDate = vettingDate;
		return this;
	}

	public String getCustomerId() {
		return customerId;
	}

	public VettingProcessDTO setCustomerId(String customerId) {
		this.customerId = customerId;
		return this;
	}

	public String getVettingMethod() {
		return vettingMethod;
	}

	public VettingProcessDTO setVettingMethod(String vettingMethod) {
		this.vettingMethod = vettingMethod;
		return this;
	}

	public String getVettingComments() {
		return vettingComments;
	}

	public VettingProcessDTO setVettingComments(String vettingComments) {
		this.vettingComments = vettingComments;
		return this;
	}
	
}