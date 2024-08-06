package com.freightcom.clickship.model.marketplace.amazon.products;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SmallImage", namespace="http://mws.amazonservices.com/schema/Products/2011-10-01/default.xsd")
@XmlAccessorType(XmlAccessType.FIELD)
public class SmallImage implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@XmlAttribute(name="Units")
	private String units;
	
	@XmlElement(name="URL", namespace="http://mws.amazonservices.com/schema/Products/2011-10-01/default.xsd")
	private String url;
	@XmlElement(name="Height", namespace="http://mws.amazonservices.com/schema/Products/2011-10-01/default.xsd")
	private String height;
	@XmlElement(name="Width", namespace="http://mws.amazonservices.com/schema/Products/2011-10-01/default.xsd")
	private String width;
	
	public SmallImage() {
		super();
	}
	
	public SmallImage(String url, String height, String width, String units) {
		super();
		this.url = url;
		this.height = height;
		this.width = width;
		this.units = units;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}
	
	
	

}
