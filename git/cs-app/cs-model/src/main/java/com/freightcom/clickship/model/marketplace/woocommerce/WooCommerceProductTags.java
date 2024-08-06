package com.freightcom.clickship.model.marketplace.woocommerce;

import java.io.Serializable;

class WooCommerceProductTags implements Serializable {
	
	private static final long serialVersionUID = -5298701734167200888L;

	private Long id;
	
	private String name;
	
	private String slug;

	public Long getId() {
		return id;
	}

	public WooCommerceProductTags setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public WooCommerceProductTags setName(String name) {
		this.name = name;
		return this;
	}

	public String getSlug() {
		return slug;
	}

	public WooCommerceProductTags setSlug(String slug) {
		this.slug = slug;
		return this;
	}

}