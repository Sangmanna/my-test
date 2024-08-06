package com.freightcom.clickship.model.constants;

public class ClickShipConstants {
	
	private ClickShipConstants() {
		super();
	}
	
	public static final String KG = "kg";
	public static final String CM = "cm";
	public static final String LBS = "lbs";
	public static final String INCHES = "inches";
	public static final double INCH_TO_CM = 2.54;
	public static final double KG_TO_POUND = 2.2046;
	public static final String UNIT_METRIC = "Metric";
	public static final String UNIT_IMPERIAL = "Imperial";
	
	public static final String QUOTE_TYPE = "Quote";
	public static final String QUOTE_STATUS_TYPE = "Quoted";
	public static final String STORE_SHIPMENT_TYPE = "Store";
	public static final String RETURN_SHIPMENT_TYPE = "Return";
	public static final String MANUAL_SHIPMENT_TYPE = "Manual";
	public static final String DEFAULT_TEMP_BOX_ID_NAME = "DEFAULTBOX-1";

	public static final String CS_SIGNUP_SOURCE = "CS";
	public static final String FC_SIGNUP_SOURCE = "FC-CS";
	public static final String FAKE_FC_USER_EMAIL = "test@test.com";
	public static final String LOGIN_TOKEN_EXPIRED = "LOGIN_TOKEN_EXPIRED";
	public static final String ROLE_VENDASTA_CUSTOMER = "VENDASTA_CUSTOMER";
	
	public static final boolean AUTO_COLLECTION_ON = true;
	public static final boolean AUTO_COLLECTION_OFF = false;
	
	public static final String CS_PALLET_CARRIER = "CS04";
	
	//LOGIN ERRORS
	public static final String NO_ACCOUNT = "NO_ACCOUNT";
	public static final String INVALID_ACCESS = "INVALID_ACCESS";
	public static final String ERR_INVALID_TOKEN = "INVALID_TOKEN";
	public static final String WRONG_PASSWORD_EXCEED = "WRONG_PASSWORD_EXCEED";
	public static final String ERR_EXCEED_FREE_QUOTE_WITHOUT_BILLINGINFO = "EXCEED_FREE_QUOTE_WITHOUT_BILLINGINFO";
	public static final String USER_DEACTIVATED = "USER_DEACTIVATED";
	public static final String USER_DELETED = "USER_DELETED";
	
	// ONBOARDING ERRORS
	public static final String ERR_CODE_EXISTING_EMAIL = "EXISTING_EMAIL";
	public static final String ERR_CODE_EXISTING_USERNAME = "EXISTING_USERNAME";
	public static final String ERR_CODE_EXISTING_BUSINESS_NAME = "EXISTING_BUSINESS_NAME";
	
	public static final double FEET_TO_INCH = 12;
	public static final double FEET_TO_CM = 30.48;
	public static final double OUNCE_TO_KG = 35.274;
	public static final double OUNCE_TO_POUND = 16;
	
	public static final String POUNDS = "pounds";
	public static final String CENTIMETERS = "centimeters";
	public static final String FEET = "feet";
	public static final String KILOGRAMS = "kilograms";
	public static final String OUNCES = "ounces";
	
	public static final String UNIT_FEET = "Feet";
	
	public static final long STORE_TYPE_SHOPIFY = 1;
	public static final String SHOPIFY_CARRIER_SERVICE_NAME = "Clickship Rates";
	
	public static final String ROLE_CUSTOMER = "customer";

	public static final String HEADER_REQUEST_ID = "RequestId";
	public static final String MDC_FIELD_MARKETPLACE_TYPE="MarketplaceType";
	public static final String MDC_FIELD_MARKETPLACE_NAME="MarketplaceName";
	public static final String MDC_FIELD_BUSINESS_NAME="BusinessName";
	public static final String MDC_FIELD_MARKETPLACE_URL="MarketplaceUrl";
	public static final String MDC_FIELD_CARRIER_NAME="CarrierName";
	public static final String MDC_FIELD_CARRIER_SERVICE="CarrierService";
	public static final String UNIQUE_DATA_SEPERATOR="\\(\\^\\)";
	public static final String RTR_CARRIER_ID_SEPERATOR="&";
	public static final String AMAZON_DRAFT_APP_MIGRATION = "AMZNDRAFTAPPMIGRATION";
	public static final String SHIPPING_RULE_PENDING_ORDERS_ERR = "AutoFulfillment Skipped : Order is in pending status!";
	public static final long THREAD_SLEEP_500 = 500;
	public static final long THREAD_SLEEP_1000 = 1000;

	public static final String EMAIL_REGEX_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
			+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	public static final String PHIONE_NUMBER_REGEX_PATTERN = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$" 
		      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$" 
		      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
}
