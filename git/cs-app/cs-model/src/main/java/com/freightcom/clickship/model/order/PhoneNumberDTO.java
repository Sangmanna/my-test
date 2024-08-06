package com.freightcom.clickship.model.order;

import java.io.Serializable;

public class PhoneNumberDTO implements Serializable {
	private static final long serialVersionUID = -8361924246005909871L;
	
	private String number = null;
    private String extension = null;

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getExtension() {
        return extension;
    }
    public void setExtension(String extension) {
        this.extension = extension;
    }
}
