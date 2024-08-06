package com.freightcom.clickship.model.marketplace.shopify;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyProduct implements Serializable {

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
	private ShopifyProductImage image;
	
	@JsonProperty("variants")
	private List<ShopifyVariant> variants;
	
	@JsonProperty("images")
	private List<ShopifyProductImage> images;

	public Long getId() {
		return id;
	}

	public ShopifyProduct setId(Long id) {
		this.id = id;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public ShopifyProduct setTitle(String title) {
		this.title = title;
		return this;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public ShopifyProduct setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
		return this;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public ShopifyProduct setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
		return this;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public ShopifyProduct setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
		return this;
	}
	
	public ShopifyProductImage getImage() {
		return image;
	}

	public ShopifyProduct setImage(ShopifyProductImage image) {
		this.image = image;
		return this;
	}

	public List<ShopifyVariant> getVariants() {
		return variants;
	}

	public ShopifyProduct setVariants(List<ShopifyVariant> variants) {
		this.variants = variants;
		return this;
	}

	public List<ShopifyProductImage> getImages() {
		return images;
	}

	public ShopifyProduct setImages(List<ShopifyProductImage> images) {
		this.images = images;
		return this;
	}
	
}
