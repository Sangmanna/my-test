package com.freightcom.clickship.model.v2;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PackingResDTO {
	
	@JsonProperty("packages")
	private List<PackagingPropertiesDTO> packPropsDto;

	public List<PackagingPropertiesDTO> getPackPropsDto() {
		return packPropsDto;
	}

	public void setPackPropsDto(List<PackagingPropertiesDTO> packPropsDto) {
		this.packPropsDto = packPropsDto;
	}
	
	

}
