package com.freightcom.clickship.model.mandrill;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.freightcom.clickship.model.KeyValue;

public class MailContent implements Serializable {

	private static final long serialVersionUID = 5919104881265410807L;
	
	private boolean dynamicContent = false;
	
	private String subject;
	private MailRecipient from;
	private List<MailRecipient> to;
	private String body = null;
	private String template = null;
	private List<KeyValue> templateValues = null;
	private List<MailAttachment> attachments;
	
	public MailContent() {
		to = new ArrayList<>();
	}
	
	public boolean isDynamicContent() {
		return dynamicContent;
	}

	public MailContent setDynamicContent(boolean dynamicContent) {
		this.dynamicContent = dynamicContent;
		return this;
	}

	public String getBody() {
		return body;
	}
	
	public MailContent setBody(String body) {
		this.body = body;
		return this;
	}
	
	public MailRecipient getFrom() {
		return from;
	}
	
	public MailContent setFrom(MailRecipient from) {
		this.from = from;
		return this;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public MailContent setSubject(String subject) {
		this.subject = subject;
		return this;
	}
	
	public List<MailRecipient> getTo() {
		return to;
	}
	
	public MailContent setTo(List<MailRecipient> to) {
		this.to = to;
		return this;
	}
	
	public MailContent addToRecipient(String email) {
		to.add(new MailRecipient(email));
		return this;
	}
	
	public MailContent addToRecipient(String[] emails) {
		for(String email : emails) {
			addToRecipient(email);	
		}
		
		return this;
	}
	
	public List<KeyValue> getTemplateValues() {
		return templateValues;
	}
	
	public MailContent setTemplateValues(List<KeyValue> templateValues) {
		this.templateValues = templateValues;
		return this;
	}
	
	public MailContent addTemplateValue(String key, Object value) {
		if(templateValues == null) {
			templateValues = new ArrayList<>();
		}
		
		templateValues.add(new KeyValue(key, value));
		return this;
	}
	
	public String getTemplate() {
		return template;
	}
	
	public MailContent setTemplate(String template) {
		this.template = template;
		return this;
	}

	public List<MailAttachment> getAttachments() {
		return attachments;
	}

	public MailContent setAttachments(List<MailAttachment> attachments) {
		if(attachments != null) {
			this.attachments = attachments;
		}
		
		return this;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
