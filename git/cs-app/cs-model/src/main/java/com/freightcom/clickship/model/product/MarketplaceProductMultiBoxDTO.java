package com.freightcom.clickship.model.product;

import static com.freightcom.clickship.model.util.Convert.getImperialDimesionByUOM;
import static com.freightcom.clickship.model.util.Convert.getImperialWeigthByUOM;
import static com.freightcom.clickship.model.util.Convert.getMetricDimesionByUOM;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freightcom.clickship.model.CommonDTO;
import com.freightcom.clickship.model.constants.ClickShipConstants;

public class MarketplaceProductMultiBoxDTO extends CommonDTO implements Serializable {
	
	private static final long serialVersionUID = -3976829760965573852L;
	
	private String id;
	
	private String marketplaceProductId;

	private Double lengthImperial;
	
	private Double widthImperial;
	
	private Double heightImperial;
	
	private Double weightImperial;
	
	private Double lengthMetric;
	
	private Double widthMetric;
	
	private Double heightMetric;
	
	private Double weightMetric;
	
	private String description;
	
	public MarketplaceProductMultiBoxDTO() {
		super();
//		double defaultValue = 0d;
//		
//		this.lengthImperial = defaultValue;
//		this.widthImperial = defaultValue;
//		this.heightImperial = defaultValue;
//		this.weightImperial = defaultValue;
//		
//		this.lengthMetric = defaultValue;
//		this.widthMetric = defaultValue;
//		this.heightMetric = defaultValue;
//		this.weightMetric = defaultValue;
	}

	
	
	public String getDescription() {
		return description;
	}



	public MarketplaceProductMultiBoxDTO setDescription(String description) {
		this.description = description;
		return this;
	}



	public String getId() {
		return id;
	}

	public MarketplaceProductMultiBoxDTO setId(String id) {
		this.id = id;
		return this;
	}

	public String getMarketplaceProductId() {
		return marketplaceProductId;
	}

	public MarketplaceProductMultiBoxDTO setMarketplaceProductId(String marketplaceProductId) {
		this.marketplaceProductId = marketplaceProductId;
		return this;
	}

	public Double getLengthImperial() {
		return lengthImperial;
	}

	public MarketplaceProductMultiBoxDTO setLengthImperial(Double lengthImperial) {
		this.lengthImperial = lengthImperial;
		return this;
	}

	public Double getWidthImperial() {
		return widthImperial;
	}

	public MarketplaceProductMultiBoxDTO setWidthImperial(Double widthImperial) {
		this.widthImperial = widthImperial;
		return this;
	}

	public Double getHeightImperial() {
		return heightImperial;
	}

	public MarketplaceProductMultiBoxDTO setHeightImperial(Double heightImperial) {
		this.heightImperial = heightImperial;
		return this;
	}

	public Double getWeightImperial() {
		return weightImperial;
	}

	public MarketplaceProductMultiBoxDTO setWeightImperial(Double weightImperial) {
		this.weightImperial = weightImperial;
		return this;
	}

	public Double getLengthMetric() {
		return lengthMetric;
	}

	public MarketplaceProductMultiBoxDTO setLengthMetric(Double lengthMetric) {
		this.lengthMetric = lengthMetric;
		return this;
	}

	public Double getWidthMetric() {
		return widthMetric;
	}

	public MarketplaceProductMultiBoxDTO setWidthMetric(Double widthMetric) {
		this.widthMetric = widthMetric;
		return this;
	}

	public Double getHeightMetric() {
		return heightMetric;
	}

	public MarketplaceProductMultiBoxDTO setHeightMetric(Double heightMetric) {
		this.heightMetric = heightMetric;
		return this;
	}

	public Double getWeightMetric() {
		return weightMetric;
	}

	public MarketplaceProductMultiBoxDTO setWeightMetric(Double weightMetric) {
		this.weightMetric = weightMetric;
		return this;
	}
	
	@JsonIgnore
	public boolean validateData() {
		return lengthImperial > 0 && widthImperial > 0 && heightImperial > 0 && weightImperial > 0 && lengthMetric > 0
				&& widthMetric > 0 && heightMetric > 0 && weightMetric > 0;
	}
	
	@JsonIgnore
	public void check(String uom) {
		String weightUnit = ClickShipConstants.UNIT_METRIC.equalsIgnoreCase(uom) ? "kg" : "lbs";
		String dimensionsUnit = ClickShipConstants.UNIT_METRIC.equalsIgnoreCase(uom) ? "cm" : "in";
		
		if (ClickShipConstants.UNIT_METRIC.equals(uom)) {
			this.weightImperial = getImperialWeigthByUOM(weightMetric, weightUnit);
			this.widthImperial = getImperialDimesionByUOM(widthMetric, dimensionsUnit);
			this.heightImperial = getImperialDimesionByUOM(heightMetric, dimensionsUnit);
			this.lengthImperial = getImperialDimesionByUOM(lengthMetric, dimensionsUnit);
		} else {
			this.weightMetric = getImperialWeigthByUOM(weightImperial, weightUnit);
			this.widthMetric = getMetricDimesionByUOM(widthImperial, dimensionsUnit);
			this.heightMetric = getMetricDimesionByUOM(heightImperial, dimensionsUnit);
			this.lengthMetric = getMetricDimesionByUOM(lengthImperial, dimensionsUnit);
		}
	}
	
}