package com.freightcom.clickship.model.jpa;

public class JpaEvent<T> {

	private String id;
	
	private String type;

	private String action;

	private T data;

	public String getId() {
		return id;
	}

	public JpaEvent<T> setId(String id) {
		this.id = id;
		return this;
	}

	public String getType() {
		return type;
	}

	public JpaEvent<T> setType(String type) {
		this.type = type;
		return this;
	}

	public String getAction() {
		return action;
	}

	public JpaEvent<T> setAction(String action) {
		this.action = action;
		return this;
	}

	public T getData() {
		return data;
	}

	public JpaEvent<T> setData(T data) {
		this.data = data;
		return this;
	}

	@Override
	public String toString() {
		return "JpaEvent ==> {\"id\":\"" + id + "\", \"type\":\"" + type + "\", \"action\":\"" + action + "\", \"data\":\"" + data + "\"]";
	}
	
}
