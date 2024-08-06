package com.freightcom.clickship.model.shippingrules;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.freightcom.clickship.model.box.BoxDTO;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShippingRuleRequestDTO {
    private String startDate;
    private String endDate;
    private String id;
    private String marketplaceId;
    
    @NotNull
    @EnumValidate(value = ShippingRuleType.class, enumMethod = "getType")
    private String ruleType;
    
    private String ruleCodeName;
    private String ruleCodeCondition;
    private String ruleCodeValue;
    private String actionProperty;
    private String actionValue;
    @JsonProperty(required = false)
    private BoxDTO box;
    private String title;
    private String description;
    private Boolean withOther = true;

    private int priority = 1;

    private Boolean active = true;

    public String getId() {
        return id;
    }

    public ShippingRuleRequestDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getRuleType() {
        return ruleType;
    }

    public ShippingRuleRequestDTO setRuleType(String ruleType) {
        this.ruleType = ruleType;
        return this;
    }

    public String getMarketplaceId() {
        return marketplaceId;
    }

    public ShippingRuleRequestDTO setMarketplaceId(String marketplaceId) {
        this.marketplaceId = marketplaceId;
        return this;
    }

    public String getRuleCodeName() {
        return ruleCodeName;
    }

    public ShippingRuleRequestDTO setRuleCodeName(String ruleCodeId) {
        this.ruleCodeName = ruleCodeId;
        return this;
    }

    public String getRuleCodeCondition() {
        return ruleCodeCondition;
    }

    public ShippingRuleRequestDTO setRuleCodeCondition(String ruleCodeCondition) {
        this.ruleCodeCondition = ruleCodeCondition;
        return this;
    }

    public String getRuleCodeValue() {
        return ruleCodeValue;
    }

    public ShippingRuleRequestDTO setRuleCodeValue(String ruleCodeValue) {
        this.ruleCodeValue = ruleCodeValue;
        return this;
    }

    public String getActionProperty() {
        return actionProperty;
    }

    public ShippingRuleRequestDTO setActionProperty(String actionProperty) {
        this.actionProperty = actionProperty;
        return this;
    }

    public String getActionValue() {
        return actionValue;
    }

    public ShippingRuleRequestDTO setActionValue(String actionValue) {
        this.actionValue = actionValue;
        return this;
    }

    public BoxDTO getBox() {
        return box;
    }

    public ShippingRuleRequestDTO setBox(BoxDTO box) {
        this.box = box;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ShippingRuleRequestDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ShippingRuleRequestDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getStartDate() {
        return startDate;
    }

    public ShippingRuleRequestDTO setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public String getEndDate() {
        return endDate;
    }

    public ShippingRuleRequestDTO setEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    public Boolean getWithOther() {
        return withOther;
    }

    public ShippingRuleRequestDTO setWithOther(Boolean withOther) {
        this.withOther = withOther;
        return this;
    }

    public int getPriority() {
        return priority;
    }

    public ShippingRuleRequestDTO setPriority(int priority) {
        this.priority = priority;
        return this;
    }

    public Boolean getActive() {
        return active;
    }

    public ShippingRuleRequestDTO setActive(Boolean active) {
        this.active = active;
        return this;
    }
}
