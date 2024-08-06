package com.freightcom.clickship.model.marketplace.amazon;


import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

import com.freightcom.clickship.model.marketplace.amazon.orders.OrderTotal;
import com.freightcom.clickship.model.marketplace.amazon.orders.PaymentMethodDetails;
import com.freightcom.clickship.model.marketplace.amazon.orders.ShippingAddress;

//@XmlRootElement(name = "Order")
@XmlAccessorType(XmlAccessType.FIELD)
public class AmazonOrder implements Serializable {

	private static final long serialVersionUID = 7520542241215034873L;
	
	@XmlElement(name = "LatestShipDate")
	private String latestShipDate;
	
	@XmlElement(name = "OrderType")
	private String orderType;
	
	@XmlElement(name = "PurchaseDate")
	private String purchaseDate;
	
	@XmlElement(name = "BuyerEmail")
	private String buyerEmail;
	
	@XmlElement(name = "AmazonOrderId")
	private String amazonOrderId;
	
	@XmlElement(name = "IsReplacementOrder")
	private String isReplacementOrder;
	
	@XmlElement(name = "LastUpdateDate")
	private String lastUpdateDate;
	
	@XmlElement(name = "NumberOfItemsShipped")
	private String numberOfItemsShipped;
	
	@XmlElement(name = "ShipServiceLevel")
	private String shipServiceLevel;
	
	@XmlElement(name = "OrderStatus")
	private String orderStatus;
	
	@XmlElement(name = "SalesChannel")
	private String salesChannel;
	
	@XmlElement(name = "ShippedByAmazonTFM")
	private String shippedByAmazonTFM;
	
	@XmlElement(name = "IsBusinessOrder")
	private String isBusinessOrder;
	
	@XmlElement(name = "NumberOfItemsUnshipped")
	private String numberOfItemsUnshipped;
	
	@XmlElement(name = "LatestDeliveryDate")
	private String latestDeliveryDate;
	
	@XmlElement(name = "PaymentMethodDetails")
	private PaymentMethodDetails paymentMethodDetails;
	
	@XmlElement(name = "IsGlobalExpressEnabled")
	private String isGlobalExpressEnabled;
	
	@XmlElement(name = "IsSoldByAB")
	private String isSoldByAB;
	
	@XmlElement(name = "EarliestDeliveryDate")
	private String earliestDeliveryDate;
	
	@XmlElement(name = "IsPremiumOrder")
	private String isPremiumOrder;
	
	@XmlElement(name = "OrderTotal")
	private OrderTotal orderTotal;
	
	@XmlElement(name = "EarliestShipDate")
	private String earliestShipDate;
	
	@XmlElement(name = "MarketplaceId")
	private String marketplaceId;
	
	@XmlElement(name = "FulfillmentChannel")
	private String fulfillmentChannel;
	
	@XmlElement(name = "PaymentMethod")
	private String paymentMethod;
	
	@XmlElement(name = "ShippingAddress")
	private ShippingAddress shippingAddress;
	
	@XmlElement(name = "IsPrime")
	private String isPrime;
	
	@XmlElement(name = "ShipmentServiceLevelCategory")
	private String shipmentServiceLevelCategory;
	
	public AmazonOrder() {
		super();
	}

	public AmazonOrder(String latestShipDate, String orderType, String purchaseDate, String buyerEmail, String amazonOrderId,
			String isReplacementOrder, String lastUpdateDate, String numberOfItemsShipped, String shipServiceLevel,
			String orderStatus, String salesChannel, String shippedByAmazonTFM, String isBusinessOrder,
			String numberOfItemsUnshipped, String latestDeliveryDate, PaymentMethodDetails paymentMethodDetails,
			String isGlobalExpressEnabled, String isSoldByAB, String earliestDeliveryDate, String isPremiumOrder,
			OrderTotal orderTotal, String earliestShipDate, String marketplaceId, String fulfillmentChannel,
			String paymentMethod, ShippingAddress shippingAddress, String isPrime,
			String shipmentServiceLevelCategory) {
		super();
		
		this.latestShipDate = latestShipDate;
		this.orderType = orderType;
		this.purchaseDate = purchaseDate;
		this.buyerEmail = buyerEmail;
		this.amazonOrderId = amazonOrderId;
		this.isReplacementOrder = isReplacementOrder;
		this.lastUpdateDate = lastUpdateDate;
		this.numberOfItemsShipped = numberOfItemsShipped;
		this.shipServiceLevel = shipServiceLevel;
		this.orderStatus = orderStatus;
		this.salesChannel = salesChannel;
		this.shippedByAmazonTFM = shippedByAmazonTFM;
		this.isBusinessOrder = isBusinessOrder;
		this.numberOfItemsUnshipped = numberOfItemsUnshipped;
		this.latestDeliveryDate = latestDeliveryDate;
		this.paymentMethodDetails = paymentMethodDetails;
		this.isGlobalExpressEnabled = isGlobalExpressEnabled;
		this.isSoldByAB = isSoldByAB;
		this.earliestDeliveryDate = earliestDeliveryDate;
		this.isPremiumOrder = isPremiumOrder;
		this.orderTotal = orderTotal;
		this.earliestShipDate = earliestShipDate;
		this.marketplaceId = marketplaceId;
		this.fulfillmentChannel = fulfillmentChannel;
		this.paymentMethod = paymentMethod;
		this.shippingAddress = shippingAddress;
		this.isPrime = isPrime;
		this.shipmentServiceLevelCategory = shipmentServiceLevelCategory;

	}

