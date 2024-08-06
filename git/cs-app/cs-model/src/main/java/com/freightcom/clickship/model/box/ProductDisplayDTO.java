package com.freightcom.clickship.model.box;

import java.io.Serializable;

import com.freightcom.clickship.model.CommonDTO;

public class ProductDisplayDTO extends CommonDTO implements Serializable{

	private static final long serialVersionUID = 7108603840555493426L;

	private String id;
	
	private String sku;
	
	private String title;
	
	private int quantity;

	private String imageUrl;
	
	private double unitPrice;
	
	private double length;

	private double width;

	private double height;
	
	private double weight;

	private double lengthMetric;

	private double widthMetric;

	private double heightMetric;
	
	private double weightMetric;

	private boolean customBox;
	
	private String unitsOfMeasure;

	//CP-521
	private String description;
	
	public ProductDisplayDTO() {
		super();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getWeightMetric() {
		return weightMetric;
	}

	public void setWeightMetric(double weightMetric) {
		this.weightMetric = weightMetric;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getLengthMetric() {
		return lengthMetric;
	}

	public void setLengthMetric(double lengthMetric) {
		this.lengthMetric = lengthMetric;
	}

	public double getWidthMetric() {
		return widthMetric;
	}

	public void setWidthMetric(double widthMetric) {
		this.widthMetric = widthMetric;
	}

	public double getHeightMetric() {
		return heightMetric;
	}

	public void setHeightMetric(double heightMetric) {
		this.heightMetric = heightMetric;
	}

	public boolean isCustomBox() {
		return customBox;
	}

	public void setCustomBox(boolean customBox) {
		this.customBox = customBox;
	}

	public String getUnitsOfMeasure() {
		return unitsOfMeasure;
	}

	public void setUnitsOfMeasure(String unitsOfMeasure) {
		this.unitsOfMeasure = unitsOfMeasure;
	}
	
}
