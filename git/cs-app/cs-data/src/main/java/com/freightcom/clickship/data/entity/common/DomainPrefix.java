package com.freightcom.clickship.data.entity.common;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class DomainPrefix {
	
	public static final String UNDEFINED_DOMAIN = "UD";
	public static final String UNDEFINED_DOMAIN_QUOTE = "QT";

	private static Map<String, String> map = new HashMap<String, String>() {
		private static final long serialVersionUID = 4265360385811606744L;
		{
			put("ORDERLINE", "OI");
			put("USER", "US");
			put("MARKETPLACETYPE", "ST");
			put("MARKETPLACE", "SP");
			put("SHIPMENT", "SM");
			put("PACKAGE", "PK");
			put("CARRIERACCOUNT", "CC");
			put("CARRIER", "CR");
			put("PICKUP", "PP");
			put("ORDER", "OD");
			put("PROMO", "PM");
			put("INVOICE", "IC");
			put("CUSTOMER", "CS");
			put("CONTACT", "CT");
			put("VALIDATION", "VD");
			put("CODE", "CD");
			put("USERSHOPSETTINGOPTION", "UO");
			put("USERSHOPSETTING", "SS");
			put("USERSETTING", "US");
			put("BOX", "BX");
			put("CUSTOMERADDRESS", "CA");
			put("ADDRESS", "AD");
			put("PROPERTIES", "PO");
			put("SHOPIFYWEBHOOKS", "SW");
			put("PAYMENTDETAIL", "PD");
			put("INSURANCE", "IS");
			put("FEE", "FE");
			put("MARKETPLACEPRODUCT", "MP");
			put("CUSTOMERADDRESSUNUSED", "AU");
			put("USERUNUSED", "UU");
			put("USERACCESS", "UA");
			put("MARKETPLACEADDRESS", "MA");
			put("SMTPEMAIL", "EM");
			put("CUSTOMERSUBPLAN", "CP");
			put("NOTIFICATIONS", "NO");
			put("MARKETPLACESETTING", "MS");
			put("CUSTOMERCARRIERPREFERENCE", "FC");
			put("NETTERMCUSTOMER", "NT");
			put("CUSTOMINVOICEDETAIL", "CI");
			put("MARKETPLACEINTEGRATIONFAILURES", "MF");
			put("EXCHANGERATE", "EX");
			put("RATECOMPARISON", "RC");
			put("RETURNLABEL", "RL");
			put("SHOPIFYWEBHOOKSFAILURE", "WF");
			put("PRICEMARKUPHISTORY", "PH");
			put("TAX", "TX");
			put("DISCOUNT", "DC");
			put("ORDERLINEDISCOUNT", "OT");
			put("ADDRESSBOOK", "AB");
			put("CARRIERTRACKINGSTATUS", "TS");
			put("SHIPMENTADDITIONALSERVICES", "AS");
			put("ORDERNOTES", "ON");
			put("MARKETPLACEPRODUCTMULTIBOX", "UD");
			put("ONBOARDING", "OB");
			put("CUSTOMER_DETAIL", "CE");
			put("CUSTOMERPERK", "CSP");
			put("BULKSHIPMENT", "BU");
			put("BATCHSHIPMENT", "BP");
			put("PREFETCHQUOTEREQUEST", "QR");
			put("PREFETCHQUOTEPACKAGES", "QP");
			put("PREFETCHQUOTES", "PQ");
			put("PREFETCHQUOTECHARGES", "QC");
			put("TAG", "TG");
			put("TAGLINK", "TL");
			put("AUTOPRINT", "AP");
			put("PRINTERSETUP", "PS");
			put("PRINTERHISTORY", "PH");
			put("ORDERLINESINGLESKUMULTIBOX","OS");
			put("CSVORDERIMPORTREQUESTS","CO");
			put("PICKUPPREFERENCE","PR");
			put("TRANSLATION","TR");
			put("JWT","JW");
			put("CUSTOMERNOTICE", "CN");
			put("PRINTINGPREFERENCE","PE");
			put("PALLETSERVICES","PS");
			put("SHIPPINGPREFERENCE","SP");
			put("DONTASKMEAGAIN","DA");
			put("ADVANCEDSHIPPINGRULE","SR");
			put("ADVSHIPPINGRULECONDITION","RC");
			put("ADVSHIPPINGRULEACTION","RA");
			put("SHIPPINGRULEADDITIONALOPTIONS","AO");
			put("SHIPPINGRULEMARKETPLACE","RM");
			put("SHIPPINGRULECARRIER","RC");
			put("SHIPPINGRULEBOX","RB");
			put("CUSTOMERHISTORY", "CH");
			put("VETTINGPROCESS", "VP");
			put("ADDRESSBOOKPALLETPREFERENCE", "DP");
			put("COURIERBROKERPREFERENCES", "CB");
		}
	};

	public static String getPrefix(String key) {
		String prefix = map.get(key);
		if (StringUtils.isEmpty(prefix)) {
			prefix = UNDEFINED_DOMAIN;
		}
		return prefix;
	}
	
}
