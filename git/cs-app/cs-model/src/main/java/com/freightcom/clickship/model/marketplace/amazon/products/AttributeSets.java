package com.freightcom.clickship.model.marketplace.amazon.products;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "AttributeSets")
@XmlAccessorType(XmlAccessType.FIELD)
public class AttributeSets implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="ItemAttributes", namespace="http://mws.amazonservices.com/schema/Products/2011-10-01/default.xsd")
	private ItemAttributes itemAttributes;
	
	public AttributeSets() {
		super();
	}
	
	public AttributeSets(ItemAttributes itemAttributes) {
		super();
		this.itemAttributes = itemAttributes;
	}

	public ItemAttributes getItemAttributes() {
		return itemAttributes;
	}

	public void setItemAttributes(ItemAttributes itemAttributes) {
		this.itemAttributes = itemAttributes;
	}
}
