package com.freightcom.clickship.model.marketplace.amazon.products;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ItemDimensions", namespace="http://mws.amazonservices.com/schema/Products/2011-10-01/default.xsd")
@XmlAccessorType(XmlAccessType.FIELD)
public class ItemDimensions implements Serializable{

	private static final long serialVersionUID = 1L;

	@XmlElement(name="Height", namespace="http://mws.amazonservices.com/schema/Products/2011-10-01/default.xsd")
	private Height height;
	@XmlElement(name="Length", namespace="http://mws.amazonservices.com/schema/Products/2011-10-01/default.xsd")
	private Length length;
	@XmlElement(name="Width", namespace="http://mws.amazonservices.com/schema/Products/2011-10-01/default.xsd")
	private Width width;	
	@XmlElement(name="Weight", namespace="http://mws.amazonservices.com/schema/Products/2011-10-01/default.xsd")
	private Weight weight;
	


	public Height getHeight() {
		return height;
	}

	public void setHeight(Height height) {
		this.height = height;
	}

	public Length getLength() {
		return length;
	}

	public void setLength(Length length) {
		this.length = length;
	}

	public Width getWidth() {
		return width;
	}

	public void setWidth(Width width) {
		this.width = width;
	}

	public ItemDimensions() {
		super();
	}
	
	public ItemDimensions(Height height, Length length, Width width, Weight weight) {
		super();
		this.height = height;
		this.length = length;
		this.width = width;
		this.weight = weight;
	}

	public Weight getWeight() {
		return weight;
	}

	public void setWeight(Weight weight) {
		this.weight = weight;
	}
}
