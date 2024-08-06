package com.freightcom.clickship.model.v2.claim;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@SuppressWarnings("unused")
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateThreadRequest {
	private ContextId context_id;
	private String subject;

	@Data
	@EqualsAndHashCode(callSuper = false)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class ContextId {
		private String id;
		private String type;
	}
}
