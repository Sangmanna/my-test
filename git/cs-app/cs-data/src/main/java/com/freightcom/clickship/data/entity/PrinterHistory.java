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
@Table(name = "printer_history")
public class PrinterHistory extends BaseEntity {

	private static final long serialVersionUID = -1234185145101860042L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "customer_id")
	@JsonIgnore
	private Customer customer;
	
	@Column(name = "username")
	private String username;

	@Column(name = "label_type")
	private String labelType;

	@Column(name = "printer_name")
	private String printerName;
	
	@Column(name = "job_name")
	private String jobName;
	
	@Column(name = "label_count")
	private Integer labelCount;

	@Column(name = "status")
	private String status;
	
	@Column(name = "message")
	private String message;

	public String getId() {
		return id;
	}

	public PrinterHistory setId(String id) {
		this.id = id;
		return this;
	}

	public Customer getCustomer() {
		return customer;
	}

	public PrinterHistory setCustomer(Customer customer) {
		this.customer = customer;
		return this;
	}

	public String getLabelType() {
		return labelType;
	}

	public PrinterHistory setLabelType(String labelType) {
		this.labelType = labelType;
		return this;
	}

	public String getPrinterName() {
		return printerName;
	}

	public PrinterHistory setPrinterName(String printerName) {
		this.printerName = printerName;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public PrinterHistory setStatus(String status) {
		this.status = status;
		return this;
	}

	public String getJobName() {
		return jobName;
	}

	public PrinterHistory setJobName(String jobName) {
		this.jobName = jobName;
		return this;
	}

	public Integer getLabelCount() {
		return labelCount;
	}

	public PrinterHistory setLabelCount(Integer labelCount) {
		this.labelCount = labelCount;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public PrinterHistory setMessage(String message) {
		this.message = message;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
