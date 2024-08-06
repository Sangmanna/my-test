package com.freightcom.clickship.model.marketplace.lightspeed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LightSpeedRequest {

	@JsonProperty("webhook")
	private LightSpeedWebhooks webhook;

	public LightSpeedWebhooks getWebhook() {
		return webhook;
	}

	public LightSpeedRequest setWebhook(LightSpeedWebhooks webhook) {
		this.webhook = webhook;
		return this;
	}
}
