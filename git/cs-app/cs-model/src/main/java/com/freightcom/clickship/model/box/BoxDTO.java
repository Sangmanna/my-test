package com.freightcom.clickship.model.box;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freightcom.clickship.model.CommonDTO;
import com.freightcom.clickship.model.constants.ClickShipConstants;
import com.freightcom.clickship.model.util.ClickshipStringUtil;

public class BoxDTO extends CommonDTO implements Serializable {

	private static final long serialVersionUID = -6268222694137508318L;
	private static final double INCH_TO_CM = 2.54;
	private static final double KG_TO_POUND = 2.2046;

	private String id;
	private String name;
	private double lengthMetric;
	private double lengthImperial;
	private double widthMetric;
	private double widthImperial;
	private double heightMetric;
	private double heightImperial;
	private double emptyWeightMetric;
	private double emptyWeightImperial;
	private Boolean useInAlgorithm;
	private Boolean realtimeUse;
	private String currentUnit = ClickShipConstants.UNIT_IMPERIAL;
	private Boolean defaultBox = false;
	private double insuranceAmount;
	private double productWeightImperial;
	private double productWeightMetric;
	private String freightClass;
	private String nmfcCode;
	private String type;
	private String pieces;
	private String description;
	private String customBoxDescription;

	// this field fro bulkshipment purpose
	private Boolean smartBoxWorked = true;
	private List<ProductDisplayDTO> productsInfo;
	private Boolean specialHandlingRequired = false;

	public String getId() {
		return id;
	}

