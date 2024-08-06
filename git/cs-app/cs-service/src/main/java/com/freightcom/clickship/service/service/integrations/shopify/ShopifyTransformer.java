package com.freightcom.clickship.service.service.integrations.shopify;

import static com.freightcom.clickship.model.util.ClickshipStringUtil.removeSpecialCharsAndAreaCode;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.freightcom.clickship.client.shopify.ShopifyRestClient;
import com.freightcom.clickship.data.entity.Carrier;
import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.CustomerAddress;
import com.freightcom.clickship.data.entity.Discount;
import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.data.entity.MarketplaceProduct;
import com.freightcom.clickship.data.entity.Order;
import com.freightcom.clickship.data.entity.Orderline;
import com.freightcom.clickship.data.entity.OrderlineDiscount;
import com.freightcom.clickship.data.entity.Tax;
import com.freightcom.clickship.data.entity.common.ClickShipOrderStatus;
import com.freightcom.clickship.data.rep.CarrierRepository;
import com.freightcom.clickship.data.rep.MarketplaceProductRepository;
import com.freightcom.clickship.data.rep.OrderlineRepository;
import com.freightcom.clickship.data.rep.TaxRepository;
import com.freightcom.clickship.event.service.AdvanceShippingRuleService;
import com.freightcom.clickship.model.constants.ClickShipConstants;
import com.freightcom.clickship.model.enums.AddressType;
import com.freightcom.clickship.model.enums.ShopifyFinancialStatus;
import com.freightcom.clickship.model.marketplace.MarketplaceDTO;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyAddress;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyDiscount;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyFulfillment;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyLineItemDiscount;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyOrder;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyOrderLineItem;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyOrderShippingCost;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyPrice;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyProduct;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyProductImage;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyShipping;
import com.freightcom.clickship.model.marketplace.shopify.ShopifyVariant;
import com.freightcom.clickship.model.util.ClickshipStringUtil;

@Component
public class ShopifyTransformer {
	
	private Logger logger = LogManager.getLogger(ShopifyTransformer.class);	
	
	private static final String CLICKSHIP_RATES = "Clickship Rates";
	
	@Autowired
	private ShopifyRestClient client;
	
	@Autowired
	private TaxRepository taxRepository;
	
	@Autowired
	private CarrierRepository carrierRepository;
	
	@Autowired
	private OrderlineRepository orderlineRepository;
	
	@Autowired
	private MarketplaceProductRepository marketplaceProductRepository;
	
	@Autowired
	private AdvanceShippingRuleService shippingRuleService;

	public MarketplaceProduct createBaseProduct(Marketplace marketplace) {
		return new MarketplaceProduct().setMarketplace(marketplace).setCustomer(marketplace.getCustomer());
	}
	
	public CustomerAddress createBaseAddress(Marketplace marketplace) {
		Customer customer = marketplace.getCustomer();
		return new CustomerAddress().setCustomer(customer).setBusinessName(customer.getBusinessName())
				.setFirstName(customer.getFirstName()).setLastName(customer.getLastName()).setEmail(customer.getEmail());
	}
	
	public void setProductGeneralInfo(MarketplaceProduct product, ShopifyProduct shopifyProduct, ShopifyVariant variant) {
		product.setExternalProductId(shopifyProduct.getId()).setSku(variant.getSku()).setVariantId("" + variant.getId())
			.setTitle(getProductTitle(shopifyProduct, variant)).setPrice(variant.getPrice());
	}
	
	public String getProductTitle(ShopifyProduct shopifyProduct, ShopifyVariant variant) {
		if ("Default Title".equals(variant.getTitle())) {
			return shopifyProduct.getTitle();
		} else {
			return shopifyProduct.getTitle() + " - " + variant.getTitle();
		}
	}
	
