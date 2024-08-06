package com.freightcom.clickship.model.enums;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

public enum TaxNames {

	TAX_GST_AB("tax-gst-ab", "GST AB"),
	TAX_GST_BC("tax-gst-bc", "GST BC"),
	TAX_GST_CUSTOMS("tax-gst-customs", "GST Customs"),
	TAX_GST_HV("tax-gst-hv", "GST HV"),
	TAX_GST_MB("tax-gst-mb", "GST MB"),
	TAX_GST_NT("tax-gst-nt", "GST NT"),
	TAX_GST_OR_HST("tax-gst-or-hst", "GST/HST"),
	TAX_GST_QC("tax-gst-qc", "GST QC"),
	TAX_GST_SK("tax-gst-sk", "GST SK"), 
	TAX_GST_YK("tax-gst-yk", "GST YK"),
	TAX_HST_HS("tax-hst-hs", "HST HS"), 
	TAX_HST_NB("tax-hst-nb", "HST NB"), 
	TAX_HST_NF("tax-hst-nf", "HST NF"),
	TAX_HST_NS("tax-hst-ns", "HST NS"),
	TAX_HST_ON("tax-hst-on", "HST ON"),
	TAX_HST_PEI("tax-hst-pei", "HST PEI"),
	TAX_PST_BC("tax-pst-bc", "PST BC"),
	TAX_PST_MB("tax-pst-mb", "PST MB"),
	TAX_PST_SK("tax-pst-sk", "PST SK"),
	TAX_QST_QC("tax-qst-qc", "QST QC"),
	TAX_VAT("tax-vat", "VAT");

	private final String name;
	private final String value;
	
	TaxNames(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	public static String getTaxValue(String name) {
		String value = "HST"; // default Tax Name
		
		Map<String, String> map = Stream.of(values()).collect(Collectors.toMap(k -> k.name, v -> v.value));
		if (StringUtils.isNotEmpty(name) && !map.isEmpty()) {
			value = map.get(name);
		}
		return value;
	}
}
