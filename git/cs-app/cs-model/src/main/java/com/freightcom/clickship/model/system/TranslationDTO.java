package com.freightcom.clickship.model.system;

import java.util.Date;

public class TranslationDTO {
	private String id;
	private String en;
	private String fr;
	private String url;
	private boolean verified = false;
	private Date updatedDatetime;
	private String updatedBy;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEn() {
		return en;
	}

	public void setEn(String en) {
		this.en = en;
	}

	public String getFr() {
		return fr;
	}

	public void setFr(String fr) {
		this.fr = fr;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public Date getUpdatedDatetime() {
		return updatedDatetime;
	}

	public void setUpdatedDatetime(Date updatedDatetime) {
		this.updatedDatetime = updatedDatetime;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
}