	public void setProductImage(MarketplaceProduct marketplaceProduct, ShopifyProduct shopifyProduct, ShopifyVariant variant) {
		if(shopifyProduct.getImage() != null) {
			Long imageId = variant.getImageId();
			ShopifyProductImage productImage = shopifyProduct.getImage();
			
			if(imageId != null) {
				for(ShopifyProductImage image : shopifyProduct.getImages()) {
					if(image != null && imageId.equals(image.getId())) {
						productImage = image;
						break;
					}
				}
			}
			
			marketplaceProduct.setImageUrl(productImage.getSrc());
		}
	}
	
	public void setProductWeight(MarketplaceProduct marketplaceProduct, ShopifyVariant variant) {
		String weightUnit = variant.getWeightUnit();
		double weight = variant.getWeight();
		
		if ("kg".equalsIgnoreCase(weightUnit)) {
			marketplaceProduct.setWeightMetric(weight);
			marketplaceProduct.setWeight(weight * ClickShipConstants.KG_TO_POUND);
			
		} else if ("lb".equalsIgnoreCase(weightUnit)) {
			marketplaceProduct.setWeightMetric(weight / ClickShipConstants.KG_TO_POUND);
			marketplaceProduct.setWeight(weight);
			
		} else if ("g".equalsIgnoreCase(weightUnit)) {
			marketplaceProduct.setWeightMetric(weight / 1000);
			marketplaceProduct.setWeight(weight / 1000 * ClickShipConstants.KG_TO_POUND);
			
		} else if ("oz".equalsIgnoreCase(weightUnit)) {
			marketplaceProduct.setWeightMetric(weight * 0.0283495);
			marketplaceProduct.setWeight(weight * 0.0625);
		}
	}
	
