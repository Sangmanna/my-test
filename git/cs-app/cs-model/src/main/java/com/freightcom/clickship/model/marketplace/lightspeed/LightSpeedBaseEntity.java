package com.freightcom.clickship.model.marketplace.lightspeed;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LightSpeedBaseEntity {

	@JsonProperty("id")
	private String id;

	@JsonProperty("createdAt")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date createdAt;

	@JsonProperty("updatedAt")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date updatedAt;

	public String getId() {
		return id;
	}

	public LightSpeedBaseEntity setId(String id) {
		this.id = id;
		return this;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public LightSpeedBaseEntity setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
		return this;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public LightSpeedBaseEntity setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}

}
