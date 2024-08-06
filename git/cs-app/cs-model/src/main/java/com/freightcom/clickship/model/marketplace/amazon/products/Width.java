package com.freightcom.clickship.model.marketplace.amazon.products;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "Width")
@XmlAccessorType(XmlAccessType.FIELD)
public class Width implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public Width() {
		super();
	}
	
	@XmlAttribute(name="Units")
	private String units;
	
	@XmlValue
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}
}
