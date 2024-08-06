package com.freightcom.clickship.data.entity;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freightcom.clickship.data.entity.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "printing_preference")
public class PrintingPreference extends BaseEntity {

	private static final long serialVersionUID = 5318716590500341950L;
	
	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_preferences_id", nullable = false, updatable = false)
	@JsonIgnore
	private CustomerPreferences customerPreferences;

	@Column(name = "picklist_sortby")
	private String picklistSortby = "SKU";
	
	@Column(name = "picklist_include_product_image")
	private boolean picklistIncludeProductImage = true;
	
	@Column(name = "picklist_include_order_number")
	private boolean picklistIncludeOrderNumber = false;
	
	@Column(name = "packing_slip_thermal_labels")
	private boolean packingSlipThermalLabels = false;

	@Column(name = "packing_slip_sortby")
	private String packingSlipSortBy = "SKU";

	@Column(name = "packing_slip_include_product_image")
	private boolean packingSlipIncludeProductImage = true;

	@Column(name = "packing_slip_include_sku")
	private boolean packingSlipIncludeSku = true;

	@Column(name = "packing_slip_include_price")
	private boolean packingSlipIncludePrice = true;

	@Column(name = "packing_slip_include_ship_date")
	private boolean packingSlipIncludeShipDate = true;

	@Column(name = "packing_slip_include_shipping_method")
	private boolean packingSlipIncludeShippingMethod = true;
	
	@Column(name = "packing_slip_custom_message")
	private String packingSlipCustomMessage;

	@Override
	public String getId() {
		return id;
	}

	@Override
	public BaseEntity setId(String id) {
		this.id = id;
		return this;
	}

	public CustomerPreferences getCustomerPreferences() {
		return customerPreferences;
	}

	public PrintingPreference setCustomerPreferences(CustomerPreferences customerPreferences) {
		this.customerPreferences = customerPreferences;
		return this;
	}

	public String getPicklistSortby() {
		return picklistSortby;
	}

	public PrintingPreference setPicklistSortby(String picklistSortby) {
		this.picklistSortby = picklistSortby;
		return this;
	}

	public boolean isPicklistIncludeProductImage() {
		return picklistIncludeProductImage;
	}

	public PrintingPreference setPicklistIncludeProductImage(boolean picklistIncludeProductImage) {
		this.picklistIncludeProductImage = picklistIncludeProductImage;
		return this;
	}

	public boolean isPicklistIncludeOrderNumber() {
		return picklistIncludeOrderNumber;
	}

	public PrintingPreference setPicklistIncludeOrderNumber(boolean picklistIncludeOrderNumber) {
		this.picklistIncludeOrderNumber = picklistIncludeOrderNumber;
		return this;
	}

	public boolean isPackingSlipThermalLabels() {
		return packingSlipThermalLabels;
	}

	public PrintingPreference setPackingSlipThermalLabels(boolean packingSlipThermalLabels) {
		this.packingSlipThermalLabels = packingSlipThermalLabels;
		return this;
	}

	public String getPackingSlipSortBy() {
		return packingSlipSortBy;
	}

	public PrintingPreference setPackingSlipSortBy(String packingSlipSortBy) {
		this.packingSlipSortBy = packingSlipSortBy;
		return this;
	}

	public boolean isPackingSlipIncludeProductImage() {
		return packingSlipIncludeProductImage;
	}

	public PrintingPreference setPackingSlipIncludeProductImage(boolean packingSlipIncludeProductImage) {
		this.packingSlipIncludeProductImage = packingSlipIncludeProductImage;
		return this;
	}

	public boolean isPackingSlipIncludeSku() {
		return packingSlipIncludeSku;
	}

	public PrintingPreference setPackingSlipIncludeSku(boolean packingSlipIncludeSku) {
		this.packingSlipIncludeSku = packingSlipIncludeSku;
		return this;
	}

	public boolean isPackingSlipIncludePrice() {
		return packingSlipIncludePrice;
	}

	public PrintingPreference setPackingSlipIncludePrice(boolean packingSlipIncludePrice) {
		this.packingSlipIncludePrice = packingSlipIncludePrice;
		return this;
	}

	public boolean isPackingSlipIncludeShipDate() {
		return packingSlipIncludeShipDate;
	}

	public PrintingPreference setPackingSlipIncludeShipDate(boolean packingSlipIncludeShipDate) {
		this.packingSlipIncludeShipDate = packingSlipIncludeShipDate;
		return this;
	}

	public boolean isPackingSlipIncludeShippingMethod() {
		return packingSlipIncludeShippingMethod;
	}

	public PrintingPreference setPackingSlipIncludeShippingMethod(boolean packingSlipIncludeShippingMethod) {
		this.packingSlipIncludeShippingMethod = packingSlipIncludeShippingMethod;
		return this;
	}

	public String getPackingSlipCustomMessage() {
		return packingSlipCustomMessage;
	}

	public PrintingPreference setPackingSlipCustomMessage(String packingSlipCustomMessage) {
		this.packingSlipCustomMessage = packingSlipCustomMessage;
		return this;
	}
	
}
