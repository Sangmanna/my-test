package com.freightcom.clickship.model.slimcd;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SlimcdRequest {

	private String username;
	
	private String password;
	
	private String clientid;
	
	private String siteid;
	
	private String priceid;
	
	private String transtype;
	
	private String key;
	
	private String product;
	
	private String cardnumber;
	
	private String expmonth;
	
	private String expyear;
	
	private String cvv2;
	
	private String amount;
	
	@JsonProperty("allow_duplicates")
	private String allowDuplicates;

	public String getUsername() {
		return username;
	}

	public SlimcdRequest setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public SlimcdRequest setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getClientid() {
		return clientid;
	}

	public SlimcdRequest setClientid(String clientid) {
		this.clientid = clientid;
		return this;
	}

	public String getSiteid() {
		return siteid;
	}

	public SlimcdRequest setSiteid(String siteid) {
		this.siteid = siteid;
		return this;
	}

	public String getPriceid() {
		return priceid;
	}

	public SlimcdRequest setPriceid(String priceid) {
		this.priceid = priceid;
		return this;
	}

	public String getTranstype() {
		return transtype;
	}

	public SlimcdRequest setTranstype(String transtype) {
		this.transtype = transtype;
		return this;
	}

	public String getKey() {
		return key;
	}

	public SlimcdRequest setKey(String key) {
		this.key = key;
		return this;
	}

	public String getProduct() {
		return product;
	}

	public SlimcdRequest setProduct(String product) {
		this.product = product;
		return this;
	}

	public String getCardnumber() {
		return cardnumber;
	}

	public SlimcdRequest setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
		return this;
	}

	public String getExpmonth() {
		return expmonth;
	}

	public SlimcdRequest setExpmonth(String expmonth) {
		this.expmonth = expmonth;
		return this;
	}

	public String getExpyear() {
		return expyear;
	}

	public SlimcdRequest setExpyear(String expyear) {
		this.expyear = expyear;
		return this;
	}

	public String getCvv2() {
		return cvv2;
	}

	public SlimcdRequest setCvv2(String cvv2) {
		this.cvv2 = cvv2;
		return this;
	}

	public String getAmount() {
		return amount;
	}

	public SlimcdRequest setAmount(String amount) {
		this.amount = amount;
		return this;
	}

	public String getAllowDuplicates() {
		return allowDuplicates;
	}

	public SlimcdRequest setAllowDuplicates(String allowDuplicates) {
		this.allowDuplicates = allowDuplicates;
		return this;
	}
	
}
