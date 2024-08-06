package com.freightcom.clickship.model.v2.claim;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.freightcom.clickship.model.CommonDTO;
import com.freightcom.clickship.model.v2.FreightcomDateDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClaimSearchDTO extends CommonDTO {
  @JsonProperty("ships_after")
  private FreightcomDateDTO shipsAfter;

  @JsonProperty("ships_before")
  private FreightcomDateDTO shipsBefore;
}
