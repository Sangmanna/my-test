package com.freightcom.clickship.model.marketplace.ebay;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EbayNotificationMetaData implements Serializable {

	private static final long serialVersionUID = 7762344800663104882L;

	private String topic;
	
	private String schemaVersion;
	
	private String deprecated;

	public String getTopic() {
		return topic;
	}

	public EbayNotificationMetaData setTopic(String topic) {
		this.topic = topic;
		return this;
	}

	public String getSchemaVersion() {
		return schemaVersion;
	}

	public EbayNotificationMetaData setSchemaVersion(String schemaVersion) {
		this.schemaVersion = schemaVersion;
		return this;
	}

	public String getDeprecated() {
		return deprecated;
	}

	public EbayNotificationMetaData setDeprecated(String deprecated) {
		this.deprecated = deprecated;
		return this;
	}
	
}

