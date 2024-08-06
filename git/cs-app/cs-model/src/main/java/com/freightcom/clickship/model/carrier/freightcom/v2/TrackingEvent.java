package com.freightcom.clickship.model.carrier.freightcom.v2;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrackingEvent {

	@JsonProperty("Data")
	private String data;

	@JsonProperty("Message")
	private String message;

	@JsonProperty("Type")
	private String type;

	@JsonProperty("When")
	private Date when;

	@JsonProperty("Where")
	private FCAddress where;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getWhen() {
		return when;
	}

	public void setWhen(Date when) {
		this.when = when;
	}

	public FCAddress getWhere() {
		return where;
	}

	public void setWhere(FCAddress where) {
		this.where = where;
	}

}
