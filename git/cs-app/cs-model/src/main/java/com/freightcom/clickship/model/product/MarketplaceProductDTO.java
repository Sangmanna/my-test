package com.freightcom.clickship.model.product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.freightcom.clickship.model.CommonDTO;
import com.freightcom.clickship.model.tag.TagDTO;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketplaceProductDTO extends CommonDTO implements Serializable {
	
	private static final long serialVersionUID = -6693529657344830007L;

	private String id;
	private String sku;
	private String title;
	private String price;
	private int quantity;
	private String hsCode;
	private String origin;
	private String imageUrl;
	private String barcode;
	private String description;
	private String customDescription;

	private Double length;
	private Double width;
	private Double height;
	private Double weight;
	private Double lengthMetric;
	private Double widthMetric;
	private Double heightMetric;
	private Double weightMetric;

	private String unitPrice;
	private Double lineSubtotal;
	private Double discountPrice;
	
	private String currency;
	private String weightUnit;
	private String unitsOfMeasure;
	private String marketPlace;
	private String marketplaceId;
	private String marketplaceTypeName;
	private String customBoxDescription;

	private Boolean multiBox = false;
	private Boolean customBox = false;
	private Boolean stackable = true;
	private Boolean canRotate = true;
	
	private Integer multiBoxQuantity = 0;
	
	private List<TagDTO> tagDtoList = new ArrayList<>();
	
	private List<MarketplaceProductMultiBoxDTO> multiBoxList = new ArrayList<>();
	
	private Date createdDatetime;
	
	private String storageLocationId;
	private String storageId;
	
	// We need to show empty box when user want to add new in UI. 
	private MarketplaceProductMultiBoxDTO dummyBox;

	public String getImageUrl() {
		return imageUrl;
	}

	public MarketplaceProductDTO setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public MarketplaceProductDTO setTitle(String title) {
		this.title = title;
		return this;
	}

	public Double getLength() {
		return length;
	}

	public MarketplaceProductDTO setLength(Double length) {
		this.length = length;
		return this;
	}

	public Double getWidth() {
		return width;
	}

	public MarketplaceProductDTO setWidth(Double width) {
		this.width = width;
		return this;
	}

	public Double getHeight() {
		return height;
	}

	public MarketplaceProductDTO setHeight(Double height) {
		this.height = height;
		return this;
	}

	public Double getLengthMetric() {
		return lengthMetric;
	}

	public MarketplaceProductDTO setLengthMetric(Double lengthMetric) {
		this.lengthMetric = lengthMetric;
		return this;
	}

	public Double getWidthMetric() {
		return widthMetric;
	}

	public MarketplaceProductDTO setWidthMetric(Double widthMetric) {
		this.widthMetric = widthMetric;
		return this;
	}

	public Double getHeightMetric() {
		return heightMetric;
	}

	public MarketplaceProductDTO setHeightMetric(Double heightMetric) {
		this.heightMetric = heightMetric;
		return this;
	}

	public Double getWeightMetric() {
		return weightMetric;
	}

	public MarketplaceProductDTO setWeightMetric(Double weightMetric) {
		this.weightMetric = weightMetric;
		return this;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public MarketplaceProductDTO setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
		return this;
	}

	public Double getLineSubtotal() {
		return lineSubtotal;
	}

	public MarketplaceProductDTO setLineSubtotal(Double lineSubtotal) {
		this.lineSubtotal = lineSubtotal;
		return this;
	}

	public Double getDiscountPrice() {
		return discountPrice;
	}

	public MarketplaceProductDTO setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
		return this;
	}
	
	public String getCurrency() {
		return currency;
	}

	public MarketplaceProductDTO setCurrency(String currency) {
		this.currency = currency;
		return this;
	}

	public String getWeightUnit() {
		return weightUnit;
	}

	public MarketplaceProductDTO setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
		return this;
	}

	public String getMarketPlace() {
		return marketPlace;
	}

	public MarketplaceProductDTO setMarketPlace(String marketPlace) {
		this.marketPlace = marketPlace;
		return this;
	}

	public String getMarketplaceTypeName() {
		return marketplaceTypeName;
	}

	public MarketplaceProductDTO setMarketplaceTypeName(String marketplaceTypeName) {
		this.marketplaceTypeName = marketplaceTypeName;
		return this;
	}

	public String getMarketplaceId() {
		return marketplaceId;
	}

	public MarketplaceProductDTO setMarketplaceId(String marketplaceId) {
		this.marketplaceId = marketplaceId;
		return this;
	}

	public String getUnitsOfMeasure() {
		return unitsOfMeasure;
	}

	public MarketplaceProductDTO setUnitsOfMeasure(String unitsOfMeasure) {
		this.unitsOfMeasure = unitsOfMeasure;
		return this;
	}
	
	public Boolean isMultiBox() {
		return multiBox != null && multiBox;
	}

	public MarketplaceProductDTO setMultiBox(Boolean multiBox) {
		this.multiBox = multiBox;
		return this;
	}

	public Boolean isCustomBox() {
		return customBox;
	}

	public MarketplaceProductDTO setCustomBox(Boolean customBox) {
		this.customBox = customBox;
		return this;
	}

	public Double getWeight() {
		return weight;
	}

	public MarketplaceProductDTO setWeight(Double weight) {
		this.weight = weight;
		return this;
	}

	public String getOrigin() {
		return origin;
	}

	public MarketplaceProductDTO setOrigin(String origin) {
		this.origin = origin;
		return this;
	}

	public String getSku() {
		return sku;
	}

	public MarketplaceProductDTO setSku(String sku) {
		this.sku = sku;
		return this;
	}

	public String getBarcode() {
		return barcode;
	}

	public MarketplaceProductDTO setBarcode(String barcode) {
		this.barcode = barcode;
		return this;
	}

	public String getPrice() {
		return price;
	}

	public MarketplaceProductDTO setPrice(String price) {
		this.price = price;
		return this;
	}

	public int getQuantity() {
		return quantity;
	}

	public MarketplaceProductDTO setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}

	public String getId() {
		return id;
	}

	public MarketplaceProductDTO setId(String id) {
		this.id = id;
		return this;
	}

	public String getHsCode() {
		return hsCode;
	}

	public MarketplaceProductDTO setHsCode(String hsCode) {
		this.hsCode = hsCode;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public MarketplaceProductDTO setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getCustomDescription() {
		return customDescription;
	}

	public MarketplaceProductDTO setCustomDescription(String customDescription) {
		this.customDescription = customDescription;
		return this;
	}

	public Boolean getCanRotate() {
		return canRotate;
	}

	public MarketplaceProductDTO setCanRotate(Boolean canRotate) {
		this.canRotate = canRotate;
		return this;
	}

	public Boolean getStackable() {
		return stackable;
	}

	public MarketplaceProductDTO setStackable(Boolean stackable) {
		this.stackable = stackable;
		return this;
	}

	public Date getCreatedDatetime() {
		return createdDatetime;
	}

	public MarketplaceProductDTO setCreatedDatetime(Date createdDatetime) {
		this.createdDatetime = createdDatetime;
		return this;
	}

	public Integer getMultiBoxQuantity() {
		return multiBoxQuantity != null ? multiBoxQuantity : 0;
	}

	public MarketplaceProductDTO setMultiBoxQuantity(Integer multiBoxQuantity) {
		this.multiBoxQuantity = multiBoxQuantity;
		return this;
	}

	public List<MarketplaceProductMultiBoxDTO> getMultiBoxList() {
		if(multiBoxList == null) {
			multiBoxList = new ArrayList<>();
		}
		
		return multiBoxList;
	}

	public MarketplaceProductDTO setMultiBoxList(List<MarketplaceProductMultiBoxDTO> multiBoxList) {
		this.multiBoxList = multiBoxList;
		return this;
	}

	public MarketplaceProductMultiBoxDTO getDummyBox() {
		return dummyBox;
	}

	public MarketplaceProductDTO setDummyBox(MarketplaceProductMultiBoxDTO dummyBox) {
		this.dummyBox = dummyBox;
		return this;
	}

	public List<TagDTO> getTagDtoList() {
		return tagDtoList;
	}

	public void setTagDtoList(List<TagDTO> tagDtoList) {
		this.tagDtoList = tagDtoList;
	}

	public String getCustomBoxDescription() {
		return customBoxDescription;
	}

	public MarketplaceProductDTO setCustomBoxDescription(String customBoxDescription) {
		this.customBoxDescription = customBoxDescription;
		return this;
	}

	public String getStorageLocationId() {
		return storageLocationId;
	}

	public void setStorageLocationId(String storageLocationId) {
		this.storageLocationId = storageLocationId;
	}

	public String getStorageId() {
		return storageId;
	}

	public void setStorageId(String storageId) {
		this.storageId = storageId;
	}

}