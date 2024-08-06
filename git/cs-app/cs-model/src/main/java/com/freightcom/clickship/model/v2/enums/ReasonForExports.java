package com.freightcom.clickship.model.v2.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Values are provided by Kiran. 2022-06-17
 * 
 * @author sangmann
 *
 */
public enum ReasonForExports {
	// ReasonForExportGift means the ReasonForExport is a gift.

    ReasonForExportGift("gift"),

    // ReasonForExportRepairWarranty means the ReasonForExport is a repair warranty.

    ReasonForExportRepairWarranty("repair-warranty"),

    // ReasonForExportCommercialSample means the ReasonForExport is a commercial sample.

    ReasonForExportCommercialSample("commercial-sample"),

    // ReasonForExportReturnShipment means the ReasonForExport is a return shipment.

    ReasonForExportReturnShipment("return-shipment"),

    // ReasonForExportCommerciallySoldGoods means the ReasonForExport is commercially-sold goods.

    ReasonForExportCommerciallySoldGoods("commercially-sold-goods"),

    // ReasonForExportOther means the ReasonForExport is none of the above.

    ReasonForExportOther("other");
	
	private String value;

	private ReasonForExports() {
		this.value = name();
	}

	private ReasonForExports(String value) {
		this.value = value;
	}

	@JsonValue
	public String getValue() {
		return value;
	}

	public String toString() {
		return value;
	}
}
