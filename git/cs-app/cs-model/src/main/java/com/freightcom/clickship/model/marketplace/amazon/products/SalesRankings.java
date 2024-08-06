package com.freightcom.clickship.model.marketplace.amazon.products;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SalesRankings")
@XmlAccessorType(XmlAccessType.FIELD)
public class SalesRankings  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public SalesRankings() {
		super();
	}
}
