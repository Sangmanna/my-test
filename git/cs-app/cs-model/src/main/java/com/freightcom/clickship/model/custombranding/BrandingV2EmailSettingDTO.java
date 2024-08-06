package com.freightcom.clickship.model.custombranding;

import java.io.Serializable;
import java.util.Date;

import com.freightcom.clickship.model.CommonDTO;

public class BrandingV2EmailSettingDTO extends CommonDTO implements Serializable {
	
	private static final long serialVersionUID = -1341406724908726325L;
	
	private String id;
	
	private boolean enabled;
	
	private String previewText;
	
	private String subjectLine;
	
	private String templateName;
	
	private String templateCode;

	private String emailMessage;
	
	private Date updateDatetime;
	
	private boolean preDefinedTemplate;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Date getUpdateDatetime() {
		return updateDatetime;
	}

	public void setUpdateDatetime(Date updateDatetime) {
		this.updateDatetime = updateDatetime;
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
}
