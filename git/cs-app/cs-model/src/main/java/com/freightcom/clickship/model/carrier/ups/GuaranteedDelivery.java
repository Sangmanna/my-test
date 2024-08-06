
package com.freightcom.clickship.model.carrier.ups;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GuaranteedDelivery implements Serializable {

	private static final long serialVersionUID = 6704615343242370055L;

	@JsonProperty("DeliveryByTime")
	private String deliveryByTime;
	
	@JsonProperty("BusinessDaysInTransit")
	private String businessDaysInTransit;

	public String getBusinessDaysInTransit() {
		return businessDaysInTransit;
	}

	public void setBusinessDaysInTransit(String businessDaysInTransit) {
		this.businessDaysInTransit = businessDaysInTransit;
	}

	public String getDeliveryByTime() {
		return deliveryByTime;
	}

	public void setDeliveryByTime(String deliveryByTime) {
		this.deliveryByTime = deliveryByTime;
	}

}
