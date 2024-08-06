package com.freightcom.clickship.data.entity;

import java.io.Serializable;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freightcom.clickship.data.entity.common.BaseEntity;
import com.freightcom.clickship.model.util.ClickshipStringUtil;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "batch_shipments")
public class BatchShipment extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 7386990948431525720L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bulk_shipment_id", nullable = false, updatable = false)
	@JsonIgnore
	private BulkShipment bulkShipment;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id", nullable = false, updatable = false)
	@JsonIgnore
	private Order order;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shipment_id")
	@JsonIgnore
	private Shipment shipment;

	@Column(name = "no_of_packages")
	private Integer noOfPackages;

	@Column(name = "shipping_cost")
	private Double shippingCost;
	
	@Column(name = "shipping_currency")
	private String shippingCurrency = "CAD";
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "freightcom_v2_order_id")
	private String freightcomOrderId;
	
	@Column(name = "is_own_carrier_shipment")
	private Boolean isOwnCarrierShipment = false;
	
	@Column(name = "is_cart_shipment")
	private Boolean isCartShipment = false;
	
	@Column(name = "fc_cart_id")
	private String fcCartId;
	
	@Column(name = "carrier_name")
	private String carrierName;
	
	@Column(name = "shipping_error")
	private String shippingError;

	@Column(name = "shipping_label")
	private String shippingLabel;

	@Column(name = "packing_slip")
	private String packingSlip;

	@Column(name = "shipment_details")
	private String shipmentDetails;

	@Column(name = "customs_invoice")
	private String customsInvoice;
		
    @Column(columnDefinition = "json")
    private String formDto;

	public BatchShipment() {
		super();
	}

	public BatchShipment(BulkShipment bulkShipment) {
		super();
		this.bulkShipment = bulkShipment;
	}
	
	public String getId() {
		return id;
	}

	public BatchShipment setId(String id) {
		this.id = id;
		return this;
	}

	public BulkShipment getBulkShipment() {
		return bulkShipment;
	}

	public BatchShipment setBulkShipment(BulkShipment bulkShipment) {
		this.bulkShipment = bulkShipment;
		return this;
	}

	public Order getOrder() {
		return order;
	}

	public BatchShipment setOrder(Order order) {
		this.order = order;
		return this;
	}

	public Shipment getShipment() {
		return shipment;
	}

	public BatchShipment setShipment(Shipment shipment) {
		this.shipment = shipment;
		this.status = shipment != null ? "Success" : "Failed";
		return this;
	}

	public String getStatus() {
		return status;
	}

	public BatchShipment setStatus(String status) {
		this.status = status;
		return this;
	}
	
	public Integer getNoOfPackages() {
		return noOfPackages;
	}

	public BatchShipment setNoOfPackages(Integer noOfPackages) {
		this.noOfPackages = noOfPackages;
		return this;
	}
	
	public Double getShippingCost() {
		return shippingCost;
	}

	public BatchShipment setShippingCost(Double shippingCost) {
		this.shippingCost = shippingCost;
		return this;
	}

	public String getShippingCurrency() {
		return shippingCurrency;
	}

	public BatchShipment setShippingCurrency(String shippingCurrency) {
		this.shippingCurrency = shippingCurrency;
		return this;
	}
	
	public String getFreightcomOrderId() {
		return freightcomOrderId;
	}

	public void setFreightcomOrderId(String freightcomOrderId) {
		this.freightcomOrderId = freightcomOrderId;
	}

	public Boolean getIsOwnCarrierShipment() {
		return isOwnCarrierShipment;
	}

	public BatchShipment setIsOwnCarrierShipment(Boolean isOwnCarrierShipment) {
		this.isOwnCarrierShipment = isOwnCarrierShipment;
		return this;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public String getShippingError() {
		return shippingError;
	}

	public BatchShipment setShippingError(String shippingError) {
		this.shippingError = ClickshipStringUtil.truncateString(shippingError, 250);
		return this;
	}
	
	public String getShippingLabel() {
		return shippingLabel;
	}

	public BatchShipment setShippingLabel(String shippingLabel) {
		this.shippingLabel = shippingLabel;
		return this;
	}

	public String getPackingSlip() {
		return packingSlip;
	}

	public BatchShipment setPackingSlip(String packingSlip) {
		this.packingSlip = packingSlip;
		return this;
	}

	public String getCustomsInvoice() {
		return customsInvoice;
	}

	public BatchShipment setCustomsInvoice(String customsInvoice) {
		this.customsInvoice = customsInvoice;
		return this;
	}

	public String getShipmentDetails() {
		return shipmentDetails;
	}

	public BatchShipment setShipmentDetails(String shipmentDetails) {
		this.shipmentDetails = shipmentDetails;
		return this;
	}

	public String getFormDto() {
		return formDto;
	}

	public BatchShipment setFormDto(String formDto) {
		this.formDto = formDto;
		return this;
	}

	public Boolean getIsCartShipment() {
		return isCartShipment;
	}

	public BatchShipment setIsCartShipment(Boolean isCartShipment) {
		this.isCartShipment = isCartShipment;
		return this;
	}

	public String getFcCartId() {
		return fcCartId;
	}

	public BatchShipment setFcCartId(String fcCartId) {
		this.fcCartId = fcCartId;
		return this;
	}
	
	
}
