package com.freightcom.clickship.model.marketplace.magento;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MagentoComment implements Serializable {

	private static final long serialVersionUID = -1358379467721116498L;
	
	@JsonProperty("comment")
	private String comment;
	
	public String getComment() {
		return comment;
	}

	public MagentoComment setComment(String comment) {
		this.comment = comment;
		return this;
	}
}
