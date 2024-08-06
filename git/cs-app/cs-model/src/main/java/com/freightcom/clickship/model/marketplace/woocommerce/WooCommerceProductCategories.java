package com.freightcom.clickship.model.marketplace.woocommerce;

import java.io.Serializable;

class WooCommerceProductCategories implements Serializable {
	
	private static final long serialVersionUID = 7994286996875827009L;

	private Long id;
	
	private String name;
	
	private String slug;

	public Long getId() {
		return id;
	}

	public WooCommerceProductCategories setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public WooCommerceProductCategories setName(String name) {
		this.name = name;
		return this;
	}

	public String getSlug() {
		return slug;
	}

	public WooCommerceProductCategories setSlug(String slug) {
		this.slug = slug;
		return this;
	}

}