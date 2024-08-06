package com.freightcom.clickship.model.v2.invoice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.freightcom.clickship.model.v2.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenerateReport {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("type")
	private String type; 
	
	@JsonProperty("name")
	private String name; 
	
	@JsonProperty("created")
	private String created;
	
	@JsonProperty("start_date")
	private Date startDate;

	@JsonProperty("end_date")
	private Date endDate;
	
	@JsonProperty("urls")
	private ReportUrls urls;
	
	@Data
	@EqualsAndHashCode(callSuper = false)
	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public class ReportUrls {

		@JsonProperty("csv")
		private String csv;
		
	}
	
}
