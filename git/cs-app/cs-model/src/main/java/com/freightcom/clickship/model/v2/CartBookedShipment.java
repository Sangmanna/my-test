package com.freightcom.clickship.model.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CartBookedShipment {
	 @JsonProperty("error_type")
     private String errorType;

     @JsonProperty("error_message")
     private String errorMessage;

     @JsonProperty("shipment_id")
     private String shipmentId;

     @JsonProperty("booking_request_id")
     private String bookingRequestId;

     @JsonProperty("rate_request_id")
     private String rateRequestId;

     @JsonProperty("carrier_id")
     private String carrierId;

     @JsonProperty("service_id")
     private String serviceId;

     @JsonProperty("booked_at")
     private String bookedAt;

     @JsonProperty("transit_time_days")
     private int transitTimeDays;

     @JsonProperty("payment_type")
     private String paymentType;

     @JsonProperty("price_data")
     private Object priceData;
     
     public String getErrorType() {
         return errorType;
     }

     public void setErrorType(String errorType) {
         this.errorType = errorType;
     }

     public String getErrorMessage() {
         return errorMessage;
     }

     public void setErrorMessage(String errorMessage) {
         this.errorMessage = errorMessage;
     }

     public String getShipmentId() {
         return shipmentId;
     }

     public void setShipmentId(String shipmentId) {
         this.shipmentId = shipmentId;
     }

     public String getBookingRequestId() {
         return bookingRequestId;
     }

     public void setBookingRequestId(String bookingRequestId) {
         this.bookingRequestId = bookingRequestId;
     }

     public String getRateRequestId() {
         return rateRequestId;
     }

     public void setRateRequestId(String rateRequestId) {
         this.rateRequestId = rateRequestId;
     }

     public String getCarrierId() {
         return carrierId;
     }

     public void setCarrierId(String carrierId) {
         this.carrierId = carrierId;
     }

     public String getServiceId() {
         return serviceId;
     }

     public void setServiceId(String serviceId) {
         this.serviceId = serviceId;
     }

     public String getBookedAt() {
         return bookedAt;
     }

     public void setBookedAt(String bookedAt) {
         this.bookedAt = bookedAt;
     }

     public int getTransitTimeDays() {
         return transitTimeDays;
     }

     public void setTransitTimeDays(int transitTimeDays) {
         this.transitTimeDays = transitTimeDays;
     }

     public String getPaymentType() {
         return paymentType;
     }

     public void setPaymentType(String paymentType) {
         this.paymentType = paymentType;
     }

     public Object getPriceData() {
         return priceData;
     }

     public void setPriceData(Object priceData) {
         this.priceData = priceData;
     }
     
     
}
