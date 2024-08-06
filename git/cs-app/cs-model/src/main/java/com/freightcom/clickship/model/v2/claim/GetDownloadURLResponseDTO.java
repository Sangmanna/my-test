package com.freightcom.clickship.model.v2.claim;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.freightcom.clickship.model.CommonDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@SuppressWarnings("unused")
@EqualsAndHashCode(callSuper=false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetDownloadURLResponseDTO extends CommonDTO {
  private String url;
}
