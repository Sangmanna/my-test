package com.freightcom.clickship.model.carrier.ups.trackingDetail;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpsShipment implements Serializable {
	
	private static final long serialVersionUID = 6123110033432558591L;
    	
    @JsonProperty("package")
    private List<UpsPackage> upsPackage;

	public List<UpsPackage> getUpsPackage() {
		return upsPackage;
	}

	public void setUpsPackage(List<UpsPackage> upsPackage) {
		this.upsPackage = upsPackage;
	}
}
