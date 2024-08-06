package com.freightcom.clickship.model.marketplace.woocommerce;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WooCommerceWebhookBatchRequest {
	
	private List<WooCommerceWebhookRequest> create;
	
	private List<String> delete;

	public WooCommerceWebhookBatchRequest(List<WooCommerceWebhookRequest> create, List<String> delete) {
		super();
		this.create = create != null ?  create : Collections.emptyList();
		this.delete = delete != null ?  delete : Collections.emptyList();
	}

	public List<WooCommerceWebhookRequest> getCreate() {
		return create;
	}

	public WooCommerceWebhookBatchRequest setCreate(List<WooCommerceWebhookRequest> create) {
		this.create = create;
		return this;
	}

	public List<String> getDelete() {
		return delete;
	}

	public WooCommerceWebhookBatchRequest setDelete(List<String> delete) {
		this.delete = delete;
		return this;
	}

}
