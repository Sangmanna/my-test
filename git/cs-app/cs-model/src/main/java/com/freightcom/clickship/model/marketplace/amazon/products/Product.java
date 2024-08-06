package com.freightcom.clickship.model.marketplace.amazon.products;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Product")
@XmlAccessorType(XmlAccessType.FIELD)
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="Identifiers")
	private Identifiers identifiers;
	@XmlElement(name="AttributeSets")
	private AttributeSets attributeSets;
	@XmlElement(name="Relationships")
	private Relationships relationships;
	@XmlElement(name="SalesRankings")
	private SalesRankings salesRankings;
	
	
	public Product() {
		super();
	}
	
	public Product(Identifiers identifiers, AttributeSets attributeSets, Relationships relationships,
			SalesRankings salesRankings) {
		super();
		this.identifiers = identifiers;
		this.attributeSets = attributeSets;
		this.relationships = relationships;
		this.salesRankings = salesRankings;
		
	}

	public Identifiers getIdentifiers() {
		return identifiers;
	}

	public void setIdentifiers(Identifiers identifiers) {
		this.identifiers = identifiers;
	}

	public AttributeSets getAttributeSets() {
		return attributeSets;
	}

	public void setAttributeSets(AttributeSets attributeSets) {
		this.attributeSets = attributeSets;
	}

	public Relationships getRelationships() {
		return relationships;
	}

	public void setRelationships(Relationships relationships) {
		this.relationships = relationships;
	}

	public SalesRankings getSalesRankings() {
		return salesRankings;
	}

	public void setSalesRankings(SalesRankings salesRankings) {
		this.salesRankings = salesRankings;
	}
	
}
