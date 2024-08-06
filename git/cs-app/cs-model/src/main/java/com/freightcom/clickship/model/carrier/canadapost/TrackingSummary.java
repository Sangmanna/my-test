package com.freightcom.clickship.model.carrier.canadapost;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="tracking-summary")
public class TrackingSummary {
	
    private String xmlns;
	
	private PinSummary pinSummary;

	@XmlAttribute(name = "xmlns")
	public String getXmlns() {
		return xmlns;
	}

	public void setXmlns(String xmlns) {
		this.xmlns = xmlns;
	}

	@XmlElement(name = "pin-summary")
	public PinSummary getPinSummary() {
		return pinSummary;
	}

	public void setPinSummary(PinSummary pinSummary) {
		this.pinSummary = pinSummary;
	}
	
}
