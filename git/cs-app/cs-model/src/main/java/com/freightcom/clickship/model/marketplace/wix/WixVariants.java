package com.freightcom.clickship.model.marketplace.wix;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WixVariants {

	@JsonProperty("id")
	private String id;

	@JsonProperty("variant")
	private WixVariant variant;

	@JsonProperty("choices")
	private Map<String, Object> choices = new HashMap<>();

	// webhooks fields
	@JsonProperty("variantId")
	private String variantId;

	@JsonProperty("changedFields")
	private List<String> changedFields;

	public String getId() {
		return id;
	}

	public WixVariants setId(String id) {
		this.id = id;
		return this;
	}

	public WixVariant getVariant() {
		return variant;
	}

	public WixVariants setVariant(WixVariant variant) {
		this.variant = variant;
		return this;
	}

	public String getVariantId() {
		return variantId;
	}

	public WixVariants setVariantId(String variantId) {
		this.variantId = variantId;
		return this;
	}

	public List<String> getChangedFields() {
		return changedFields;
	}

	public WixVariants setChangedFields(List<String> changedFields) {
		this.changedFields = changedFields;
		return this;
	}

	@JsonAnyGetter
	public Map<String, Object> getChoices() {
		return choices;
	}

	@JsonAnySetter
	public void addOtherInfo(String key, Object value) {
		if (this.choices == null) {
			this.choices = new HashMap<>();
		}
		this.choices.put(key, value);
	}

}
