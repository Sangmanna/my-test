package com.freightcom.clickship.model.v2;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrackingEventsResponse {
	@JsonProperty("events")
	List<TrackingEvent> events;

	public List<TrackingEvent> getEvents() {
		return events;
	}

	public void setEvents(List<TrackingEvent> events) {
		this.events = events;
	}
}