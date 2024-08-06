package com.freightcom.clickship.model.mandrill;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class AddToList implements Serializable{
	private static final long serialVersionUID = 4217814537599242575L;
	
	private String email;
	private String firstname;
	private String lastname;
	private String listId;
	
	public AddToList() {	
	}

	public AddToList(String email, String firstname, String lastname, String listId) {
		super();
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.listId = listId;
	}

	public String getEmail() {
		return email;
	}
	
	public AddToList setEmail(String email) {
		this.email = email;
		return this;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public AddToList setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public AddToList setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}
	
	public String getListId() {
		return listId;
	}
	
	public AddToList setListId(String listId) {
		this.listId = listId;
		return this;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}