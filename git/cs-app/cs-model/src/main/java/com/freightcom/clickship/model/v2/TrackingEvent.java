package com.freightcom.clickship.model.v2;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrackingEvent {
	@JsonProperty("type")
	String type;

	@JsonProperty("when")
	String when;
	
	@JsonProperty("where")
	List<TrackingEventWhere> where;
	
	@JsonProperty("message")
	String message;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getWhen() {
		return when;
	}

	public void setWhen(String when) {
		this.when = when;
	}

	public List<TrackingEventWhere> getWhere() {
		return where;
	}

	public void setWhere(List<TrackingEventWhere> where) {
		this.where = where;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}