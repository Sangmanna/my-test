package com.freightcom.clickship.model.shippingrules;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

public class AdvancedShippingRuleDTO {

	private String id;
	@NotNull
	@EnumValidate(value = AdvShippingRuleType.class, enumMethod = "getType")
	private String ruleType;
	private String ruleName;
	private String description;
	private Date startDate;
	private Date endDate;
	private int priority;
	private boolean active;
	private Boolean activateByDateRange;
	private boolean isDeleted;
	private String warningMessage;
	private List<AdvShippingRuleConditionDTO> advShippingRuleConditionDTOs;
	private AdvShippingRuleActionDTO advShippingRuleActionDTO;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRuleType() {
		return ruleType;
	}

	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	

	public void setActive(Boolean active) {
		this.active = active;
	}

	public List<AdvShippingRuleConditionDTO> getAdvShippingRuleConditionDTOs() {
		return advShippingRuleConditionDTOs;
	}

	public void setAdvShippingRuleConditionDTOs(List<AdvShippingRuleConditionDTO> advShippingRuleConditionDTOs) {
		this.advShippingRuleConditionDTOs = advShippingRuleConditionDTOs;
	}

	public AdvShippingRuleActionDTO getAdvShippingRuleActionDTO() {
		return advShippingRuleActionDTO;
	}

	public void setAdvShippingRuleActionDTO(AdvShippingRuleActionDTO advShippingRuleActionDTO) {
		this.advShippingRuleActionDTO = advShippingRuleActionDTO;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public String getWarningMessage() {
		return warningMessage;
	}

	public void setWarningMessage(String warningMessage) {
		this.warningMessage = warningMessage;
	}

	public Boolean getActivateByDateRange() {
		return activateByDateRange;
	}

	public void setActivateByDateRange(Boolean activateByDateRange) {
		this.activateByDateRange = activateByDateRange;
	}
	
}
