package com.freightcom.clickship.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CurrencyType {

	CAD("CAD"),
	AUD("AUD"),
	SGD("SGD"),
	CHF("CHF"),
	NOK("NOK"),
	SEK("SEK"),
	HKD("HKD"),
	JPY("JPY"),
	KRW("KRW"),
	ZAR("ZAR"),
	INR("INR"),
	PEN("PEN"),
	MXN("MXN"),
	SAR("SAR"),
	EUR("EUR"),
	TWD("TWD"),
	IDR("IDR"),
	VND("VND"),
	USD("USD"),
	BRL("BRL"),
	MYR("MYR"),
	GBP("GBP"),
	RUB("RUB"),
	TRY("TRY"),
	CNY("CNY"),
	NZD("NZD"),
	THB("THB"),
	AED("AED");
	
    private String value;
    
	private CurrencyType(){
		this.value = name();
	}

    private CurrencyType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
    
	public String toString() {
		return value;
	}
	
	public static final CurrencyType defaultCurrency = CurrencyType.CAD;
	
	public static CurrencyType getCurrency(String currencyStr) {
		CurrencyType result = null;
		try {
			result = CurrencyType.valueOf(currencyStr);
		} catch (Exception e) {
			return CurrencyType.defaultCurrency;
		}
		return result;
	}
}
