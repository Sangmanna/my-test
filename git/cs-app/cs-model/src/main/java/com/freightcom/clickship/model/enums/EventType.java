package com.freightcom.clickship.model.enums;

/**
 * Defines enum values equivalent to the event_type data in code table Used to
 * map InjectEvent annotation to event to be triggered
 * 
 * @author sangmann
 *
 */
public enum EventType {
	ONBOARDING_START(4), SIGNUP(5);

	private final int value;

	EventType(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}
}
