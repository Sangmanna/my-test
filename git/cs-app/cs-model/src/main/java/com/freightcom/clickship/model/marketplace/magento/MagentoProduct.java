package com.freightcom.clickship.model.marketplace.magento;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MagentoProduct implements Serializable {

	private static final long serialVersionUID = 4332964369639010873L;
	
	private Long id;
	
	private String sku;
	
	private Double price;

	private String name;
	
	private Double weight;
	
	private boolean status;
	
	private Integer visibility;
	
// Since we are not pulling inventory no need of this extension attributes 
//	@JsonProperty("extension_attributes")
//	private ProductExtensionAttributes extensionAttributes;
	
	@JsonProperty("custom_attributes")
	private List<MagentoProductAttributes> customAttributes;
	
	public Long getId() {
		return id;
	}

	public MagentoProduct setId(Long id) {
		this.id = id;
		return this;
	}

	public String getSku() {
		return sku;
	}

	public MagentoProduct setSku(String sku) {
		this.sku = sku;
		return this;
	}
	
	public Double getPrice() {
		return price;
	}

	public MagentoProduct setPrice(Double price) {
		this.price = price;
		return this;
	}

	public String getName() {
		return name;
	}

	public MagentoProduct setName(String name) {
		this.name = name;
		return this;
	}

	public Double getWeight() {
		return weight;
	}

	public MagentoProduct setWeight(Double weight) {
		this.weight = weight;
		return this;
	}

	public boolean isStatus() {
		return status;
	}

	public MagentoProduct setStatus(boolean status) {
		this.status = status;
		return this;
	}

	public Integer getVisibility() {
		return visibility;
	}

	public MagentoProduct setVisibility(Integer visibility) {
		this.visibility = visibility;
		return this;
	}

/*	public ProductExtensionAttributes getExtensionAttributes() {
		return extensionAttributes;
	}

	public MagentoProduct setExtensionAttributes(ProductExtensionAttributes extensionAttributes) {
		this.extensionAttributes = extensionAttributes;
		return this;
	} */

	public List<MagentoProductAttributes> getCustomAttributes() {
		return customAttributes;
	}

	public MagentoProduct setCustomAttributes(List<MagentoProductAttributes> customAttributes) {
		this.customAttributes = customAttributes;
		return this;
	}

	@Override
	public String toString() {
		return "MagentoProduct [id=" + id + ", sku=" + sku + "]";
	}
	
}
