package com.freightcom.clickship.data.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "promo")
public class Promo extends BaseEntity {

	private static final long serialVersionUID = 3544799665082227907L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@Column(name = "promo_code")
	private String promoCode;

	@Column(name = "promo_name")
	private String promoName;

	@Column(name = "promo_description")
	private String promoDescription;

	@Column(name = "promo_type")
	private String promoType;

	@Column(name = "promo_start_datetime")
	private Date promoStartDatetime;

	@Column(name = "promo_end_datetime")
	private Date promoEndDatetime;

	@Column(name = "discount_percentage")
	private Double discountPercentage;

	@Column(name = "discount_amount")
	private Double discountAmount;

	@Column(name = "discount_on")
	private String discountOn;

	@Column(name = "can_combo")
	private Boolean canCombo;

	public String getPromoCode() {
		return promoCode;
	}

	public Promo setPromoCode(String promoCode) {
		this.promoCode = promoCode;
		return this;
	}

	public String getPromoName() {
		return promoName;
	}

	public Promo setPromoName(String promoName) {
		this.promoName = promoName;
		return this;
	}

	public String getPromoDescription() {
		return promoDescription;
	}

	public Promo setPromoDescription(String promoDescription) {
		this.promoDescription = promoDescription;
		return this;
	}

	public String getPromoType() {
		return promoType;
	}

	public Promo setPromoType(String promoType) {
		this.promoType = promoType;
		return this;
	}

	public Date getPromoStartDatetime() {
		return promoStartDatetime;
	}

	public Promo setPromoStartDatetime(Date promoStartDatetime) {
		this.promoStartDatetime = promoStartDatetime;
		return this;
	}

	public Date getPromoEndDatetime() {
		return promoEndDatetime;
	}

	public Promo setPromoEndDatetime(Date promoEndDatetime) {
		this.promoEndDatetime = promoEndDatetime;
		return this;
	}

	public Double getDiscountPercentage() {
		return discountPercentage;
	}

	public Promo setDiscountPercentage(Double discountPercentage) {
		this.discountPercentage = discountPercentage;
		return this;
	}

	public Double getDiscountAmount() {
		return discountAmount;
	}

	public Promo setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
		return this;
	}

	public String getDiscountOn() {
		return discountOn;
	}

	public Promo setDiscountOn(String discountOn) {
		this.discountOn = discountOn;
		return this;
	}

	public Boolean getCanCombo() {
		return canCombo;
	}

	public Promo setCanCombo(Boolean canCombo) {
		this.canCombo = canCombo;
		return this;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public BaseEntity setId(String id) {
		this.id = id;
		return this;
	}

}
