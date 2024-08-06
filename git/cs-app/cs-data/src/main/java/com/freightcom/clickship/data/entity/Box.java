package com.freightcom.clickship.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freightcom.clickship.data.entity.common.BaseEntity;
import com.freightcom.clickship.data.entity.common.CustomerAssociateEntity;
import com.freightcom.clickship.model.constants.ClickShipConstants;

@Entity
@Table(name = "box")
public class Box extends BaseEntity implements CustomerAssociateEntity {

	private static final long serialVersionUID = -5149448470213771897L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@Column(name = "name", nullable = false)
	private String name;

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

	@Column(name = "empty_weight_metric", nullable = false)
	private Double emptyWeightMetric;

	@Column(name = "empty_weight_imperial", nullable = false)
	private Double emptyWeightImperial;

	@Column(name = "max_weight_metric", nullable = false)
	private Double maxWeightMetric;

	@Column(name = "max_weight_imperial", nullable = false)
	private Double maxWeightImperial;

	@Column(name = "use_in_algorithm")
	private Boolean useInAlgorithm;

	@Column(name = "realtime_use")
	private Boolean realtimeUse;

	@Column(name = "default_box", nullable = false)
	private Boolean defaultBox = false;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false, updatable = false)
	@JsonIgnore
	private Customer customer;
	
	@Column(name = "unit_of_measure")
	private String unitOfMeasure = ClickShipConstants.UNIT_IMPERIAL;

	@Column(name = "package_type")
	private String packageType;

	@Transient
	private Double weight;

	@Transient
	private Double maxWeight;

	@Transient
	private Double length;

	@Transient
	private Double width;

	@Transient
	private Double height;
	
	@Transient
	private String customBoxDescription;
	
	public String getId() {
		return id;
	}

	public BaseEntity setId(String id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Box setName(String name) {
		this.name = name;
		return this;
	}

	public Boolean isUseInAlgorithm() {
		return useInAlgorithm;
	}

	public Box setUseInAlgorithm(Boolean useInAlgorithm) {
		this.useInAlgorithm = useInAlgorithm;
		return this;
	}

	public Boolean isDefaultBox() {
		return defaultBox;
	}

	public Box setDefaultBox(Boolean defaultBox) {
		this.defaultBox = defaultBox;
		return this;
	}

	@Override
	public Customer getCustomer() {
		return customer;
	}

	public Box setCustomer(Customer customer) {
		this.customer = customer;
		return this;
	}

	public Double getLengthMetric() {
		return lengthMetric;
	}

	public Box setLengthMetric(Double lengthMetric) {
		this.lengthMetric = lengthMetric;
		return this;
	}

	public Double getLengthImperial() {
		return lengthImperial;
	}

	public Box setLengthImperial(Double lengthImperial) {
		this.lengthImperial = lengthImperial;
		return this;
	}

	public Double getWidthMetric() {
		return widthMetric;
	}

	public Box setWidthMetric(Double widthMetric) {
		this.widthMetric = widthMetric;
		return this;
	}

	public Double getWidthImperial() {
		return widthImperial;
	}

	public Box setWidthImperial(Double widthImperial) {
		this.widthImperial = widthImperial;
		return this;
	}

	public Double getHeightMetric() {
		return heightMetric;
	}

	public Box setHeightMetric(Double heightMetric) {
		this.heightMetric = heightMetric;
		return this;
	}

	public Double getHeightImperial() {
		return heightImperial;
	}

	public Box setHeightImperial(Double heightImperial) {
		this.heightImperial = heightImperial;
		return this;
	}

	public Double getEmptyWeightMetric() {
		return emptyWeightMetric;
	}

	public Box setEmptyWeightMetric(Double emptyWeightMetric) {
		this.emptyWeightMetric = emptyWeightMetric;
		return this;
	}

	public Double getEmptyWeightImperial() {
		return emptyWeightImperial;
	}

	public Box setEmptyWeightImperial(Double emptyWeightImperial) {
		this.emptyWeightImperial = emptyWeightImperial;
		return this;
	}

	public Double getMaxWeightMetric() {
		return maxWeightMetric;
	}

	public Box setMaxWeightMetric(Double maxWeightMetric) {
		this.maxWeightMetric = maxWeightMetric;
		return this;
	}

	public Double getMaxWeightImperial() {
		return maxWeightImperial;
	}

	public Box setMaxWeightImperial(Double maxWeightImperial) {
		this.maxWeightImperial = maxWeightImperial;
		return this;
	}

	public Boolean getRealtimeUse() {
		return realtimeUse != null && realtimeUse;
	}

	public Box setRealtimeUse(Boolean realtimeUse) {
		this.realtimeUse = realtimeUse;
		return this;
	}

	public Boolean getUseInAlgorithm() {
		return useInAlgorithm;
	}

	public Boolean getDefaultBox() {
		return defaultBox;
	}
	
	public Double getWeight() {
		return weight;
	}

	public Box setWeight(Double weight) {
		this.weight = weight;
		return this;
	}

	public Double getMaxWeight() {
		return maxWeight;
	}

	public Box setMaxWeight(Double maxWeight) {
		this.maxWeight = maxWeight;
		return this;
	}

	public Double getLength() {
		return length;
	}

	public Box setLength(Double length) {
		this.length = length;
		return this;
	}

	public Double getWidth() {
		return width;
	}

	public Box setWidth(Double width) {
		this.width = width;
		return this;
	}

	public Double getHeight() {
		return height;
	}

	public Box setHeight(Double height) {
		this.height = height;
		return this;
	}

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public Box setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
		return this;
	}
	
	public String getPackageType() {
		return packageType;
	}

	public Box setPackageType(String packageType) {
		this.packageType = packageType;
		return this;
	}

	public String getCustomBoxDescription() {
		return customBoxDescription;
	}

	public void setCustomBoxDescription(String customBoxDescription) {
		this.customBoxDescription = customBoxDescription;
	}

}