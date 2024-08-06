package com.freightcom.clickship.model.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentMethodDocumentReponse {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("number")
	private String number;
	
	@JsonProperty("date")
	private Date date;
	
	@JsonProperty("due_date")
	private Date dueDate;
	
	@JsonProperty("amount")
	private CostDTO amount;
	
	@JsonProperty("owing")
	private CostDTO owing;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public CostDTO getAmount() {
		return amount;
	}

	public void setAmount(CostDTO amount) {
		this.amount = amount;
	}

	public CostDTO getOwing() {
		return owing;
	}

	public void setOwing(CostDTO owing) {
		this.owing = owing;
	}

}
