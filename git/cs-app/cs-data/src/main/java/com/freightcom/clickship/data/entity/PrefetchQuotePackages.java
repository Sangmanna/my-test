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

import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "prefetch_quote_packages")
public class PrefetchQuotePackages extends BaseEntity {

	private static final long serialVersionUID = 2172833296320182032L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "prefetch_quote_request_id", nullable = false)
	private PrefetchQuoteRequest prefetchQuoteRequest;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", nullable = false)
	private com.freightcom.clickship.data.entity.Order order;

	@Column(name = "box_id")
	private String boxId;

	@Column(name = "name")
	private String name;

	@Column(name = "length_metric", nullable = false)
	private double lengthMetric;

	@Column(name = "length_imperial", nullable = false)
	private double lengthImperial;

	@Column(name = "width_metric", nullable = false)
	private double widthMetric;

	@Column(name = "width_imperial", nullable = false)
	private double widthImperial;

	@Column(name = "height_metric", nullable = false)
	private double heightMetric;

	@Column(name = "height_imperial", nullable = false)
	private double heightImperial;

	@Column(name = "empty_weight_metric", nullable = false)
	private double emptyWeightMetric = 0.0;

	@Column(name = "empty_weight_imperial", nullable = false)
	private double emptyWeightImperial = 0.0;

	@Column(name = "product_weight_metric", nullable = false)
	private double productWeightMetric = 0.0;

	@Column(name = "product_weight_imperial", nullable = false)
	private double productWeightImperial = 0.0;

	@Column(name = "current_unit", nullable = false)
	private String currentUnit = "Metric";

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

	@Column(name = "smart_box_worked")
	private boolean smartBoxWorked = false;

	public String getId() {
		return id;
	}

	public PrefetchQuotePackages setId(String id) {
		this.id = id;
		return this;
	}

	public PrefetchQuoteRequest getPrefetchQuoteRequest() {
		return prefetchQuoteRequest;
	}

	public PrefetchQuotePackages setPrefetchQuoteRequest(PrefetchQuoteRequest prefetchQuoteRequest) {
		this.prefetchQuoteRequest = prefetchQuoteRequest;
		return this;
	}

	public com.freightcom.clickship.data.entity.Order getOrder() {
		return order;
	}

	public PrefetchQuotePackages setOrder(com.freightcom.clickship.data.entity.Order order) {
		this.order = order;
		return this;
	}

	public String getBoxId() {
		return boxId;
	}

	public PrefetchQuotePackages setBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}

	public String getName() {
		return name;
	}

	public PrefetchQuotePackages setName(String name) {
		this.name = name;
		return this;
	}

	public double getLengthMetric() {
		return lengthMetric;
	}

	public PrefetchQuotePackages setLengthMetric(double lengthMetric) {
		this.lengthMetric = lengthMetric;
		return this;
	}

	public double getLengthImperial() {
		return lengthImperial;
	}

	public PrefetchQuotePackages setLengthImperial(double lengthImperial) {
		this.lengthImperial = lengthImperial;
		return this;
	}

	public double getWidthMetric() {
		return widthMetric;
	}

	public PrefetchQuotePackages setWidthMetric(double widthMetric) {
		this.widthMetric = widthMetric;
		return this;
	}

	public double getWidthImperial() {
		return widthImperial;
	}

	public PrefetchQuotePackages setWidthImperial(double widthImperial) {
		this.widthImperial = widthImperial;
		return this;
	}

	public double getHeightMetric() {
		return heightMetric;
	}

	public PrefetchQuotePackages setHeightMetric(double heightMetric) {
		this.heightMetric = heightMetric;
		return this;
	}

	public double getHeightImperial() {
		return heightImperial;
	}

	public PrefetchQuotePackages setHeightImperial(double heightImperial) {
		this.heightImperial = heightImperial;
		return this;
	}

	public double getEmptyWeightMetric() {
		return emptyWeightMetric;
	}

	public PrefetchQuotePackages setEmptyWeightMetric(double emptyWeightMetric) {
		this.emptyWeightMetric = emptyWeightMetric;
		return this;
	}

	public double getEmptyWeightImperial() {
		return emptyWeightImperial;
	}

	public PrefetchQuotePackages setEmptyWeightImperial(double emptyWeightImperial) {
		this.emptyWeightImperial = emptyWeightImperial;
		return this;
	}

	public double getProductWeightMetric() {
		return productWeightMetric;
	}

	public PrefetchQuotePackages setProductWeightMetric(double productWeightMetric) {
		this.productWeightMetric = productWeightMetric;
		return this;
	}

	public double getProductWeightImperial() {
		return productWeightImperial;
	}

	public PrefetchQuotePackages setProductWeightImperial(double productWeightImperial) {
		this.productWeightImperial = productWeightImperial;
		return this;
	}

	public String getCurrentUnit() {
		return currentUnit;
	}

	public PrefetchQuotePackages setCurrentUnit(String currentUnit) {
		this.currentUnit = currentUnit;
		return this;
	}

	public String getFreightClass() {
		return freightClass;
	}

	public PrefetchQuotePackages setFreightClass(String freightClass) {
		this.freightClass = freightClass;
		return this;
	}

	public String getNmfcCode() {
		return nmfcCode;
	}

	public PrefetchQuotePackages setNmfcCode(String nmfcCode) {
		this.nmfcCode = nmfcCode;
		return this;
	}

	public String getType() {
		return type;
	}

	public PrefetchQuotePackages setType(String type) {
		this.type = type;
		return this;
	}

	public String getPieces() {
		return pieces;
	}

	public PrefetchQuotePackages setPieces(String pieces) {
		this.pieces = pieces;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public PrefetchQuotePackages setDescription(String description) {
		this.description = description;
		return this;
	}

	public boolean isSmartBoxWorked() {
		return smartBoxWorked;
	}

	public PrefetchQuotePackages setSmartBoxWorked(boolean smartBoxWorked) {
		this.smartBoxWorked = smartBoxWorked;
		return this;
	}

}
