package com.freightcom.clickship.model.marketplace.wix.ecom;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WixEcomMetadata {

	@JsonProperty("count")
	private Integer count;

	@JsonProperty("cursors")
	private Cursors cursors;

	@JsonProperty("hasNext")
	private Boolean hasNext;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Cursors getCursors() {
		return cursors;
	}

	public void setCursors(Cursors cursors) {
		this.cursors = cursors;
	}

	public Boolean getHasNext() {
		return hasNext;
	}

	public void setHasNext(Boolean hasNext) {
		this.hasNext = hasNext;
	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Cursors {

		@JsonProperty("next")
		private String next;

		public String getNext() {
			return next;
		}

		public void setNext(String next) {
			this.next = next;
		}
	}
}
