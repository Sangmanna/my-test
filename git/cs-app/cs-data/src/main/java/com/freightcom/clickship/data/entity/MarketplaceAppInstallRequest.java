package com.freightcom.clickship.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "marketplace_app_install_requests")
public class MarketplaceAppInstallRequest extends BaseEntity {

	private static final long serialVersionUID = 277537792847631321L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "marketplace_type_id", updatable = false)
	private MarketplaceType marketplaceType;

	@Column(name = "store_id")
	private String storeId;

	@Column(name = "key_1")
	private String key1;
	
	@Column(name = "key_2")
	private String key2;

	public String getId() {
		return id;
	}

	public MarketplaceAppInstallRequest setId(String id) {
		this.id = id;
		return this;
	}

	public MarketplaceType getMarketplaceType() {
		return marketplaceType;
	}

	public MarketplaceAppInstallRequest setMarketplaceType(MarketplaceType marketplaceType) {
		this.marketplaceType = marketplaceType;
		return this;
	}

	public String getStoreId() {
		return storeId;
	}

	public MarketplaceAppInstallRequest setStoreId(String storeId) {
		this.storeId = storeId;
		return this;
	}

	public String getKey1() {
		return key1;
	}

	public MarketplaceAppInstallRequest setKey1(String key1) {
		this.key1 = key1;
		return this;
	}

	public String getKey2() {
		return key2;
	}

	public void setKey2(String key2) {
		this.key2 = key2;
	}

}
