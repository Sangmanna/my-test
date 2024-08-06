package com.freightcom.clickship.service.service.integrations.reebelo;

import static com.freightcom.clickship.model.util.ClickshipStringUtil.removeSpecialCharsAndAreaCode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import com.freightcom.clickship.data.entity.Tax;
import com.freightcom.clickship.data.entity.common.ClickShipOrderStatus;
import com.freightcom.clickship.data.rep.MarketplaceProductRepository;
import com.freightcom.clickship.data.rep.OrderlineRepository;
import com.freightcom.clickship.data.rep.TaxRepository;
import com.freightcom.clickship.model.marketplace.MarketplaceDTO;
import com.freightcom.clickship.model.marketplace.reebelo.ReebeloAddress;
import com.freightcom.clickship.model.marketplace.reebelo.ReebeloDiscount;
import com.freightcom.clickship.model.marketplace.reebelo.ReebeloFinancialStatus;
import com.freightcom.clickship.model.marketplace.reebelo.ReebeloFulfillment;
import com.freightcom.clickship.model.marketplace.reebelo.ReebeloLineItemDiscount;
import com.freightcom.clickship.model.marketplace.reebelo.ReebeloOrder;
import com.freightcom.clickship.model.marketplace.reebelo.ReebeloOrderLineItem;
import com.freightcom.clickship.model.marketplace.reebelo.ReebeloOrderShippingCost;
import com.freightcom.clickship.model.marketplace.reebelo.ReebeloPrice;
import com.freightcom.clickship.model.marketplace.reebelo.ReebeloProduct;
import com.freightcom.clickship.model.marketplace.reebelo.ReebeloVariant;
import com.freightcom.clickship.model.util.ClickshipStringUtil;

@Component
public class ReebeloTransformer {
	
	private Logger logger = LogManager.getLogger(ReebeloTransformer.class);	
	
	@Autowired
	private TaxRepository taxRepository;
	
	@Autowired
	private OrderlineRepository orderlineRepository;
	
	@Autowired
	private MarketplaceProductRepository marketplaceProductRepository;
	
	public MarketplaceProduct createBaseProduct(Marketplace marketplace) {
		return new MarketplaceProduct().setMarketplace(marketplace).setCustomer(marketplace.getCustomer());
	}
	
	public void setProductGeneralInfo(MarketplaceProduct product, ReebeloProduct reebeloProduct, ReebeloVariant variant) {
		product.setExternalProductId(variant.getProductId()).setSku(variant.getSku()).setVariantId("" + variant.getId())
			.setTitle(getProductTitle(reebeloProduct, variant)).setPrice(variant.getPrice());
	}
	
	public String getProductTitle(ReebeloProduct reebeloProduct, ReebeloVariant variant) {
		if ("Default Title".equals(variant.getTitle())) {
			return reebeloProduct.getTitle();
		} else {
			return variant.getTitle();
		}
	}
	
