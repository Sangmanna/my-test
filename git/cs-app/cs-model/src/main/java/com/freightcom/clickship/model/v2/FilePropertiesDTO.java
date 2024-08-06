package com.freightcom.clickship.model.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("unused")
public class FilePropertiesDTO {

  @JsonProperty("file_name")
  private String fileName;

  @JsonProperty("upload_id")
  private String uploadId;
  private FreightcomDateDTO date;
  private String url;
}
