package com.freightcom.clickship.data.entity;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freightcom.clickship.data.entity.common.CustomerIdAssociateEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "upload_order_mapping")
public class UploadOrderMapping implements CustomerIdAssociateEntity {

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	private Customer customer;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "mapping_json")
	private String mappingJson;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getMappingJson() {
		return mappingJson;
	}

	public void setMappingJson(String mappingJson) {
		this.mappingJson = mappingJson;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
