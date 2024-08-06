package com.freightcom.clickship.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.freightcom.clickship.data.entity.common.BaseEntity;

// TODO Should we keep this or delete
@Entity
@Table(name = "net_term_customer")
public class NetTermCustomer extends BaseEntity {

	private static final long serialVersionUID = 7225865286908348527L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;

	@Override
	public String getId() {
		return id;
	}

	@Override
	public NetTermCustomer setId(String id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public NetTermCustomer setName(String name) {
		this.name = name;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public NetTermCustomer setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public NetTermCustomer setPhone(String phone) {
		this.phone = phone;
		return this;
	}

}
