package com.freightcom.clickship.service.service.integrations.ebay;

import static com.freightcom.clickship.model.util.ClickshipStringUtil.removeSpecialCharsAndAreaCode;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.freightcom.clickship.data.entity.Discount;
import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.data.entity.MarketplaceProduct;
import com.freightcom.clickship.data.entity.Order;
import com.freightcom.clickship.data.entity.Orderline;
import com.freightcom.clickship.data.entity.OrderlineDiscount;
import com.freightcom.clickship.data.entity.common.ClickShipOrderStatus;
import com.freightcom.clickship.data.rep.MarketplaceProductRepository;
import com.freightcom.clickship.data.rep.OrderlineRepository;
import com.freightcom.clickship.model.marketplace.ebay.Address;
import com.freightcom.clickship.model.marketplace.ebay.AppliedPromotion;
import com.freightcom.clickship.model.marketplace.ebay.EbayOrder;
import com.freightcom.clickship.model.marketplace.ebay.ExtendedContact;
import com.freightcom.clickship.model.marketplace.ebay.FulfillmentStartInstruction;
import com.freightcom.clickship.model.marketplace.ebay.LineItem;
import com.freightcom.clickship.model.marketplace.ebay.PricingSummary;
import com.freightcom.clickship.model.util.CountryConverter;
import com.freightcom.clickship.model.util.NumberUtility;

@Component
public class EbayTransformer {

    @Autowired
    private OrderlineRepository orderlineRepository;

    @Autowired
    private MarketplaceProductRepository marketplaceProductRepository;
    
    public Order createBaseOrder(Marketplace marketplace) {
        return new Order().setMarketplace(marketplace).setCustomer(marketplace.getCustomer())
        	.setShipfromCompany(marketplace.getCustomer().getBusinessName()).setShipfromContact(marketplace.getCustomer().getContactName())
        	.setShipfromEmail(marketplace.getCustomer().getEmail()).setShipfromPhone(removeSpecialCharsAndAreaCode(marketplace.getCustomer().getPhone()));
    }

    public Order setOrderInfo(Order order, EbayOrder ebayOrder) {
        setOrderGeneralInfo(order, ebayOrder);
        setOrderCostInfo(order, ebayOrder);
        setOrderStatusInfo(order, ebayOrder);
        setOrderShipToInfo(order, ebayOrder);

        return order;
    }
    
    public void setDiscounts(Order order, EbayOrder ebayOrder) {
		if (ebayOrder.getPricingSummary() != null && ebayOrder.getPricingSummary().getPriceDiscount() != null) {
			Discount discount = null;
			double value = NumberUtility.getSafeCheckDoubleValue(ebayOrder.getPricingSummary().getPriceDiscount().getValue());

			if (CollectionUtils.isNotEmpty(order.getDiscounts())) {
				Optional<Discount> optional = order.getDiscounts().stream().filter(d -> StringUtils.equals(d.getType(), "Total Discount")).findFirst();

				if (optional.isPresent()) {
					discount = optional.get();
				}
			}
			
			if(discount == null) {
				discount = new Discount(order);
				discount.setType("Total Discount");
				order.addDiscount(discount);
			}
			
			discount.setValue(value);
		}

		if (ebayOrder.getPricingSummary() != null && ebayOrder.getPricingSummary().getDeliveryDiscount() != null) {
			Discount discount = null;
			double value = NumberUtility.getSafeCheckDoubleValue(ebayOrder.getPricingSummary().getDeliveryDiscount().getValue());
			
			if (CollectionUtils.isNotEmpty(order.getDiscounts())) {
				Optional<Discount> optional = order.getDiscounts().stream().filter(d -> StringUtils.equals(d.getType(), "Delivery Discount")).findFirst();

				if (optional.isPresent()) {
					discount = optional.get();
				}
			}
			
			if(discount == null) {
				discount = new Discount(order);
				discount.setType("Delivery Discount");
				order.addDiscount(discount);
			}
			
			discount.setValue(value);
		}
	}
    
