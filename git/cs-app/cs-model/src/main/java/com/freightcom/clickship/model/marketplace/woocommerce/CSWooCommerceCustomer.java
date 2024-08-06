package com.freightcom.clickship.model.marketplace.woocommerce;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CSWooCommerceCustomer implements Serializable {

	private static final long serialVersionUID = -2065291257696984210L;

	private String customers;
	
	private String fixWebhooks;
	
	public CSWooCommerceCustomer() {
		super();
		
		this.fixWebhooks = "true";
		this.customers = StringUtils.EMPTY;
	}

	public String getCustomers() {
		return customers;
	}

	public CSWooCommerceCustomer setCustomers(String customers) {
		this.customers = customers;
		return this;
	}

	public String getFixWebhooks() {
		return fixWebhooks;
	}

	public CSWooCommerceCustomer setFixWebhooks(String fixWebhooks) {
		this.fixWebhooks = fixWebhooks;
		return this;
	}
	
}
