package com.freightcom.clickship.model.shippingrules;


import java.io.Serializable;
import java.util.Date;

import com.freightcom.clickship.model.CommonDTO;
import com.freightcom.clickship.model.marketplace.MarketplaceDTO;

public class ShippingRuleDTO extends CommonDTO implements Serializable {

    private static final long serialVersionUID = 2661990908955746739L;

    private String id;
    private String ruleType;
    private MarketplaceDTO marketplaceDTO;
    private String ruleCodeName;
    private String ruleCodeCondition;
    private String ruleCodeValue;
    private String actionProperty;
    private String actionValue;
    private String title;
    private String description;
    private Boolean withOther = true;

    private Date startDate;
    private Date endDate;

    private int priority;

    private Boolean active = true;

    public String getId() {
        return id;
    }

    public ShippingRuleDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getRuleType() {
        return ruleType;
    }

    public ShippingRuleDTO setRuleType(String ruleType) {
        this.ruleType = ruleType;
        return this;
    }

    public MarketplaceDTO getMarketplaceDTO() {
        return marketplaceDTO;
    }

    public ShippingRuleDTO setMarketplaceDTO(MarketplaceDTO marketplaceDTO) {
        this.marketplaceDTO = marketplaceDTO;
        return this;
    }

    public String getRuleCodeName() {
        return ruleCodeName;
    }

    public ShippingRuleDTO setRuleCodeName(String ruleCodeName) {
        this.ruleCodeName = ruleCodeName;
        return this;
    }

    public String getRuleCodeCondition() {
        return ruleCodeCondition;
    }

    public ShippingRuleDTO setRuleCodeCondition(String ruleCodeCondition) {
        this.ruleCodeCondition = ruleCodeCondition;
        return this;
    }

    public String getRuleCodeValue() {
        return ruleCodeValue;
    }

    public ShippingRuleDTO setRuleCodeValue(String ruleCodeValue) {
        this.ruleCodeValue = ruleCodeValue;
        return this;
    }

    public String getActionProperty() {
        return actionProperty;
    }

    public ShippingRuleDTO setActionProperty(String actionProperty) {
        this.actionProperty = actionProperty;
        return this;
    }

    public String getActionValue() {
        return actionValue;
    }

    public ShippingRuleDTO setActionValue(String actionValue) {
        this.actionValue = actionValue;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ShippingRuleDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ShippingRuleDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public ShippingRuleDTO setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public ShippingRuleDTO setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public Boolean getWithOther() {
        return withOther;
    }

    public ShippingRuleDTO setWithOther(Boolean withOther) {
        this.withOther = withOther;
        return this;
    }

    public int getPriority() {
        return priority;
    }

    public ShippingRuleDTO setPriority(int priority) {
        this.priority = priority;
        return this;
    }

    public Boolean getActive() {
        return active;
    }

    public ShippingRuleDTO setActive(Boolean active) {
        this.active = active;
        return this;
    }
}
