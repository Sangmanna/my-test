package com.freightcom.clickship.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "marketplace_type")
public class MarketplaceType extends BaseEntity {

	private static final long serialVersionUID = 1118610104213724917L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@Column(name = "name")
	private String name;

	@Column(name = "bean_prefix")
	private String beanPrefix;

	@Column(name = "order_import_type")
	private String orderImportType;

	@Column(name = "product_id_str")
	private boolean productIdStr;

	@Column(name = "seq")
	private Long seq;

	@Column(name = "rtr_response_threshold")
	private Integer rtrResponseThreshold;

	@Column(name = "data_encrypted")
	private boolean dataEncrypted;

	@Column(name = "store_type")
	private String storeType;

	@Column(name = "image_url")
	private String imageUrl;

	@Column(name = "video_url")
	private String videoUrl;
	
	@Column(name = "support_rtr")
	private Boolean supportRtr;

	@Column(name = "rtr_video_url")
	private String rtrVideoUrl;
	
	@Column(name = "location_split")
	private boolean locationSplitAllowed;
	
	public String getId() {
		return id;
	}

	public BaseEntity setId(String id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public MarketplaceType setName(String name) {
		this.name = name;
		return this;
	}

	public String getBeanPrefix() {
		return beanPrefix;
	}

	public MarketplaceType setBeanPrefix(String beanPrefix) {
		this.beanPrefix = beanPrefix;
		return this;
	}

	public String getOrderImportType() {
		return orderImportType;
	}

	public void setOrderImportType(String orderImportType) {
		this.orderImportType = orderImportType;
	}

	public boolean isProductIdStr() {
		return productIdStr;
	}

	public void setProductIdStr(boolean productIdStr) {
		this.productIdStr = productIdStr;
	}

	public Long getSeq() {
		return seq;
	}

	public MarketplaceType setSeq(Long seq) {
		this.seq = seq;
		return this;
	}

	public Integer getRtrResponseThreshold() {
		return rtrResponseThreshold;
	}

	public MarketplaceType setRtrResponseThreshold(Integer rtrResponseThreshold) {
		this.rtrResponseThreshold = rtrResponseThreshold;
		return this;
	}

	public boolean isDataEncrypted() {
		return dataEncrypted;
	}

	public MarketplaceType setDataEncrypted(boolean dataEncrypted) {
		this.dataEncrypted = dataEncrypted;
		return this;
	}

	public String getStoreType() {
		return storeType;
	}

	public MarketplaceType setStoreType(String storeType) {
		this.storeType = storeType;
		return this;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public MarketplaceType setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
		return this;
	}
	

	public String getVideoUrl() {
		return videoUrl;
	}

	public MarketplaceType setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
		return this;
	}

	public Boolean getSupportRtr() {
		return supportRtr;
	}

	public MarketplaceType setSupportRtr(Boolean supportRtr) {
		this.supportRtr = supportRtr;
		return this;
	}

	public String getRtrVideoUrl() {
		return rtrVideoUrl;
	}

	public MarketplaceType setRtrVideoUrl(String rtrVideoUrl) {
		this.rtrVideoUrl = rtrVideoUrl;
		return this;
	}

	public boolean isLocationSplitAllowed() {
		return locationSplitAllowed;
	}

	public MarketplaceType setLocationSplitAllowed(boolean locationSplitAllowed) {
		this.locationSplitAllowed = locationSplitAllowed;
		return this;
	}

}