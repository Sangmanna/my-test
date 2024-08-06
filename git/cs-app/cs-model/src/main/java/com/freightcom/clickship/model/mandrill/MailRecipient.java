package com.freightcom.clickship.model.mandrill;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class MailRecipient implements Serializable {
	
	private static final long serialVersionUID = -1566173443424933949L;
	
	private String email;
	private String name;
	
	public MailRecipient() {
	}
	
	public MailRecipient(String email, String name) {
		super();
		this.email = email;
		this.name = name;
	}
	
	public MailRecipient(String email) {
		super();
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public MailRecipient setEmail(String email) {
		this.email = email;
		return this;
	}
	
	public String getName() {
		return name;
	}
	
	public MailRecipient setName(String name) {
		this.name = name;
		return this;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}