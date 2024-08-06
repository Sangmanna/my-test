package com.freightcom.clickship.model.marketplace.wix;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WixFulfillments {

    @JsonProperty("id")
    private String id;

    @JsonProperty("dateCreated")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date dateCreated;

    @JsonProperty("lineItems")
    private List<WixLineItems> lineItems;

    @JsonProperty("trackingInfo")
    private WixTrackingInfo trackingInfo;

	public String getId() {
		return id;
	}

	public WixFulfillments setId(String id) {
		this.id = id;
		return this;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public WixFulfillments setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
		return this;
	}

	public List<WixLineItems> getLineItems() {
		return lineItems;
	}

	public WixFulfillments setLineItems(List<WixLineItems> lineItems) {
		this.lineItems = lineItems;
		return this;
	}

	public WixTrackingInfo getTrackingInfo() {
		return trackingInfo;
	}

	public WixFulfillments setTrackingInfo(WixTrackingInfo trackingInfo) {
		this.trackingInfo = trackingInfo;
		return this;
	}
    
}
