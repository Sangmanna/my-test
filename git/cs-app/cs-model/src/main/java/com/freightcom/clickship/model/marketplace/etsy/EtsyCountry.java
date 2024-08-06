package com.freightcom.clickship.model.marketplace.etsy;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EtsyCountry implements Serializable {

	private static final long serialVersionUID = -5023914284663131875L;

	@JsonProperty("lat")
	private Float lat;

	@JsonProperty("lon")
	private Float lon;

	@JsonProperty("name")
	private String name;

	@JsonProperty("slug")
	private String slug;

	@JsonProperty("country_id")
	private Long countryId;

	@JsonProperty("iso_country_code")
	private String isoCountryCode;

	@JsonProperty("world_bank_country_code")
	private String worldBankCountryCode;

	public Float getLat() {
		return lat;
	}

	public void setLat(Float lat) {
		this.lat = lat;
	}

	public Float getLon() {
		return lon;
	}

	public void setLon(Float lon) {
		this.lon = lon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getIsoCountryCode() {
		return isoCountryCode;
	}

	public void setIsoCountryCode(String isoCountryCode) {
		this.isoCountryCode = isoCountryCode;
	}

	public String getWorldBankCountryCode() {
		return worldBankCountryCode;
	}

	public void setWorldBankCountryCode(String worldBankCountryCode) {
		this.worldBankCountryCode = worldBankCountryCode;
	}
}