	public MarketplaceProduct getShopifyVariant(Marketplace marketplace, ShopifyProduct shopifyProduct, ShopifyVariant variant) {
		MarketplaceProduct csProduct = createBaseProduct(marketplace);
		
		setProductGeneralInfo(csProduct, shopifyProduct, variant);
		setProductImage(csProduct, shopifyProduct, variant);
		setProductWeight(csProduct, variant);
		
		return csProduct;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateProduct(Marketplace marketplace, ShopifyProduct shopifyProduct) {
		long productId = shopifyProduct.getId();
		List<ShopifyVariant> variants = shopifyProduct.getVariants();
		
		for (ShopifyVariant variant : variants) {
			MarketplaceProduct csProduct = marketplaceProductRepository
					.findByMarketplaceAndExternalProductIdAndVariantId(marketplace, productId, "" + variant.getId());
			
			if (csProduct == null) {
				// New Variant. -> Need to create
				csProduct = getShopifyVariant(marketplace, shopifyProduct, variant);
			} else {
				setProductWeight(csProduct, variant);
				setProductImage(csProduct, shopifyProduct, variant);
				String title = getProductTitle(shopifyProduct, variant);
				
				csProduct.setSku(variant.getSku()).setPrice(variant.getPrice()).setTitle(title);
			}
			
			marketplaceProductRepository.save(csProduct);
		}
	}
	
	public Order getCsOrder(Marketplace marketplace, ShopifyOrder shopifyOrder) {
		Order order = createBaseOrder(marketplace);
		
		setOrderGerneralInfo(order, shopifyOrder);
		setOrderCostInfo(order, shopifyOrder);
		setOrderStatusInfo(order, shopifyOrder);
		setOrderShiptoInfo(order, shopifyOrder);
		setOrderBilltoInfo(order, shopifyOrder);
		setOrderShippingInfo(order, shopifyOrder);
		
		return order;
	}
	
	public void setOrderCostInfo(Order order, ShopifyOrder shopifyOrder) {
		order.setTaxes(shopifyOrder.getTotalTax())
			.setTotal(shopifyOrder.getTotalPrice())
			.setSubtotal(shopifyOrder.getSubTotal())
			.setCostCurrency(shopifyOrder.getCurrency())
			.setOriginalTotal(shopifyOrder.getTotalPrice())
			.setTotalDiscounts(shopifyOrder.getTotalDiscount());
	}
	
	public void setOrderStatusInfo(Order order, ShopifyOrder shopifyOrder) {
		if (shopifyOrder.getCancelledDate() != null) {
			order.setStatus(ClickShipOrderStatus.Cancelled);
		} else {
			String shopifyFulfillmentStatus = shopifyOrder.getFulfillmentStatus();
			String financialStatus = shopifyOrder.getStatus();

			if (StringUtils.equalsIgnoreCase(shopifyFulfillmentStatus, "fulfilled")) {
				order.setStatus(ClickShipOrderStatus.ExternallyFulfilled);
				order.setExternallyFulfilledDate(new Date());
			} else if (StringUtils.equalsIgnoreCase(shopifyFulfillmentStatus, "partial")) {
				order.setStatus(ClickShipOrderStatus.UnFulfilled);
			} else if (StringUtils.equalsAnyIgnoreCase(financialStatus, ShopifyFinancialStatus.authorized.getValue(), ShopifyFinancialStatus.paid.getValue(),
					ShopifyFinancialStatus.partially_refunded.getValue())){
				order.setStatus(ClickShipOrderStatus.UnFulfilled);
			// These two status will not be stored in ClickShip. requested by Yonas 2019-05-19
			} else if (ShopifyFinancialStatus.voided.toString().equalsIgnoreCase(financialStatus) || 
					ShopifyFinancialStatus.refunded.toString().equalsIgnoreCase(financialStatus)) {
				order.setStatus(ClickShipOrderStatus.Cancelled);
			} else {
				order.setStatus(ClickShipOrderStatus.Pending);
			}
		}
	}
	
	public void setOrderShiptoInfo(Order order, ShopifyOrder shopifyOrder) {
		ShopifyAddress shippingAddress = shopifyOrder.getShippingAddress();
		
		if (shippingAddress != null) {
			order.setShiptoAddress1(shippingAddress.getAddress1())
				.setShiptoAddress2(shippingAddress.getAddress2())
				.setShiptoCompany(shippingAddress.getCompany())
				.setShiptoCity(shippingAddress.getCity())
				.setShiptoCountry(shippingAddress.getCountryCode())
				.setShiptoEmail(shopifyOrder.getEmail())
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
	
	public void setOrderBilltoInfo(Order order, ShopifyOrder shopifyOrder) {
		ShopifyAddress billingAddress = shopifyOrder.getBillingAddress();
		
		if (billingAddress != null) {
			order.setBilltoAddress1(billingAddress.getAddress1())
				.setBilltoAddress2(billingAddress.getAddress2())
				.setBilltoContact(billingAddress.getFullName().trim())
				.setBilltoCity(billingAddress.getCity())
				.setBilltoCountry(billingAddress.getCountryCode())
				.setBilltoEmail(shopifyOrder.getEmail())
				.setBilltoPhone(ClickshipStringUtil.removeSpecialCharsAndAreaCode(billingAddress.getPhone()))
				.setBilltoProvinceState(billingAddress.getProvinceCode())
				.setBilltoPostalcode(billingAddress.getPostalCode());
		}
	}
	
	@Transactional
	public List<Discount> getDiscountsFromShopifyOrder(ShopifyOrder shopifyOrder, Order order) {
		List<Discount> list = new ArrayList<>();
		
		if(CollectionUtils.isNotEmpty(shopifyOrder.getDiscounts())) {
			list = shopifyOrder.getDiscounts().stream().filter(d -> !"line_item".equalsIgnoreCase(d.getTargetType())).map(d -> 
				getDiscount(order, d)
			).collect(Collectors.toList());
		}
		
		return list;
	}
	
	@Transactional
	public List<Tax> getTaxesFromShopifyOrder(ShopifyOrder shopifyOrder, Order order) {
		List<Tax> list = new ArrayList<>();
		
		if(CollectionUtils.isNotEmpty(shopifyOrder.getTaxes())) {
			// Taxes applicable based on products added to cart while creating Order. Once the order created while updating it
			// line can be remove but SHOPIFY creates a refunds instead of remove line item so there is no way to remove 
			// existing tax the order. Always checks for new Tax if found add it or else update it for total tax. 
			list = shopifyOrder.getTaxes().stream().map(t -> {
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
	public List<Orderline> getLineItems(ShopifyOrder shopifyOrder, Order order) {
		List<Orderline> items = new ArrayList<>();
		
		int i=0;
		for(ShopifyOrderLineItem sl : shopifyOrder.getOrderLines()) {
			Marketplace marketplace = order.getMarketplace();
			 
			// Save OrderLine only if SHOPIFY says product exist. If SHOPIFY says product does't exist means product source is from external system. 
			if(sl.isProductExist()) {
				Orderline obj = orderlineRepository.findByExternalLineIdAndOrder(sl.getId().toString(), order);
				
				if(obj == null) {
					obj = new Orderline().setOrder(order).setExternalLineId("" + sl.getId()).setLineNumber(++i);
					setLineItemDiscount(order, shopifyOrder, obj, sl);
				}
				
				setProductInfo(marketplace, obj, sl);
				
				obj.setQuantity(sl.getCurrentQuantity()).setUnitPrice(sl.getPrice()).setLineSubtotal(sl.getSubTotal()).setSku(sl.getSku());
				
				items.add(obj);
			}
		}
		
		return items;
	}
	
	public Map<String, Object> getStoreDetailsForEmail(Marketplace marketplace) {
		Map<String, Object> content = new HashMap<>();
		
		content.put("marketplaceId", marketplace.getId());
		content.put("marketplaceUrl", marketplace.getStoreUrl());
		content.put("marketplaceName", marketplace.getAliasName());
		content.put("customerId", marketplace.getCustomer().getId());
		content.put("marketplaceType", marketplace.getMarketplaceType().getName());
		
		return content;
	}
	
	
	public void setOrderShippingInfo(Order order, ShopifyOrder shopifyOrder) {
		List<ShopifyShipping> shipping = shopifyOrder.getShipping();
		List<ShopifyFulfillment> fulfillments = shopifyOrder.getFulfillments();
		ShopifyOrderShippingCost shippingCost = shopifyOrder.getShippingCost();
		
		if(shippingCost != null && shippingCost.getCost() != null) {
			ShopifyPrice shopifyPrice = shippingCost.getCost();
			
			order.setOriginalShippingCost(shopifyPrice.getAmount()).setShippingCost(shopifyPrice.getAmount())
			 .setOriginalShippingCurrency(shopifyPrice.getCurrency()).setShippingCurrency(shopifyPrice.getCurrency());
		}
		
		// Save the externally fulfillment id to allow customers(like Guitarworks) to cancel 
		// the externally fulfill shipments from CS and fulfill it again from CS.
		if(CollectionUtils.isNotEmpty(fulfillments) && fulfillments.size() == 1) {
			// Ship date can be first fulfillment from list.  
			ShopifyFulfillment shopifyFilfillment = fulfillments.get(0);
			order.setShipDate(shopifyFilfillment.getUpdatedDate());
			
			String externalFulfilmentId = "", carrierName = "";
			
			externalFulfilmentId = fulfillments.stream().map(sf -> Long.toString(sf.getId())).collect(Collectors.joining("|"));
			carrierName = fulfillments.stream().map(ShopifyFulfillment::getTrackingCompany).collect(Collectors.joining("|"));
			
			order.setServiceType(carrierName);
			order.setExternalFulfillmentId(externalFulfilmentId);
		}
		
		if (!shipping.isEmpty()) {
			ShopifyShipping shopifyShipping = shipping.get(0);
			String serviceType = ClickshipStringUtil.truncateString(shopifyShipping.getService(), 50);
			order.setServiceType(serviceType);
			if(StringUtils.equalsIgnoreCase(shopifyShipping.getSource(), CLICKSHIP_RATES) && shopifyShipping.getCode() != null) {
				String[] carrierShippingRule = shopifyShipping.getCode().split(ClickShipConstants.RTR_CARRIER_ID_SEPERATOR);
				Carrier carrier = carrierRepository.findByServiceId(carrierShippingRule[0]);				
				if(carrier != null) {
					order.setCarrier(carrier);
					order.setServiceType(carrier.getService());
					order.setServiceTypeCode(carrierShippingRule[0]);
					order.setRtrCarrier(carrier);
					if(carrierShippingRule.length > 1 && carrierShippingRule[1] != null ) {	
						shippingRuleService.checkAndCreateRTROrderShippingRule(order,carrierShippingRule[1]);
					}
				}
			}	
		}
	}
	
	public void setAddressInfo(CustomerAddress address, ShopifyAddress shopifyAddress) {
		address.setAddressType(AddressType.SHP.toString()).setExternalId(shopifyAddress.getId()).setAddressName(shopifyAddress.getFullName())
		.setAddress1(shopifyAddress.getAddress1()).setAddress2(shopifyAddress.getAddress2()).setCity(shopifyAddress.getCity())
		.setProvinceState(shopifyAddress.getProvinceCode()).setCountry(shopifyAddress.getCountryCode()).setPostalCode(shopifyAddress.getPostalCode())						
		.setPhone(ClickshipStringUtil.removeSpecialCharsAndAreaCode(shopifyAddress.getPhone()));

		address.setUpdateDatetime(shopifyAddress.getUpdatedDate());
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
	
	private void setOrderGerneralInfo(Order order, ShopifyOrder shopifyOrder) {
		order.setNote(shopifyOrder.getNote())
			.setExternalOrderId("" + shopifyOrder.getId())
			.setOrderNumber(shopifyOrder.getName())
			.setOrderDate(shopifyOrder.getCreatedDate());
	}
	
	private void setLineItemDiscount(Order order, ShopifyOrder shopifyOrder, Orderline orderline, ShopifyOrderLineItem lineItem) {
		if(CollectionUtils.isNotEmpty(lineItem.getDiscounts())){
			for(ShopifyLineItemDiscount d : lineItem.getDiscounts()) {
				OrderlineDiscount od = orderline.getOrderlineDiscount();
				
				if(od == null) {
					ShopifyDiscount sd = shopifyOrder.getDiscounts().get(d.getDiscountIndex());
					Discount discount = getDiscount(order, sd);
					order.addDiscount(discount);
					
					od = new OrderlineDiscount(orderline, discount);	
				}
				
				od.setAmount(d.getAmount());
				orderline.setOrderlineDiscount(od);
			}
		}
	}	
	
	@Transactional
	private void setProductInfo(Marketplace marketplace, Orderline orderLine, ShopifyOrderLineItem lineItem) {
		String variantId = "" + lineItem.getVariantId();
		long externalProductId = lineItem.getProductId();
			
		MarketplaceProduct csProduct = marketplaceProductRepository.findByMarketplaceAndExternalProductIdAndVariantId(marketplace, externalProductId, variantId);

		// If SHOPIFY says product exists but CS does not have product/variant means product might not imported into CS due WEBHOOKS failure.
		// Call SHOPIFY and create variant before save the order.
		if(csProduct == null) {
			try {
				MarketplaceDTO dto = getMarketplaceDto(marketplace);
				ShopifyProduct shopifyProduct = client.importProduct(dto, "" + externalProductId);
			
				if(shopifyProduct != null) {
					// Product/variant doesn't imported. Import first before save order.
					updateProduct(marketplace, shopifyProduct);
				}
			} catch (Exception e) {
				logger.debug("Exception while importing shopify:[{}] missing product:[{}]", marketplace.getId(), "" + externalProductId);
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
	
	private Discount getDiscount(Order order, ShopifyDiscount sd) {
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