	public BoxDTO setId(String id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public BoxDTO setName(String name) {
		this.name = name;
		return this;
	}

	public double getLengthMetric() {
		return lengthMetric;
	}

	public BoxDTO setLengthMetric(double lengthMetric) {
		this.lengthMetric = lengthMetric;
		return this;
	}

	public double getLengthImperial() {
		return lengthImperial;
	}

	public BoxDTO setLengthImperial(double lengthImperial) {
		this.lengthImperial = lengthImperial;
		return this;
	}

	public double getWidthMetric() {
		return widthMetric;
	}

	public BoxDTO setWidthMetric(double widthMetric) {
		this.widthMetric = widthMetric;
		return this;
	}

	public double getWidthImperial() {
		return widthImperial;
	}

	public BoxDTO setWidthImperial(double widthImperial) {
		this.widthImperial = widthImperial;
		return this;
	}

	public double getHeightMetric() {
		return heightMetric;
	}

	public BoxDTO setHeightMetric(double heightMetric) {
		this.heightMetric = heightMetric;
		return this;
	}

	public double getHeightImperial() {
		return heightImperial;
	}

	public BoxDTO setHeightImperial(double heightImperial) {
		this.heightImperial = heightImperial;
		return this;
	}

	public double getEmptyWeightMetric() {
		return emptyWeightMetric;
	}

	public BoxDTO setEmptyWeightMetric(double emptyWeightMetric) {
		this.emptyWeightMetric = emptyWeightMetric;
		return this;
	}

	public double getEmptyWeightImperial() {
		return emptyWeightImperial;
	}

	public BoxDTO setEmptyWeightImperial(double emptyWeightImperial) {
		this.emptyWeightImperial = emptyWeightImperial;
		return this;
	}

	public Boolean getUseInAlgorithm() {
		return useInAlgorithm;
	}

	public BoxDTO setUseInAlgorithm(Boolean useInAlgorithm) {
		this.useInAlgorithm = useInAlgorithm;
		return this;
	}

	public Boolean getRealtimeUse() {
		return realtimeUse;
	}

	public BoxDTO setRealtimeUse(Boolean realtimeUse) {
		this.realtimeUse = realtimeUse;
		return this;
	}

	public String getCurrentUnit() {
		return currentUnit;
	}

	public BoxDTO setCurrentUnit(String currentUnit) {
		this.currentUnit = currentUnit;
		return this;
	}

	public Boolean getDefaultBox() {
		return defaultBox;
	}

	public BoxDTO setDefaultBox(Boolean defaultBox) {
		this.defaultBox = defaultBox;
		return this;
	}

	public double getInsuranceAmount() {
		return insuranceAmount;
	}

	public BoxDTO setInsuranceAmount(double insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
		return this;
	}

	public double getProductWeightImperial() {
		return productWeightImperial;
	}

	public BoxDTO setProductWeightImperial(double productWeightImperial) {
		this.productWeightImperial = productWeightImperial;
		return this;
	}

	public double getProductWeightMetric() {
		return productWeightMetric;
	}

	public BoxDTO setProductWeightMetric(double productWeightMetric) {
		this.productWeightMetric = productWeightMetric;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public BoxDTO setDescription(String description) {
		this.description = ClickshipStringUtil.truncateString(description, 249);
		return this;
	}

	public String getNmfcCode() {
		return StringUtils.isNotBlank(nmfcCode) ? nmfcCode : "";
	}

	public BoxDTO setNmfcCode(String nmfcCode) {
		this.nmfcCode = nmfcCode;
		return this;
	}

	public String getFreightClass() {
		return freightClass;
	}

	public BoxDTO setFreightClass(String freightClass) {
		this.freightClass = freightClass;
		return this;
	}

	public String getType() {
		return type;
	}

	public BoxDTO setType(String type) {
		this.type = type;
		return this;
	}

	public String getPieces() {
		return pieces;
	}

	public BoxDTO setPieces(String pieces) {
		this.pieces = pieces;
		return this;
	}

	public BoxDTO setLengthType(double length) {
		if (length != 0) {
			if (ClickShipConstants.UNIT_METRIC.equals(this.currentUnit)) {
				this.lengthMetric = length;
				this.lengthImperial = length / INCH_TO_CM;
			} else {
				this.lengthMetric = length * INCH_TO_CM;
				this.lengthImperial = length;
			}
		}
		return this;
	}

	public BoxDTO setHeightType(double height) {
		if (height != 0) {
			if (ClickShipConstants.UNIT_METRIC.equals(this.currentUnit)) {
				this.heightMetric = height;
				this.heightImperial = height / INCH_TO_CM;
			} else {
				this.heightMetric = height * INCH_TO_CM;
				this.heightImperial = height;
			}
		}
		return this;
	}

	public BoxDTO setWidthType(double width) {
		if (width != 0) {
			if (ClickShipConstants.UNIT_METRIC.equals(this.currentUnit)) {
				this.widthMetric = width;
				this.widthImperial = width / INCH_TO_CM;
			} else {
				this.widthMetric = width * INCH_TO_CM;
				this.widthImperial = width;
			}
		}
		return this;
	}

	public BoxDTO setWeightType(double weight) {
		if (weight != 0) {
			if (ClickShipConstants.UNIT_METRIC.equals(this.currentUnit)) {
				this.emptyWeightMetric = weight;
				this.emptyWeightImperial = KG_TO_POUND * weight;
			} else {
				this.emptyWeightMetric = weight / KG_TO_POUND;
				this.emptyWeightImperial = weight;
			}
		}
		return this;
	}

	public BoxDTO setProductWeightType(double weight) {
		if (weight != 0) {
			if (ClickShipConstants.UNIT_METRIC.equals(this.currentUnit)) {
				this.productWeightMetric = weight;
				this.productWeightImperial = KG_TO_POUND * weight;
			} else {
				this.productWeightMetric = weight / KG_TO_POUND;
				this.productWeightImperial = weight;
			}
		}
		return this;
	}

	@JsonIgnore
	public double getHeight() {
		return ClickShipConstants.UNIT_METRIC.equals(this.currentUnit) ? heightMetric : heightImperial;
	}

	@JsonIgnore
	public double getWidth() {
		return ClickShipConstants.UNIT_METRIC.equals(this.currentUnit) ? widthMetric : widthImperial;
	}

	@JsonIgnore
	public double getLength() {
		return ClickShipConstants.UNIT_METRIC.equals(this.currentUnit) ? lengthMetric : lengthImperial;
	}

	@JsonIgnore
	public double getWeight() {
		return ClickShipConstants.UNIT_METRIC.equals(this.currentUnit) ? emptyWeightMetric : emptyWeightImperial;
	}

	@JsonIgnore
	public double getProductWeight() {
		return ClickShipConstants.UNIT_METRIC.equals(this.currentUnit) ? productWeightMetric : productWeightImperial;
	}
	
	@JsonIgnore
	public double getTotalWeight() {
		return emptyWeightImperial + productWeightImperial;
	}

	public BoxDTO check(BoxDTO box) {
		if ("imperial".equalsIgnoreCase(box.getCurrentUnit())) {
			if (box.getEmptyWeightMetric() == 0.0 && box.getEmptyWeightImperial() > 0.0) {
				box.setWeightType(box.getEmptyWeightImperial());
			}
			if (box.getProductWeightMetric() == 0.0 && box.getProductWeightImperial() > 0.0) {
				box.setProductWeightType(box.getProductWeightImperial());
			}
			if (box.getLengthMetric() == 0.0 && box.getLengthImperial() > 0.0) {
				box.setLengthType(box.getLengthImperial());
			}
			if (box.getWidthMetric() == 0.0 && box.getLengthImperial() > 0.0) {
				box.setWidthType(box.getWidthImperial());
			}
			if (box.getHeightMetric() == 0.0 && box.getHeightImperial() > 0.0) {
				box.setHeightType(box.getHeightImperial());
			}
		} else if ("metric".equalsIgnoreCase(box.getCurrentUnit())) {
			if (box.getEmptyWeightImperial() == 0.0 && box.getEmptyWeightMetric() > 0.0) {
				box.setWeightType(box.getEmptyWeightMetric());
			}
			if (box.getProductWeightImperial() == 0.0 && box.getProductWeightMetric() > 0.0) {
				box.setProductWeightType(box.getProductWeightMetric());
			}
			if (box.getLengthImperial() == 0.0 && box.getLengthMetric() > 0.0) {
				box.setLengthType(box.getLengthMetric());
			}
			if (box.getWidthImperial() == 0.0 && box.getWidthMetric() > 0.0) {
				box.setWidthType(box.getWidthMetric());
			}
			if (box.getHeightImperial() == 0.0 && box.getHeightMetric() > 0.0) {
				box.setHeightType(box.getHeightMetric());
			}
		}
		return box;
	}
	
	public Boolean getSmartBoxWorked() {
		return smartBoxWorked;
	}

	public BoxDTO setSmartBoxWorked(Boolean smartBoxWorked) {
		this.smartBoxWorked = smartBoxWorked;
		return this;
	}

	public List<ProductDisplayDTO> getProductsInfo() {
		return productsInfo;
	}

	public BoxDTO setProductsInfo(List<ProductDisplayDTO> productsInfo) {
		this.productsInfo = productsInfo;
		return this;
	}

	public String getCustomBoxDescription() {
		return customBoxDescription;
	}

	public BoxDTO setCustomBoxDescription(String customBoxDescription) {
		this.customBoxDescription = customBoxDescription;
		return this;
	}

	public Boolean getSpecialHandlingRequired() {
		return specialHandlingRequired;
	}

	public BoxDTO setSpecialHandlingRequired(Boolean specialHandlingRequired) {
		this.specialHandlingRequired = specialHandlingRequired;
		return this;
	}

}