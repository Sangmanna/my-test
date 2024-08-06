package com.freightcom.clickship.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "woocommerce_customers")
public class WooCommerceCustomer extends BaseEntity {

	private static final long serialVersionUID = -1853773616088400445L;
	
	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;
	
	@Column(name = "customer_id", nullable = false)
	private String customer;
	
	@Column(name = "business_name", nullable = false)
	private String businessName;
	
	@Column(name = "marketplace_id", nullable = false)
	private String marketplace;
	
	@Column(name = "store_url", nullable = false)
	private String storeUrl;
	
	@Column(name = "integration_status")
	private boolean integrationStatus = true;
	
	@Column(name = "webhooks_status")
	private boolean webhooksStatus = true;
	
	@Column(name = "err_msg")
	private String errors;
	
	public WooCommerceCustomer() {
		super();
	}
	
	public WooCommerceCustomer(String customer, String businessName, String marketplace, String url) {
		super();
		this.storeUrl = url;
		this.customer = customer;
		this.marketplace = marketplace;
		this.businessName = businessName;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public WooCommerceCustomer setId(String id) {
		this.id = id;
		return this;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getMarketplace() {
		return marketplace;
	}

	public void setMarketplace(String marketplace) {
		this.marketplace = marketplace;
	}

	public String getStoreUrl() {
		return storeUrl;
	}

	public void setStoreUrl(String storeUrl) {
		this.storeUrl = storeUrl;
	}

	public boolean isIntegrationStatus() {
		return integrationStatus;
	}

	public void setIntegrationStatus(boolean integrationStatus) {
		this.integrationStatus = integrationStatus;
	}

	public boolean isWebhooksStatus() {
		return webhooksStatus;
	}

	public void setWebhooksStatus(boolean webhooksStatus) {
		this.webhooksStatus = webhooksStatus;
	}

	public String getErrors() {
		return errors;
	}

	public void setErrors(String errors) {
		this.errors = errors;
	}
	
}
