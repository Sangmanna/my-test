package com.freightcom.clickship.model.v2.claim;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
/**
 * Time of day in 24 hour time.
 */
@Data
public class TimeOfDay   {
  @JsonProperty("hour")
  private Integer hour = null;

  @JsonProperty("minute")
  private Integer minute = null;
  
  @JsonProperty("populated")
  private boolean populated;
}
