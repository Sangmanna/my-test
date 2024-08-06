package com.freightcom.clickship.model.v2;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.freightcom.clickship.model.CommonDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SendDocumentEmailRequestDTO extends CommonDTO {
	
	@JsonProperty("document_entity_id")
	private EntityIdDTO documentEntityId;

	@JsonProperty("email_addresses")
	private List<String> emailAddresses;

	public EntityIdDTO getDocumentEntityId() {
		return documentEntityId;
	}

	public SendDocumentEmailRequestDTO setDocumentEntityId(EntityIdDTO documentEntityId) {
		this.documentEntityId = documentEntityId;
		return this;
	}

	public List<String> getEmailAddresses() {
		return emailAddresses;
	}

	public SendDocumentEmailRequestDTO setEmailAddresses(List<String> emailAddresses) {
		this.emailAddresses = emailAddresses;
		return this;
	}

}
