package com.freightcom.clickship.model.marketplace.reebelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReebeloProduct implements Serializable {

	private static final long serialVersionUID = 8585476807754401663L;

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("created_at")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date createdDate;
	
	@JsonProperty("updated_at")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date updatedDate;
	
	@JsonProperty("published_at")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date publishedDate;
	
	@JsonProperty("image")
	private ReebeloProductImage image;
	
	@JsonProperty("variants")
	private List<ReebeloVariant> variants;
	
	@JsonProperty("images")
	private List<ReebeloProductImage> images;

	public Long getId() {
		return id;
	}

	public ReebeloProduct setId(Long id) {
		this.id = id;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public ReebeloProduct setTitle(String title) {
		this.title = title;
		return this;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public ReebeloProduct setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
		return this;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public ReebeloProduct setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
		return this;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public ReebeloProduct setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
		return this;
	}
	
	public ReebeloProductImage getImage() {
		return image;
	}

	public ReebeloProduct setImage(ReebeloProductImage image) {
		this.image = image;
		return this;
	}

	public List<ReebeloVariant> getVariants() {
		return variants;
	}

	public ReebeloProduct setVariants(List<ReebeloVariant> variants) {
		this.variants = variants;
		return this;
	}

	public List<ReebeloProductImage> getImages() {
		return images;
	}

	public ReebeloProduct setImages(List<ReebeloProductImage> images) {
		this.images = images;
		return this;
	}
	
}
