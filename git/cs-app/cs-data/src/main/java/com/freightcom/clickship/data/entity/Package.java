package com.freightcom.clickship.data.entity;

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
import com.freightcom.clickship.model.constants.ClickShipConstants;
import com.freightcom.clickship.model.util.ClickshipStringUtil;
import com.freightcom.clickship.model.util.Convert;


@Entity
@Table(name = "package")
public class Package extends BaseEntity {
	
	private static final long serialVersionUID = -5225908421436319555L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "shipment_id", nullable = false)
	private Shipment shipment;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false, updatable = false)
	@JsonIgnore
	private Customer customer;

	@Column(name = "length_metric", nullable = false)
	private Double lengthMetric;

	@Column(name = "length_imperial", nullable = false)
	private Double lengthImperial;

	@Column(name = "width_metric", nullable = false)
	private Double widthMetric;

	@Column(name = "width_imperial", nullable = false)
	private Double widthImperial;

	@Column(name = "height_metric", nullable = false)
	private Double heightMetric;

	@Column(name = "height_imperial", nullable = false)
	private Double heightImperial;

	@Column(name = "current_unit", nullable = false)
	private String currentUnit = "Metric";

	@Column(name = "empty_weight_metric", nullable = false)
	private Double emptyWeightMetric = 0.0;

	@Column(name = "empty_weight_imperial", nullable = false)
	private Double emptyWeightImperial = 0.0;

	@Column(name = "product_weight_metric", nullable = false)
	private Double productWeightMetric = 0.0;

	@Column(name = "product_weight_imperial", nullable = false)
	private Double productWeightImperial = 0.0;

	@Column(name = "box_id")
	private String boxId;

	@Column(name = "insurance_amount", nullable = false)
	private Double insuranceAmount = 0.0;

	@Column(name = "tracking_number")
	private String trackingNumber;

	@Column(name = "freight_class")
	private String freightClass;

	@Column(name = "NMFC_Code")
	private String nmfcCode;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "pieces")
	private String pieces;

	@Column(name = "description")
	private String description;

	@Column(name = "special_handling_required")
	private Boolean specialHandlingRequired = false;

	public String getId() {
		return id;
	}

	public Package setId(String id) {
		this.id = id;
		return this;
	}

	public Shipment getShipment() {
		return shipment;
	}

	public Package setShipment(Shipment shipment) {
		this.shipment = shipment;
		return this;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Package setCustomer(Customer customer) {
		this.customer = customer;
		return this;
	}

	public Package setLength(Double length) {
		if (length == null) {
			this.lengthMetric = Double.valueOf(0);
			this.lengthImperial = Double.valueOf(0);
			return this;
		}

		if (ClickShipConstants.UNIT_METRIC.equals(this.currentUnit)) {
			this.lengthMetric = length;
			this.lengthImperial = Convert.centimetersToInches(length);
		} else {
			this.lengthMetric = Convert.inchesToCentimeters(length);
			this.lengthImperial = length;
		}
		return this;
	}

	public Double getLength() {
		return ClickShipConstants.UNIT_METRIC.equals(this.currentUnit) ? lengthMetric : lengthImperial;
	}

	public Double getLengthMetric() {
		return lengthMetric;
	}

	public Package setLengthMetric(Double lengthMetric) {
		this.lengthMetric = lengthMetric;
		return this;
	}

	public Double getLengthImperial() {
		return lengthImperial;
	}

	public Package setLengthImperial(Double lengthImperial) {
		this.lengthImperial = lengthImperial;
		return this;
	}

	public Double getWidth() {
		return ClickShipConstants.UNIT_METRIC.equals(this.currentUnit) ? widthMetric : widthImperial;
	}

	public Double getWidthMetric() {
		return widthMetric;
	}

	public Package setWidth(Double width) {
		if (width == null) {
			this.widthMetric = Double.valueOf(0);
			this.widthImperial = Double.valueOf(0);
			return this;
		}

		if (ClickShipConstants.UNIT_METRIC.equals(this.currentUnit)) {
			this.widthMetric = width;
			this.widthImperial = Convert.centimetersToInches(width);
		} else {
			this.widthMetric = Convert.inchesToCentimeters(width);
			this.widthImperial = width;
		}
		return this;
	}

	public Package setWidthMetric(Double widthMetric) {
		this.widthMetric = widthMetric;
		return this;
	}

	public Double getWidthImperial() {
		return widthImperial;
	}

	public Package setWidthImperial(Double widthImperial) {
		this.widthImperial = widthImperial;
		return this;
	}

	public Double getHeight() {
		return ClickShipConstants.UNIT_METRIC.equals(this.currentUnit) ? heightMetric : heightImperial;
	}

	public Double getHeightMetric() {
		return heightMetric;
	}

	public Package setHeight(Double height) {
		if (height == null) {
			this.heightMetric = Double.valueOf(0);
			this.heightImperial = Double.valueOf(0);
			return this;
		}
		if (ClickShipConstants.UNIT_METRIC.equals(this.currentUnit)) {
			this.heightMetric = height;
			this.heightImperial = Convert.centimetersToInches(height);
		} else {
			this.heightMetric = Convert.inchesToCentimeters(height);
			this.heightImperial = height;
		}
		return this;
	}

	public Package setHeightMetric(Double heightMetric) {
		this.heightMetric = heightMetric;
		return this;
	}

	public Double getHeightImperial() {
		return heightImperial;
	}

	public Package setHeightImperial(Double heightImperial) {
		this.heightImperial = heightImperial;
		return this;
	}

	public String getCurrentUnit() {
		return currentUnit;
	}

	public Package setCurrentUnit(String currentUnit) {
		this.currentUnit = currentUnit;
		return this;
	}

	public Double getWeight() {
		/**
		 * return ClickShipConstants.UNIT_METRIC.equals(this.currentUnit) ?
		 * (emptyWeightMetric + productWeightMetric) : (emptyWeightImperial + productWeightImperial);
		 */
		return ClickShipConstants.UNIT_METRIC.equals(this.currentUnit) ? emptyWeightMetric : emptyWeightImperial;
	}

	public Double getEmptyWeightMetric() {
		return emptyWeightMetric;
	}

	public Package setWeight(Double weight) {
		if (weight == null) {
			this.emptyWeightMetric = Double.valueOf(0);
			this.emptyWeightImperial = Double.valueOf(0);
			return this;
		}

		if (ClickShipConstants.UNIT_METRIC.equals(this.currentUnit)) {
			this.emptyWeightMetric = weight;
			this.emptyWeightImperial = Convert.kilogramsToPounds(weight);
		} else {
			this.emptyWeightMetric = Convert.poundsToKilograms(weight);
			this.emptyWeightImperial = weight;
		}
		return this;
	}

	public Package setEmptyWeightMetric(Double emptyWeightMetric) {
		this.emptyWeightMetric = emptyWeightMetric;
		return this;
	}

	public Double getEmptyWeightImperial() {
		return emptyWeightImperial;
	}

	public Package setEmptyWeightImperial(Double emptyWeightImperial) {
		this.emptyWeightImperial = emptyWeightImperial;
		return this;
	}

	public Double getProductWeightMetric() {
		return productWeightMetric;
	}

	public Package setProductWeightMetric(Double productWeightMetric) {
		this.productWeightMetric = productWeightMetric;
		return this;
	}

	public Double getProductWeightImperial() {
		return productWeightImperial;
	}

	public Package setProductWeightImperial(Double productWeightImperial) {
		this.productWeightImperial = productWeightImperial;
		return this;
	}

	public String getBoxId() {
		return boxId;
	}

	public Package setBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}

	public Double getInsuranceAmount() {
		return insuranceAmount;
	}

	public Package setInsuranceAmount(Double insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
		return this;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public Package setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
		return this;
	}

	public String getFreightClass() {
		return freightClass;
	}

	public Package setFreightClass(String freightClass) {
		this.freightClass = freightClass;
		return this;
	}

	public String getNmfcCode() {
		return nmfcCode;
	}

	public Package setNmfcCode(String nmfcCode) {
		this.nmfcCode = nmfcCode;
		return this;
	}

	public String getType() {
		return type;
	}

	public Package setType(String type) {
		this.type = type;
		return this;
	}

	public String getPieces() {
		return pieces;
	}

	public Package setPieces(String pieces) {
		this.pieces = pieces;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public Package setDescription(String description) {
		this.description = ClickshipStringUtil.truncateString(description, 249);
		return this;
	}

	public Boolean getSpecialHandlingRequired() {
		return specialHandlingRequired;
	}

	public Package setSpecialHandlingRequired(Boolean specialHandlingRequired) {
		this.specialHandlingRequired = specialHandlingRequired;
		return this;
	}

}