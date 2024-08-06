package com.freightcom.clickship.data.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLRestriction;

import com.freightcom.clickship.data.entity.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "code")
@SQLRestriction("delete_flag=0")
public class Code extends BaseEntity {

	private static final long serialVersionUID = -5330540739156841027L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;
	
	@Column(name = "parent_code_id")
	private String parentCodeId;
	
	@Column(name = "group_name", nullable = false)
	private String groupName;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "value", nullable = false)
	private String value;
	
	@Column(name = "orderby")
	private Long orderby;
	
	@Column(name = "delete_flag")
	private Boolean deleteFlag;
	
	public String getId() {
		return id;
	}

	public BaseEntity setId(String id) {
		this.id = id;
		return this;
	}
	
	public String getGroupName() {
		return groupName;
	}

	public Code setGroupName(String groupName) {
		this.groupName = groupName;
		return this;
	}

	public String getName() {
		return name;
	}

	public Code setName(String name) {
		this.name = name;
		return this;
	}

	public String getValue() {
		return value;
	}

	public Code setValue(String value) {
		this.value = value;
		return this;
	}

	public Long getOrderby() {
		return orderby;
	}

	public Code setOrderby(Long orderby) {
		this.orderby = orderby;
		return this;
	}

	public Boolean isDeleteFlag() {
		return deleteFlag;
	}

	public Code setDeleteFlag(Boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
		return this;
	}

	public Boolean getDeleteFlag() {
		return deleteFlag;
	}

	public String getParentCodeId() {
		return parentCodeId;
	}

	public Code setParentCodeId(String parentCodeId) {
		this.parentCodeId = parentCodeId;
		return this;
	}
}