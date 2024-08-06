package com.freightcom.clickship.model.carrier.freightcom;

import java.io.Serializable;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "QuoteReply")
@XmlAccessorType(XmlAccessType.FIELD)
public class QuoteReply implements Serializable {

	private static final long serialVersionUID = -4874654813543871678L;

	@XmlElement(name= "Quote")
	private List<QuoteReply.Quote> quoteList;
	
	@XmlElement(name= "CarrierErrorMessage")
	private QuoteReply.CarrierErrorMessage carrierErrorMessage;
	
	public List<QuoteReply.Quote> getQuoteList() {
		return quoteList;
	}

	public QuoteReply setQuoteList(List<QuoteReply.Quote> quoteList) {
		this.quoteList = quoteList;
		return this;
	}

	public QuoteReply.CarrierErrorMessage getCarrierErrorMessage() {
		return carrierErrorMessage;
	}

	public QuoteReply setCarrierErrorMessage(QuoteReply.CarrierErrorMessage carrierErrorMessage) {
		this.carrierErrorMessage = carrierErrorMessage;
		return this;
	}
	
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        
    })
	public static class Quote {
    	@XmlAttribute(name = "carrierId")
    	private String carrierId;
    	
    	@XmlAttribute(name = "carrierName")
    	private String carrierName;
    	
    	@XmlAttribute(name = "serviceId")
    	private String serviceId;
    	
    	@XmlAttribute(name = "serviceName")
    	private String serviceName;
    	
    	@XmlAttribute(name = "modeTransport")
    	private String modeTransport;

    	@XmlAttribute(name = "transitDays")
    	private int transitDays;
    	
    	@XmlAttribute(name = "currency")
    	private String currency;
    	
    	@XmlAttribute(name = "baseCharge")
    	private double baseCharge;
    	
    	@XmlAttribute(name = "fuelSurcharge")
    	private double fuelSurcharge;
    	
    	@XmlAttribute(name = "totalCharge")
    	private double totalCharge;
    	
    	@XmlAttribute(name = "cubedWeight")
    	private double cubedWeight;
    	
    	@XmlElement(name= "Surcharge")
    	private List<Quote.Surcharge> surchargeList;

    	public String getCarrierId() {
    		return carrierId;
    	}

    	public Quote setCarrierId(String carrierId) {
    		this.carrierId = carrierId;
    		return this;
    	}

    	public String getCarrierName() {
    		return carrierName;
    	}

    	public Quote setCarrierName(String carrierName) {
    		this.carrierName = carrierName;
    		return this;
    	}

    	public String getServiceId() {
    		return serviceId;
    	}

    	public Quote setServiceId(String serviceId) {
    		this.serviceId = serviceId;
    		return this;
    	}

    	public String getServiceName() {
    		return serviceName;
    	}

    	public Quote setServiceName(String serviceName) {
    		this.serviceName = serviceName;
    		return this;
    	}

    	public String getModeTransport() {
    		return modeTransport;
    	}

    	public Quote setModeTransport(String modeTransport) {
    		this.modeTransport = modeTransport;
    		return this;
    	}

    	public int getTransitDays() {
    		return transitDays;
    	}

    	public Quote setTransitDays(int transitDays) {
    		this.transitDays = transitDays;
    		return this;
    	}

    	public String getCurrency() {
    		return currency;
    	}

    	public Quote setCurrency(String currency) {
    		this.currency = currency;
    		return this;
    	}

    	public double getBaseCharge() {
    		return baseCharge;
    	}

    	public Quote setBaseCharge(double baseCharge) {
    		this.baseCharge = baseCharge;
    		return this;
    	}

    	public double getFuelSurcharge() {
    		return fuelSurcharge;
    	}

    	public Quote setFuelSurcharge(double fuelSurcharge) {
    		this.fuelSurcharge = fuelSurcharge;
    		return this;
    	}

    	public double getTotalCharge() {
    		return totalCharge;
    	}

    	public Quote setTotalCharge(double totalCharge) {
    		this.totalCharge = totalCharge;
    		return this;
    	}

    	public double getCubedWeight() {
    		return cubedWeight;
    	}

    	public Quote setCubedWeight(double cubedWeight) {
    		this.cubedWeight = cubedWeight;
    		return this;
    	}

    	public List<Quote.Surcharge> getSurchargeList() {
    		return surchargeList;
    	}

    	public Quote setSurchargeList(List<Quote.Surcharge> surchargeList) {
    		this.surchargeList = surchargeList;
    		return this;
    	}

    	@Override
    	public String toString() {
    		return "Quote [carrierId=" + carrierId + ", carrierName=" + carrierName + ", serviceId=" + serviceId
    				+ ", serviceName=" + serviceName + ", modeTransport=" + modeTransport + ", transitDays=" + transitDays
    				+ ", currency=" + currency + ", baseCharge=" + baseCharge + ", fuelSurcharge=" + fuelSurcharge
    				+ ", totalCharge=" + totalCharge + ", cubedWeight=" + cubedWeight + ", surchargeList=" + surchargeList
    				+ "]";
    	}
    	
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "id", "name", "amount"
        })
    	public static class Surcharge {
    		
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
    }
    
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "errorMessage0", "errorMessage1", "size"
    })
	public static class CarrierErrorMessage {
    	@XmlAttribute(name = "size")
    	private int size;
    	
    	@XmlAttribute(name = "errorMessage0")
    	private String errorMessage0;
    	
    	@XmlAttribute(name = "errorMessage1")
    	private String errorMessage1;

    	public int getSize() {
    		return size;
    	}

    	public CarrierErrorMessage setSize(int size) {
    		this.size = size;
    		return this;
    	}

    	public String getErrorMessage0() {
    		return errorMessage0;
    	}

    	public CarrierErrorMessage setErrorMessage0(String errorMessage0) {
    		this.errorMessage0 = errorMessage0;
    		return this;
    	}

    	public String getErrorMessage1() {
    		return errorMessage1;
    	}

    	public CarrierErrorMessage setErrorMessage1(String errorMessage1) {
    		this.errorMessage1 = errorMessage1;
    		return this;
    	}
    }
	
}
