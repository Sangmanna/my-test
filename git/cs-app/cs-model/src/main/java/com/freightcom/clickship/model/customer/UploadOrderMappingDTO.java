package com.freightcom.clickship.model.customer;

import com.freightcom.clickship.model.CommonDTO;

public class UploadOrderMappingDTO extends CommonDTO {
	
	private String id;
	
	private String name;
	
	private String mappingJson;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMappingJson() {
		return mappingJson;
	}

	public void setMappingJson(String mappingJson) {
		this.mappingJson = mappingJson;
	}
}
