package com.freightcom.clickship.model.marketplace.magento;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MagentoShipmentTracking implements Serializable {

	private static final long serialVersionUID = -3455322564760640157L;

	@JsonAlias({ "order_id", "orderId" })
	private String orderId;
	
	@JsonAlias({ "entityId", "entity_id" })
	private String entityId;
	
	@JsonAlias({ "parentId", "parent_id" })
	private String parentId;
	
	private Integer weight;
	
	private Integer qty;
	
	private String description;
	
	@JsonAlias({ "track_number", "trackNumber" })
	private String trackNumber;
	
	@JsonProperty("title")
	private String carrierName;
	
	@JsonAlias({ "carrierCode", "carrier_code" })
	private String carrierCode;

	public String getOrderId() {
		return orderId;
	}

	public MagentoShipmentTracking setOrderId(String orderId) {
		this.orderId = orderId;
		return this;
	}

	public String getEntityId() {
		return entityId;
	}

	public MagentoShipmentTracking setEntityId(String entityId) {
		this.entityId = entityId;
		return this;
	}

	public String getParentId() {
		return parentId;
	}

	public MagentoShipmentTracking setParentId(String parentId) {
		this.parentId = parentId;
		return this;
	}

	public Integer getWeight() {
		return weight;
	}

	public MagentoShipmentTracking setWeight(Integer weight) {
		this.weight = weight;
		return this;
	}

	public Integer getQty() {
		return qty;
	}

	public MagentoShipmentTracking setQty(Integer qty) {
		this.qty = qty;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public MagentoShipmentTracking setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getTrackNumber() {
		return trackNumber;
	}

	public MagentoShipmentTracking setTrackNumber(String trackNumber) {
		this.trackNumber = trackNumber;
		return this;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public MagentoShipmentTracking setCarrierName(String carrierName) {
		this.carrierName = carrierName;
		return this;
	}

	public String getCarrierCode() {
		return carrierCode;
	}

	public MagentoShipmentTracking setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
		return this;
	}

	@Override
	public String toString() {
		return "MagentoShipmentTracking [orderId=" + orderId + ", entityId=" + entityId + ", parentId=" + parentId
				+ ", weight=" + weight + ", qty=" + qty + ", description=" + description + ", trackNumber="
				+ trackNumber + ", carrierName=" + carrierName + ", carrierCode=" + carrierCode + "]";
	}

}
