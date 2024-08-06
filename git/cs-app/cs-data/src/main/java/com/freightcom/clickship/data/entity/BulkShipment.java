package com.freightcom.clickship.data.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freightcom.clickship.data.entity.common.BaseEntity;
import com.freightcom.clickship.data.entity.common.CustomerAssociateEntity;
import com.freightcom.clickship.model.shipment.BulkShipmentStatus;

@Entity
@Table(name = "bulk_shipment")
public class BulkShipment extends BaseEntity implements Serializable, CustomerAssociateEntity {

	private static final long serialVersionUID = -1778857043240627084L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", nullable = false, updatable = false)
	@JsonIgnore
	private Customer customer;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "username", nullable = false, updatable = false)
	@JsonIgnore
	private User user;

	@Column(name = "batch_number")
	private String batchNumber;
	
	@Column(name = "orders_count")
	private Integer ordersCount;

	@Column(name = "status")
	private String status = BulkShipmentStatus.QUEUE.getValue();
	
	@Column(name = "shipping_label")
	private String shippingLabel;

	@Column(name = "packing_slip")
	private String packingSlip;

	@Column(name = "customs_invoice")
	private String customsInvoice;

	@Column(name = "shipment_details")
	private String shipmentDetails;
	
	@Column(name = "all_labels")
	private String allLabels;
	
	@Column(name = "booking_type")
	private String bookingType;
	
	@Column(name = "fc_cart_id")
	private String fcCartId;
	
	@Column(name = "fc_booking_request_id")
	private String fcBookingRequestId;
	
	public BulkShipment() {
		super();
	}
	
	public BulkShipment(Customer customer, User user) {
		super();
		this.customer = customer;
		this.user = user;
	}

	public String getId() {
		return id;
	}

	public BulkShipment setId(String id) {
		this.id = id;
		return this;
	}

	public Customer getCustomer() {
		return customer;
	}

	public BulkShipment setCustomer(Customer customer) {
		this.customer = customer;
		return this;
	}

	public User getUser() {
		return user;
	}

	public BulkShipment setUser(User user) {
		this.user = user;
		return this;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public BulkShipment setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
		return this;
	}
	
	public Integer getOrdersCount() {
		return ordersCount;
	}

	public BulkShipment setOrdersCount(Integer ordersCount) {
		this.ordersCount = ordersCount;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public BulkShipment setStatus(String status) {
		this.status = status;
		return this;
	}

	public String getShippingLabel() {
		return shippingLabel;
	}

	public BulkShipment setShippingLabel(String shippingLabel) {
		this.shippingLabel = shippingLabel;
		return this;
	}

	public String getPackingSlip() {
		return packingSlip;
	}

	public BulkShipment setPackingSlip(String packingSlip) {
		this.packingSlip = packingSlip;
		return this;
	}

	public String getCustomsInvoice() {
		return customsInvoice;
	}

	public BulkShipment setCustomsInvoice(String customsInvoice) {
		this.customsInvoice = customsInvoice;
		return this;
	}

	public String getShipmentDetails() {
		return shipmentDetails;
	}

	public BulkShipment setShipmentDetails(String shipmentDetails) {
		this.shipmentDetails = shipmentDetails;
		return this;
	}

	public String getAllLabels() {
		return allLabels;
	}

	public BulkShipment setAllLabels(String allLabels) {
		this.allLabels = allLabels;
		return this;
	}

	public String getBookingType() {
		return bookingType;
	}

	public BulkShipment setBookingType(String bookingType) {
		this.bookingType = bookingType;
		return this;
	}

	public String getFcCartId() {
		return fcCartId;
	}

	public BulkShipment setFcCartId(String fcCartId) {
		this.fcCartId = fcCartId;
		return this;
	}

	public String getFcBookingRequestId() {
		return fcBookingRequestId;
	}

	public BulkShipment setFcBookingRequestId(String fcBookingRequestId) {
		this.fcBookingRequestId = fcBookingRequestId;
		return this;
	}
	
	

}
