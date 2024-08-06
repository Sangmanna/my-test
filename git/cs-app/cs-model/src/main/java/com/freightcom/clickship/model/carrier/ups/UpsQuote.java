
package com.freightcom.clickship.model.carrier.ups;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpsQuote implements Serializable {

	private static final long serialVersionUID = 4423173408137473857L;

	@JsonProperty("Service")
    private CodeDescription service;
    
    @JsonProperty("RatedShipmentAlert")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<CodeDescription> ratedShipmentAlert;
    
    @JsonProperty("BillingWeight")
    private UpsWeight weight;

    @JsonProperty("TransportationCharges")
    private UpsMoney transportationCharges;

    @JsonProperty("ServiceOptionsCharges")
    private UpsMoney serviceOptionsCharges;
    
    @JsonProperty("TotalCharges")
    private UpsMoney totalCharges;
    
    @JsonProperty("NegotiatedRateCharges")
    private NegotiatedRateCharges negotiatedRateCharges;
    
    @JsonProperty("GuaranteedDelivery")
    private GuaranteedDelivery guaranteedDelivery;
    
    @JsonProperty("RatedPackage")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<UpsWeight> pacakgeWeight;
    
    @JsonProperty("TimeInTransit")
    private TransitResponse timeInTransit;

	public CodeDescription getService() {
		return service;
	}

	public void setService(CodeDescription service) {
		this.service = service;
	}

	public List<CodeDescription> getRatedShipmentAlert() {
		return ratedShipmentAlert;
	}

	public void setRatedShipmentAlert(List<CodeDescription> ratedShipmentAlert) {
		this.ratedShipmentAlert = ratedShipmentAlert;
	}

	public UpsWeight getWeight() {
		return weight;
	}

	public void setWeight(UpsWeight weight) {
		this.weight = weight;
	}

	public UpsMoney getTransportationCharges() {
		return transportationCharges;
	}

	public void setTransportationCharges(UpsMoney transportationCharges) {
		this.transportationCharges = transportationCharges;
	}

	public UpsMoney getServiceOptionsCharges() {
		return serviceOptionsCharges;
	}

	public void setServiceOptionsCharges(UpsMoney serviceOptionsCharges) {
		this.serviceOptionsCharges = serviceOptionsCharges;
	}

	public UpsMoney getTotalCharges() {
		return totalCharges;
	}

	public void setTotalCharges(UpsMoney totalCharges) {
		this.totalCharges = totalCharges;
	}

	public NegotiatedRateCharges getNegotiatedRateCharges() {
		return negotiatedRateCharges;
	}

	public void setNegotiatedRateCharges(NegotiatedRateCharges negotiatedRateCharges) {
		this.negotiatedRateCharges = negotiatedRateCharges;
	}

	public List<UpsWeight> getPacakgeWeight() {
		return pacakgeWeight;
	}

	public void setPacakgeWeight(List<UpsWeight> pacakgeWeight) {
		this.pacakgeWeight = pacakgeWeight;
	}

	public GuaranteedDelivery getGuaranteedDelivery() {
		return guaranteedDelivery;
	}

	public void setGuaranteedDelivery(GuaranteedDelivery guaranteedDelivery) {
		this.guaranteedDelivery = guaranteedDelivery;
	}

	public TransitResponse getTimeInTransit() {
		return timeInTransit;
	}

	public void setTimeInTransit(TransitResponse timeInTransit) {
		this.timeInTransit = timeInTransit;
	}

}
