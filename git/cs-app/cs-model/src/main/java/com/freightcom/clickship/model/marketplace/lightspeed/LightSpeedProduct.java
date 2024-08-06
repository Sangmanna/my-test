package com.freightcom.clickship.model.marketplace.lightspeed;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LightSpeedProduct extends LightSpeedBaseEntity {
	
	private static final String IMAGE = "image";

	@JsonProperty("title")
	private String title;

	@JsonProperty("description")
	private String description;

	@JsonProperty("isVisible")
	private boolean isVisible;

	@JsonProperty("variants")
	private LightSpeedVariant variants;
	
	@JsonProperty("resource")
	private LightSpeedResource resource;

	private List<LightSpeedVariant> variantsList;

	private Map<Object, Object> imageMap = new HashMap<>();
	
	private LightSpeedImage lightSpeedImage;
	
	public String getTitle() {
		return title;
	}

	public LightSpeedProduct setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public LightSpeedProduct setDescription(String description) {
		this.description = description;
		return this;
	}

	public boolean isVisible() {
		return isVisible;
	}

	public LightSpeedProduct setVisible(boolean isVisible) {
		this.isVisible = isVisible;
		return this;
	}

	public LightSpeedResource getResource() {
		return resource;
	}

	public LightSpeedProduct setResource(LightSpeedResource resource) {
		this.resource = resource;
		return this;
	}

	public LightSpeedVariant getVariants() {
		return variants;
	}

	public LightSpeedProduct setVariants(LightSpeedVariant variants) {
		this.variants = variants;
		return this;
	}

	public List<LightSpeedVariant> getVariantsList() {
		return variantsList;
	}

	public LightSpeedProduct setVariantsList(List<LightSpeedVariant> variantsList) {
		this.variantsList = variantsList;
		return this;
	}
	
	public LightSpeedImage getLightSpeedImage() {
		return lightSpeedImage;
	}

	public LightSpeedProduct setLightSpeedImage(LightSpeedImage lightSpeedImage) {
		this.lightSpeedImage = lightSpeedImage;
		return this;
	}

	@JsonAnyGetter
	public Map<Object, Object> getImageMap() {
		return imageMap;
	}

	// image field value will false, if image not found, else image object, so
	// checking for instanceof operator
	@JsonAnySetter
	public void setImageMap(String key, Object value) {
		if (this.imageMap == null) {
			this.imageMap = new HashMap<>();
		}
		this.imageMap.put(key, value);

		if (this.imageMap.get(IMAGE) != null && !(this.imageMap.get(IMAGE) instanceof Boolean)) {
			LightSpeedImage lsImage = new ObjectMapper().convertValue(this.imageMap.get(IMAGE), LightSpeedImage.class);
			if (lsImage != null) {
				lightSpeedImage = lsImage;
			}
		}
	}

}
