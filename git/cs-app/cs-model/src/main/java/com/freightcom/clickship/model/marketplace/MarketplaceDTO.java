package com.freightcom.clickship.model.marketplace;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.freightcom.clickship.model.CommonDTO;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketplaceDTO extends CommonDTO implements Serializable {

	private static final long serialVersionUID = 2587774399926726908L;

	private String id;

	private String url;

	private String type;

	private String name;

	private boolean status;

	private String currency;

	private String installURL;

	private String redirectURL;

	private String accessToken;

	private String privateKey;
	
	private String secret;
	
	private String username;

	private String password;
	
	private boolean isImporting;

	private boolean integrationSuccess;

	private boolean isImportSuccess;
	
	private String productIdentifier;
	
	private boolean isLocationSplitAllowed;
	
	private MarketplaceTypeDTO typeDTO;

	public String getId() {
		return id;
	}

	public MarketplaceDTO setId(String id) {
		this.id = id;
		return this;
	}

	public String getUrl() {
		return url;
	}

	public MarketplaceDTO setUrl(String url) {
		this.url = url;
		return this;
	}

	public String getType() {
		return type;
	}

	public MarketplaceDTO setType(String type) {
		this.type = type;
		return this;
	}

	public String getName() {
		return name;
	}

	public MarketplaceDTO setName(String name) {
		this.name = name;
		return this;
	}

	public boolean isStatus() {
		return status;
	}

	public MarketplaceDTO setActive(boolean status) {
		this.status = status;
		return this;
	}

	public String getCurrency() {
		return currency;
	}

	public MarketplaceDTO setCurrency(String currency) {
		this.currency = currency;
		return this;
	}

	public String getInstallURL() {
		return installURL;
	}

	public MarketplaceDTO setInstallURL(String installURL) {
		this.installURL = installURL;
		return this;
	}

	public String getRedirectURL() {
		return redirectURL;
	}

	public MarketplaceDTO setRedirectURL(String redirectURL) {
		this.redirectURL = redirectURL;
		return this;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public MarketplaceDTO setAccessToken(String accessToken) {
		this.accessToken = accessToken;
		return this;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public MarketplaceDTO setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
		return this;
	}

	public String getSecret() {
		return secret;
	}

	public MarketplaceDTO setSecret(String secret) {
		this.secret = secret;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public MarketplaceDTO setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public MarketplaceDTO setPassword(String password) {
		this.password = password;
		return this;
	}

	public boolean getIsImporting() {
		return isImporting;
	}

	public MarketplaceDTO setIsImporting(boolean isImporting) {
		this.isImporting = isImporting;
		return this;
	}

	public boolean isIntegrationSuccess() {
		return integrationSuccess;
	}

	public String getProductIdentifier() {
		return productIdentifier;
	}

	public MarketplaceDTO setProductIdentifier(String productIdentifier) {
		this.productIdentifier = productIdentifier;
		return this;
	}

	public MarketplaceDTO setIntegrationSuccess(boolean integrationSuccess) {
		this.integrationSuccess = integrationSuccess;
		return this;
	}

	public boolean isImportSuccess() {
		return isImportSuccess;
	}

	public MarketplaceDTO setImportSuccess(boolean isImportSuccess) {
		this.isImportSuccess = isImportSuccess;
		return this;
	}

	public MarketplaceTypeDTO getTypeDTO() {
		return typeDTO;
	}

	public MarketplaceDTO setTypeDTO(MarketplaceTypeDTO typeDTO) {
		this.typeDTO = typeDTO;
		return this;
	}

	public boolean isLocationSplitAllowed() {
		return isLocationSplitAllowed;
	}

	public MarketplaceDTO setLocationSplitAllowed(boolean isLocationSplitAllowed) {
		this.isLocationSplitAllowed = isLocationSplitAllowed;
		return this;
	}

}