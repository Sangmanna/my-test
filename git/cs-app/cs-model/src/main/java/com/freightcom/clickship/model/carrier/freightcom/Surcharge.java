	package com.freightcom.clickship.model.carrier.freightcom;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Surcharge")
@XmlAccessorType(XmlAccessType.FIELD)
public class Surcharge implements Serializable {

	private static final long serialVersionUID = 748812773543190085L;

	@XmlAttribute(name = "id")
	private String id;
	
	@XmlAttribute(name = "name")
	private String name;
	
	@XmlAttribute(name = "amount")
	private double amount;

	public String getId() {
		return id;
	}

	public Surcharge setId(String id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Surcharge setName(String name) {
		this.name = name;
		return this;
	}

	public double getAmount() {
		return amount;
	}

	public Surcharge setAmount(double amount) {
		this.amount = amount;
		return this;
	}

	@Override
	public String toString() {
		return "Surcharge [id=" + id + ", name=" + name + ", amount=" + amount + "]";
	}
	
}
