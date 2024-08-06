package com.freightcom.clickship.model.marketplace.wix.ecom;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WixEcomSearch {

	@JsonProperty("search")
	private WixSearch search;

	public WixSearch getSearch() {
		return search;
	}

	public void setSearch(WixSearch search) {
		this.search = search;
	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class WixSearch {

		@JsonProperty("filter")
		private Map<String, Object> filter;

		@JsonProperty("sort")
		private List<Sort> sort;

		@JsonProperty("cursor_paging")
		private CursorPaging cursorPaging;

		public Map<String, Object> getFilter() {
			return filter;
		}

		public void setFilter(Map<String, Object> filter) {
			this.filter = filter;
		}

		public List<Sort> getSort() {
			return sort;
		}

		public void setSort(List<Sort> sort) {
			this.sort = sort;
		}

		public CursorPaging getCursorPaging() {
			return cursorPaging;
		}

		public void setCursorPaging(CursorPaging cursorPaging) {
			this.cursorPaging = cursorPaging;
		}
	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Sort {

		@JsonProperty("fieldName")
		private String fieldName;

		@JsonProperty("order")
		private String order;

		public String getFieldName() {
			return fieldName;
		}

		public void setFieldName(String fieldName) {
			this.fieldName = fieldName;
		}

		public String getOrder() {
			return order;
		}

		public void setOrder(String order) {
			this.order = order;
		}

	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class CursorPaging {

		@JsonProperty("limit")
		private Integer limit;

		@JsonProperty("cursor")
		private String cursor;

		public Integer getLimit() {
			return limit;
		}

		public void setLimit(Integer limit) {
			this.limit = limit;
		}

		public String getCursor() {
			return cursor;
		}

		public void setCursor(String cursor) {
			this.cursor = cursor;
		}

	}

}
