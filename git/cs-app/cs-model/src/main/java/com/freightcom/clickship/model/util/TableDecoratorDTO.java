package com.freightcom.clickship.model.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The DTO to handle pagination/sorting
 * 
 */
public class TableDecoratorDTO implements Serializable {
	
	private static final long serialVersionUID = -4392783548353866346L;

	private int totalCnt;
	
	private int pageSize;
	
	private int currentPage;
	
	private String tableName;
	
	private String sortColName;
	
	private String sortDirection;
	
	private boolean conditionChanged;
	
	private Map<String, String> filter = new HashMap<>();
	
	private transient Map<String, Object> condition = new HashMap<>();
	
	private Map<String, List<String>> ordercondition = new HashMap<>();

	public int getTotalCnt() {
		return totalCnt;
	}

	public TableDecoratorDTO setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
		return this;
	}

	public int getPageSize() {
		return pageSize;
	}

	public TableDecoratorDTO setPageSize(int pageSize) {
		this.pageSize = pageSize;
		return this;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public TableDecoratorDTO setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		return this;
	}

	public String getSortColName() {
		return sortColName;
	}

	public TableDecoratorDTO setSortColName(String sortColName) {
		this.sortColName = sortColName;
		return this;
	}

	public String getSortDirection() {
		return sortDirection;
	}

	public TableDecoratorDTO setSortDirection(String sortDirection) {
		this.sortDirection = sortDirection;
		return this;
	}

	public Map<String, String> getFilter() {
		return filter;
	}

	public TableDecoratorDTO setFilter(Map<String, String> filter) {
		this.filter = filter;
		return this;
	}

	public Map<String, Object> getCondition() {
		return condition;
	}

	public TableDecoratorDTO setCondition(Map<String, Object> condition) {
		this.condition = condition;
		return this;
	}

	public String getTableName() {
		return tableName;
	}

	public TableDecoratorDTO setTableName(String tableName) {
		this.tableName = tableName;
		return this;
	}
	
	public boolean isConditionChanged() {
		return conditionChanged;
	}

	public void setConditionChanged(boolean conditionChanged) {
		this.conditionChanged = conditionChanged;
	}
	
	public Map<String, List<String>> getOrdercondition() {
		return ordercondition;
	}
	
	@JsonProperty("orderCondition")
	public TableDecoratorDTO setOrdercondition(Map<String, List<String>> ordercondition) {
		this.ordercondition = ordercondition;
		return this;
	}
	
	public void addCondition(String key, Object value) {
		condition.put(key, value);
		this.conditionChanged = true;
	}
	
}
