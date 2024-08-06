package com.freightcom.clickship.model.carrier.freightcom;

import jakarta.xml.bind.annotation.XmlAttribute;

//@XmlAccessorType(XmlAccessType.NONE)
public abstract class ShipAddress {

	@XmlAttribute(name = "address1")
	protected String address1;
	
	@XmlAttribute(name = "address2")
	protected String address2;
	
	@XmlAttribute(name = "attention")
	protected String attention;
	
	@XmlAttribute(name = "city")
	protected String city;

	@XmlAttribute(name = "company")
	protected String company;

	@XmlAttribute(name = "country")
	protected String country;
	
	@XmlAttribute(name = "email")
	protected String email;
	
	@XmlAttribute(name = "phone")
	protected String phone;
	
	@XmlAttribute(name = "state")
	protected String state;
	
	@XmlAttribute(name = "zip")
	protected String zip;
	
	@XmlAttribute(name = "instructions")
	protected String instructions;

}
