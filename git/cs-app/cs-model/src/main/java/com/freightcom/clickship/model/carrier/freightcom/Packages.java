package com.freightcom.clickship.model.carrier.freightcom;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
public class Packages {

	@XmlAttribute(name = "type")
	private String type;
	
	@XmlElement(name= "Package")
	private List<Package> fcPackage = new ArrayList<>();

	public String getType() {
		return type;
	}

	public Packages setType(String type) {
		this.type = type;
		return this;
	}

	public List<Package> getFcPackage() {
		return fcPackage;
	}

	public Packages setFcPackage(List<Package> fcPackage) {
		this.fcPackage = fcPackage;
		return this;
	}
	
	public void addPackage(Package pack) {
		fcPackage.add(pack);
	}
	
}
