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
@Table(name = "marketplace_webhooks")
public class MarketplaceWebhooks extends BaseEntity {

	private static final long serialVersionUID = -2971032300954519336L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class )
	@Column(name = "id", nullable = false, updatable = false)
	private String id;
	
	@Column(name = "external_webhooks_id")
	private String externalWebhooksId;
	
	@Column(name = "endpoint")
	private String endpoint;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "marketplace_id", updatable = false)
	private Marketplace marketplace;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "code_id", updatable = false)
	private Code code;
	
	@Override
	public String getId() {
		return id;
	}
	
	public String getExternalWebhooksId() {
		return externalWebhooksId;
	}

	public MarketplaceWebhooks setExternalWebhooksId(String externalWebhooksId) {
		this.externalWebhooksId = externalWebhooksId;
		return this;
	}

	public Marketplace getMarketplace() {
		return marketplace;
	}

	public MarketplaceWebhooks setMarketplace(Marketplace marketplace) {
		this.marketplace = marketplace;
		return this;
	}

	public Code getCode() {
		return code;
	}

	public MarketplaceWebhooks setCode(Code code) {
		this.code = code;
		return this;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public MarketplaceWebhooks setEndpoint(String endpoint) {
		this.endpoint = endpoint;
		return this;
	}

	@Override
	public BaseEntity setId(String id) {
		this.id = id;
		return this;
	}
}
