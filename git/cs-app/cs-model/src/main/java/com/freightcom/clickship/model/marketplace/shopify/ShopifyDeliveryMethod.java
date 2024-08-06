package com.freightcom.clickship.model.marketplace.shopify;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyDeliveryMethod implements Serializable {

	private static final long serialVersionUID = -2571882909858543171L;
	
	@JsonProperty("id")
	private Long id;

	@JsonProperty("method_type")
	private String methodType;
	
	@JsonProperty("min_delivery_date_time")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date minDeliveryDateTime;
	
	@JsonProperty("max_delivery_date_time")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date maxDeliveryDateTime;

	public Long getId() {
		return id;
	}

	public ShopifyDeliveryMethod setId(Long id) {
		this.id = id;
		return this;
	}

	public String getMethodType() {
		return methodType;
	}

	public ShopifyDeliveryMethod setMethodType(String methodType) {
		this.methodType = methodType;
		return this;
	}

	public Date getMinDeliveryDateTime() {
		return minDeliveryDateTime;
	}

	public ShopifyDeliveryMethod setMinDeliveryDateTime(Date minDeliveryDateTime) {
		this.minDeliveryDateTime = minDeliveryDateTime;
		return this;
	}

	public Date getMaxDeliveryDateTime() {
		return maxDeliveryDateTime;
	}

	public ShopifyDeliveryMethod setMaxDeliveryDateTime(Date maxDeliveryDateTime) {
		this.maxDeliveryDateTime = maxDeliveryDateTime;
		return this;
	}

}
