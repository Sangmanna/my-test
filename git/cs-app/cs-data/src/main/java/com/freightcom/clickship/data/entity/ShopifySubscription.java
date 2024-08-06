package com.freightcom.clickship.data.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "shopify_subscriptions")
public class ShopifySubscription extends BaseEntity {

	private static final long serialVersionUID = -6486456280484205245L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", nullable = false, updatable = false)
	@JsonIgnore
	private Customer customer;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "marketplace_id", nullable = false, updatable = false)
	private Marketplace marketplace;
	
	@Column(name = "addon_id")
	private String addonId;
	
	@Column(name = "addon_type")
	private String addonType = "CLICKSHIP"; // CLICKSHIP / SHOPIFY
	
	@Column(name = "addon_name")
	private String addonName; // CLUBBED NAME INCASE of multiple add-ons opted SINCE SHOPIFY SUPPORTS ONLY ONE RECUURING
	
	@Column(name = "shopify_subscription_id")
	private String shopifySubscriptionId;
	
	@Column(name = "prev_shopify_subscription_id")
	private String prevShopifySubscriptionId;

	@Column(name = "amount")
	private Double amount = 0.0d;

	@Column(name = "currency")
	private String currency;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "renewed_on")
	private Date renewedOn;
	
	@Column(name = "subscribed_on")
	private Date subscribedOn;
	
	@Column(name = "un_subscribed_on")
	private Date unsubscribedOn;
	
	@Column(name = "un_subscribed_channel")
	private String unSubscribedChannel; 

	public ShopifySubscription() {
		super();
	}

	public ShopifySubscription(Customer customer, Marketplace marketplace, String addonType) {
		super();

		this.customer = customer;
		this.addonType = addonType;
		this.marketplace = marketplace;
		this.subscribedOn = new Date();
	}

	public String getId() {
		return id;
	}

	public ShopifySubscription setId(String id) {
		this.id = id;
		return this;
	}

	public Customer getCustomer() {
		return customer;
	}

	public ShopifySubscription setCustomer(Customer customer) {
		this.customer = customer;
		return this;
	}

	public Marketplace getMarketplace() {
		return marketplace;
	}

	public ShopifySubscription setMarketplace(Marketplace marketplace) {
		this.marketplace = marketplace;
		return this;
	}
	
	public String getAddonId() {
		return addonId;
	}

	public ShopifySubscription setAddonId(String addonId) {
		this.addonId = addonId;
		return this;
	}

	public String getAddonType() {
		return addonType;
	}

	public ShopifySubscription setAddonType(String addonType) {
		this.addonType = addonType;
		return this;
	}

	public String getAddonName() {
		return addonName;
	}

	public ShopifySubscription setAddonName(String addonName) {
		this.addonName = addonName;
		return this;
	}

	public String getShopifySubscriptionId() {
		return shopifySubscriptionId;
	}

	public ShopifySubscription setShopifySubscriptionId(String shopifySubscriptionId) {
		this.shopifySubscriptionId = shopifySubscriptionId;
		return this;
	}
	
	public String getPrevShopifySubscriptionId() {
		return prevShopifySubscriptionId;
	}

	public ShopifySubscription setPrevShopifySubscriptionId(String prevShopifySubscriptionId) {
		this.prevShopifySubscriptionId = prevShopifySubscriptionId;
		return this;
	}

	public Double getAmount() {
		return amount;
	}

	public ShopifySubscription setAmount(Double amount) {
		this.amount = amount;
		return this;
	}

	public String getCurrency() {
		return currency;
	}

	public ShopifySubscription setCurrency(String currency) {
		this.currency = currency;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public ShopifySubscription setStatus(String status) {
		this.status = status;
		return this;
	}

	public Date getSubscribedOn() {
		return subscribedOn;
	}

	public ShopifySubscription setSubscribedOn(Date subscribedOn) {
		this.subscribedOn = subscribedOn;
		return this;
	}

	public Date getUnsubscribedOn() {
		return unsubscribedOn;
	}

	public ShopifySubscription setUnsubscribedOn(Date unsubscribedOn) {
		this.unsubscribedOn = unsubscribedOn;
		return this;
	}

	public Date getRenewedOn() {
		return renewedOn;
	}

	public ShopifySubscription setRenewedOn(Date renewedOn) {
		this.renewedOn = renewedOn;
		return this;
	}

	public String getUnSubscribedChannel() {
		return unSubscribedChannel;
	}

	public ShopifySubscription setUnSubscribedChannel(String unSubscribedChannel) {
		this.unSubscribedChannel = unSubscribedChannel;
		return this;
	}
	
	public void setPlanDetails(String... strings) {
		this.setCurrency(strings[2]);
		this.setAddonName(strings[0]);
		this.setAmount(Double.parseDouble(strings[1]));
	}

}

