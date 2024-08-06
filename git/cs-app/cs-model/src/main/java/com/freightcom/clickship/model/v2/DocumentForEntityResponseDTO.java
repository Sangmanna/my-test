package com.freightcom.clickship.model.v2;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.freightcom.clickship.model.CommonDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DocumentForEntityResponseDTO extends CommonDTO {
  List<Document> documents;
  String url; // for get invoice for claim

  @Data
  @NoArgsConstructor
  @EqualsAndHashCode(callSuper = false)
  public static class Document extends CommonDTO {
    String id;
    String type;
    String url;

    @JsonProperty("file_name")
    String fileName;

    @JsonProperty("uploaded_at")
    String uploadedAt;

    @JsonProperty("uploaded_by")
    EntityIdDTO uploadedBy;
  }
}
