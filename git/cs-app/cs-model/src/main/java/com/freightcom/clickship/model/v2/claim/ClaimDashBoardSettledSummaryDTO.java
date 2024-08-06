package com.freightcom.clickship.model.v2.claim;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.freightcom.clickship.model.CommonDTO;
import com.freightcom.clickship.model.v2.DashboardNumberDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@SuppressWarnings("unused")
@EqualsAndHashCode(callSuper=false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClaimDashBoardSettledSummaryDTO extends CommonDTO {
  private Summary summary;

  @Data
  @EqualsAndHashCode(callSuper=false)
  public class Summary extends ClaimDashBoardSummaryDTO {
    private DashboardNumberDTO total;
  }
}
