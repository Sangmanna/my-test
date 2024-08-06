package com.freightcom.clickship.model.marketplace.vendasta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class VendastaIDTokenClaims {

    @JsonProperty("aud")
    private String audience;

    @JsonProperty("exp")
    private Integer expiry;

    @JsonProperty("iat")
    private Integer issuedAt;

    @JsonProperty("iss")
    private String issuer;

    @JsonProperty("sub")
    private String subject;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("kind")
    private String kind;

    @JsonProperty("kid")
    private String keyId;

    @JsonProperty("service_provider_id")
    private String serviceProviderId;

    @JsonProperty("legacy_user_id")
    private String legacyUserId;

    @JsonProperty("at_hash")
    private String atHash;

    @JsonProperty("given_name")
    private String givenName;

    @JsonProperty("family_name")
    private String familyName;

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public Integer getExpiry() {
        return expiry;
    }

    public void setExpiry(Integer expiry) {
        this.expiry = expiry;
    }

    public Integer getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(Integer issuedAt) {
        this.issuedAt = issuedAt;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getServiceProviderId() {
        return serviceProviderId;
    }

    public void setServiceProviderId(String serviceProviderId) {
        this.serviceProviderId = serviceProviderId;
    }

    public String getLegacyUserId() {
        return legacyUserId;
    }

    public void setLegacyUserId(String legacyUserId) {
        this.legacyUserId = legacyUserId;
    }

    public String getAtHash() {
        return atHash;
    }

    public void setAtHash(String atHash) {
        this.atHash = atHash;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }
}
