package com.freightcom.clickship.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "fee_type")
public class FeeType extends BaseEntity {

	private static final long serialVersionUID = -6575354106224370356L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "amount", nullable = false)
	private Double amount;

	public String getId() {
		return id;
	}

	public FeeType setId(String id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public FeeType setName(String name) {
		this.name = name;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public FeeType setDescription(String description) {
		this.description = description;
		return this;
	}

	public Double getAmount() {
		return amount;
	}

	public FeeType setAmount(Double amount) {
		this.amount = amount;
		return this;
	}

}
