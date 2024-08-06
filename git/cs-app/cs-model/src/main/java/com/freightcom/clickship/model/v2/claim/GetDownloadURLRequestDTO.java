package com.freightcom.clickship.model.v2.claim;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.freightcom.clickship.model.CommonDTO;
import com.freightcom.clickship.model.v2.EntityIdDTO;
import com.freightcom.clickship.model.v2.FilePropertiesDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetDownloadURLRequestDTO extends CommonDTO {

	@JsonProperty("document_entity_id")
	private EntityIdDTO documentEntityId;

	@JsonProperty("document_sub_entity_id")
	private EntityIdDTO documentSubEntityId;

	@JsonProperty("upload_properties")
	private FilePropertiesDTO uploadProperties;

	@JsonProperty("document_type")
	private String document_type;

	public EntityIdDTO getDocumentEntityId() {
		return documentEntityId;
	}

	public void setDocumentEntityId(EntityIdDTO documentEntityId) {
		this.documentEntityId = documentEntityId;
	}

	public EntityIdDTO getDocumentSubEntityId() {
		return documentSubEntityId;
	}

	public void setDocumentSubEntityId(EntityIdDTO documentSubEntityId) {
		this.documentSubEntityId = documentSubEntityId;
	}

	public FilePropertiesDTO getUploadProperties() {
		return uploadProperties;
	}

	public void setUploadProperties(FilePropertiesDTO uploadProperties) {
		this.uploadProperties = uploadProperties;
	}

	public String getDocument_type() {
		return document_type;
	}

	public void setDocument_type(String document_type) {
		this.document_type = document_type;
	}

}
