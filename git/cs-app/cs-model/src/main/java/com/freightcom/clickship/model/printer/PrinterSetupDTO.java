package com.freightcom.clickship.model.printer;

public class PrinterSetupDTO {

	private String id;
	
	private String labelType;
	
	private String labelName;
	
	private String labelSize;
	
	private String printerName;
	
	private Double width;
	
	private Double height;
	
	private String unitOfMeasure;
	
	private AutoPrintDTO autoPrint;

	public String getId() {
		return id;
	}

	public PrinterSetupDTO setId(String id) {
		this.id = id;
		return this;
	}

	public String getLabelType() {
		return labelType;
	}

	public PrinterSetupDTO setLabelType(String labelType) {
		this.labelType = labelType;
		return this;
	}

	public String getLabelName() {
		return labelName;
	}

	public PrinterSetupDTO setLabelName(String labelName) {
		this.labelName = labelName;
		return this;
	}

	public String getLabelSize() {
		return labelSize;
	}

	public PrinterSetupDTO setLabelSize(String labelSize) {
		this.labelSize = labelSize;
		return this;
	}

	public String getPrinterName() {
		return printerName;
	}

	public PrinterSetupDTO setPrinterName(String printerName) {
		this.printerName = printerName;
		return this;
	}

	public Double getWidth() {
		return width;
	}

	public PrinterSetupDTO setWidth(Double width) {
		this.width = width;
		return this;
	}

	public Double getHeight() {
		return height;
	}

	public PrinterSetupDTO setHeight(Double height) {
		this.height = height;
		return this;
	}

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public PrinterSetupDTO setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
		return this;
	}

	public AutoPrintDTO getAutoPrint() {
		return autoPrint;
	}

	public PrinterSetupDTO setAutoPrint(AutoPrintDTO autoPrint) {
		this.autoPrint = autoPrint;
		return this;
	}
	
}
