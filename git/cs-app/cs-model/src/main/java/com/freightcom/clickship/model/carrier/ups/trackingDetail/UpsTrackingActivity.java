
package com.freightcom.clickship.model.carrier.ups.trackingDetail;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpsTrackingActivity implements Serializable {
	
	private static final long serialVersionUID = 3888415571861351539L;

	@JsonProperty("date")
	private String date;
	
	@JsonProperty("time")
	private String time;
	
	@JsonProperty("status")
	private Status status;
	
	@JsonProperty("location")
	private UpsTrackingLocation location;

	public String getDate() {
		return date;
	}

	public UpsTrackingActivity setDate(String date) {
		this.date = date;
		return this;
	}

	public Status getStatus() {
		return status;
	}

	public UpsTrackingActivity setStatus(Status status) {
		this.status = status;
		return this;
	}

	public String getTime() {
		return time;
	}

	public UpsTrackingActivity setTime(String time) {
		this.time = time;
		return this;
	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Status {
		
	    @JsonProperty("code")
	    private String code;
	    
	    @JsonProperty("description")
	    private String description;
	    
	    @JsonProperty("type")
	    private String type;

		public String getCode() {
			return code;
		}

		public Status setCode(String code) {
			this.code = code;
			return this;
		}

		public String getDescription() {
			return description;
		}

		public Status setDescription(String description) {
			this.description = description;
			return this;
		}

		public String getType() {
			return type;
		}

		public Status setType(String type) {
			this.type = type;
			return this;
		}
		
	}

	public UpsTrackingLocation getLocation() {
		return location;
	}

	public void setLocation(UpsTrackingLocation location) {
		this.location = location;
	}

	
}
