package com.freightcom.clickship.model.customer.userrole;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.freightcom.clickship.model.CommonDTO;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserPermissionsDTO extends CommonDTO implements Serializable {

	private static final long serialVersionUID = -9137864215234124551L;

	private String id;
	
	private String name;
	
	private String value;
	
	private String address;
	
	private boolean enable;
	
	public UserPermissionsDTO() {
		super();
	}
	
	public UserPermissionsDTO(String id, String name, String value, String permissionValue) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
		this.enable = StringUtils.isNotBlank(permissionValue);
	}
	
	public UserPermissionsDTO(String id, String name, String address, String value, String permissionValue) {
		super();
		this.id = StringUtils.isNotBlank(id) ? id : "";
		this.name = StringUtils.isNotBlank(name) ? name : "";
		this.value = value;
		this.address = address;
		this.enable = StringUtils.isNotBlank(permissionValue);
	}

	public String getId() {
		return id;
	}

	public UserPermissionsDTO setId(String id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public UserPermissionsDTO setName(String name) {
		this.name = name;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public UserPermissionsDTO setAddress(String address) {
		this.address = address;
		return this;
	}

	public String getValue() {
		return value;
	}

	public UserPermissionsDTO setValue(String value) {
		this.value = value;
		return this;
	}

	public boolean isEnable() {
		return enable;
	}

	public UserPermissionsDTO setEnable(boolean enable) {
		this.enable = enable;
		return this;
	}

}
