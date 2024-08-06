package com.freightcom.clickship.data.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freightcom.clickship.data.entity.common.BaseEntity;
import com.freightcom.clickship.data.entity.common.CustomerAssociateEntity;

@Entity
@Table(name = "shipping_rule")
public class ShippingRule extends BaseEntity implements CustomerAssociateEntity {

    private static final long serialVersionUID = 7889818998069007073L;

    @Id
    @GeneratedValue(generator = "customIdGenerator")
    @GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
    @Column(name = "id", nullable = false, updatable = false)
    private String id;

    @Column(name = "start_date")
    public Date startDate;

    @Column(name = "end_date")
    public Date endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false, updatable = false)
    @JsonIgnore
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marketplace_id", updatable = false)
    @JsonIgnore
    private Marketplace marketplace;

    @Column(name = "rule_type")
    private String ruleType;

    @Column(name = "rule_code_name")
    private String ruleCodeName;

    @Column(name = "rule_code_condition")
    private String ruleCodeCondition;

    @Column(name = "rule_code_value")
    private String ruleCodeValue;

    @Column(name = "action_property")
    private String actionProperty;

    @Column(name = "action_value")
    private String actionValue;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "with_other")
    private Boolean withOther;

    @Column(name = "priority")
    private int priority;

    @Column(name = "active")
    private Boolean active;
    
    public String getId() {
        return id;
    }

    public BaseEntity setId(String id) {
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Marketplace getMarketplace() {
        return marketplace;
    }

    public void setMarketplace(Marketplace marketplace) {
        this.marketplace = marketplace;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public String getRuleCodeName() {
        return ruleCodeName;
    }

    public void setRuleCodeName(String ruleCodeId) {
        this.ruleCodeName = ruleCodeId;
    }

    public String getRuleCodeCondition() {
        return ruleCodeCondition;
    }

    public void setRuleCodeCondition(String ruleCodeCondition) {
        this.ruleCodeCondition = ruleCodeCondition;
    }

    public String getActionProperty() {
        return actionProperty;
    }

    public void setActionProperty(String actionProperty) {
        this.actionProperty = actionProperty;
    }

    public String getActionValue() {
        return actionValue;
    }

    public void setActionValue(String actionValue) {
        this.actionValue = actionValue;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Boolean getWithOther() {
        return withOther;
    }

    public void setWithOther(Boolean withOther) {
        this.withOther = withOther;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getRuleCodeValue() {
        return ruleCodeValue;
    }

    public void setRuleCodeValue(String ruleCodeValue) {
        this.ruleCodeValue = ruleCodeValue;
    }
    
}