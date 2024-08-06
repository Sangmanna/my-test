package com.freightcom.clickship.model.marketplace.bigcommerce;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BigCommerceMeta {
	
	@JsonProperty("pagination")
	private Pagintaion pagintaion;
	
	public Pagintaion getPagintaion() {
		return pagintaion;
	}

	public void setPagintaion(Pagintaion pagintaion) {
		this.pagintaion = pagintaion;
	}
	
	public static class Pagintaion {
		
		@JsonProperty("total")
		private int total;
		
		@JsonProperty("count")
		private int count;
		
		@JsonProperty("per_page")
		private int perPage;
		
		@JsonProperty("current_page")
		private int currentPage;
		
		@JsonProperty("total_pages")
		private int totalPages;
		
		@JsonProperty("too_many")
		private boolean tooMany;
		
		@JsonProperty("links")
		private Link links;

		public int getTotal() {
			return total;
		}

		public void setTotal(int total) {
			this.total = total;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		public int getPerPage() {
			return perPage;
		}

		public void setPerPage(int perPage) {
			this.perPage = perPage;
		}

		public int getCurrentPage() {
			return currentPage;
		}

		public void setCurrentPage(int currentPage) {
			this.currentPage = currentPage;
		}

		public int getTotalPages() {
			return totalPages;
		}

		public void setTotalPages(int totalPages) {
			this.totalPages = totalPages;
		}

		public boolean isTooMany() {
			return tooMany;
		}

		public void setTooMany(boolean tooMany) {
			this.tooMany = tooMany;
		}

		public Link getLinks() {
			return links;
		}

		public void setLinks(Link links) {
			this.links = links;
		}
	}
	
	public static class Link {
		
		private String next;
		
		private String current;

		public String getNext() {
			return next;
		}

		public void setNext(String next) {
			this.next = next;
		}

		public String getCurrent() {
			return current;
		}

		public void setCurrent(String current) {
			this.current = current;
		}
	}
}