    @Transactional(propagation = Propagation.REQUIRED)
	public void setLineItems(Order order, EbayOrder ebayOrder ) {
		int lineItemNo = 0;

		for (LineItem lineItem : ebayOrder.getLineItems()) {
			String lineItemId = lineItem.getLineItemId();

			Orderline orderline = orderlineRepository.findByExternalLineIdAndOrder(lineItemId, order);
			if (orderline == null) {
				orderline = new Orderline().setOrder(order).setExternalLineId("" + lineItem.getLineItemId()).setLineNumber(++lineItemNo);
			}

			setProductInfo(order.getMarketplace(), orderline, lineItem);

			orderline.setQuantity(lineItem.getQuantity()).setSku(lineItem.getSku()).setVariantId(lineItem.getLegacyVariationId());
			
			if(lineItem.getLineItemCost() != null) {
				double lineItemCost = NumberUtility.getSafeCheckDoubleValue(lineItem.getLineItemCost().getValue());
				orderline.setUnitPrice(NumberUtility.round( lineItemCost / lineItem.getQuantity(), 2)).setLineSubtotal(lineItemCost);
			}
			
			if(lineItem.getDiscountedLineItemCost() != null) {
				orderline.setDiscount(NumberUtility.round(NumberUtility.getSafeCheckDoubleValue(lineItem.getDiscountedLineItemCost().getValue())));
			}
			
			if(CollectionUtils.isNotEmpty(order.getDiscounts()) && CollectionUtils.isNotEmpty(lineItem.getAppliedPromotions())) {
				setOrderlineDiscount(order, orderline, lineItem);	
			}
			
			order.addOrderline(orderline);
		}
	}
    
    private void setOrderGeneralInfo(Order order, EbayOrder ebayOrder) {
        order.setOrderNumber(ebayOrder.getOrderId()).setOrderDate(ebayOrder.getCreationDate());
    }
    
	private void setOrderCostInfo(Order order, EbayOrder ebayOrder) {
		PricingSummary pricingSummary = ebayOrder.getPricingSummary();

		if (pricingSummary != null && pricingSummary.getTotal() != null) {
			order.setTotal(NumberUtility.getSafeCheckDoubleValue(pricingSummary.getTotal().getValue()))
					.setOriginalTotal(NumberUtility.getSafeCheckDoubleValue(pricingSummary.getTotal().getValue()))
					.setCostCurrency(pricingSummary.getTotal().getCurrency());
		}

		if (pricingSummary != null && pricingSummary.getPriceSubtotal() != null) {
			order.setSubtotal(NumberUtility.getSafeCheckDoubleValue(pricingSummary.getPriceSubtotal().getValue()));
		}

		if (pricingSummary != null && pricingSummary.getTax() != null) {
			order.setTaxes(NumberUtility.getSafeCheckDoubleValue(pricingSummary.getTax().getValue()));
		}

		if (pricingSummary != null && pricingSummary.getPriceDiscount() != null) {
			order.setTotalDiscounts(NumberUtility.getSafeCheckDoubleValue(pricingSummary.getPriceDiscount().getValue()));
		}
		
		if (pricingSummary != null && pricingSummary.getDeliveryCost() != null) {
			// As per eBay documentation delivery discount value will be the negative number. Directly sum the delivery discount
			// with original value. 
			double deliveryDiscount = pricingSummary.getDeliveryDiscount() != null ? 
					NumberUtility.getSafeCheckDoubleValue(pricingSummary.getDeliveryDiscount().getValue()) : 0d; 
			
			order.setOriginalShippingCurrency(pricingSummary.getDeliveryCost().getCurrency())
				.setShippingCurrency(pricingSummary.getDeliveryCost().getCurrency())
				.setOriginalShippingCost(NumberUtility.getSafeCheckDoubleValue(pricingSummary.getDeliveryCost().getValue()) + deliveryDiscount)
				.setShippingCost(NumberUtility.getSafeCheckDoubleValue(pricingSummary.getDeliveryCost().getValue()) + deliveryDiscount);
		}
	}
	
