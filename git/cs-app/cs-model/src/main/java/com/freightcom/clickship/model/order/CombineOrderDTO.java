package com.freightcom.clickship.model.order;

import java.util.List;

import com.freightcom.clickship.model.CommonDTO;

public class CombineOrderDTO extends CommonDTO {
	
	private String groupName;
	
	private List<String> orderIds;
	
	public List<String> getOrderIds() {
		return orderIds;
	}
	public CombineOrderDTO setOrderIds(List<String> orderIds) {
		this.orderIds = orderIds;
		return this;
	}
	public String getGroupName() {
		return groupName;
	}
	public CombineOrderDTO setGroupName(String groupName) {
		this.groupName = groupName;
		return this;
	}
	
	

}