	public String getLatestShipDate() {
		return latestShipDate;
	}

	public void setLatestShipDate(String latestShipDate) {
		this.latestShipDate = latestShipDate;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}

	public String getAmazonOrderId() {
		return amazonOrderId;
	}

	public void setAmazonOrderId(String amazonOrderId) {
		this.amazonOrderId = amazonOrderId;
	}

	public String getIsReplacementOrder() {
		return isReplacementOrder;
	}

	public void setIsReplacementOrder(String isReplacementOrder) {
		this.isReplacementOrder = isReplacementOrder;
	}

	public String getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getNumberOfItemsShipped() {
		return numberOfItemsShipped;
	}

	public void setNumberOfItemsShipped(String numberOfItemsShipped) {
		this.numberOfItemsShipped = numberOfItemsShipped;
	}

	public String getShipServiceLevel() {
		return shipServiceLevel;
	}

	public void setShipServiceLevel(String shipServiceLevel) {
		this.shipServiceLevel = shipServiceLevel;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getSalesChannel() {
		return salesChannel;
	}

	public void setSalesChannel(String salesChannel) {
		this.salesChannel = salesChannel;
	}

	public String getShippedByAmazonTFM() {
		return shippedByAmazonTFM;
	}

	public void setShippedByAmazonTFM(String shippedByAmazonTFM) {
		this.shippedByAmazonTFM = shippedByAmazonTFM;
	}

	public String getIsBusinessOrder() {
		return isBusinessOrder;
	}

	public void setIsBusinessOrder(String isBusinessOrder) {
		this.isBusinessOrder = isBusinessOrder;
	}

	public String getNumberOfItemsUnshipped() {
		return numberOfItemsUnshipped;
	}

	public void setNumberOfItemsUnshipped(String numberOfItemsUnshipped) {
		this.numberOfItemsUnshipped = numberOfItemsUnshipped;
	}

	public String getLatestDeliveryDate() {
		return latestDeliveryDate;
	}

	public void setLatestDeliveryDate(String latestDeliveryDate) {
		this.latestDeliveryDate = latestDeliveryDate;
	}

	public PaymentMethodDetails getPaymentMethodDetails() {
		return paymentMethodDetails;
	}

	public void setPaymentMethodDetails(PaymentMethodDetails paymentMethodDetails) {
		this.paymentMethodDetails = paymentMethodDetails;
	}

	public String getIsGlobalExpressEnabled() {
		return isGlobalExpressEnabled;
	}

	public void setIsGlobalExpressEnabled(String isGlobalExpressEnabled) {
		this.isGlobalExpressEnabled = isGlobalExpressEnabled;
	}

	public String getIsSoldByAB() {
		return isSoldByAB;
	}

	public void setIsSoldByAB(String isSoldByAB) {
		this.isSoldByAB = isSoldByAB;
	}

	public String getEarliestDeliveryDate() {
		return earliestDeliveryDate;
	}

	public void setEarliestDeliveryDate(String earliestDeliveryDate) {
		this.earliestDeliveryDate = earliestDeliveryDate;
	}

	public String getIsPremiumOrder() {
		return isPremiumOrder;
	}

	public void setIsPremiumOrder(String isPremiumOrder) {
		this.isPremiumOrder = isPremiumOrder;
	}

	public OrderTotal getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(OrderTotal orderTotal) {
		this.orderTotal = orderTotal;
	}

	public String getEarliestShipDate() {
		return earliestShipDate;
	}

	public void setEarliestShipDate(String earliestShipDate) {
		this.earliestShipDate = earliestShipDate;
	}

	public String getMarketplaceId() {
		return marketplaceId;
	}

	public void setMarketplaceId(String marketplaceId) {
		this.marketplaceId = marketplaceId;
	}

	public String getFulfillmentChannel() {
		return fulfillmentChannel;
	}

	public void setFulfillmentChannel(String fulfillmentChannel) {
		this.fulfillmentChannel = fulfillmentChannel;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getIsPrime() {
		return isPrime;
	}

	public void setIsPrime(String isPrime) {
		this.isPrime = isPrime;
	}

	public String getShipmentServiceLevelCategory() {
		return shipmentServiceLevelCategory;
	}

	public void setShipmentServiceLevelCategory(String shipmentServiceLevelCategory) {
		this.shipmentServiceLevelCategory = shipmentServiceLevelCategory;
	}

}
