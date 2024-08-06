package com.freightcom.clickship.model.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CartBooking {
	  @JsonProperty("invoice_request_id")
      private String invoiceRequestId;

      @JsonProperty("booked_at")
      private String bookedAt;

      @JsonProperty("total_count")
      private int totalCount;

      @JsonProperty("booked_count")
      private int bookedCount;

      @JsonProperty("failed_count")
      private int failedCount;

      @JsonProperty("state")
      private int state;

      public String getInvoiceRequestId() {
          return invoiceRequestId;
      }

      public void setInvoiceRequestId(String invoiceRequestId) {
          this.invoiceRequestId = invoiceRequestId;
      }

      public String getBookedAt() {
          return bookedAt;
      }

      public void setBookedAt(String bookedAt) {
          this.bookedAt = bookedAt;
      }

      public int getTotalCount() {
          return totalCount;
      }

      public void setTotalCount(int totalCount) {
          this.totalCount = totalCount;
      }

      public int getBookedCount() {
          return bookedCount;
      }

      public void setBookedCount(int bookedCount) {
          this.bookedCount = bookedCount;
      }

      public int getFailedCount() {
          return failedCount;
      }

      public void setFailedCount(int failedCount) {
          this.failedCount = failedCount;
      }

      public int getState() {
          return state;
      }

      public void setState(int state) {
          this.state = state;
      }

}
