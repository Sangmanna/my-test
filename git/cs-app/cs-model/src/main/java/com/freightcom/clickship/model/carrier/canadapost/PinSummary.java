package com.freightcom.clickship.model.carrier.canadapost;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="pin-summary")
public class PinSummary {

	private String pin;
	
	private String eventDescription;

	@XmlElement(name = "pin")
	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	@XmlElement(name = "event-description")
	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	
}
