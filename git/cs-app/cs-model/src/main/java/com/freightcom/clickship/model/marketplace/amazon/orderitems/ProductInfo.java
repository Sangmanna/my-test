package com.freightcom.clickship.model.marketplace.amazon.orderitems;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ProductInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="NumberOfItems")
	private String numberOfItems;
	
	public ProductInfo() {
		super();
	}
	
	public ProductInfo(String numberOfItems) {
		super();
		this.numberOfItems = numberOfItems;
	}

	public String getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(String numberOfItems) {
		this.numberOfItems = numberOfItems;
	}
	
	
}
