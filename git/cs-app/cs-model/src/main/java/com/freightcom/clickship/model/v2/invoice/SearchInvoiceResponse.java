package com.freightcom.clickship.model.v2.invoice;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchInvoiceResponse {
	
	private String url;
	
	private Data_ data;

    public String getUrl() {
		return url;
	}

    public SearchInvoiceResponse setUrl(String url) {
		this.url = url;
		return this;
	}

	public Data_ getData() {
		return data;
	}

	public SearchInvoiceResponse setData(Data_ data) {
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
            
			private List<InvoiceData> data;
            
            private int total_size;
            
            private int page_index;
            
            private Date min_date;
            
            private Date max_date;

            public List<InvoiceData> getData() {
				return data;
			}

			public Page setData(List<InvoiceData> data) {
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
