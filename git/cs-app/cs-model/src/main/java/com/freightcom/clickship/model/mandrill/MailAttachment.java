package com.freightcom.clickship.model.mandrill;

import java.io.Serializable;

public class MailAttachment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6736229968684626325L;

	private String type;
	private String name;
	private String content;

	public String getType() {
		return type;
	}

	public MailAttachment setType(String type) {
		this.type = type;
		return this;
	}

	public String getName() {
		return name;
	}

	public MailAttachment setName(String name) {
		this.name = name;
		return this;
	}

	public String getContent() {
		return content;
	}

	public MailAttachment setContent(String content) {
		this.content = content;
		return this;
	}

}
