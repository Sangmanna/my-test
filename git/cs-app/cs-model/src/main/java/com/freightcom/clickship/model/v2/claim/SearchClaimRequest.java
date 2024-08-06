package com.freightcom.clickship.model.v2.claim;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchClaimRequest {
    private SearchCriteria criteria;
    private List<SortOrder> sort_orders;
    private Pagination pagination;
    private RequestedFields requested_fields;

    @Data
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SearchCriteria {
        private String mode;
        private String category;
        private boolean use_time_range;
        private String text;
        private boolean allow_ignore_mode_and_category;
        private List<CarrierService> carrier_service_ids_array;
        private List<String> packaging_types;
        private List<String> shipment_statuses;
        private boolean only_spot_shipments;
        private TimeRange time_range;
        private boolean new_admin_messages_only;

        @Data
        @NoArgsConstructor
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class TimeRange {
            private String after_time;
            private String before_time;
			
            public String getAfter_time() {
				return after_time;
			}
			
			public TimeRange setAfter_time(String after_time) {
				this.after_time = after_time;
				return this;
			}
			
			public String getBefore_time() {
				return before_time;
			}
			
			public TimeRange setBefore_time(String before_time) {
				this.before_time = before_time;
				return this;
			}
        }

		public String getMode() {
			return mode;
		}

		public SearchCriteria setMode(String mode) {
			this.mode = mode;
			return this;
		}

		public String getCategory() {
			return category;
		}

		public SearchCriteria setCategory(String category) {
			this.category = category;
			return this;
		}

		public boolean isUse_time_range() {
			return use_time_range;
		}

		public SearchCriteria setUse_time_range(boolean use_time_range) {
			this.use_time_range = use_time_range;
			return this;
		}

		public String getText() {
			return text;
		}

		public SearchCriteria setText(String text) {
			this.text = text;
			return this;
		}

		public boolean isAllow_ignore_mode_and_category() {
			return allow_ignore_mode_and_category;
		}

		public SearchCriteria setAllow_ignore_mode_and_category(boolean allow_ignore_mode_and_category) {
			this.allow_ignore_mode_and_category = allow_ignore_mode_and_category;
			return this;
		}

		public List<CarrierService> getCarrier_service_ids_array() {
			return carrier_service_ids_array;
		}

		public SearchCriteria setCarrier_service_ids_array(List<CarrierService> carrier_service_ids_array) {
			this.carrier_service_ids_array = carrier_service_ids_array;
			return this;
		}

		public List<String> getPackaging_types() {
			return packaging_types;
		}

		public SearchCriteria setPackaging_types(List<String> packaging_types) {
			this.packaging_types = packaging_types;
			return this;
		}

		public List<String> getShipment_statuses() {
			return shipment_statuses;
		}

		public SearchCriteria setShipment_statuses(List<String> shipment_statuses) {
			this.shipment_statuses = shipment_statuses;
			return this;
		}

		public boolean isOnly_spot_shipments() {
			return only_spot_shipments;
		}

		public SearchCriteria setOnly_spot_shipments(boolean only_spot_shipments) {
			this.only_spot_shipments = only_spot_shipments;
			return this;
		}

		public TimeRange getTime_range() {
			return time_range;
		}

		public SearchCriteria setTime_range(TimeRange time_range) {
			this.time_range = time_range;
			return this;
		}

		public boolean isNew_admin_messages_only() {
			return new_admin_messages_only;
		}

		public SearchCriteria setNew_admin_messages_only(boolean new_admin_messages_only) {
			this.new_admin_messages_only = new_admin_messages_only;
			return this;
		}
    }
    
    @Data
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CarrierService {
        private String carrierId;
        
        private List<String> serviceIds;

		public String getCarrierId() {
			return carrierId;
		}

		public CarrierService setCarrierId(String carrierId) {
			this.carrierId = carrierId;
			return this;
		}

		public List<String> getServiceIds() {
			return serviceIds;
		}

		public CarrierService setServiceIds(List<String> serviceIds) {
			this.serviceIds = serviceIds;
			return this;
		}
    }

    @Data
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SortOrder {
        private String sort_by;
        private boolean descending;
		
        public String getSort_by() {
			return sort_by;
		}
		
        public SortOrder setSort_by(String sort_by) {
			this.sort_by = sort_by;
			return this;
		}
		
        public boolean isDescending() {
			return descending;
		}
		
        public SortOrder setDescending(boolean descending) {
			this.descending = descending;
			return this;
		}
    }

    @Data
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Pagination {
        private int page_index;
        private int page_size;
        private boolean get_date_range;
		
        public int getPage_index() {
			return page_index;
		}
		public Pagination setPage_index(int page_index) {
			this.page_index = page_index;
			return this;
		}
		public int getPage_size() {
			return page_size;
		}
		public Pagination setPage_size(int page_size) {
			this.page_size = page_size;
			return this;
		}
		public boolean isGet_date_range() {
			return get_date_range;
		}
		public Pagination setGet_date_range(boolean get_date_range) {
			this.get_date_range = get_date_range;
			return this;
		}
    }

    @Data
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RequestedFields {
        private boolean count_num_new_admin_messages;

		public boolean isCount_num_new_admin_messages() {
			return count_num_new_admin_messages;
		}

		public RequestedFields setCount_num_new_admin_messages(boolean count_num_new_admin_messages) {
			this.count_num_new_admin_messages = count_num_new_admin_messages;
			return this;
		}
    }

	public SearchCriteria getCriteria() {
		return criteria;
	}

	public SearchClaimRequest setCriteria(SearchCriteria criteria) {
		this.criteria = criteria;
		return this;
	}

	public List<SortOrder> getSort_orders() {
		return sort_orders;
	}

	public SearchClaimRequest setSort_orders(List<SortOrder> sort_orders) {
		this.sort_orders = sort_orders;
		return this;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public SearchClaimRequest setPagination(Pagination pagination) {
		this.pagination = pagination;
		return this;
	}

	public RequestedFields getRequested_fields() {
		return requested_fields;
	}

	public SearchClaimRequest setRequested_fields(RequestedFields requested_fields) {
		this.requested_fields = requested_fields;
		return this;
	}
    
}
