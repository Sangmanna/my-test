package com.freightcom.clickship.model.marketplace.woocommerce;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WooCommerceWebhookBatchResponse {
	
	private List<WooCommerceWebhookResponse> create;
	
	private List<WooCommerceWebhookResponse> delete;

	public List<WooCommerceWebhookResponse> getCreate() {
		return create;
	}

	public WooCommerceWebhookBatchResponse setCreate(List<WooCommerceWebhookResponse> create) {
		this.create = create;
		return this;
	}

	public List<WooCommerceWebhookResponse> getDelete() {
		return delete;
	}

	public WooCommerceWebhookBatchResponse setDelete(List<WooCommerceWebhookResponse> delete) {
		this.delete = delete;
		return this;
	}	
}
