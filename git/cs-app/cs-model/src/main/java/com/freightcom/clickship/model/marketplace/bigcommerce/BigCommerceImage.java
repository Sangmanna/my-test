package com.freightcom.clickship.model.marketplace.bigcommerce;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BigCommerceImage {
	
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("product_id")
	private int productId;

	@JsonProperty("image_file")
	private String imageFile;
	
	@JsonProperty("is_thumbnail")
	private boolean isThumbNail;
	
	@JsonProperty("url_standard")
	private String urlStandrad;
	
	@JsonProperty("url_thumbnail")
	private String urlThumbNail;
	
	@JsonProperty("url_tiny")
	private String imageTiny;

	public String getImageFile() {
		return imageFile;
	}

	public BigCommerceImage setImageFile(String imageFile) {
		this.imageFile = imageFile;
		return this;
	}

	public boolean isThumbNail() {
		return isThumbNail;
	}

	public BigCommerceImage setThumbNail(boolean isThumbNail) {
		this.isThumbNail = isThumbNail;
		return this;
	}

	public String getUrlStandrad() {
		return urlStandrad;
	}

	public BigCommerceImage setUrlStandrad(String urlStandrad) {
		this.urlStandrad = urlStandrad;
		return this;
	}

	public String getUrlThumbNail() {
		return urlThumbNail;
	}

	public BigCommerceImage setUrlThumbNail(String urlThumbNail) {
		this.urlThumbNail = urlThumbNail;
		return this;
	}

	public String getImageTiny() {
		return imageTiny;
	}

	public BigCommerceImage setImageTiny(String imageTiny) {
		this.imageTiny = imageTiny;
		return this;
	}

	public int getId() {
		return id;
	}

	public BigCommerceImage setId(int id) {
		this.id = id;
		return this;
	}

	public int getProductId() {
		return productId;
	}

	public BigCommerceImage setProductId(int productId) {
		this.productId = productId;
		return this;
	}	
}
