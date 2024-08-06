package com.freightcom.clickship.model.orderscsv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.freightcom.clickship.model.KeyValue;

public class CSVImportDto {

	Map<String, ImportCSVOrder> successOrderMap = new HashMap<>();
	Map<String, ImportCSVOrder> failureOrderMap = new HashMap<>();

	private List<KeyValue> errorMsgs = new ArrayList<>();

	public List<KeyValue> getErrorMsgs() {
		return errorMsgs;
	}

	public CSVImportDto setErrorMsgs(List<KeyValue> errorMsgs) {
		this.errorMsgs = errorMsgs;
		return this;
	}

	public void addErrorMsg(KeyValue errorMsg) {
		this.errorMsgs.add(errorMsg);
	}

	public Map<String, ImportCSVOrder> getSuccessOrderMap() {
		return successOrderMap;
	}

	public void setSuccessOrderMap(Map<String, ImportCSVOrder> successOrderMap) {
		this.successOrderMap = successOrderMap;
	}

	public Map<String, ImportCSVOrder> getFailureOrderMap() {
		return failureOrderMap;
	}

	public void setFailureOrderMap(Map<String, ImportCSVOrder> failureOrderMap) {
		this.failureOrderMap = failureOrderMap;
	}

}
