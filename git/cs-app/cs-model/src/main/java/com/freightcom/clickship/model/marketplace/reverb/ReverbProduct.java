package com.freightcom.clickship.model.marketplace.reverb;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
public class ReverbProduct {
	@JsonProperty("total")
	private String total;
	@JsonProperty("current_page")
	private String currentPage;
	@JsonProperty("total_pages")
	private String totalPages;
	@JsonProperty("listings")
	private ArrayList<ReverbListing> reverbListings;
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	public String getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(String totalPages) {
		this.totalPages = totalPages;
	}
	public ArrayList<ReverbListing> getReverbListings() {
		return reverbListings;
	}
	public void setReverbListings(ArrayList<ReverbListing> reverbListings) {
		this.reverbListings = reverbListings;
	}
	
}
