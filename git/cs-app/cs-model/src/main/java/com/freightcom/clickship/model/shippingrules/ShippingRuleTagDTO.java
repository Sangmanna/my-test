package com.freightcom.clickship.model.shippingrules;

import com.freightcom.clickship.model.tag.TagDTO;

public class ShippingRuleTagDTO {
	private String id;
	private TagDTO tagDTO;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public TagDTO getTagDTO() {
		return tagDTO;
	}
	public void setTagDTO(TagDTO tagDTO) {
		this.tagDTO = tagDTO;
	}	
}
