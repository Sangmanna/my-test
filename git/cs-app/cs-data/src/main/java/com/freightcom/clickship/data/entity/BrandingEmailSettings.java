package com.freightcom.clickship.data.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.freightcom.clickship.data.entity.common.BaseEntity;

/**
 * Entity class for Custom Branding - Email tab's attributes
 * 
 * @author sangmann
 */
@Entity
@Table(name = "branding_email_settings")
public class BrandingEmailSettings extends BaseEntity {

	private static final long serialVersionUID = -22814086018995982L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "branding_id", nullable = false, updatable = false)
	private Branding branding;
	
	@Column(name = "template_name")
	private String templateName;
	
	@Column(name = "template_code")
	private String templateCode;

	@Column(name = "subject_line")
	private String subjectLine;

	@Column(name = "preview_text")
	private String previewText;

	@Column(name = "email_message")
	private String emailMessage;
	
	@Column(name = "pre_defined_template")
	private boolean preDefinedTemplate;
	
	@Column(name = "enabled")
	private boolean enabled;

	public Branding getBranding() {
		return branding;
	}

	public void setBranding(Branding branding) {
		this.branding = branding;
	}
	
	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public boolean isPreDefinedTemplate() {
		return preDefinedTemplate;
	}

	public void setPreDefinedTemplate(boolean preDefinedTemplate) {
		this.preDefinedTemplate = preDefinedTemplate;
	}

	public String getSubjectLine() {
		return subjectLine;
	}

	public void setSubjectLine(String subjectLine) {
		this.subjectLine = subjectLine;
	}

	public String getPreviewText() {
		return previewText;
	}

	public void setPreviewText(String previewText) {
		this.previewText = previewText;
	}

	public String getEmailMessage() {
		return emailMessage;
	}

	public void setEmailMessage(String emailMessage) {
		this.emailMessage = emailMessage;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getTemplateCode() {
		return templateCode;
	}

	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public BaseEntity setId(String id) {
		this.id = id;
		return this;
	}
}
