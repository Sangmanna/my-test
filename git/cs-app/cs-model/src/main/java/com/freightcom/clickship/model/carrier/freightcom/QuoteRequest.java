package com.freightcom.clickship.model.carrier.freightcom;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyAttribute;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
public class QuoteRequest implements Serializable {

	private static final long serialVersionUID = 1645421658752828149L;

	@XmlAttribute(name = "insuranceType")
	private String insuranceType;

	@XmlAttribute(name = "isSaturdayService")
	private String isSaturdayService;

	@XmlAttribute(name = "residentialDelivery")
	private String residentialDelivery;

	@XmlAttribute(name = "orderSource")
	private String orderSource;

	@XmlAttribute(name = "saturdayPickupRequired")
	private String saturdayPickupRequired;

	@XmlAttribute(name = "signatureRequired")
	private String signatureRequired;
	
	// Attribute for Pallet
/*	@XmlAttribute(name = "insidePickup")
	private String insidePickup;
	
	@XmlAttribute(name = "insideDelivery")
	private String insideDelivery;
	
	@XmlAttribute(name = "limitedAccess")
	private String limitedAccess;
	
	@XmlAttribute(name = "deliveryAppointment")
	private String deliveryAppointment;
	
	@XmlAttribute(name = "homelandSecurity")
	private String homelandSecurity;
	
	@XmlAttribute(name = "crossBorderFee")
	private String crossBorderFee;
	
	@XmlAttribute(name = "militaryBaseDelivery")
	private String militaryBaseDelivery;
	
	@XmlAttribute(name = "dangerousGoodsType")
	private String dangerousGoodsType;
	
	@XmlAttribute(name = "stackable")
	private String stackable;*/

	@XmlElement(name = "From")
	private FromAddress fromAddress;

	@XmlElement(name = "To")
	private ToAddress toAddress;

	@XmlElement(name = "Packages")
	private Packages packages;
	
	@XmlAnyAttribute
	private Map<String, String> map = new HashMap<>();

	public String getInsuranceType() {
		return insuranceType;
	}

	public QuoteRequest setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
		return this;
	}

	public String getIsSaturdayService() {
		return isSaturdayService;
	}

	public QuoteRequest setIsSaturdayService(String isSaturdayService) {
		this.isSaturdayService = isSaturdayService;
		return this;
	}

	public String getResidentialDelivery() {
		return residentialDelivery;
	}

	public QuoteRequest setResidentialDelivery(String residentialDelivery) {
		this.residentialDelivery = residentialDelivery;
		return this;
	}

	public String getOrderSource() {
		return orderSource;
	}

	public QuoteRequest setOrderSource(String orderSource) {
		this.orderSource = orderSource;
		return this;
	}

	public String getSaturdayPickupRequired() {
		return saturdayPickupRequired;
	}

	public QuoteRequest setSaturdayPickupRequired(String saturdayPickupRequired) {
		this.saturdayPickupRequired = saturdayPickupRequired;
		return this;
	}

	public String getSignatureRequired() {
		return signatureRequired;
	}

	public QuoteRequest setSignatureRequired(String signatureRequired) {
		this.signatureRequired = signatureRequired;
		return this;
	}

/*	public String getInsidePickup() {
		return insidePickup;
	}

	public QuoteRequest setInsidePickup(String insidePickup) {
		this.insidePickup = insidePickup;
		return this;
	}

	public String getInsideDelivery() {
		return insideDelivery;
	}

	public QuoteRequest setInsideDelivery(String insideDelivery) {
		this.insideDelivery = insideDelivery;
		return this;
	}

	public String getLimitedAccess() {
		return limitedAccess;
	}

	public QuoteRequest setLimitedAccess(String limitedAccess) {
		this.limitedAccess = limitedAccess;
		return this;
	}

	public String getDeliveryAppointment() {
		return deliveryAppointment;
	}

	public QuoteRequest setDeliveryAppointment(String deliveryAppointment) {
		this.deliveryAppointment = deliveryAppointment;
		return this;
	}

	public String getHomelandSecurity() {
		return homelandSecurity;
	}

	public QuoteRequest setHomelandSecurity(String homelandSecurity) {
		this.homelandSecurity = homelandSecurity;
		return this;
	}

	public String getCrossBorderFee() {
		return crossBorderFee;
	}

	public QuoteRequest setCrossBorderFee(String crossBorderFee) {
		this.crossBorderFee = crossBorderFee;
		return this;
	}
	
	public String getStackable() {
		return stackable;
	}

	public QuoteRequest setStackable(String stackable) {
		this.stackable = stackable;
		return this;
	}

	public String getMilitaryBaseDelivery() {
		return militaryBaseDelivery;
	}

	public QuoteRequest setMilitaryBaseDelivery(String militaryBaseDelivery) {
		this.militaryBaseDelivery = militaryBaseDelivery;
		return this;
	}

	public String getDangerousGoodsType() {
		return dangerousGoodsType;
	}

	public QuoteRequest setDangerousGoodsType(String dangerousGoodsType) {
		this.dangerousGoodsType = dangerousGoodsType;
		return this;
	} */

	public FromAddress getFromAddress() {
		return fromAddress;
	}

	public QuoteRequest setFromAddress(FromAddress fromAddress) {
		this.fromAddress = fromAddress;
		return this;
	}

	public ToAddress getToAddress() {
		return toAddress;
	}

	public QuoteRequest setToAddress(ToAddress toAddress) {
		this.toAddress = toAddress;
		return this;
	}

	public Packages getPackages() {
		return packages;
	}

	public QuoteRequest setPackages(Packages packages) {
		this.packages = packages;
		return this;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

}
