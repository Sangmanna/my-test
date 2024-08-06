package com.freightcom.clickship.model.marketplace.etsy;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pagination implements Serializable {

	private static final long serialVersionUID = -4592133979352273704L;

	@JsonProperty("effective_limit")
	private Integer effectiveLimit;

	@JsonProperty("effective_offset")
	private Integer effectiveOffset;

	@JsonProperty("next_offset")
	private Integer nextOffset;

	@JsonProperty("effective_page")
	private Integer effectivePage;

	@JsonProperty("next_page")
	private Integer nextPage;

	public Integer getEffectiveLimit() {
		return effectiveLimit;
	}

	public void setEffectiveLimit(Integer effectiveLimit) {
		this.effectiveLimit = effectiveLimit;
	}

	public Integer getEffectiveOffset() {
		return effectiveOffset;
	}

	public void setEffectiveOffset(Integer effectiveOffset) {
		this.effectiveOffset = effectiveOffset;
	}

	public Integer getNextOffset() {
		return nextOffset;
	}

	public void setNextOffset(Integer nextOffset) {
		this.nextOffset = nextOffset;
	}

	public Integer getEffectivePage() {
		return effectivePage;
	}

	public void setEffectivePage(Integer effectivePage) {
		this.effectivePage = effectivePage;
	}

	public Integer getNextPage() {
		return nextPage;
	}

	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}
}