	public MarketplaceProduct getReebeloVariant(Marketplace marketplace, ReebeloProduct reebeloProduct, ReebeloVariant variant) {
		MarketplaceProduct csProduct = createBaseProduct(marketplace);
		setProductGeneralInfo(csProduct, reebeloProduct, variant);
		return csProduct;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	private void updateProduct(Marketplace marketplace, ReebeloProduct reebeloProduct) {
		List<ReebeloVariant> variants = reebeloProduct.getVariants();
		for (ReebeloVariant variant : variants) {
			MarketplaceProduct csProduct = marketplaceProductRepository
					.findByMarketplaceAndExternalProductIdAndVariantId(marketplace, variant.getProductId(), "" + variant.getId());
			if (csProduct == null) {
				csProduct = getReebeloVariant(marketplace, reebeloProduct, variant);
			} else {
				String title = getProductTitle(reebeloProduct, variant);
				csProduct.setSku(variant.getSku()).setPrice(variant.getPrice()).setTitle(title).setMarketplace(marketplace);
			}
			marketplaceProductRepository.save(csProduct);
		}
	}
	
	public Order getCsOrder(Marketplace marketplace, ReebeloOrder reebeloOrder) {
		Order order = createBaseOrder(marketplace);
		setOrderGerneralInfo(order, reebeloOrder);
		setOrderCostInfo(order, reebeloOrder);
		setOrderStatusInfo(order, reebeloOrder);
		setOrderShiptoInfo(order, reebeloOrder);
		setOrderBilltoInfo(order, reebeloOrder);
		setOrderShippingInfo(order, reebeloOrder);
		return order;
	}
	
	public void setOrderCostInfo(Order order, ReebeloOrder reebeloOrder) {
		order.setTaxes(reebeloOrder.getTotalTax())
			.setTotal(reebeloOrder.getTotalPrice())
			.setSubtotal(reebeloOrder.getSubTotal())
			.setCostCurrency(reebeloOrder.getCurrency())
			.setOriginalTotal(reebeloOrder.getTotalPrice())
			.setTotalDiscounts(reebeloOrder.getTotalDiscount());
	}
	
	public void setOrderStatusInfo(Order order, ReebeloOrder reebeloOrder) {
		if (reebeloOrder.getCancelledDate() != null) {
			order.setStatus(ClickShipOrderStatus.Cancelled);
		} else {
			String reebeloFulfillmentStatus = reebeloOrder.getFulfillmentStatus();
			String financialStatus = reebeloOrder.getStatus();
			if (StringUtils.equalsIgnoreCase(reebeloFulfillmentStatus, "fulfilled")) {
				order.setStatus(ClickShipOrderStatus.ExternallyFulfilled);
				order.setExternallyFulfilledDate(new Date());
			} else if (StringUtils.equalsIgnoreCase(reebeloFulfillmentStatus, "partial")) {
				order.setStatus(ClickShipOrderStatus.UnFulfilled);
			} else if (StringUtils.equalsAnyIgnoreCase(financialStatus, ReebeloFinancialStatus.AUTHORIZED.getValue(), ReebeloFinancialStatus.PAID.getValue(),
					ReebeloFinancialStatus.PARTIALLY_REFUNDED.getValue())){
				order.setStatus(ClickShipOrderStatus.UnFulfilled);
			} else if (ReebeloFinancialStatus.VOIDED.toString().equalsIgnoreCase(financialStatus) || 
					ReebeloFinancialStatus.REFUNDED.toString().equalsIgnoreCase(financialStatus)) {
				order.setStatus(ClickShipOrderStatus.Cancelled);
			} else {
				order.setStatus(ClickShipOrderStatus.Pending);
			}
		}
	}
	
	public void setOrderShiptoInfo(Order order, ReebeloOrder reebeloOrder) {
		ReebeloAddress shippingAddress = reebeloOrder.getShippingAddress();
		if (shippingAddress != null) {
			order.setShiptoAddress1(shippingAddress.getAddress1())
				.setShiptoAddress2(shippingAddress.getAddress2())
				.setShiptoCompany(shippingAddress.getCompany())
				.setShiptoCity(shippingAddress.getCity())
				.setShiptoCountry(shippingAddress.getCountryCode())
				.setShiptoEmail(reebeloOrder.getEmail())
				.setShiptoContact(shippingAddress.getFullName().trim())
				.setShiptoPhone(ClickshipStringUtil.removeSpecialCharsAndAreaCode(shippingAddress.getPhone()))
				.setShiptoProvinceState(shippingAddress.getProvinceCode())
				.setShiptoZip(shippingAddress.getPostalCode());
			if(StringUtils.isEmpty(order.getShiptoCompany())) {
				order.setShiptoCompany(order.getShiptoContact());
			}
			if(StringUtils.isEmpty(order.getShiptoContact())) {
				order.setShiptoContact(order.getShiptoCompany());
			}
		}
	}
	
	public void setOrderBilltoInfo(Order order, ReebeloOrder reebeloOrder) {
		ReebeloAddress billingAddress = reebeloOrder.getBillingAddress();
		if (billingAddress != null) {
			order.setBilltoAddress1(billingAddress.getAddress1())
				.setBilltoAddress2(billingAddress.getAddress2())
				.setBilltoContact(billingAddress.getFullName().trim())
				.setBilltoCity(billingAddress.getCity())
				.setBilltoCountry(billingAddress.getCountryCode())
				.setBilltoEmail(reebeloOrder.getEmail())
				.setBilltoPhone(ClickshipStringUtil.removeSpecialCharsAndAreaCode(billingAddress.getPhone()))
				.setBilltoProvinceState(billingAddress.getProvinceCode())
				.setBilltoPostalcode(billingAddress.getPostalCode());
		}
	}
	
	@Transactional
	public List<Discount> getDiscountsFromReebeloOrder(ReebeloOrder reebeloOrder, Order order) {
		List<Discount> list = new ArrayList<>();
		if(CollectionUtils.isNotEmpty(reebeloOrder.getDiscounts())) {
			list = reebeloOrder.getDiscounts().stream().filter(d -> !"line_item".equalsIgnoreCase(d.getTargetType())).map(d -> 
				getDiscount(order, d)
			).collect(Collectors.toList());
		}
		return list;
	}
	
	@Transactional
	public List<Tax> getTaxesFromReebeloOrder(ReebeloOrder reebeloOrder, Order order) {
		List<Tax> list = new ArrayList<>();
		if(CollectionUtils.isNotEmpty(reebeloOrder.getTaxes())) {
			list = reebeloOrder.getTaxes().stream().map(t -> {
				Tax tax = taxRepository.findByTitleAndOrder(t.getType(), order);
				if(tax == null) {
					tax = new Tax(order);	
				}
				tax.setRate(t.getRate()).setTitle(t.getType()).setPrice(t.getTotalTax());
				return tax;
			}).collect(Collectors.toList());
		}
		return list;
	}
	
	@Transactional
	public List<Orderline> getLineItems(ReebeloOrder reebeloOrder, Order order) {
		List<Orderline> items = new ArrayList<>();
		int i=0;
		for(ReebeloOrderLineItem sl : reebeloOrder.getOrderLines()) {
			Marketplace marketplace = order.getMarketplace();
			if(sl.isProductExist()) {
				Orderline obj = orderlineRepository.findByExternalLineIdAndOrder(sl.getId().toString(), order);
				if(obj == null) {
					obj = new Orderline().setOrder(order).setExternalLineId("" + sl.getId()).setLineNumber(++i);
					setLineItemDiscount(order, reebeloOrder, obj, sl);
				}
				setProductInfo(marketplace, obj, sl);
				obj.setQuantity(sl.getQuantity()).setUnitPrice(sl.getPrice()).setLineSubtotal(sl.getSubTotal()).setSku(sl.getSku());
				items.add(obj);
			}
		}
		return items;
	}
	
	public void setOrderShippingInfo(Order order, ReebeloOrder reebeloOrder) {
		List<ReebeloFulfillment> fulfillments = reebeloOrder.getFulfillments();
		ReebeloOrderShippingCost shippingCost = reebeloOrder.getShippingCost();
		if(shippingCost != null && shippingCost.getCost() != null) {
			ReebeloPrice reebeloPrice = shippingCost.getCost();
			order.setOriginalShippingCost(reebeloPrice.getAmount()).setShippingCost(reebeloPrice.getAmount())
			 .setOriginalShippingCurrency(reebeloPrice.getCurrency()).setShippingCurrency(reebeloPrice.getCurrency());
		}
		if(CollectionUtils.isNotEmpty(fulfillments) && fulfillments.size() == 1) {
			ReebeloFulfillment reebeloFilfillment = fulfillments.get(0);
			order.setShipDate(reebeloFilfillment.getUpdatedDate());
			String externalFulfilmentId = "", carrierName = "";
			externalFulfilmentId = fulfillments.stream().map(sf -> Long.toString(sf.getId())).collect(Collectors.joining("|"));
			carrierName = fulfillments.stream().map(ReebeloFulfillment::getTrackingCompany).collect(Collectors.joining("|"));
			order.setServiceType(carrierName);
			order.setExternalFulfillmentId(externalFulfilmentId);
		}
	}
	
	private Order createBaseOrder(Marketplace marketplace) {
		Order order = new Order();
		order.setMarketplace(marketplace)
			.setCustomer(marketplace.getCustomer())
			.setShipfromEmail(marketplace.getCustomer().getEmail())
			.setShipfromContact(marketplace.getCustomer().getContactName())
			.setShipfromCompany(marketplace.getCustomer().getBusinessName())
			.setShipfromPhone(removeSpecialCharsAndAreaCode(marketplace.getCustomer().getPhone()));
		return order;
	}
	
	private void setOrderGerneralInfo(Order order, ReebeloOrder reebeloOrder) {
		order.setNote(reebeloOrder.getNote())
			.setExternalOrderId("" + reebeloOrder.getId())
			.setOrderNumber(reebeloOrder.getOrderNumber().toString())
			.setOrderDate(reebeloOrder.getCreatedDate());
	}
	
	private void setLineItemDiscount(Order order, ReebeloOrder reebeloOrder, Orderline orderline, ReebeloOrderLineItem lineItem) {
		if(CollectionUtils.isNotEmpty(lineItem.getDiscounts())){
			for(ReebeloLineItemDiscount d : lineItem.getDiscounts()) {
				OrderlineDiscount od = orderline.getOrderlineDiscount();
				if(od == null) {
					ReebeloDiscount sd = reebeloOrder.getDiscounts().get(d.getDiscountIndex());
					Discount discount = getDiscount(order, sd);
					order.addDiscount(discount);
					od = new OrderlineDiscount(orderline, discount);	
				}
				od.setAmount(d.getAmount());
				orderline.setOrderlineDiscount(od);
			}
		}
	}	
	
	/*
	 * Preparing Product from Orderlines not making product api call
	 */
	@Transactional
	private void setProductInfo(Marketplace marketplace, Orderline orderLine, ReebeloOrderLineItem lineItem) {
		String variantId = "" + lineItem.getVariantId();
		long externalProductId = lineItem.getProductId();
		MarketplaceProduct csProduct = marketplaceProductRepository.findByMarketplaceAndExternalProductIdAndVariantId(marketplace, externalProductId, variantId);
		if(csProduct == null) {
			try {
				ReebeloProduct reebeloProduct = new ReebeloProduct(); 
				ReebeloVariant reebeloVariant= new ReebeloVariant();
				reebeloVariant.setId(lineItem.getVariantId());
				reebeloVariant.setProductId(lineItem.getProductId());
				reebeloVariant.setPrice(lineItem.getPrice());
				reebeloVariant.setSku(lineItem.getSku());
				reebeloVariant.setQuantity(lineItem.getQuantity());
				reebeloVariant.setTitle(lineItem.getName());
				List<ReebeloVariant> list= new ArrayList<>();
				list.add(reebeloVariant);
				reebeloProduct.setVariants(list);
				reebeloProduct.setId(lineItem.getId());
				if(reebeloProduct != null) {
					updateProduct(marketplace, reebeloProduct);
				}
			} catch (Exception e) {
				logger.debug("Exception while Preparing Reebelo Product:[{}] missing product:[{}]", marketplace.getId(), "" + externalProductId);
			}
			csProduct = marketplaceProductRepository.findByMarketplaceAndExternalProductIdAndVariantId(marketplace, externalProductId, variantId);
		}
		if(csProduct != null) {
			orderLine.setMarketplaceProduct(csProduct).setTitle(csProduct.getTitle()).setHsCode(csProduct.getHsCode());
		} 
	}

	public MarketplaceDTO getMarketplaceDto(Marketplace marketplace) {
		return new MarketplaceDTO().setUrl(marketplace.getStoreUrl()).setAccessToken(marketplace.getToken());
	}
	
	private Discount getDiscount(Order order, ReebeloDiscount sd) {
		Discount discount = new Discount(order);
		discount.setType(sd.getType());
		discount.setTitle(sd.getTitle());
		discount.setValue(sd.getValue());
		discount.setValueType(sd.getValueType());
		discount.setAllocationMethod(sd.getAllocationMethod());
		discount.setTargetSelection(sd.getTargetSelection());
		discount.setTargetType(sd.getTargetType());
		discount.setCode(sd.getCode());
		return discount;
	}
}