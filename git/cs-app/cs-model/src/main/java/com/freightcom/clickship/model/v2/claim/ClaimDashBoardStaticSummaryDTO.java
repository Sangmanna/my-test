package com.freightcom.clickship.model.v2.claim;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.freightcom.clickship.model.CommonDTO;
import com.freightcom.clickship.model.v2.DashboardNumberDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@SuppressWarnings("unused")
@EqualsAndHashCode(callSuper=false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClaimDashBoardStaticSummaryDTO extends CommonDTO {
  private Summary summary;

  @Data
  public class Summary {
    @JsonProperty("saved_claims")
    private SavedClaims savedClaims;
    private Pending pending;
    private Approved approved;
  }

  @Data
  @EqualsAndHashCode(callSuper=false)
  public class SavedClaims extends ClaimDashBoardSummaryDTO {
    @JsonProperty("expiring_soon")
    private DashboardNumberDTO expiringSoon;

    @JsonProperty("no_insurance")
    private DashboardNumberDTO noInsurance;

    private DashboardNumberDTO total;
    private DashboardNumberDTO insured;
  }

  @Data
  @EqualsAndHashCode(callSuper=false)
  public class Approved extends ClaimDashBoardSummaryDTO {
    @JsonProperty("pending_payout")
    private DashboardNumberDTO pendingPayout;
    private DashboardNumberDTO total;
  }

  @Data
  @EqualsAndHashCode(callSuper=false)
  public class Pending extends ClaimDashBoardSummaryDTO {
    @JsonProperty("in_process")
    private DashboardNumberDTO inProcess;

    private DashboardNumberDTO total;
    private DashboardNumberDTO review;
    private DashboardNumberDTO trace;
  }
}
