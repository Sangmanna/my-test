package com.freightcom.clickship.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "permissions")
public class Permissions extends BaseEntity {

	private static final long serialVersionUID = -5330540739156841027L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;
	
	@Column(name = "type", nullable = false)
	private String type;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "value", nullable = false)
	private String value;
	
	public String getId() {
		return id;
	}

	public BaseEntity setId(String id) {
		this.id = id;
		return this;
	}
	
	public String getName() {
		return name;
	}

	public Permissions setName(String name) {
		this.name = name;
		return this;
	}

	public String getValue() {
		return value;
	}

	public Permissions setValue(String value) {
		this.value = value;
		return this;
	}

	public String getType() {
		return type;
	}

	public Permissions setType(String type) {
		this.type = type;
		return this;
	}

}