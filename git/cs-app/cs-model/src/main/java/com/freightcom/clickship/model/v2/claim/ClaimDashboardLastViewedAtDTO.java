package com.freightcom.clickship.model.v2.claim;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.freightcom.clickship.model.CommonDTO;
import com.freightcom.clickship.model.util.DateDeserializer;
import com.freightcom.clickship.model.v2.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@SuppressWarnings("unused")
@EqualsAndHashCode(callSuper=false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClaimDashboardLastViewedAtDTO extends CommonDTO {
  private Result result = new Result();

  @Data
  public class Result {
    @JsonProperty("has_viewed_before")
    private boolean hasViewedBefore;

    @JsonProperty("last_viewed_at")
    @JsonDeserialize(using = DateDeserializer.class)
    private Date lastViewedAt;
  }
}
