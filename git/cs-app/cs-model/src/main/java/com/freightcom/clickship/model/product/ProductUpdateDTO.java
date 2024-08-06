package com.freightcom.clickship.model.product;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.freightcom.clickship.model.CommonDTO;

public class ProductUpdateDTO extends CommonDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3641095219579853786L;
	private String id;
	private String variantId = "";
	private String externalProductId;
	private String externalProductIdStr = "";
	private String title;
	private Double length;
	private Double width;
	private Double height;
	private Double weight;
	private String unitOfMeasure;
	private Double lengthMetric;
	private Double widthMetric;
	private Double heightMetric;
	private Double weightMetric;
	private Double lengthImperial;
	private Double widthImperial;
	private Double heightImperial;
	private Double weightImperial;
	private Boolean customBox;
	private String sku;
	private String hsCode;
	private String customDescription;
	private String countryOfOrigin;
	private Boolean stackable;
	private Boolean canRotate;
	private Boolean multiBox;
	private int multiBoxQuantity;
	private String description;
	private String postalCode;
	private String storageId;
	private String storageLocationId;
	private String marketplaceId;
	
	private List<MarketplaceProductMultiBoxDTO> multiBoxList = new ArrayList<>();

	public String getId() {
		return id;
	}
	public ProductUpdateDTO setId(String id) {
		this.id = id;
		return this;
	}
	public String getExternalProductId() {
		return externalProductId;
	}
	public ProductUpdateDTO setExternalProductId(BigInteger externalProductId) {
		this.externalProductId = externalProductId != null ? externalProductId.toString() : "";
		return this;
	}

	public String getExternalProductIdStr() {
		return externalProductIdStr;
	}

	public ProductUpdateDTO setExternalProductIdStr(String externalProductIdStr) {
		this.externalProductIdStr = externalProductIdStr;
		return this;
	}
	public String getTitle() {
		return title;
	}
	public ProductUpdateDTO setTitle(String title) {
		this.title = title;
		return this;
	}
	public Double getLength() {
		return length;
	}
	public ProductUpdateDTO setLength(Double length) {
		this.length = length;
		return this;
	}
	public Double getWidth() {
		return width;
	}
	public ProductUpdateDTO setWidth(Double width) {
		this.width = width;
		return this;
	}
	public Double getHeight() {
		return height;
	}
	public ProductUpdateDTO setHeight(Double height) {
		this.height = height;
		return this;
	}
	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}
	public ProductUpdateDTO setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
		return this;
	}
	public Boolean getCustomBox() {
		return customBox;
	}
	public ProductUpdateDTO setCustomBox(Boolean customBox) {
		this.customBox = customBox;
		return this;
	}
	public Double getWeight() {
		return weight;
	}
	public ProductUpdateDTO setWeight(Double weight) {
		this.weight = weight;
		return this;
	}
	public Double getLengthMetric() {
		return lengthMetric;
	}
	public ProductUpdateDTO setLengthMetric(Double lengthMetric) {
		this.lengthMetric = lengthMetric;
		return this;
	}
	public Double getWidthMetric() {
		return widthMetric;
	}
	public ProductUpdateDTO setWidthMetric(Double widthMetric) {
		this.widthMetric = widthMetric;
		return this;
	}
	public Double getHeightMetric() {
		return heightMetric;
	}
	public ProductUpdateDTO setHeightMetric(Double heightMetric) {
		this.heightMetric = heightMetric;
		return this;
	}
	public Double getWeightMetric() {
		return weightMetric;
	}
	public ProductUpdateDTO setWeightMetric(Double weightMetric) {
		this.weightMetric = weightMetric;
		return this;
	}
	public Double getLengthImperial() {
		return lengthImperial;
	}
	public ProductUpdateDTO setLengthImperial(Double lengthImperial) {
		this.lengthImperial = lengthImperial;
		return this;
	}
	public Double getWidthImperial() {
		return widthImperial;
	}
	public ProductUpdateDTO setWidthImperial(Double widthImperial) {
		this.widthImperial = widthImperial;
		return this;
	}
	public Double getHeightImperial() {
		return heightImperial;
	}
	public ProductUpdateDTO setHeightImperial(Double heightImperial) {
		this.heightImperial = heightImperial;
		return this;
	}
	public Double getWeightImperial() {
		return weightImperial;
	}
	public ProductUpdateDTO setWeightImperial(Double weightImperial) {
		this.weightImperial = weightImperial;
		return this;
	}
	public String getVariantId() {
		return variantId;
	}
	public ProductUpdateDTO setVariantId(String variantId) {
		this.variantId = variantId;
		return this;
	}

	public String getSku() {
		return sku;
	}

	public ProductUpdateDTO setSku(String sku) {
		this.sku = sku;
		return this;
	}

	public String getHsCode() {
		return hsCode;
	}

	public ProductUpdateDTO setHsCode(String hsCode) {
		this.hsCode = hsCode;
		return this;
	}

	public String getCustomDescription() {
		return customDescription;
	}
	
	public ProductUpdateDTO setCustomDescription(String customDescription) {
		this.customDescription = customDescription;
		return this;
	}
	
	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public ProductUpdateDTO setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
		return this;
	}
	public Boolean getStackable() {
		return stackable;
	}

	public ProductUpdateDTO setStackable(Boolean stackable) {
		this.stackable = stackable;
		return this;
	}

	public Boolean getCanRotate() {
		return canRotate;
	}

	public ProductUpdateDTO setCanRotate(Boolean canRotate) {
		this.canRotate = canRotate;
		return this;
	}
	
	public Boolean getMultiBox() {
		return multiBox;
	}
	
	public ProductUpdateDTO setMultiBox(Boolean multiBox) {
		this.multiBox = multiBox != null && multiBox;
		return this;
	}
	
	public List<MarketplaceProductMultiBoxDTO> getMultiBoxList() {
		return multiBoxList;
	}

	public ProductUpdateDTO setMultiBoxList(List<MarketplaceProductMultiBoxDTO> multiBoxList) {
		this.multiBoxList = multiBoxList;
		return this;
	}
	
	public ProductUpdateDTO addMultiBox(MarketplaceProductMultiBoxDTO dto) {
		this.multiBoxList.add(dto);
		return this;
	}
	
	public int getMultiBoxQuantity() {
		return multiBoxQuantity;
	}
	
	public ProductUpdateDTO setMultiBoxQuantity(int multiBoxQuantity) {
		this.multiBoxQuantity = multiBoxQuantity;
		return this;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getStorageId() {
		return storageId;
	}
	public void setStorageId(String storageId) {
		this.storageId = storageId;
	}
	public String getMarketplaceId() {
		return marketplaceId;
	}
	public void setMarketplaceId(String marketplaceId) {
		this.marketplaceId = marketplaceId;
	}
	public String getStorageLocationId() {
		return storageLocationId;
	}
	public void setStorageLocationId(String storageLocationId) {
		this.storageLocationId = storageLocationId;
	}
	
	
	
}
