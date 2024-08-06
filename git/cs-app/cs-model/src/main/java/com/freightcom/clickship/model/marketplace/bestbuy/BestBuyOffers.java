package com.freightcom.clickship.model.marketplace.bestbuy;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BestBuyOffers {

	@JsonProperty("active")
	private boolean active;
	
	@JsonProperty("all_prices")
	private List<AllPrices> allPrices;	
	
	@JsonProperty("category_code")
	private String categoryCode;
	
	@JsonProperty("category_label")
	private String categoryLabel;
	
	@JsonProperty("channels")
	private List<String> channels;
	
	@JsonProperty("currency_iso_code")
	private String currencyIsoCode;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("fulfillment")
	private Fulfillment fulfillment;
	
	@JsonProperty("inactivity_reasons")
	private List<String> inactivityReasons;
	
	@JsonProperty("internal_description")
	private String internaldescription;
	
	@JsonProperty("leadtime_to_ship")
	private int leadTimeToShip;
	
	@JsonProperty("logistic_class")
	private LogisticClass logisticClass;
	
	@JsonProperty("max_order_quantity")
	private int maxOrderQuantity;
	
	@JsonProperty("min_order_quantity")
	private int minOrderQuantity;
	
	@JsonProperty("min_quantity_alert")
	private int minQuantityAlert;
	
	@JsonProperty("min_shipping_price")
	private double minShippingPrice;
	
	@JsonProperty("min_shipping_price_additional")
	private double minShippingPriceAdditional;
	
	@JsonProperty("min_shipping_type")
	private String minshippingType;
	
	@JsonProperty("min_shipping_zone")
	private String minShippingZone;
	
	@JsonProperty("offer_id")
	private int offerId;
	
	@JsonProperty("package_quantity")
	private int packageQuantity;
	
	@JsonProperty("price")
	private double price;
	
	@JsonProperty("price_additional_info")
	private String priceAdditionalInfo;
	
	@JsonProperty("product_references")
	private List<ProductReferences> productReferences;
	
	@JsonProperty("product_sku")
	private String productSku;
	
	@JsonProperty("product_tax_code")
	private String productTaxCode;
	
	@JsonProperty("product_title")
	private String productTitle;
	
	@JsonProperty("quantity")
	private int quantity;
	
	@JsonProperty("shipping_deadline")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date shippingDeadLine;
	
	@JsonProperty("state_code")
	private String stateCode;
	
	@JsonProperty("total_price")
	private double totalPrice;
	
	@JsonProperty("shop_sku")
	private String shopSku;
	
	@JsonProperty("applicable_pricing")
	private ApplicablePricing applicablePricing;
	
	
	
	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public List<AllPrices> getAllPrices() {
		return allPrices;
	}


	public void setAllPrices(List<AllPrices> allPrices) {
		this.allPrices = allPrices;
	}


	public String getCategoryCode() {
		return categoryCode;
	}


	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}


	public String getCategoryLabel() {
		return categoryLabel;
	}


	public void setCategoryLabel(String categoryLabel) {
		this.categoryLabel = categoryLabel;
	}


	public List<String> getChannels() {
		return channels;
	}


	public void setChannels(List<String> channels) {
		this.channels = channels;
	}


	public String getCurrencyIsoCode() {
		return currencyIsoCode;
	}


	public void setCurrencyIsoCode(String currencyIsoCode) {
		this.currencyIsoCode = currencyIsoCode;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Fulfillment getFulfillment() {
		return fulfillment;
	}


	public void setFulfillment(Fulfillment fulfillment) {
		this.fulfillment = fulfillment;
	}


	public List<String> getInactivityReasons() {
		return inactivityReasons;
	}


	public void setInactivityReasons(List<String> inactivityReasons) {
		this.inactivityReasons = inactivityReasons;
	}


	public String getInternaldescription() {
		return internaldescription;
	}


	public void setInternaldescription(String internaldescription) {
		this.internaldescription = internaldescription;
	}


	public int getLeadTimeToShip() {
		return leadTimeToShip;
	}


	public void setLeadTimeToShip(int leadTimeToShip) {
		this.leadTimeToShip = leadTimeToShip;
	}


	public LogisticClass getLogisticClass() {
		return logisticClass;
	}


	public void setLogisticClass(LogisticClass logisticClass) {
		this.logisticClass = logisticClass;
	}


	public int getMaxOrderQuantity() {
		return maxOrderQuantity;
	}


	public void setMaxOrderQuantity(int maxOrderQuantity) {
		this.maxOrderQuantity = maxOrderQuantity;
	}


	public int getMinOrderQuantity() {
		return minOrderQuantity;
	}


	public void setMinOrderQuantity(int minOrderQuantity) {
		this.minOrderQuantity = minOrderQuantity;
	}


	public int getMinQuantityAlert() {
		return minQuantityAlert;
	}


	public void setMinQuantityAlert(int minQuantityAlert) {
		this.minQuantityAlert = minQuantityAlert;
	}


	public double getMinShippingPrice() {
		return minShippingPrice;
	}


	public void setMinShippingPrice(double minShippingPrice) {
		this.minShippingPrice = minShippingPrice;
	}


	public double getMinShippingPriceAdditional() {
		return minShippingPriceAdditional;
	}


	public void setMinShippingPriceAdditional(double minShippingPriceAdditional) {
		this.minShippingPriceAdditional = minShippingPriceAdditional;
	}


	public String getMinshippingType() {
		return minshippingType;
	}


	public void setMinshippingType(String minshippingType) {
		this.minshippingType = minshippingType;
	}


	public String getMinShippingZone() {
		return minShippingZone;
	}


	public void setMinShippingZone(String minShippingZone) {
		this.minShippingZone = minShippingZone;
	}


	public int getOfferId() {
		return offerId;
	}


	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}


	public int getPackageQuantity() {
		return packageQuantity;
	}


	public void setPackageQuantity(int packageQuantity) {
		this.packageQuantity = packageQuantity;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getPriceAdditionalInfo() {
		return priceAdditionalInfo;
	}


	public void setPriceAdditionalInfo(String priceAdditionalInfo) {
		this.priceAdditionalInfo = priceAdditionalInfo;
	}


	public List<ProductReferences> getProductReferences() {
		return productReferences;
	}


	public void setProductReferences(List<ProductReferences> productReferences) {
		this.productReferences = productReferences;
	}


	public String getProductSku() {
		return productSku;
	}


	public void setProductSku(String productSku) {
		this.productSku = productSku;
	}


	public String getProductTaxCode() {
		return productTaxCode;
	}


	public void setProductTaxCode(String productTaxCode) {
		this.productTaxCode = productTaxCode;
	}


	public String getProductTitle() {
		return productTitle;
	}


	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Date getShippingDeadLine() {
		return shippingDeadLine;
	}


	public void setShippingDeadLine(Date shippingDeadLine) {
		this.shippingDeadLine = shippingDeadLine;
	}


	public String getStateCode() {
		return stateCode;
	}


	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}


	public double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public String getShopSku() {
		return shopSku;
	}


	public void setShopSku(String shopSku) {
		this.shopSku = shopSku;
	}


	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class AllPrices {
		@JsonProperty("channel_code")
		private String channelCode;

		@JsonProperty("discount_end_date")
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
		private Date discountEndDate;
		
		@JsonProperty("discount_start_date")
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
		private Date discountStartDate;
		
		@JsonProperty("price")
		private double price;
		
		@JsonProperty("unit_discount_price")
		private double unitDiscountPrice;
		
		@JsonProperty("unit_origin_price")
		private double unitOriginPrice;

		public String getChannelCode() {
			return channelCode;
		}

		public void setChannelCode(String channelCode) {
			this.channelCode = channelCode;
		}

		public Date getDiscountEndDate() {
			return discountEndDate;
		}

		public void setDiscountEndDate(Date discountEndDate) {
			this.discountEndDate = discountEndDate;
		}

		public Date getDiscountStartDate() {
			return discountStartDate;
		}

		public void setDiscountStartDate(Date discountStartDate) {
			this.discountStartDate = discountStartDate;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public double getUnitDiscountPrice() {
			return unitDiscountPrice;
		}

		public void setUnitDiscountPrice(double unitDiscountPrice) {
			this.unitDiscountPrice = unitDiscountPrice;
		}

		public double getUnitOriginPrice() {
			return unitOriginPrice;
		}

		public void setUnitOriginPrice(double unitOriginPrice) {
			this.unitOriginPrice = unitOriginPrice;
		}

	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class LogisticClass {
		@JsonProperty("code")
		private String code;

		@JsonProperty("label")
		private String label;

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Fulfillment {
		@JsonProperty("center")
		private Center center;

		public Center getCenter() {
			return center;
		}

		public void setCenter(Center center) {
			this.center = center;
		}
	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Center {
		@JsonProperty("code")
		private String code;

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

	}


	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class ProductReferences {

		@JsonProperty("reference")
		private String reference;

		@JsonProperty("reference_type")
		private String referenceType;

		public String getReference() {
			return reference;
		}

		public void setReference(String reference) {
			this.reference = reference;
		}

		public String getReferenceType() {
			return referenceType;
		}

		public void setReferenceType(String referenceType) {
			this.referenceType = referenceType;
		}

	}
	
	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class ApplicablePricing {

		@JsonProperty("channel_code")
		private String channelCode;

		@JsonProperty("discount_end_date")
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
		private Date discountEndDate;
		
		@JsonProperty("discount_start_date")
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
		private Date discountStartDate;
		
		@JsonProperty("price")
		private double discountPrice;
		
		@JsonProperty("unit_discount_price")
		private double unitDiscountPrice;
		
		@JsonProperty("unit_origin_price")
		private double unitOriginPrice;
		
		@JsonProperty("volume_prices")
		private List<VolumePrices> volumePrices;

		public String getChannelCode() {
			return channelCode;
		}

		public void setChannelCode(String channelCode) {
			this.channelCode = channelCode;
		}

		public Date getDiscountEndDate() {
			return discountEndDate;
		}

		public void setDiscountEndDate(Date discountEndDate) {
			this.discountEndDate = discountEndDate;
		}

		public Date getDiscountStartDate() {
			return discountStartDate;
		}

		public void setDiscountStartDate(Date discountStartDate) {
			this.discountStartDate = discountStartDate;
		}

		public double getDiscountPrice() {
			return discountPrice;
		}

		public void setDiscountPrice(double discountPrice) {
			this.discountPrice = discountPrice;
		}

		public double getUnitDiscountPrice() {
			return unitDiscountPrice;
		}

		public void setUnitDiscountPrice(double unitDiscountPrice) {
			this.unitDiscountPrice = unitDiscountPrice;
		}

		public double getUnitOriginPrice() {
			return unitOriginPrice;
		}

		public void setUnitOriginPrice(double unitOriginPrice) {
			this.unitOriginPrice = unitOriginPrice;
		}

		public List<VolumePrices> getVolumePrices() {
			return volumePrices;
		}

		public void setVolumePrices(List<VolumePrices> volumePrices) {
			this.volumePrices = volumePrices;
		}

	}
	
	public ApplicablePricing getApplicablePricing() {
		return applicablePricing;
	}


	public void setApplicablePricing(ApplicablePricing applicablePricing) {
		this.applicablePricing = applicablePricing;
	}


	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class VolumePrices {

		@JsonProperty("channel_code")
		private double volumePrice;

		@JsonProperty("discount_end_date")
		private int quantity_threshold;
		
		@JsonProperty("unit_discount_price")
		private double unitDiscountPrice;
		
		@JsonProperty("unit_origin_price")
		private double unitOriginPrice;

		public double getVolumePrice() {
			return volumePrice;
		}

		public void setVolumePrice(double volumePrice) {
			this.volumePrice = volumePrice;
		}

		public int getQuantity_threshold() {
			return quantity_threshold;
		}

		public void setQuantity_threshold(int quantity_threshold) {
			this.quantity_threshold = quantity_threshold;
		}

		public double getUnitDiscountPrice() {
			return unitDiscountPrice;
		}

		public void setUnitDiscountPrice(double unitDiscountPrice) {
			this.unitDiscountPrice = unitDiscountPrice;
		}

		public double getUnitOriginPrice() {
			return unitOriginPrice;
		}

		public void setUnitOriginPrice(double unitOriginPrice) {
			this.unitOriginPrice = unitOriginPrice;
		}

	}

}
