package com.freightcom.clickship.model.v2.claim;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.freightcom.clickship.model.v2.DashboardNumberDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@SuppressWarnings("unused")
@EqualsAndHashCode(callSuper=false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TerminatedSummaryResponse {
	private TerminatedSummary summary;
	
	@Data
    @EqualsAndHashCode(callSuper=false)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TerminatedSummary extends DateRange {
		private DashboardNumberDTO denied;
		private DashboardNumberDTO expired;
		private DashboardNumberDTO canceled;	
    }
}
