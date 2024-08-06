package com.freightcom.clickship.model.v2.claim;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.freightcom.clickship.model.CommonDTO;
import com.freightcom.clickship.model.v2.FilePropertiesDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetUploadURLResponseDTO extends CommonDTO {
  @JsonProperty("upload_properties")
  private FilePropertiesDTO uploadProperties;
}
