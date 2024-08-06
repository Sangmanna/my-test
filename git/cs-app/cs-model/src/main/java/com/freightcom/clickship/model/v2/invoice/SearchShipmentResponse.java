package com.freightcom.clickship.model.v2.invoice;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.freightcom.clickship.model.v2.Destination;
import com.freightcom.clickship.model.v2.Origin;
import com.freightcom.clickship.model.v2.PackagingType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchShipmentResponse {

	private String url;
	
	private Data_ data;
	
	public String getUrl() {
		return url;
	}

	public SearchShipmentResponse setUrl(String url) {
		this.url = url;
		return this;
	}

	public Data_ getData() {
		return data;
	}

	public SearchShipmentResponse setData(Data_ data) {
		this.data = data;
		return this;
	}

	@Data
	@NoArgsConstructor
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Data_ {
		
		private Page page;

		public Page getPage() {
			return page;
		}

		public Data_ setPage(Page page) {
			this.page = page;
			return this;
		}

		@Data
		@NoArgsConstructor
		@JsonIgnoreProperties(ignoreUnknown = true)
		public static class Page {
			
			private List<ShipmentResponse> data;
			
			private int total_size;
			
			private int page_index;
			
			private Date min_date;
			
			private Date max_date;
			
			public List<ShipmentResponse> getData() {
				return data;
			}

			public Page setData(List<ShipmentResponse> data) {
				this.data = data;
				return this;
			}

			public int getTotal_size() {
				return total_size;
			}

			public Page setTotal_size(int total_size) {
				this.total_size = total_size;
				return this;
			}

			public int getPage_index() {
				return page_index;
			}

			public Page setPage_index(int page_index) {
				this.page_index = page_index;
				return this;
			}

			public Date getMin_date() {
				return min_date;
			}

			public Page setMin_date(Date min_date) {
				this.min_date = min_date;
				return this;
			}

			public Date getMax_date() {
				return max_date;
			}

			public Page setMax_date(Date max_date) {
				this.max_date = max_date;
				return this;
			}

			@Data
			@NoArgsConstructor
			@JsonIgnoreProperties(ignoreUnknown = true)
			public static class ShipmentResponse {
				
				@JsonProperty("id")
				private String id;

				@JsonProperty("state")
				private String state;

				@JsonProperty("transaction_number")
				private String transactionNumber;

				@JsonProperty("tracking_number")
				private String trackingNumber;

				@JsonProperty("tracking_numbers")
				private List<String> trackingNumbers;

				@JsonProperty("tracking_url")
				private String trackingURL;

				@JsonProperty("bolnumber")
				private String bloNumber;
				
				@JsonProperty("pickup_confirmation_number")
				private String pickupConfirmationNumber;

				@JsonProperty("order_source")
				private String orderSource;
				
				@JsonProperty("shipping_details")
				private ShippingDetails details;

				public String getId() {
					return id;
				}

				public ShipmentResponse setId(String id) {
					this.id = id;
					return this;
				}

				public String getState() {
					return state;
				}

				public ShipmentResponse setState(String state) {
					this.state = state;
					return this;
				}

				public String getTransactionNumber() {
					return transactionNumber;
				}

				public ShipmentResponse setTransactionNumber(String transactionNumber) {
					this.transactionNumber = transactionNumber;
					return this;
				}

				public String getTrackingNumber() {
					return trackingNumber;
				}

				public ShipmentResponse setTrackingNumber(String trackingNumber) {
					this.trackingNumber = trackingNumber;
					return this;
				}

				public List<String> getTrackingNumbers() {
					return trackingNumbers;
				}

				public ShipmentResponse setTrackingNumbers(List<String> trackingNumbers) {
					this.trackingNumbers = trackingNumbers;
					return this;
				}

				public String getTrackingURL() {
					return trackingURL;
				}

				public ShipmentResponse setTrackingURL(String trackingURL) {
					this.trackingURL = trackingURL;
					return this;
				}

				public String getBloNumber() {
					return bloNumber;
				}

				public ShipmentResponse setBloNumber(String bloNumber) {
					this.bloNumber = bloNumber;
					return this;
				}

				public String getPickupConfirmationNumber() {
					return pickupConfirmationNumber;
				}

				public ShipmentResponse setPickupConfirmationNumber(String pickupConfirmationNumber) {
					this.pickupConfirmationNumber = pickupConfirmationNumber;
					return this;
				}

				public String getOrderSource() {
					return orderSource;
				}

				public ShipmentResponse setOrderSource(String orderSource) {
					this.orderSource = orderSource;
					return this;
				}

				public ShippingDetails getDetails() {
					return details;
				}

				public ShipmentResponse setDetails(ShippingDetails details) {
					this.details = details;
					return this;
				}
			}
			
			@Data
			@NoArgsConstructor
			@JsonIgnoreProperties(ignoreUnknown = true)
			public static class ShippingDetails {
				
				@JsonProperty("id")
				private String id;
				
				@JsonProperty("expected_ship_date")
				private Date expectedShipDate = null;
				
				@JsonProperty("origin")
				private Origin origin;
				
				@JsonProperty("destination")
				private Destination destination;

				@JsonProperty("packaging_type")
				private PackagingType packagingType;
				
				@JsonProperty("reference_codes")
				private String[] referenceCodes;

				public String getId() {
					return id;
				}

				public ShippingDetails setId(String id) {
					this.id = id;
					return this;
				}

				public Date getExpectedShipDate() {
					return expectedShipDate;
				}

				public ShippingDetails setExpectedShipDate(Date expectedShipDate) {
					this.expectedShipDate = expectedShipDate;
					return this;
				}

				public Origin getOrigin() {
					return origin;
				}

				public ShippingDetails setOrigin(Origin origin) {
					this.origin = origin;
					return this;
				}

				public Destination getDestination() {
					return destination;
				}

				public ShippingDetails setDestination(Destination destination) {
					this.destination = destination;
					return this;
				}

				public PackagingType getPackagingType() {
					return packagingType;
				}

				public ShippingDetails setPackagingType(PackagingType packagingType) {
					this.packagingType = packagingType;
					return this;
				}

				public String[] getReferenceCodes() {
					return referenceCodes;
				}

				public ShippingDetails setReferenceCodes(String[] referenceCodes) {
					this.referenceCodes = referenceCodes;
					return this;
				}
			}
			
			@Data
			@NoArgsConstructor
			@JsonIgnoreProperties(ignoreUnknown = true)
			public static class Date {
				private int year;
				
				private int month;
				
				private int day;

				public int getYear() {
					return year;
				}

				public Date setYear(int year) {
					this.year = year;
					return this;
				}

				public int getMonth() {
					return month;
				}

				public Date setMonth(int month) {
					this.month = month;
					return this;
				}

				public int getDay() {
					return day;
				}

				public Date setDay(int day) {
					this.day = day;
					return this;
				}
				
			}
		}
	}
}
