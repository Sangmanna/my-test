package com.freightcom.clickship.data.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLRestriction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freightcom.clickship.data.entity.common.BaseEntity;
import com.freightcom.clickship.data.entity.common.CustomerAssociateEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "adv_shipping_rule")
@SQLRestriction("is_deleted <> 1")
public class AdvancedShippingRule extends BaseEntity implements CustomerAssociateEntity {
    
	private static final long serialVersionUID = 7889818998069007073L;

    @Id
    @GeneratedValue(generator = "customIdGenerator")
    @GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
    @Column(name = "id", nullable = false, updatable = false)
    private String id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false, updatable = false)
    @JsonIgnore
    private Customer customer;
   
    @Column(name = "rule_type")
    private String ruleType;

    @Column(name = "rule_name")
    private String ruleName;

    @Column(name = "description")
    private String description;
    
    @Column(name = "start_date")
    public Date startDate;

    @Column(name = "end_date")
    public Date endDate;

    @Column(name = "priority")
    private int priority;
    
    @Column(name = "is_deleted")
    private Boolean isDeleted = false;

    @Column(name = "active")
    private Boolean active = false;
    
    @Column(name = "activate_by_date_range")
    private Boolean activateByDateRange = false;
    
    @Column(name = "warning_message")
    private String warningMessage;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "shippingRule", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<AdvShippingRuleCondition> shippingRuleConditions;
    
    @OneToOne(fetch = FetchType.EAGER,  mappedBy = "shippingRule", cascade = CascadeType.ALL)
    @JsonIgnore
	private AdvShippingRuleAction shippingRuleAction;

	public String getId() {
		return id;
	}

	public BaseEntity setId(String id) {
		return this;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public List<AdvShippingRuleCondition> getShippingRuleConditions() {
		return shippingRuleConditions;
	}

	public void setShippingRuleConditions(List<AdvShippingRuleCondition> shippingRuleConditions) {
		if (CollectionUtils.isNotEmpty(shippingRuleConditions)) {
			shippingRuleConditions.forEach(c -> c.setShippingRule(this));
		}
		this.shippingRuleConditions = shippingRuleConditions;
	}

	public void addShippingRuleCondition(AdvShippingRuleCondition shippingRuleCondition) {
		if (this.shippingRuleConditions == null) {
			this.shippingRuleConditions = new ArrayList<>();
		}
		shippingRuleCondition.setShippingRule(this);
		this.shippingRuleConditions.add(shippingRuleCondition);
	}

	public AdvShippingRuleAction getShippingRuleAction() {
		return shippingRuleAction;
	}

	public void setShippingRuleAction(AdvShippingRuleAction shippingRuleAction) {
		shippingRuleAction.setShippingRule(this);
		this.shippingRuleAction = shippingRuleAction;
	}

	@Override
	public Customer getCustomer() {
		return customer;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
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