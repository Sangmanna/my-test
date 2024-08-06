package com.freightcom.clickship.data.entity;

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

@Entity
@Table(name = "tag_link")
public class TagLink extends BaseEntity {

	private static final long serialVersionUID = 3349216467854395500L;
	
	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tag_id", nullable = false, updatable = false)
	@JsonIgnore
	private Tag tag;

	@Column(name = "target_id", nullable = false)
	private String targetId;
	
	@Column(name = "shipping_rule_action_id")
	private String shippingRuleActionId;

	public TagLink() {
		
	}
	
	public TagLink(Tag tag, String targetId) {
		this.tag = tag;
		this.targetId = targetId;
	}
	
	public TagLink(Tag tag, String targetId, String shippingRuleActionId) {
		this.tag = tag;
		this.targetId = targetId;
		this.shippingRuleActionId = shippingRuleActionId;
	}
	
	public String getId() {
		return id;
	}

	@Override
	public BaseEntity setId(String id) {
		this.id = id;
		return this;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	public String getShippingRuleActionId() {
		return shippingRuleActionId;
	}

	public void setShippingRuleActionId(String shippingRuleActionId) {
		this.shippingRuleActionId = shippingRuleActionId;
	}
	
}