	private void setOrderStatusInfo(Order order, EbayOrder ebayOrder) {
		if (!StringUtils.equalsIgnoreCase(order.getStatus(), ClickShipOrderStatus.Fulfilled.getValue())) {

			if (StringUtils.equalsIgnoreCase(ebayOrder.getOrderPaymentStatus(), "PAID")) {
				String ebayFulfillmentStatus = ebayOrder.getOrderFulfillmentStatus();

				if (StringUtils.equalsAnyIgnoreCase(ebayFulfillmentStatus, "FULFILLED", "IN_PROGRESS")) {
					ClickShipOrderStatus status = CollectionUtils.isEmpty(order.getShipments()) ? 
							ClickShipOrderStatus.ExternallyFulfilled : ClickShipOrderStatus.UnFulfilled; 
					order.setStatus(status);
					order.setExternallyFulfilledDate(new Date());
				} else if (StringUtils.equalsIgnoreCase(ebayFulfillmentStatus, "NOT_STARTED")) {
					order.setStatus(ClickShipOrderStatus.UnFulfilled);
				} else {
					order.setStatus(ClickShipOrderStatus.Pending);
				}
			} else if (StringUtils.equalsIgnoreCase(ebayOrder.getOrderPaymentStatus(), "FULLY_REFUNDED")) {
				order.setStatus(ClickShipOrderStatus.Cancelled);
			} else {
				order.setStatus(ClickShipOrderStatus.Pending);
			}
		}
	}

	private void setOrderShipToInfo(Order order, EbayOrder ebayOrder) {
		List<FulfillmentStartInstruction> fulfillmentStartInstructions = ebayOrder.getFulfillmentStartInstructions();
		ExtendedContact shipToInfo = CollectionUtils.isNotEmpty(fulfillmentStartInstructions) 
				? fulfillmentStartInstructions.get(0).getShippingStep().getShipTo() : null;
			
		 if(shipToInfo != null) {
			Address contactAddress = shipToInfo.getContactAddress();
			
			order.setShiptoCompany(shipToInfo.getFullName()).setShiptoContact(shipToInfo.getFullName())
				.setShiptoEmail(shipToInfo.getEmail()).setShiptoPhone(shipToInfo.getPrimaryPhone().getPhoneNumber())
				.setShiptoAddress1(contactAddress.getAddressLine1()).setShiptoAddress2(contactAddress.getAddressLine2())
				.setShiptoCity(contactAddress.getCity()).setShiptoProvinceState(contactAddress.getStateOrProvince())
				.setShiptoCountry(CountryConverter.unknownIsoToIso2CountryCode(contactAddress.getCountryCode()))
				.setShiptoZip(contactAddress.getPostalCode());				 
		 }
	}

	private void setOrderlineDiscount(Order order, Orderline orderline, LineItem lineItem) {
		Optional<Discount> optional = order.getDiscounts().stream()
				.filter(d -> StringUtils.equals(d.getType(), "Total Discount")).findFirst();
		
		if(optional.isPresent()) {
			double totalDiscount = 0d;
			for (AppliedPromotion appliedPromotion : lineItem.getAppliedPromotions()) {
				totalDiscount += NumberUtility.getSafeCheckDoubleValue(appliedPromotion.getDiscountAmount().getValue());
			}

			OrderlineDiscount od = orderline.getOrderlineDiscount();

			if (od == null) {
				od = new OrderlineDiscount();
				od.setOrderline(orderline);
			}

			od.setAmount(totalDiscount);
			od.setDiscount(optional.get());
			orderline.setOrderlineDiscount(od);			
		}
	}
	
	private void setProductInfo(Marketplace marketplace, Orderline orderLine, LineItem lineItem) {
		MarketplaceProduct csProduct = marketplaceProductRepository.findByMarketplaceAndExternalProductIdAndVariantId(
				marketplace, Long.valueOf(lineItem.getLegacyItemId()), lineItem.getLegacyVariationId());
		
		if (csProduct == null) {
			csProduct = createBaseProduct(marketplace);
		} 
		
		setProductGeneralInfo(csProduct, lineItem);
		marketplaceProductRepository.save(csProduct);

		if (csProduct != null) {
			orderLine.setMarketplaceProduct(csProduct).setTitle(csProduct.getTitle()).setHsCode(csProduct.getHsCode());
		}
	}
	
    private MarketplaceProduct createBaseProduct(Marketplace marketplace) {
        return new MarketplaceProduct().setMarketplace(marketplace).setCustomer(marketplace.getCustomer());
    }
    
	private void setProductGeneralInfo(MarketplaceProduct product, LineItem lineItem) {
		product.setExternalProductId(Long.valueOf(lineItem.getLegacyItemId())).setTitle(lineItem.getTitle())
			.setQuantity(lineItem.getQuantity()).setSku(lineItem.getSku()).setQuantity(lineItem.getQuantity())
			.setVariantId(lineItem.getLegacyVariationId()).setPrice(NumberUtility.getSafeCheckDoubleValue(lineItem.getLineItemCost().getValue()));
	}
}

