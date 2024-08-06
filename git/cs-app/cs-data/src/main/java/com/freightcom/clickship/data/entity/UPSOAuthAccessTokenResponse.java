package com.freightcom.clickship.data.entity;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freightcom.clickship.data.entity.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ups_oauth_access_token_response")
public class UPSOAuthAccessTokenResponse extends BaseEntity {

	private static final long serialVersionUID = 5434526593528837319L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "carrier_account_id", nullable = false, updatable = false)
	@JsonIgnore
	private CarrierAccount carrierAccount;

	@Column(name = "refresh_token_expires_in")
	private int refreshTokenExpiresIn;

	@Column(name = "refresh_token_status")
	private String refreshTokenStatus;

	@Column(name = "old_access_token_life_time")
	private int oldAccessTokenLifeTime;

	@Column(name = "token_type")
	private String tokenType;

	@Column(name = "issued_at")
	private Date issuedAt;

	@Column(name = "client_id")
	private String clientId;

	@Column(name = "access_token")
	private String accessToken;

	@Column(name = "refresh_token")
	private String refreshToken;

	@Column(name = "scope")
	private String scope;

	@Column(name = "refresh_token_issued_at")
	private Date refreshTokenIssuedAt;

	@Column(name = "expires_in")
	private int expiresIn;

	@Column(name = "refresh_count")
	private int refreshCount;

	@Column(name = "status")
	private String status;

	public String getRefreshTokenStatus() {
		return refreshTokenStatus;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public Date getIssuedAt() {
		return issuedAt;
	}

	public void setIssuedAt(Date issuedAt) {
		this.issuedAt = issuedAt;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
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

	public CarrierAccount getCarrierAccount() {
		return carrierAccount;
	}

	public void setCarrierAccount(CarrierAccount carrierAccount) {
		this.carrierAccount = carrierAccount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getRefreshTokenExpiresIn() {
		return refreshTokenExpiresIn;
	}

	public void setRefreshTokenExpiresIn(int refreshTokenExpiresIn) {
		this.refreshTokenExpiresIn = refreshTokenExpiresIn;
	}

	public int getOldAccessTokenLifeTime() {
		return oldAccessTokenLifeTime;
	}

	public void setOldAccessTokenLifeTime(int oldAccessTokenLifeTime) {
		this.oldAccessTokenLifeTime = oldAccessTokenLifeTime;
	}

	public Date getRefreshTokenIssuedAt() {
		return refreshTokenIssuedAt;
	}

	public void setRefreshTokenIssuedAt(Date refreshTokenIssuedAt) {
		this.refreshTokenIssuedAt = refreshTokenIssuedAt;
	}

	public int getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}

	public int getRefreshCount() {
		return refreshCount;
	}

	public void setRefreshCount(int refreshCount) {
		this.refreshCount = refreshCount;
	}

	public void setRefreshTokenStatus(String refreshTokenStatus) {
		this.refreshTokenStatus = refreshTokenStatus;
	}
}