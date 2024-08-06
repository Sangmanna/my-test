package com.freightcom.clickship.model.marketplace.lightspeed;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LightSpeedVariant extends LightSpeedBaseEntity {
	
	private static final String IMAGE = "image";

	@JsonProperty("title")
	private String title;

	@JsonProperty("sku")
	private String sku;

	@JsonProperty("ean")
	private String ean;

	@JsonProperty("hs")
	private String hs;

	@JsonProperty("isDefault")
	private Boolean isDefault;

	@JsonProperty("priceExcl")
	private Double priceExcl;

	@JsonProperty("priceIncl")
	private Double priceIncl;

	@JsonProperty("articleCode")
	private String articleCode;

	@JsonProperty("unitPrice")
	private Double unitPrice;

	@JsonProperty("unitUnit")
	private String unitUnit;

	@JsonProperty("weight")
	private Double weight;

	@JsonProperty("weightValue")
	private Double weightValue;

	@JsonProperty("weightUnit")
	private String weightUnit;

	@JsonProperty("volume")
	private Double volume;

	@JsonProperty("volumeUnit")
	private String volumeUnit;

	@JsonProperty("sizeX")
	private Double sizeX;

	@JsonProperty("sizeY")
	private Double sizeY;

	@JsonProperty("sizeZ")
	private Double sizeZ;
	
	@JsonProperty("sizeXValue")
	private Double sizeXValue;
	
	@JsonProperty("sizeYValue")
	private Double sizeYValue;
	
	@JsonProperty("sizeZValue")
	private Double sizeZValue;
	
	@JsonProperty("sizeUnit")
	private String sizeUnit;

	@JsonProperty("resource")
	private LightSpeedResource resource;

	@JsonProperty("product")
	private LightSpeedProduct product;

	private Map<Object, Object> imageMap = new HashMap<>();
	
	private LightSpeedImage lightSpeedImage;

	public String getTitle() {
		return title;
	}

	public LightSpeedVariant setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getSku() {
		return sku;
	}

	public LightSpeedVariant setSku(String sku) {
		this.sku = sku;
		return this;
	}

	public String getEan() {
		return ean;
	}

	public LightSpeedVariant setEan(String ean) {
		this.ean = ean;
		return this;
	}

	public String getHs() {
		return hs;
	}

	public LightSpeedVariant setHs(String hs) {
		this.hs = hs;
		return this;
	}

	public String getArticleCode() {
		return articleCode;
	}

	public LightSpeedVariant setArticleCode(String articleCode) {
		this.articleCode = articleCode;
		return this;
	}

	public Boolean getIsDefault() {
		return isDefault;
	}

	public LightSpeedVariant setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
		return this;
	}

	public Double getPriceExcl() {
		return priceExcl;
	}

	public LightSpeedVariant setPriceExcl(Double priceExcl) {
		this.priceExcl = priceExcl;
		return this;
	}

	public Double getPriceIncl() {
		return priceIncl;
	}

	public LightSpeedVariant setPriceIncl(Double priceIncl) {
		this.priceIncl = priceIncl;
		return this;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public LightSpeedVariant setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
		return this;
	}

	public String getUnitUnit() {
		return unitUnit;
	}

	public LightSpeedVariant setUnitUnit(String unitUnit) {
		this.unitUnit = unitUnit;
		return this;
	}

	public Double getWeight() {
		return weight;
	}

	public LightSpeedVariant setWeight(Double weight) {
		this.weight = weight;
		return this;
	}

	public Double getWeightValue() {
		return weightValue;
	}

	public LightSpeedVariant setWeightValue(Double weightValue) {
		this.weightValue = weightValue;
		return this;
	}

	public String getWeightUnit() {
		return weightUnit;
	}

	public LightSpeedVariant setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
		return this;
	}

	public Double getVolume() {
		return volume;
	}

	public LightSpeedVariant setVolume(Double volume) {
		this.volume = volume;
		return this;
	}

	public String getVolumeUnit() {
		return volumeUnit;
	}

	public LightSpeedVariant setVolumeUnit(String volumeUnit) {
		this.volumeUnit = volumeUnit;
		return this;
	}

	public Double getSizeX() {
		return sizeX;
	}

	public LightSpeedVariant setSizeX(Double sizeX) {
		this.sizeX = sizeX;
		return this;
	}

	public Double getSizeY() {
		return sizeY;
	}

	public LightSpeedVariant setSizeY(Double sizeY) {
		this.sizeY = sizeY;
		return this;
	}

	public Double getSizeZ() {
		return sizeZ;
	}

	public LightSpeedVariant setSizeZ(Double sizeZ) {
		this.sizeZ = sizeZ;
		return this;
	}

	public Double getSizeXValue() {
		return sizeXValue;
	}

	public LightSpeedVariant setSizeXValue(Double sizeXValue) {
		this.sizeXValue = sizeXValue;
		return this;
	}

	public Double getSizeYValue() {
		return sizeYValue;
	}

	public LightSpeedVariant setSizeYValue(Double sizeYValue) {
		this.sizeYValue = sizeYValue;
		return this;
	}

	public Double getSizeZValue() {
		return sizeZValue;
	}

	public LightSpeedVariant setSizeZValue(Double sizeZValue) {
		this.sizeZValue = sizeZValue;
		return this;
	}

	public String getSizeUnit() {
		return sizeUnit;
	}

	public LightSpeedVariant setSizeUnit(String sizeUnit) {
		this.sizeUnit = sizeUnit;
		return this;
	}

	public LightSpeedResource getResource() {
		return resource;
	}

	public LightSpeedVariant setResource(LightSpeedResource resource) {
		this.resource = resource;
		return this;
	}

	public LightSpeedProduct getProduct() {
		return product;
	}

	public LightSpeedVariant setProduct(LightSpeedProduct product) {
		this.product = product;
		return this;
	}

	public LightSpeedImage getLightSpeedImage() {
		return lightSpeedImage;
	}

	public LightSpeedVariant setLightSpeedImage(LightSpeedImage lightSpeedImage) {
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
