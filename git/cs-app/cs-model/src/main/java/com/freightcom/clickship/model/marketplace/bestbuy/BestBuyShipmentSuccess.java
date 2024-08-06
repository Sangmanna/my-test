package com.freightcom.clickship.model.marketplace.bestbuy;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BestBuyShipmentSuccess {

	@JsonProperty("created_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date createdDate;
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("last_updated_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date lastUpdatedDate;
	
	@JsonProperty("order_id")
	private String orderId;
	
	@JsonProperty("shipment_lines")
	private List<BestBuyShipmentLines> shipmentLines;
	
	@JsonProperty("shipped_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date shippedDate;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("tracking")
	private BestBuyTracking tracking;

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public List<BestBuyShipmentLines> getShipmentLines() {
		return shipmentLines;
	}

	public void setShipmentLines(List<BestBuyShipmentLines> shipmentLines) {
		this.shipmentLines = shipmentLines;
	}

	public Date getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BestBuyTracking getTracking() {
		return tracking;
	}

	public void setTracking(BestBuyTracking tracking) {
		this.tracking = tracking;
	}
	
}
