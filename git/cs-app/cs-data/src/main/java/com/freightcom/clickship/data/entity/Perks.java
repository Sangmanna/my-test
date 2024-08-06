package com.freightcom.clickship.data.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "perks")
public class Perks extends BaseEntity {

	private static final long serialVersionUID = -5149448470213771897L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@Column(name = "perk_name", nullable = false)
	private String perkName;

	@Column(name = "perk_description", nullable = false)
	private String perkDescription;

	@Column(name = "perk_image", nullable = false)
	private String perkImage;

	@Column(name = "perk_status", nullable = false)
	private Boolean perkStatus;

	@Column(name = "perk_start_date", nullable = false)
	private Date perkStartDate;

	@Column(name = "perk_end_date", nullable = false)
	private Date perkEndDate;

	@Column(name = "tagline")
	private String tagline;

	@Column(name = "category")
	private String category;

	@Column(name = "url")
	private String url;

	@Column(name = "banner_image")
	private String bannerImage;

	@Column(name = "business_details")
	private String businessDetails;

	@Column(name = "sequence")
	private Integer sequence;
	
	@Column(name = "is_new")
	private Boolean isNew;

	public String getId() {
		return id;
	}

	public BaseEntity setId(String id) {
		this.id = id;
		return this;
	}

	public String getPerkName() {
		return perkName;
	}

	public Perks setPerkName(String perkName) {
		this.perkName = perkName;
		return this;
	}

	public String getPerkDescription() {
		return perkDescription;
	}

	public Perks setPerkDescription(String perkDescription) {
		this.perkDescription = perkDescription;
		return this;
	}

	public String getPerkImage() {
		return perkImage;
	}

	public Perks setPerkImage(String perkImage) {
		this.perkImage = perkImage;
		return this;
	}

	public Boolean getPerkStatus() {
		return perkStatus;
	}

	public Perks setPerkStatus(Boolean perkStatus) {
		this.perkStatus = perkStatus;
		return this;
	}

	public Date getPerkStartDate() {
		return perkStartDate;
	}

	public Perks setPerkStartDate(Date perkStartDate) {
		this.perkStartDate = perkStartDate;
		return this;
	}

	public Date getPerkEndDate() {
		return perkEndDate;
	}

	public Perks setPerkEndDate(Date perkEndDate) {
		this.perkEndDate = perkEndDate;
		return this;
	}
	
	public String getTagline() {
		return tagline;
	}

	public Perks setTagline(String tagline) {
		this.tagline = tagline;
		return this;
	}

	public String getCategory() {
		return category;
	}

	public Perks setCategory(String category) {
		this.category = category;
		return this;
	}

	public String getUrl() {
		return url;
	}

	public Perks setUrl(String url) {
		this.url = url;
		return this;
	}

	public String getBannerImage() {
		return bannerImage;
	}

	public Perks setBannerImage(String bannerImage) {
		this.bannerImage = bannerImage;
		return this;
	}

	public String getBusinessDetails() {
		return businessDetails;
	}

	public Perks setBusinessDetails(String businessDetails) {
		this.businessDetails = businessDetails;
		return this;
	}

	public Integer getSequence() {
		return sequence;
	}

	public Perks setSequence(Integer sequence) {
		this.sequence = sequence;
		return this;
	}

	public Boolean getIsNew() {
		return isNew;
	}

	public void setIsNew(Boolean isNew) {
		this.isNew = isNew;
	}
}
