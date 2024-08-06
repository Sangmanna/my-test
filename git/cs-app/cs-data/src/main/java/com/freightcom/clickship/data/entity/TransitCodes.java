package com.freightcom.clickship.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "transit_codes")
public class TransitCodes  extends BaseEntity {

	private static final long serialVersionUID = -156291387626078017L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)	
	private String id;	

	@Column(name = "service_code", nullable = false)
	private String serviceCode;
	
	@Column(name = "service", nullable = false)
	private String service;

	@Column(name = "transit_code_us", nullable = true)
	private String transitCodeUs;

	@Column(name = "transit_code_canada", nullable = true)
	private String transitCodeCanada;

	@Column(name = "transit_code_international", nullable = true)
	private String transitCodeInternational;

	@Column(name = "transit_code_mexico", nullable = true)
	private String transitCodeMexico;

	@Column(name = "transit_code_poland", nullable = true)
	private String transitCodePoland;
	
	@Column(name = "transit_code_other", nullable = true)
	private String transitCodeOther;

	@Override
	public String getId() {		
		return id;
	}

	@Override
	public TransitCodes setId(String id) {
		this.id = id;
		return this;
	}
	
	public String getServiceCode() {
		return serviceCode;
	}

	public TransitCodes setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
		return this;
	}

	public String getService() {
		return service;
	}

	public TransitCodes setService(String service) {
		this.service = service;
		return this;
	}

	public String getTransitCodeUs() {
		return transitCodeUs;
	}

	public TransitCodes setTransitCodeUs(String transitCodeUs) {
		this.transitCodeUs = transitCodeUs;
		return this;
	}

	public String getTransitCodeCanada() {
		return transitCodeCanada;
	}

	public TransitCodes setTransitCodeCanada(String transitCodeCanada) {
		this.transitCodeCanada = transitCodeCanada;
		return this;
	}

	public String getTransitCodeInternational() {
		return transitCodeInternational;
	}

	public TransitCodes setTransitCodeInternational(String transitCodeInternational) {
		this.transitCodeInternational = transitCodeInternational;
		return this;
	}

	public String getTransitCodeMexico() {
		return transitCodeMexico;
	}

	public TransitCodes setTransitCodeMexico(String transitCodeMexico) {
		this.transitCodeMexico = transitCodeMexico;
		return this;
	}

	public String getTransitCodePoland() {
		return transitCodePoland;
	}

	public TransitCodes setTransitCodePoland(String transitCodePoland) {
		this.transitCodePoland = transitCodePoland;
		return this;
	}

	public String getTransitCodeOther() {
		return transitCodeOther;
	}

	public TransitCodes setTransitCodeOther(String transitCodeOther) {
		this.transitCodeOther = transitCodeOther;
		return this;
	}
	
}
