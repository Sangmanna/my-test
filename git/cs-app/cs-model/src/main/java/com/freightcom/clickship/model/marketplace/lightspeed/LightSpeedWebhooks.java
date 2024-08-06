package com.freightcom.clickship.model.marketplace.lightspeed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LightSpeedWebhooks extends LightSpeedBaseEntity {

	@JsonProperty("isActive")
	private Boolean isActive;

	@JsonProperty("itemGroup")
	private String itemGroup;

	@JsonProperty("itemAction")
	private String itemAction;

	@JsonProperty("language")
	private Object language;

	@JsonProperty("format")
	private String format;

	@JsonProperty("address")
	private String address;

	public Boolean getIsActive() {
		return isActive;
	}

	public LightSpeedWebhooks setIsActive(Boolean isActive) {
		this.isActive = isActive;
		return this;
	}

	public String getItemGroup() {
		return itemGroup;
	}

	public LightSpeedWebhooks setItemGroup(String itemGroup) {
		this.itemGroup = itemGroup;
		return this;
	}

	public String getItemAction() {
		return itemAction;
	}

	public LightSpeedWebhooks setItemAction(String itemAction) {
		this.itemAction = itemAction;
		return this;
	}

	public Object getLanguage() {
		return language;
	}

	public LightSpeedWebhooks setLanguage(Object language) {
		this.language = language;
		return this;
	}

	public String getFormat() {
		return format;
	}

	public LightSpeedWebhooks setFormat(String format) {
		this.format = format;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public LightSpeedWebhooks setAddress(String address) {
		this.address = address;
		return this;
	}

	@Override
	public String toString() {
		return "LightSpeedWebhooks [isActive=" + isActive + ", itemGroup=" + itemGroup + ", itemAction=" + itemAction
				+ ", format=" + format + ", address=" + address + "]";
	}
}
