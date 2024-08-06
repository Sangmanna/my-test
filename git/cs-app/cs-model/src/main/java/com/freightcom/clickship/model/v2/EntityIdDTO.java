package com.freightcom.clickship.model.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.freightcom.clickship.model.CommonDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EntityIdDTO extends CommonDTO {
	private String id;
	private String type;

	public String getId() {
		return id;
	}

	public EntityIdDTO setId(String id) {
		this.id = id;
		return this;
	}

	public String getType() {
		return type;
	}

	public EntityIdDTO setType(String type) {
		this.type = type;
		return this;
	}

}