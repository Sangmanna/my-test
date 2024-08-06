package com.freightcom.clickship.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "validation")
public class Validation extends BaseEntity {
	
	private static final long serialVersionUID = 7536290268800418863L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@Column(name = "endpoint_uri", nullable = false)
	private String endpointUri;

	@Column(name = "form_name", nullable = false)
	private String formName;

	@Column(name = "field_name", nullable = false)
	private String fieldName;

	@Column(name = "required")
	private Boolean required = false;

	@Column(name = "max_len")
	private Integer maxLen = 0;

	@Column(name = "min_len")
	private Integer minLen = 0;

	@Column(name = "reg_exp")
	private String regExp = null;

	@Column(name = "js_reg_exp")
	private String jsRegExp = null;

	@Column(name = "reg_exp_msg")
	private String regExpMsg = null;

	@Column(name = "isemail")
	private Boolean isEmail = false;

	@Column(name = "isphone")
	private Boolean isPhone = false;

	public String getId() {
		return id;
	}

	public BaseEntity setId(String id) {
		this.id = id;
		return this;
	}

	public String getEndpointUri() {
		return endpointUri;
	}

	public Validation setEndpointUri(String endpointUri) {
		this.endpointUri = endpointUri;
		return this;
	}

	public String getFormName() {
		return formName;
	}

	public Validation setFormName(String formName) {
		this.formName = formName;
		return this;
	}

	public Boolean isRequired() {
		return required;
	}

	public Validation setRequired(Boolean required) {
		this.required = required;
		return this;
	}

	public Integer getMaxLen() {
		return maxLen;
	}

	public Validation setMaxLen(Integer maxLen) {
		this.maxLen = maxLen;
		return this;
	}

	public Integer getMinLen() {
		return minLen;
	}

	public Validation setMinLen(Integer minLen) {
		this.minLen = minLen;
		return this;
	}

	public String getRegExp() {
		return regExp;
	}

	public Validation setRegExp(String regExp) {
		this.regExp = regExp;
		return this;
	}

	public String getFieldName() {
		return fieldName;
	}

	public Validation setFieldName(String fieldName) {
		this.fieldName = fieldName;
		return this;
	}

	public String getJsRegExp() {
		return jsRegExp;
	}

	public Validation setJsRegExp(String jsRegExp) {
		this.jsRegExp = jsRegExp;
		return this;
	}

	public String getRegExpMsg() {
		return regExpMsg;
	}

	public Validation setRegExpMsg(String regExpMsg) {
		this.regExpMsg = regExpMsg;
		return this;
	}

	public Boolean isEmail() {
		return isEmail;
	}

	public Validation setEmail(Boolean isEmail) {
		this.isEmail = isEmail;
		return this;
	}

	public Boolean isPhone() {
		return isPhone;
	}

	public Validation setPhone(Boolean isPhone) {
		this.isPhone = isPhone;
		return this;
	}
}