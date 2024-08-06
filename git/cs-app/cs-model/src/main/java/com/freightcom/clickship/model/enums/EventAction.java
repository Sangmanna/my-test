package com.freightcom.clickship.model.enums;

public enum EventAction {
	BEFORE(0), THEN(1), AFTER(2);

	private final int value;

	EventAction(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}
}
