package com.freightcom.clickship.model.mandrill;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class MailChimpRequest implements Serializable {
	
	private static final long serialVersionUID = -960355009605837088L;
	
	private MailContent sendMail = null;
	private AddToList addToList = null;
	
	public MailContent getSendMail() {
		return sendMail;
	}
	
	public void setSendMail(MailContent sendMail) {
		this.sendMail = sendMail;
	}
	
	public AddToList getAddToList() {
		return addToList;
	}
	
	public void setAddToList(AddToList addToList) {
		this.addToList = addToList;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}