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
@Table(name = "printer_setup")
public class PrinterSetup extends BaseEntity {

	private static final long serialVersionUID = -2091685558014125980L;

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

	@Column(name = "label_size")
	private String labelSize;

	@Column(name = "width")
	private Double width;

	@Column(name = "height")
	private Double height;

	@Column(name = "unit_of_measure")
	private String unitOfMeasure;

	@Column(name = "printer_name")
	private String printerName;

	public String getId() {
		return id;
	}

	public PrinterSetup setId(String id) {
		this.id = id;
		return this;
	}

	public Customer getCustomer() {
		return customer;
	}

	public PrinterSetup setCustomer(Customer customer) {
		this.customer = customer;
		return this;
	}

	public String getLabelType() {
		return labelType;
	}

	public PrinterSetup setLabelType(String labelType) {
		this.labelType = labelType;
		return this;
	}

	public String getLabelSize() {
		return labelSize;
	}

	public PrinterSetup setLabelSize(String labelSize) {
		this.labelSize = labelSize;
		return this;
	}

	public Double getWidth() {
		return width;
	}

	public PrinterSetup setWidth(Double width) {
		this.width = width;
		return this;
	}

	public Double getHeight() {
		return height;
	}

	public PrinterSetup setHeight(Double height) {
		this.height = height;
		return this;
	}

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public PrinterSetup setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
		return this;
	}

	public String getPrinterName() {
		return printerName;
	}

	public PrinterSetup setPrinterName(String printerName) {
		this.printerName = printerName;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
