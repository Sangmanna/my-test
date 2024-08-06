
package com.freightcom.clickship.model.carrier.ups;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ "Service", "GuaranteedIndicator", "EstimatedArrival" })
public class ServiceSummary implements Serializable {
	
	private static final long serialVersionUID = 4634679925360715114L;

	@JsonProperty("Service")
    private CodeDescription service;
	
	@JsonProperty("GuaranteedIndicator")
    private String guaranteedIndicator;
	
    @JsonProperty("EstimatedArrival")
    private EstimatedArrival estimatedArrival;
    
	@JsonProperty("SaturdayDelivery")
    private String saturdayDelivery;

    public CodeDescription getService() {
        return service;
    }

    public ServiceSummary setService(CodeDescription service) {
        this.service = service;
        return this;
    }

    public String getGuaranteedIndicator() {
        return guaranteedIndicator;
    }

    public ServiceSummary setGuaranteedIndicator(String guaranteedIndicator) {
        this.guaranteedIndicator = guaranteedIndicator;
        return this;
    }

    public EstimatedArrival getEstimatedArrival() {
        return estimatedArrival;
    }
    
    public ServiceSummary setEstimatedArrival(EstimatedArrival estimatedArrival) {
        this.estimatedArrival = estimatedArrival;
        return this;
    }

	public String getSaturdayDelivery() {
		return saturdayDelivery;
	}

	public ServiceSummary setSaturdayDelivery(String saturdayDelivery) {
		this.saturdayDelivery = saturdayDelivery;
		return this;
	}

}
