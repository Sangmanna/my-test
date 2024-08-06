package com.freightcom.clickship.model.marketplace.amazon.verify;

import java.io.Serializable;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ListParticipations")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListParticipations implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="Participation")
	private List<Participation> participations;
	
	public ListParticipations() {
		super();
	}
	
	public ListParticipations(List<Participation> participations) {
		super();
		this.participations = participations;
	}

	public List<Participation> getParticipations() {
		return participations;
	}

	public void setParticipations(List<Participation> participations) {
		this.participations = participations;
	}
	
	
}
