package com.freightcom.clickship.model.printer;

import java.util.List;

public class PrinterSettingsDTO {

	private AutoPrintDTO autoPrint;

	private List<PrinterSetupDTO> printerSetup;

	public AutoPrintDTO getAutoPrint() {
		return autoPrint;
	}

	public PrinterSettingsDTO setAutoPrint(AutoPrintDTO autoPrint) {
		this.autoPrint = autoPrint;
		return this;
	}

	public List<PrinterSetupDTO> getPrinterSetup() {
		return printerSetup;
	}

	public PrinterSettingsDTO setPrinterSetup(List<PrinterSetupDTO> printerSetup) {
		this.printerSetup = printerSetup;
		return this;
	}

}
