package com.freightcom.clickship.model.v2.claim;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.freightcom.clickship.model.v2.DashboardNumberDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@SuppressWarnings("unused")
@EqualsAndHashCode(callSuper=false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StaticSummaryResponse {
	private StaticSummary summary;
	
	@Data
    @EqualsAndHashCode(callSuper=false)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class StaticSummary {
    	private SavedClaims saved_claims;
        private Pending pending;
        private Approved approved;	
    }

    @Data
    @EqualsAndHashCode(callSuper=false)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SavedClaims extends DateRange {
        private DashboardNumberDTO expiring_soon;
        private DashboardNumberDTO no_insurance;
        private DashboardNumberDTO insured;
    }

    @Data
    @EqualsAndHashCode(callSuper=false)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Pending extends DateRange {
        private DashboardNumberDTO review;
        private DashboardNumberDTO trace;
        private DashboardNumberDTO in_process;
    }

    @Data
    @EqualsAndHashCode(callSuper=false)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Approved extends DateRange {
        private DashboardNumberDTO pending_payout;
    }
}
