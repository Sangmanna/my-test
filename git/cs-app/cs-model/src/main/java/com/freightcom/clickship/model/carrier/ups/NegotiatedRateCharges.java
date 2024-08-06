
package com.freightcom.clickship.model.carrier.ups;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NegotiatedRateCharges implements Serializable {

	private static final long serialVersionUID = -7711988913104962442L;
	
	@JsonProperty("TotalCharge")
	private UpsMoney totalCharge;
	
	public UpsMoney getTotalCharge() {
		return totalCharge;
	}

	public void setTotalCharge(UpsMoney totalCharge) {
		this.totalCharge = totalCharge;
	}

}
