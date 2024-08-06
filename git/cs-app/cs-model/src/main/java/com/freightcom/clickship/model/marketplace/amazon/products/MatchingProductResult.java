package com.freightcom.clickship.model.marketplace.amazon.products;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GetMatchingProductResult")
@XmlAccessorType(XmlAccessType.FIELD)
public class MatchingProductResult implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="Product")
	private Product product;
	
	public MatchingProductResult() {
		super();
	}
	
	public MatchingProductResult(Product product) {
		super();
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
