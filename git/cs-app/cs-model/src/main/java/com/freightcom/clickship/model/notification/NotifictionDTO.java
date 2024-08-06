package com.freightcom.clickship.model.notification;

import java.io.Serializable;
import java.util.Date;

import com.freightcom.clickship.model.CommonDTO;

public class NotifictionDTO extends CommonDTO implements Serializable, Comparable<NotifictionDTO> {

	private static final long serialVersionUID = 6561360532101583769L;

	private String id;
	
	private String icon;
	
	private String alert;
	
	private Date createdDate;
	
	private String description;

	public String getId() {
		return id;
	}

	public NotifictionDTO setId(String id) {
		this.id = id;
		return this;
	}

	public String getIcon() {
		return icon;
	}

	public NotifictionDTO setIcon(String icon) {
		this.icon = icon;
		return this;
	}

	public String getAlert() {
		return alert;
	}

	public NotifictionDTO setAlert(String alert) {
		this.alert = alert;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public NotifictionDTO setDescription(String description) {
		this.description = description; 	
		return this;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public NotifictionDTO setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
		return this;
	}

	@Override
	public int compareTo(NotifictionDTO o) {
		return o.getCreatedDate().compareTo(getCreatedDate());
	}

}
