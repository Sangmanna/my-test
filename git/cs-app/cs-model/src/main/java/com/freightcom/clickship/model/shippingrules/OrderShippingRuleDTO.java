package com.freightcom.clickship.model.shippingrules;

public class OrderShippingRuleDTO {
	private String id;
	private AdvancedShippingRuleDTO advancedShippingRuleDTO;
	private String orderId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public AdvancedShippingRuleDTO getAdvancedShippingRuleDTO() {
		return advancedShippingRuleDTO;
	}
	public void setAdvancedShippingRuleDTO(AdvancedShippingRuleDTO advancedShippingRuleDTO) {
		this.advancedShippingRuleDTO = advancedShippingRuleDTO;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	
}
