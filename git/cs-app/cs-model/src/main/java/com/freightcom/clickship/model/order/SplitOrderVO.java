package com.freightcom.clickship.model.order;

import java.io.Serializable;

import com.freightcom.clickship.model.CommonDTO;

public class SplitOrderVO extends CommonDTO implements Serializable {
	private static final long serialVersionUID = 5271946357997508901L;
	
	private String orderlineId;
	private int[] quantities;
	
	public String getOrderlineId() {
		return orderlineId;
	}
	public SplitOrderVO setOrderlineId(String orderlineId) {
		this.orderlineId = orderlineId;
		return this;
	}
	public int[] getQuantities() {
		return quantities;
	}
	public SplitOrderVO setQuantities(int[] quantities) {
		this.quantities = quantities;
		return this;
	}
}