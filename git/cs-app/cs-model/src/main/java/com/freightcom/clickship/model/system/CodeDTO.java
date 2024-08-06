package com.freightcom.clickship.model.system;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.freightcom.clickship.model.CommonDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CodeDTO extends CommonDTO {
	
	private String name;
	
	private Long orderby;
	
	private String value;
	
	private String groupName;
	
	private String parentCodeId;

	public String getName() {
		return name;
	}

	public CodeDTO setName(String name) {
		this.name = name;
		return this;
	}

	public Long getOrderby() {
		return orderby;
	}

	public CodeDTO setOrderby(Long orderby) {
		this.orderby = orderby;
		return this;
	}

	public String getValue() {
		return value;
	}

	public CodeDTO setValue(String value) {
		this.value = value;
		return this;
	}

	public String getGroupName() {
		return groupName;
	}

	public CodeDTO setGroupName(String groupName) {
		this.groupName = groupName;
		return this;
	}

	public String getParentCodeId() {
		return parentCodeId;
	}

	public CodeDTO setParentCodeId(String parentCodeId) {
		this.parentCodeId = parentCodeId;
		return this;
	}
	
}
