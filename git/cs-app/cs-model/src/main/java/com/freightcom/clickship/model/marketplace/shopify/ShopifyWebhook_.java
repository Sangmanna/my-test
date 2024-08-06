package com.freightcom.clickship.model.marketplace.shopify;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyWebhook_ implements Serializable {

	private static final long serialVersionUID = -177063583487049512L;
	
	private ShopifyWebhook webhook;
	
	public ShopifyWebhook_() {
		super();
	}
	public ShopifyWebhook_(ShopifyWebhook webhook) {
		super();
		this.webhook = webhook;
	}

	public ShopifyWebhook getWebhook() {
		return webhook;
	}

	public void setWebhook(ShopifyWebhook webhook) {
		this.webhook = webhook;
	}
	
}
