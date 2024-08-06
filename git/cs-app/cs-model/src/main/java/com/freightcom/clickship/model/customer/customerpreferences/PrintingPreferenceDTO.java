package com.freightcom.clickship.model.customer.customerpreferences;

import java.io.Serializable;

import com.freightcom.clickship.model.CommonDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PrintingPreferenceDTO extends CommonDTO implements Serializable {
	static final long serialVersionUID = 6027263633082738527L;

	String picklistSortby;
	boolean picklistIncludeProductImage = true;
	boolean picklistIncludeOrderNumber = false;
	boolean packingSlipThermalLabels;
	String packingSlipSortBy;
	boolean packingSlipIncludeProductImage;
	boolean packingSlipIncludeSku;
	boolean packingSlipIncludePrice;
	boolean packingSlipIncludeShipDate;
	boolean packingSlipIncludeShippingMethod;
	String packingSlipCustomMessage;
}
