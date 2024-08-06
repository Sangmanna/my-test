package com.freightcom.clickship.model.carrier.freightcom;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyAttribute;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;

@XmlRootElement(namespace = "http://www.freightcom.net/XMLSchema", name = "Freightcom")
@XmlAccessorType(XmlAccessType.FIELD)
public class FCRateRequest extends FreightcomAuth implements Serializable {

	private static final long serialVersionUID = 4316633291858438982L;
	
	@XmlElement(name= "QuoteRequest", required = true)
	private FCRateRequest.QuoteRequest quoteRequest;

	public FCRateRequest() {
		super();
	}

	public FCRateRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public FCRateRequest.QuoteRequest getQuoteRequest() {
		return quoteRequest;
	}

	public void setQuoteRequest(FCRateRequest.QuoteRequest quoteRequest) {
		this.quoteRequest = quoteRequest;
	} 
	
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
	public static class QuoteRequest {
		
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
		
		@XmlElement(name = "From")
		private FromAddress fromAddress;

		@XmlElement(name = "To")
		private ToAddress toAddress;

		@XmlElement(name = "Packages")
		private Packages packages;
		
		@XmlAnyAttribute
		private Map<QName, String> map = new HashMap<>();

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

		public Map<QName, String> getMap() {
			return map;
		}

		public void setMap(Map<QName, String> map) {
			this.map = map;
		}
		
		public void addDynamicAttribute(String name, String value) {
			this.map.put(new QName(name) , value);
		}
	}	

}
