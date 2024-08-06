package com.freightcom.clickship.model.tag;

import java.io.Serializable;

import com.freightcom.clickship.model.CommonDTO;

public class TagDTO extends CommonDTO implements Serializable {
	
	private static final long serialVersionUID = -3642702373309825150L;
	
	private String id;
	
	private String name;
	
	private String colorRgb;
	
	public TagDTO() {
		super();
	}
	
	public TagDTO(String id, String name, String colorRgb) {
		super();
		this.id = id;
		this.name = name;
		this.colorRgb = colorRgb;
	}

	public String getId() {
		return id;
	}

	public TagDTO setId(String id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public TagDTO setName(String name) {
		this.name = name;
		return this;
	}

	public String getColorRgb() {
		return colorRgb;
	}

	public TagDTO setColorRgb(String colorRgb) {
		this.colorRgb = colorRgb;
		return this;
	}
	
}
