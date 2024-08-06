package com.freightcom.clickship.model.marketplace.magento;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MagentoInvoice implements Serializable {

	private static final long serialVersionUID = -857381520117731948L;

	private boolean notify;
	
	private boolean capture;
	
	private boolean appendCommnet;
	
	private MagentoComment comment;
	
	@JsonProperty("items")
	private List<MagentoOrderItem> itemsList;

	public boolean isNotify() {
		return notify;
	}

	public MagentoInvoice setNotify(boolean notify) {
		this.notify = notify;
		return this;
	}

	public boolean isCapture() {
		return capture;
	}

	public MagentoInvoice setCapture(boolean capture) {
		this.capture = capture;
		return this;
	}

	public boolean isAppendCommnet() {
		return appendCommnet;
	}

	public MagentoInvoice setAppendCommnet(boolean appendCommnet) {
		this.appendCommnet = appendCommnet;
		return this;
	}

	public MagentoComment getComment() {
		return comment;
	}

	public MagentoInvoice setComment(MagentoComment comment) {
		this.comment = comment;
		return this;
	}

	public List<MagentoOrderItem> getItemsList() {
		return itemsList;
	}

	public MagentoInvoice setItemsList(List<MagentoOrderItem> itemsList) {
		this.itemsList = itemsList;
		return this;
	}
}
