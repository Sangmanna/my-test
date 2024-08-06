package com.freightcom.clickship.model.marketplace.etsy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Listing implements Serializable {

	private static final long serialVersionUID = -3777156423924609367L;

	@JsonProperty("listing_id")
	private Long listing_id;

	@JsonProperty("state")
	private String state;

	@JsonProperty("user_id")
	private Integer user_id;

	@JsonProperty("category_id")
	private Integer category_id;

	@JsonProperty("title")
	private String title;

	@JsonProperty("description")	
	private String description;

	@JsonProperty("creation_tsz")
	private Float creation_tsz;

	@JsonProperty("ending_tsz")
	private Float ending_tsz;

	@JsonProperty("original_creation_tsz")
	private Float original_creation_tsz;

	@JsonProperty("last_modified_tsz")
	private Float last_modified_tsz;

	@JsonProperty("price")
	private String price;

	@JsonProperty("currency_code")
	private String currency_code;

	@JsonProperty("quantity")
	private Integer quantity;

	@JsonProperty("tags")
	private ArrayList<String> tags;

	@JsonProperty("sku")
	private ArrayList<String> skus;

	@JsonProperty("category_path")
	private ArrayList<String> category_path;

	@JsonProperty("category_path_ids")
	private Integer[] category_path_ids;

	@JsonProperty("taxonomy_id")
	private Integer taxonomy_id;

	@JsonProperty("suggested_taxonomy_id")
	private Integer suggested_taxonomy_id;

	@JsonProperty("taxonomy_path")
	private ArrayList<String> taxonomy_path;

	@JsonProperty("materials")
	private ArrayList<String> materials;

	@JsonProperty("shop_section_id")
	private Integer shop_section_id;

	@JsonProperty("featured_rank")
	private String featured_rank;

	@JsonProperty("state_tsz")
	private Float state_tsz;

	@JsonProperty("url")
	private String url;

	@JsonProperty("views")
	private Integer views;

	@JsonProperty("num_favorers")
	private Integer num_favorers;

	@JsonProperty("shipping_template_id")
	private Long shipping_template_id;

	@JsonProperty("processing_min")
	private Integer processing_min;

	@JsonProperty("processing_max")
	private Integer processing_max;

	@JsonProperty("who_made")
	private String who_made;

	@JsonProperty("is_supply")
	private Boolean is_supply;

	@JsonProperty("when_made")
	private String when_made;

	@JsonProperty("item_weight")
	private Double item_weight;

	@JsonProperty("item_weight_unit")
	private String item_weight_unit;

	@JsonProperty("item_length")
	private Double item_length;

	@JsonProperty("item_width")
	private Double item_width;

	@JsonProperty("item_height")
	private Double item_height;

	@JsonProperty("item_dimensions_unit")
	private String item_dimensions_unit;

	@JsonProperty("is_private")
	private Boolean is_private;

	@JsonProperty("recipient")
	private String recipient;

	@JsonProperty("occasion")
	private String occasion;

	@JsonProperty("style")
	private ArrayList<String> style;

	@JsonProperty("non_taxable")
	private Boolean non_taxable;

	@JsonProperty("is_customizable")
	private Boolean is_customizable;

	@JsonProperty("is_digital")
	private Boolean is_digital;

	@JsonProperty("file_data")
	private String file_data;

	@JsonProperty("has_variations")
	private Boolean has_variations;

	@JsonProperty("should_auto_renew")
	private Boolean should_auto_renew;

	@JsonProperty("language")
	private String language;

	@JsonProperty("used_manufacturer")
	private Boolean used_manufacturer;

	public Long getListing_id() {
		return listing_id;
	}

	public void setListing_id(Long listing_id) {
		this.listing_id = listing_id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getCreation_tsz() {
		return creation_tsz;
	}

	public void setCreation_tsz(Float creation_tsz) {
		this.creation_tsz = creation_tsz;
	}

	public Float getEnding_tsz() {
		return ending_tsz;
	}

	public void setEnding_tsz(Float ending_tsz) {
		this.ending_tsz = ending_tsz;
	}

	public Float getOriginal_creation_tsz() {
		return original_creation_tsz;
	}

	public void setOriginal_creation_tsz(Float original_creation_tsz) {
		this.original_creation_tsz = original_creation_tsz;
	}

	public Float getLast_modified_tsz() {
		return last_modified_tsz;
	}

	public void setLast_modified_tsz(Float last_modified_tsz) {
		this.last_modified_tsz = last_modified_tsz;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCurrency_code() {
		return currency_code;
	}

	public void setCurrency_code(String currency_code) {
		this.currency_code = currency_code;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public ArrayList<String> getTags() {
		return tags;
	}

	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}

	public ArrayList<String> getCategory_path() {
		return category_path;
	}

	public void setCategory_path(ArrayList<String> category_path) {
		this.category_path = category_path;
	}

	public Integer[] getCategory_path_ids() {
		return category_path_ids;
	}

	public void setCategory_path_ids(Integer[] category_path_ids) {
		this.category_path_ids = category_path_ids;
	}

	public Integer getTaxonomy_id() {
		return taxonomy_id;
	}

	public void setTaxonomy_id(Integer taxonomy_id) {
		this.taxonomy_id = taxonomy_id;
	}

	public Integer getSuggested_taxonomy_id() {
		return suggested_taxonomy_id;
	}

	public void setSuggested_taxonomy_id(Integer suggested_taxonomy_id) {
		this.suggested_taxonomy_id = suggested_taxonomy_id;
	}

	public ArrayList<String> getTaxonomy_path() {
		return taxonomy_path;
	}

	public void setTaxonomy_path(ArrayList<String> taxonomy_path) {
		this.taxonomy_path = taxonomy_path;
	}

	public ArrayList<String> getMaterials() {
		return materials;
	}

	public void setMaterials(ArrayList<String> materials) {
		this.materials = materials;
	}

	public Integer getShop_section_id() {
		return shop_section_id;
	}

	public void setShop_section_id(Integer shop_section_id) {
		this.shop_section_id = shop_section_id;
	}

	public String getFeatured_rank() {
		return featured_rank;
	}

	public void setFeatured_rank(String featured_rank) {
		this.featured_rank = featured_rank;
	}

	public Float getState_tsz() {
		return state_tsz;
	}

	public void setState_tsz(Float state_tsz) {
		this.state_tsz = state_tsz;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public Integer getNum_favorers() {
		return num_favorers;
	}

	public void setNum_favorers(Integer num_favorers) {
		this.num_favorers = num_favorers;
	}

	public Long getShipping_template_id() {
		return shipping_template_id;
	}

	public void setShipping_template_id(Long shipping_template_id) {
		this.shipping_template_id = shipping_template_id;
	}

	public Integer getProcessing_min() {
		return processing_min;
	}

	public void setProcessing_min(Integer processing_min) {
		this.processing_min = processing_min;
	}

	public Integer getProcessing_max() {
		return processing_max;
	}

	public void setProcessing_max(Integer processing_max) {
		this.processing_max = processing_max;
	}

	public String getWho_made() {
		return who_made;
	}

	public void setWho_made(String who_made) {
		this.who_made = who_made;
	}

	public Boolean getIs_supply() {
		return is_supply;
	}

	public void setIs_supply(Boolean is_supply) {
		this.is_supply = is_supply;
	}

	public String getWhen_made() {
		return when_made;
	}

	public void setWhen_made(String when_made) {
		this.when_made = when_made;
	}

	public Double getItem_weight() {
		return item_weight;
	}

	public void setItem_weight(Double item_weight) {
		this.item_weight = item_weight;
	}

	public String getItem_weight_unit() {
		return item_weight_unit;
	}

	public void setItem_weight_unit(String item_weight_unit) {
		this.item_weight_unit = item_weight_unit;
	}

	public Double getItem_length() {
		return item_length;
	}

	public void setItem_length(Double item_length) {
		this.item_length = item_length;
	}

	public Double getItem_width() {
		return item_width;
	}

	public void setItem_width(Double item_width) {
		this.item_width = item_width;
	}

	public Double getItem_height() {
		return item_height;
	}

	public void setItem_height(Double item_height) {
		this.item_height = item_height;
	}

	public String getItem_dimensions_unit() {
		return item_dimensions_unit;
	}

	public void setItem_dimensions_unit(String item_dimensions_unit) {
		this.item_dimensions_unit = item_dimensions_unit;
	}

	public Boolean getIs_private() {
		return is_private;
	}

	public void setIs_private(Boolean is_private) {
		this.is_private = is_private;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getOccasion() {
		return occasion;
	}

	public void setOccasion(String occasion) {
		this.occasion = occasion;
	}

	public ArrayList<String> getStyle() {
		return style;
	}

	public void setStyle(ArrayList<String> style) {
		this.style = style;
	}

	public Boolean getNon_taxable() {
		return non_taxable;
	}

	public void setNon_taxable(Boolean non_taxable) {
		this.non_taxable = non_taxable;
	}

	public Boolean getIs_customizable() {
		return is_customizable;
	}

	public void setIs_customizable(Boolean is_customizable) {
		this.is_customizable = is_customizable;
	}

	public Boolean getIs_digital() {
		return is_digital;
	}

	public void setIs_digital(Boolean is_digital) {
		this.is_digital = is_digital;
	}

	public String getFile_data() {
		return file_data;
	}

	public void setFile_data(String file_data) {
		this.file_data = file_data;
	}

	public Boolean getHas_variations() {
		return has_variations;
	}

	public void setHas_variations(Boolean has_variations) {
		this.has_variations = has_variations;
	}

	public Boolean getShould_auto_renew() {
		return should_auto_renew;
	}

	public void setShould_auto_renew(Boolean should_auto_renew) {
		this.should_auto_renew = should_auto_renew;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Boolean getUsed_manufacturer() {
		return used_manufacturer;
	}

	public void setUsed_manufacturer(Boolean used_manufacturer) {
		this.used_manufacturer = used_manufacturer;
	}

	public ArrayList<String> getSkus() {
		return skus;
	}

	public void setSkus(ArrayList<String> skus) {
		this.skus = skus;
	}
}
