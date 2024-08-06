package com.freightcom.clickship.model.order;

import java.io.Serializable;

public class TimeDTO implements Serializable {
	private static final long serialVersionUID = 633841610704228111L;
	
	private int hour;
    private int minute;

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}