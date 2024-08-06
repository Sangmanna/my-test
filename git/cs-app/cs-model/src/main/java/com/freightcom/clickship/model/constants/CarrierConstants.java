package com.freightcom.clickship.model.constants;

import java.util.Arrays;
import java.util.List;

import com.freightcom.clickship.model.enums.CarrierName;

public class CarrierConstants {
	public static final List<String> ACTIVATION_REQUIRED_CARRIERS = Arrays.asList(CarrierName.LOOMIS.getDisplayName(), CarrierName.DHL_ECOMMERCE.getDisplayName(), CarrierName.KINDERSLEY_TRANSPORT.getDisplayName());
}
