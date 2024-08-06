package com.freightcom.clickship.data.entity;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freightcom.clickship.data.entity.common.BaseEntity;
import com.freightcom.clickship.data.entity.common.CustomerAssociateEntity;
import com.freightcom.clickship.model.util.ClickshipStringUtil;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "marketplace_product")
@SQLDelete(sql = "UPDATE marketplace_product SET delete_flag = 1 WHERE id = ?", check = ResultCheckStyle.COUNT)
@SQLRestriction("delete_flag <> 1")
public class MarketplaceProduct extends BaseEntity implements CustomerAssociateEntity {

	private static final long serialVersionUID = -8542870525736335835L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "marketplace_id")
	@JsonIgnore
	private Marketplace marketplace;
	
	@Column(name = "external_product_id")
	private Long externalProductId;

	@Column(name = "external_product_id_str")
	private String externalProductIdStr;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	@JsonIgnore
	private Customer customer;
	
	@Column(name = "sku")
	private String sku;

	@Column(name = "upc")
	private String upc;

	@Column(name = "variant_id")
	private String variantId;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private Double price;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "image_thumbnail")
	private String imageThumbnail;

	@Column(name = "image_url")
	private String imageUrl;

	@Column(name = "image_path")
	private String imagePath;
	
	@Column(name = "barcode")
	private String barcode;
	
	@Column(name = "length")
	private double length;

	@Column(name = "width")
	private double width;

	@Column(name = "height")
	private double height;

	@Column(name = "weight")
	private double weight;
	
	@Column(name = "length_metric")
	private double lengthMetric;

	@Column(name = "width_metric")
	private double widthMetric;

	@Column(name = "height_metric")
	private double heightMetric;

	@Column(name = "weight_metric")
	private double weightMetric;

	@Column(name = "custom_box")
	private boolean customBox;
	
	@Column(name = "is_multi_box")
	private boolean multiBox;
	
	@Column(name = "multi_box_quantity")
	private int multiBoxQuantity = 0;
	
	@Column(name = "origin")
	private String origin;
	
	@Column(name = "discount_price")
	private Double discountPrice;

	@Column(name = "hs_code")
	private String hsCode;
	
	@Column(name = "custom_description")
	private String customDescription;

	@Column(name = "delete_flag")
	private boolean deleteFlag;
	
	@Column(name = "stackable")
	private boolean stackable = true;

	@Column(name = "can_rotate")
	private boolean canRotate = true;
	
	@Column(name = "is_hidden")
	private boolean isHidden = false;
	
	@Column(name = "custom_box_description")
	private String customBoxDescription;
	
	@Column(name = "storage_location_id")
	private String storageLocationId;
	
	@Column(name = "storage_id")
	private String storageId;

	public MarketplaceProduct() {
		
	}
	
	public MarketplaceProduct(Marketplace marketplace) {
		this.marketplace = marketplace;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public BaseEntity setId(String id) {
		this.id = id;
		return this;
	}

	@Override
	public Customer getCustomer() {
		return customer;
	}

	public MarketplaceProduct setCustomer(Customer customer) {
		this.customer = customer;
		return this;
	}

	public String getSku() {
		return sku;
	}

	public MarketplaceProduct setSku(String sku) {
		this.sku = sku;
		return this;
	}

	public String getUpc() {
		return upc;
	}

	public MarketplaceProduct setUpc(String upc) {
		this.upc = upc;
		return this;
	}

	public String getVariantId() {
		return variantId;
	}

	public MarketplaceProduct setVariantId(String variantId) {
		this.variantId = variantId;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public MarketplaceProduct setTitle(String title) {
		String accents = ClickshipStringUtil.getStringStripAccents(title);
		this.title = ClickshipStringUtil.truncateString(accents, 255);
		return this;
	}

	public String getDescription() {
		return description;
	}

	public MarketplaceProduct setDescription(String description) {
		String accents = ClickshipStringUtil.getStringStripAccents(description);
		this.description = ClickshipStringUtil.truncateString(accents, 255);
		return this;
	}

	public Double getPrice() {
		return price;
	}

	public MarketplaceProduct setPrice(Double price) {
		this.price = price;
		return this;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public MarketplaceProduct setQuantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}

	public String getImageThumbnail() {
		return imageThumbnail;
	}

	public MarketplaceProduct setImageThumbnail(String imageThumbnail) {
		this.imageThumbnail = imageThumbnail;
		return this;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public MarketplaceProduct setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
		return this;
	}

	public String getImagePath() {
		return imagePath;
	}

	public MarketplaceProduct setImagePath(String imagePath) {
		this.imagePath = imagePath;
		return this;
	}

	public Marketplace getMarketplace() {
		return marketplace;
	}

	public MarketplaceProduct setMarketplace(Marketplace marketplace) {
		this.marketplace = marketplace;
		return this;
	}

	public String getBarcode() {
		return barcode;
	}

	public MarketplaceProduct setBarcode(String barcode) {
		this.barcode = barcode;
		return this;
	}

	public Long getExternalProductId() {
		return externalProductId;
	}

	public MarketplaceProduct setExternalProductId(Long externalProductId) {
		this.externalProductId = externalProductId;
		return this;
	}

	public String getExternalProductIdStr() {
		return externalProductIdStr;
	}

	public MarketplaceProduct setExternalProductIdStr(String externalProductIdStr) {
		this.externalProductIdStr = externalProductIdStr;
		return this;
	}

	public double getLength() {
		return length;
	}

	public MarketplaceProduct setLength(double length) {
		this.length = length;
		return this;
	}

	public double getWidth() {
		return width;
	}

	public MarketplaceProduct setWidth(double width) {
		this.width = width;
		return this;
	}

	public double getHeight() {
		return height;
	}

	public MarketplaceProduct setHeight(double height) {
		this.height = height;
		return this;
	}

	public double getWeight() {
		return weight;
	}

	public MarketplaceProduct setWeight(double weight) {
		this.weight = weight;
		return this;
	}
	
	public MarketplaceProduct setLength(double lengthImperial, double lengthMetric) {
		this.length = lengthImperial;
		this.lengthMetric = lengthMetric;
		return this;
	}
	
	public MarketplaceProduct setWidth(double widthImperial, double widthMetric) {
		this.width = widthImperial;
		this.widthMetric = widthMetric;
		return this;
	}
	
	public MarketplaceProduct setHeight(double heightImperial, double heightMetric) {
		this.height = heightImperial;
		this.heightMetric = heightMetric;
		return this;
	}
	
	public MarketplaceProduct setWeight(double weightImperial, double weightMetric) {
		this.weight = weightImperial;
		this.weightMetric = weightMetric;
		return this;
	}

	public double getLengthMetric() {
		return lengthMetric;
	}

	public MarketplaceProduct setLengthMetric(double lengthMetric) {
		this.lengthMetric = lengthMetric;
		return this;
	}

	public double getWidthMetric() {
		return widthMetric;
	}

	public MarketplaceProduct setWidthMetric(double widthMetric) {
		this.widthMetric = widthMetric;
		return this;
	}

	public double getHeightMetric() {
		return heightMetric;
	}

	public MarketplaceProduct setHeightMetric(double heightMetric) {
		this.heightMetric = heightMetric;
		return this;
	}

	public double getWeightMetric() {
		return weightMetric;
	}

	public MarketplaceProduct setWeightMetric(double weightMetric) {
		this.weightMetric = weightMetric;
		return this;
	}

	public boolean isCustomBox() {
		return customBox;
	}

	public MarketplaceProduct setCustomBox(boolean customBox) {
		this.customBox = customBox;
		return this;
	}

	public String getOrigin() {
		return origin;
	}

	public MarketplaceProduct setOrigin(String origin) {
		this.origin = origin;
		return this;
	}

	public Double getDiscountPrice() {
		return discountPrice;
	}

	public MarketplaceProduct setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
		return this;
	}

	public String getHsCode() {
		return hsCode;
	}

	public MarketplaceProduct setHsCode(String hsCode) {
		this.hsCode = hsCode;
		return this;
	}

	public String getCustomDescription() {
		return customDescription;
	}

	public MarketplaceProduct setCustomDescription(String customDescription) {
		this.customDescription = customDescription;
		return this;
	}

	public boolean isDeleteFlag() {
		return deleteFlag;
	}

	public MarketplaceProduct setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
		return this;
	}
	
	public boolean getStackable() {
		return stackable;
	}

	public MarketplaceProduct setStackable(boolean stackable) {
		this.stackable = stackable;
		return this;
	}

	public boolean getCanRotate() {
		return canRotate;
	}

	public MarketplaceProduct setCanRotate(boolean canRotate) {
		this.canRotate = canRotate;
		return this;
	}

	public boolean isMultiBox() {
		return multiBox;
	}

	public MarketplaceProduct setMultiBox(boolean multiBox) {
		this.multiBox = multiBox;
		
		if(!multiBox) {
			this.multiBoxQuantity = 0;
		}
		
		if(multiBox) {
			this.customBox = true;
		}
		
		return this;
	}
	
	public int getMultiBoxQuantity() {
		return multiBoxQuantity;
	}

	public MarketplaceProduct setMultiBoxQuantity(int multiBoxQuantity) {
		this.multiBoxQuantity = multiBoxQuantity;
		return this;
	}
	
	public boolean isHidden() {
		return isHidden;
	}

	public MarketplaceProduct setHidden(boolean isHidden) {
		this.isHidden = isHidden;
		return this;
	}	

	public String getCustomBoxDescription() {
		return customBoxDescription;
	}

	public MarketplaceProduct setCustomBoxDescription(String customBoxDescription) {
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

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj instanceof MarketplaceProduct) {
			MarketplaceProduct pObj = (MarketplaceProduct) obj;
			if (pObj.getExternalProductId().equals(this.getExternalProductId()) && StringUtils.equals(pObj.getVariantId(), this.getVariantId())) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		String extProductId = "" + this.getExternalProductId();
		String vId = "" + this.getVariantId();
		return super.hashCode() + extProductId.hashCode() + vId.hashCode();
	}
}
