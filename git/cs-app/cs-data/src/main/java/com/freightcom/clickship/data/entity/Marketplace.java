package com.freightcom.clickship.data.entity;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLRestriction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freightcom.clickship.data.entity.common.BaseEntity;
import com.freightcom.clickship.data.entity.common.CustomerAssociateEntity;
import com.freightcom.clickship.model.enums.CurrencyType;
import com.freightcom.clickship.model.util.ClickshipStringUtil;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "marketplace")
@SQLRestriction("is_deleted <> 1")
public class Marketplace extends BaseEntity implements CustomerAssociateEntity {

	private static final long serialVersionUID = 7024608409628159351L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "marketplace_type_id", updatable = false)
	private MarketplaceType marketplaceType;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "customer_id")
	@JsonIgnore
	private Customer customer;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "default_shipping_address_id")
	@JsonIgnore
	private CustomerAddress defaultAddress;

	@Column(name = "alias_name", nullable = false)
	private String aliasName;

	@Column(name = "active")
	private Boolean active = true;

	@Column(name = "integration_success")
	private Boolean integrationSuccess = false;

	@Column(name = "secret")
	private String secret;

	@Column(name = "token")
	private String token;

	@Column(name = "private_key")
	private String privateKey;

	@Column(name = "store_url")
	private String storeUrl;

	@Column(name = "currency")
	private String currency = CurrencyType.defaultCurrency.toString();

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "multi_location")
	private boolean multiLocation;

	@Column(name = "prev_import_job_exec_datetime")
	private Date prevJobExecDate;

	@Column(name = "est_ship_time")
	private Integer estShipTime;

	@Column(name = "inv_percentage")
	private Double invPercentage;

	@Column(name = "inv_threshold")
	private Integer invThreshold;

	@Column(name = "inv_percentage_wknd")
	private Double invPercentageWknd;

	@Column(name = "inv_threshold_wknd")
	private Double invThresholdWknd;

	@Column(name = "threshold_percentage_on")
	private Boolean thresholdPercentageOn;

	@Column(name = "threshold_percentage_wknd_on")
	private Boolean thresholdPercentageWkndOn;

	@Column(name = "is_importing")
	private boolean isImporting = true;

	@Column(name = "carrier_service_id")
	private String carrierServiceId;

	@Column(name = "is_import_success")
	private boolean isImportSuccess = false;
	
	@Column(name = "is_deleted")
	private boolean isDeleted = false;
	
	@Column(name = "show_renew_button")
	private boolean showRenewButton = false;
	
	@Transient
	private boolean isPrimaryShopifyStore;
	
	public String getId() {
		return id;
	}

	public BaseEntity setId(String id) {
		this.id = id;
		return this;
	}

	public String getAliasName() {
		return aliasName;
	}

	public Marketplace setAliasName(String aliasName) {
		this.aliasName = aliasName;
		return this;
	}

	public Boolean getActive() {
		return active;
	}

	public Marketplace setActive(Boolean active) {
		this.active = active;
		return this;
	}

	public Boolean getIntegrationSuccess() {
		return integrationSuccess;
	}

	public Marketplace setIntegrationSuccess(Boolean integrationSuccess) {
		this.integrationSuccess = integrationSuccess;
		return this;
	}

	public String getCurrency() {
		return ClickshipStringUtil.nvl(currency, CurrencyType.defaultCurrency.toString());
	}

	public Marketplace setCurrency(String currency) {
		this.currency = ClickshipStringUtil.nvl(currency, CurrencyType.defaultCurrency.toString());
		return this;
	}

	public String getPassword() {
		return password;
	}

	public Marketplace setPassword(String password) {
		this.password = password;
		return this;
	}

	public boolean isMultiLocation() {
		return multiLocation;
	}

	public Marketplace setMultiLocation(boolean multiLocation) {
		this.multiLocation = multiLocation;
		return this;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Marketplace setCustomer(Customer customer) {
		this.customer = customer;
		return this;
	}

	public String getToken() {
		return token;
	}

	public Marketplace setToken(String token) {
		this.token = token;
		return this;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public Marketplace setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
		return this;
	}

	public String getStoreUrl() {
		return storeUrl;
	}

	public Marketplace setStoreUrl(String storeUrl) {
		this.storeUrl = storeUrl;
		return this;
	}

	public MarketplaceType getMarketplaceType() {
		return marketplaceType;
	}

	public Marketplace setMarketplaceType(MarketplaceType marketplaceType) {
		this.marketplaceType = marketplaceType;
		return this;
	}

	public Integer getEstShipTime() {
		return estShipTime;
	}

	public Marketplace setEstShipTime(Integer estShipTime) {
		this.estShipTime = estShipTime;
		return this;
	}

	public Double getInvPercentage() {
		return invPercentage;
	}

	public Marketplace setInvPercentage(Double invPercentage) {
		this.invPercentage = invPercentage;
		return this;
	}

	public Integer getInvThreshold() {
		return invThreshold;
	}

	public Marketplace setInvThreshold(Integer invThreshold) {
		this.invThreshold = invThreshold;
		return this;
	}

	public Double getInvPercentageWknd() {
		return invPercentageWknd;
	}

	public Marketplace setInvPercentageWknd(Double invPercentageWknd) {
		this.invPercentageWknd = invPercentageWknd;
		return this;
	}

	public Double getInvThresholdWknd() {
		return invThresholdWknd;
	}

	public Marketplace setInvThresholdWknd(Double invThresholdWknd) {
		this.invThresholdWknd = invThresholdWknd;
		return this;
	}

	public Boolean getThresholdPercentageOn() {
		return thresholdPercentageOn;
	}

	public Marketplace setThresholdPercentageOn(Boolean thresholdPercentageOn) {
		this.thresholdPercentageOn = thresholdPercentageOn;
		return this;
	}

	public Boolean getThresholdPercentageWkndOn() {
		return thresholdPercentageWkndOn;
	}

	public Marketplace setThresholdPercentageWkndOn(Boolean thresholdPercentageWkndOn) {
		this.thresholdPercentageWkndOn = thresholdPercentageWkndOn;
		return this;
	}

	public CustomerAddress getDefaultAddress() {
		return defaultAddress;
	}

	public Marketplace setDefaultAddress(CustomerAddress defaultAddress) {
		this.defaultAddress = defaultAddress;
		return this;
	}

	public String getSecret() {
		return secret;
	}

	public Marketplace setSecret(String secret) {
		this.secret = secret;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public Marketplace setUsername(String username) {
		this.username = username;
		return this;
	}

	public Date getPrevJobExecDate() {
		return prevJobExecDate;
	}

	public Marketplace setPrevJobExecDate(Date prevJobExecDate) {
		this.prevJobExecDate = prevJobExecDate;
		return this;
	}

	public boolean getIsImporting() {
		return isImporting;
	}

	public Marketplace setIsImporting(boolean isImporting) {
		this.isImporting = isImporting;
		return this;
	}

	public String getCarrierServiceId() {
		return carrierServiceId;
	}

	public Marketplace setCarrierServiceId(String carrierServiceId) {
		this.carrierServiceId = carrierServiceId;
		return this;
	}

	public boolean isImportSuccess() {
		return isImportSuccess;
	}

	public Marketplace setImportSuccess(boolean isImportSuccess) {
		this.isImportSuccess = isImportSuccess;
		return this;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public Marketplace setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
		return this;
	}

	public boolean isShowRenewButton() {
		return showRenewButton;
	}

	public void setShowRenewButton(boolean showRenewButton) {
		this.showRenewButton = showRenewButton;
	}

	public boolean isPrimaryShopifyStore() {
		return isPrimaryShopifyStore;
	}

	public void setPrimaryShopifyStore(boolean isPrimaryShopifyStore) {
		this.isPrimaryShopifyStore = isPrimaryShopifyStore;
	}
}