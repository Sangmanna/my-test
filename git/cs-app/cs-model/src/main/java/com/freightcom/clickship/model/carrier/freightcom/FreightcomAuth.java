package com.freightcom.clickship.model.carrier.freightcom;

import jakarta.xml.bind.annotation.XmlAttribute;

public abstract class FreightcomAuth extends Freightcom {

	@XmlAttribute
	protected String username;
	
	@XmlAttribute
	protected String password;

}
