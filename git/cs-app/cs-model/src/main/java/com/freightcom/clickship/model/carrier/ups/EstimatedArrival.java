
package com.freightcom.clickship.model.carrier.ups;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
	"Pickup",
	"Arrival",
	"DayOfWeek",
	"TotalTransitDays",
	"CustomerCenterCutoff",
    "BusinessDaysInTransit"
})
public class EstimatedArrival implements Serializable {

	private static final long serialVersionUID = -1084124586552424775L;

	@JsonProperty("Arrival")
	private DateTime arrival;
	
	@JsonProperty("BusinessDaysInTransit")
	private String businessDaysInTransit;
	
	@JsonProperty("Pickup")
	private DateTime pickup;
	
	@JsonProperty("DayOfWeek")
	private String dayOfWeek;
	
	@JsonProperty("CustomerCenterCutoff")
	private String customerCenterCutoff;
	
	@JsonProperty("RestDays")
	private String restDays;
	
	@JsonProperty("TotalTransitDays")
	private String totalTransitDays;

	public DateTime getPickup() {
		return pickup;
	}

	public EstimatedArrival setPickup(DateTime pickup) {
		this.pickup = pickup;
		return this;
	}

	public DateTime getArrival() {
		return arrival;
	}

	public EstimatedArrival setArrival(DateTime arrival) {
		this.arrival = arrival;
		return this;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public EstimatedArrival setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
		return this;
	}

	public String getTotalTransitDays() {
		return totalTransitDays;
	}

	public EstimatedArrival setTotalTransitDays(String totalTransitDays) {
		this.totalTransitDays = totalTransitDays;
		return this;
	}

	public String getCustomerCenterCutoff() {
		return customerCenterCutoff;
	}

	public EstimatedArrival setCustomerCenterCutoff(String customerCenterCutoff) {
		this.customerCenterCutoff = customerCenterCutoff;
		return this;
	}

	public String getBusinessDaysInTransit() {
		return businessDaysInTransit;
	}

	public EstimatedArrival setBusinessDaysInTransit(String businessDaysInTransit) {
		this.businessDaysInTransit = businessDaysInTransit;
		return this;
	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	@JsonPropertyOrder({ "Date", "Time" })
	public static class DateTime {

		@JsonProperty("Date")
		private String date;
		
		@JsonProperty("Time")
		private String time;
		
	    @JsonIgnore
	    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

		public String getDate() {
			return date;
		}

		public DateTime setDate(String date) {
			this.date = date;
			return this;
		}

		public String getTime() {
			return time;
		}

		public DateTime setTime(String time) {
			this.time = time;
			return this;
		}
		
	    @JsonAnyGetter
	    public Map<String, Object> getAdditionalProperties() {
	        return this.additionalProperties;
	    }

	    @JsonAnySetter
	    public DateTime setAdditionalProperty(String name, Object value) {
	        this.additionalProperties.put(name, value);
	        return this;
	    }
	}
}
