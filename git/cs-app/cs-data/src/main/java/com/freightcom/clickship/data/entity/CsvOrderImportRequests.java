package com.freightcom.clickship.data.entity;

import java.io.Serializable;

import org.hibernate.annotations.GenericGenerator;

import com.freightcom.clickship.data.entity.common.BaseEntity;
import com.freightcom.clickship.data.entity.common.CustomerAssociateEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "csv_order_import_requests")
public class CsvOrderImportRequests extends BaseEntity implements Serializable, CustomerAssociateEntity {

	private static final long serialVersionUID = 1865703718296219133L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@ManyToOne(fetch = FetchType.EAGER)
	private Customer customer;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "marketplace_id")
	private Marketplace marketplace;

	@Column(name = "marketplace_name", nullable = false, updatable = false)
	private String marketplaceName;
	
	@Column(name = "file_type")
	private String fileType;

	@Column(name = "path", nullable = false, updatable = false)
	private String path;

	@Column(name = "status", nullable = false)
	private String status;

	@Column(name = "success_count", nullable = false)
	private int successCount;

	@Column(name = "failure_count", nullable = false)
	private int failureCount;
	
	@Column(name = "mappings")
	private String mappings;
	
	@Column(name = "general_error")
	private String generalError;

	@Override
	public Customer getCustomer() {
		return customer;
	}

	public CsvOrderImportRequests setCustomer(Customer customer) {
		this.customer = customer;
		return this;
	}

	public Marketplace getMarketplace() {
		return marketplace;
	}

	public CsvOrderImportRequests setMarketplace(Marketplace marketplace) {
		this.marketplace = marketplace;
		return this;
	}

	public String getMarketplaceName() {
		return marketplaceName;
	}

	public CsvOrderImportRequests setMarketplaceName(String marketplaceName) {
		this.marketplaceName = marketplaceName;
		return this;
	}

	public String getPath() {
		return path;
	}

	public CsvOrderImportRequests setPath(String path) {
		this.path = path;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public CsvOrderImportRequests setStatus(String status) {
		this.status = status;
		return this;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public CsvOrderImportRequests setId(String id) {
		this.id = id;
		return this;
	}

	public int getSuccessCount() {
		return successCount;
	}

	public CsvOrderImportRequests setSuccessCount(int successCount) {
		this.successCount = successCount;
		return this;
	}

	public int getFailureCount() {
		return failureCount;
	}

	public CsvOrderImportRequests setFailureCount(int failureCount) {
		this.failureCount = failureCount;
		return this;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getMappings() {
		return mappings;
	}

	public void setMappings(String mappings) {
		this.mappings = mappings;
	}

	public String getGeneralError() {
		return generalError;
	}

	public void setGeneralError(String generalError) {
		this.generalError = generalError;
	}
}
